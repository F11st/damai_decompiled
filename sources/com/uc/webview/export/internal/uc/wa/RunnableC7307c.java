package com.uc.webview.export.internal.uc.wa;

import android.content.Context;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.uc.wa.c */
/* loaded from: classes11.dex */
public final class RunnableC7307c implements Runnable {
    final /* synthetic */ C7303a a;

    public RunnableC7307c(C7303a c7303a) {
        this.a = c7303a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        String a;
        try {
            C7303a c7303a = this.a;
            context = c7303a.k;
            a = c7303a.a(context.getSharedPreferences("UC_WA_STAT", 0));
            C7303a.b(a);
        } catch (Throwable th) {
            Log.i("SDKWaStat", "generateUUID", th);
        }
    }
}
