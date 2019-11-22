   package com.example.testmvpdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.testmvpdemo.testmvp.SimpleMVPActivity
import kotlinx.android.synthetic.main.activity_main.*

   class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_main?.setOnClickListener {
            var intent = Intent()
            intent.setClass(this,SimpleMVPActivity::class.java)
            startActivity(intent)
        }
    }
}
