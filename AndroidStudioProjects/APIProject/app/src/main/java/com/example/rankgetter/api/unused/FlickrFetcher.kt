package com.example.rankgetter.api.unused
import com.example.rankgetter.api.FlickrApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "FlickrFetcher"
class FlickrFetcher {
    private val flickrApi: FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())//ScalarsConverterFactory.create())
            .build()
        flickrApi = retrofit.create(FlickrApi::class.java)
    }
}
    //  fun fetchContents(): LiveData<String> {
  /*  fun fetchPhotos():LiveData<String> {
        //  val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        // val flickrRequest: Call<String> = flickrApi.fetchPhotos()//replace fetchContents() here
        val flickrRequest: Call<String> = flickrApi.fetchData()
        flickrRequest.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                Log.d(TAG, "Response receivedFF")
                responseLiveData.value = response.message()
            }
        })
        return responseLiveData
    }
}*/