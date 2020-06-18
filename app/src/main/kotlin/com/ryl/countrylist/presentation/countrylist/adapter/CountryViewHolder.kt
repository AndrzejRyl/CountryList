package com.ryl.countrylist.presentation.countrylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ryl.countrylist.R
import com.ryl.countrylist.domain.model.Country
import com.ryl.countrylist.presentation.countrylist.adapter.base.BasePagedViewHolder
import kotlinx.android.synthetic.main.item_country.view.*

class CountryViewHolder(
    parent: ViewGroup,
    layoutInflater: LayoutInflater
) : BasePagedViewHolder<Country>(R.layout.item_country, parent, layoutInflater) {

    override fun bind(item: Country?) {
        with(itemView) {
            item?.let {
                countryItemName.text = item.name
                countryItemCurrencyValue.text = item.currency
                countryItemPhoneNumberValue.text = item.phoneNumber
                countryItemInternetDomainValue.text = item.internetDomainName
            }
        }
    }
}