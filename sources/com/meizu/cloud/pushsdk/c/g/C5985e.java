package com.meizu.cloud.pushsdk.c.g;

import com.huawei.hms.opendevice.AbstractC5658c;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.g.e */
/* loaded from: classes10.dex */
public class C5985e implements Serializable, Comparable<C5985e> {
    static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final C5985e b = a(new byte[0]);
    private static final long serialVersionUID = 1;
    final byte[] c;
    transient int d;
    transient String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5985e(byte[] bArr) {
        this.c = bArr;
    }

    public static C5985e a(InputStream inputStream, int i) throws IOException {
        if (inputStream != null) {
            if (i < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + i);
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new C5985e(bArr);
        }
        throw new IllegalArgumentException("in == null");
    }

    public static C5985e a(String str) {
        if (str != null) {
            C5985e c5985e = new C5985e(str.getBytes(C5995o.a));
            c5985e.e = str;
            return c5985e;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static C5985e a(byte... bArr) {
        if (bArr != null) {
            return new C5985e((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private C5985e b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        C5985e a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = C5985e.class.getDeclaredField(AbstractC5658c.a);
            declaredField.setAccessible(true);
            declaredField.set(this, a2.c);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }

    public byte a(int i) {
        return this.c[i];
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C5985e c5985e) {
        int d = d();
        int d2 = c5985e.d();
        int min = Math.min(d, d2);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & 255;
            int a3 = c5985e.a(i) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (d == d2) {
            return 0;
        }
        return d < d2 ? -1 : 1;
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, C5995o.a);
        this.e = str2;
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C5982b c5982b) {
        byte[] bArr = this.c;
        c5982b.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.c;
        return i <= bArr2.length - i3 && i2 <= bArr.length - i3 && C5995o.a(bArr2, i, bArr, i2, i3);
    }

    public C5985e b() {
        return b(MessageDigestAlgorithms.MD5);
    }

    public String c() {
        byte[] bArr = this.c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public int d() {
        return this.c.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5985e) {
            C5985e c5985e = (C5985e) obj;
            int d = c5985e.d();
            byte[] bArr = this.c;
            if (d == bArr.length && c5985e.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.c);
        this.d = hashCode;
        return hashCode;
    }

    public String toString() {
        byte[] bArr = this.c;
        return bArr.length == 0 ? "ByteString[size=0]" : bArr.length <= 16 ? String.format("ByteString[size=%s data=%s]", Integer.valueOf(bArr.length), c()) : String.format("ByteString[size=%s md5=%s]", Integer.valueOf(bArr.length), b().c());
    }
}
