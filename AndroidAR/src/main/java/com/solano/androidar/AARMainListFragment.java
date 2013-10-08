package com.solano.androidar;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.app.Activity;

import com.solano.androidar.interfaces.OnSelectedListener;

/**
 * Created by Radsen on 7/13/13.
 */
public class AARMainListFragment extends Fragment{

    private OnSelectedListener itemSelectedListener = null;

    String[] options = new String[] {
            "Check HW availability",
            "Location services",
            "Sensors"
    };

    private ArrayAdapter<String> arrayAdapter = null;
    private ListView listView = null;

    public AARMainListFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.main_list_fragment,container, false);

        arrayAdapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, options);

        listView = (ListView) linearLayout.findViewById(R.id.mainListView);
        /** Setting the list adapter for the ListFragment */
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemSelectedListener.onSelectedItem(i);
            }
        });

        return linearLayout;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            itemSelectedListener = (OnSelectedListener) activity;
        }catch (ClassCastException cce) {
            // TODO: handle exception
            throw new ClassCastException(activity.toString() + "must implement OnItemSelectedListener");
        }
    }
}
