package com.uc.webview.export.internal.android;

import com.uc.webview.export.internal.AbstractC7213a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.w */
/* loaded from: classes11.dex */
public final class RunnableC7244w implements Runnable {
    final /* synthetic */ C7243v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7244w(C7243v c7243v) {
        this.a = c7243v;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkedHashSet linkedHashSet;
        boolean z;
        int i;
        linkedHashSet = AbstractC7213a.a;
        Iterator it = linkedHashSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (((IWebView) it.next()).getView().getWindowVisibility() == 0) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        i = AbstractC7213a.d;
        if (i == 1) {
            if (IWaStat.WaStat.getPrintLogEnable()) {
                Log.d("SDKWaStat", "WebViewDetector:onPause");
            }
            IWaStat.WaStat.saveData();
            C7243v.c();
        }
    }
}
