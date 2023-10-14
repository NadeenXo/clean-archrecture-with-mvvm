package com.example.thursday.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.thursday.databinding.ActivityPurchaseMobileBinding

class PurchaseMobileActivity : AppCompatActivity() {
    private val viewModel: ViewModel by lazy { ViewModelProvider(this)[ViewModel::class.java] }
    private lateinit var binding: ActivityPurchaseMobileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseMobileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.mobileBrand.observe(this) {
            binding.textView.text = viewModel.mobileBrand.toString()
            viewModel.getMobileBrand()
        }


    }
}