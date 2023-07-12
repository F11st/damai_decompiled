package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.b.C7430r;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.y */
/* loaded from: classes11.dex */
final class RunnableC7479y implements Runnable {
    final /* synthetic */ C7430r a;
    final /* synthetic */ C7478x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7479y(C7478x c7478x, C7430r c7430r) {
        this.b = c7478x;
        this.a = c7430r;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C7478x c7478x = this.b;
        PushMessageCallback pushMessageCallback = ((AbstractC7480z) c7478x).b;
        context = ((AbstractRunnableC7491l) c7478x).a;
        pushMessageCallback.onPublish(context, this.a.h(), this.a.g());
    }
}
