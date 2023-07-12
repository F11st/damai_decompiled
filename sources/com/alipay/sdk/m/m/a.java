package com.alipay.sdk.m.m;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.j;
import com.alipay.sdk.m.u.n;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class a {
    public static final String A0 = "cfg_max_time";
    public static final String B0 = "get_oa_id";
    public static final String C0 = "notifyFailApp";
    public static final String D0 = "startactivity_in_ui_thread";
    public static final String E = "DynCon";
    public static final String E0 = "scheme_pay_2";
    public static final int F = 10000;
    public static final String F0 = "intercept_batch";
    public static final String G = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final String G0 = "bind_with_startActivity";
    public static final int H = 10;
    public static final String H0 = "startActivity_InsteadOf_Scheme";
    public static final boolean I = true;
    public static final String I0 = "enableStartActivityFallback";
    public static final boolean J = true;
    public static final String J0 = "enableBindExFallback";
    public static final boolean K = false;
    public static a K0 = null;
    public static final boolean L = true;
    public static final boolean M = true;
    public static final String N = "";
    public static final boolean O = false;
    public static final boolean P = false;
    public static final boolean Q = false;
    public static final boolean R = false;
    public static final boolean S = true;
    public static final String T = "";
    public static final boolean U = false;
    public static final boolean V = false;
    public static final boolean W = false;
    public static final int X = 1000;
    public static final boolean Y = true;
    public static final String Z = "";
    public static final boolean a0 = false;
    public static final boolean b0 = false;
    public static final boolean c0 = false;
    public static final int d0 = 1000;
    public static final int e0 = 20000;
    public static final boolean f0 = false;
    public static final String g0 = "alipay_cashier_dynamic_config";
    public static final String h0 = "timeout";
    public static final String i0 = "h5_port_degrade";
    public static final String j0 = "st_sdk_config";
    public static final String k0 = "tbreturl";
    public static final String l0 = "launchAppSwitch";
    public static final String m0 = "configQueryInterval";
    public static final String n0 = "deg_log_mcgw";
    public static final String o0 = "deg_start_srv_first";
    public static final String p0 = "prev_jump_dual";
    public static final String q0 = "use_sc_only";
    public static final String r0 = "retry_aidl_activity_not_start";
    public static final String s0 = "bind_use_imp";
    public static final String t0 = "retry_bnd_once";
    public static final String u0 = "skip_trans";
    public static final String v0 = "start_trans";
    public static final String w0 = "up_before_pay";
    public static final String x0 = "lck_k";
    public static final String y0 = "use_sc_lck_a";
    public static final String z0 = "utdid_factor";
    public JSONObject A;
    public int a = 10000;
    public boolean b = false;
    public String c = G;
    public int d = 10;
    public boolean e = true;
    public boolean f = true;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = true;
    public boolean k = true;
    public String l = "";
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = true;
    public String r = "";
    public String s = "";
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public int y = 1000;
    public boolean z = false;
    public boolean B = true;
    public List<b> C = null;
    public int D = -1;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class RunnableC0195a implements Runnable {
        public final /* synthetic */ com.alipay.sdk.m.s.a a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        public RunnableC0195a(com.alipay.sdk.m.s.a aVar, Context context, boolean z, int i) {
            this.a = aVar;
            this.b = context;
            this.c = z;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alipay.sdk.m.p.b a = new com.alipay.sdk.m.q.b().a(this.a, this.b);
                if (a != null) {
                    a.this.G(this.a, a.a());
                    a.this.F(com.alipay.sdk.m.s.a.h());
                    com.alipay.sdk.m.s.a aVar = this.a;
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "offcfg|" + this.c + "|" + this.d);
                }
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }

    private int C() {
        return this.y;
    }

    public static a D() {
        if (K0 == null) {
            a aVar = new a();
            K0 = aVar;
            aVar.t();
        }
        return K0;
    }

    private JSONObject E() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeout", k());
        jSONObject.put(i0, y());
        jSONObject.put(k0, r());
        jSONObject.put(m0, d());
        jSONObject.put(l0, b.a(l()));
        jSONObject.put(E0, i());
        jSONObject.put(F0, h());
        jSONObject.put(n0, e());
        jSONObject.put(o0, f());
        jSONObject.put(p0, m());
        jSONObject.put(q0, g());
        jSONObject.put(s0, b());
        jSONObject.put(t0, n());
        jSONObject.put(u0, p());
        jSONObject.put(v0, B());
        jSONObject.put(w0, s());
        jSONObject.put(y0, o());
        jSONObject.put(x0, j());
        jSONObject.put(G0, c());
        jSONObject.put(H0, q());
        jSONObject.put(r0, A());
        jSONObject.put(A0, C());
        jSONObject.put(B0, x());
        jSONObject.put(C0, v());
        jSONObject.put(I0, w());
        jSONObject.put(J0, u());
        jSONObject.put(D0, z());
        jSONObject.put(com.alipay.sdk.m.u.a.b, a());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(com.alipay.sdk.m.s.a aVar) {
        try {
            JSONObject E2 = E();
            j.b(aVar, com.alipay.sdk.m.s.b.d().b(), g0, E2.toString());
        } catch (Exception e) {
            e.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(com.alipay.sdk.m.s.a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject(j0);
            com.alipay.sdk.m.u.a.a(aVar, optJSONObject, com.alipay.sdk.m.u.a.a(aVar, jSONObject));
            if (optJSONObject != null) {
                I(optJSONObject);
            } else {
                e.e(E, "empty config");
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }

    private void H(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            I(new JSONObject(str));
        } catch (Throwable th) {
            e.a(th);
        }
    }

    private void I(JSONObject jSONObject) {
        this.a = jSONObject.optInt("timeout", 10000);
        this.b = jSONObject.optBoolean(i0, false);
        this.c = jSONObject.optString(k0, G).trim();
        this.d = jSONObject.optInt(m0, 10);
        this.C = b.a(jSONObject.optJSONArray(l0));
        this.e = jSONObject.optBoolean(E0, true);
        this.f = jSONObject.optBoolean(F0, true);
        this.i = jSONObject.optBoolean(n0, false);
        this.j = jSONObject.optBoolean(o0, true);
        this.k = jSONObject.optBoolean(p0, true);
        this.l = jSONObject.optString(q0, "");
        this.m = jSONObject.optBoolean(s0, false);
        this.n = jSONObject.optBoolean(t0, false);
        this.o = jSONObject.optBoolean(u0, false);
        this.p = jSONObject.optBoolean(v0, false);
        this.q = jSONObject.optBoolean(w0, true);
        this.r = jSONObject.optString(x0, "");
        this.w = jSONObject.optBoolean(y0, false);
        this.x = jSONObject.optBoolean(r0, false);
        this.z = jSONObject.optBoolean(C0, false);
        this.s = jSONObject.optString(G0, "");
        this.t = jSONObject.optBoolean(H0, false);
        this.y = jSONObject.optInt(A0, 1000);
        this.B = jSONObject.optBoolean(B0, true);
        this.u = jSONObject.optBoolean(I0, false);
        this.v = jSONObject.optBoolean(J0, false);
        this.g = jSONObject.optBoolean(D0, false);
        this.A = jSONObject.optJSONObject(com.alipay.sdk.m.u.a.b);
    }

    public boolean A() {
        return this.x;
    }

    public boolean B() {
        return this.p;
    }

    public boolean b() {
        return this.m;
    }

    public String c() {
        return this.s;
    }

    public int d() {
        return this.d;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public String g() {
        return this.l;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return this.e;
    }

    public String j() {
        return this.r;
    }

    public int k() {
        int i = this.a;
        if (i >= 1000 && i <= 20000) {
            e.b(E, "time = " + this.a);
            return this.a;
        }
        e.b(E, "time(def) = 10000");
        return 10000;
    }

    public List<b> l() {
        return this.C;
    }

    public boolean m() {
        return this.k;
    }

    public boolean n() {
        return this.n;
    }

    public boolean o() {
        return this.w;
    }

    public boolean p() {
        return this.o;
    }

    public boolean q() {
        return this.t;
    }

    public String r() {
        return this.c;
    }

    public boolean s() {
        return this.q;
    }

    public void t() {
        Context b2 = com.alipay.sdk.m.s.b.d().b();
        String a = j.a(com.alipay.sdk.m.s.a.h(), b2, g0, null);
        try {
            this.D = Integer.parseInt(j.a(com.alipay.sdk.m.s.a.h(), b2, z0, "-1"));
        } catch (Exception unused) {
        }
        H(a);
    }

    public boolean u() {
        return this.v;
    }

    public boolean v() {
        return this.z;
    }

    public boolean w() {
        return this.u;
    }

    public boolean x() {
        return this.B;
    }

    public boolean y() {
        return this.b;
    }

    public boolean z() {
        return this.g;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class b {
        public final String a;
        public final int b;
        public final String c;

        public b(String str, int i, String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optString(IRequestConst.PN), jSONObject.optInt("v", 0), jSONObject.optString(PushConstants.URI_PACKAGE_NAME));
        }

        public String toString() {
            return String.valueOf(a(this));
        }

        public static List<b> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                b a = a(jSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }

        public static JSONObject a(b bVar) {
            if (bVar == null) {
                return null;
            }
            try {
                return new JSONObject().put(IRequestConst.PN, bVar.a).put("v", bVar.b).put(PushConstants.URI_PACKAGE_NAME, bVar.c);
            } catch (JSONException e) {
                e.a(e);
                return null;
            }
        }

        public static JSONArray a(List<b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                jSONArray.put(a(bVar));
            }
            return jSONArray;
        }
    }

    public JSONObject a() {
        return this.A;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(com.alipay.sdk.m.s.a aVar, Context context, boolean z, int i) {
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "oncfg|" + z + "|" + i);
        RunnableC0195a runnableC0195a = new RunnableC0195a(aVar, context, z, i);
        if (z && !n.h()) {
            int C = C();
            if (n.a(C, runnableC0195a, "AlipayDCPBlok")) {
                return;
            }
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.m0, "" + C);
            return;
        }
        Thread thread = new Thread(runnableC0195a);
        thread.setName("AlipayDCP");
        thread.start();
    }

    public boolean a(Context context, int i) {
        if (this.D == -1) {
            this.D = n.a();
            j.b(com.alipay.sdk.m.s.a.h(), context, z0, String.valueOf(this.D));
        }
        return this.D < i;
    }
}
