package com.example.testmvpdemo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.facebook.stetho.Stetho

class TestMVPApplication : Application() {
    private var mUiThread: Thread? = null
    private val activityLifecycleCallbacks = object : ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity?) {
        }

        override fun onActivityResumed(activity: Activity?) {
        }

        override fun onActivityStarted(activity: Activity?) {
        }

        override fun onActivityDestroyed(activity: Activity?) {
        }

        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        }

        override fun onActivityStopped(activity: Activity?) {
        }

        override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        }
    }

    override fun onCreate() {
        super.onCreate()
        mUiThread = Thread.currentThread()
        Stetho.initializeWithDefaults(this)
    }

    fun getUiThread(): Thread? {
        return mUiThread
    }
}