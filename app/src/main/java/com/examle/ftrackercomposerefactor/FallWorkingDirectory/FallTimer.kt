package com.examle.ftrackercomposerefactor.FallWorkingDirectory

import android.os.CountDownTimer

import android.content.Context
import com.examle.ftrackercomposerefactor.FallHelpDirectory.AllConstants.phoneNumber
import com.examle.ftrackercomposerefactor.FallHelpDirectory.AllConstants.timerNums
import com.examle.ftrackercomposerefactor.FallWorkingDirectory.FallSiren.Companion.siren
import com.examle.ftrackercomposerefactor.ui.elements.MainPage

public class FallTimer(private var timer: CountDownTimer, private val context: Context) {
    val mainPage = MainPage()
    val sendMessage = SendMessage()
    public fun startTimer(message: String) {
        timer = object : CountDownTimer(timerNums.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                siren(context)
            }

            override fun onFinish() {
                sendMessage.sendSms(phoneNumber, message)
            }
        }.start()
    }

    public fun stopTimer() {
        timer.cancel()
    }
}