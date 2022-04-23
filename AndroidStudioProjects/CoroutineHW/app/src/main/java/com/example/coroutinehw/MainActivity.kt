package com.example.coroutinehw

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnTouchListener
import android.webkit.URLUtil
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutinehw.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL


private lateinit var binding: ActivityMainBinding
private var i = 0
class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view: View
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        binding.textView.setOnTouchListener(OnTouchListener { v, event ->
            newImage()
            true
        })

        setContentView(view)
        setImage(i)
        setDesc(i)
    }

     fun newImage(){
        if(i<9){
            i++
        } else{
            i=0
        }
         setImage(i)
         setDesc(i)
    }

    fun setDesc(i:Int){
        val imagefetch = ImageFetcher()
        var descString = imagefetch.getText(i)
        binding.textView.text = descString
    }
    fun setImage(i:Int){//Somewhere here I should be cancelling currently running Coroutines. However as of now I cannot figure out how this should work.
        GlobalScope.launch(Dispatchers.IO) {
            val imagefetch = ImageFetcher()
            var imageUrlString = imagefetch.getImage(i)
            if(URLUtil.isValidUrl(imageUrlString)) {
                val imageUrl = URL(imageUrlString)
                val httpConnection = imageUrl.openConnection() as HttpURLConnection
                httpConnection.doInput = true
                httpConnection.connect()
                val inputStream = httpConnection.inputStream
                val bitmapImage = BitmapFactory.decodeStream(inputStream)
                launch(Dispatchers.Main) {
                    Log.d("CoroutineExample", "Name of thread is ${Thread.currentThread().name}")
                    binding.imageView.setImageBitmap(bitmapImage)
                }
            } else {
                binding.textView.text = "Sorry, this URL is broken."
                Log.d(TAG,"String is not valid URL")
            }
        }
    }
}