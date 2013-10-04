package com.solano.androidar.location;

import android.location.Geocoder;
import android.location.Address;
import java.util.List;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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

import java.io.IOException;

/**
 * Created by Radsen on 7/23/13.
 */
public class AARMapFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = AARMapFragment.class.getSimpleName();

    GoogleMap mMap = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.loc_map_fragment, container, false);

        Button btnStandard = (Button) relativeLayout.findViewById(R.id.btnStandard);
        btnStandard.setOnClickListener(this);
        Button btnSatellite = (Button) relativeLayout.findViewById(R.id.btnSatellite);
        btnSatellite.setOnClickListener(this);
        Button btnHybrid = (Button) relativeLayout.findViewById(R.id.btnHybrid);
        btnHybrid.setOnClickListener(this);

        mMap = ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        return relativeLayout;
    }

    @Override
    public void onClick(View view) {
        if(view instanceof Button){
            Button button = (Button) view;
            int mapType = 0;

            if(button.getText().toString().equals(getString(R.string.sb_btn_txt_std))){
                mapType = GoogleMap.MAP_TYPE_NORMAL;
            }else if(button.getText().toString().equals(getString(R.string.sb_btn_txt_sat))){
                mapType = GoogleMap.MAP_TYPE_SATELLITE;
            }else if(button.getText().toString().equals(getString(R.string.sb_btn_txt_hyd))){
                mapType = GoogleMap.MAP_TYPE_HYBRID;
            }

            mMap.setMapType(mapType);
        }
    }

    public void setLocation(Location location){
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        Geocoder geocoder = new Geocoder(getActivity());
        Address address = null;

        try{
            List<Address> reverseGeocodeList =  geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

            if(reverseGeocodeList.size() > 0){
                address = reverseGeocodeList.get(0);
            }

        }catch (IOException ioex){
            Log.d(TAG, ioex.getMessage());
            address = null;
        }

        String title = "N/A";
        String addr = "N/A";

        if(address != null){
            title = address.getFeatureName();
            addr = address.getAddressLine(0);
        }

        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(title)
                .snippet(addr));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLng)
                .zoom(0)
                .build();

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
