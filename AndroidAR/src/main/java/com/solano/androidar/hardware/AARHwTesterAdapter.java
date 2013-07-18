package com.solano.androidar.hardware;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.solano.androidar.R;
import com.solano.androidar.model.Hardware;

import java.util.ArrayList;

/**
 * Created by Radsen on 7/17/13.
 */
public class AARHwTesterAdapter extends BaseAdapter {

    private Context ctx = null;
    private ArrayList<Hardware> hwList = null;

    public AARHwTesterAdapter(Context ctx, ArrayList<Hardware> hwList){
        this.ctx = ctx;
        this.hwList = hwList;
    }

    public int getCount(){
        return this.hwList.size();
    }

    public Object getItem(int position){
        return this.hwList.get(position);
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        if(convertView == null){
            view = new View(ctx);

            inflater.inflate(R.layout.hardwareItem, null);

            ImageView imgView = (ImageView) view.findViewById(R.id.ivwHwItem);
            imgView.setImageResource(R.drawable.ic_launcher);
            TextView tvName = (TextView) view.findViewById(R.id.tvwHwItem);
            tvName.setText(R.string.app_name);

        }else{
            view = convertView;
        }

        return view;
    }
}
