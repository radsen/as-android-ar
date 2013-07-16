package com.solano.androidar.hardware;

import android.os.Bundle;
import android.view.Menu;
import android.support.v4.app.FragmentActivity;

import com.solano.androidar.R;

/**
 * Created by Radsen on 7/13/13.
 */
public class AARHwTesterActivity extends FragmentActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw_tester_fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aarmain, menu);
        return true;
    }
}
