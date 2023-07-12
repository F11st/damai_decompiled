package com.android.alibaba.ip.runtime;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ApplicationPatch {
    public final int patchVersion;
    public final String path;

    public ApplicationPatch(String str, int i) {
        this.path = str;
        this.patchVersion = i;
    }

    public int getPatchVersion() {
        return this.patchVersion;
    }

    public String getPath() {
        return this.path;
    }

    public String toString() {
        return "ApplicationPatch{path='" + this.path + "', patchVersion=" + this.patchVersion + '}';
    }
}
