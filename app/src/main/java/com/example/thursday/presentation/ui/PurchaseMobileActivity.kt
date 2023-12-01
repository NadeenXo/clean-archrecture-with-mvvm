package com.example.thursday.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thursday.databinding.ActivityPurchaseMobileBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.thursday.util.ScreenState
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PurchaseMobileActivity : AppCompatActivity() {

    private val mobileViewModel: PurchaseMobileViewModel by viewModels()
    private lateinit var binding: ActivityPurchaseMobileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseMobileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mobileViewModel.mobileBrand.observe(this) { mobileBrand ->
            binding.textView.text = mobileBrand.toString()
        }
        lifecycleScope.launch {
            mobileViewModel.brandName.collect { brandName ->
                binding.textView.text = brandName
            }
        }
        mobileViewModel.getMobileBrand()
        mobileViewModel.getBrandName()

        lifecycleScope.launchWhenStarted {
            mobileViewModel.screenState.collect { state ->
                handleScreenState(state)
            }
        }
    }

    private fun handleScreenState(state: ScreenState) {
        when (state) {
            is ScreenState.Success -> {
                binding.textView.text = state.data
            }

            is ScreenState.NetworkError -> {
                binding.textView.text = "Network Error: ${state.message}"
                //navigate to error page
            }

            is ScreenState.NotFoundError -> {
                binding.textView.text = "Not Found Error: ${state.message}"
                //navigate to not found page
            }
        }
    }
}