package com.elli0tt.money_manager.base.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}