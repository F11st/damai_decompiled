package com.uc.webview.export.internal.android;

import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class v extends com.uc.webview.export.internal.a {
    Runnable f = new w(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c() {
        com.uc.webview.export.internal.a.d = 0;
        return 0;
    }

    @Override // com.uc.webview.export.internal.a
    public final void a(IWebView iWebView, int i) {
        if (i == 0) {
            if (com.uc.webview.export.internal.a.d != 1) {
                com.uc.webview.export.internal.a.d = 1;
            }
        } else if (com.uc.webview.export.internal.a.d == 1) {
            com.uc.webview.export.internal.a.e.removeCallbacks(this.f);
            com.uc.webview.export.internal.a.e.post(this.f);
        }
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
}
