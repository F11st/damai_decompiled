package com.uc.webview.export;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWebStorage;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class WebStorage {
    private static HashMap<Integer, WebStorage> a;
    private IWebStorage b;

    private WebStorage(IWebStorage iWebStorage) {
        this.b = iWebStorage;
    }

    private static synchronized WebStorage a(int i) throws RuntimeException {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            if (a == null) {
                a = new HashMap<>();
            }
            webStorage = a.get(Integer.valueOf(i));
            if (webStorage == null) {
                webStorage = new WebStorage(SDKFactory.a(i));
                a.put(Integer.valueOf(i), webStorage);
            }
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        return a(SDKFactory.e());
    }

    public void deleteAllData() {
        this.b.deleteAllData();
    }

    public void deleteOrigin(String str) {
        this.b.deleteOrigin(str);
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        this.b.getOrigins(valueCallback);
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        this.b.getQuotaForOrigin(str, valueCallback);
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        this.b.getUsageForOrigin(str, valueCallback);
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        this.b.setQuotaForOrigin(str, j);
    }

    public String toString() {
        return "WebStorage@" + hashCode() + jn1.ARRAY_START_STR + this.b + jn1.ARRAY_END_STR;
    }

    public static WebStorage getInstance(WebView webView) {
        return a(webView.getCurrentViewCoreType());
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public static class Origin {
        private String a;
        private long b;
        private long c;

        public Origin(String str, long j, long j2) {
            this.a = null;
            this.b = 0L;
            this.c = 0L;
            this.a = str;
            this.b = j;
            this.c = j2;
        }

        public String getOrigin() {
            return this.a;
        }

        public long getQuota() {
            return this.b;
        }

        public long getUsage() {
            return this.c;
        }

        public Origin(String str, long j) {
            this.a = null;
            this.b = 0L;
            this.c = 0L;
            this.a = str;
            this.b = j;
        }

        public Origin(String str) {
            this.a = null;
            this.b = 0L;
            this.c = 0L;
            this.a = str;
        }
    }
}
