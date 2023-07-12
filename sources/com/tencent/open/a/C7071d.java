package com.tencent.open.a;

import java.io.IOException;
import okhttp3.AbstractC8829r;
import okhttp3.C8827q;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.a.d */
/* loaded from: classes11.dex */
class C7071d implements InterfaceC7075g {
    private C8827q a;
    private String b = null;
    private int c;
    private int d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7071d(C8827q c8827q, int i) {
        this.a = c8827q;
        this.d = i;
        this.c = c8827q.e();
        AbstractC8829r a = this.a.a();
        if (a != null) {
            this.e = (int) a.f();
        } else {
            this.e = 0;
        }
    }

    @Override // com.tencent.open.a.InterfaceC7075g
    public String a() throws IOException {
        if (this.b == null) {
            AbstractC8829r a = this.a.a();
            if (a != null) {
                this.b = a.k();
            }
            if (this.b == null) {
                this.b = "";
            }
        }
        return this.b;
    }

    @Override // com.tencent.open.a.InterfaceC7075g
    public int b() {
        return this.e;
    }

    @Override // com.tencent.open.a.InterfaceC7075g
    public int c() {
        return this.d;
    }

    @Override // com.tencent.open.a.InterfaceC7075g
    public int d() {
        return this.c;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + this.b + this.c + this.d + this.e;
    }
}
