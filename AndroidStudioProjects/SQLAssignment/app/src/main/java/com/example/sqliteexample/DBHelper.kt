package com.example.sqliteexample

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context,factory:SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context,DATABASE_NAME,factory,DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " (" +
                ID_COL + " INTEGER PRIMARY KEY, " + NAME_COL +
                " TEXT," + LNAME_COL + " TEXT," + REWARDS_COL + " TEXT" + ")")

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addLine(id: Int, name: String, lname: String, rewards: Int) {
        val values = ContentValues()
        values.put(ID_COL, id)
        values.put(NAME_COL, name)
        values.put(LNAME_COL, lname)
        values.put(REWARDS_COL, rewards)


        val db = this.writableDatabase

        val mCursor: Cursor? = db.rawQuery(
            "SELECT * FROM $TABLE_NAME WHERE $ID_COL=$id",
            null
        )
        mCursor!!.moveToFirst()
        if (mCursor.count > 0) {
            db.update(TABLE_NAME, values, "$ID_COL=$id", arrayOf())
        } else {
            db.insert(TABLE_NAME, null, values)
        }
        mCursor.close()
        db.close()
    }

    @SuppressLint("Range")
    fun getItem(id: String): String {
        val db = this.readableDatabase
        val cursor: Cursor? = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $ID_COL = $id", null)
        var result = "No entry found."

        if (cursor!!.count > 0) {
            cursor.moveToFirst()
            result =
                (cursor.getString(cursor.getColumnIndex(ID_COL)) + " | " + cursor.getString(
                    cursor.getColumnIndex(NAME_COL)
                ) + " | " + cursor.getString(cursor.getColumnIndex(LNAME_COL)) + " | " + cursor.getString(
                    cursor.getColumnIndex(REWARDS_COL)
                ))
            cursor.close()
        }
        return result
    }

    fun delete(id: String):String {
        val db = this.readableDatabase
        val cursor: Cursor? = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $ID_COL = $id", null)
        if (cursor!!.count > 0) {
            db.delete(TABLE_NAME, "$ID_COL=$id", arrayOf())
            return "Deleted UID $id from table."
        } else{
            return "UID $id does not exist in table."
        }
    }


   /* fun checkItem(id:Int): Boolean{
        val db = this.readableDatabase
        val mCursor: Cursor = db.rawQuery(
            "SELECT * FROM $TABLE_NAME WHERE $ID_COL=$id",
            null)
        mCursor.moveToFirst()
        if(mCursor.getInt(0)==1) {
            mCursor.close()
            return true
        } else{
            return false
            }
    }*/

    companion object{

        private val DATABASE_NAME = "ANDROIDKTCLASS"

        private val DATABASE_VERSION = 2

        val TABLE_NAME = "SimpleTable"

        val ID_COL = "id"

        val NAME_COL = "name"

        val LNAME_COL = "lname"

        val REWARDS_COL = "rewards"

    }

}