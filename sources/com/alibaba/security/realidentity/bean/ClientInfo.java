package com.alibaba.security.realidentity.bean;

import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.common.d.C3818l;
import com.alibaba.security.common.d.C3823p;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ClientInfo implements Serializable {
    private String appName;
    private String appPackName;
    private String appVersion;
    private long availableMemory;
    private String clientType;
    private String cpuArch = C3823p.h();
    private String faceSdkName;
    private String faceSdkVersion;
    private String livenessSdkName;
    private String livenessSdkVersion;
    private String manufacturer;
    private String mobileModel;
    private String osName;
    private String osVersion;
    private String rpSdkName;
    private String rpSdkVersion;
    private String supportNeon;
    private long totalMemory;
    private String versionTag;

    public ClientInfo() {
        this.supportNeon = C3823p.g() ? "Yes" : "No";
        this.mobileModel = Build.getMODEL();
        this.manufacturer = Build.getMANUFACTURER();
        this.osName = "Android";
        this.osVersion = Build.VERSION.getRELEASE();
        this.rpSdkName = AbstractC3840a.I;
        this.rpSdkVersion = VersionKey.RP_SDK_VERSION;
        this.livenessSdkName = AbstractC3840a.J;
        this.livenessSdkVersion = VersionKey.FL_SDK_VERSION;
        this.faceSdkName = AbstractC3840a.J;
        this.faceSdkVersion = VersionKey.FL_SDK_VERSION;
        this.clientType = GrsBaseInfo.CountryCodeSource.APP;
        if (C3847g.C3848a.a.c != null) {
            this.appName = C3818l.b(C3847g.C3848a.a.c);
            this.appVersion = C3818l.c(C3847g.C3848a.a.c);
            this.appPackName = C3818l.a(C3847g.C3848a.a.c);
            this.availableMemory = C3823p.a(C3847g.C3848a.a.c);
            C3847g unused = C3847g.C3848a.a;
            this.totalMemory = C3823p.i();
        }
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackName() {
        return this.appPackName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public long getAvailableMemory() {
        return this.availableMemory;
    }

    public String getClientType() {
        return this.clientType;
    }

    public String getCpuArch() {
        return this.cpuArch;
    }

    public String getFaceSdkName() {
        return this.faceSdkName;
    }

    public String getFaceSdkVersion() {
        return this.faceSdkVersion;
    }

    public String getLivenessSdkName() {
        return this.livenessSdkName;
    }

    public String getLivenessSdkVersion() {
        return this.livenessSdkVersion;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getMobileModel() {
        return this.mobileModel;
    }

    public String getOsName() {
        return this.osName;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getRpSdkName() {
        return this.rpSdkName;
    }

    public String getRpSdkVersion() {
        return this.rpSdkVersion;
    }

    public String getSupportNeon() {
        return this.supportNeon;
    }

    public long getTotalMemory() {
        return this.totalMemory;
    }

    public String getVersionTag() {
        return this.versionTag;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppPackName(String str) {
        this.appPackName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setAvailableMemory(long j) {
        this.availableMemory = j;
    }

    public void setClientType(String str) {
        this.clientType = str;
    }

    public void setCpuArch(String str) {
        this.cpuArch = str;
    }

    public void setFaceSdkName(String str) {
        this.faceSdkName = str;
    }

    public void setFaceSdkVersion(String str) {
        this.faceSdkVersion = str;
    }

    public void setLivenessSdkName(String str) {
        this.livenessSdkName = str;
    }

    public void setLivenessSdkVersion(String str) {
        this.livenessSdkVersion = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setMobileModel(String str) {
        this.mobileModel = str;
    }

    public void setOsName(String str) {
        this.osName = str;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setRpSdkName(String str) {
        this.rpSdkName = str;
    }

    public void setRpSdkVersion(String str) {
        this.rpSdkVersion = str;
    }

    public void setSupportNeon(String str) {
        this.supportNeon = str;
    }

    public void setTotalMemory(long j) {
        this.totalMemory = j;
    }

    public void setVersionTag(String str) {
        this.versionTag = str;
    }
}
