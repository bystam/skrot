package com.decubate.skrot

import android.app.Application
import timber.log.Timber

class SkrotApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}