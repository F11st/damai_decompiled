package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.setup.bh;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bk implements Callable<Object> {
    final /* synthetic */ bh.C7270a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bh.C7270a c7270a) {
        this.a = c7270a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        Context context = af.a;
        bh.C7270a c7270a = this.a;
        boolean a = C7276g.a(context, c7270a.e, c7270a.f.mOptions);
        bh.C7270a c7270a2 = this.a;
        bt btVar = c7270a2.e;
        ConcurrentHashMap<String, Object> concurrentHashMap = c7270a2.f.mOptions;
        Context context2 = af.a;
        C7276g.a(btVar, concurrentHashMap, a, c7270a2.b, false);
        return Integer.valueOf(C7257ae.C7262e.c);
    }
}
