package com.solano.androidar.location;

import java.util.List;

import android.location.Criteria;
import android.util.Log;
import android.os.Bundle;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;

/**
 * Created by Radsen on 8/4/13.
 */
public class LocationGps implements LocationListener {

    private static final String TAG = LocationGps.class.getSimpleName();
    private final int LOC_MIN_TIME = 300000; // Request updates every 5 minutes.
    private final int LOC_MIN_DISTANCE = 25; // Request updates every 25 meters.

    private Context context;
    private Location location;
    private String bestProvider;
    private LocationManager locationManager;

    public Location getLocation(){
        return location;
    }

    public LocationGps(Context ctx){
        context = ctx;
        locationManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_LOW);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);

        bestProvider = locationManager.getBestProvider(criteria, true);
        location = locationManager.getLastKnownLocation(bestProvider);

        if(location != null){
            Log.d(TAG, location.toString());
            this.onLocationChanged(location);
        }


    }

    public void onLocationChanged(Location location){
        Log.d(TAG, "onLocationChanged with location " + location.toString());
        String locDetails = String.format("Lat:\t %f\nLong:\t %f\nAlt:\t %f\nBearing:\t %f",
                location.getLatitude(),
                location.getLongitude(),
                location.getAltitude(),
                location.getBearing());
        this.location = location;
    }

    public void onStatusChanged(String provider, int status, Bundle extras){
        Log.d(TAG, "onStatusChanged:" + provider + ", " + status);
    }

    public void onProviderEnabled(String provider){

    }

    public void onProviderDisabled(String provider){

    }

    public void start(){
        locationManager.requestLocationUpdates(bestProvider, LOC_MIN_TIME, LOC_MIN_DISTANCE, this);
    }

    public void stop(){
        locationManager.removeUpdates(this);
    }
}
