package com.example.gardendemo

import android.app.Application
import android.content.Context
import com.example.gardendemo.moduls.gModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    private var mContext: Context? = null

    companion object {

        lateinit var instance: MainApplication

        fun applicationContext() : Context {
            return instance.mContext!!
        }
    }


    override fun onCreate() {
        super.onCreate()

        instance = this
        mContext = this

        startKoin {
            androidContext(this@MainApplication)

            modules(gModule)
        }
    }
}