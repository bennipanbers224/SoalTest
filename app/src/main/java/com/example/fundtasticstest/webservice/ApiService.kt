package com.example.fundtasticstest.webservice

import com.example.fundtasticstest.Models.Data
import com.example.fundtasticstest.Models.ResponseModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("reksadana-saham")
    fun getData() : Call<ResponseModel>
}