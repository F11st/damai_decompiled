package com.uc.webview.export.internal.uc;

import com.uc.webview.export.internal.AbstractC7213a;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.uc.b */
/* loaded from: classes11.dex */
public final class C7299b extends AbstractC7213a {
    static Runnable f = new RunnableC7300c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c() {
        AbstractC7213a.d = 0;
        return 0;
    }

    @Override // com.uc.webview.export.internal.AbstractC7213a
    public final void a(int i, int i2) {
        UCMobileWebKit uCMobileWebKit;
        if (AbstractC7213a.b == i && AbstractC7213a.c == i2) {
            return;
        }
        if (!SDKFactory.f && (uCMobileWebKit = SDKFactory.d) != null) {
            uCMobileWebKit.onWindowSizeChanged();
        }
        AbstractC7213a.b = i;
        AbstractC7213a.c = i2;
    }

    @Override // com.uc.webview.export.internal.AbstractC7213a
    public final void b(IWebView iWebView) {
        AbstractC7213a.a.remove(iWebView);
        if (AbstractC7213a.a.isEmpty()) {
            if (IWaStat.WaStat.getPrintLogEnable()) {
                Log.d("SDKWaStat", "WebViewDetector:destroy");
            }
            IWaStat.WaStat.saveData(true);
        }
    }

    @Override // com.uc.webview.export.internal.AbstractC7213a
    public final void a(IWebView iWebView, int i) {
        UCMobileWebKit uCMobileWebKit;
        Log.d("WebViewDetector", "onWindowVisibilityChanged: " + i);
        iWebView.notifyForegroundChanged(i == 0);
        if (i == 0) {
            if (AbstractC7213a.d != 1) {
                if (!SDKFactory.f && (uCMobileWebKit = SDKFactory.d) != null) {
                    uCMobileWebKit.onResume();
                }
                Log.d("WebViewDetector", "WebViewDetector:onResume");
                AbstractC7213a.d = 1;
            }
        } else if (AbstractC7213a.d == 1) {
            AbstractC7213a.e.removeCallbacks(f);
            AbstractC7213a.e.post(f);
        }
    }
}
