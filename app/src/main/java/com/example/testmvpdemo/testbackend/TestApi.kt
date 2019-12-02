package com.example.testmvpdemo.testbackend

import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import retrofit2.http.GET

interface TestApi {
    @GET("/getAd")
    fun getAd(): Observable<AdData>
}

data class AdData(
    @SerializedName("name") var name: String = "",
    @SerializedName("id") var id: Int = 0
 )