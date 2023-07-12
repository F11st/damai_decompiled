package com.uc.webview.export.internal.setup;

import android.util.Pair;
import com.uc.webview.export.cyclone.UCLoader;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.setup.bh;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.bm */
/* loaded from: classes11.dex */
public final class CallableC7271bm implements Callable<Object> {
    final /* synthetic */ bh.C7270a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC7271bm(bh.C7270a c7270a) {
        this.a = c7270a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        bt btVar = this.a.e;
        Pair<String, String> pair = btVar.sdkShellModule;
        this.a.e.mSdkShellClassLoader = new UCLoader((String) pair.first, (String) pair.second, btVar.soDirPath, bh.class.getClassLoader());
        return Integer.valueOf(C7257ae.C7262e.c);
    }
}
