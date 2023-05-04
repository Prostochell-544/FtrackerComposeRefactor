package com.examle.ftrackercomposerefactor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager


class SensorTrack :SensorEventListener {

    lateinit var sensorManager: SensorManager;
    private var mSensorManager: SensorManager? = null
    private var mOrientation: Sensor? = null

    private var xy_angle = 0f
    private var xz_angle = 0f
    private var zy_angle = 0f

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //Изменение точности показани
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
                xy_angle = it.values[0]
                xz_angle = it.values[1];
                zy_angle = it.values[2];
                if (xy_angle>500 || xz_angle>500 || zy_angle>500){
                    FallTimer().startTimer()
                }
            }
        }
    }
}