package com.elli0tt.feature_transaction_history.presentation.adapter

import com.elli0tt.feature_transaction_history.databinding.ListItemTransactionBinding
import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.money_manager.base.viewHolder.BaseViewHolder
import com.elli0tt.money_manager.R as appR

class TransactionRecyclerViewHolder(private val binding: ListItemTransactionBinding) :
    BaseViewHolder<ListItemTransactionBinding, TransactionDomainModel>(binding) {

    override fun bind(model: TransactionDomainModel) {
        binding.apply {
            nameTextView.text = model.name
            categoryTextView.text = model.category

            bindPrice(model)
        }
    }

    private fun bindPrice(model: TransactionDomainModel) {
        binding.priceTextView.apply {
            text = model.price.toString()
            setTextColor(getColor(if (model.price > 0) (appR.color.green) else (appR.color.red)))
        }
    }
}