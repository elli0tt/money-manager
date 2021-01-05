package com.elli0tt.feature_transaction_history.presentation.transaction_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.elli0tt.money_manager.R as appR
import com.elli0tt.feature_transaction_history.databinding.FragmentTransactionListBinding
import com.elli0tt.feature_transaction_history.presentation.transaction_list.di.DaggerTransactionListComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.fragment.BaseFragment
import javax.inject.Inject

class TransactionListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: TransactionListViewModel

    private var _binding: FragmentTransactionListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        subscribeToViewModel()
        initViews()
    }

    private fun initDagger() {
        DaggerTransactionListComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun subscribeToViewModel() {
        viewModel.text.observe(viewLifecycleOwner) {
            binding.text.text = it
        }
    }

    private fun initViews() {
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            button.setOnClickListener {
                findNavController().navigate(appR.id.action_transactionListScreen_to_addTransactionScreen)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}