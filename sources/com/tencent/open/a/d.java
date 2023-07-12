package com.tencent.open.a;

import java.io.IOException;
import okhttp3.q;
import okhttp3.r;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class d implements g {
    private q a;
    private String b = null;
    private int c;
    private int d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(q qVar, int i) {
        this.a = qVar;
        this.d = i;
        this.c = qVar.e();
        r a = this.a.a();
        if (a != null) {
            this.e = (int) a.f();
        } else {
            this.e = 0;
        }
    }

    @Override // com.tencent.open.a.g
    public String a() throws IOException {
        if (this.b == null) {
            r a = this.a.a();
            if (a != null) {
                this.b = a.k();
            }
            if (this.b == null) {
                this.b = "";
            }
        }
        return this.b;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.e;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.d;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.c;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + this.b + this.c + this.d + this.e;
    }
}
