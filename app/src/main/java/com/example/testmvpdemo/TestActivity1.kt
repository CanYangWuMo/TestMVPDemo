package com.example.testmvpdemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.testmvpdemo.database.TestDataBase
import com.example.testmvpdemo.database.TestUserEntity
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TestActivity1 : AppCompatActivity() {
    private var compositedisipose:CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)
        GlobalScope.launch {
            val db = Room.databaseBuilder(
                this@TestActivity1,
                TestDataBase::class.java, "database-name"
            ).build()
        }
        addDispose(Observable.just("database-name")
            .subscribeOn(Schedulers.io())
            .subscribe {
            })
        var btnAdd: Button = findViewById(R.id.btn_add)
        var btnDelete: Button = findViewById(R.id.btn_delete)
        var btnShow: Button = findViewById(R.id.btn_show)
        var textShow: TextView = findViewById(R.id.text_db_data)
        var editText:EditText = findViewById(R.id.edit_text_test)
        var testEntity:TestUserEntity = TestUserEntity(1,"new data")
        btnAdd.setOnClickListener {
            var string = editText.text.toString()
            testEntity.name = string
            GlobalScope.launch {
                TestDataBase.getDatabase(this@TestActivity1).getDao().updateUserInfo(testEntity)
            }
        }
        addDispose(TestDataBase.getDatabase(this@TestActivity1).getDao().getById(1)
            .subscribeOn(Schedulers.io())
            .subscribe {
                Log.d("db", it.printData())
            })
    }

    private fun addDispose(disposable: Disposable){
        compositedisipose.add(disposable)
    }

    private fun disPose(){
        compositedisipose.dispose()
    }

    override fun onDestroy() {
        disPose()
        super.onDestroy()
    }

    companion object {
    }
}