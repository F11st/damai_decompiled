package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.b.C7426n;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.o */
/* loaded from: classes11.dex */
final class RunnableC7468o implements Runnable {
    final /* synthetic */ C7426n a;
    final /* synthetic */ C7467n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7468o(C7467n c7467n, C7426n c7426n) {
        this.b = c7467n;
        this.a = c7426n;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C7467n c7467n = this.b;
        PushMessageCallback pushMessageCallback = ((AbstractC7480z) c7467n).b;
        context = ((AbstractRunnableC7491l) c7467n).a;
        pushMessageCallback.onLog(context, this.a.d(), this.a.e(), this.a.f());
    }
}
