package com.solano.androidar.location;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.solano.androidar.AARTabActivity;
import com.solano.androidar.R;

/**
 * Created by Radsen on 7/23/13.
 */
public class AARLocationActivity extends AARTabActivity implements TabHost.OnTabChangeListener{

    private static final String TAG = AARLocationActivity.class.getSimpleName();

    private LocationGps mGps;
    private FragmentManager fragmentManager;
    private AARLocationFragment locationFragment;
    private AARMapFragment mapFragment;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mGps = new LocationGps(this);
        mGps.start();

        locationFragment = new AARLocationFragment();
        mapFragment = new AARMapFragment();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.tabcontent, locationFragment);
        fragmentTransaction.add(android.R.id.tabcontent, mapFragment);
        showFragment(0);

        addTab(createTabSpec(getString(R.string.th_loc_01), locationFragment.getId()));
        addTab(createTabSpec(getString(R.string.th_map_02), mapFragment.getId()));

        setOnTabChangedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aarmain, menu);
        return true;
    }

    @Override
    public void onTabChanged(String tabId){
        showFragment (getCurrentTab());
    }

    private void showFragment(int fragment){
        FragmentTransaction ft = fragmentManager.beginTransaction();

        switch (fragment){
            case 0:
                ft.replace(android.R.id.tabcontent, locationFragment);
                break;
            case 1:
                ft.replace(android.R.id.tabcontent, mapFragment);
                break;
        }

        ft.commit();
    }

    public LocationGps getLocationFromGps(){
        return mGps;
    }
}
