package com.example.gumtree

import android.content.Context
import androidx.multidex.MultiDex
import com.example.gumtree.di.components.DaggerGumtreeAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class GumtreeApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerGumtreeAppComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}