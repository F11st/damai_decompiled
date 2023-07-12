package com.alipay.sdk.m.l0;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.l0.e */
/* loaded from: classes12.dex */
public class C4240e {

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.l0.e$b */
    /* loaded from: classes12.dex */
    public static class C4242b {
        public int[] a;
        public int b;
        public int c;

        public C4242b() {
            this.a = new int[256];
        }
    }

    public static byte[] a(byte[] bArr) {
        C4242b a;
        if (bArr == null || (a = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, a);
    }

    public static C4242b a(String str) {
        if (str != null) {
            C4242b c4242b = new C4242b();
            for (int i = 0; i < 256; i++) {
                c4242b.a[i] = i;
            }
            c4242b.b = 0;
            c4242b.c = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                try {
                    char charAt = str.charAt(i2);
                    int[] iArr = c4242b.a;
                    i3 = ((charAt + iArr[i4]) + i3) % 256;
                    int i5 = iArr[i4];
                    iArr[i4] = iArr[i3];
                    iArr[i3] = i5;
                    i2 = (i2 + 1) % str.length();
                } catch (Exception unused) {
                    return null;
                }
            }
            return c4242b;
        }
        return null;
    }

    public static byte[] a(byte[] bArr, C4242b c4242b) {
        if (bArr == null || c4242b == null) {
            return null;
        }
        int i = c4242b.b;
        int i2 = c4242b.c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            int[] iArr = c4242b.a;
            i2 = (iArr[i] + i2) % 256;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            bArr[i3] = (byte) (iArr[(iArr[i] + iArr[i2]) % 256] ^ bArr[i3]);
        }
        c4242b.b = i;
        c4242b.c = i2;
        return bArr;
    }
}
