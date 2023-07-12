package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.weex.common.Constants;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7662gc;
import com.xiaomi.push.C7667h;
import com.xiaomi.push.C7672hn;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.EnumC7693q;
import com.xiaomi.push.hg;
import com.xiaomi.push.ho;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import tb.m80;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.o */
/* loaded from: classes11.dex */
public class C7764o {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile C7764o a;

    /* renamed from: a  reason: collision with other field name */
    private long f974a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f975a;

    /* renamed from: a  reason: collision with other field name */
    private final SharedPreferences f976a;

    /* renamed from: b  reason: collision with other field name */
    private final boolean f981b;

    /* renamed from: c  reason: collision with other field name */
    private final boolean f982c;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicInteger f978a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    private String f977a = null;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f979a = false;
    private String b = null;

    /* renamed from: b  reason: collision with other field name */
    private final AtomicInteger f980b = new AtomicInteger(0);
    private final AtomicInteger c = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    private int f973a = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.o$a */
    /* loaded from: classes11.dex */
    public static class C7765a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b() {
            return "record_support_wifi_digest_reported";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    private C7764o(Context context) {
        this.f975a = context;
        this.f982c = C7688m.m1119a(context);
        this.f981b = ba.a(context).a(ho.IntelligentHeartbeatSwitchBoolean.a(), true);
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.f976a = sharedPreferences;
        long currentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(C7765a.c(), -1L) == -1) {
            sharedPreferences.edit().putLong(C7765a.c(), currentTimeMillis).apply();
        }
        long j = sharedPreferences.getLong(C7765a.i(), -1L);
        this.f974a = j;
        if (j == -1) {
            this.f974a = currentTimeMillis;
            sharedPreferences.edit().putLong(C7765a.i(), currentTimeMillis).apply();
        }
    }

