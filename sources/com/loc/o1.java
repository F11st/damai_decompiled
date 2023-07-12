package com.loc;

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
import tb.w33;
import tb.x33;
import tb.y33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class o1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.o1$a */
    /* loaded from: classes10.dex */
    public static class C5867a {
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

        private C5867a() {
        }

        /* synthetic */ C5867a(byte b) {
            this();
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = C5846l.d() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            y33.e(th, "CI", "TS");
            return null;
        }
    }

    public static String b(Context context) {
        return i(context);
    }

    public static String c(Context context, String str, String str2) {
        try {
            String i = C5846l.i(context);
            return r1.a(i + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            y33.e(th, "CI", "Sco");
            return null;
        }
    }

    private static String d(C5867a c5867a) {
        return p1.f(j(c5867a));
    }

    private static void e(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            v1.k(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            v1.k(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, v1.p(str));
        }
    }

    public static byte[] f(Context context, boolean z, boolean z2) {
        try {
            return j(h(context, z, z2));
        } catch (Throwable th) {
            y33.e(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] g(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return p1.b(bArr);
    }

    private static C5867a h(Context context, boolean z, boolean z2) {
        C5867a c5867a = new C5867a((byte) 0);
        c5867a.a = C5861o.h0(context);
        c5867a.b = C5861o.W(context);
        String R = C5861o.R(context);
        if (R == null) {
            R = "";
        }
        c5867a.c = R;
        c5867a.d = C5846l.g(context);
        c5867a.e = Build.getMODEL();
        c5867a.f = Build.getMANUFACTURER();
        c5867a.g = android.os.Build.DEVICE;
        c5867a.h = C5846l.e(context);
        c5867a.i = C5846l.h(context);
        c5867a.j = String.valueOf(Build.VERSION.SDK_INT);
        c5867a.k = C5861o.k0(context);
        c5867a.l = C5861o.d0(context);
        StringBuilder sb = new StringBuilder();
        sb.append(C5861o.a0(context));
        c5867a.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C5861o.Z(context));
        c5867a.n = sb2.toString();
        c5867a.o = C5861o.a(context);
        c5867a.p = C5861o.Y(context);
        c5867a.q = "";
        c5867a.r = "";
        if (z) {
            c5867a.s = "";
            c5867a.t = "";
        } else {
            String[] K = C5861o.K();
            c5867a.s = K[0];
            c5867a.t = K[1];
        }
        c5867a.w = C5861o.v();
        String w = C5861o.w(context);
        if (TextUtils.isEmpty(w)) {
            c5867a.x = "";
        } else {
            c5867a.x = w;
        }
        c5867a.y = "aid=" + C5861o.V(context);
        if ((z2 && w33.e) || w33.k) {
            String Q = C5861o.Q(context);
            if (!TextUtils.isEmpty(Q)) {
                c5867a.y += "|oaid=" + Q;
            }
        }
        String y = C5861o.y(context, ",");
        if (!TextUtils.isEmpty(y)) {
            c5867a.y += "|multiImeis=" + y;
        }
        String j0 = C5861o.j0(context);
        if (!TextUtils.isEmpty(j0)) {
            c5867a.y += "|meid=" + j0;
        }
        c5867a.y += "|serial=" + C5861o.T(context);
        String C = C5861o.C();
        if (!TextUtils.isEmpty(C)) {
            c5867a.y += "|adiuExtras=" + C;
        }
        c5867a.y += "|storage=" + C5861o.N() + "|ram=" + C5861o.l0(context) + "|arch=" + C5861o.P();
        String b = x33.a().b();
        if (TextUtils.isEmpty(b)) {
            c5867a.z = "";
        } else {
            c5867a.z = b;
        }
        return c5867a;
    }

    private static String i(Context context) {
        try {
            return d(h(context, false, false));
        } catch (Throwable th) {
            y33.e(th, "CI", "gCXi");
            return null;
        }
    }

    private static byte[] j(C5867a c5867a) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            e(byteArrayOutputStream, c5867a.a);
            e(byteArrayOutputStream, c5867a.b);
            e(byteArrayOutputStream, c5867a.c);
            e(byteArrayOutputStream, c5867a.d);
            e(byteArrayOutputStream, c5867a.e);
            e(byteArrayOutputStream, c5867a.f);
            e(byteArrayOutputStream, c5867a.g);
            e(byteArrayOutputStream, c5867a.h);
            e(byteArrayOutputStream, c5867a.i);
            e(byteArrayOutputStream, c5867a.j);
            e(byteArrayOutputStream, c5867a.k);
            e(byteArrayOutputStream, c5867a.l);
            e(byteArrayOutputStream, c5867a.m);
            e(byteArrayOutputStream, c5867a.n);
            e(byteArrayOutputStream, c5867a.o);
            e(byteArrayOutputStream, c5867a.p);
            e(byteArrayOutputStream, c5867a.q);
            e(byteArrayOutputStream, c5867a.r);
            e(byteArrayOutputStream, c5867a.s);
            e(byteArrayOutputStream, c5867a.t);
            e(byteArrayOutputStream, c5867a.u);
            e(byteArrayOutputStream, c5867a.v);
            e(byteArrayOutputStream, c5867a.w);
            e(byteArrayOutputStream, c5867a.x);
            e(byteArrayOutputStream, c5867a.y);
            e(byteArrayOutputStream, c5867a.z);
            byte[] k = k(v1.u(byteArrayOutputStream.toByteArray()));
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return k;
        } catch (Throwable th3) {
            th = th3;
            try {
                y33.e(th, "CI", "gzx");
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

    private static byte[] k(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey y = v1.y();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy(bArr, 0, bArr2, 0, 117);
            byte[] c = p1.c(bArr2, y);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(c, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return p1.c(bArr, y);
    }
}
