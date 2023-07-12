package com.youku.network.call;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class c {
    private a a;
    private e b;

    public c(a aVar) {
        this.a = aVar;
        c();
    }

    private void c() {
        this.b = this.a instanceof g ? new i() : new j();
    }

    public com.youku.network.d a() {
        b();
        com.youku.network.d a = this.a.a();
        a(a);
        return a;
    }

    public void a(com.youku.network.a aVar) {
        b();
        this.a.a(new d(aVar, this.b));
    }

    public void a(com.youku.network.d dVar) {
        this.b.a(dVar);
    }

    public void b() {
        this.b.a(this.a);
    }

    public void b(com.youku.network.a aVar) {
        b();
        this.a.b(new d(aVar, this.b));
    }
}
