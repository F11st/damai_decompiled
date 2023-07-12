package com.alibaba.android.ultron.trade.monitor;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IMonitor {
    String getCurrentPage();

    long getMaxThreshold();

    long getStartMonitorTime();

    boolean isMonitorStart();

    void setMonitorStart(boolean z);
}
