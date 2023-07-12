package com.alibaba.security.biometrics.sensor.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MotionEventData implements Serializable {
    private int action;
    private int deviceID;
    private long downTime;
    private long elapsedRealtime;
    private long eventTime;
    private float pressure;
    private float size;
    private int toolType;
    private float x;
    private float y;

    public int getAction() {
        return this.action;
    }

    public int getDeviceID() {
        return this.deviceID;
    }

    public long getDownTime() {
        return this.downTime;
    }

    public long getElapsedRealtime() {
        return this.elapsedRealtime;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public float getPressure() {
        return this.pressure;
    }

    public float getSize() {
        return this.size;
    }

    public int getToolType() {
        return this.toolType;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public void setDeviceID(int i) {
        this.deviceID = i;
    }

    public void setDownTime(long j) {
        this.downTime = j;
    }

    public void setElapsedRealtime(long j) {
        this.elapsedRealtime = j;
    }

    public void setEventTime(long j) {
        this.eventTime = j;
    }

    public void setPressure(float f) {
        this.pressure = f;
    }

    public void setSize(float f) {
        this.size = f;
    }

    public void setToolType(int i) {
        this.toolType = i;
    }

    public void setX(float f) {
        this.x = f;
    }

    public void setY(float f) {
        this.y = f;
    }
}
