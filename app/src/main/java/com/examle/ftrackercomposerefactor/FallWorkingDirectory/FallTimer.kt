package com.examle.ftrackercomposerefactor.FallWorkingDirectory

import android.os.CountDownTimer


import com.examle.ftrackercomposerefactor.FallHelpDirectory.AllConstants.phoneNumbers
import com.examle.ftrackercomposerefactor.FallHelpDirectory.AllConstants.timerNums

class FallTimer {
    private lateinit var timer: CountDownTimer

    fun startTimer() {
        timer = object : CountDownTimer( timerNums.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Код, который будет выполняться каждую секунду
            }

            override fun onFinish() {
                // Код, который будет выполняться по завершению таймера
            }
        }.start()
    }

    fun stopTimer() {
        timer.cancel()
    }
}