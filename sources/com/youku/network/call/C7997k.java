package com.youku.network.call;

import anetwork.channel.Network;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.youku.android.antiflow.AntiFlowManagerImpl;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.httpcommunication.C7925b;
import com.youku.network.C7984c;
import com.youku.network.C8004d;
import com.youku.network.InterfaceC7974a;
import com.youku.network.a.C7978d;
import java.util.concurrent.Future;
import tb.k60;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.k */
/* loaded from: classes3.dex */
public class C7997k extends C7987a {
    private Request e;
    private Network f;
    private Future<Response> g;
    private IAntiFlowManager h;

    @Override // com.youku.network.call.C7987a
    public C8004d a() {
        if (!this.h.beforeCall()) {
            return this.d.a(this.f.syncSend(this.e, null));
        }
        C8004d a = C8004d.a();
        a.b(420);
        return a;
    }

    @Override // com.youku.network.call.C7987a
    public void a(InterfaceC7974a interfaceC7974a) {
        if (!this.h.beforeCall()) {
            this.g = this.f.asyncSend(this.e, null, null, new C7998l(interfaceC7974a, this.h));
            return;
        }
        C8004d a = C8004d.a();
        a.b(420);
        a(null, interfaceC7974a, a);
    }

    @Override // com.youku.network.call.C7987a
    public void a(C7984c c7984c) {
        this.c = c7984c;
        this.h = new AntiFlowManagerImpl(C7925b.a, c7984c.e(), c7984c.M(), c7984c.N());
        this.f = new k60(C7925b.a);
        C7978d c7978d = new C7978d(this.h);
        this.d = c7978d;
        this.e = c7978d.a(c7984c);
    }

    @Override // com.youku.network.call.C7987a
    public void b() {
        Future<Response> future = this.g;
        if (future != null) {
            future.cancel(true);
        }
    }

    @Override // com.youku.network.call.C7987a
    public void b(InterfaceC7974a interfaceC7974a) {
        if (!this.h.beforeCall()) {
            this.g = this.f.asyncSend(this.e, null, null, new C7998l(C7987a.a, interfaceC7974a, this.h));
            return;
        }
        C8004d a = C8004d.a();
        a.b(420);
        a(C7987a.a, interfaceC7974a, a);
    }
}
