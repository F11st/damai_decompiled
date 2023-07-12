package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.setup.bb;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class be implements Callable<Object> {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;
    final /* synthetic */ bb.C7269a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bb.C7269a c7269a, Context context, boolean z) {
        this.c = c7269a;
        this.a = context;
        this.b = z;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        Context context = this.a;
        bb.C7269a c7269a = this.c;
        boolean a = C7276g.a(context, c7269a.e, c7269a.f.mOptions);
        bb.C7269a c7269a2 = this.c;
        C7276g.a(c7269a2.e, c7269a2.f.mOptions, a, this.b, true);
        return Integer.valueOf(C7257ae.C7262e.c);
    }
}
