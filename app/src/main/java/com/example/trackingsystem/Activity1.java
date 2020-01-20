package com.example.trackingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Activity1 extends AppCompatActivity implements LocationListener {
private static LocationManager locMan = null;
public static int x = 0;
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
        TextView datetime = findViewById(R.id.datetime);

        double lat = location.getLatitude();
        double lon = location.getLongitude();

        lo.setText(String.format("%.4f", lon));
        la.setText(String.format("%.4f", lat));

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/YYYY");
        String date = sdfD.format(today);
        SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss:SSS");
        String time = sdft.format(today);

        datetime.setText(date + "     " + time);

        //MySQLiteHelper dbhelper = new MySQLiteHelper(this);
        //SQLiteDatabase db = dbhelper.getReadableDatabase();
        //db.execSQL("INSERT INTO Data " +
          //      "VALUES(x+1, lon, lat, date, time)");
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
