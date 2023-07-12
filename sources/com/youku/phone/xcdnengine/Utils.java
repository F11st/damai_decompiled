package com.youku.phone.xcdnengine;

import android.text.TextUtils;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.io.File;
import java.net.URL;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class Utils {
    private static final String DEBUG_VERSION = "1.1.20210101.1";
    private static final String TAG = "XcdnEngine";

    /* JADX WARN: Removed duplicated region for block: B:41:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean copFile(java.lang.String r11, java.lang.String r12) {
        /*
            r0 = 0
            r1 = 0
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            r3.<init>(r11)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            r4.<init>(r12)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            java.nio.channels.FileChannel r1 = r3.getChannel()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            r6 = 0
            long r8 = r2.size()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            r4 = r1
            r5 = r2
            long r3 = r4.transferFrom(r5, r6, r8)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            long r11 = r2.size()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            int r5 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r5 != 0) goto L36
            r0 = 1
        L36:
            r2.close()     // Catch: java.lang.Exception -> L39
        L39:
            r1.close()     // Catch: java.lang.Exception -> L3c
        L3c:
            return r0
        L3d:
            r11 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
            goto L80
        L42:
            r3 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
            goto L4c
        L47:
            r11 = move-exception
            r2 = r1
            goto L80
        L4a:
            r3 = move-exception
            r2 = r1
        L4c:
            java.lang.String r4 = "XcdnEngine"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f
            r5.<init>()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r6 = "copy file from "
            r5.append(r6)     // Catch: java.lang.Throwable -> L7f
            r5.append(r11)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r11 = " to "
            r5.append(r11)     // Catch: java.lang.Throwable -> L7f
            r5.append(r12)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r11 = " failed : "
            r5.append(r11)     // Catch: java.lang.Throwable -> L7f
            r5.append(r3)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r11 = r5.toString()     // Catch: java.lang.Throwable -> L7f
            com.taobao.tlog.adapter.AdapterForTLog.loge(r4, r11)     // Catch: java.lang.Throwable -> L7f
            if (r1 == 0) goto L79
            r1.close()     // Catch: java.lang.Exception -> L78
            goto L79
        L78:
        L79:
            if (r2 == 0) goto L7e
            r2.close()     // Catch: java.lang.Exception -> L7e
        L7e:
            return r0
        L7f:
            r11 = move-exception
        L80:
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.lang.Exception -> L86
            goto L87
        L86:
        L87:
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.lang.Exception -> L8c
        L8c:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.phone.xcdnengine.Utils.copFile(java.lang.String, java.lang.String):boolean");
    }

    public static String getDomain(String str) {
        try {
            return new URL(str).getHost();
        } catch (Throwable unused) {
            return "-1";
        }
    }

    public static String getFileName(String str) {
        return new File(str).getName();
    }

    public static String getVersion(String str) {
        try {
            int lastIndexOf = str.lastIndexOf("-");
            if (lastIndexOf > -1) {
                str = str.substring(0, lastIndexOf);
            }
            String[] split = str.split("\\.");
            if (split.length == 4) {
                for (String str2 : split) {
                    if (!TextUtils.isDigitsOnly(str2)) {
                        return DEBUG_VERSION;
                    }
                }
                return str;
            }
        } catch (Exception unused) {
        }
        return DEBUG_VERSION;
    }

    public static boolean isPathValid(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str.substring(0, str.lastIndexOf(47)));
                if (file.exists()) {
                    return true;
                }
                boolean mkdirs = file.mkdirs();
                AdapterForTLog.loge(TAG, "dir: " + file.getAbsolutePath() + " no exist, make dir: " + mkdirs);
                return mkdirs;
            }
        } catch (Exception e) {
            AdapterForTLog.loge(TAG, "check download path exception:" + e);
        }
        return false;
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Error e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
