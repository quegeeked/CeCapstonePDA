package com.cecapstone.pda;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

import android.app.Activity;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import android.widget.Button;

public class CeCapstonePDAActivity extends MapActivity {
    private MapView Mapview;
    private MyLocationOverlay mypos;
    private MapController controller;
    private String LogCatTag = "Que's";
    private MyLocationListener mlocListener;
    private Button camera;
    private Button depth;
    private Button mapView2;
    JoystickView mJoystickView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        InitializeMap();
        InitializeMyLocation();
        IntializeLocationManager();
        Log.i(LogCatTag, "In onCreate");
        camera = (Button) findViewById(R.id.Camera);
        depth = (Button) findViewById(R.id.Depth);
      
    }


    public void onStart()
    {
        super.onStart();
    }

    public void onRestart()
    {
        super.onRestart();
    }

    public void onResume()
    {
        super.onResume();
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onStop()
    {
        super.onStop();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    private void IntializeLocationManager()
    {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener(this, controller);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
                mlocListener);

    }

    private void InitializeMyLocation()
    {
        mypos = new MyLocationOverlay(this, Mapview);
        mypos.enableMyLocation();
        Mapview.getOverlays().add(mypos);
        controller = Mapview.getController();
        mypos.runOnFirstFix(new Runnable() {
            public void run()
            {
                controller.setZoom(17);
                controller.animateTo(mypos.getMyLocation());
            }
        });

    }

    private void InitializeMap()
    {
        Mapview = (MapView) findViewById(R.id.mapview);
        Mapview.setBuiltInZoomControls(true);
        Mapview.setSatellite(true);
        Mapview.setSaveEnabled(true);

    }

    @Override
    protected boolean isRouteDisplayed()
    {

        return false;
    }
}