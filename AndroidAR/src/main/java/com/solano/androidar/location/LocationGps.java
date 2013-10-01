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
        bestProvider = locationManager.getBestProvider(criteria, false);
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
    }

    public void onStatusChanged(String provider, int status, Bundle extras){
        String locChanged = String.format("Provider:\t %@\nStatus:\t %d\nExtras:\t %@", provider, status, extras.toString());
        Log.d(TAG, "onStatusChanged with location " + locChanged);
    }

    public void onProviderEnabled(String provider){

    }

    public void onProviderDisabled(String provider){

    }

    public void start(){
        locationManager.requestLocationUpdates(bestProvider, 0, 0, this);
    }

    public void stop(){
        locationManager.removeUpdates(this);
    }
}
