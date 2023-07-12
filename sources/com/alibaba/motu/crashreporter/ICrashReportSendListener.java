package com.alibaba.motu.crashreporter;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public interface ICrashReportSendListener {
    void afterSend(boolean z, CrashReport crashReport);

    void beforeSend(CrashReport crashReport);

    String getName();
}
