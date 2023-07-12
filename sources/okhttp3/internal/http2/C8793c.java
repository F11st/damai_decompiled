package okhttp3.internal.http2;

import com.youku.upsplayer.util.YKUpsConvert;
import java.io.IOException;
import okhttp3.internal.C8753a;
import okio.ByteString;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.c */
/* loaded from: classes2.dex */
public final class C8793c {
    static final ByteString a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] c = new String[64];
    static final String[] d = new String[256];

    static {
        String[] strArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr2 = d;
            if (i2 >= strArr2.length) {
                break;
            }
            strArr2[i2] = C8753a.q("%8s", Integer.toBinaryString(i2)).replace(' ', YKUpsConvert.CHAR_ZERO);
            i2++;
        }
        String[] strArr3 = c;
        strArr3[0] = "";
        strArr3[1] = "END_STREAM";
        int[] iArr = {1};
        strArr3[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            c[i4 | 8] = strArr[i4] + "|PADDED";
        }
        String[] strArr4 = c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = c;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = c;
            if (i >= strArr6.length) {
                return;
            }
            if (strArr6[i] == null) {
                strArr6[i] = d[i];
            }
            i++;
        }
    }

    private C8793c() {
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : d[b3];
            } else if (b2 != 7 && b2 != 8) {
                String[] strArr = c;
                String str = b3 < strArr.length ? strArr[b3] : d[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return d[b3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = b;
        String q = b2 < strArr.length ? strArr[b2] : C8753a.q("0x%02x", Byte.valueOf(b2));
        String a2 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = q;
        objArr[4] = a2;
        return C8753a.q("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(C8753a.q(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(C8753a.q(str, objArr));
    }
}
