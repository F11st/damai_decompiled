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
    /* renamed from: com.amap.api.mapcore.util.gf$a */
    /* loaded from: classes10.dex */
    public static class C4564a {
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

        private C4564a() {
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            String e = C4554gc.e(context);
            return gk.b(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            C4573ha.a(th, "CI", "Sco");
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
            byte[] a = gh.a(bArr2, d);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(a, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return gh.a(bArr, d);
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = C4554gc.a() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            C4573ha.a(th, "CI", "TS");
            return null;
        }
    }

    public static String a(Context context) {
        try {
            C4564a c4564a = new C4564a();
            c4564a.d = C4554gc.c(context);
            c4564a.i = C4554gc.d(context);
            return a(context, c4564a);
        } catch (Throwable th) {
            C4573ha.a(th, "CI", "IX");
            return null;
        }
    }

    private static byte[] b(Context context, C4564a c4564a) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            a(byteArrayOutputStream, c4564a.a);
            a(byteArrayOutputStream, c4564a.b);
            a(byteArrayOutputStream, c4564a.c);
            a(byteArrayOutputStream, c4564a.d);
            a(byteArrayOutputStream, c4564a.e);
            a(byteArrayOutputStream, c4564a.f);
            a(byteArrayOutputStream, c4564a.g);
            a(byteArrayOutputStream, c4564a.h);
            a(byteArrayOutputStream, c4564a.i);
            a(byteArrayOutputStream, c4564a.j);
            a(byteArrayOutputStream, c4564a.k);
            a(byteArrayOutputStream, c4564a.l);
            a(byteArrayOutputStream, c4564a.m);
            a(byteArrayOutputStream, c4564a.n);
            a(byteArrayOutputStream, c4564a.o);
            a(byteArrayOutputStream, c4564a.p);
            a(byteArrayOutputStream, c4564a.q);
            a(byteArrayOutputStream, c4564a.r);
            a(byteArrayOutputStream, c4564a.s);
            a(byteArrayOutputStream, c4564a.t);
            a(byteArrayOutputStream, c4564a.u);
            a(byteArrayOutputStream, c4564a.v);
            a(byteArrayOutputStream, c4564a.w);
            a(byteArrayOutputStream, c4564a.x);
            a(byteArrayOutputStream, c4564a.y);
            byte[] a = a(context, byteArrayOutputStream);
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return a;
        } catch (Throwable th3) {
            th = th3;
            try {
                C4573ha.a(th, "CI", "gzx");
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
            C4573ha.a(th, "CI", "gz");
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        try {
            return a(context, b(context, false, z));
        } catch (Throwable th) {
            C4573ha.a(th, "CI", "gCXi");
            return null;
        }
    }

    private static String a(Context context, C4564a c4564a) {
        return gh.b(b(context, c4564a));
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

    private static C4564a b(Context context, boolean z, boolean z2) {
        C4564a c4564a = new C4564a();
        c4564a.a = gg.w(context);
        c4564a.b = gg.n(context);
        String i = gg.i(context);
        if (i == null) {
            i = "";
        }
        c4564a.c = i;
        c4564a.d = C4554gc.c(context);
        c4564a.e = Build.getMODEL();
        c4564a.f = Build.getMANUFACTURER();
        c4564a.g = android.os.Build.DEVICE;
        c4564a.h = C4554gc.b(context);
        c4564a.i = C4554gc.d(context);
        c4564a.j = String.valueOf(Build.VERSION.SDK_INT);
        c4564a.k = gg.y(context);
        c4564a.l = gg.u(context);
        c4564a.m = gg.r(context) + "";
        c4564a.n = gg.q(context) + "";
        c4564a.o = gg.A(context);
        c4564a.p = gg.p(context);
        if (z) {
            c4564a.q = "";
        } else {
            c4564a.q = gg.m(context);
        }
        if (z) {
            c4564a.r = "";
        } else {
            c4564a.r = gg.l(context);
        }
        if (z) {
            c4564a.s = "";
            c4564a.t = "";
        } else {
            String[] o = gg.o(context);
            c4564a.s = o[0];
            c4564a.t = o[1];
        }
        c4564a.w = gg.a();
        String b = gg.b(context);
        if (!TextUtils.isEmpty(b)) {
            c4564a.x = b;
        } else {
            c4564a.x = "";
        }
        c4564a.y = "aid=" + gg.k(context);
        if ((z2 && gy.e) || gy.f) {
            String h = gg.h(context);
            if (!TextUtils.isEmpty(h)) {
                c4564a.y += "|oaid=" + h;
            }
        }
        String a = gg.a(context, ",", true);
        if (!TextUtils.isEmpty(a)) {
            c4564a.y += "|multiImeis=" + a;
        }
        String x = gg.x(context);
        if (!TextUtils.isEmpty(x)) {
            c4564a.y += "|meid=" + x;
        }
        c4564a.y += "|serial=" + gg.j(context);
        String a2 = gg.a(context);
        if (!TextUtils.isEmpty(a2)) {
            c4564a.y += "|adiuExtras=" + a2;
        }
        c4564a.y += "|storage=" + gg.d() + "|ram=" + gg.z(context) + "|arch=" + gg.e();
        return c4564a;
    }
}
