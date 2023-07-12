package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gf {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;

        private a() {
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            String e = gc.e(context);
            return gk.b(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            ha.a(th, "CI", "Sco");
            return null;
        }
    }

    public static String b(Context context) {
        return a(context, false);
    }

    public static byte[] b(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey d = gn.d();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy(bArr, 0, bArr2, 0, 117);
            byte[] a2 = gh.a(bArr2, d);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(a2, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return gh.a(bArr, d);
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = gc.a() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            ha.a(th, "CI", "TS");
            return null;
        }
    }

    public static String a(Context context) {
        try {
            a aVar = new a();
            aVar.d = gc.c(context);
            aVar.i = gc.d(context);
            return a(context, aVar);
        } catch (Throwable th) {
            ha.a(th, "CI", "IX");
            return null;
        }
    }

    private static byte[] b(Context context, a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            a(byteArrayOutputStream, aVar.a);
            a(byteArrayOutputStream, aVar.b);
            a(byteArrayOutputStream, aVar.c);
            a(byteArrayOutputStream, aVar.d);
            a(byteArrayOutputStream, aVar.e);
            a(byteArrayOutputStream, aVar.f);
            a(byteArrayOutputStream, aVar.g);
            a(byteArrayOutputStream, aVar.h);
            a(byteArrayOutputStream, aVar.i);
            a(byteArrayOutputStream, aVar.j);
            a(byteArrayOutputStream, aVar.k);
            a(byteArrayOutputStream, aVar.l);
            a(byteArrayOutputStream, aVar.m);
            a(byteArrayOutputStream, aVar.n);
            a(byteArrayOutputStream, aVar.o);
            a(byteArrayOutputStream, aVar.p);
            a(byteArrayOutputStream, aVar.q);
            a(byteArrayOutputStream, aVar.r);
            a(byteArrayOutputStream, aVar.s);
            a(byteArrayOutputStream, aVar.t);
            a(byteArrayOutputStream, aVar.u);
            a(byteArrayOutputStream, aVar.v);
            a(byteArrayOutputStream, aVar.w);
            a(byteArrayOutputStream, aVar.x);
            a(byteArrayOutputStream, aVar.y);
            byte[] a2 = a(context, byteArrayOutputStream);
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return a2;
        } catch (Throwable th3) {
            th = th3;
            try {
                ha.a(th, "CI", "gzx");
                return null;
            } finally {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    public static byte[] a(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return gh.a(bArr);
    }

    public static byte[] a(Context context, boolean z, boolean z2) {
        try {
            return b(context, b(context, z, z2));
        } catch (Throwable th) {
            ha.a(th, "CI", "gz");
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        try {
            return a(context, b(context, false, z));
        } catch (Throwable th) {
            ha.a(th, "CI", "gCXi");
            return null;
        }
    }

    private static String a(Context context, a aVar) {
        return gh.b(b(context, aVar));
    }

    private static byte[] a(Context context, ByteArrayOutputStream byteArrayOutputStream) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return b(context, gn.b(byteArrayOutputStream.toByteArray()));
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            gn.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, gn.a(str));
        } else {
            gn.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    private static a b(Context context, boolean z, boolean z2) {
        a aVar = new a();
        aVar.a = gg.w(context);
        aVar.b = gg.n(context);
        String i = gg.i(context);
        if (i == null) {
            i = "";
        }
        aVar.c = i;
        aVar.d = gc.c(context);
        aVar.e = Build.getMODEL();
        aVar.f = Build.getMANUFACTURER();
        aVar.g = android.os.Build.DEVICE;
        aVar.h = gc.b(context);
        aVar.i = gc.d(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = gg.y(context);
        aVar.l = gg.u(context);
        aVar.m = gg.r(context) + "";
        aVar.n = gg.q(context) + "";
        aVar.o = gg.A(context);
        aVar.p = gg.p(context);
        if (z) {
            aVar.q = "";
        } else {
            aVar.q = gg.m(context);
        }
        if (z) {
            aVar.r = "";
        } else {
            aVar.r = gg.l(context);
        }
        if (z) {
            aVar.s = "";
            aVar.t = "";
        } else {
            String[] o = gg.o(context);
            aVar.s = o[0];
            aVar.t = o[1];
        }
        aVar.w = gg.a();
        String b = gg.b(context);
        if (!TextUtils.isEmpty(b)) {
            aVar.x = b;
        } else {
            aVar.x = "";
        }
        aVar.y = "aid=" + gg.k(context);
        if ((z2 && gy.e) || gy.f) {
            String h = gg.h(context);
            if (!TextUtils.isEmpty(h)) {
                aVar.y += "|oaid=" + h;
            }
        }
        String a2 = gg.a(context, ",", true);
        if (!TextUtils.isEmpty(a2)) {
            aVar.y += "|multiImeis=" + a2;
        }
        String x = gg.x(context);
        if (!TextUtils.isEmpty(x)) {
            aVar.y += "|meid=" + x;
        }
        aVar.y += "|serial=" + gg.j(context);
        String a3 = gg.a(context);
        if (!TextUtils.isEmpty(a3)) {
            aVar.y += "|adiuExtras=" + a3;
        }
        aVar.y += "|storage=" + gg.d() + "|ram=" + gg.z(context) + "|arch=" + gg.e();
        return aVar;
    }
}
