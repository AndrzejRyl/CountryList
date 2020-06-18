package com.ryl.countrylist.data.repository

import com.ryl.countrylist.data.local.dao.CountryDao
import com.ryl.countrylist.data.local.model.toCountry
import com.ryl.countrylist.data.local.model.toCountryEntity
import com.ryl.countrylist.data.network.CountriesAPI
import com.ryl.countrylist.data.network.model.toCountry
import com.ryl.countrylist.domain.repository.CountryRepository
import com.ryl.countrylist.domain.repository.CountryResults
import com.ryl.countrylist.domain.repository.LastListUpdateRepository
import kotlinx.coroutines.flow.first
import org.joda.time.DateTime

class CountryRepositoryImpl(
    private val countriesAPI: CountriesAPI,
    private val countryDao: CountryDao,
    private val lastListUpdateRepository: LastListUpdateRepository
) : CountryRepository {

    override suspend fun getCountries(page: Int, limit: Int): CountryResults {
        if (shouldRefreshData()) {
            return countriesAPI.getCountries()
                .run {
                    lastListUpdateRepository.updateLastUpdateTimestamp()
                    // Unfortunately it turns out this API doesn't support lazy loading
                    // That's why I have to load entire data at once
                    CountryResults(
                        countries = this.map { it.toCountry() },
                        hasPreviousCountryPage = false,
                        hasNextCountryPage = false
                    )
                }
                .also { results -> cacheCountries(results) }
        } else {
            return countryDao
                .getCountries(limit, (page - 1) * limit)
                .first()
                .run {
                    CountryResults(
                        countries = this.map { it.toCountry() },
                        hasPreviousCountryPage = false,
                        hasNextCountryPage = countryDao.getCountriesCount().first() > page * limit
                    )
                }
        }
    }

    private fun shouldRefreshData(): Boolean =
        DateTime(lastListUpdateRepository.getLastUpdateTimestamp())
            .plusDays(1)
            .isBeforeNow

    private fun cacheCountries(results: CountryResults) =
        countryDao.insertCountries(results.countries.map { it.toCountryEntity() })

}