package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.setup.bh;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bl implements Callable<Object> {
    final /* synthetic */ bh.C7270a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bh.C7270a c7270a) {
        this.a = c7270a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        C7277h.a(af.a, Integer.valueOf(this.a.a), (String) this.a.e.sdkShellModule.first);
        return Integer.valueOf(C7257ae.C7262e.c);
    }
}
