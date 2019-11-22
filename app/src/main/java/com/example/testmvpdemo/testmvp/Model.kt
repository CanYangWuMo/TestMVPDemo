package com.example.testmvpdemo.testmvp

import android.os.Handler

class Model {
    fun getData(status: String, callback: Contract.ModelCallBack) {
        var handler = Handler()
        handler.postDelayed(Runnable {
            when (status) {
                SUCCESS -> {
                    callback.onSuccess("Success")
                }
                FAIL -> {
                    callback.onError("Fail")
                }
                else -> {

                }
            }
        }, 2000)
    }

    companion object {
        const val SUCCESS = "SUCCESS"
        const val FAIL = "FAIL"
    }
}