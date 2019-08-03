package com.example.testmvpdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.testmvpdemo.singleType.ListTestActivity

class MainActivity : AppCompatActivity() {
    private var textHelloWorld: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textHelloWorld = findViewById(R.id.text_hello_world)
        textHelloWorld?.setOnClickListener {
            startActivity(ListTestActivity.getIntent(this))
        }
    }
}
