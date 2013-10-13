package com.solano.androidar.hardware;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.solano.androidar.R;
import com.solano.androidar.model.Hardware;
import com.solano.androidar.utils.AARValidationHelper;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Radsen on 7/13/13.
 */
public class AARHwTestFragment extends Fragment {

    ListView lvSensors = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.hardware, container, false);

        AARHwTesterAdapter adapter = new AARHwTesterAdapter(getActivity().getApplicationContext(), this.data());

        lvSensors = (ListView) linearLayout.findViewById(R.id.lvSensors);
        lvSensors.setAdapter(adapter);

        return linearLayout;
    }

    public ArrayList<Sensor> data(){
        ArrayList<Sensor> sensorList = new ArrayList<Sensor>();

        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(Sensor sensor : sensors){
            sensorList.add(sensor);
        }

        return sensorList;
    }
}
