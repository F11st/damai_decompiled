package com.uc.webview.export.internal;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.b */
/* loaded from: classes11.dex */
public final class RunnableC7245b implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7245b(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SDKFactory.f(this.a);
    }
}
