package com.example.trackingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity1 extends AppCompatActivity implements LocationListener {
private static LocationManager locMan = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_avtivity1);
        locMan = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    protected void onResume(){
        super.onResume();
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        if((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) &&
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            return;
        }
        locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 5, this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        locMan.removeUpdates(this);
    }


    @Override
    public void onLocationChanged(Location location) {
        if(location == null){return;}
        displayLocation(location);
    }

    private void displayLocation(Location location) {
        TextView lo = findViewById(R.id.cd1);
        TextView la = findViewById(R.id.cd2);

        double lat =
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
