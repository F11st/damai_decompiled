package tb;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class p43 implements BinaryDecoder, BinaryEncoder {
    public static final int b = 76;
    public static final int c = 64;
    protected final int a;
    protected byte[] d;
    protected int e;
    private int f;
    protected boolean g;
    protected int h;
    protected int i;

    /* JADX INFO: Access modifiers changed from: protected */
    public p43(int i, int i2, int i3, int i4) {
        this.a = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
    }

    private void a() {
        byte[] bArr = this.d;
        if (bArr == null) {
            this.d = new byte[i()];
            this.e = 0;
            this.f = 0;
            return;
        }
        byte[] bArr2 = new byte[bArr.length * 2];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.d = bArr2;
    }

    private void j() {
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.h = 0;
        this.i = 0;
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        byte[] bArr = this.d;
        if (bArr == null || bArr.length < this.e + i) {
            a();
        }
    }

    abstract void c(byte[] bArr, int i, int i2);

    abstract void d(byte[] bArr, int i, int i2);

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return h((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        j();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        d(bArr, 0, bArr.length);
        d(bArr, 0, -1);
        int i = this.e;
        byte[] bArr2 = new byte[i];
        g(bArr2, 0, i);
        return bArr2;
    }

    protected abstract boolean e(byte b2);

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        j();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        c(bArr, 0, bArr.length);
        c(bArr, 0, -1);
        int i = this.e - this.f;
        byte[] bArr2 = new byte[i];
        g(bArr2, 0, i);
        return bArr2;
    }

    int f() {
        if (this.d != null) {
            return this.e - this.f;
        }
        return 0;
    }

    int g(byte[] bArr, int i, int i2) {
        if (this.d == null) {
            return this.g ? -1 : 0;
        }
        int min = Math.min(f(), i2);
        System.arraycopy(this.d, this.f, bArr, i, min);
        int i3 = this.f + min;
        this.f = i3;
        if (i3 >= this.e) {
            this.d = null;
        }
        return min;
    }

    public byte[] h(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    protected int i() {
        return 8192;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || e(b2)) {
                return true;
            }
        }
        return false;
    }
}
