package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.w */
/* loaded from: classes11.dex */
public final class RunnableC7477w implements Runnable {
    final /* synthetic */ UPSNotificationMessage a;
    final /* synthetic */ C7475u b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7477w(C7475u c7475u, UPSNotificationMessage uPSNotificationMessage) {
        this.b = c7475u;
        this.a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C7475u c7475u = this.b;
        PushMessageCallback pushMessageCallback = ((AbstractC7480z) c7475u).b;
        context = ((AbstractRunnableC7491l) c7475u).a;
        pushMessageCallback.onNotificationMessageClicked(context, this.a);
    }
}
