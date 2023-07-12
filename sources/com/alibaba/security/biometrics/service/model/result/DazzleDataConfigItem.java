package com.alibaba.security.biometrics.service.model.result;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DazzleDataConfigItem implements Serializable {
    private String color;
    private float duration;
    private float screenLight;
    private String textColor;
    private long timeInterval;

    public String getColor() {
        return this.color;
    }

    public float getDuration() {
        return this.duration;
    }

    public float getScreenLight() {
        return this.screenLight;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public long getTimeInterval() {
        return this.timeInterval;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setDuration(float f) {
        this.duration = f;
    }

    public void setScreenLight(float f) {
        this.screenLight = f;
    }

    public void setTextColor(String str) {
        this.textColor = str;
    }

    public void setTimeInterval(long j) {
        this.timeInterval = j;
    }
}
