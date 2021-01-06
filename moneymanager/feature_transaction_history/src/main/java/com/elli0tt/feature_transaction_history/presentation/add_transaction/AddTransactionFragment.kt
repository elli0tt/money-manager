package com.elli0tt.feature_transaction_history.presentation.add_transaction

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_transaction_history.R
import com.elli0tt.feature_transaction_history.databinding.FragmentAddTransactionBinding
import com.elli0tt.feature_transaction_history.presentation.add_transaction.di.DaggerAddTransactionComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseFragment
import javax.inject.Inject

class AddTransactionFragment : BaseFragment(R.layout.fragment_add_transaction) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AddTransactionViewModel

    private val binding by viewBinding(FragmentAddTransactionBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        subscribeToViewModel()
    }

    private fun initDagger() {
        DaggerAddTransactionComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun subscribeToViewModel() {

    }
}