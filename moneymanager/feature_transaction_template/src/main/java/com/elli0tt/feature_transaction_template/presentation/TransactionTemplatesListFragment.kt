package com.elli0tt.feature_transaction_template.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_transaction_template.R
import com.elli0tt.feature_transaction_template.databinding.FragmentTransactionTemplatesListBinding
import com.elli0tt.feature_transaction_template.presentation.adapter.TemplatesRecyclerAdapter
import com.elli0tt.feature_transaction_template.presentation.di.DaggerTransactionTemplatesListComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseFragment
import javax.inject.Inject

class TransactionTemplatesListFragment :
    BaseFragment(R.layout.fragment_transaction_templates_list) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: TransactionTemplatesListViewModel

    private val binding by viewBinding(FragmentTransactionTemplatesListBinding::bind)

    private val templatesRecyclerAdapter = TemplatesRecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        initViews()
        render(viewModel.initialState)
        subscribeToViewModel()
    }

    private fun initDagger() {
        DaggerTransactionTemplatesListComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun render(viewState: TransactionTemplatesListViewModel.ViewState) {
        templatesRecyclerAdapter.submitList(viewState.templatesList)
    }

    private fun subscribeToViewModel() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            render(it)
        }
    }

    private fun initViews() {
        initRecyclerView()
        setListeners()
    }

    private fun initRecyclerView() {
        binding.templatesRecyclerView.apply {
            adapter = templatesRecyclerAdapter
            setHasFixedSize(true)
        }
    }

    private fun setListeners() {
        binding.apply {
            toolbar.setOnMenuItemClickListener(toolbarMenuItemClickListener)
        }
    }

    private val toolbarMenuItemClickListener = Toolbar.OnMenuItemClickListener {
        when (it.itemId) {
            R.id.add_mock_templates_menu_item -> {
                viewModel.sendAction(TransactionTemplatesListViewModel.ViewAction.AddMockTemplatesList)
                true
            }
            R.id.delete_all_templates_menu_item -> {
                viewModel.sendAction(TransactionTemplatesListViewModel.ViewAction.DeleteAllTemplates)
                true
            }

            else -> false
        }
    }
}