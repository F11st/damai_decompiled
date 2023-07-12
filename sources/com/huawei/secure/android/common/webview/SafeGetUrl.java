package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.C5762b;
import com.huawei.secure.android.common.util.C5763c;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SafeGetUrl {
    private static final String c = "SafeGetUrl";
    private static final long d = 200;
    private String a;
    private WebView b;

    /* compiled from: Taobao */
    /* renamed from: com.huawei.secure.android.common.webview.SafeGetUrl$a */
    /* loaded from: classes10.dex */
    class RunnableC5765a implements Runnable {
        final /* synthetic */ CountDownLatch a;

        RunnableC5765a(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.b.getUrl());
            this.a.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public String getUrlMethod() {
        if (this.b == null) {
            return "";
        }
        if (C5762b.a()) {
            return this.b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C5763c.a(new RunnableC5765a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Log.e(c, "getUrlMethod: InterruptedException " + e.getMessage(), e);
        }
        return this.a;
    }

    public WebView getWebView() {
        return this.b;
    }

    public void setUrl(String str) {
        this.a = str;
    }

    public void setWebView(WebView webView) {
        this.b = webView;
    }

    public SafeGetUrl(WebView webView) {
        this.b = webView;
    }
}
