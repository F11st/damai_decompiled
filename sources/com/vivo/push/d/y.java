package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class y implements Runnable {
    final /* synthetic */ com.vivo.push.b.r a;
    final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, com.vivo.push.b.r rVar) {
        this.b = xVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        x xVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) xVar).b;
        context = ((com.vivo.push.l) xVar).a;
        pushMessageCallback.onPublish(context, this.a.h(), this.a.g());
    }
}
