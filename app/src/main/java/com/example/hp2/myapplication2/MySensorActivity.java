package com.example.hp2.myapplication2;

import android.Manifest;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MySensorActivity extends AppCompatActivity implements SensorEventListener, LocationListener {
    @InjectView(R.id.textView5)
    TextView txtSensodData;
    @InjectView(R.id.textView6)
    TextView txtloc;
    @InjectView(R.id.button4)
    Button btnActivate;
    LocationManager locationManager;
    ProgressDialog progressDialog;
    NotificationManager notificationManager;
    SensorManager sensorManager;
    Sensor sensor;
    String msg="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sensor);
        ButterKnife.inject(this);

        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        btnActivate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {


                        if(ActivityCompat.checkSelfPermission(MySensorActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(MySensorActivity.this,"Please Grant Permissions",Toast.LENGTH_LONG).show();
                        }
                        else {

                            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                                sensorManager.registerListener(MySensorActivity.this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
                                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,10,5,MySensorActivity.this);
                                progressDialog.show();
                            }else{
                                Toast.makeText(MySensorActivity.this,"Please Enable GPS",Toast.LENGTH_LONG).show();

                                // Buil-In Intent
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(intent);
                            }


                        }
                    }
                }

        );
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {float[] values = sensorEvent.values;

        float proximity = values[0];


/*

        if (proximity == 0) {

            String phone = "+91 81465 11661";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phone));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"Please Grant Permissions",Toast.LENGTH_LONG).show();
            }else {
                startActivity(intent);
                sensorManager.unregisterListener(this);
            }
        }else{
            txtSensodData.setText("Proximity Value: "+proximity);
        }
*/

        float x = values[0];
        float y = values[1];
        float z = values[2];
        float cal = ((x*x)+(y*y)+(z*z)) / (SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
        if(cal>3){for (int k=0;k<1;k++){
            txtSensodData.setText("Shake Detected");
            String phone = "+91 98726 51661";

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone,null,msg,null,null);}
            sensorManager.unregisterListener(this);
        }else{
            txtSensodData.setText(x+" - "+y+" - "+z);
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();



        txtloc.setText("Location is: "+latitude+" - "+longitude);
        try {
            // Reverse Geocoding : Fetch Address from Latitude and Longitude
            Geocoder geocoder = new Geocoder(this);
            List<Address> adrsList = geocoder.getFromLocation(latitude, longitude, 5);

            if(adrsList!=null && adrsList.size()>0){
                Address address = adrsList.get(0);


                StringBuffer buffer = new StringBuffer();

                for(int i=0;i<address.getMaxAddressLineIndex();i++){
                    buffer.append(address.getAddressLine(i)+"\n");


                }
                txtloc.setText(buffer.toString());
                msg="Hey  Don here "+txtloc.getText();





            }

        }catch (Exception e){
            e.printStackTrace();
        }
        progressDialog.dismiss();

        //location.getSpeed(); mps

        locationManager.removeUpdates(this);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
