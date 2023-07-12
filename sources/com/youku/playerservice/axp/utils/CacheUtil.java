package com.youku.playerservice.axp.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CacheUtil {
    /* JADX WARN: Removed duplicated region for block: B:55:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getM3u8File(java.lang.String r6) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r6]     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r3.<init>()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
        Lf:
            r4 = 0
            int r5 = r1.read(r2, r4, r6)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L62
            if (r5 <= 0) goto L1a
            r3.write(r2, r4, r5)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L62
            goto Lf
        L1a:
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L62
            byte[] r2 = r3.toByteArray()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L62
            r6.<init>(r2)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L62
            r1.close()     // Catch: java.io.IOException -> L27
            goto L2b
        L27:
            r0 = move-exception
            r0.printStackTrace()
        L2b:
            r3.close()     // Catch: java.io.IOException -> L2f
            goto L33
        L2f:
            r0 = move-exception
            r0.printStackTrace()
        L33:
            return r6
        L34:
            r6 = move-exception
            goto L42
        L36:
            r6 = move-exception
            r3 = r0
            goto L63
        L39:
            r6 = move-exception
            r3 = r0
            goto L42
        L3c:
            r6 = move-exception
            r3 = r0
            goto L64
        L3f:
            r6 = move-exception
            r1 = r0
            r3 = r1
        L42:
            java.lang.StackTraceElement[] r6 = r6.getStackTrace()     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L62
            com.youku.playerservice.axp.utils.TLogUtil.playLog(r6)     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r6 = move-exception
            r6.printStackTrace()
        L57:
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L61
        L5d:
            r6 = move-exception
            r6.printStackTrace()
        L61:
            return r0
        L62:
            r6 = move-exception
        L63:
            r0 = r1
        L64:
            if (r0 == 0) goto L6e
            r0.close()     // Catch: java.io.IOException -> L6a
            goto L6e
        L6a:
            r0 = move-exception
            r0.printStackTrace()
        L6e:
            if (r3 == 0) goto L78
            r3.close()     // Catch: java.io.IOException -> L74
            goto L78
        L74:
            r0 = move-exception
            r0.printStackTrace()
        L78:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.utils.CacheUtil.getM3u8File(java.lang.String):java.lang.String");
    }

    public static String readFile(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        readToBuffer(stringBuffer, str);
        return stringBuffer.toString();
    }

    public static void readToBuffer(StringBuffer stringBuffer, String str) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(StringUtils.LF);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
