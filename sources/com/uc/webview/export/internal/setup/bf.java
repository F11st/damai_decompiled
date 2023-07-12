package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.setup.bb;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bf implements Callable<Object> {
    final /* synthetic */ Context a;
    final /* synthetic */ Integer b;
    final /* synthetic */ bb.C7269a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bb.C7269a c7269a, Context context, Integer num) {
        this.c = c7269a;
        this.a = context;
        this.b = num;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        C7276g.a(this.c.e, this.a, bt.class.getClassLoader(), this.b.intValue());
        return Integer.valueOf(C7257ae.C7262e.c);
    }
}
