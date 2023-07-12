package com.uc.webview.export.internal.uc.wa;

import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.uc.wa.d */
/* loaded from: classes11.dex */
public final class RunnableC7308d implements Runnable {
    final /* synthetic */ C7303a a;

    public RunnableC7308d(C7303a c7303a) {
        this.a = c7303a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C7303a.c(this.a);
        } catch (Throwable th) {
            Log.i("SDKWaStat", "update", th);
        }
    }
}
