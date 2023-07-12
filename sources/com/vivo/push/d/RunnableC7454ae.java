package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.b.C7421i;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.ae */
/* loaded from: classes11.dex */
final class RunnableC7454ae implements Runnable {
    final /* synthetic */ C7421i a;
    final /* synthetic */ C7453ad b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7454ae(C7453ad c7453ad, C7421i c7421i) {
        this.b = c7453ad;
        this.a = c7421i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C7453ad c7453ad = this.b;
        PushMessageCallback pushMessageCallback = ((AbstractC7480z) c7453ad).b;
        context = ((AbstractRunnableC7491l) c7453ad).a;
        pushMessageCallback.onUnBind(context, this.a.h(), this.a.d());
    }
}
