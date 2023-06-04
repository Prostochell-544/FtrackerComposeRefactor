@file:Suppress("DEPRECATION")

package com.examle.ftrackercomposerefactor.FallWorkingDirectory

import android.telephony.SmsManager

class SendMassage {

    //По запросу спам рассылка всем в ВаЦаПе (нет пока в смс)

    fun sendSms(phoneNumber: String?, message: String) {
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(phoneNumber.toString(), null, message, null, null)
    }

    companion object {
        fun sendSms(phoneNumber: String?, message: String) {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber.toString(), null, message, null, null)
        }
    }
}

