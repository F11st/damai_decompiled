package com.meizu.cloud.pushsdk.c.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.g.j */
/* loaded from: classes10.dex */
public final class C5990j {
    final byte[] a;
    int b;
    int c;
    boolean d;
    final boolean e;
    C5990j f;
    C5990j g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5990j() {
        this.a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5990j(C5990j c5990j) {
        this(c5990j.a, c5990j.b, c5990j.c);
    }

    C5990j(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public C5990j a() {
        C5990j c5990j = this.f;
        C5990j c5990j2 = c5990j != this ? c5990j : null;
        C5990j c5990j3 = this.g;
        c5990j3.f = c5990j;
        this.f.g = c5990j3;
        this.f = null;
        this.g = null;
        return c5990j2;
    }

    public C5990j a(int i) {
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        C5990j c5990j = new C5990j(this);
        c5990j.c = c5990j.b + i;
        this.b += i;
        this.g.a(c5990j);
        return c5990j;
    }

    public C5990j a(C5990j c5990j) {
        c5990j.g = this;
        c5990j.f = this.f;
        this.f.g = c5990j;
        this.f = c5990j;
        return c5990j;
    }

    public void a(C5990j c5990j, int i) {
        if (!c5990j.e) {
            throw new IllegalArgumentException();
        }
        int i2 = c5990j.c;
        if (i2 + i > 2048) {
            if (c5990j.d) {
                throw new IllegalArgumentException();
            }
            int i3 = c5990j.b;
            if ((i2 + i) - i3 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = c5990j.a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            c5990j.c -= c5990j.b;
            c5990j.b = 0;
        }
        System.arraycopy(this.a, this.b, c5990j.a, c5990j.c, i);
        c5990j.c += i;
        this.b += i;
    }

    public void b() {
        C5990j c5990j = this.g;
        if (c5990j == this) {
            throw new IllegalStateException();
        }
        if (c5990j.e) {
            int i = this.c - this.b;
            if (i > (2048 - c5990j.c) + (c5990j.d ? 0 : c5990j.b)) {
                return;
            }
            a(c5990j, i);
            a();
            C5991k.a(this);
        }
    }
}
