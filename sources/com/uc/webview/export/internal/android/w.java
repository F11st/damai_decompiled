package com.uc.webview.export.internal.android;

import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class w implements Runnable {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.a = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkedHashSet linkedHashSet;
        boolean z;
        int i;
        linkedHashSet = com.uc.webview.export.internal.a.a;
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
        i = com.uc.webview.export.internal.a.d;
        if (i == 1) {
            if (IWaStat.WaStat.getPrintLogEnable()) {
                Log.d("SDKWaStat", "WebViewDetector:onPause");
            }
            IWaStat.WaStat.saveData();
            v.c();
        }
    }
}
