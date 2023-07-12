package com.youku.network.call;

import anetwork.channel.Network;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.youku.android.antiflow.AntiFlowManagerImpl;
import com.youku.android.antiflow.IAntiFlowManager;
import java.util.concurrent.Future;
import tb.k60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class k extends a {
    private Request e;
    private Network f;
    private Future<Response> g;
    private IAntiFlowManager h;

    @Override // com.youku.network.call.a
    public com.youku.network.d a() {
        if (!this.h.beforeCall()) {
            return this.d.a(this.f.syncSend(this.e, null));
        }
        com.youku.network.d a = com.youku.network.d.a();
        a.b(420);
        return a;
    }

    @Override // com.youku.network.call.a
    public void a(com.youku.network.a aVar) {
        if (!this.h.beforeCall()) {
            this.g = this.f.asyncSend(this.e, null, null, new l(aVar, this.h));
            return;
        }
        com.youku.network.d a = com.youku.network.d.a();
        a.b(420);
        a(null, aVar, a);
    }

    @Override // com.youku.network.call.a
    public void a(com.youku.network.c cVar) {
        this.c = cVar;
        this.h = new AntiFlowManagerImpl(com.youku.httpcommunication.b.a, cVar.e(), cVar.M(), cVar.N());
        this.f = new k60(com.youku.httpcommunication.b.a);
        com.youku.network.a.d dVar = new com.youku.network.a.d(this.h);
        this.d = dVar;
        this.e = dVar.a(cVar);
    }

    @Override // com.youku.network.call.a
    public void b() {
        Future<Response> future = this.g;
        if (future != null) {
            future.cancel(true);
        }
    }

    @Override // com.youku.network.call.a
    public void b(com.youku.network.a aVar) {
        if (!this.h.beforeCall()) {
            this.g = this.f.asyncSend(this.e, null, null, new l(a.a, aVar, this.h));
            return;
        }
        com.youku.network.d a = com.youku.network.d.a();
        a.b(420);
        a(a.a, aVar, a);
    }
}
