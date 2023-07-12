package com.alibaba.security.biometrics.service.model.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DazzleCollectDataConfig implements Serializable {
    private List<DazzleDataConfigItem> conf;
    private SensorInfo firstSensorInfo;
    private SensorInfo lastSensorInfo;
    private int rotate;

    public void addUIConfig(DazzleDataConfigItem dazzleDataConfigItem) {
        if (this.conf == null) {
            this.conf = new ArrayList();
        }
        this.conf.add(dazzleDataConfigItem);
    }

    public List<DazzleDataConfigItem> getConf() {
        return this.conf;
    }

    public SensorInfo getFirstSensorInfo() {
        return this.firstSensorInfo;
    }

    public SensorInfo getLastSensorInfo() {
        return this.lastSensorInfo;
    }

    public int getRotate() {
        return this.rotate;
    }

    public void setConf(List<DazzleDataConfigItem> list) {
        this.conf = list;
    }

    public void setFirstSensorInfo(SensorInfo sensorInfo) {
        this.firstSensorInfo = sensorInfo;
    }

    public void setLastSensorInfo(SensorInfo sensorInfo) {
        this.lastSensorInfo = sensorInfo;
    }

    public void setRotate(int i) {
        this.rotate = i;
    }
}
