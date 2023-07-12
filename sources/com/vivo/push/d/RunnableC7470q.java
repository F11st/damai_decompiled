package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.q */
/* loaded from: classes11.dex */
final class RunnableC7470q implements Runnable {
    final /* synthetic */ UnvarnishedMessage a;
    final /* synthetic */ C7469p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7470q(C7469p c7469p, UnvarnishedMessage unvarnishedMessage) {
        this.b = c7469p;
        this.a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C7469p c7469p = this.b;
        PushMessageCallback pushMessageCallback = ((AbstractC7480z) c7469p).b;
        context = ((AbstractRunnableC7491l) c7469p).a;
        pushMessageCallback.onTransmissionMessage(context, this.a);
    }
}
