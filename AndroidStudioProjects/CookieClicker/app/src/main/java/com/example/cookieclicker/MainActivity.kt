package com.example.cookieclicker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private var currentScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgClip: ImageView = findViewById(R.id.paperclip)
        val lblTotal: TextView = findViewById(R.id.lblTotal)

        imgClip.setOnClickListener{
            currentScore ++
            lblTotal.text = "$currentScore"
            Log.e("Click","score = $currentScore")
        }
    }
    @SuppressLint("SetTextI18n")
    fun saveScore(view: View){
        val lblTotal: TextView = findViewById(R.id.lblTotal)
        val lastScore: TextView = findViewById(R.id.lastScore)
        val nameE: EditText = findViewById(R.id.playerName)
        val name = nameE.text.toString()


        if(name.isNotEmpty()) {
            lastScore.text = "$name: $currentScore"
            currentScore = 0
            lblTotal.text = "$currentScore"
            nameE.text.clear()
        } else {
            nameE.setError("Name Required.")
            Toast.makeText(this, "Error Msg", Toast.LENGTH_SHORT).show()
            Log.e("Error","no name")
        }
    }
}