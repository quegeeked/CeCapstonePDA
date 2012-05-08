package com.cecapstone.pda;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

import android.app.Activity;
import android.os.Bundle;

public class CeCapstonePDAActivity extends MapActivity {
    private MapView Mapview;
    private MyLocationOverlay mypos;
    private MapController controller;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        InitializeMap();
        InitializeMyLocation();
        
        
    }

    private void InitializeMyLocation(){
        mypos = new MyLocationOverlay(this, Mapview);
        mypos.enableMyLocation();
        Mapview.getOverlays().add(mypos);
        controller = Mapview.getController();
        mypos.runOnFirstFix(new Runnable() {
            public void run(){
                controller.setZoom(17);
                controller.animateTo(mypos.getMyLocation());
            }
        });
        
    }

    private void InitializeMap(){
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