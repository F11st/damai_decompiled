package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class ae implements Runnable {
    final /* synthetic */ com.vivo.push.b.i a;
    final /* synthetic */ ad b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, com.vivo.push.b.i iVar) {
        this.b = adVar;
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ad adVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) adVar).b;
        context = ((com.vivo.push.l) adVar).a;
        pushMessageCallback.onUnBind(context, this.a.h(), this.a.d());
    }
}
