package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bh;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bn implements Callable<Object> {
    final /* synthetic */ bh.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bh.a aVar) {
        this.a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        com.uc.webview.export.internal.uc.startup.b.a(29);
        bh.a aVar = this.a;
        g.a(aVar.e.mSdkShellClassLoader, (String) aVar.f.getOption("core_ver_excludes"), (String) this.a.f.getOption("sdk_ver_excludes"));
        com.uc.webview.export.internal.uc.startup.b.a(213);
        bh.a aVar2 = this.a;
        bt btVar = aVar2.e;
        g.a(btVar, af.a, btVar.mSdkShellClassLoader, aVar2.f.mOptions);
        return Integer.valueOf(ae.e.c);
    }
}
