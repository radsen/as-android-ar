package com.solano.androidar.sensors;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.RelativeLayout;

import com.solano.androidar.R;

/**
 * Created by pfhats0 on 10/10/13.
 */
public class AARSensorGyroFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        RelativeLayout relativeLayout = (RelativeLayout)inflater.inflate(R.layout.sensor_gyro_fragment, container, false);

        return relativeLayout;
    }
}
