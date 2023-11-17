package com.example.thursday.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thursday.databinding.ActivityPurchaseMobileBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels


@AndroidEntryPoint
class PurchaseMobileActivity : AppCompatActivity() {

    private val mobileViewModel: PurchaseMobileViewModel by viewModels()
    private lateinit var binding: ActivityPurchaseMobileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseMobileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mobileViewModel.mobileBrand.observe(this) {
            binding.textView.text = mobileViewModel.getMobileBrand().toString()
        }
    }
}