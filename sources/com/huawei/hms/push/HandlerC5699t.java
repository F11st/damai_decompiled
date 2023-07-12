package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.push.t */
/* loaded from: classes10.dex */
public class HandlerC5699t extends Handler {
    public WeakReference<InterfaceC5700a> a;

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.push.t$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC5700a {
        void handleMessage(Message message);
    }

    public HandlerC5699t(InterfaceC5700a interfaceC5700a) {
        this.a = new WeakReference<>(interfaceC5700a);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        InterfaceC5700a interfaceC5700a = this.a.get();
        if (interfaceC5700a != null) {
            interfaceC5700a.handleMessage(message);
        }
    }
}
