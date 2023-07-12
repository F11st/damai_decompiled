package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.loc.bl;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.a83;
import tb.h73;
import tb.jn1;
import tb.t73;
import tb.u73;

/* compiled from: Taobao */
/* renamed from: com.loc.fc */
/* loaded from: classes10.dex */
public final class C5833fc {
    private static C5833fc i = null;
    public static int j = 1;
    public static int k = 2;
    private Context f;
    private String g;
    private long a = 0;
    private ArrayList<String> b = new ArrayList<>();
    private h73 c = new h73();
    private h73 d = new h73();
    private long e = 120000;
    private boolean h = false;

    private C5833fc(Context context) {
        this.f = context;
    }

    public static synchronized C5833fc c(Context context) {
        C5833fc c5833fc;
        synchronized (C5833fc.class) {
            if (i == null) {
                i = new C5833fc(context);
            }
            c5833fc = i;
        }
        return c5833fc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h73 j(int i2) {
        return i2 == k ? this.d : this.c;
    }

    private synchronized void l(boolean z, final int i2) {
        if (!z) {
            if (!i1.E() && this.h) {
                return;
            }
        }
        if (this.a != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.a;
            if (currentTimeMillis - j2 < this.e) {
                return;
            }
            if (currentTimeMillis - j2 < DateUtils.MILLIS_PER_MINUTE) {
                return;
            }
        }
        this.a = System.currentTimeMillis();
        this.h = true;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.getClassName() + jn1.BRACKET_START_STR + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + "),");
        }
        C5866o0.f().d(new ck() { // from class: com.loc.fc.1
            @Override // com.loc.ck
            public final void a() {
                int i3;
                StringBuilder sb = new StringBuilder("http://");
                sb.append(i1.G());
                sb.append("?host=dualstack-a.apilocate.amap.com&query=");
                sb.append(i2 == C5833fc.k ? 6 : 4);
                String sb2 = sb.toString();
                t73 t73Var = new t73();
                t73Var.L(sb2);
                t73Var.N(sb2);
                t73Var.d(bl.EnumC5800a.SINGLE);
                t73Var.f(bl.EnumC5802c.HTTP);
                try {
                    bg.b();
                    JSONObject jSONObject = new JSONObject(new String(bg.c(t73Var).a));
                    String[] n = C5833fc.n(jSONObject.optJSONArray("ips"), C5833fc.j);
                    if (n != null && n.length > 0 && !C5833fc.m(n, C5833fc.this.j(C5833fc.j).d())) {
                        C5833fc.this.j(C5833fc.j).c(n);
                        C5833fc.this.r(C5833fc.j);
                    }
                    String[] n2 = C5833fc.n(jSONObject.optJSONArray("ipsv6"), C5833fc.k);
                    if (n2 != null && n2.length > 0 && !C5833fc.m(n2, C5833fc.this.j(C5833fc.k).d())) {
                        C5833fc.this.j(C5833fc.k).c(n2);
                        C5833fc.this.r(C5833fc.k);
                    }
                    if ((jSONObject.has("ips") || jSONObject.has("ipsv6")) && jSONObject.has(RemoteMessageConst.TTL) && (i3 = jSONObject.getInt(RemoteMessageConst.TTL)) > 30) {
                        C5833fc.this.e = i3 * 1000;
                    }
                } catch (Throwable th) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("key", "dnsError");
                        jSONObject2.put("reason", th.getMessage());
                    } catch (Throwable unused) {
                    }
                    l1.n(C5833fc.this.f, "O018", jSONObject2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!strArr[i2].equals(strArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] n(JSONArray jSONArray, int i2) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String string = jSONArray.getString(i3);
            if (!TextUtils.isEmpty(string)) {
                if (i2 == k) {
                    string = jn1.ARRAY_START_STR + string + jn1.ARRAY_END_STR;
                }
                strArr[i3] = string;
            }
        }
        return strArr;
    }

    private static String o(int i2) {
        return i2 == k ? "last_ip_6" : "last_ip_4";
    }

    private void p(int i2) {
        if (j(i2).i()) {
            SharedPreferences.Editor c = a83.c(this.f, "cbG9jaXA");
            a83.g(c, o(i2));
            a83.f(c);
            j(i2).b(false);
        }
    }

    private String q(int i2) {
        String str;
        int i3 = 0;
        l(false, i2);
        String[] d = j(i2).d();
        if (d == null || d.length <= 0) {
            s(i2);
            return j(i2).e();
        }
        int length = d.length;
        while (true) {
            if (i3 >= length) {
                str = null;
                break;
            }
            str = d[i3];
            if (!this.b.contains(str)) {
                break;
            }
            i3++;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        j(i2).a(str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i2) {
        if (j(i2).d() == null || j(i2).d().length <= 0) {
            return;
        }
        String str = j(i2).d()[0];
        if (str.equals(this.g) || this.b.contains(str)) {
            return;
        }
        this.g = str;
        SharedPreferences.Editor c = a83.c(this.f, "cbG9jaXA");
        a83.j(c, o(i2), str);
        a83.f(c);
    }

    private void s(int i2) {
        String e = a83.e(this.f, "cbG9jaXA", o(i2), null);
        if (TextUtils.isEmpty(e) || this.b.contains(e)) {
            return;
        }
        j(i2).a(e);
        j(i2).f(e);
        j(i2).b(true);
    }

    public final String d(u73 u73Var, int i2) {
        try {
            if (i1.F() && u73Var != null) {
                String j2 = u73Var.j();
                String host = new URL(j2).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(j2) && !"abroad.apilocate.amap.com".equals(host)) {
                    String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                    if (!C5849m.J(str)) {
                        return null;
                    }
                    String q = q(i2);
                    if (!TextUtils.isEmpty(q)) {
                        u73Var.c0(j2.replace(host, q));
                        u73Var.b().put("host", str);
                        u73Var.d0(str);
                        u73Var.i(i2 == k);
                        return q;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void f(int i2) {
        if (j(i2).j()) {
            p(i2);
            return;
        }
        this.b.add(j(i2).e());
        p(i2);
        l(true, i2);
    }

    public final void g(boolean z, int i2) {
        j(i2).g(z);
        if (z) {
            String h = j(i2).h();
            String e = j(i2).e();
            if (TextUtils.isEmpty(e) || e.equals(h)) {
                return;
            }
            SharedPreferences.Editor c = a83.c(this.f, "cbG9jaXA");
            a83.j(c, o(i2), e);
            a83.f(c);
        }
    }
}
