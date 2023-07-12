package tb;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class o01 {
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private volatile boolean g;

    private o01() {
        this.g = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00af, code lost:
        if (r2 <= 65535) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static tb.o01 g(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.o01.g(java.lang.String):tb.o01");
    }

    public boolean a() {
        return this.d != 0 && (("http".equals(this.a) && this.d != 80) || ("https".equals(this.a) && this.d != 443));
    }

    public void b() {
        this.g = true;
        if ("http".equals(this.a)) {
            return;
        }
        this.a = "http";
        String str = this.e;
        this.e = zh2.e("http", ":", str.substring(str.indexOf(WVUtils.URL_SEPARATOR)));
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return this.g;
    }

    public void f() {
        this.g = true;
    }

    public String h() {
        return this.c;
    }

    public void i(String str, int i) {
        if (str != null) {
            int indexOf = this.e.indexOf(WVUtils.URL_SEPARATOR) + 2;
            while (indexOf < this.e.length() && this.e.charAt(indexOf) != '/') {
                indexOf++;
            }
            boolean d = lw2.d(str);
            StringBuilder sb = new StringBuilder(this.e.length() + str.length());
            sb.append(this.a);
            sb.append(jg1.SCHEME_SLASH);
            if (d) {
                sb.append(jn1.ARRAY_START);
            }
            sb.append(str);
            if (d) {
                sb.append(jn1.ARRAY_END);
            }
            if (i != 0) {
                sb.append(jn1.CONDITION_IF_MIDDLE);
                sb.append(i);
            } else if (this.d != 0) {
                sb.append(jn1.CONDITION_IF_MIDDLE);
                sb.append(this.d);
            }
            sb.append(this.e.substring(indexOf));
            this.e = sb.toString();
        }
    }

    public String j() {
        return this.a;
    }

    public void k(String str) {
        if (this.g || str.equalsIgnoreCase(this.a)) {
            return;
        }
        this.a = str;
        String str2 = this.e;
        String e = zh2.e(str, ":", str2.substring(str2.indexOf(WVUtils.URL_SEPARATOR)));
        this.e = e;
        this.f = zh2.e(str, ":", this.f.substring(e.indexOf(WVUtils.URL_SEPARATOR)));
    }

    public String l() {
        return this.f;
    }

    public URL m() {
        try {
            return new URL(this.e);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public String n() {
        return this.e;
    }

    public String toString() {
        return this.e;
    }

    public o01(o01 o01Var) {
        this.g = false;
        this.a = o01Var.a;
        this.b = o01Var.b;
        this.c = o01Var.c;
        this.e = o01Var.e;
        this.f = o01Var.f;
        this.g = o01Var.g;
    }
}
