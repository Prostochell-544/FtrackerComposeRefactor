@file:Suppress("DEPRECATION")

package com.examle.ftrackercomposerefactor

import android.telephony.SmsManager
import com.examle.ftrackercomposerefactor.AllConstants.phoneNumbers

class SendMassage {
    var countContacts = 0
    fun sendSms(phoneNumber: MutableList<Double>, message: String) {
        phoneNumbers.forEach {
            val phoneNumber = phoneNumbers[this.countContacts]
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber.toString(), null, message, null, null)
            countContacts = countContacts+1
        }
    }
}