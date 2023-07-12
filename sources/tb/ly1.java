package tb;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ly1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class b {
        int[] a;
        int b;
        int c;

        private b() {
            this.a = new int[256];
        }
    }

    private static byte[] a(byte[] bArr, b bVar) {
        if (bArr == null || bVar == null) {
            return null;
        }
        int i = bVar.b;
        int i2 = bVar.c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            int[] iArr = bVar.a;
            i2 = (iArr[i] + i2) % 256;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            bArr[i3] = (byte) (iArr[(iArr[i] + iArr[i2]) % 256] ^ bArr[i3]);
        }
        bVar.b = i;
        bVar.c = i2;
        return bArr;
    }

    private static b b(String str) {
        if (str != null) {
            b bVar = new b();
            for (int i = 0; i < 256; i++) {
                bVar.a[i] = i;
            }
            bVar.b = 0;
            bVar.c = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                try {
                    char charAt = str.charAt(i2);
                    int[] iArr = bVar.a;
                    i3 = ((charAt + iArr[i4]) + i3) % 256;
                    int i5 = iArr[i4];
                    iArr[i4] = iArr[i3];
                    iArr[i3] = i5;
                    i2 = (i2 + 1) % str.length();
                } catch (Exception unused) {
                    return null;
                }
            }
            return bVar;
        }
        return null;
    }

    public static byte[] c(byte[] bArr) {
        return d(bArr, "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
    }

    private static byte[] d(byte[] bArr, String str) {
        b b2;
        if (bArr == null || str == null || (b2 = b(str)) == null) {
            return null;
        }
        return a(bArr, b2);
    }
}
