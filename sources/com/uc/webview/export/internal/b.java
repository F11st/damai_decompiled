package com.uc.webview.export.internal;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SDKFactory.f(this.a);
    }
}
