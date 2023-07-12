package com.alipay.sdk.m.t;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.m.u.e;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class a {
    public static final String g = "alipay_tid_storage";
    public static final String h = "tidinfo";
    public static final String i = "tid";
    public static final String j = "client_key";
    public static final String k = "timestamp";
    public static final String l = "vimei";
    public static final String m = "vimsi";
    public static Context n;
    public static a o;
    public String a;
    public String b;
    public long c;
    public String d;
    public String e;
    public boolean f = false;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (o == null) {
                o = new a();
            }
            if (n == null) {
                o.c(context);
            }
            aVar = o;
        }
        return aVar;
    }

    private boolean b(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    private void c(Context context) {
        if (context != null) {
            n = context.getApplicationContext();
        }
        if (this.f) {
            return;
        }
        this.f = true;
        l();
    }

    private String k() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 0
            java.lang.String r3 = "alipay_tid_storage"
            java.lang.String r4 = "tidinfo"
            r5 = 1
            java.lang.String r3 = com.alipay.sdk.m.t.a.C0201a.a(r3, r4, r5)     // Catch: java.lang.Exception -> L52
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L52
            if (r4 != 0) goto L4e
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L52
            r4.<init>(r3)     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = "tid"
            java.lang.String r3 = r4.optString(r3, r0)     // Catch: java.lang.Exception -> L52
            java.lang.String r5 = "client_key"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch: java.lang.Exception -> L4b
            java.lang.String r6 = "timestamp"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L48
            long r6 = r4.optLong(r6, r7)     // Catch: java.lang.Exception -> L48
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L48
            java.lang.String r6 = "vimei"
            java.lang.String r6 = r4.optString(r6, r0)     // Catch: java.lang.Exception -> L48
            java.lang.String r7 = "vimsi"
            java.lang.String r2 = r4.optString(r7, r0)     // Catch: java.lang.Exception -> L46
            goto L59
        L46:
            r0 = move-exception
            goto L56
        L48:
            r0 = move-exception
            r6 = r2
            goto L56
        L4b:
            r0 = move-exception
            r5 = r2
            goto L55
        L4e:
            r0 = r2
            r5 = r0
            r6 = r5
            goto L5b
        L52:
            r0 = move-exception
            r3 = r2
            r5 = r3
        L55:
            r6 = r5
        L56:
            com.alipay.sdk.m.u.e.a(r0)
        L59:
            r0 = r2
            r2 = r3
        L5b:
            java.lang.String r3 = "mspl"
            java.lang.String r4 = "tid_str: load"
            com.alipay.sdk.m.u.e.b(r3, r4)
            boolean r3 = r9.b(r2, r5, r6, r0)
            if (r3 == 0) goto L6c
            r9.m()
            goto L7a
        L6c:
            r9.a = r2
            r9.b = r5
            long r1 = r1.longValue()
            r9.c = r1
            r9.d = r6
            r9.e = r0
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.t.a.l():void");
    }

    private void m() {
        this.a = "";
        this.b = b();
        this.c = System.currentTimeMillis();
        this.d = k();
        this.e = k();
        C0201a.b(g, h);
    }

    private void n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.a);
            jSONObject.put(j, this.b);
            jSONObject.put("timestamp", this.c);
            jSONObject.put(l, this.d);
            jSONObject.put(m, this.e);
            C0201a.a(g, h, jSONObject.toString(), true);
        } catch (Exception e) {
            e.a(e);
        }
    }

    private void o() {
    }

    public String d() {
        return this.a;
    }

    public Long e() {
        return Long.valueOf(this.c);
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public boolean h() {
        return i();
    }

    public boolean i() {
        return TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e);
    }

    public String b() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0201a {
        public static boolean a(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(String str, String str2) {
            if (a.n == null) {
                return;
            }
            a.n.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static boolean c(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static String d(String str, String str2) {
            return a(str, str2, true);
        }

        public static String a(String str, String str2, boolean z) {
            if (a.n == null) {
                return null;
            }
            String string = a.n.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z) {
                string = com.alipay.sdk.m.n.e.a(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    e.b(com.alipay.sdk.m.l.a.z, "tid_str: pref failed");
                }
            }
            e.b(com.alipay.sdk.m.l.a.z, "tid_str: from local");
            return string;
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z) {
            if (a.n == null) {
                return;
            }
            SharedPreferences sharedPreferences = a.n.getSharedPreferences(str, 0);
            if (z) {
                String a = a();
                String b = com.alipay.sdk.m.n.e.b(a, str3, str3);
                if (TextUtils.isEmpty(b)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, a);
                }
                str3 = b;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static String a() {
            String str;
            try {
                str = a.n.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                e.a(th);
                str = "";
            }
            return (str + "0000000000000000000000000000").substring(0, 24);
        }
    }

    public String c() {
        return this.b;
    }

    public void a() {
        e.b(com.alipay.sdk.m.l.a.z, "tid_str: del");
        m();
    }

    public void a(String str, String str2) {
        e.b(com.alipay.sdk.m.l.a.z, "tid_str: save");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.a = str;
        this.b = str2;
        this.c = System.currentTimeMillis();
        n();
        o();
    }
}
