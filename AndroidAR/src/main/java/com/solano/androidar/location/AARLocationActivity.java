package com.solano.androidar.location;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.solano.androidar.R;

/**
 * Created by Radsen on 7/23/13.
 */
public class AARLocationActivity extends FragmentActivity{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loc_srv_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aarmain, menu);
        return true;
    }
}
