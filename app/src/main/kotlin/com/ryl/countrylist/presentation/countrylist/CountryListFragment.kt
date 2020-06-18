package com.ryl.countrylist.presentation.countrylist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.ryl.countrylist.R
import com.ryl.countrylist.presentation.countrylist.adapter.CountryListAdapter
import com.ryl.countrylist.presentation.countrylist.viewmodel.CountryListViewModel
import kotlinx.android.synthetic.main.fragment_country_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryListFragment : Fragment(R.layout.fragment_country_list) {

    private val viewModel by viewModel<CountryListViewModel>()
    private val countryListAdapter by lazy { CountryListAdapter(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        setupObserver()
    }

    private fun setupViews() {
        countrListRecycler.adapter = countryListAdapter
        countryListAdapter.onRetryClickedListener = { viewModel.refreshFailedRequest() }
    }

    private fun setupObserver() = with(viewModel) {
        countryListNetworkState?.observe(viewLifecycleOwner) {
            countryListAdapter.updateNetworkState(it)
        }
        countries.observe(viewLifecycleOwner) { countryListAdapter.submitList(it) }
    }
}