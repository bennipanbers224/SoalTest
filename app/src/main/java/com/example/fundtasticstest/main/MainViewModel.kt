package com.example.fundtasticstest.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fundtasticstest.Models.Data
import com.example.fundtasticstest.webservice.ApiClient
import com.example.fundtasticstest.webservice.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class MainViewModel:ViewModel(){
     private val mService = ApiClient()

    fun getData():MutableLiveData<List<Data>>?{
        return mService.loadData()
    }

}

