package com.example.rankgetter.api;

import com.google.gson.annotations.SerializedName;


data class DataResponse(

    @SerializedName("id") val id: String = "",
    @SerializedName("accountId") val accountId: String = "",
    @SerializedName("puuid") val puuid: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("summonerLevel") val summonerLevel: Int = 0
){
    override fun toString():String{
        return this.toString()
    }
}
