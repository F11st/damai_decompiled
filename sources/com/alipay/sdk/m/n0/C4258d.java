package com.alipay.sdk.m.n0;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.motu.crashreporter.Constants;
import com.alipay.sdk.m.l0.C4234b;
import com.alipay.sdk.m.l0.C4238c;
import com.alipay.sdk.m.l0.C4239d;
import com.alipay.sdk.m.l0.C4240e;
import com.alipay.sdk.m.l0.C4243f;
import com.alipay.sdk.m.m0.C4249a;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;
import tb.km1;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.n0.d */
/* loaded from: classes12.dex */
public class C4258d {
    public static C4258d j;
    public Context a;
    public C4259e c;
    public String d;
    public String e;
    public C4249a f;
    public C4249a g;
    public static final Object i = new Object();
    public static final String k = ".UTSystemConfig" + File.separator + "Global";
    public String b = null;
    public Pattern h = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public C4258d(Context context) {
        this.a = null;
        this.c = null;
        this.d = "xx_utdid_key";
        this.e = "xx_utdid_domain";
        this.f = null;
        this.g = null;
        this.a = context;
        this.g = new C4249a(context, k, "Alvin2", false, true);
        this.f = new C4249a(context, ".DataStorage", "ContextData", false, true);
        this.c = new C4259e();
        this.d = String.format("K_%d", Integer.valueOf(C4243f.a(this.d)));
        this.e = String.format("D_%d", Integer.valueOf(C4243f.a(this.e)));
    }

    public static C4258d a(Context context) {
        if (context != null && j == null) {
            synchronized (i) {
                if (j == null) {
                    C4258d c4258d = new C4258d(context);
                    j = c4258d;
                    c4258d.e();
                }
            }
        }
        return j;
    }

    private void c(String str) {
        C4249a c4249a;
        if (b(str)) {
            if (str.endsWith(StringUtils.LF)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (c4249a = this.g) == null) {
                return;
            }
            c4249a.a("UTDID2", str);
            this.g.a();
        }
    }

    private void d(String str) {
        C4249a c4249a;
        if (str == null || (c4249a = this.f) == null || str.equals(c4249a.a(this.d))) {
            return;
        }
        this.f.a(this.d, str);
        this.f.a();
    }

    private void e() {
        C4249a c4249a = this.g;
        if (c4249a != null) {
            if (C4243f.m215a(c4249a.a("UTDID2"))) {
                String a = this.g.a(Constants.UTDID);
                if (!C4243f.m215a(a)) {
                    c(a);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!C4243f.m215a(this.g.a("DID"))) {
                this.g.b("DID");
                z = true;
            }
            if (!C4243f.m215a(this.g.a("EI"))) {
                this.g.b("EI");
                z = true;
            }
            if (C4243f.m215a(this.g.a("SI"))) {
                z2 = z;
            } else {
                this.g.b("SI");
            }
            if (z2) {
                this.g.a();
            }
        }
    }

    private byte[] f() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a = C4238c.a(currentTimeMillis);
        byte[] a2 = C4238c.a(nextInt);
        byteArrayOutputStream.write(a, 0, 4);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = C4239d.a(this.a);
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(C4238c.a(C4243f.a(str)), 0, 4);
        byteArrayOutputStream.write(C4238c.a(C4243f.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private String g() {
        C4249a c4249a = this.g;
        if (c4249a != null) {
            String a = c4249a.a("UTDID2");
            if (C4243f.m215a(a) || this.c.a(a) == null) {
                return null;
            }
            return a;
        }
        return null;
    }

    public synchronized String b() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        return a();
    }

    private boolean b(String str) {
        if (str != null) {
            if (str.endsWith(StringUtils.LF)) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.h.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public synchronized String a() {
        String c = c();
        this.b = c;
        if (!TextUtils.isEmpty(c)) {
            return this.b;
        }
        try {
            byte[] f = f();
            if (f != null) {
                String c2 = C4234b.c(f, 2);
                this.b = c2;
                c(c2);
                String a = this.c.a(f);
                if (a != null) {
                    d(a);
                }
                return this.b;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized String c() {
        String g = g();
        if (b(g)) {
            d(this.c.a(g));
            this.b = g;
            return g;
        }
        String a = this.f.a(this.d);
        if (!C4243f.m215a(a)) {
            String a2 = new C4260f().a(a);
            if (!b(a2)) {
                a2 = this.c.b(a);
            }
            if (b(a2) && !C4243f.m215a(a2)) {
                this.b = a2;
                c(a2);
                return this.b;
            }
        }
        return null;
    }

    public static String a(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, SignedBytes.MAX_POWER_OF_TWO, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, km1.OP_CREATE_JSON, -80, -68, -78, -117, 53, 30, -122, SignedBytes.MAX_POWER_OF_TWO, -104, 74, -49, 106, 85, -38, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(C4240e.a(bArr2), mac.getAlgorithm()));
        return C4234b.c(mac.doFinal(bArr), 2);
    }
}
