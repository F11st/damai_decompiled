package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.interfaces.IWaStat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ag implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(int i) {
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IWaStat.WaStat.stat("core_sust", "st_" + this.a + ":1", 0);
    }
}
