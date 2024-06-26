package com.sd.todolistapp.database

import android.annotation.SuppressLint
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date


@Entity("todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo("title")
    val title:String,
    @ColumnInfo("sub_title")
    val subTitle:String,
    @ColumnInfo("done")
    val done:Boolean = false,
    @ColumnInfo("added")
    val added:Long = System.currentTimeMillis()
)

val TodoEntity.addDate:String @SuppressLint("SimpleDateFormat")
get() = SimpleDateFormat("yyyy/MM/dd hh:mm").format(Date(added))

