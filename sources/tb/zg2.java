package tb;

import com.taobao.tcommon.core.BytesPool;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zg2 {
    public static ne0 a(InputStream inputStream, BytesPool bytesPool, int[] iArr) throws Exception {
        yg2 yg2Var = new yg2(null, iArr[0], 0);
        try {
            b(inputStream, bytesPool, yg2Var);
            iArr[0] = yg2Var.b();
            return yg2Var.a();
        } catch (Throwable th) {
            iArr[0] = yg2Var.b();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.io.InputStream r10, com.taobao.tcommon.core.BytesPool r11, tb.yg2 r12) throws java.lang.Exception {
        /*
            r0 = 8192(0x2000, float:1.148E-41)
            if (r11 == 0) goto L9
            byte[] r0 = r11.offer(r0)
            goto Lb
        L9:
            byte[] r0 = new byte[r0]
        Lb:
            int r1 = r12.d
            java.lang.String r2 = "Stream"
            r3 = 0
            r4 = 1
            r5 = 0
            if (r1 <= 0) goto L35
            if (r11 == 0) goto L1e
            byte[] r1 = r11.offer(r1)     // Catch: java.lang.OutOfMemoryError -> L26
            r9 = r3
            r3 = r1
            r1 = r9
            goto L36
        L1e:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.OutOfMemoryError -> L26
            int r6 = r12.d     // Catch: java.lang.OutOfMemoryError -> L26
            r1.<init>(r6)     // Catch: java.lang.OutOfMemoryError -> L26
            goto L36
        L26:
            java.lang.Object[] r1 = new java.lang.Object[r4]
            int r6 = r12.d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1[r5] = r6
            java.lang.String r6 = "allocate byte array OOM with content length=%d"
            tb.xt2.c(r2, r6, r1)
        L35:
            r1 = r3
        L36:
            if (r3 != 0) goto L42
            if (r1 != 0) goto L42
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r6 = 32768(0x8000, float:4.5918E-41)
            r1.<init>(r6)
        L42:
            int r6 = r10.read(r0)     // Catch: java.lang.Throwable -> L96
            r7 = -1
            if (r6 == r7) goto L64
            boolean r8 = r12.c(r6)     // Catch: java.lang.Throwable -> L96
            if (r8 == 0) goto L64
            if (r1 == 0) goto L55
            r1.write(r0, r5, r6)     // Catch: java.lang.Throwable -> L96
            goto L5c
        L55:
            int r8 = r12.b()     // Catch: java.lang.Throwable -> L96
            java.lang.System.arraycopy(r0, r5, r3, r8, r6)     // Catch: java.lang.Throwable -> L96
        L5c:
            boolean r8 = r12.f(r6)     // Catch: java.lang.Throwable -> L96
            if (r8 != 0) goto L42
            r8 = 1
            goto L65
        L64:
            r8 = 0
        L65:
            if (r8 != 0) goto L88
            if (r1 == 0) goto L6e
            byte[] r1 = r1.toByteArray()     // Catch: java.lang.Throwable -> L96
            goto L6f
        L6e:
            r1 = r3
        L6f:
            r12.g(r1)     // Catch: java.lang.Throwable -> L96
            if (r6 == r7) goto L87
            java.lang.String r1 = "read bytes incorrect, exceed content-length=%d"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L84
            int r12 = r12.d     // Catch: java.lang.Throwable -> L84
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L84
            r4[r5] = r12     // Catch: java.lang.Throwable -> L84
            tb.xt2.i(r2, r1, r4)     // Catch: java.lang.Throwable -> L84
            goto L87
        L84:
            r12 = move-exception
            r4 = 0
            goto L97
        L87:
            r4 = 0
        L88:
            if (r11 == 0) goto L92
            r11.release(r0)
            if (r4 == 0) goto L92
            r11.release(r3)
        L92:
            r10.close()     // Catch: java.lang.Throwable -> L95
        L95:
            return
        L96:
            r12 = move-exception
        L97:
            if (r11 == 0) goto La1
            r11.release(r0)
            if (r4 == 0) goto La1
            r11.release(r3)
        La1:
            r10.close()     // Catch: java.lang.Throwable -> La4
        La4:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.zg2.b(java.io.InputStream, com.taobao.tcommon.core.BytesPool, tb.yg2):void");
    }
}
