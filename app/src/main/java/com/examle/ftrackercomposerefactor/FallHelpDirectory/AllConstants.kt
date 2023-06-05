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
    //android.permission.ACCESS_COARSE_LOCATION
    //android.permission.ACCESS_FINE_LOCATION
    //android.permission.MODIFY_AUDIO_SETTINGS
    //android.permission.READ_CONTACTS
    //android.permission.READ_PHONE_STATE
    //android.permission.RECEIVE_BOOT_COMPLETED
    //android.permission.RECEIVE_SMS
    //android.permission.SEND_SMS
    //android.permission.FOREGROUND_SERVICE
    //android.permission.BODY_SENSORS
    //android.permission.WAKE_LOCK

    //COARSE_PERMISSION_CODE
    //FINE_PERMISSION_CODE
    //AUDIO_PERMISSION_CODE
    //CONTACTS_PERMISSION_CODE
    //PHONE_PERMISSION_CODE
    //BOOT_PERMISSION_CODE
    //RECEIVE_PERMISSION_CODE
    //SEND_PERMISSION_CODE
    //FOREGROUND_PERMISSION_CODE
    //SENSORS_PERMISSION_CODE
    //WAKE_PERMISSION_CODE
    internal fun level(context: Context): Int {
        val applicationContext: Context = context.applicationContext
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val intent = applicationContext.registerReceiver(null, filter) ?: return -1
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1)
        return (level * 100.0 / scale).toInt()
    }
}