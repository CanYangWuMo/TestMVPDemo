package com.example.testmvpdemo.database

import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_user")
class TestUserEntity(
    @PrimaryKey @ColumnInfo(name = "id") var userId: Long,
    @ColumnInfo(name = "name") var name: String? = null
) {

    fun printData(): String {
        Log.d("Message",Thread.currentThread().name)
        return "id= $userId     name= $name"
    }
}