package com.example.rankgetter

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.rankgetter.api.FlickrApi
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import rankgetter.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fetchButton = findViewById<Button>(R.id.button)


        fetchButton.setOnClickListener{
            Log.e(ContentValues.TAG,"Button Pressed")
            onFetch()
        }
    }
    fun getPlayerName():String{
        val pName: String = findViewById<EditText>(R.id.editTextName).toString()
        return pName
    }

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://na1.api.riotgames.com")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    fun onFetch(){
        Log.e(ContentValues.TAG,"On Fetch Called")
        val flickrApi: FlickrApi = retrofit.create(FlickrApi::class.java)
        val flickrHomePageRequest: Call<String> = flickrApi.fetchData()
        flickrHomePageRequest.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(ContentValues.TAG, "Failed to fetch data", t)
            }

            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                Log.d(ContentValues.TAG, "Response received data: ${response.body()}")

                if (response.body() != "[]") {

                    var interpreted = response.body().toString().replace("}", "")
                    interpreted = interpreted.replace("{", "")
                    interpreted = interpreted.replace("\"", "")

                    val map = interpreted
                        .splitToSequence(",")
                        .map { it.split(":") }
                        .map { it[0] to it[1] }
                        .toMap()
                    Log.e(ContentValues.TAG, "Name: ${map["name"]}")

                    if(map["id"]!= null){
                        Log.e(ContentValues.TAG, "fetching rank")
                        var sid = map["id"]
                        fetchRankMain(sid)
                    } else{
                        val outputText = findViewById<TextView>(R.id.textView2)
                        outputText.text = "Player does not exist"
                    }

                }
            }
        })
    }
    fun fetchRankMain(sid:String?){
        val flickrApi: FlickrApi = retrofit.create(FlickrApi::class.java)
        val riotRankRequest: Call<String> = flickrApi.fetchRank()
        riotRankRequest.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(ContentValues.TAG, "Failed to fetch rank", t)
            }
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                Log.d(ContentValues.TAG, "Response received rank: ${response.body()}")

                if(response.body()!="[]") {

                    var interpreted = response.body().toString().replace("}", "")
                    interpreted = interpreted.replace("{", "")
                    interpreted = interpreted.replace("\"", "")

                    val map = interpreted
                        .splitToSequence(",")
                        .map { it.split(":") }
                        .map { it[0] to it[1] }
                        .toMap()
                    Log.d(ContentValues.TAG, "Rank: ${map["tier"]} ${map["rank"]}")
                    val outputText = findViewById<TextView>(R.id.textView2)
                    outputText.text = "${map["tier"]} ${map["rank"]}"
                 } else {
                    val outputText = findViewById<TextView>(R.id.textView2)
                    outputText.text = "Player is not ranked"
                }
            }


        })
    }
}
/*fun onFetch(){
       Log.e(ContentValues.TAG,"On Fetch Called")
       val flickrApi: FlickrApi = retrofit.create(FlickrApi::class.java)
       val flickrHomePageRequest: Call<DataResponse> = flickrApi.fetchData()
       flickrHomePageRequest.enqueue(object : Callback<DataResponse> {
           override fun onFailure(call: Call<DataResponse>, t: Throwable) {
               Log.e(ContentValues.TAG, "Failed to fetch photos", t)
           }
           override fun onResponse(
               call: Call<DataResponse>,
               response: Response<DataResponse>
           ) {
               Log.d(ContentValues.TAG, "Response receivedPGF: ${response.body()}")


           }
       })
   }*/