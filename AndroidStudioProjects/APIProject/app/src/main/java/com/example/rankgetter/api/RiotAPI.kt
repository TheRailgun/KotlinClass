package com.example.rankgetter.api

import androidx.appcompat.app.AppCompatActivity
import com.example.rankgetter.MainActivity
import rankgetter.BuildConfig
import retrofit2.Call
import retrofit2.http.GET



const val api_key: String = BuildConfig.API_KEY

//const val playerName = MainActivity.getPlayerName()

//const val playerName: String = "Alan Turing"
//const val sid: String = "iZuI1Od2LtDWH32OVF3TIE4KB7CHd_HQK3kK6IL5j5QoLos" //Alan Turing

//const val playerName: String = "Lives in Box"
//const val sid: String = "sOAA374zNK71rCdp5vaW5OVqolPZRhHtljyjyLFilIqHUe8" //Lives in Box

const val playerName: String = "Maraimen3222"
const val sid: String = "yNJTPziZTbQx5IFfRPcv05MWUj_VqGiCaX8b7NS9rS9l-lE" //Maraimen3222

//const val sid: String = "hqCylH22icc2yOyfl1-01IYGDzAPEPOLsEM4nn_z156Edr_W7-GOa7GUKA" // Moonie Witch


interface FlickrApi {


    @GET("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+
        playerName+
        "?api_key=" +
        api_key
    )
    fun fetchData():Call<String>

    @GET("https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/"+
            sid +
            "?api_key=" +
            api_key
    )
    fun fetchRank():Call<String>

}