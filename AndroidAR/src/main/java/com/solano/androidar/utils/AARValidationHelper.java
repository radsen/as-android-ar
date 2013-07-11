package com.solano.androidar.utils;

import android.content.Context;
import android.hardware.SensorManager;

/**
 * Created by Radsen on 7/10/13.
 */
public abstract class AARValidationHelper {

    public static boolean isHardwareAvailable(Context ctx, String type_hw)
    {
        return ctx.getPackageManager().hasSystemFeature(type_hw);
    }

    public static boolean isSensorAvailable(Context ctx, int type_sensor)
    {
        boolean isSensorAvailable = false;
        SensorManager sensorManger = null;

        sensorManger = (SensorManager) ctx.getSystemService(ctx.SENSOR_SERVICE);

        if(sensorManger.getDefaultSensor(type_sensor) != null)
        {
            isSensorAvailable = true;
        }

        return isSensorAvailable;
    }

}
