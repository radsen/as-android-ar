package com.solano.androidar.sensors;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;

import com.solano.androidar.R;

/**
 * Created by pfhats0 on 10/8/13.
 */
public class AARSensorAccelFragment extends Fragment {

    private static final String TAG = AARSensorAccelFragment.class.getSimpleName();

    private TextView tvX, tvY, tvZ;
    private ProgressBar pbX, pbY, pbZ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout)inflater.inflate(R.layout.sensor_accel_fragment, container, false);

        tvX = (TextView) relativeLayout.findViewById(R.id.tvXAxis);
        pbX = (ProgressBar) relativeLayout.findViewById(R.id.pbXAxis);

        tvY = (TextView) relativeLayout.findViewById(R.id.tvYAxis);
        pbY = (ProgressBar) relativeLayout.findViewById(R.id.pbYAxis);

        tvZ = (TextView) relativeLayout.findViewById(R.id.tvZAxis);
        pbZ = (ProgressBar) relativeLayout.findViewById(R.id.pbZAxis);

        return relativeLayout;
    }

    public void setAccelerometer(SensorEvent event){
        if(event != null){
            tvX.setText("X: " + event.values[0]);
            pbX.setProgress(Math.abs ((int) event.values[0]));
            tvY.setText("Y: " + event.values[1]);
            pbY.setProgress(Math.abs ((int) event.values[1]));
            tvZ.setText("Z: " + event.values[2]);
            pbZ.setProgress(Math.abs ((int) event.values[2]));
        }else{
            Log.d(TAG, "WTF! For some reason the event is 'null'");
        }
    }
}
