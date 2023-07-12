package tb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class he implements Comparable<he> {
    final byte[] a;
    int b;
    int c;

    private he(byte[] bArr, int i) {
        bArr = bArr == null ? new byte[i] : bArr;
        this.a = bArr;
        this.b = bArr.length;
        this.c = i;
    }

    public static he b(int i) {
        return new he(null, i);
    }

    public static he g(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return h(bArr, bArr.length);
    }

    public static he h(byte[] bArr, int i) {
        if (bArr == null || i < 0 || i > bArr.length) {
            return null;
        }
        return new he(bArr, i);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(he heVar) {
        int i = this.b;
        int i2 = heVar.b;
        if (i == i2) {
            if (this.a == null) {
                return -1;
            }
            if (heVar.a == null) {
                return 1;
            }
            return hashCode() - heVar.hashCode();
        }
        return i - i2;
    }

    public byte[] c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public int e(InputStream inputStream) throws IOException {
        int read = inputStream.read(this.a, 0, this.b);
        this.c = read != -1 ? read : 0;
        return read;
    }

    public void f() {
        if (this.b == 0) {
            return;
        }
        je.a().b(this);
    }

    public void i(OutputStream outputStream) throws IOException {
        outputStream.write(this.a, 0, this.c);
    }
}
