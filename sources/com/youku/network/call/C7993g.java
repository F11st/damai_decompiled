package com.youku.network.call;

import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.youku.network.C7984c;
import com.youku.network.C8004d;
import com.youku.network.InterfaceC7974a;
import com.youku.network.a.C7977c;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.g */
/* loaded from: classes3.dex */
public class C7993g extends C7987a {
    private MtopBuilder e;
    private ApiID f;

    @Override // com.youku.network.call.C7987a
    public C8004d a() {
        return this.d.a(this.e.syncRequest());
    }

    @Override // com.youku.network.call.C7987a
    public void a(InterfaceC7974a interfaceC7974a) {
        MtopBuilder mtopBuilder = this.e;
        if (mtopBuilder instanceof MtopBusiness) {
            ((MtopBusiness) mtopBuilder).registerListener((IRemoteListener) new C7992f(interfaceC7974a, this.d));
        } else {
            mtopBuilder.addListener(new C7994h(interfaceC7974a, this.d));
        }
        this.f = this.e.asyncRequest();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.network.call.C7987a
    public void a(C7984c c7984c) {
        this.c = c7984c;
        C7977c c7977c = new C7977c();
        this.d = c7977c;
        this.e = c7977c.a(c7984c);
    }

    @Override // com.youku.network.call.C7987a
    public void b() {
        this.f.cancelApiCall();
    }

    @Override // com.youku.network.call.C7987a
    public void b(InterfaceC7974a interfaceC7974a) {
        MtopBuilder mtopBuilder = this.e;
        if (mtopBuilder instanceof MtopBusiness) {
            ((MtopBusiness) mtopBuilder).registerListener((IRemoteListener) new C7992f(interfaceC7974a, C7987a.a, this.d));
        } else {
            mtopBuilder.addListener(new C7994h(interfaceC7974a, C7987a.a, this.d));
        }
        this.f = this.e.asyncRequest();
    }
}
