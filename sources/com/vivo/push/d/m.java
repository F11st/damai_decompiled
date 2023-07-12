package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class m implements Runnable {
    final /* synthetic */ com.vivo.push.b.m a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, com.vivo.push.b.m mVar) {
        this.b = lVar;
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) lVar).b;
        context = ((com.vivo.push.l) lVar).a;
        pushMessageCallback.onListTags(context, this.a.h(), this.a.d(), this.a.g());
    }
}
