package com.alibaba.security.biometrics.service.model.result;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SensorInfo implements Serializable {
    private float lightBrightness;
    private float proximityValue;

    public SensorInfo(float f) {
        this.lightBrightness = f;
    }

    public float getLightBrightness() {
        return this.lightBrightness;
    }

    public float getProximityValue() {
        return this.proximityValue;
    }

    public void setLightBrightness(float f) {
        this.lightBrightness = f;
    }

    public void setProximityValue(float f) {
        this.proximityValue = f;
    }

    public SensorInfo(float f, float f2) {
        this.lightBrightness = f;
        this.proximityValue = f2;
    }
}
