package com.uc.webview.export.internal.uc;

import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.utility.Log;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class c implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        LinkedHashSet linkedHashSet;
        int i;
        UCMobileWebKit uCMobileWebKit;
        boolean z = false;
        try {
            linkedHashSet = com.uc.webview.export.internal.a.a;
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((IWebView) it.next()).getView().getWindowVisibility() == 0) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            i = com.uc.webview.export.internal.a.d;
            if (i == 1) {
                if (IWaStat.WaStat.getPrintLogEnable()) {
                    Log.d("WebViewDetector", "WebViewDetector:onPause");
                }
                IWaStat.WaStat.saveData();
                if (!SDKFactory.f && (uCMobileWebKit = SDKFactory.d) != null) {
                    uCMobileWebKit.onPause();
                }
                b.c();
            }
        } catch (Throwable unused) {
        }
    }
}
