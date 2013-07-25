package com.solano.androidar.hardware;

import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.solano.androidar.R;
import com.solano.androidar.model.Hardware;
import com.solano.androidar.utils.AARValidationHelper;

import java.util.ArrayList;

/**
 * Created by Radsen on 7/13/13.
 */
public class AARHwTestFragment extends Fragment {

    GridView gvHw = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.hardware, container, false);

        AARHwTesterAdapter adapter = new AARHwTesterAdapter(getActivity().getApplicationContext(), this.data());

        gvHw = (GridView) linearLayout.findViewById(R.id.gridView);
        gvHw.setAdapter(adapter);

        return linearLayout;
    }

    public ArrayList<Hardware> data(){
        ArrayList<Hardware> reqHwList = new ArrayList<Hardware>();

        Hardware camera = new Hardware();
        camera.setHardwareId(1);
        camera.setHardwareName("Camera");
        camera.setHardwareImageResource(R.drawable.ic_launcher);

        if(AARValidationHelper.isHardwareAvailable(getActivity().getApplicationContext(), PackageManager.FEATURE_CAMERA)){
            camera.setHardwareImageResource(R.drawable.icn_camera_96);
        }

        reqHwList.add(camera);

        return reqHwList;
    }
}
