package com.android.alibaba.ip.common;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PatchInfo implements Serializable {
    public String baseVersion;
    private String httpsUrl;
    private String md5;
    private String patchUrl;
    public int patchVersion;
    public int priority;
    private long size;
    private String type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PatchInfo patchInfo = (PatchInfo) obj;
        if (this.patchVersion == patchInfo.patchVersion && this.priority == patchInfo.priority) {
            return this.baseVersion.equals(patchInfo.baseVersion);
        }
        return false;
    }

    public String getBaseVersion() {
        return this.baseVersion;
    }

    public String getHttpsUrl() {
        return this.httpsUrl;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPatchUrl() {
        return this.patchUrl;
    }

    public int getPatchVersion() {
        return this.patchVersion;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getSize() {
        return this.size;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.patchVersion * 31) + this.baseVersion.hashCode()) * 31) + this.priority;
    }

    public void setBaseVersion(String str) {
        this.baseVersion = str;
    }

    public void setHttpsUrl(String str) {
        this.httpsUrl = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setPatchUrl(String str) {
        this.patchUrl = str;
    }

    public void setPatchVersion(int i) {
        this.patchVersion = i;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setType(String str) {
        this.type = str;
    }
}
