package com.example.testmvpdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.testmvpdemo.testactionmvp.ActionMVPActivity
import com.example.testmvpdemo.testactionmvp.fragment.ActionMVPFragment
import com.example.testmvpdemo.testbackend.TestApi
import com.example.testmvpdemo.testbackend.TestBackEndService
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_main?.setOnClickListener {
            var intent = Intent()
            intent.setClass(this, TestActivity1::class.java)
            startActivity(intent)
        }
    }

    /**
     * 接口测试
     */
    @SuppressLint("CheckResult")
    private fun testBackendService() {
        var testApi: TestApi = TestBackEndService.instance.createService(TestApi::class.java)
        testApi.getAd()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                Log.d("Ad", it.toString())
            }, {
                Log.d("Ad", it.message)
            })
    }

    private fun addActionMVPFragment() {
        if (supportFragmentManager.findFragmentByTag("TestMVP") == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.content, ActionMVPFragment.instance, "TestMVP")
                .commit()
        }
    }

    private fun startActionMVPActivity() {
        var intent = Intent()
        intent.setClass(this, ActionMVPActivity::class.java)
        startActivity(intent)
    }
}
