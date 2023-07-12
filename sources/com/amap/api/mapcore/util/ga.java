package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ga {
    private static byte[] c = "FDF1F436161AEF5B".getBytes();
    private static byte[] d = "0102030405060708".getBytes();
    private static int e = 6;
    static byte[] a = null;
    static byte[] b = null;

    public static byte[] a(byte[] bArr) {
        try {
            return gh.b(c, bArr, d);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return gh.a(c, bArr, d);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static byte[] a(Context context, byte[] bArr) {
        try {
            return gh.b(a(context), bArr, b(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] b(Context context, byte[] bArr) {
        try {
            return gh.a(a(context), bArr, b(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    private static byte[] a(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = a;
        if (bArr == null || bArr.length <= 0) {
            byte[] bytes = C4554gc.f(context).getBytes();
            a = bytes;
            return bytes;
        }
        return bArr;
    }

    private static byte[] b(Context context) {
        byte[] bArr = b;
        if (bArr == null || bArr.length <= 0) {
            int i = 0;
            if (Build.VERSION.SDK_INT >= 9) {
                b = Arrays.copyOfRange(a(context), 0, a(context).length / 2);
            } else {
                b = new byte[a(context).length / 2];
                while (true) {
                    byte[] bArr2 = b;
                    if (i >= bArr2.length) {
                        break;
                    }
                    bArr2[i] = a(context)[i];
                    i++;
                }
            }
            return b;
        }
        return bArr;
    }
}
