package com.alibaba.security.biometrics.sensor.model;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RpCollectInfo implements Serializable {
    private static final int DATA_VERSION = 1;
    private String activityName;
    private List<DisplayInfo> displayInfoArray;
    private int displayModelSize;
    private List<MotionEventData> motionDataArray;
    private int motionListSize;
    private List<SensorData> sensorDataArray;
    private int sensorListSize;
    private long timestamp;
    private int version = 1;

    public String getActivityName() {
        return this.activityName;
    }

    public List<DisplayInfo> getDisplayInfoArray() {
        return this.displayInfoArray;
    }

    public int getDisplayModelSize() {
        return this.displayModelSize;
    }

    public List<MotionEventData> getMotionDataArray() {
        return this.motionDataArray;
    }

    public int getMotionListSize() {
        return this.motionListSize;
    }

    public List<SensorData> getSensorDataArray() {
        return this.sensorDataArray;
    }

    public int getSensorListSize() {
        return this.sensorListSize;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getVersion() {
        return this.version;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public void setDisplayInfoArray(List<DisplayInfo> list) {
        this.displayInfoArray = list;
    }

    public void setDisplayModelSize(int i) {
        this.displayModelSize = i;
    }

    public void setMotionDataArray(List<MotionEventData> list) {
        this.motionDataArray = list;
    }

    public void setMotionListSize(int i) {
        this.motionListSize = i;
    }

    public void setSensorDataArray(List<SensorData> list) {
        this.sensorDataArray = list;
    }

    public void setSensorListSize(int i) {
        this.sensorListSize = i;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
