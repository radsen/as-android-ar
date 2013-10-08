package com.solano.androidar.sensors;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.solano.androidar.R;

/**
 * Created by pfhats0 on 10/8/13.
 */
public class AARSensorAccelFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout)inflater.inflate(R.layout.sensor_accel_fragment, container, false);

        return relativeLayout;
    }
}
