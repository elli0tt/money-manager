package com.elli0tt.money_manager.base.fragment

import androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment
import com.elli0tt.money_manager.R

class CustomProgressFragment : AbstractProgressFragment(R.layout.fragment_custom_progress) {

    override fun onCancelled() {
        TODO("Not yet implemented")
    }

    override fun onFailed(errorCode: Int) {
        TODO("Not yet implemented")
    }

    override fun onProgress(status: Int, bytesDownloaded: Long, bytesTotal: Long) {
        TODO("Not yet implemented")
    }
}