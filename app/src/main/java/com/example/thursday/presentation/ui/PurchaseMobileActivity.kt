package com.example.thursday.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thursday.MyApplication
import com.example.thursday.databinding.ActivityPurchaseMobileBinding

class PurchaseMobileActivity : AppCompatActivity() {
    //    private val mobileViewModel: PurchaseMobileViewModel by lazy {
    //        ViewModelProvider(this)[PurchaseMobileViewModel::class.java]
    //    }
    private val mobileViewModel: PurchaseMobileViewModel by lazy {
        (application as MyApplication).provider.purchaseViewModelFactory
            .create(PurchaseMobileViewModel::class.java)
    }
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