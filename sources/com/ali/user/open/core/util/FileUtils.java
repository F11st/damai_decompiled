package com.ali.user.open.core.util;

import android.content.Context;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FileUtils {
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r1 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readFileData(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.io.FileInputStream r1 = r3.openFileInput(r4)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
            int r3 = r1.available()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
            if (r3 <= 0) goto L1a
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
            r1.read(r3)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
            java.lang.String r2 = "UTF-8"
            r4.<init>(r3, r2)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
            r0 = r4
        L1a:
            r1.close()     // Catch: java.lang.Exception -> L29
            goto L29
        L1e:
            r3 = move-exception
            if (r1 == 0) goto L24
            r1.close()     // Catch: java.lang.Exception -> L24
        L24:
            throw r3
        L25:
            if (r1 == 0) goto L29
            goto L1a
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.open.core.util.FileUtils.readFileData(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void writeFileData(Context context, String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, 0);
            fileOutputStream.write(str2.getBytes(Charset.forName("UTF-8")));
            fileOutputStream.flush();
        } catch (Exception unused) {
            if (fileOutputStream == null) {
                return;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            fileOutputStream.close();
        } catch (Exception unused3) {
        }
    }
}
