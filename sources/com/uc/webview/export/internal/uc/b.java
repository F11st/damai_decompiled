package com.uc.webview.export.internal.uc;

import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b extends com.uc.webview.export.internal.a {
    static Runnable f = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c() {
        com.uc.webview.export.internal.a.d = 0;
        return 0;
    }

    @Override // com.uc.webview.export.internal.a
    public final void a(int i, int i2) {
        UCMobileWebKit uCMobileWebKit;
        if (com.uc.webview.export.internal.a.b == i && com.uc.webview.export.internal.a.c == i2) {
            return;
        }
        if (!SDKFactory.f && (uCMobileWebKit = SDKFactory.d) != null) {
            uCMobileWebKit.onWindowSizeChanged();
        }
        com.uc.webview.export.internal.a.b = i;
        com.uc.webview.export.internal.a.c = i2;
    }

    @Override // com.uc.webview.export.internal.a
    public final void b(IWebView iWebView) {
        com.uc.webview.export.internal.a.a.remove(iWebView);
        if (com.uc.webview.export.internal.a.a.isEmpty()) {
            if (IWaStat.WaStat.getPrintLogEnable()) {
                Log.d("SDKWaStat", "WebViewDetector:destroy");
            }
            IWaStat.WaStat.saveData(true);
        }
    }

    @Override // com.uc.webview.export.internal.a
    public final void a(IWebView iWebView, int i) {
        UCMobileWebKit uCMobileWebKit;
        Log.d("WebViewDetector", "onWindowVisibilityChanged: " + i);
        iWebView.notifyForegroundChanged(i == 0);
        if (i == 0) {
            if (com.uc.webview.export.internal.a.d != 1) {
                if (!SDKFactory.f && (uCMobileWebKit = SDKFactory.d) != null) {
                    uCMobileWebKit.onResume();
                }
                Log.d("WebViewDetector", "WebViewDetector:onResume");
                com.uc.webview.export.internal.a.d = 1;
            }
        } else if (com.uc.webview.export.internal.a.d == 1) {
            com.uc.webview.export.internal.a.e.removeCallbacks(f);
            com.uc.webview.export.internal.a.e.post(f);
        }
    }
}
