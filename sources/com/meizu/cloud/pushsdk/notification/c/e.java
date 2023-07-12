package com.meizu.cloud.pushsdk.notification.c;

import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e {
    private final File a;
    private final File b;
    private final String c;

    public e(String str, String str2) {
        File file = new File(str);
        this.a = file;
        File file2 = new File(str2);
        this.b = file2;
        this.c = file2.getAbsolutePath();
        DebugLogger.i("ZipExtractTask", "Extract mInput file = " + file.toString());
        DebugLogger.i("ZipExtractTask", "Extract mOutput file = " + file2.toString());
    }

    private int a(InputStream inputStream, OutputStream outputStream) {
        StringBuilder sb;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        int i = 0;
        while (true) {
            try {
                try {
                    int read = bufferedInputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    i += read;
                } catch (IOException e) {
                    DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e.toString());
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                        DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e2.toString());
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("in.close() IOException e=");
                        sb.append(e.toString());
                        DebugLogger.e("ZipExtractTask", sb.toString());
                        return i;
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e4.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    DebugLogger.e("ZipExtractTask", "in.close() IOException e=" + e5.toString());
                }
                throw th;
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e6) {
            DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e6.toString());
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e7) {
            e = e7;
            sb = new StringBuilder();
            sb.append("in.close() IOException e=");
            sb.append(e.toString());
            DebugLogger.e("ZipExtractTask", sb.toString());
            return i;
        }
        return i;
    }

    private void b() {
        StringBuilder sb;
        String str;
        File file = this.a;
        if (file == null || !file.exists()) {
            return;
        }
        if (this.a.delete()) {
            sb = new StringBuilder();
            str = "Delete file:";
        } else {
            sb = new StringBuilder();
            str = "Can't delete file:";
        }
        sb.append(str);
        sb.append(this.a.toString());
        sb.append(" after extracted.");
        DebugLogger.i("ZipExtractTask", sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r13 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
        r7 = r13.split("/")[0];
        com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract temp directory=" + r18.b + "/" + r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long c() {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.notification.c.e.c():long");
    }

    public boolean a() {
        return c() > 0;
    }
}
