package com.uc.webview.export.cyclone;

import android.os.SystemClock;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public class UCElapseTime {
    private long mStart = currentTime();
    private long mStartCpu = currentThreadTime();

    public static long currentThreadTime() {
        return SystemClock.currentThreadTimeMillis();
    }

    public static long currentTime() {
        return System.currentTimeMillis();
    }

    public long getMilis() {
        return currentTime() - this.mStart;
    }

    public long getMilisCpu() {
        return currentThreadTime() - this.mStartCpu;
    }

    public void reset() {
        this.mStart = currentTime();
        this.mStartCpu = currentThreadTime();
    }

    public long start() {
        return this.mStart;
    }

    public long startCpu() {
        return this.mStartCpu;
    }

    public String toString() {
        return String.format("milis: %-6d, %-6d", Long.valueOf(getMilis()), Long.valueOf(getMilisCpu()));
    }
}
