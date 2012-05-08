package com.cecapstone.pda;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class CeCapstonePDAOverlay extends ItemizedOverlay {

    private ArrayList<OverlayItem> moverlays = new ArrayList<OverlayItem>();
    private Context mcontext;
    
    
    
    
    public CeCapstonePDAOverlay(Drawable defaultMarker, Context context){
        super(boundCenterBottom(defaultMarker));
        mcontext = context;
        
    }

    @Override
    protected OverlayItem createItem(int mark)
    {
        
        return moverlays.get(mark);
    }

    @Override
    public int size()
    {
        // TODO Auto-generated method stub
        return moverlays.size();
        
    }
    public void addOverlay(OverlayItem overlay) {
        moverlays.add(overlay);
        populate();
    }
    
    @Override
    protected boolean onTap(int index){
        
        OverlayItem item = moverlays.get(index);
        AlertDialog.Builder dialog = new AlertDialog.Builder(mcontext);
        dialog.setTitle(item.getTitle());
        dialog.setMessage(item.getSnippet());
        dialog.show();
        return true;
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event, MapView mapView) 
    {   
        //---when user lifts his finger---
        if (event.getAction() == 1) {                
            GeoPoint p = mapView.getProjection().fromPixels(
                (int) event.getX(),
                (int) event.getY());
                Toast.makeText(mcontext, 
                    p.getLatitudeE6() / 1E6 + "," + 
                    p.getLongitudeE6() /1E6 , 
                    Toast.LENGTH_SHORT).show();
        }                            
        return false;
    }
    

}
