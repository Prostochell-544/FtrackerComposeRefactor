@file:Suppress("DEPRECATION")

package com.examle.ftrackercomposerefactor.FallWorkingDirectory

import android.telephony.SmsManager
import com.examle.ftrackercomposerefactor.FallHelpDirectory.AllConstants.phoneNumbers

class SendMassage {

    //По запросу спам рассылка всем в ВаЦаПе (нет пока в смс)

        private var countContacts = 0
        fun sendSms(phoneNumber: MutableList<Double>, message: String) {

            phoneNumbers.forEach {
                val phoneNumber = phoneNumbers[this.countContacts]
                val smsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(phoneNumber.toString(), null, message, null, null)
                countContacts = countContacts+1
            }
        }

    companion object {
        private var countContacts = 0
        fun sendSms(phoneNumber: MutableList<Double>, message: String) {
            phoneNumbers.forEach {
                val phoneNumber = phoneNumbers[this.countContacts]
                val smsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(phoneNumber.toString(), null, message, null, null)
                countContacts = countContacts+1
            }
        }
        }
    }
