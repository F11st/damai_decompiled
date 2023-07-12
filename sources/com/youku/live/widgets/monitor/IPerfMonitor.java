package com.youku.live.widgets.monitor;

import com.youku.live.widgets.protocol.IDestroyable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPerfMonitor extends IDestroyable {
    IPerfMonitor begin();

    int getDeviceScore();

    IPerfMonitor perfBegin(long j);

    IPerfMonitor perfCommitFailure();

    IPerfMonitor perfCommitSuccess();

    IPerfMonitor perfConfig(String str, String str2);

    IPerfMonitor perfEnable(String str, boolean z);

    IPerfMonitor perfPointBegin(String str);

    IPerfMonitor perfPointEnd(String str, String str2);

    IPerfMonitor point(String str, String str2);

    IPerfMonitor pointError(String str, String str2);

    IPerfMonitor pointWarn(String str, String str2);
}
