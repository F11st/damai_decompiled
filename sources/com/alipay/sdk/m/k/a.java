package com.alipay.sdk.m.k;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class a {

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C0189a {
        public static final String a = "RecordPref";
        public static final String b = "alipay_cashier_statistic_record";

        public static synchronized String a(Context context, String str, String str2) {
            synchronized (C0189a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat append " + str2 + " , " + str);
                if (context != null && !TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = UUID.randomUUID().toString();
                    }
                    C0190a a2 = a(context);
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
            synchronized (C0189a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat peek");
                if (context == null) {
                    return null;
                }
                C0190a a2 = a(context);
                if (a2.a.isEmpty()) {
                    return null;
                }
                return a2.a.entrySet().iterator().next().getValue();
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.k.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C0190a {
            public final LinkedHashMap<String, String> a = new LinkedHashMap<>();

            public C0190a() {
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
                    com.alipay.sdk.m.u.e.a(th);
                    return new JSONArray().toString();
                }
            }

            public C0190a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                }
            }
        }

        public static synchronized int a(Context context, String str) {
            synchronized (C0189a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat remove " + str);
                if (context != null && !TextUtils.isEmpty(str)) {
                    C0190a a2 = a(context);
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

        public static synchronized C0190a a(Context context) {
            synchronized (C0189a.class) {
                try {
                    String a2 = j.a(null, context, b, null);
                    if (TextUtils.isEmpty(a2)) {
                        return new C0190a();
                    }
                    return new C0190a(a2);
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return new C0190a();
                }
            }
        }

        public static synchronized void a(Context context, C0190a c0190a) {
            synchronized (C0189a.class) {
                if (c0190a == null) {
                    try {
                        c0190a = new C0190a();
                    } catch (Throwable th) {
                        com.alipay.sdk.m.u.e.a(th);
                    }
                }
                j.b(null, context, b, c0190a.a());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class b {

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static class RunnableC0191a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ Context b;

            public RunnableC0191a(String str, Context context) {
                this.a = str;
                this.b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.a) || b.b(this.b, this.a)) {
                    for (int i = 0; i < 4; i++) {
                        String b = C0189a.b(this.b);
                        if (TextUtils.isEmpty(b) || !b.b(this.b, b)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized boolean b(Context context, String str) {
            synchronized (b.class) {
                com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "stat sub " + str);
                if ((com.alipay.sdk.m.m.a.D().e() ? new com.alipay.sdk.m.q.d() : new com.alipay.sdk.m.q.e()).a((com.alipay.sdk.m.s.a) null, context, str) != null) {
                    C0189a.a(context, str);
                    return true;
                }
                return false;
            }
        }

        public static synchronized void a(Context context, com.alipay.sdk.m.k.b bVar, String str, String str2) {
            synchronized (b.class) {
                if (context == null || bVar == null || str == null) {
                    return;
                }
                a(context, bVar.a(str), str2);
            }
        }

        public static synchronized void a(Context context) {
            synchronized (b.class) {
                a(context, null, null);
            }
        }

        public static synchronized void a(Context context, String str, String str2) {
            synchronized (b.class) {
                if (context == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    C0189a.a(context, str, str2);
                }
                new Thread(new RunnableC0191a(str, context)).start();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class c {
        public static final String a = "alipay_cashier_ap_seq_v";

        public static synchronized long a(Context context) {
            long a2;
            synchronized (c.class) {
                a2 = d.a(context, a);
            }
            return a2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class d {
        /* JADX WARN: Can't wrap try/catch for region: R(8:3|(2:4|5)|(5:7|8|9|10|11)|17|8|9|10|11) */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static synchronized long a(android.content.Context r6, java.lang.String r7) {
            /*
                java.lang.Class<com.alipay.sdk.m.k.a$d> r0 = com.alipay.sdk.m.k.a.d.class
                monitor-enter(r0)
                r1 = 0
                java.lang.String r2 = com.alipay.sdk.m.u.j.a(r1, r6, r7, r1)     // Catch: java.lang.Throwable -> L13
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
                com.alipay.sdk.m.u.j.b(r1, r6, r7, r4)     // Catch: java.lang.Throwable -> L1f
            L1f:
                monitor-exit(r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.k.a.d.a(android.content.Context, java.lang.String):long");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class e {
        public static final String a = "alipay_cashier_statistic_v";

        public static synchronized long a(Context context) {
            long a2;
            synchronized (e.class) {
                a2 = d.a(context, a);
            }
            return a2;
        }
    }

    public static synchronized void a(Context context, com.alipay.sdk.m.s.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context == null || aVar == null) {
                return;
            }
            try {
                C0189a.a(context, aVar.l.a(str), str2);
            } catch (Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
            }
        }
    }

    public static synchronized void b(Context context, com.alipay.sdk.m.s.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context == null || aVar == null) {
                return;
            }
            b.a(context, aVar.l, str, str2);
        }
    }

    public static void b(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.b(str, str2, str3);
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            b.a(context);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, Throwable th) {
        if (aVar == null || th == null) {
            return;
        }
        aVar.l.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, th, str3);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, th);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, str3);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2);
    }
}
