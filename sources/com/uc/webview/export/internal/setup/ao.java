package com.uc.webview.export.internal.setup;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ao implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        am.c(this.a);
    }
}
