package com.example.testmvpdemo.testmvp

class Contract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showSuccess(data: String)
        fun showFail(data: String)
    }

    interface Presenter<T : View> {
        fun attachView(view: T)
        fun detachView()
        fun getData(data:String)
    }

    interface ModelCallBack {
        fun onSuccess(data: String)
        fun onError(data: String)
    }
}