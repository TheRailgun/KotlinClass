package com.example.HWweek4Contacts

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.example.readwrite.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val range = 99
    private val db = DBHelper(this,null)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Work around for not having permissions. Takes you to the permissions to be able to turn it on.
        //Not perfect but should be acceptable in the scope of this app
        //In a more refined product you would add a permission request but this seemed easier.
        if (Build.VERSION.SDK_INT >= 30) {
            if (!Environment.isExternalStorageManager()) {
                val getpermission = Intent()
                getpermission.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                startActivity(getpermission)
            }
        }


        binding.query.setOnClickListener {

            if (binding.contactInteger.text.isNotEmpty()) {
                var index = Integer.valueOf(binding.contactInteger.text.toString())
                if ((index > 0) && index <= range) {
                    loadContact(index)
                }
            }
        }
    }
    private fun loadContact(key: Int){
        val cursor = db.getName()
        cursor!!.moveToPosition(key-1)
        binding.contact.text = cursor.getString(1)
    }

    }




