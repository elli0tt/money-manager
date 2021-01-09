package com.elli0tt.feature_transaction_template.presentation.adapter

import com.elli0tt.feature_transaction_template.databinding.ListItemTemplateBinding
import com.elli0tt.feature_transaction_template.domain.enums.TemplateDomainType
import com.elli0tt.feature_transaction_template.domain.model.TemplateDomainModel
import com.elli0tt.money_manager.base.viewHolder.BaseViewHolder
import com.elli0tt.money_manager.R as appR

class TemplatesRecyclerViewHolder(private val binding: ListItemTemplateBinding) :
    BaseViewHolder<ListItemTemplateBinding, TemplateDomainModel>(binding) {

    override fun bind(model: TemplateDomainModel) {
        binding.apply {
            nameTextView.text = model.name
            categoryTextView.text = model.category

            bindPrice(model)
        }
    }

    private fun bindPrice(model: TemplateDomainModel) {
        binding.priceTextView.apply {
            text = model.price.toString()
            setTextColor(
                getColor(
                    when (model.templateType) {
                        TemplateDomainType.INCOME -> appR.color.green
                        TemplateDomainType.EXPENSE -> appR.color.red
                    }
                )
            )
        }
    }
}