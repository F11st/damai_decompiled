package okhttp3.internal.ws;

import okio.Buffer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class a {
    static String a(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): " + i;
        } else if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        } else {
            return "Code " + i + " is reserved and may not be used.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Buffer.c cVar, byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = cVar.e;
            int i2 = cVar.f;
            int i3 = cVar.g;
            while (i2 < i3) {
                int i4 = i % length;
                bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                i2++;
                i = i4 + 1;
            }
        } while (cVar.a() != -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(int i) {
        String a = a(i);
        if (a != null) {
            throw new IllegalArgumentException(a);
        }
    }
}
