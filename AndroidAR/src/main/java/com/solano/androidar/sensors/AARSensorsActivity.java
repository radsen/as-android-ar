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
    private Sensor gyroscope;

    private FragmentManager fragmentManager;
    private AARSensorAccelFragment accelFragment;
    private AARSensorGyroFragment gyroFragment;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.avail_sensors_txt_title));

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (AARValidationHelper.isSensorAvailable(this, Sensor.TYPE_ACCELEROMETER)){
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }else{
            // No accelerometer was found, bad news you need a newer phone.
        }

        if (AARValidationHelper.isSensorAvailable(this, Sensor.TYPE_GYROSCOPE)){
            gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        }else{
            // No accelerometer was found, bad news you need a newer phone.
        }

        accelFragment = new AARSensorAccelFragment();
        gyroFragment = new AARSensorGyroFragment();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(android.R.id.tabcontent, accelFragment);
        ft.add(android.R.id.tabcontent, gyroFragment);

        // Creates the accelerometer tab
        addTab(createTabSpec(getString(R.string.sensor_tab_01), accelFragment.getId()));
        // Creates the gyroscope tab
        addTab(createTabSpec(getString(R.string.sensor_tab_02), gyroFragment.getId()));
        setOnTabChangedListener(this);

        showFragment(0);
    }

    @Override
    public void onResume(){
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onTabChanged(String tabId){
        showFragment(getTabHost().getCurrentTab());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // If the accuracy of the sensor changes do something.
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if((getTabHost().getCurrentTab() == 0) &&
                (Math.abs(event.values[0]) > kThreshold || Math.abs(event.values[1]) > kThreshold ||
                        Math.abs(event.values[2]) > kThreshold )
                ){
            Log.d(TAG, "Shake Detected!");
        }

        if((getTabHost().getCurrentTab() == 0) &&
                (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)){
            accelFragment.setAccelerometer(event);
        }else if(getTabHost().getCurrentTab() == 1 &&
                event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            gyroFragment.setGyroscope(event);
            gyroFragment.setRotation((float)Math.toDegrees(event.values[2]));
        }
    }

    private void showFragment(int fragment){
        FragmentTransaction ft = fragmentManager.beginTransaction();

        switch (fragment){
            case 0:
                Log.d(TAG, "Accelerometer Tab");
                ft.replace(android.R.id.tabcontent, accelFragment);
                break;
            case 1:
                Log.d(TAG, "Gyroscope Tab");
                ft.replace(android.R.id.tabcontent, gyroFragment);
                break;
        }

        ft.commit();
    }

}
