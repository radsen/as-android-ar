package com.solano.androidar.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.TabHost;

import com.solano.androidar.AARTabActivity;
import com.solano.androidar.R;
import com.solano.androidar.utils.AARValidationHelper;

/**
 * Created by pfhats0 on 10/8/13.
 */
public class AARSensorsActivity extends AARTabActivity implements TabHost.OnTabChangeListener, SensorEventListener{

    private final String TAG = AARSensorsActivity.class.getSimpleName();
    private final double kThreshold = 2.0;

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private FragmentManager fragmentManager;
    private AARSensorAccelFragment accelFragment;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (AARValidationHelper.isSensorAvailable(this, Sensor.TYPE_ACCELEROMETER)){
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }else{
            // No accelerometer was found, bad news you need a newer phone.
        }

        accelFragment = new AARSensorAccelFragment();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.tabcontent, accelFragment);
        fragmentTransaction.commit();

        // Creates the accelerometer tab
        addTab(createTabSpec(getString(R.string.sensor_tab_01), accelFragment.getId()));
    }

    @Override
    public void onResume(){
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onTabChanged(String tabId){
        FragmentTransaction ft = fragmentManager.beginTransaction();

        if(getCurrentTab() == 0){
            ft.replace(android.R.id.tabcontent, accelFragment);
        }else if(getCurrentTab() == 1){

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // If the accuracy of the sensor changes do something.
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(Math.abs(event.values[0]) > kThreshold ||
                Math.abs(event.values[1]) > kThreshold ||
                Math.abs(event.values[2]) > kThreshold ){
            Log.d(TAG, "Shake Detected!");
        }

        accelFragment.setAccelerometer(event);
    }

}
