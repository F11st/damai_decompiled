package com.alibaba.analytics.utils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface ILogger {
    int getLogLevel();

    boolean isValid();

    void logd(String str, String str2);

    void loge(String str, String str2);

    void loge(String str, String str2, Throwable th);

    void logi(String str, String str2);

    void logw(String str, String str2);

    void logw(String str, String str2, Throwable th);
}
