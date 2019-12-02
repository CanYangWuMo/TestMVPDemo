package com.example.testmvpdemo.testbackend

import com.example.testmvpdemo.base.backend.BaseBackendService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class TestBackEndService : BaseBackendService() {
    override var baseUrl = "http://test-api.com"

    override fun setHttpDefaultClient(httpClient: OkHttpClient.Builder) {
        //连接超时时间
        httpClient.connectTimeout(10, TimeUnit.SECONDS)
        //写操作超时时间
        httpClient.writeTimeout(10, TimeUnit.SECONDS)
        //读操作超时时间
        httpClient.readTimeout(10, TimeUnit.SECONDS)
    }

    override fun setDefaultInterceptor(): Interceptor {
        return Interceptor {
            it.proceed(
                it.request().newBuilder()
                    .addHeader("platform", "android")
                    .addHeader("version", "v1.0.0")
                    .build()
            )
        }
    }

    companion object {
        val instance = TestBackEndService()
    }
}