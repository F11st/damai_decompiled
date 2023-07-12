package com.amap.api.col.s;

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
public final class bn {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.bn$a */
    /* loaded from: classes10.dex */
    public static class C4390a {
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
        String z;

        private C4390a() {
        }

        /* synthetic */ C4390a(byte b) {
            this();
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            String e = bk.e(context);
            return bs.a(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            ci.a(th, "CI", "Sco");
            return null;
        }
    }

    private static String b(Context context) {
        try {
            return a(b(context, false));
        } catch (Throwable th) {
            ci.a(th, "CI", "gCXi");
            return null;
        }
    }

    private static byte[] b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey d = bw.d();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy(bArr, 0, bArr2, 0, 117);
            byte[] a = bp.a(bArr2, d);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(a, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return bp.a(bArr, d);
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = bk.a() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            ci.a(th, "CI", "TS");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return bp.a(bArr);
    }

    public static byte[] a(Context context, boolean z) {
        try {
            return b(b(context, z));
        } catch (Throwable th) {
            ci.a(th, "CI", "gz");
            return null;
        }
    }

    private static byte[] b(C4390a c4390a) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            a(byteArrayOutputStream, c4390a.a);
            a(byteArrayOutputStream, c4390a.b);
            a(byteArrayOutputStream, c4390a.c);
            a(byteArrayOutputStream, c4390a.d);
            a(byteArrayOutputStream, c4390a.e);
            a(byteArrayOutputStream, c4390a.f);
            a(byteArrayOutputStream, c4390a.g);
            a(byteArrayOutputStream, c4390a.h);
            a(byteArrayOutputStream, c4390a.i);
            a(byteArrayOutputStream, c4390a.j);
            a(byteArrayOutputStream, c4390a.k);
            a(byteArrayOutputStream, c4390a.l);
            a(byteArrayOutputStream, c4390a.m);
            a(byteArrayOutputStream, c4390a.n);
            a(byteArrayOutputStream, c4390a.o);
            a(byteArrayOutputStream, c4390a.p);
            a(byteArrayOutputStream, c4390a.q);
            a(byteArrayOutputStream, c4390a.r);
            a(byteArrayOutputStream, c4390a.s);
            a(byteArrayOutputStream, c4390a.t);
            a(byteArrayOutputStream, c4390a.u);
            a(byteArrayOutputStream, c4390a.v);
            a(byteArrayOutputStream, c4390a.w);
            a(byteArrayOutputStream, c4390a.x);
            a(byteArrayOutputStream, c4390a.y);
            a(byteArrayOutputStream, c4390a.z);
            byte[] b = b(bw.b(byteArrayOutputStream.toByteArray()));
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return b;
        } catch (Throwable th3) {
            th = th3;
            try {
                ci.a(th, "CI", "gzx");
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

    public static String a(Context context) {
        return b(context);
    }

    private static String a(C4390a c4390a) {
        return bp.b(b(c4390a));
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            bw.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, bw.a(str));
        } else {
            bw.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    private static C4390a b(Context context, boolean z) {
        C4390a c4390a = new C4390a((byte) 0);
        c4390a.a = bo.r(context);
        c4390a.b = bo.k(context);
        String h = bo.h(context);
        if (h == null) {
            h = "";
        }
        c4390a.c = h;
        c4390a.d = bk.c(context);
        c4390a.e = Build.getMODEL();
        c4390a.f = Build.getMANUFACTURER();
        c4390a.g = android.os.Build.DEVICE;
        c4390a.h = bk.b(context);
        c4390a.i = bk.d(context);
        c4390a.j = String.valueOf(Build.VERSION.SDK_INT);
        c4390a.k = bo.t(context);
        c4390a.l = bo.o(context);
        StringBuilder sb = new StringBuilder();
        sb.append(bo.n(context));
        c4390a.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bo.m(context));
        c4390a.n = sb2.toString();
        c4390a.o = bo.v(context);
        c4390a.p = bo.l(context);
        c4390a.q = "";
        c4390a.r = "";
        String[] d = bo.d();
        c4390a.s = d[0];
        c4390a.t = d[1];
        c4390a.w = bo.a();
        String a = bo.a(context);
        if (!TextUtils.isEmpty(a)) {
            c4390a.x = a;
        } else {
            c4390a.x = "";
        }
        c4390a.y = "aid=" + bo.j(context);
        if ((z && cf.d) || cf.e) {
            String g = bo.g(context);
            if (!TextUtils.isEmpty(g)) {
                c4390a.y += "|oaid=" + g;
            }
        }
        String a2 = bo.a(context, ",");
        if (!TextUtils.isEmpty(a2)) {
            c4390a.y += "|multiImeis=" + a2;
        }
        String s = bo.s(context);
        if (!TextUtils.isEmpty(s)) {
            c4390a.y += "|meid=" + s;
        }
        c4390a.y += "|serial=" + bo.i(context);
        String b = bo.b();
        if (!TextUtils.isEmpty(b)) {
            c4390a.y += "|adiuExtras=" + b;
        }
        c4390a.y += "|storage=" + bo.e() + "|ram=" + bo.u(context) + "|arch=" + bo.f();
        String b2 = ch.a().b();
        if (!TextUtils.isEmpty(b2)) {
            c4390a.z = b2;
        } else {
            c4390a.z = "";
        }
        return c4390a;
    }
}
