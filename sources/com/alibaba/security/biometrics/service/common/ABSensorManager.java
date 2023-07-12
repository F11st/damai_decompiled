package com.alibaba.security.biometrics.service.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alibaba.security.biometrics.service.state.ABStateMachine;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABSensorManager {
    private static final String TAG = "ABSensorManager";
    private SensorEventListener accSensorEventListener = new SensorEventListener() { // from class: com.alibaba.security.biometrics.service.common.ABSensorManager.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent != null) {
                try {
                    Sensor sensor = sensorEvent.sensor;
                    if (sensor == null || sensor.getType() == 15) {
                        return;
                    }
                    if (sensorEvent.sensor.getType() == 1) {
                        if (ABSensorManager.this.mABStateMachine != null) {
                            ABSensorManager.this.mABStateMachine.onSensorChanged(sensorEvent);
                        }
                    } else if (sensorEvent.sensor.getType() == 10 || sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16 || sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 9 || sensorEvent.sensor.getType() != 5 || ABSensorManager.this.mABStateMachine == null) {
                    } else {
                        ABSensorManager.this.mABStateMachine.onIlluminanceChanged(sensorEvent.values[0]);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    };
    private SensorEventListener gyroSensorEventListener = new SensorEventListener() { // from class: com.alibaba.security.biometrics.service.common.ABSensorManager.2
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() == 15) {
                return;
            }
            if (sensorEvent.sensor.getType() == 1) {
                if (ABSensorManager.this.mABStateMachine != null) {
                    ABSensorManager.this.mABStateMachine.onSensorChanged(sensorEvent);
                }
            } else if (sensorEvent.sensor.getType() == 10 || sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16 || sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 9 || sensorEvent.sensor.getType() != 5 || ABSensorManager.this.mABStateMachine == null) {
            } else {
                ABSensorManager.this.mABStateMachine.onIlluminanceChanged(sensorEvent.values[0]);
            }
        }
    };
    private SensorEventListener lightSensorEventListener = new SensorEventListener() { // from class: com.alibaba.security.biometrics.service.common.ABSensorManager.3
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() == 15) {
                return;
            }
            if (sensorEvent.sensor.getType() == 1) {
                if (ABSensorManager.this.mABStateMachine != null) {
                    ABSensorManager.this.mABStateMachine.onSensorChanged(sensorEvent);
                }
            } else if (sensorEvent.sensor.getType() == 10 || sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16 || sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 9 || sensorEvent.sensor.getType() != 5 || ABSensorManager.this.mABStateMachine == null) {
            } else {
                ABSensorManager.this.mABStateMachine.onIlluminanceChanged(sensorEvent.values[0]);
            }
        }
    };
    private ABStateMachine mABStateMachine;
    private Context mContext;
    private Sensor mGyroSensor;
    private Sensor mLightSensor;
    private SensorManager mSensorManager;

    public ABSensorManager(Context context, ABStateMachine aBStateMachine) {
        this.mContext = context;
        this.mABStateMachine = aBStateMachine;
    }

    public void init() {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        if (sensorManager != null) {
            this.mGyroSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 4);
            this.mLightSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.mSensorManager, 5);
            this.mSensorManager.registerListener(this.gyroSensorEventListener, this.mGyroSensor, 3);
            this.mSensorManager.registerListener(this.lightSensorEventListener, this.mLightSensor, 3);
        }
    }

    public void unRegisterABSensorListener() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.accSensorEventListener);
            this.mSensorManager.unregisterListener(this.gyroSensorEventListener);
            this.mSensorManager.unregisterListener(this.lightSensorEventListener);
        }
        this.mSensorManager = null;
        this.accSensorEventListener = null;
        this.gyroSensorEventListener = null;
        this.lightSensorEventListener = null;
    }
}
