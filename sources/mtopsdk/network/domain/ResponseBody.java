package mtopsdk.network.domain;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ResponseBody {
    private static final String TAG = "mtopsdk.ResponseBody";
    private byte[] bodyBytes = null;

    /* JADX WARN: Removed duplicated region for block: B:27:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] readBytes() throws java.io.IOException {
        /*
            r8 = this;
            long r0 = r8.contentLength()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L76
            java.io.InputStream r2 = r8.byteStream()
            r3 = 0
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r2.<init>()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L6d
        L1e:
            int r6 = r4.read(r5)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L6d
            r7 = -1
            if (r6 == r7) goto L2a
            r7 = 0
            r2.write(r5, r7, r6)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L6d
            goto L1e
        L2a:
            r2.flush()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L6d
            byte[] r5 = r2.toByteArray()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L6d
            mtopsdk.network.util.NetworkUtils.closeQuietly(r4)
            mtopsdk.network.util.NetworkUtils.closeQuietly(r2)
            goto L54
        L38:
            r5 = move-exception
            goto L46
        L3a:
            r0 = move-exception
            r2 = r3
            goto L6e
        L3d:
            r5 = move-exception
            r2 = r3
            goto L46
        L40:
            r0 = move-exception
            r2 = r3
            goto L6f
        L43:
            r5 = move-exception
            r2 = r3
            r4 = r2
        L46:
            java.lang.String r6 = "mtopsdk.ResponseBody"
            java.lang.String r7 = "[readBytes] read bytes from byteStream error."
            mtopsdk.common.util.TBSdkLog.e(r6, r7, r5)     // Catch: java.lang.Throwable -> L6d
            mtopsdk.network.util.NetworkUtils.closeQuietly(r4)
            mtopsdk.network.util.NetworkUtils.closeQuietly(r2)
            r5 = r3
        L54:
            if (r5 != 0) goto L57
            return r3
        L57:
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L6c
            int r2 = r5.length
            long r2 = (long) r2
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L64
            goto L6c
        L64:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Content-Length and stream length disagree"
            r0.<init>(r1)
            throw r0
        L6c:
            return r5
        L6d:
            r0 = move-exception
        L6e:
            r3 = r4
        L6f:
            mtopsdk.network.util.NetworkUtils.closeQuietly(r3)
            mtopsdk.network.util.NetworkUtils.closeQuietly(r2)
            throw r0
        L76:
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cannot buffer entire body for content length: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.network.domain.ResponseBody.readBytes():byte[]");
    }

    public abstract InputStream byteStream();

    public abstract long contentLength() throws IOException;

    public abstract String contentType();

    public byte[] getBytes() throws IOException {
        if (this.bodyBytes == null) {
            this.bodyBytes = readBytes();
        }
        return this.bodyBytes;
    }
}
