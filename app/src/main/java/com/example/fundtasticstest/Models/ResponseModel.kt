package com.example.fundtasticstest.Models

import com.google.gson.annotations.SerializedName

class ResponseModel {
    @SerializedName("data")
    private var mResult : ArrayList<Data>?=null
    var result:ArrayList<Data>?
        get() = mResult
        set(result){
        mResult = result
    }
}