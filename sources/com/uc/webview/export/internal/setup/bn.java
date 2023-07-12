package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.setup.bh;
import com.uc.webview.export.internal.uc.startup.C7302b;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bn implements Callable<Object> {
    final /* synthetic */ bh.C7270a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bh.C7270a c7270a) {
        this.a = c7270a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        C7302b.a(29);
        bh.C7270a c7270a = this.a;
        C7276g.a(c7270a.e.mSdkShellClassLoader, (String) c7270a.f.getOption("core_ver_excludes"), (String) this.a.f.getOption("sdk_ver_excludes"));
        C7302b.a(213);
        bh.C7270a c7270a2 = this.a;
        bt btVar = c7270a2.e;
        C7276g.a(btVar, af.a, btVar.mSdkShellClassLoader, c7270a2.f.mOptions);
        return Integer.valueOf(C7257ae.C7262e.c);
    }
}
