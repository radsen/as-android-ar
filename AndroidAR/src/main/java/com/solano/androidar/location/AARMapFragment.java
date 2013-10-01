package com.solano.androidar.location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.solano.androidar.R;

/**
 * Created by Radsen on 7/23/13.
 */
public class AARMapFragment extends SupportMapFragment {

    GoogleMap mMap = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        //mMap = ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map_frag)).getMap();

        return view;
    }
}
