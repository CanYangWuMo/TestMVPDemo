package com.example.testmvpdemo.database

import androidx.room.*
import io.reactivex.Flowable

@Dao
interface ITestUserDao {
    //采用suspend关键字使用kotlin协程使得数据库的操作方法不在主线程进行
    @Query("select * from test_user")
    fun getAll(): List<TestUserEntity>

    @Query("select * from test_user where id = (:userId)")
    fun getById(userId: Long): Flowable<TestUserEntity>

    @Update
    suspend fun updateUserInfo(vararg userEntity: TestUserEntity)

    @Insert
    fun insertUser(vararg userEntity: TestUserEntity)

    @Delete
    fun deleteUser(vararg userEntity: TestUserEntity)

    @Query("delete from test_user where id = (:userId)")
    fun deleteById(userId: Long)

}