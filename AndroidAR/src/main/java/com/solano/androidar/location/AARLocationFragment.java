package com.solano.androidar.location;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.solano.androidar.R;

/**
 * Created by Radsen on 7/23/13.
 */
public class AARLocationFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout relativeLayout = (RelativeLayout)inflater.inflate(R.layout.loc_gps_fragment, container, false);

        return relativeLayout;
    }
}
