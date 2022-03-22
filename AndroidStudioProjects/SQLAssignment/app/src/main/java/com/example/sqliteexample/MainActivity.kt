package com.example.sqliteexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.sqliteexample.DBHelper.Companion.ID_COL
import com.example.sqliteexample.DBHelper.Companion.LNAME_COL
import com.example.sqliteexample.DBHelper.Companion.NAME_COL
import com.example.sqliteexample.DBHelper.Companion.REWARDS_COL
import com.example.sqliteexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = DBHelper(this,null)

        binding.add.setOnClickListener{
            val db = DBHelper(this,null)
            var idTest = binding.idText.text.toString()
            val name = binding.nameText.text.toString()
            val lname = binding.lnameText.text.toString()
            var rewardsTest = binding.rewardsText.text.toString()
            if(!(TextUtils.isEmpty(name))&&!(TextUtils.isEmpty(lname))&&!(TextUtils.isEmpty(idTest))&&!(TextUtils.isEmpty(rewardsTest))) {
                val id = idTest.toInt()
                val rewards = rewardsTest.toInt()
                if ((id > 0) && (rewards > 0)) {
                    db.addLine(id, name, lname, rewards)
                    Toast.makeText(this, "$name added to database", Toast.LENGTH_LONG).show()

                    binding.idText.text.clear()
                    binding.nameText.text.clear()
                    binding.lnameText.text.clear()
                    binding.rewardsText.text.clear()
                    binding.idText2.text.clear()
                } else {
                    Toast.makeText(
                        this,
                        "Id and rewards both must be positive integers.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else{
                Toast.makeText(this, "Please fill in all categories.", Toast.LENGTH_LONG).show()
            }
        }

        binding.display.setOnClickListener{
            val db = DBHelper(this,null)
            val id2Test = binding.idText2.text.toString()
            if(!(TextUtils.isEmpty(id2Test))) {
                val id2 = binding.idText2.text.toString().toInt()
                if (id2 > 0) {
                    binding.output.text = db.getItem(id2.toString())
                    binding.idText.text.clear()
                    binding.nameText.text.clear()
                    binding.lnameText.text.clear()
                    binding.rewardsText.text.clear()
                    binding.idText2.text.clear()
                } else {
                    Toast.makeText(this, "Id must be a positive integer!", Toast.LENGTH_LONG).show()
                }
            } else{
                Toast.makeText(this, "UID field must be filled in to search.", Toast.LENGTH_LONG).show()
            }
        }
        binding.delete.setOnClickListener{
            val db = DBHelper(this,null)
            val id2Test = binding.idText2.text.toString()
            if(!(TextUtils.isEmpty(id2Test))) {
                val id2 = binding.idText2.text.toString().toInt()
                if (id2 > 0) {
                    binding.output.text = db.delete(id2.toString())
                    binding.idText.text.clear()
                    binding.nameText.text.clear()
                    binding.lnameText.text.clear()
                    binding.rewardsText.text.clear()
                    binding.idText2.text.clear()
                } else {
                    Toast.makeText(this, "Id must be a positive integer!", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "UID field must be filled in to search.", Toast.LENGTH_LONG).show()
            }
        }

    }
}