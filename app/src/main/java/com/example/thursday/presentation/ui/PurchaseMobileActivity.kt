package com.example.thursday.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thursday.databinding.ActivityPurchaseMobileBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import com.example.thursday.data.dataSource.remote.ApiService
import com.example.thursday.data.dataSource.remote.ApiService2
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject


@AndroidEntryPoint
class PurchaseMobileActivity : AppCompatActivity() {

    private val mobileViewModel: PurchaseMobileViewModel by viewModels()
    @Inject lateinit var myApiService: ApiService
    @Inject lateinit var apiService2: ApiService2
//    @Inject lateinit var retrofit: Retrofit
    private lateinit var binding: ActivityPurchaseMobileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseMobileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mobileViewModel.mobileBrand.observe(this) {
            binding.textView.text = mobileViewModel.getMobileBrand().toString()
        }
//        retrofit.create(myApiService)
    }
}