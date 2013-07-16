package com.solano.androidar.hardware;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.solano.androidar.R;

/**
 * Created by Radsen on 7/13/13.
 */
public class AARHwTestFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.hardware,container, false);

        return linearLayout;
    }
}
