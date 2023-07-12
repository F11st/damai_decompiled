package com.uc.webview.export.internal.android;

import com.uc.webview.export.internal.AbstractC7213a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.v */
/* loaded from: classes11.dex */
public final class C7243v extends AbstractC7213a {
    Runnable f = new RunnableC7244w(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c() {
        AbstractC7213a.d = 0;
        return 0;
    }

    @Override // com.uc.webview.export.internal.AbstractC7213a
    public final void a(IWebView iWebView, int i) {
        if (i == 0) {
            if (AbstractC7213a.d != 1) {
                AbstractC7213a.d = 1;
            }
        } else if (AbstractC7213a.d == 1) {
            AbstractC7213a.e.removeCallbacks(this.f);
            AbstractC7213a.e.post(this.f);
        }
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
}
