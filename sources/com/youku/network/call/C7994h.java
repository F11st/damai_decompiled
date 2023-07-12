package com.youku.network.call;

import android.os.Handler;
import com.youku.network.C8004d;
import com.youku.network.InterfaceC7974a;
import com.youku.network.a.C7977c;
import com.youku.network.a.InterfaceC7976b;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.h */
/* loaded from: classes3.dex */
public class C7994h implements MtopCallback.MtopFinishListener {
    private InterfaceC7974a a;
    private Handler b;
    private C7977c c;
    private C8004d d;

    public C7994h(InterfaceC7974a interfaceC7974a, Handler handler, InterfaceC7976b interfaceC7976b) {
        this.a = interfaceC7974a;
        this.b = handler;
        this.c = (C7977c) interfaceC7976b;
    }

    public C7994h(InterfaceC7974a interfaceC7974a, InterfaceC7976b interfaceC7976b) {
        this(interfaceC7974a, null, interfaceC7976b);
    }

    private void a() {
        InterfaceC7974a interfaceC7974a = this.a;
        if (interfaceC7974a != null) {
            Handler handler = this.b;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.youku.network.call.MTopListener$1
                    @Override // java.lang.Runnable
                    public void run() {
                        InterfaceC7974a interfaceC7974a2;
                        C8004d c8004d;
                        interfaceC7974a2 = C7994h.this.a;
                        c8004d = C7994h.this.d;
                        interfaceC7974a2.a(c8004d);
                    }
                });
            } else {
                interfaceC7974a.a(this.d);
            }
        }
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        this.d = this.c.a((C7977c) mtopFinishEvent.getMtopResponse());
        a();
    }
}
