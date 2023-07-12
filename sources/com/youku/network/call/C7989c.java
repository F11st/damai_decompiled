package com.youku.network.call;

import com.youku.network.C8004d;
import com.youku.network.InterfaceC7974a;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.c */
/* loaded from: classes13.dex */
public class C7989c {
    private C7987a a;
    private InterfaceC7991e b;

    public C7989c(C7987a c7987a) {
        this.a = c7987a;
        c();
    }

    private void c() {
        this.b = this.a instanceof C7993g ? new C7995i() : new C7996j();
    }

    public C8004d a() {
        b();
        C8004d a = this.a.a();
        a(a);
        return a;
    }

    public void a(InterfaceC7974a interfaceC7974a) {
        b();
        this.a.a(new C7990d(interfaceC7974a, this.b));
    }

    public void a(C8004d c8004d) {
        this.b.a(c8004d);
    }

    public void b() {
        this.b.a(this.a);
    }

    public void b(InterfaceC7974a interfaceC7974a) {
        b();
        this.a.b(new C7990d(interfaceC7974a, this.b));
    }
}
