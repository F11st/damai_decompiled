package com.alipay.euler.andfix.util;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FileUtil {
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void copyFile(java.io.File r11, java.io.File r12) throws java.io.IOException {
        /*
            java.lang.String r0 = ", dest="
            java.lang.String r1 = "FileUtil"
            r2 = 0
            boolean r3 = r12.exists()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L91
            if (r3 != 0) goto Le
            r12.createNewFile()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L91
        Le:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L91
            r3.<init>(r11)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L91
            java.nio.channels.FileChannel r3 = r3.getChannel()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L91
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            r4.<init>(r12)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            r5 = 0
            long r7 = r3.size()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            r4 = r3
            r9 = r2
            r4.transferTo(r5, r7, r9)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            r4.<init>()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            java.lang.String r5 = "copyFile(src="
            r4.append(r5)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            r4.append(r11)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            r4.append(r0)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            r4.append(r12)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            com.alipay.euler.andfix.log.Log.i(r1, r4)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L58
            r3.close()
            if (r2 == 0) goto L52
            r2.close()
        L52:
            return
        L53:
            r4 = move-exception
            r10 = r3
            r3 = r2
            r2 = r10
            goto L5f
        L58:
            r11 = move-exception
            r0 = r2
            r2 = r3
            goto L93
        L5c:
            r3 = move-exception
            r4 = r3
            r3 = r2
        L5f:
            r12.delete()     // Catch: java.lang.Throwable -> L8f
            com.alipay.euler.andfix.log.Log.e(r1, r4)     // Catch: java.lang.Throwable -> L8f
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L8f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r5.<init>()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r6 = "Failed to copy file[src="
            r5.append(r6)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r11 = r11.getAbsolutePath()     // Catch: java.lang.Throwable -> L8f
            r5.append(r11)     // Catch: java.lang.Throwable -> L8f
            r5.append(r0)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r11 = r12.getAbsolutePath()     // Catch: java.lang.Throwable -> L8f
            r5.append(r11)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r11 = "]"
            r5.append(r11)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r11 = r5.toString()     // Catch: java.lang.Throwable -> L8f
            r1.<init>(r11, r4)     // Catch: java.lang.Throwable -> L8f
            throw r1     // Catch: java.lang.Throwable -> L8f
        L8f:
            r11 = move-exception
            goto L9c
        L91:
            r11 = move-exception
            r0 = r2
        L93:
            r12.delete()     // Catch: java.lang.Throwable -> L9a
            com.alipay.euler.andfix.log.Log.e(r1, r11)     // Catch: java.lang.Throwable -> L9a
            throw r11     // Catch: java.lang.Throwable -> L9a
        L9a:
            r11 = move-exception
            r3 = r0
        L9c:
            if (r2 == 0) goto La1
            r2.close()
        La1:
            if (r3 == 0) goto La6
            r3.close()
        La6:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.euler.andfix.util.FileUtil.copyFile(java.io.File, java.io.File):void");
    }

    public static boolean deleteFile(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteFile(file2);
                }
            }
            return file.delete();
        }
        return true;
    }
}
