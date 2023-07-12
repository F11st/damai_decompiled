package com.uc.webview.export.internal.android;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import com.uc.webview.export.WebStorage;
import com.uc.webview.export.internal.interfaces.IWebStorage;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class q implements IWebStorage {
    private WebStorage a = WebStorage.getInstance();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements ValueCallback<Map> {
        private ValueCallback<Map> b;

        public a(ValueCallback<Map> valueCallback) {
            this.b = valueCallback;
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Map map) {
            Map map2 = map;
            ValueCallback<Map> valueCallback = this.b;
            if (valueCallback != null) {
                if (Build.VERSION.SDK_INT >= 11) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry : map2.entrySet()) {
                        WebStorage.Origin origin = (WebStorage.Origin) entry.getValue();
                        hashMap.put(entry.getKey(), new WebStorage.Origin(origin.getOrigin(), origin.getQuota(), origin.getUsage()));
                    }
                    valueCallback.onReceiveValue(hashMap);
                    return;
                }
                valueCallback.onReceiveValue(map2);
            }
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebStorage
    public final void deleteAllData() {
        this.a.deleteAllData();
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebStorage
    public final void deleteOrigin(String str) {
        this.a.deleteOrigin(str);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebStorage
    public final void getOrigins(ValueCallback<Map> valueCallback) {
        this.a.getOrigins(new a(valueCallback));
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebStorage
    public final void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        this.a.getQuotaForOrigin(str, valueCallback);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebStorage
    public final void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        this.a.getUsageForOrigin(str, valueCallback);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebStorage
    @Deprecated
    public final void setQuotaForOrigin(String str, long j) {
        this.a.setQuotaForOrigin(str, j);
    }
}
