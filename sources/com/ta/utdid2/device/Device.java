package com.ta.utdid2.device;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes7.dex */
public class Device {
    private String imei = "";
    private String imsi = "";
    private String deviceId = "";
    private String utdid = "";
    private long mCreateTimestamp = 0;
    private long mCheckSum = 0;

    long getCheckSum() {
        return this.mCheckSum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getCreateTimestamp() {
        return this.mCreateTimestamp;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getUtdid() {
        return this.utdid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckSum(long j) {
        this.mCheckSum = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCreateTimestamp(long j) {
        this.mCreateTimestamp = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImei(String str) {
        this.imei = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImsi(String str) {
        this.imsi = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUtdid(String str) {
        this.utdid = str;
    }
}
