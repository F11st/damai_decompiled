package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.b.C7425m;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.m */
/* loaded from: classes11.dex */
final class RunnableC7466m implements Runnable {
    final /* synthetic */ C7425m a;
    final /* synthetic */ C7465l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7466m(C7465l c7465l, C7425m c7425m) {
        this.b = c7465l;
        this.a = c7425m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C7465l c7465l = this.b;
        PushMessageCallback pushMessageCallback = ((AbstractC7480z) c7465l).b;
        context = ((AbstractRunnableC7491l) c7465l).a;
        pushMessageCallback.onListTags(context, this.a.h(), this.a.d(), this.a.g());
    }
}
