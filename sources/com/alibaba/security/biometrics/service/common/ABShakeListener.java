package com.alibaba.security.biometrics.service.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABShakeListener implements SensorEventListener {
    private static final int UPDATE_INTERVAL_TIME = 70;
    private boolean isShaking;
    private long lastUpdateTime;
    private float lastX;
    private float lastY;
    private float lastZ;
    private Context mContext;
    private int mShakeSpeed = 1000;

    public ABShakeListener(Context context) {
        this.mContext = context;
    }

    public boolean isShaking() {
        return this.isShaking;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lastUpdateTime;
        if (j < 70) {
            return;
        }
        this.lastUpdateTime = currentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = f - this.lastX;
        float f5 = f2 - this.lastY;
        float f6 = f3 - this.lastZ;
        this.lastX = f;
        this.lastY = f2;
        this.lastZ = f3;
        this.isShaking = false;
        if ((Math.sqrt(((f4 * f4) + (f5 * f5)) + (f6 * f6)) / j) * 10000.0d >= this.mShakeSpeed) {
            this.isShaking = true;
        }
    }
}
