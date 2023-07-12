package com.meizu.cloud.pushsdk.c.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d extends Handler {
    private final WeakReference<com.meizu.cloud.pushsdk.c.d.a> a;

    public d(com.meizu.cloud.pushsdk.c.d.a aVar) {
        super(Looper.getMainLooper());
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.meizu.cloud.pushsdk.c.d.a aVar = this.a.get();
        if (message.what != 1) {
            super.handleMessage(message);
        } else if (aVar != null) {
            com.meizu.cloud.pushsdk.c.f.a aVar2 = (com.meizu.cloud.pushsdk.c.f.a) message.obj;
            aVar.a(aVar2.a, aVar2.b);
        }
    }
}
