package tb;

import com.youku.upsplayer.util.YKUpsConvert;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class td1 {
    private static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};

    private static final String a(byte[] bArr) {
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static String b(String str) {
        try {
            return a(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r6, java.lang.String r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L8
            r6 = 1
            return r6
        L8:
            java.lang.String r6 = r6.toLowerCase()
            r0 = 0
            if (r7 != 0) goto L10
            return r0
        L10:
            r1 = 0
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            java.nio.channels.FileChannel r1 = r3.getChannel()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
            r7 = 102400(0x19000, float:1.43493E-40)
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r7)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
        L27:
            int r4 = r1.read(r7)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
            r5 = -1
            if (r4 == r5) goto L3e
            byte[] r5 = r7.array()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
            r2.update(r5, r0, r4)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
            r7.position(r0)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
            r4 = 1
            java.lang.Thread.sleep(r4)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
            goto L27
        L3e:
            byte[] r7 = r2.digest()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
            java.lang.String r7 = a(r7)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
            boolean r6 = r7.equals(r6)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5f
            r3.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r7 = move-exception
            r7.printStackTrace()
        L52:
            r1.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r7 = move-exception
            r7.printStackTrace()
        L5a:
            return r6
        L5b:
            r6 = move-exception
            r7 = r1
            r1 = r3
            goto L81
        L5f:
            r6 = move-exception
            r7 = r1
            r1 = r3
            goto L68
        L63:
            r6 = move-exception
            r7 = r1
            goto L81
        L66:
            r6 = move-exception
            r7 = r1
        L68:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L80
            if (r1 == 0) goto L75
            r1.close()     // Catch: java.io.IOException -> L71
            goto L75
        L71:
            r6 = move-exception
            r6.printStackTrace()
        L75:
            if (r7 == 0) goto L7f
            r7.close()     // Catch: java.io.IOException -> L7b
            goto L7f
        L7b:
            r6 = move-exception
            r6.printStackTrace()
        L7f:
            return r0
        L80:
            r6 = move-exception
        L81:
            if (r1 == 0) goto L8b
            r1.close()     // Catch: java.io.IOException -> L87
            goto L8b
        L87:
            r0 = move-exception
            r0.printStackTrace()
        L8b:
            if (r7 == 0) goto L95
            r7.close()     // Catch: java.io.IOException -> L91
            goto L95
        L91:
            r7 = move-exception
            r7.printStackTrace()
        L95:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.td1.c(java.lang.String, java.lang.String):boolean");
    }
}
