package com.youku.network.call;

import android.os.Handler;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.youku.network.C8004d;
import com.youku.network.InterfaceC7974a;
import com.youku.network.a.C7977c;
import com.youku.network.a.InterfaceC7976b;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.f */
/* loaded from: classes3.dex */
public class C7992f implements IRemoteListener {
    private InterfaceC7974a a;
    private Handler b;
    private C7977c c;
    private C8004d d;

    public C7992f(InterfaceC7974a interfaceC7974a, Handler handler, InterfaceC7976b interfaceC7976b) {
        this.a = interfaceC7974a;
        this.b = handler;
        this.c = (C7977c) interfaceC7976b;
    }

    public C7992f(InterfaceC7974a interfaceC7974a, InterfaceC7976b interfaceC7976b) {
        this(interfaceC7974a, null, interfaceC7976b);
    }

    private void a() {
        InterfaceC7974a interfaceC7974a = this.a;
        if (interfaceC7974a != null) {
            Handler handler = this.b;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.youku.network.call.MTopBusinessListener$1
                    @Override // java.lang.Runnable
                    public void run() {
                        InterfaceC7974a interfaceC7974a2;
                        C8004d c8004d;
                        interfaceC7974a2 = C7992f.this.a;
                        c8004d = C7992f.this.d;
                        interfaceC7974a2.a(c8004d);
                    }
                });
            } else {
                interfaceC7974a.a(this.d);
            }
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        this.d = this.c.a((C7977c) mtopResponse);
        a();
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        this.d = this.c.a((C7977c) mtopResponse);
        a();
    }
}
