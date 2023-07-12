package com.taobao.statistic.core;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class Device {
    private String udid = "";
    private String imei = "";
    private String imsi = "";

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getUdid() {
        return this.udid;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setUdid(String str) {
        this.udid = str;
    }
}
