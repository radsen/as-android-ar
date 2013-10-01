package com.solano.androidar.location;

import com.solano.androidar.R;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.location.Location;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.support.v4.app.Fragment;

/**
 * Created by Radsen on 7/23/13.
 */
public class AARLocationFragment extends Fragment{

    private TextView tvLocTitle;
    private TextView tvLocDesc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout relativeLayout = (RelativeLayout)inflater.inflate(R.layout.loc_gps_fragment, container, false);

        tvLocTitle = (TextView) relativeLayout.findViewById(R.id.tvLocTitle);
        tvLocDesc = (TextView) relativeLayout.findViewById(R.id.tvLocDescription);

        return relativeLayout;
    }

    public void setLocation(Location location){
        tvLocTitle.setText("First View");
        tvLocDesc.setText(String.format("Latitude: %f, Longitude: %f", location.getLatitude(), location.getLongitude()));
    }
}
