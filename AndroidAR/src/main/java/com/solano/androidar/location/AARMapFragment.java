package com.solano.androidar.location;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.solano.androidar.R;

/**
 * Created by Radsen on 7/23/13.
 */
public class AARMapFragment extends Fragment implements View.OnClickListener{

    GoogleMap mMap = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.loc_map_fragment, container, false);

        mMap = ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        return relativeLayout;
    }

    @Override
    public void onClick(View view) {
        if(view instanceof Button){
            Button button = (Button) view;
            int mapType = 0;

            if(button.getText().toString().equalsIgnoreCase(getString(R.string.sb_btn_txt_std))){
                mapType = GoogleMap.MAP_TYPE_NORMAL;
            }else if(button.getText().toString().equalsIgnoreCase(getString(R.string.sb_btn_txt_sat))){
                mapType = GoogleMap.MAP_TYPE_SATELLITE;
            }else if(button.getText().toString().equalsIgnoreCase(getString(R.string.sb_btn_txt_hyd))){
                mapType = GoogleMap.MAP_TYPE_HYBRID;
            }

            mMap.setMapType(mapType);
        }
    }

    public void setLocation(Location location){
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.addMarker(new MarkerOptions().position(latLng));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLng)
                .zoom(0)
                .build();

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
