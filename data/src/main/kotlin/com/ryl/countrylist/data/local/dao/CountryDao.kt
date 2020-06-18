package com.ryl.countrylist.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ryl.countrylist.data.local.model.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Query("SELECT * FROM countries LIMIT :limit OFFSET :offset")
    fun getCountries(limit: Int, offset: Int): Flow<List<CountryEntity>>

    @Query("SELECT COUNT(*) FROM countries")
    fun getCountriesCount(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(countries: List<CountryEntity>)
}