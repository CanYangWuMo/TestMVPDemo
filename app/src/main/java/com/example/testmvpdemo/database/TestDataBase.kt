package com.example.testmvpdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [TestUserEntity::class], version = 1, exportSchema = false)
abstract class TestDataBase : RoomDatabase() {


    //获取DAO数据库操作
    abstract fun getDao(): ITestUserDao

    //单例模式
    companion object {
        private const val DB_NAME = "test_user_database"

        @Volatile
        private var INSTANCE: TestDataBase? = null

        fun getDatabase(context: Context): TestDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TestDataBase::class.java, DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }

        //升级语句
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE user ADD COLUMN age INTEGER NOT NULL DEFAULT 0")
            }
        }
    }
}