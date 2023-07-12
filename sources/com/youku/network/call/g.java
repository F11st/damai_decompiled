package com.youku.network.call;

import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class g extends a {
    private MtopBuilder e;
    private ApiID f;

    @Override // com.youku.network.call.a
    public com.youku.network.d a() {
        return this.d.a(this.e.syncRequest());
    }

    @Override // com.youku.network.call.a
    public void a(com.youku.network.a aVar) {
        MtopBuilder mtopBuilder = this.e;
        if (mtopBuilder instanceof MtopBusiness) {
            ((MtopBusiness) mtopBuilder).registerListener((IRemoteListener) new f(aVar, this.d));
        } else {
            mtopBuilder.addListener(new h(aVar, this.d));
        }
        this.f = this.e.asyncRequest();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.network.call.a
    public void a(com.youku.network.c cVar) {
        this.c = cVar;
        com.youku.network.a.c cVar2 = new com.youku.network.a.c();
        this.d = cVar2;
        this.e = cVar2.a(cVar);
    }

    @Override // com.youku.network.call.a
    public void b() {
        this.f.cancelApiCall();
    }

    @Override // com.youku.network.call.a
    public void b(com.youku.network.a aVar) {
        MtopBuilder mtopBuilder = this.e;
        if (mtopBuilder instanceof MtopBusiness) {
            ((MtopBusiness) mtopBuilder).registerListener((IRemoteListener) new f(aVar, a.a, this.d));
        } else {
            mtopBuilder.addListener(new h(aVar, a.a, this.d));
        }
        this.f = this.e.asyncRequest();
    }
}
