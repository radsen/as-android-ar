package com.solano.androidar.sensors;

import android.graphics.Point;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.solano.androidar.R;

/**
 * Created by pfhats0 on 10/10/13.
 */
public class AARSensorGyroFragment extends Fragment {

    private static final String TAG = AARSensorGyroFragment.class.getSimpleName();

    private ImageView ivFigtherJet;
    private TextView tvRollVal, tvPitchVal, tvYawVal;
    private ProgressBar pbRoll, pbPitch, pbYaw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        RelativeLayout relativeLayout = (RelativeLayout)inflater.inflate(R.layout.sensor_gyro_fragment, container, false);

        ivFigtherJet = (ImageView) relativeLayout.findViewById(R.id.ivFigtherJet);

        tvRollVal = (TextView) relativeLayout.findViewById(R.id.tvRollVal);
        pbRoll = (ProgressBar) relativeLayout.findViewById(R.id.pbRoll);

        tvPitchVal = (TextView) relativeLayout.findViewById(R.id.tvPitchVal);
        pbPitch = (ProgressBar) relativeLayout.findViewById(R.id.pbPitch);

        tvYawVal = (TextView) relativeLayout.findViewById(R.id.tvYawVal);
        pbYaw = (ProgressBar) relativeLayout.findViewById(R.id.pbYaw);

        return relativeLayout;
    }

    public void setGyroscope(SensorEvent event){
        if(event != null){
            tvRollVal.setText("ROLL: " + event.values[0]);
            pbRoll.setProgress(Math.abs ((int) event.values[0]));
            tvPitchVal.setText("PITCH: " + event.values[1]);
            pbPitch.setProgress(Math.abs ((int) event.values[1]));
            tvYawVal.setText("YAW: " + event.values[2]);
            pbYaw.setProgress(Math.abs ((int) event.values[2]));
        }else{
            Log.d(TAG, "WTF! For some reason the event is 'null'");
        }
    }

    public void setRotation(float z){
//        LinearLayout.LayoutParams layoutParams =
//                (LinearLayout.LayoutParams)ivFigtherJet.getLayoutParams();
//        int x = (int)(layoutParams.leftMargin + (ivFigtherJet.getWidth()*0.5));
//        int y = (int)(layoutParams.topMargin + (ivFigtherJet.getHeight()*0.5));
//        Point center = new Point(x, y);

        ObjectAnimator rotation = ObjectAnimator.ofFloat(ivFigtherJet, "rotation", z);
        rotation.setDuration(500);
        rotation.start();

    }
}
