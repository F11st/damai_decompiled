package com.ta.audid.utils;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RC4 {
    private static final String RC4_PK = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.ta.audid.utils.RC4$b */
    /* loaded from: classes7.dex */
    public static class C6246b {
        public int[] a;
        public int b;
        public int c;

        private C6246b() {
            this.a = new int[256];
        }
    }

    private static C6246b prepareKey(String str) {
        if (str != null) {
            C6246b c6246b = new C6246b();
            for (int i = 0; i < 256; i++) {
                c6246b.a[i] = i;
            }
            c6246b.b = 0;
            c6246b.c = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                try {
                    char charAt = str.charAt(i2);
                    int[] iArr = c6246b.a;
                    i3 = ((charAt + iArr[i4]) + i3) % 256;
                    int i5 = iArr[i4];
                    iArr[i4] = iArr[i3];
                    iArr[i3] = i5;
                    i2 = (i2 + 1) % str.length();
                } catch (Exception unused) {
                    return null;
                }
            }
            return c6246b;
        }
        return null;
    }

    public static byte[] rc4(byte[] bArr) {
        C6246b prepareKey;
        if (bArr == null || (prepareKey = prepareKey(RC4_PK)) == null) {
            return null;
        }
        return rc4(bArr, prepareKey);
    }

    private static byte[] rc4(byte[] bArr, C6246b c6246b) {
        if (bArr == null || c6246b == null) {
            return null;
        }
        int i = c6246b.b;
        int i2 = c6246b.c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            int[] iArr = c6246b.a;
            i2 = (iArr[i] + i2) % 256;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            bArr[i3] = (byte) (iArr[(iArr[i] + iArr[i2]) % 256] ^ bArr[i3]);
        }
        c6246b.b = i;
        c6246b.c = i2;
        return bArr;
    }
}
