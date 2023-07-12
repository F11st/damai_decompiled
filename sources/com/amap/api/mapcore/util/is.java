package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class is {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public is(Context context, String str, String str2, String str3) throws gb {
        if (!TextUtils.isEmpty(str3) && str3.length() <= 256) {
            this.a = context.getApplicationContext();
            this.c = str;
            this.d = str2;
            this.b = str3;
            return;
        }
        throw new gb("无效的参数 - IllegalArgumentException");
    }

    public void a(String str) throws gb {
        if (!TextUtils.isEmpty(str) && str.length() <= 65536) {
            this.e = str;
            return;
        }
        throw new gb("无效的参数 - IllegalArgumentException");
    }

    public byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public byte[] b(String str) {
        byte[] a;
        if (!TextUtils.isEmpty(str) && (a = gn.a(this.e)) != null) {
            return gn.a(a.length, 2);
        }
        return new byte[]{0, 0};
    }

    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream;
        int i = 0;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            gn.a(byteArrayOutputStream, this.c);
            gn.a(byteArrayOutputStream, this.d);
            gn.a(byteArrayOutputStream, this.b);
            gn.a(byteArrayOutputStream, String.valueOf(gg.r(this.a)));
            try {
                i = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
            }
            byteArrayOutputStream.write(a(i));
            byteArrayOutputStream.write(b(this.e));
            byteArrayOutputStream.write(gn.a(this.e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                hd.c(th, "se", "tds");
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                return bArr;
            } catch (Throwable th4) {
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th4;
            }
        }
        return bArr;
    }
}
