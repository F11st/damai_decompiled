package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.setup.bb;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class bd implements Callable<Object> {
    final /* synthetic */ Context a;
    final /* synthetic */ bb.C7269a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb.C7269a c7269a, Context context) {
        this.b = c7269a;
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        C7276g.a(this.b.e, this.a, bt.class.getClassLoader(), bb.this.mOptions);
        return Integer.valueOf(C7257ae.C7262e.c);
    }
}
