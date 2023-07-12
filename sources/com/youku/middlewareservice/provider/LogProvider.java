package com.youku.middlewareservice.provider;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface LogProvider {
    void enableLog(boolean z);

    void logd(String str, String str2);

    void loge(String str, String str2);

    void loge(String str, String str2, Throwable th);

    void logi(String str, String str2);

    void logv(String str, String str2);

    void logw(String str, String str2);
}
