package com.youku.middlewareservice_impl.provider;

import android.util.Log;
import androidx.annotation.Keep;
import com.youku.middlewareservice.provider.LogProvider;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class LogProviderImpl implements LogProvider {
    private boolean enableLog = AppInfoProviderProxy.isDebuggable();

    @Override // com.youku.middlewareservice.provider.LogProvider
    public void enableLog(boolean z) {
        this.enableLog = z;
    }

    @Override // com.youku.middlewareservice.provider.LogProvider
    public void logd(String str, String str2) {
        if (this.enableLog) {
            Log.d(str, str2);
        }
    }

    @Override // com.youku.middlewareservice.provider.LogProvider
    public void loge(String str, String str2) {
        if (this.enableLog) {
            Log.e(str, str2);
        }
    }

    @Override // com.youku.middlewareservice.provider.LogProvider
    public void logi(String str, String str2) {
        if (this.enableLog) {
            Log.i(str, str2);
        }
    }

    @Override // com.youku.middlewareservice.provider.LogProvider
    public void logv(String str, String str2) {
        if (this.enableLog) {
            Log.w(str, str2);
        }
    }

    @Override // com.youku.middlewareservice.provider.LogProvider
    public void logw(String str, String str2) {
        if (this.enableLog) {
            Log.w(str, str2);
        }
    }

    @Override // com.youku.middlewareservice.provider.LogProvider
    public void loge(String str, String str2, Throwable th) {
        if (this.enableLog) {
            Log.e(str, str2, th);
        }
    }
}
