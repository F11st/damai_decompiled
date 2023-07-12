package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class a {
    public static final a a = new a(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    private volatile int f82a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f83a;

    private a(byte[] bArr) {
        this.f83a = bArr;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static a a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new a(bArr2);
    }

    public int a() {
        return this.f83a.length;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m658a() {
        byte[] bArr = this.f83a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            byte[] bArr = this.f83a;
            int length = bArr.length;
            byte[] bArr2 = ((a) obj).f83a;
            if (length != bArr2.length) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f82a;
        if (i == 0) {
            byte[] bArr = this.f83a;
            int length = bArr.length;
            for (byte b : bArr) {
                length = (length * 31) + b;
            }
            i = length == 0 ? 1 : length;
            this.f82a = i;
        }
        return i;
    }
}
