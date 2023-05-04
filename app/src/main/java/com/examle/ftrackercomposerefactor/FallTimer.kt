package com.examle.ftrackercomposerefactor

import android.os.CountDownTimer

import com.examle.ftrackercomposerefactor.AllConstants.messageText
import com.examle.ftrackercomposerefactor.AllConstants.phoneNumbers
import com.examle.ftrackercomposerefactor.AllConstants.timerNums

class FallTimer {
    private lateinit var timer: CountDownTimer

    fun startTimer() {
        timer = object : CountDownTimer( timerNums.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Код, который будет выполняться каждую секунду
            }

            override fun onFinish() {
                // Код, который будет выполняться по завершению таймера
                SendMassage().sendSms(phoneNumbers,messageText)
            }
        }.start()
    }

    fun stopTimer() {
        timer.cancel()
    }
}