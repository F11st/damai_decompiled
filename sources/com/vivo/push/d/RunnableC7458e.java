package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.b.C7421i;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.e */
/* loaded from: classes11.dex */
final class RunnableC7458e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ C7421i b;
    final /* synthetic */ C7457d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7458e(C7457d c7457d, String str, C7421i c7421i) {
        this.c = c7457d;
        this.a = str;
        this.b = c7421i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.a)) {
            C7457d c7457d = this.c;
            PushMessageCallback pushMessageCallback = ((AbstractC7480z) c7457d).b;
            context2 = ((AbstractRunnableC7491l) c7457d).a;
            pushMessageCallback.onReceiveRegId(context2, this.a);
        }
        C7457d c7457d2 = this.c;
        PushMessageCallback pushMessageCallback2 = ((AbstractC7480z) c7457d2).b;
        context = ((AbstractRunnableC7491l) c7457d2).a;
        pushMessageCallback2.onBind(context, this.b.h(), this.b.d());
    }
}
