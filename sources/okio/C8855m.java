package okio;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: okio.m */
/* loaded from: classes2.dex */
public final class C8855m {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    C8855m f;
    C8855m g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8855m() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final void a() {
        C8855m c8855m = this.g;
        if (c8855m != this) {
            if (c8855m.e) {
                int i = this.c - this.b;
                if (i > (8192 - c8855m.c) + (c8855m.d ? 0 : c8855m.b)) {
                    return;
                }
                g(c8855m, i);
                b();
                C8856n.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Nullable
    public final C8855m b() {
        C8855m c8855m = this.f;
        C8855m c8855m2 = c8855m != this ? c8855m : null;
        C8855m c8855m3 = this.g;
        c8855m3.f = c8855m;
        this.f.g = c8855m3;
        this.f = null;
        this.g = null;
        return c8855m2;
    }

    public final C8855m c(C8855m c8855m) {
        c8855m.g = this;
        c8855m.f = this.f;
        this.f.g = c8855m;
        this.f = c8855m;
        return c8855m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final C8855m d() {
        this.d = true;
        return new C8855m(this.a, this.b, this.c, true, false);
    }

    public final C8855m e(int i) {
        C8855m b;
        if (i > 0 && i <= this.c - this.b) {
            if (i >= 1024) {
                b = d();
            } else {
                b = C8856n.b();
                System.arraycopy(this.a, this.b, b.a, 0, i);
            }
            b.c = b.b + i;
            this.b += i;
            this.g.c(b);
            return b;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final C8855m f() {
        return new C8855m((byte[]) this.a.clone(), this.b, this.c, false, true);
    }

    public final void g(C8855m c8855m, int i) {
        if (c8855m.e) {
            int i2 = c8855m.c;
            if (i2 + i > 8192) {
                if (!c8855m.d) {
                    int i3 = c8855m.b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = c8855m.a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        c8855m.c -= c8855m.b;
                        c8855m.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.a, this.b, c8855m.a, c8855m.c, i);
            c8855m.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8855m(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }
}
