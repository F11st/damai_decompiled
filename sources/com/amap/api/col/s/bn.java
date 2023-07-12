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
        String z;

        private a() {
        }

        /* synthetic */ a(byte b) {
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
            byte[] a2 = bp.a(bArr2, d);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(a2, 0, bArr3, 0, 128);
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

    private static byte[] b(a aVar) {
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
            a(byteArrayOutputStream, aVar.z);
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

    private static String a(a aVar) {
        return bp.b(b(aVar));
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            bw.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, bw.a(str));
        } else {
            bw.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    private static a b(Context context, boolean z) {
        a aVar = new a((byte) 0);
        aVar.a = bo.r(context);
        aVar.b = bo.k(context);
        String h = bo.h(context);
        if (h == null) {
            h = "";
        }
        aVar.c = h;
        aVar.d = bk.c(context);
        aVar.e = Build.getMODEL();
        aVar.f = Build.getMANUFACTURER();
        aVar.g = android.os.Build.DEVICE;
        aVar.h = bk.b(context);
        aVar.i = bk.d(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = bo.t(context);
        aVar.l = bo.o(context);
        StringBuilder sb = new StringBuilder();
        sb.append(bo.n(context));
        aVar.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bo.m(context));
        aVar.n = sb2.toString();
        aVar.o = bo.v(context);
        aVar.p = bo.l(context);
        aVar.q = "";
        aVar.r = "";
        String[] d = bo.d();
        aVar.s = d[0];
        aVar.t = d[1];
        aVar.w = bo.a();
        String a2 = bo.a(context);
        if (!TextUtils.isEmpty(a2)) {
            aVar.x = a2;
        } else {
            aVar.x = "";
        }
        aVar.y = "aid=" + bo.j(context);
        if ((z && cf.d) || cf.e) {
            String g = bo.g(context);
            if (!TextUtils.isEmpty(g)) {
                aVar.y += "|oaid=" + g;
            }
        }
        String a3 = bo.a(context, ",");
        if (!TextUtils.isEmpty(a3)) {
            aVar.y += "|multiImeis=" + a3;
        }
        String s = bo.s(context);
        if (!TextUtils.isEmpty(s)) {
            aVar.y += "|meid=" + s;
        }
        aVar.y += "|serial=" + bo.i(context);
        String b = bo.b();
        if (!TextUtils.isEmpty(b)) {
            aVar.y += "|adiuExtras=" + b;
        }
        aVar.y += "|storage=" + bo.e() + "|ram=" + bo.u(context) + "|arch=" + bo.f();
        String b2 = ch.a().b();
        if (!TextUtils.isEmpty(b2)) {
            aVar.z = b2;
        } else {
            aVar.z = "";
        }
        return aVar;
    }
}
