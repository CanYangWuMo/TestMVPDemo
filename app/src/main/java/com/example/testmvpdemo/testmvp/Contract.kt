package com.example.testmvpdemo.testmvp

class Contract {
    interface View {
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter<T : View> {
        fun attachView(view:T)
        fun detachView()
    }

    interface ModelCallBack {
        fun onSuccess()
        fun onError()
    }
}