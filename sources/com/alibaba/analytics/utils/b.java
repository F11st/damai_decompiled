package com.alibaba.analytics.utils;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import tb.qe;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class b {
    private static int a;
    private static int b;
    private static HashMap<String, String> c = new HashMap<>();

    private static synchronized boolean a(String str, boolean z) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (z) {
                if (str.length() > 1024) {
                    return false;
                }
            } else if (str.length() > 256) {
                return false;
            }
            return a + str.length() <= 32768;
        }
    }

    public static synchronized void b() {
        synchronized (b.class) {
            c.clear();
            a = 0;
            b = 0;
        }
    }

    public static synchronized byte[] c(String str) throws IOException {
        byte[] d;
        synchronized (b.class) {
            d = d(str, false);
        }
        return d;
    }

    private static synchronized byte[] d(String str, boolean z) throws IOException {
        byte[] byteArray;
        synchronized (b.class) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (a(str, z)) {
                int i = -1;
                try {
                    i = Integer.parseInt(c.get(str));
                } catch (Exception unused) {
                }
                if (i >= 0) {
                    byteArrayOutputStream.write(g(1, i));
                } else {
                    h(str);
                    byteArrayOutputStream.write(g(2, str.getBytes().length));
                    byteArrayOutputStream.write(str.getBytes());
                }
            } else if (TextUtils.isEmpty(str)) {
                byteArrayOutputStream.write(g(3, 0));
            } else {
                byteArrayOutputStream.write(g(3, str.getBytes().length));
                byteArrayOutputStream.write(str.getBytes());
            }
            byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArray;
    }

    public static synchronized byte[] e(String str) throws IOException {
        byte[] d;
        synchronized (b.class) {
            d = d(str, true);
        }
        return d;
    }

    public static byte[] f(int i) {
        return g(0, i);
    }

    public static byte[] g(int i, int i2) {
        int i3 = 1 << (8 - i);
        byte b2 = (byte) i3;
        int i4 = i3 - 1;
        if (i2 < i4) {
            return qe.c(i2 | b2);
        }
        byte[] bArr = new byte[5];
        bArr[0] = (byte) ((b2 | i4) & 255);
        int i5 = i2 - i4;
        int i6 = 1;
        while (i5 >= 128) {
            bArr[i6] = (byte) ((128 | (i5 % 128)) & 255);
            i5 /= 128;
            i6++;
        }
        bArr[i6] = (byte) (i5 & 127);
        return qe.g(bArr, 0, i6 + 1);
    }

    private static synchronized void h(String str) {
        synchronized (b.class) {
            HashMap<String, String> hashMap = c;
            hashMap.put(str, "" + b);
            a = a + str.length();
            b = b + 1;
        }
    }
}
