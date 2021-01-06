package com.elli0tt.feature_transaction_history.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elli0tt.feature_transaction_history.databinding.ListItemTransactionBinding
import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel

class TransactionRecyclerAdapter :
    ListAdapter<TransactionDomainModel, TransactionRecyclerViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TransactionDomainModel>() {
            override fun areItemsTheSame(
                oldItem: TransactionDomainModel,
                newItem: TransactionDomainModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TransactionDomainModel,
                newItem: TransactionDomainModel
            ): Boolean {
                return oldItem.name == newItem.name &&
                        oldItem.price == newItem.price &&
                        oldItem.date == newItem.date &&
                        oldItem.category == newItem.category
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionRecyclerViewHolder {
        val binding = ListItemTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransactionRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}