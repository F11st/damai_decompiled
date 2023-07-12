package com.alipay.sdk.m.k;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.m.C4245a;
import com.alipay.sdk.m.q.C4281d;
import com.alipay.sdk.m.q.C4282e;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4302e;
import com.alipay.sdk.m.u.C4314j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.k.a */
/* loaded from: classes12.dex */
public class C4218a {

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.k.a$a */
    /* loaded from: classes12.dex */
    public static final class C4219a {
        public static final String a = "RecordPref";
        public static final String b = "alipay_cashier_statistic_record";

        public static synchronized String a(Context context, String str, String str2) {
            synchronized (C4219a.class) {
                C4302e.b(a, "stat append " + str2 + " , " + str);
                if (context != null && !TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = UUID.randomUUID().toString();
                    }
                    C4220a a2 = a(context);
                    if (a2.a.size() > 20) {
                        a2.a.clear();
                    }
                    a2.a.put(str2, str);
                    a(context, a2);
                    return str2;
                }
                return null;
            }
        }

        public static synchronized String b(Context context) {
            synchronized (C4219a.class) {
                C4302e.b(a, "stat peek");
                if (context == null) {
                    return null;
                }
                C4220a a2 = a(context);
                if (a2.a.isEmpty()) {
                    return null;
                }
                return a2.a.entrySet().iterator().next().getValue();
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.k.a$a$a */
        /* loaded from: classes12.dex */
        public static final class C4220a {
            public final LinkedHashMap<String, String> a = new LinkedHashMap<>();

            public C4220a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    C4302e.a(th);
                    return new JSONArray().toString();
                }
            }

            public C4220a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    C4302e.a(th);
                }
            }
        }

        public static synchronized int a(Context context, String str) {
            synchronized (C4219a.class) {
                C4302e.b(a, "stat remove " + str);
                if (context != null && !TextUtils.isEmpty(str)) {
                    C4220a a2 = a(context);
                    if (a2.a.isEmpty()) {
                        return 0;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, String> entry : a2.a.entrySet()) {
                        if (str.equals(entry.getValue())) {
                            arrayList.add(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.a.remove((String) it.next());
                    }
                    a(context, a2);
                    return arrayList.size();
                }
                return 0;
            }
        }

        public static synchronized C4220a a(Context context) {
            synchronized (C4219a.class) {
                try {
                    String a2 = C4314j.a(null, context, b, null);
                    if (TextUtils.isEmpty(a2)) {
                        return new C4220a();
                    }
                    return new C4220a(a2);
                } catch (Throwable th) {
                    C4302e.a(th);
                    return new C4220a();
                }
            }
        }

        public static synchronized void a(Context context, C4220a c4220a) {
            synchronized (C4219a.class) {
                if (c4220a == null) {
                    try {
                        c4220a = new C4220a();
                    } catch (Throwable th) {
                        C4302e.a(th);
                    }
                }
                C4314j.b(null, context, b, c4220a.a());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.k.a$b */
    /* loaded from: classes12.dex */
    public static final class C4221b {

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.k.a$b$a */
        /* loaded from: classes12.dex */
        public static class RunnableC4222a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ Context b;

            public RunnableC4222a(String str, Context context) {
                this.a = str;
                this.b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.a) || C4221b.b(this.b, this.a)) {
                    for (int i = 0; i < 4; i++) {
                        String b = C4219a.b(this.b);
                        if (TextUtils.isEmpty(b) || !C4221b.b(this.b, b)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized boolean b(Context context, String str) {
            synchronized (C4221b.class) {
                C4302e.b(C4230a.z, "stat sub " + str);
                if ((C4245a.D().e() ? new C4281d() : new C4282e()).a((C4293a) null, context, str) != null) {
                    C4219a.a(context, str);
                    return true;
                }
                return false;
            }
        }

        public static synchronized void a(Context context, C4226b c4226b, String str, String str2) {
            synchronized (C4221b.class) {
                if (context == null || c4226b == null || str == null) {
                    return;
                }
                a(context, c4226b.a(str), str2);
            }
        }

        public static synchronized void a(Context context) {
            synchronized (C4221b.class) {
                a(context, null, null);
            }
        }

        public static synchronized void a(Context context, String str, String str2) {
            synchronized (C4221b.class) {
                if (context == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    C4219a.a(context, str, str2);
                }
                new Thread(new RunnableC4222a(str, context)).start();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.k.a$c */
    /* loaded from: classes12.dex */
    public static final class C4223c {
        public static final String a = "alipay_cashier_ap_seq_v";

        public static synchronized long a(Context context) {
            long a2;
            synchronized (C4223c.class) {
                a2 = C4224d.a(context, a);
            }
            return a2;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.k.a$d */
    /* loaded from: classes12.dex */
    public static final class C4224d {
        /* JADX WARN: Can't wrap try/catch for region: R(8:3|(2:4|5)|(5:7|8|9|10|11)|17|8|9|10|11) */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static synchronized long a(android.content.Context r6, java.lang.String r7) {
            /*
                java.lang.Class<com.alipay.sdk.m.k.a$d> r0 = com.alipay.sdk.m.k.C4218a.C4224d.class
                monitor-enter(r0)
                r1 = 0
                java.lang.String r2 = com.alipay.sdk.m.u.C4314j.a(r1, r6, r7, r1)     // Catch: java.lang.Throwable -> L13
                boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L13
                if (r3 != 0) goto L13
                long r2 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L13
                goto L15
            L13:
                r2 = 0
            L15:
                r4 = 1
                long r2 = r2 + r4
                java.lang.String r4 = java.lang.Long.toString(r2)     // Catch: java.lang.Throwable -> L1f
                com.alipay.sdk.m.u.C4314j.b(r1, r6, r7, r4)     // Catch: java.lang.Throwable -> L1f
            L1f:
                monitor-exit(r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.k.C4218a.C4224d.a(android.content.Context, java.lang.String):long");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.k.a$e */
    /* loaded from: classes12.dex */
    public static final class C4225e {
        public static final String a = "alipay_cashier_statistic_v";

        public static synchronized long a(Context context) {
            long a2;
            synchronized (C4225e.class) {
                a2 = C4224d.a(context, a);
            }
            return a2;
        }
    }

    public static synchronized void a(Context context, C4293a c4293a, String str, String str2) {
        synchronized (C4218a.class) {
            if (context == null || c4293a == null) {
                return;
            }
            try {
                C4219a.a(context, c4293a.l.a(str), str2);
            } catch (Throwable th) {
                C4302e.a(th);
            }
        }
    }

    public static synchronized void b(Context context, C4293a c4293a, String str, String str2) {
        synchronized (C4218a.class) {
            if (context == null || c4293a == null) {
                return;
            }
            C4221b.a(context, c4293a.l, str, str2);
        }
    }

    public static void b(C4293a c4293a, String str, String str2, String str3) {
        if (c4293a == null) {
            return;
        }
        c4293a.l.b(str, str2, str3);
    }

    public static synchronized void a(Context context) {
        synchronized (C4218a.class) {
            C4221b.a(context);
        }
    }

    public static void a(C4293a c4293a, String str, Throwable th) {
        if (c4293a == null || th == null) {
            return;
        }
        c4293a.l.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(C4293a c4293a, String str, String str2, Throwable th, String str3) {
        if (c4293a == null) {
            return;
        }
        c4293a.l.a(str, str2, th, str3);
    }

    public static void a(C4293a c4293a, String str, String str2, Throwable th) {
        if (c4293a == null) {
            return;
        }
        c4293a.l.a(str, str2, th);
    }

    public static void a(C4293a c4293a, String str, String str2, String str3) {
        if (c4293a == null) {
            return;
        }
        c4293a.l.a(str, str2, str3);
    }

    public static void a(C4293a c4293a, String str, String str2) {
        if (c4293a == null) {
            return;
        }
        c4293a.l.a(str, str2);
    }
}
