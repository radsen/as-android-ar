package com.solano.androidar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.content.Intent;

import com.solano.androidar.hardware.AARHwTestFragment;
import com.solano.androidar.hardware.AARHwTesterActivity;
import com.solano.androidar.interfaces.OnSelectedListener;

public class AARMainActivity extends FragmentActivity implements OnSelectedListener {

    private static final String TAG = AARMainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_ar_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.aarmain, menu);
        return true;
    }

    @Override
    public void onSelectedItem(String item)
    {
        Fragment viewer =  getSupportFragmentManager().findFragmentById(R.id.hw_fragment);

        if(viewer == null || !viewer.isInLayout())
        {
            Intent intent = new Intent(getApplicationContext(), AARHwTesterActivity.class);

            startActivity(intent);
        }

        Log.d(TAG, item);
    }
}
