package com.taobao.phenix.request;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ImageFlowMonitor {
    int getMinimumScheduleTime2StatWaitSize();

    void onCancel(ImageStatistics imageStatistics);

    void onFail(ImageStatistics imageStatistics, Throwable th);

    void onProcess(ImageStatistics imageStatistics, String str, String str2);

    void onStart(ImageStatistics imageStatistics);

    void onSuccess(ImageStatistics imageStatistics);
}
