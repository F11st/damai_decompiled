package com.alibaba.security.biometrics.sensor.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SensorData implements Serializable {
    private long timestamp;
    private int type;
    private float[] values;

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getType() {
        return this.type;
    }

    public float[] getValues() {
        return this.values;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setValues(float[] fArr) {
        this.values = fArr;
    }
}
