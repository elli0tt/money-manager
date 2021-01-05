package com.elli0tt.money_manager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elli0tt.money_manager.databinding.ActivityNavHostBinding

class NavHostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavHostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
