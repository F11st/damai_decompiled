package com.uc.webview.export.internal.uc.wa;

import android.content.Context;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class c implements Runnable {
    final /* synthetic */ a a;

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        String a;
        try {
            a aVar = this.a;
            context = aVar.k;
            a = aVar.a(context.getSharedPreferences("UC_WA_STAT", 0));
            a.b(a);
        } catch (Throwable th) {
            Log.i("SDKWaStat", "generateUUID", th);
        }
    }
}
