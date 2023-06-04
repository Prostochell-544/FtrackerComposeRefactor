package com.examle.ftrackercomposerefactor.FallHelpDirectory

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import com.examle.ftrackercomposerefactor.ui.elements.MainPage

val mainPage = MainPage()

object AllConstants {
    var phoneNumber = mainPage.phoneNumberSetter
    val timerNums = 15000

    internal fun level(context: Context): Int {
        val applicationContext: Context = context.applicationContext
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val intent = applicationContext.registerReceiver(null, filter) ?: return -1
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1)
        return (level * 100.0 / scale).toInt()
    }
}