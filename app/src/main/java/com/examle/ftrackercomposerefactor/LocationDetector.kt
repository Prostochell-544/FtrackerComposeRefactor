package com.examle.ftrackercomposerefactor

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat

class LocationDetector : LocationListener {
    //private lateinit var locationManager: LocationManager
    //private lateinit var tvGpsLocation: TextView
    //private val locationPermissionCode = 2
    override fun onLocationChanged(location: Location) {
        TODO("Not yet implemented")
    }
    fun getLocation(context: Context): Location? {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var location: Location? = null

        // Проверяем, есть ли разрешение на использование GPS
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // Получаем последнюю известную GPS локацию
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

            // Если локация не найдена, пытаемся запросить обновление координат
            if (location == null) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, object : LocationListener {
                    override fun onLocationChanged(newLocation: Location) {
                        location = newLocation
                        locationManager.removeUpdates(this)
                    }

                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
                    override fun onProviderEnabled(provider: String?) {}
                    override fun onProviderDisabled(provider: String?) {}
                })
            }
        }

        return location
    }

}
