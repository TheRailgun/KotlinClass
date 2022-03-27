package com.example.donutroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var taskId:Long =0L,

    @ColumnInfo(name = "task_value")
    var taskValue:Int=0, //removed task name and age and just have value

)