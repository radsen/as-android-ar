package com.solano.androidar.model;

import android.graphics.Bitmap;

/**
 * Created by Radsen on 7/17/13.
 */
public class Hardware {

    private int hw_id;
    private String hw_name;
    private int img_resource;

    public Hardware(){}

    public void setHardwareId(int hw_id){
        this.hw_id = hw_id;
    }

    public int getHardwareId(){
        return this.hw_id;
    }

    public void setHardwareName(String hw_name){
        this.hw_name = hw_name;
    }

    public String getHardwareName(){
        return this.hw_name;
    }

    public void setHardwareImageResource(int img_resource){
        this.img_resource = img_resource;
    }

    public int getHardwareImageResource(){
        return this.img_resource;
    }
}
