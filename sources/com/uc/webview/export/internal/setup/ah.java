package com.uc.webview.export.internal.setup;

import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.utility.C7327d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ah implements Runnable {
    final /* synthetic */ Throwable a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(Throwable th) {
        this.a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C7327d.C7328a c;
        try {
            Thread.sleep(1000L);
        } catch (Throwable unused) {
        }
        try {
            c = af.c(this.a);
            C7327d.a(c);
        } catch (Throwable th) {
            Log.rInfo("SetupController", "generateCustomeLogInfo falied", th);
        }
    }
}
