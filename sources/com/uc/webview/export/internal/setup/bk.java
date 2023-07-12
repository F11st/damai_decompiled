package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bh;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bk implements Callable<Object> {
    final /* synthetic */ bh.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bh.a aVar) {
        this.a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        Context context = af.a;
        bh.a aVar = this.a;
        boolean a = g.a(context, aVar.e, aVar.f.mOptions);
        bh.a aVar2 = this.a;
        bt btVar = aVar2.e;
        ConcurrentHashMap<String, Object> concurrentHashMap = aVar2.f.mOptions;
        Context context2 = af.a;
        g.a(btVar, concurrentHashMap, a, aVar2.b, false);
        return Integer.valueOf(ae.e.c);
    }
}
