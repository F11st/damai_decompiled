package com.meizu.cloud.pushsdk.c.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meizu.cloud.pushsdk.c.d.InterfaceC5975a;
import com.meizu.cloud.pushsdk.c.f.C5980a;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.e.d */
/* loaded from: classes10.dex */
public class HandlerC5979d extends Handler {
    private final WeakReference<InterfaceC5975a> a;

    public HandlerC5979d(InterfaceC5975a interfaceC5975a) {
        super(Looper.getMainLooper());
        this.a = new WeakReference<>(interfaceC5975a);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        InterfaceC5975a interfaceC5975a = this.a.get();
        if (message.what != 1) {
            super.handleMessage(message);
        } else if (interfaceC5975a != null) {
            C5980a c5980a = (C5980a) message.obj;
            interfaceC5975a.a(c5980a.a, c5980a.b);
        }
    }
}
