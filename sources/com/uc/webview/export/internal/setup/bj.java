package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bh;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class bj implements Callable<Object> {
    final /* synthetic */ bh.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bh.a aVar) {
        this.a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        h.a(af.a, Integer.valueOf(this.a.a), (String) this.a.e.coreImplModule.first);
        return Integer.valueOf(ae.e.c);
    }
}
