package com.alibaba.motu.crashreporter2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ThreadInfo {
    private final String mThreadName;
    private final int mTid;

    public ThreadInfo(int i, String str) {
        this.mThreadName = str;
        this.mTid = i;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public int getTid() {
        return this.mTid;
    }
}
