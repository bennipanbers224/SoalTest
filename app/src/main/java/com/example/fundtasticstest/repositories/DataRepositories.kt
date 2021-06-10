//package com.example.fundtasticstest.repositories
//
//import android.app.Application
//import androidx.lifecycle.MutableLiveData
//import com.example.fundtasticstest.Models.Data
//import com.example.fundtasticstest.Models.ResponseModel
//import com.example.fundtasticstest.webservice.ApiClient
//import com.example.fundtasticstest.webservice.ApiService
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//
//
//class DataRepositories {
//    private var users: ArrayList<Data> = ArrayList()
//    private val mutableLiveData: MutableLiveData<List<Data>> = MutableLiveData<List<Data>>()
//    private var application: Application? = null
//    fun UserRepository(application: Application?) {
//        this.application = application
//    }
//
//    fun getMutableLiveData(): MutableLiveData<List<Data>>? {
//        val apiService: Retrofit = ApiClient.getInstance()
//        val call: Call<ResponseModel> = apiService
//        call.enqueue(object : Callback<ResponseModel?>() {
//            fun onResponse(call: Call<ResponseModel?>?, response: Response<ResponseModel?>) {
//                val responseModel: ResponseModel = response.body()
//                if (userWrapper != null && userWrapper.getUser() != null) {
//                    users = userWrapper.getUser()
//                    mutableLiveData.setValue(users)
//                }
//            }
//
//            fun onFailure(call: Call<UserWrapper?>?, t: Throwable) {
//                Log.d("ListSize", " - > Error    " + t.message)
//            }
//        })
//        return mutableLiveData
//    }
//}