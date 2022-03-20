package com.example.HWweek4Contacts

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
import android.util.Log
import android.util.Log.INFO
import java.io.File
import java.io.FileReader
import java.io.InputStream
import java.util.*
import java.util.logging.Level.INFO

private val DATABASE_NAME = "contactDB"

private val DATABASE_VERSION = 1

private val file = "/storage/emulated/0/Download/100-contacts.csv"
class DBHelper(context:Context,factory:SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME,factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE contacts (" +
                "id INTEGER PRIMARY KEY, " +
                "data TEXT" +
                ")"
                )
        db.execSQL(query)
        val values = ContentValues()
        val file1 = File(file)
        val scanner = Scanner(file1)
        scanner.nextLine()
        while(scanner.hasNextLine()){
           Log.println(Log.INFO,null,"ScannerLopping")
            values.put("data",scanner.nextLine().toString())
            db.insert("contacts",null,values)
            values.clear()
        }
        //db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + "contacts")
        onCreate(db)
    }
    fun getName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + "contacts",null)
    }
}