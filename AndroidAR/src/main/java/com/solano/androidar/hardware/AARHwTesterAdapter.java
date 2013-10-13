package com.solano.androidar.hardware;

import android.content.Context;
import android.hardware.Sensor;
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
    private ArrayList<Sensor> hwList = null;
    LayoutInflater inflater = null;

    public AARHwTesterAdapter(Context ctx, ArrayList<Sensor> hwList){
        this.ctx = ctx;
        this.hwList = hwList;

        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        ViewHolder holder;
        Sensor sensor = (Sensor)getItem(position);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.hardware_item, null);
            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tvwHwItem);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvName.setText(sensor.getName());

        return convertView;
    }

    static class ViewHolder
    {
        TextView tvName;
    }
}
