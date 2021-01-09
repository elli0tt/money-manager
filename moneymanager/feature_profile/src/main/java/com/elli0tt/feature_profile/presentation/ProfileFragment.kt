package com.elli0tt.feature_profile.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_profile.R
import com.elli0tt.feature_profile.databinding.FragmentProfileBinding
import com.elli0tt.feature_profile.presentation.di.DaggerProfileComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseFragment
import javax.inject.Inject

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ProfileViewModel

    private val binding by viewBinding(FragmentProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        initViews()
        render(viewModel.initialState)
        subscribeToViewModel()
    }

    private fun initDagger() {
        DaggerProfileComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun initViews() {
        setListeners()
    }

    private fun setListeners() {

    }

    private fun render(viewState: ProfileViewModel.ViewState) {

    }

    private fun subscribeToViewModel() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            render(it)
        }
    }
}