package com.android.alibaba.ip.utils;

import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FileUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void copyInputStreamToFile(java.io.InputStream r5, java.io.File r6) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
        Le:
            int r2 = r5.read(r6)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            if (r2 <= 0) goto L1d
            r3 = 0
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r6, r3, r2)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r0.write(r2)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            goto Le
        L1d:
            r5.close()     // Catch: java.lang.Exception -> L21
            goto L25
        L21:
            r5 = move-exception
            r5.printStackTrace()
        L25:
            if (r0 == 0) goto L2f
            r0.close()     // Catch: java.lang.Exception -> L2b
            goto L2f
        L2b:
            r5 = move-exception
            r5.printStackTrace()
        L2f:
            r1.close()     // Catch: java.lang.Exception -> L33
            goto L37
        L33:
            r5 = move-exception
            r5.printStackTrace()
        L37:
            return
        L38:
            r6 = move-exception
            goto L4e
        L3a:
            r6 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L44
        L3f:
            r6 = move-exception
            r1 = r0
            goto L4e
        L42:
            r6 = move-exception
            r1 = r0
        L44:
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L4a
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L4a
            throw r2     // Catch: java.lang.Throwable -> L4a
        L4a:
            r6 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L4e:
            if (r5 == 0) goto L58
            r5.close()     // Catch: java.lang.Exception -> L54
            goto L58
        L54:
            r5 = move-exception
            r5.printStackTrace()
        L58:
            if (r0 == 0) goto L62
            r0.close()     // Catch: java.lang.Exception -> L5e
            goto L62
        L5e:
            r5 = move-exception
            r5.printStackTrace()
        L62:
            if (r1 == 0) goto L6c
            r1.close()     // Catch: java.lang.Exception -> L68
            goto L6c
        L68:
            r5 = move-exception
            r5.printStackTrace()
        L6c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.alibaba.ip.utils.FileUtils.copyInputStreamToFile(java.io.InputStream, java.io.File):void");
    }

    public static byte[] getByte(File file) {
        byte[] bArr = new byte[(int) file.length()];
        try {
            try {
                new FileInputStream(file).read(bArr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bArr;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getMD5(byte[] bArr) {
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isSameFile(File file, File file2) {
        return getMD5(file).equals(getMD5(file2));
    }

    public static String getMD5(File file) {
        return getMD5(getByte(file));
    }
}
