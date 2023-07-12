package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class q implements Runnable {
    final /* synthetic */ UnvarnishedMessage a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.b = pVar;
        this.a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) pVar).b;
        context = ((com.vivo.push.l) pVar).a;
        pushMessageCallback.onTransmissionMessage(context, this.a);
    }
}
