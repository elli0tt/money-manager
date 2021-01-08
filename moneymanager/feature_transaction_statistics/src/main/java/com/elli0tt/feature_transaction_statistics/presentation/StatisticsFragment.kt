package com.elli0tt.feature_transaction_statistics.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_transaction_statistics.R
import com.elli0tt.feature_transaction_statistics.databinding.FragmentStatisticsBinding
import com.elli0tt.feature_transaction_statistics.presentation.di.DaggerStatisticsComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseFragment
import javax.inject.Inject

class StatisticsFragment : BaseFragment(R.layout.fragment_statistics) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: StatisticsViewModel

    private val binding by viewBinding(FragmentStatisticsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        initViews()
        render(viewModel.initialState)
        subscribeToViewModel()
    }

    private fun initDagger() {
        DaggerStatisticsComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun render(state: StatisticsViewModel.ViewState) {

    }

    private fun subscribeToViewModel() {

    }

    private fun initViews() {
        setListeners()
    }

    private fun setListeners() {

    }
}