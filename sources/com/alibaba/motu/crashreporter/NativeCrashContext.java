package com.alibaba.motu.crashreporter;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class NativeCrashContext {
    public final long faultAddress;
    public final long threadId;

    public NativeCrashContext(long j, long j2) {
        this.faultAddress = j;
        this.threadId = j2;
    }
}
