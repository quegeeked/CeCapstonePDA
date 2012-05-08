package com.cecapstone.pda;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class MyLocationListener implements LocationListener {
    private Context mcontext;
    private MapController mcontrol;

    public MyLocationListener(Context context, MapController controller){
        mcontext = context;
        mcontrol = controller;
        
        
    }

    public void onLocationChanged(Location loc)
    {
        double lat = loc.getLatitude();
        double lon = loc.getLongitude();
        GeoPoint p = new GeoPoint(
                (int) (lat * 1E6),
                (int) (lon * 1E6));
        mcontrol.animateTo(p);
        
        
    }

    public void onProviderDisabled(String provider){
        Toast.makeText(mcontext, "GPS Disabled", Toast.LENGTH_SHORT).show();
        
    }

    public void onProviderEnabled(String provider){
        Toast.makeText(mcontext, "GPS Enabled", Toast.LENGTH_SHORT).show();
        
    }

    public void onStatusChanged(String provider, int status, Bundle extra){

        
    }

}
