package com.example.fundtasticstest.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Data{
    @SerializedName("mfid")
    @Expose
    var mfid:String?=null
    @SerializedName("name_portofolio")
    @Expose
    var name_portofolio:String?=null
    @SerializedName("syariah")
    @Expose
    var syariah:Boolean?=null
    @SerializedName("mfTypeName")
    @Expose
    var mfTypeName:String?=null
    @SerializedName("price_buy")
    @Expose
    var price_buy:String?=null
}