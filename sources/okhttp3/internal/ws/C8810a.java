package okhttp3.internal.ws;

import okio.Buffer;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.ws.a */
/* loaded from: classes2.dex */
public final class C8810a {
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
    public static void b(Buffer.C8836c c8836c, byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = c8836c.e;
            int i2 = c8836c.f;
            int i3 = c8836c.g;
            while (i2 < i3) {
                int i4 = i % length;
                bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                i2++;
                i = i4 + 1;
            }
        } while (c8836c.a() != -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(int i) {
        String a = a(i);
        if (a != null) {
            throw new IllegalArgumentException(a);
        }
    }
}
