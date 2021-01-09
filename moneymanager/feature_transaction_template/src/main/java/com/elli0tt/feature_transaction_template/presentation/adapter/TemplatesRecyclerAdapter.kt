package com.elli0tt.feature_transaction_template.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elli0tt.feature_transaction_template.databinding.ListItemTemplateBinding
import com.elli0tt.feature_transaction_template.domain.model.TemplateDomainModel

class TemplatesRecyclerAdapter :
    ListAdapter<TemplateDomainModel, TemplatesRecyclerViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TemplateDomainModel>() {
            override fun areItemsTheSame(
                oldItem: TemplateDomainModel,
                newItem: TemplateDomainModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TemplateDomainModel,
                newItem: TemplateDomainModel
            ): Boolean {
                return oldItem.name == newItem.name &&
                        oldItem.price == newItem.price &&
                        oldItem.category == newItem.category
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TemplatesRecyclerViewHolder {
        val binding = ListItemTemplateBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TemplatesRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TemplatesRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}