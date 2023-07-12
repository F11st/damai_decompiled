package com.alibaba.security.common.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.taobao.windvane.WindVaneSDK;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class b {
    private static final String a = "CommonUtils";

    public static boolean a() {
        try {
            int i = WindVaneSDK.a;
            Class.forName("android.taobao.windvane.extra.uc.WVUCWebView");
            return true;
        } catch (ClassNotFoundException unused) {
            com.alibaba.security.common.c.a.a(a, "WindVane sdk is not exist");
            return false;
        }
    }

    public static String b(Throwable th) {
        return th == null ? "" : th.getMessage();
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            printWriter.close();
        }
    }

    public static Bitmap a(byte[] bArr, int i, int i2) {
        if (bArr != null && i > 0 && i2 > 0) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new YuvImage(bArr, 17, i, i2, null).compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length);
                Matrix matrix = new Matrix();
                matrix.postRotate(-90.0f);
                return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
            } catch (Exception e) {
                com.alibaba.security.common.c.a.d(a, e.getMessage());
            }
        }
        return null;
    }
}
