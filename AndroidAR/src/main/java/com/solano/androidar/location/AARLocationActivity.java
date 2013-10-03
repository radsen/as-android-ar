package com.solano.androidar.location;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.solano.androidar.R;

/**
 * Created by Radsen on 7/23/13.
 */
public class AARLocationActivity extends FragmentActivity implements TabHost.OnTabChangeListener{

    private static final String TAG = AARLocationActivity.class.getSimpleName();

    private LocationGps mGps;
    private TabHost locTabHost;
    private FragmentManager fragmentManager;
    private AARLocationFragment locationFragment;
    private AARMapFragment mapFragment;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loc_srv_activity);

        mGps = new LocationGps(this);
        mGps.start();

        fragmentManager = getSupportFragmentManager();
        locationFragment = (AARLocationFragment) fragmentManager.findFragmentById(R.id.gps_frag);
        mapFragment = (AARMapFragment) fragmentManager.findFragmentById(R.id.map_frag);

        locTabHost = (TabHost) findViewById(R.id.tabHost);
        setupTabs();
        locTabHost.setOnTabChangedListener(this);

        locationFragment.setLocation(mGps.getLocation());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aarmain, menu);
        return true;
    }

    @Override
    public void onTabChanged(String tabId){
        if (locTabHost.getCurrentTab() == 1){
            mapFragment.setLocation(mGps.getLocation());
        }
    }

    private void setupTabs() {
		locTabHost.setup(); // you must call this before adding your tabs!
		locTabHost.addTab(newTab(getString(R.string.th_loc_01), R.id.gps_frag));
		locTabHost.addTab(newTab(getString(R.string.th_map_02), R.id.map_frag));
	}

	private TabSpec newTab(String tag, int tabContentId) {
		TabSpec tabSpec = locTabHost.newTabSpec(tag);
		tabSpec.setIndicator(tag);
		tabSpec.setContent(tabContentId);
		return tabSpec;
	}

}
