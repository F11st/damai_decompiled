package com.uc.webview.export.internal.uc.wa;

import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.Log;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class f {
    private static final char[] b = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
    static boolean a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return a;
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            e.printStackTrace();
            return bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            int i = length + 0;
            for (int i2 = 0; i2 < i; i2++) {
                byte b2 = digest[i2];
                char[] cArr = b;
                char c = cArr[(b2 & 240) >> 4];
                char c2 = cArr[b2 & 15];
                sb.append(c);
                sb.append(c2);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            Log.e("SDKWaStat", "", e);
            return null;
        } catch (NoSuchAlgorithmException e2) {
            Log.e("SDKWaStat", "", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr) throws Exception {
        Method method;
        Class<?> cls = Class.forName("org.chromium.android_webview.AwContentsStatics", false, SDKFactory.c);
        try {
            method = cls.getDeclaredMethod("encryptData", byte[].class);
        } catch (Throwable unused) {
            method = cls.getMethod("encryptData", byte[].class);
        }
        Object[] objArr = new Object[1];
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i = 4; i < 16; i++) {
            bArr2[i] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        objArr[0] = bArr2;
        return (byte[]) method.invoke(null, objArr);
    }
}
