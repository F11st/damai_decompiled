package com.uc.webview.export;

import android.util.Pair;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.f */
/* loaded from: classes11.dex */
final class RunnableC7210f implements Runnable {
    final /* synthetic */ Constructor a;
    final /* synthetic */ RunnableC7207e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7210f(RunnableC7207e runnableC7207e, Constructor constructor) {
        this.b = runnableC7207e;
        this.a = constructor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.d.onReceiveValue(new Pair((WebView) this.a.newInstance(this.b.c), null));
        } catch (Throwable th) {
            this.b.d.onReceiveValue(new Pair(null, th));
        }
    }
}
