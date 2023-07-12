package com.youku.network.call;

import com.youku.network.C8004d;
import com.youku.network.InterfaceC7974a;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.d */
/* loaded from: classes3.dex */
public class C7990d implements InterfaceC7974a {
    private InterfaceC7974a a;
    private InterfaceC7991e b;

    public C7990d(InterfaceC7974a interfaceC7974a, InterfaceC7991e interfaceC7991e) {
        this.a = interfaceC7974a;
        this.b = interfaceC7991e;
    }

    private void b(C8004d c8004d) {
        this.b.a(c8004d);
    }

    @Override // com.youku.network.InterfaceC7974a
    public void a(C8004d c8004d) {
        b(c8004d);
        InterfaceC7974a interfaceC7974a = this.a;
        if (interfaceC7974a != null) {
            interfaceC7974a.a(c8004d);
        }
    }
}
