package com.android.senzori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Pressure_6 extends AppCompatActivity implements SensorEventListener {

    private  static final String TAG="Pressure";
    private SensorManager sensorManager;
    Sensor pressure;

    TextView pressureVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        pressureVal=(TextView) findViewById(R.id.pressureVal);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        pressure=sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        sensorManager.registerListener(Pressure_6.this, pressure, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered pressure listener");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged: pressure: " + event.values[0] );

        pressureVal.setText("Pressure: " + event.values[0]+" Pa");

    }
}