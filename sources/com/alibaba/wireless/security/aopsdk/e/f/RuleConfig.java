package com.alibaba.wireless.security.aopsdk.e.f;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.e.e.AopAttribute;
import com.alibaba.wireless.security.aopsdk.e.e.AopAttributeType;
import com.alibaba.wireless.security.aopsdk.g.ICachePolicy;
import com.alibaba.wireless.security.aopsdk.g.NoArgCachePolicy;
import com.alibaba.wireless.security.aopsdk.g.WithArgsCachePolicy;
import com.alibaba.wireless.security.aopsdk.i.LogUtils;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* renamed from: com.alibaba.wireless.security.aopsdk.e.f.e */
/* loaded from: classes.dex */
public class RuleConfig extends ExecutionConfig {
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
    @AopAttribute(key = ReportManager.e, type = AopAttributeType.INT)
    public int m;
    @AopAttribute(handler = ConditionConfig.class, key = "cond", type = AopAttributeType.JSON)
    public ConditionConfig n;
    @AopAttribute(key = "brk", type = AopAttributeType.INT)
    public int o;
    @AopAttribute(handler = C3980a.class, key = "arg", type = AopAttributeType.JSON)
    public C3980a s;
    @AopAttribute(key = "ret", type = AopAttributeType.OBJECT)
    public Object t;
    private ICachePolicy v;
    public Throwable w;
    @AopAttribute(key = SocialConstants.PARAM_ACT, type = AopAttributeType.INT)
    public int p = -1;
    @AopAttribute(key = "lmt", type = AopAttributeType.DOUBLE)
    public double q = -1.0d;
    @AopAttribute(key = "crt", type = AopAttributeType.INT)
    public int r = -1;
    @AopAttribute(key = IRequestConst.CS, type = AopAttributeType.INT)
    public int u = 5;

    /* compiled from: RuleConfig.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.e.f.e$a */
    /* loaded from: classes.dex */
    public static class C3980a extends BaseAopConfig {
        public Map<Integer, Object> d;

        @Override // com.alibaba.wireless.security.aopsdk.e.f.BaseAopConfig
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
                            LogUtils.a(BaseAopConfig.c, "", e);
                        }
                    }
                }
            }
        }
    }

    public RuleConfig() {
        this.f = 1;
    }

    public boolean a(Invocation invocation) {
        return this.v.a(invocation);
    }

    @Override // com.alibaba.wireless.security.aopsdk.e.f.ExecutionConfig, com.alibaba.wireless.security.aopsdk.e.f.BaseAopConfig
    public void b(JSONObject jSONObject) {
        super.b(jSONObject);
        BaseAopConfig a = a();
        if (a instanceof StrategyConfig) {
            BaseAopConfig a2 = a.a();
            if (a2 instanceof ProxyConfig) {
                String str = ((ProxyConfig) a2).d;
                if (str.contains(jn1.BRACKET_START_STR) && !str.contains("()")) {
                    WithArgsCachePolicy withArgsCachePolicy = new WithArgsCachePolicy(this.q);
                    this.v = withArgsCachePolicy;
                    withArgsCachePolicy.a(this.u);
                }
            }
        }
        if (this.v == null) {
            this.v = new NoArgCachePolicy(this.q);
        }
    }

    public Throwable c(Invocation invocation) {
        return this.v.c(invocation);
    }

    public Map<Integer, Object> d() {
        C3980a c3980a = this.s;
        return c3980a != null ? c3980a.d : new HashMap();
    }

    public Throwable e(Invocation invocation) {
        return this.w;
    }

    public boolean f(Invocation invocation) {
        return this.v.f(invocation);
    }

    public boolean g(Invocation invocation) {
        ConditionConfig conditionConfig = this.n;
        return conditionConfig == null || conditionConfig.a(invocation);
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
