package tb;

import java.nio.charset.Charset;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class sy {
    private int a;
    private int[] b;
    private int[] c;
    private int[] d;
    private byte[] e;
    private int f;
    private int g;
    private int h;
    private int i;

    private void a() {
        if (pe.d(this.e, this.f) == 1718843492) {
            int b = pe.b(this.e, this.f + 4);
            if (b <= 1) {
                int d = pe.d(this.e, this.f + 8);
                this.i = d;
                if (this.f + d <= this.e.length) {
                    return;
                }
                throw new IllegalArgumentException("Invalid binary, offset: " + this.f + "+ fileLen: " + this.i + " > bytes.length: " + this.e.length);
            }
            throw new IllegalArgumentException("Invalid binary, newer format not support: " + b);
        }
        throw new IllegalArgumentException("Invalid binary, invalid magic number");
    }

    public byte[] b() {
        return this.e;
    }

    public az c(int i) {
        int i2 = this.b[i];
        int d = pe.d(this.e, this.f + i2);
        if (d == 0) {
            return az.N(new String(this.e, this.f + i2 + 8, pe.d(this.e, (this.f + i2) + 4) - 1, Charset.forName("UTF-8")));
        }
        throw new IllegalArgumentException("not support const type:" + d);
    }

    public int d() {
        return this.g;
    }

    public int e(int i) {
        return this.d[i];
    }

    public int f(int i) {
        return this.c[i] + this.f;
    }

    public void g(byte[] bArr, int i) {
        this.e = bArr;
        this.f = i;
        a();
        int d = pe.d(bArr, i + 12);
        int i2 = 0;
        while (true) {
            if (i2 >= d) {
                break;
            }
            int i3 = i + 16 + (i2 * 12);
            if (pe.d(bArr, i3) == 1) {
                this.a = pe.d(bArr, i3 + 4);
                break;
            }
            i2++;
        }
        if (this.a != 0) {
            int i4 = i + 16 + (d * 12);
            int d2 = pe.d(bArr, i4);
            this.h = d2;
            if (d2 != 0) {
                this.c = new int[d2];
                this.d = new int[d2];
                for (int i5 = 0; i5 < this.h; i5++) {
                    int i6 = i4 + 4;
                    int i7 = i5 * 8;
                    this.c[i5] = pe.d(bArr, i6 + i7);
                    this.d[i5] = pe.d(bArr, i6 + 4 + i7);
                }
                int d3 = pe.d(bArr, this.a + i);
                this.g = d3;
                this.b = new int[d3];
                for (int i8 = 0; i8 < this.g; i8++) {
                    this.b[i8] = pe.d(bArr, this.a + i + 4 + (i8 * 4));
                }
                return;
            }
            throw new IllegalArgumentException("Empty binary, 0 expression");
        }
        throw new IllegalArgumentException("Invalid binary, no const section");
    }
}
