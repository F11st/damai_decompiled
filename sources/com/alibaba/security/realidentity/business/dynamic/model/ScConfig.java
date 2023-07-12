package com.alibaba.security.realidentity.business.dynamic.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScConfig implements Serializable {
    private String clickSensorCnt;
    private String enableSensors;
    private String interval;
    private String maxClickCnt;
    private String needCollect;

    public String getClickSensorCnt() {
        return this.clickSensorCnt;
    }

    public String getEnableSensors() {
        return this.enableSensors;
    }

    public String getInterval() {
        return this.interval;
    }

    public String getMaxClickCnt() {
        return this.maxClickCnt;
    }

    public String getNeedCollect() {
        return this.needCollect;
    }

    public void setClickSensorCnt(String str) {
        this.clickSensorCnt = str;
    }

    public void setEnableSensors(String str) {
        this.enableSensors = str;
    }

    public void setInterval(String str) {
        this.interval = str;
    }

    public void setMaxClickCnt(String str) {
        this.maxClickCnt = str;
    }

    public void setNeedCollect(String str) {
        this.needCollect = str;
    }
}
