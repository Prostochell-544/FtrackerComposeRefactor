package com.examle.ftrackercomposerefactor.FallWorkingDirectory

import android.os.CountDownTimer
import com.examle.ftrackercomposerefactor.FallHelpDirectory.AllConstants

import android.content.Context
import com.examle.ftrackercomposerefactor.FallHelpDirectory.AllConstants.timerNums
import com.examle.ftrackercomposerefactor.FallWorkingDirectory.FallSiren.Companion.siren


    private lateinit var timer: CountDownTimer

    public fun startTimer(message: String) {
        timer = object : CountDownTimer( timerNums.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                //siren(Context)
            }

            override fun onFinish() {
                SendMassage.sendSms(AllConstants.phoneNumber, message)
            }
        }.start()
    }

    public fun stopTimer() {
        timer.cancel()
    }