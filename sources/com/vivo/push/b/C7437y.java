package com.vivo.push.b;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.y */
/* loaded from: classes11.dex */
public final class C7437y extends AbstractC7496o {
    private String a;

    public C7437y(String str) {
        super(2008);
        this.a = str;
    }

    @Override // com.vivo.push.AbstractC7496o
    protected final void c(C7410a c7410a) {
        c7410a.a("package_name", this.a);
    }

    @Override // com.vivo.push.AbstractC7496o
    protected final void d(C7410a c7410a) {
        this.a = c7410a.a("package_name");
    }

    @Override // com.vivo.push.AbstractC7496o
    public final String toString() {
        return "StopServiceCommand";
    }

    public C7437y() {
        super(2008);
    }
}
