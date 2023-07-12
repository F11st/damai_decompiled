package com.vivo.push.b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class y extends com.vivo.push.o {
    private String a;

    public y(String str) {
        super(2008);
        this.a = str;
    }

    @Override // com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.a);
    }

    @Override // com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("package_name");
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "StopServiceCommand";
    }

    public y() {
        super(2008);
    }
}
