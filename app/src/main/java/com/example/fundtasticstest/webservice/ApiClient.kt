package com.example.fundtasticstest.webservice

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.fundtasticstest.Models.Data
import com.example.fundtasticstest.Models.ResponseModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class ApiClient {

    val liveDataResponse: MutableLiveData<List<Data>> = MutableLiveData()

    companion object{
        private val BASEURL = "https://cms-dev.fundtastic.co.id/api/v1/"
        var gson = GsonBuilder().setLenient().create()
        fun getInstance():ApiService{
            Log.e("retrofit","create")
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASEURL)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    fun loadData() : MutableLiveData<List<Data>>?{
        val retrofitCall = getInstance().getData()

        retrofitCall.enqueue(object : Callback<ResponseModel>{
            override fun onResponse(
                call: Call<ResponseModel>?,
                response: Response<ResponseModel>?
            ) {

                val responseModel:ResponseModel? = response?.body()
                if(responseModel != null){
                    try {
                        val resultList:ArrayList<Data>? = response.body().result
                        liveDataResponse.value = resultList
                    }catch (t:Exception){
                        Log.d("Error : ",t.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ResponseModel>?, t: Throwable?) {
                Log.d("Error : ",t.toString())
            }

        })

        return liveDataResponse
    }

}