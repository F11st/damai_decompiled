package com.uc.webview.export.internal.setup;

import android.os.HandlerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bs extends HandlerThread {
    final /* synthetic */ UCAsyncTask a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(UCAsyncTask uCAsyncTask, String str, int i) {
        super(str, i);
        this.a = uCAsyncTask;
    }

    @Override // android.os.HandlerThread
    protected final void onLooperPrepared() {
        this.a.a(getLooper());
    }
}
