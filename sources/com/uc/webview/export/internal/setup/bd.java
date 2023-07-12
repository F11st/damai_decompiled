package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bb;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class bd implements Callable<Object> {
    final /* synthetic */ Context a;
    final /* synthetic */ bb.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb.a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        g.a(this.b.e, this.a, bt.class.getClassLoader(), bb.this.mOptions);
        return Integer.valueOf(ae.e.c);
    }
}
