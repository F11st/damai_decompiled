package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* renamed from: com.loc.d0 */
/* loaded from: classes10.dex */
public final class C5818d0 {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public C5818d0(Context context, String str, String str2, String str3) throws C5844k {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new C5844k("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    private static byte[] c(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private byte[] d(String str) {
        byte[] p;
        if (!TextUtils.isEmpty(str) && (p = v1.p(this.e)) != null) {
            return v1.o(p.length);
        }
        return new byte[]{0, 0};
    }

    public final void a(String str) throws C5844k {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new C5844k("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    public final byte[] b() {
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
            v1.l(byteArrayOutputStream, this.c);
            v1.l(byteArrayOutputStream, this.d);
            v1.l(byteArrayOutputStream, this.b);
            v1.l(byteArrayOutputStream, String.valueOf(C5861o.a0(this.a)));
            try {
                i = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
            }
            byteArrayOutputStream.write(c(i));
            byteArrayOutputStream.write(d(this.e));
            byteArrayOutputStream.write(v1.p(this.e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                an.m(th, "se", "tds");
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
