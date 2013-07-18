package com.solano.androidar.hardware;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.solano.androidar.R;

/**
 * Created by Radsen on 7/13/13.
 */
public class AARHwTestFragment extends Fragment {

    GridView gvHw = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.hardware,container, false);

        gvHw = (GridView)getActivity().findViewById(R.id.gridView);

        return linearLayout;
    }
}
