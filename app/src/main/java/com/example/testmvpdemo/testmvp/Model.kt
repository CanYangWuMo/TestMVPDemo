package com.example.testmvpdemo.testmvp

import android.os.Handler

class Model {
    fun getData(data:String,callback:Contract.ModelCallBack){
        var handler = Handler()
        handler.postDelayed(Runnable {

        },2000)
    }
}