package com.solano.androidar.sensors;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TabHost;

import com.solano.androidar.AARTabActivity;
import com.solano.androidar.R;

/**
 * Created by pfhats0 on 10/8/13.
 */
public class AARSensorsActivity extends AARTabActivity implements TabHost.OnTabChangeListener{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        AARSensorAccelFragment accelFragment = new AARSensorAccelFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.tabcontent, accelFragment);
        fragmentTransaction.commit();

        // Creates the accelerometer tab
        addTab(createTabSpec(getString(R.string.sensor_tab_01), accelFragment.getId()));
    }

    @Override
    public void onTabChanged(String tabId){
        if(getCurrentTab() == 0){

        }else if(getCurrentTab() == 1){

        }
    }
}
