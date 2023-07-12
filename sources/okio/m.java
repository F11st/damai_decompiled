package okio;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class m {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    m f;
    m g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final void a() {
        m mVar = this.g;
        if (mVar != this) {
            if (mVar.e) {
                int i = this.c - this.b;
                if (i > (8192 - mVar.c) + (mVar.d ? 0 : mVar.b)) {
                    return;
                }
                g(mVar, i);
                b();
                n.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Nullable
    public final m b() {
        m mVar = this.f;
        m mVar2 = mVar != this ? mVar : null;
        m mVar3 = this.g;
        mVar3.f = mVar;
        this.f.g = mVar3;
        this.f = null;
        this.g = null;
        return mVar2;
    }

    public final m c(m mVar) {
        mVar.g = this;
        mVar.f = this.f;
        this.f.g = mVar;
        this.f = mVar;
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m d() {
        this.d = true;
        return new m(this.a, this.b, this.c, true, false);
    }

    public final m e(int i) {
        m b;
        if (i > 0 && i <= this.c - this.b) {
            if (i >= 1024) {
                b = d();
            } else {
                b = n.b();
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
    public final m f() {
        return new m((byte[]) this.a.clone(), this.b, this.c, false, true);
    }

    public final void g(m mVar, int i) {
        if (mVar.e) {
            int i2 = mVar.c;
            if (i2 + i > 8192) {
                if (!mVar.d) {
                    int i3 = mVar.b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = mVar.a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        mVar.c -= mVar.b;
                        mVar.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.a, this.b, mVar.a, mVar.c, i);
            mVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }
}
