package com.alibaba.motu.tbrest.utils;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RC4 {
    private static final String RC4_PK = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class RC4Key {
        int[] state;
        int x;
        int y;

        private RC4Key() {
            this.state = new int[256];
        }
    }

    private static byte[] doRc4(byte[] bArr, RC4Key rC4Key) {
        if (bArr == null || rC4Key == null) {
            return null;
        }
        int i = rC4Key.x;
        int i2 = rC4Key.y;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            int[] iArr = rC4Key.state;
            i2 = (iArr[i] + i2) % 256;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            bArr[i3] = (byte) (iArr[(iArr[i] + iArr[i2]) % 256] ^ bArr[i3]);
        }
        rC4Key.x = i;
        rC4Key.y = i2;
        return bArr;
    }

    private static RC4Key prepareKey(String str) {
        if (str != null) {
            RC4Key rC4Key = new RC4Key();
            for (int i = 0; i < 256; i++) {
                rC4Key.state[i] = i;
            }
            rC4Key.x = 0;
            rC4Key.y = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                try {
                    char charAt = str.charAt(i2);
                    int[] iArr = rC4Key.state;
                    i3 = ((charAt + iArr[i4]) + i3) % 256;
                    int i5 = iArr[i4];
                    iArr[i4] = iArr[i3];
                    iArr[i3] = i5;
                    i2 = (i2 + 1) % str.length();
                } catch (Exception unused) {
                    return null;
                }
            }
            return rC4Key;
        }
        return null;
    }

    public static byte[] rc4(byte[] bArr) {
        return rc4(bArr, RC4_PK);
    }

    private static byte[] rc4(byte[] bArr, String str) {
        RC4Key prepareKey;
        if (bArr == null || str == null || (prepareKey = prepareKey(str)) == null) {
            return null;
        }
        return doRc4(bArr, prepareKey);
    }
}