    private int a() {
        if (TextUtils.isEmpty(this.f977a)) {
            return -1;
        }
        try {
            return this.f976a.getInt(C7765a.a(this.f977a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static C7764o a(Context context) {
        if (a == null) {
            synchronized (C7764o.class) {
                if (a == null) {
                    a = new C7764o(context);
                }
            }
        }
        return a;
    }

    private void a(String str, String str2, Map<String, String> map) {
        C7672hn c7672hn = new C7672hn();
        c7672hn.d(str);
        c7672hn.c("hb_name");
        c7672hn.a("hb_channel");
        c7672hn.a(1L);
        c7672hn.b(str2);
        c7672hn.a(false);
        c7672hn.b(System.currentTimeMillis());
        c7672hn.g(this.f975a.getPackageName());
        c7672hn.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        C7776t m1238a = C7777u.m1238a(this.f975a);
        if (m1238a != null && !TextUtils.isEmpty(m1238a.f996a)) {
            String[] split = m1238a.f996a.split(m80.DINAMIC_PREFIX_AT);
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        map.put("uuid", str3);
        map.put("model", Build.getMODEL());
        Context context = this.f975a;
        map.put("avc", String.valueOf(C7667h.a(context, context.getPackageName())));
        map.put("pvc", String.valueOf(40091));
        map.put("cvc", String.valueOf(48));
        c7672hn.a(map);
        hg a2 = hg.a(this.f975a);
        if (a2 != null) {
            a2.a(c7672hn, this.f975a.getPackageName());
        }
    }

    private void a(boolean z) {
        if (m1218c()) {
            int incrementAndGet = (z ? this.f980b : this.c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            AbstractC7535b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                String d = z ? C7765a.d() : C7765a.e();
                int i = this.f976a.getInt(d, 0) + incrementAndGet;
                this.f976a.edit().putInt(d, i).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i);
                AbstractC7535b.m586a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                (z ? this.f980b : this.c).set(0);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m1216a() {
        return this.f978a.get() >= Math.max(ba.a(this.f975a).a(ho.IntelligentHeartbeatNATCountInt.a(), 5), 3);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private long b() {
        return this.f976a.getLong(C7765a.j(), -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "WIFI-ID-UNKNOWN"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L16
            java.lang.String r10 = r9.f977a
            if (r10 == 0) goto L15
            java.lang.String r0 = "W-"
            boolean r10 = r10.startsWith(r0)
            if (r10 == 0) goto L15
            goto L18
        L15:
            r10 = 0
        L16:
            r9.f977a = r10
        L18:
            android.content.SharedPreferences r10 = r9.f976a
            java.lang.String r0 = r9.f977a
            java.lang.String r0 = com.xiaomi.push.service.C7764o.C7765a.a(r0)
            r1 = -1
            int r10 = r10.getInt(r0, r1)
            android.content.SharedPreferences r0 = r9.f976a
            java.lang.String r2 = r9.f977a
            java.lang.String r2 = com.xiaomi.push.service.C7764o.C7765a.b(r2)
            r3 = -1
            long r5 = r0.getLong(r2, r3)
            long r7 = java.lang.System.currentTimeMillis()
            if (r10 == r1) goto L75
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 != 0) goto L56
            android.content.SharedPreferences r10 = r9.f976a
            android.content.SharedPreferences$Editor r10 = r10.edit()
            java.lang.String r0 = r9.f977a
            java.lang.String r0 = com.xiaomi.push.service.C7764o.C7765a.b(r0)
            long r2 = r9.c()
            long r7 = r7 + r2
            android.content.SharedPreferences$Editor r10 = r10.putLong(r0, r7)
        L52:
            r10.apply()
            goto L75
        L56:
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 <= 0) goto L75
            android.content.SharedPreferences r10 = r9.f976a
            android.content.SharedPreferences$Editor r10 = r10.edit()
            java.lang.String r0 = r9.f977a
            java.lang.String r0 = com.xiaomi.push.service.C7764o.C7765a.a(r0)
            android.content.SharedPreferences$Editor r10 = r10.remove(r0)
            java.lang.String r0 = r9.f977a
            java.lang.String r0 = com.xiaomi.push.service.C7764o.C7765a.b(r0)
            android.content.SharedPreferences$Editor r10 = r10.remove(r0)
            goto L52
        L75:
            java.util.concurrent.atomic.AtomicInteger r10 = r9.f978a
            r0 = 0
            r10.getAndSet(r0)
            java.lang.String r10 = r9.f977a
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            r2 = 1
            if (r10 != 0) goto L8e
            int r10 = r9.a()
            if (r10 == r1) goto L8b
            goto L8e
        L8b:
            r9.f979a = r2
            goto L90
        L8e:
            r9.f979a = r0
        L90:
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.String r1 = r9.f977a
            r10[r0] = r1
            boolean r0 = r9.f979a
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r10[r2] = r0
            java.lang.String r0 = "[HB] network changed, netid:%s, %s"
            java.lang.String r10 = java.lang.String.format(r0, r10)
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.m586a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C7764o.b(java.lang.String):void");
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m1217b() {
        return (TextUtils.isEmpty(this.f977a) || !this.f977a.startsWith("M-") || ba.a(this.f975a).a(ho.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) ? false : true;
    }

    private long c() {
        return ba.a(this.f975a).a(ho.ShortHeartbeatEffectivePeriodMsLong.a(), 777600000L);
    }

    private void c(String str) {
        if (a(str)) {
            this.f976a.edit().putInt(C7765a.a(str), 235000).apply();
            this.f976a.edit().putLong(C7765a.b(this.f977a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m1218c() {
        return d() && ba.a(this.f975a).a(ho.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true) && EnumC7693q.China.name().equals(C7718a.a(this.f975a).a());
    }

    private void d(String str) {
        String str2;
        String str3;
        if (m1218c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = ExifInterface.LONGITUDE_WEST;
            } else if (!str.startsWith("M-")) {
                return;
            } else {
                str2 = "M";
            }
            String valueOf = String.valueOf(235000);
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append(valueOf);
            sb.append(":::");
            sb.append(valueOf2);
            String string = this.f976a.getString(C7765a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f976a.edit().putString(C7765a.f(), str3).apply();
        }
    }

    private boolean d() {
        return this.f982c && (this.f981b || ((b() > System.currentTimeMillis() ? 1 : (b() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    private void e() {
        if (this.f976a.getBoolean(C7765a.a(), false)) {
            return;
        }
        this.f976a.edit().putBoolean(C7765a.a(), true).apply();
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m1219e() {
        long j = this.f976a.getLong(C7765a.c(), -1L);
        if (j == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void f() {
        int i = this.f973a;
        String h = i != 0 ? i != 1 ? null : C7765a.h() : C7765a.g();
        if (TextUtils.isEmpty(h)) {
            return;
        }
        if (this.f976a.getLong(C7765a.i(), -1L) == -1) {
            this.f974a = System.currentTimeMillis();
            this.f976a.edit().putLong(C7765a.i(), this.f974a).apply();
        }
        this.f976a.edit().putInt(h, this.f976a.getInt(h, 0) + 1).apply();
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m1220f() {
        if (this.f974a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f974a;
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void g() {
        int i;
        String[] split;
        String[] split2;
        if (m1218c()) {
            String string = this.f976a.getString(C7765a.f(), null);
            char c = 1;
            char c2 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i2 = 0;
                while (i2 < split.length) {
                    if (!TextUtils.isEmpty(split[i2]) && (split2 = split[i2].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c2];
                        String str2 = split2[c];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", Constants.Event.CHANGE);
                        hashMap.put("model", Build.getMODEL());
                        hashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, str2);
                        hashMap.put("net_name", str);
                        hashMap.put(Constants.Name.INTERVAL, str3);
                        hashMap.put("timestamp", str4);
                        a("category_hb_change", null, hashMap);
                        AbstractC7535b.m586a("[HB] report hb changed events.");
                    }
                    i2++;
                    c = 1;
                    c2 = 0;
                }
                this.f976a.edit().remove(C7765a.f()).apply();
            }
            if (this.f976a.getBoolean(C7765a.a(), false) && !this.f976a.getBoolean(C7765a.b(), false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event", "support");
                hashMap2.put("model", Build.getMODEL());
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, hashMap2);
                AbstractC7535b.m586a("[HB] report support wifi digest events.");
                this.f976a.edit().putBoolean(C7765a.b(), true).apply();
            }
            if (m1219e()) {
                int i3 = this.f976a.getInt(C7765a.d(), 0);
                int i4 = this.f976a.getInt(C7765a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j = this.f976a.getLong(C7765a.c(), -1L);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Constants.Name.INTERVAL, valueOf);
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put(AdUtConstants.XAD_UT_ARG_COUNT, String.valueOf(i3 + i4));
                        jSONObject.put("start_time", valueOf2);
                        jSONObject.put("end_time", valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        AbstractC7535b.m586a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f976a.edit().putInt(C7765a.d(), 0).putInt(C7765a.e(), 0).putLong(C7765a.c(), System.currentTimeMillis()).apply();
            }
            if (m1220f()) {
                String valueOf4 = String.valueOf(this.f974a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f976a.getInt(C7765a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, "M");
                        jSONObject3.put("ptc", i5);
                        jSONObject3.put("start_time", valueOf4);
                        jSONObject3.put("end_time", valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        AbstractC7535b.m586a("[HB] report ping timeout count events of mobile network.");
                        this.f976a.edit().putInt(C7765a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f976a.edit().putInt(C7765a.g(), 0).apply();
                    }
                }
                i = 0;
                int i6 = this.f976a.getInt(C7765a.h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, ExifInterface.LONGITUDE_WEST);
                        jSONObject5.put("ptc", i6);
                        jSONObject5.put("start_time", valueOf4);
                        jSONObject5.put("end_time", valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        AbstractC7535b.m586a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f976a.edit().putInt(C7765a.h(), 0).apply();
                }
                this.f974a = System.currentTimeMillis();
                this.f976a.edit().putLong(C7765a.i(), this.f974a).apply();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m1221a() {
        int a2;
        long b = C7662gc.b();
        if (this.f982c && !m1217b() && ((ba.a(this.f975a).a(ho.IntelligentHeartbeatSwitchBoolean.a(), true) || b() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
            b = a2;
        }
        if (!TextUtils.isEmpty(this.f977a) && !"WIFI-ID-UNKNOWN".equals(this.f977a) && this.f973a == 1) {
            a(b < 300000);
        }
        AbstractC7535b.m586a("[HB] ping interval:" + b);
        return b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1222a() {
    }

    public void a(int i) {
        this.f976a.edit().putLong(C7765a.j(), System.currentTimeMillis() + (i * 1000)).apply();
    }

    public synchronized void a(NetworkInfo networkInfo) {
        if (d()) {
            String str = null;
            if (networkInfo == null) {
                b(null);
            } else if (networkInfo.getType() == 0) {
                String subtypeName = networkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName) && !"UNKNOWN".equalsIgnoreCase(subtypeName)) {
                    str = "M-" + subtypeName;
                }
                b(str);
                this.f973a = 0;
            } else {
                if (networkInfo.getType() != 1 && networkInfo.getType() != 6) {
                    b(null);
                }
                b("WIFI-ID-UNKNOWN");
                this.f973a = 1;
            }
            this.f973a = -1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m1223a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m1224b() {
        if (d()) {
            f();
            if (this.f979a && !TextUtils.isEmpty(this.f977a) && this.f977a.equals(this.b)) {
                this.f978a.getAndIncrement();
                AbstractC7535b.m586a("[HB] ping timeout count:" + this.f978a);
                if (m1216a()) {
                    AbstractC7535b.m586a("[HB] change hb interval for net:" + this.f977a);
                    c(this.f977a);
                    this.f979a = false;
                    this.f978a.getAndSet(0);
                    d(this.f977a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m1225c() {
        if (d()) {
            this.b = this.f977a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m1226d() {
        if (d()) {
            g();
            if (this.f979a) {
                this.f978a.getAndSet(0);
            }
        }
    }
}
