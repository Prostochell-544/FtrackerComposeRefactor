package com.examle.ftrackercomposerefactor.FallWorkingDirectory

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.examle.ftrackercomposerefactor.R
import kotlinx.coroutines.Dispatchers.Main

class TrackDelper : Service() {
    override fun onCreate() {
        LocationDetector.initiate(this)
        SensorTrack.instance(this)
        FallSiren.instance(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(): String {
        val channelId = resources.getString(R.string.app)
        val channelName = "$channelId Background Service"
        val channel = NotificationChannel(
            channelId,
            channelName, NotificationManager.IMPORTANCE_NONE
        )
        channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(channel)
        return channelId
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onStartCommand(intent: Intent, flags: Int, startID: Int): Int {
        val now = System.currentTimeMillis()
        val app = resources.getString(R.string.app)
        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel()
            } else {
                ""
            }
        val main = Intent(this, Main::class.java)
        val pending = PendingIntent.getActivity(this, 0, main, 0)
        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(android.R.drawable.stat_sys_warning)
            .setContentTitle(app)
            .setContentText("$app is active")
            .setWhen(now)
            .setContentIntent(pending).build()
        startForeground(1, notification)
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    companion object {
        internal fun initiate(context: Context) {
            val intent = Intent(context, TrackDelper::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }

        internal fun stop(context: Context) {
            val intent = Intent(context, TrackDelper::class.java)
            context.stopService(intent)
        }

        internal fun say(context: TrackDelper?, level: Int, tag: String, message: String) {
            Log.println(level, tag, message)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}