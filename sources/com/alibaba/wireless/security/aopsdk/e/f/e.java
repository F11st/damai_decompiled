package com.alibaba.wireless.security.aopsdk.e.f;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: RuleConfig.java */
/* loaded from: classes.dex */
public class e extends c {
    public static final int A = 4;
    public static final int B = 8;
    public static final int C = 16;
    public static final int D = 32;
    public static final int E = 0;
    public static final int F = 1;
    public static final int G = 2;
    private static final String H = "AOP-RuleConfig";
    public static final int x = 0;
    public static final int y = 1;
    public static final int z = 2;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = ReportManager.e, type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int m;
    @com.alibaba.wireless.security.aopsdk.e.e.a(handler = b.class, key = "cond", type = com.alibaba.wireless.security.aopsdk.e.e.b.JSON)
    public b n;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "brk", type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int o;
    @com.alibaba.wireless.security.aopsdk.e.e.a(handler = a.class, key = "arg", type = com.alibaba.wireless.security.aopsdk.e.e.b.JSON)
    public a s;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "ret", type = com.alibaba.wireless.security.aopsdk.e.e.b.OBJECT)
    public Object t;
    private com.alibaba.wireless.security.aopsdk.g.a v;
    public Throwable w;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = SocialConstants.PARAM_ACT, type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int p = -1;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "lmt", type = com.alibaba.wireless.security.aopsdk.e.e.b.DOUBLE)
    public double q = -1.0d;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "crt", type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int r = -1;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = IRequestConst.CS, type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int u = 5;

    /* compiled from: RuleConfig.java */
    /* loaded from: classes.dex */
    public static class a extends com.alibaba.wireless.security.aopsdk.e.f.a {
        public Map<Integer, Object> d;

        @Override // com.alibaba.wireless.security.aopsdk.e.f.a
        public void b(JSONObject jSONObject) {
            this.d = new HashMap();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (TextUtils.isDigitsOnly(next)) {
                        try {
                            this.d.put(Integer.valueOf(Integer.parseInt(next)), jSONObject.get(next));
                        } catch (JSONException e) {
                            com.alibaba.wireless.security.aopsdk.i.a.a(com.alibaba.wireless.security.aopsdk.e.f.a.c, "", e);
                        }
                    }
                }
            }
        }
    }

    public e() {
        this.f = 1;
    }

    public boolean a(Invocation invocation) {
        return this.v.a(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.e.f.c, com.alibaba.wireless.security.aopsdk.e.f.a
    public void b(JSONObject jSONObject) {
        super.b(jSONObject);
        com.alibaba.wireless.security.aopsdk.e.f.a a2 = a();
        if (a2 instanceof f) {
            com.alibaba.wireless.security.aopsdk.e.f.a a3 = a2.a();
            if (a3 instanceof d) {
                String str = ((d) a3).d;
                if (str.contains(jn1.BRACKET_START_STR) && !str.contains("()")) {
                    com.alibaba.wireless.security.aopsdk.g.c cVar = new com.alibaba.wireless.security.aopsdk.g.c(this.q);
                    this.v = cVar;
                    cVar.a(this.u);
                }
            }
        }
        if (this.v == null) {
            this.v = new com.alibaba.wireless.security.aopsdk.g.b(this.q);
        }
    }

    public Throwable c(Invocation invocation) {
        return this.v.c(invocation);
    }

    public Map<Integer, Object> d() {
        a aVar = this.s;
        return aVar != null ? aVar.d : new HashMap();
    }

    public Throwable e(Invocation invocation) {
        return this.w;
    }

    public boolean f(Invocation invocation) {
        return this.v.f(invocation);
    }

    public boolean g(Invocation invocation) {
        b bVar = this.n;
        return bVar == null || bVar.a(invocation);
    }

    public void h(Invocation invocation) {
        this.v.g(invocation);
    }

    public synchronized void i(Invocation invocation) {
        this.v.e(invocation);
    }

    public void a(Throwable th) {
        this.w = th;
    }

    public Object d(Invocation invocation) {
        return this.t;
    }

    public Object b(Invocation invocation) {
        return this.v.b(invocation);
    }
}
