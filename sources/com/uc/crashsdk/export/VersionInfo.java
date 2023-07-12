package com.uc.crashsdk.export;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class VersionInfo {
    public String mBuildId;
    public String mSubVersion;
    public String mVersion;

    public VersionInfo() {
        this.mVersion = null;
        this.mSubVersion = null;
        this.mBuildId = null;
    }

    public VersionInfo(VersionInfo versionInfo) {
        this.mVersion = null;
        this.mSubVersion = null;
        this.mBuildId = null;
        this.mVersion = versionInfo.mVersion;
        this.mSubVersion = versionInfo.mSubVersion;
        this.mBuildId = versionInfo.mBuildId;
    }
}
