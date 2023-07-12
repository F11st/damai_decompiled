package com.alibaba.analytics.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.config.b;
import com.alibaba.analytics.core.config.d;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.sync.UploadMode;
import com.alibaba.analytics.core.sync.g;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.delegate.a;
import com.ut.mini.UTAnalyticsDelegate;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import tb.ga;
import tb.pq;
import tb.u6;
import tb.we2;
import tb.xs2;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class Variables {
    public static final Variables s_instance = new Variables();
    private String a;
    private Context b = null;
    private String c = null;
    private volatile IUTRequestAuthentication d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private boolean m = false;
    private String n = null;
    private Map<String, String> o = null;
    private boolean p = false;
    private volatile boolean q = false;
    private pq r = null;
    private d s = null;
    private volatile String t = null;
    private volatile boolean u = false;
    private String v = "";
    private long w = 0;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private String D = null;
    private boolean E = false;

    private void E() {
        Context context = this.b;
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("UTRealTimeDebug", 0);
        long j = sharedPreferences.getLong("debug_date", 0L);
        Logger.f("", "debugDate", Long.valueOf(j));
        if (System.currentTimeMillis() - j <= 14400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("debug_api_url", sharedPreferences.getString("debug_api_url", ""));
            hashMap.put("debug_key", sharedPreferences.getString("debug_key", ""));
            a(hashMap);
        }
    }

    public static boolean L() {
        return true;
    }

    private void Z(String str) {
        this.a = str;
    }

    private void a(Map<String, String> map) {
        Logger.d();
        if ("0".equalsIgnoreCase(SystemConfigMgr.i().h("real_time_debug"))) {
            Logger.v("Variables", "Server Config turn off RealTimeDebug Mode!");
        } else if (b.a()) {
            Logger.v("Variables", "Server Config(disable_ut_debug) turn off RealTimeDebug Mode!");
        } else if (map != null && map.containsKey("debug_api_url") && map.containsKey("debug_key")) {
            String str = map.get("debug_key");
            if (!yh2.f(map.get("debug_api_url")) && !yh2.f(str)) {
                a0();
                U(str);
            }
            if (map.containsKey("debug_sampling_option")) {
                V();
            }
            T(true);
            g.p().t(UploadMode.REALTIME);
        }
    }

    private void f0(String str) {
        this.k = str;
        if (yh2.f(str)) {
            return;
        }
        this.l = str;
    }

    private void g0(String str) {
        this.i = str;
        if (yh2.f(str)) {
            return;
        }
        this.j = str;
    }

    private void h0(String str) {
        this.g = str;
        if (yh2.f(str)) {
            return;
        }
        this.h = str;
    }

    private void i0(String str) {
        Context context = this.b;
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                if (TextUtils.isEmpty(str)) {
                    edit.putString("_openid", null);
                } else {
                    edit.putString("_openid", new String(ga.c(str.getBytes("UTF-8"), 2)));
                }
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void j0(Map<String, String> map) {
        if (this.b == null) {
            return;
        }
        Logger.e("", map);
        SharedPreferences.Editor edit = this.b.getSharedPreferences("UTRealTimeDebug", 0).edit();
        if (map != null && map.containsKey("debug_store")) {
            edit.putString("debug_api_url", map.get("debug_api_url"));
            edit.putString("debug_key", map.get("debug_key"));
            edit.putLong("debug_date", System.currentTimeMillis());
        } else {
            edit.putLong("debug_date", 0L);
        }
        edit.commit();
    }

    private void k0(String str) {
        Context context;
        if (yh2.f(str) || (context = this.b) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
            edit.putString("_luid", new String(ga.c(str.getBytes("UTF-8"), 2)));
            edit.commit();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void l0(String str) {
        Context context = this.b;
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                if (TextUtils.isEmpty(str)) {
                    edit.putString("_usersite", null);
                } else {
                    edit.putString("_usersite", new String(ga.c(str.getBytes("UTF-8"), 2)));
                }
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void m0(String str) {
        Context context;
        if (yh2.f(str) || (context = this.b) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
            edit.putString("_lun", new String(ga.c(str.getBytes("UTF-8"), 2)));
            edit.commit();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static Variables n() {
        return s_instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        try {
            Map<String, String> e = u6.e(this.b);
            if (e == null || e.size() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(LogField.EVENTID.toString(), "1021");
            hashMap.putAll(e);
            UTAnalyticsDelegate.getInstance().transferLog(hashMap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void o() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("UTCommon", 0);
        String string = sharedPreferences.getString("_lun", "");
        if (!yh2.f(string)) {
            try {
                this.h = new String(ga.a(string.getBytes(), 2), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String string2 = sharedPreferences.getString("_luid", "");
        if (!yh2.f(string2)) {
            try {
                this.j = new String(ga.a(string2.getBytes(), 2), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        String string3 = sharedPreferences.getString("_openid", "");
        if (!yh2.f(string3)) {
            try {
                this.a = new String(ga.a(string3.getBytes(), 2), "UTF-8");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        String string4 = sharedPreferences.getString("_usersite", "");
        if (yh2.f(string4)) {
            return;
        }
        try {
            this.l = new String(ga.a(string4.getBytes(), 2), "UTF-8");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void w0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g0(null);
            Z(null);
        } else if (TextUtils.isEmpty(str2) && str.equals(this.i)) {
        } else {
            g0(str);
            Z(str2);
            k0(str);
            i0(str2);
        }
    }

    public String A() {
        return this.k;
    }

    public String B() {
        return this.i;
    }

    public String C() {
        return this.g;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:27:0x0093
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public synchronized void D(android.app.Application r8) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.core.Variables.D(android.app.Application):void");
    }

    public synchronized boolean F() {
        return this.x;
    }

    public boolean G() {
        return this.u;
    }

    public boolean H() {
        if (this.C) {
            return this.B;
        }
        Context j = j();
        if (j == null) {
            return false;
        }
        if ("1".equalsIgnoreCase(u6.f(j, "package_type"))) {
            this.B = true;
            this.C = true;
        }
        return this.B;
    }

    public boolean I() {
        return this.A;
    }

    public synchronized boolean J() {
        return this.y;
    }

    public boolean K() {
        return this.q;
    }

    public synchronized boolean M() {
        return this.m;
    }

    public synchronized boolean N() {
        return this.z;
    }

    public boolean O() {
        return false;
    }

    public synchronized void P() {
        this.m = false;
    }

    public synchronized void Q(boolean z) {
        this.x = z;
    }

    public void R(String str) {
        this.f = str;
    }

    public void S(String str) {
        Logger.f(null, str, str);
        this.e = str;
    }

    public void T(boolean z) {
        Logger.s(z);
    }

    public synchronized void U(String str) {
        this.n = str;
    }

    public synchronized void V() {
        this.p = true;
        a.a = true;
    }

    public void W(boolean z) {
        this.A = z;
    }

    public synchronized void X(boolean z) {
        this.y = z;
    }

    public void Y(long j) {
        this.w = j;
    }

    public synchronized void a0() {
        this.m = true;
    }

    public synchronized void b0(boolean z) {
        this.z = z;
    }

    public void c0(IUTRequestAuthentication iUTRequestAuthentication) {
        this.d = iUTRequestAuthentication;
        if (iUTRequestAuthentication != null) {
            this.c = iUTRequestAuthentication.getAppkey();
        }
    }

    public synchronized void d0(Map<String, String> map) {
        this.o = map;
    }

    public void e0(String str) {
        this.t = str;
    }

    public String f() {
        Map<String, String> b;
        if (TextUtils.isEmpty(this.f) && (b = xs2.b(j())) != null) {
            this.f = b.get(LogField.APPVERSION);
        }
        return this.f;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        if (TextUtils.isEmpty(this.e)) {
            String a = we2.a(j(), "channel");
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
        }
        return this.e;
    }

    public d i() {
        return this.s;
    }

    public Context j() {
        return this.b;
    }

    public pq k() {
        return this.r;
    }

    public synchronized String l() {
        return this.n;
    }

    public synchronized boolean m() {
        if (b.a()) {
            return false;
        }
        return this.p;
    }

    @Deprecated
    public void o0() {
    }

    public String p() {
        return this.h;
    }

    public void p0() {
        P();
        U(null);
        g.p().t(UploadMode.INTERVAL);
        j0(null);
        this.u = false;
    }

    public String q() {
        return this.l;
    }

    public void q0() {
    }

    public String r() {
        return this.j;
    }

    public void r0() {
        T(true);
    }

    public long s() {
        return this.w;
    }

    public void s0(Map<String, String> map) {
        a(map);
        j0(map);
    }

    public String t() {
        return this.v;
    }

    public void t0() {
    }

    public String u() {
        return this.a;
    }

    @Deprecated
    public void u0(String str, String str2, String str3) {
        h0(str);
        w0(str2, str3);
        m0(str);
    }

    public String v() {
        if (this.E) {
            return this.D;
        }
        Context j = j();
        if (j == null) {
            return null;
        }
        String f = u6.f(j, "build_id");
        this.D = f;
        this.E = true;
        return f;
    }

    public void v0(String str, String str2, String str3, String str4) {
        h0(str);
        f0(str4);
        w0(str2, str3);
        m0(str);
        l0(str4);
    }

    public IUTRequestAuthentication w() {
        return this.d;
    }

    public synchronized Map<String, String> x() {
        return this.o;
    }

    public String y() {
        return this.t;
    }

    public String z() {
        if (this.t != null) {
            return "" + this.t.hashCode();
        }
        return null;
    }
}
