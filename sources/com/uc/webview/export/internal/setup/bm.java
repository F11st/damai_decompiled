package com.uc.webview.export.internal.setup;

import android.util.Pair;
import com.uc.webview.export.cyclone.UCLoader;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bh;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bm implements Callable<Object> {
    final /* synthetic */ bh.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bh.a aVar) {
        this.a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        bt btVar = this.a.e;
        Pair<String, String> pair = btVar.sdkShellModule;
        this.a.e.mSdkShellClassLoader = new UCLoader((String) pair.first, (String) pair.second, btVar.soDirPath, bh.class.getClassLoader());
        return Integer.valueOf(ae.e.c);
    }
}
