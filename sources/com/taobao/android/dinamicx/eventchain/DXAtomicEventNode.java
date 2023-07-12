package com.taobao.android.dinamicx.eventchain;

import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.analysis.v3.FalcoAbilitySpan;
import com.taobao.analysis.v3.FalcoBusinessSpan;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.analysis.v3.FalcoStage;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.weex.bridge.WXBridgeManager;
import java.util.HashMap;
import java.util.Map;
import tb.C9192h;
import tb.C9327k;
import tb.C9392l;
import tb.C9428m;
import tb.C9586q;
import tb.C9703t;
import tb.ky;
import tb.m80;
import tb.nz;
import tb.oy;
import tb.s00;
import tb.wt;
import tb.y00;
import tb.zz;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXAtomicEventNode {
    private String a;
    private Long b;
    private String d;
    private JSONObject e;
    private String g;
    private JSONObject h;
    private JSONObject i;
    private Map<String, String> j;
    private DXAtomicFTData k;
    private AKBaseAbility l;
    private String c = "";
    private String f = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.eventchain.DXAtomicEventNode$a */
    /* loaded from: classes11.dex */
    public class C6370a extends TypeReference<Map<String, String>> {
        C6370a(DXAtomicEventNode dXAtomicEventNode) {
        }
    }

    public DXAtomicEventNode(String str, Long l) {
        this.a = "";
        this.b = -1L;
        this.a = str;
        this.b = l;
    }

    private void e(JSONArray jSONArray, C6371a c6371a) {
        for (int i = 0; i < jSONArray.size(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                f((JSONObject) obj, c6371a);
            } else if (obj instanceof JSONArray) {
                e((JSONArray) obj, c6371a);
            } else {
                jSONArray.set(i, g(obj.toString(), c6371a));
            }
        }
    }

    private void f(JSONObject jSONObject, C6371a c6371a) {
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                f((JSONObject) value, c6371a);
            } else if (value instanceof JSONArray) {
                e((JSONArray) value, c6371a);
            } else {
                Object g = g(value.toString(), c6371a);
                if (g == null) {
                    jSONObject.put(key, "");
                } else {
                    jSONObject.put(key, g);
                }
            }
        }
    }

    private Object g(String str, C6371a c6371a) {
        return (str.startsWith(m80.DINAMIC_PREFIX_AT) && str.endsWith("}")) ? c6371a.n().b(str).b(null, c6371a.l()) : str;
    }

    private void i(JSONObject jSONObject, JSONObject jSONObject2) {
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                JSONObject jSONObject3 = new JSONObject();
                i((JSONObject) value, jSONObject3);
                jSONObject2.put(entry.getKey(), (Object) jSONObject3);
            } else if (value instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) value;
                JSONArray jSONArray2 = new JSONArray();
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject4 = new JSONObject();
                    Object obj = jSONArray.get(i);
                    if (obj instanceof JSONObject) {
                        i((JSONObject) obj, jSONObject4);
                        jSONArray2.add(jSONObject4);
                    } else if (!(obj instanceof String) && !(obj instanceof Number)) {
                        String jSONString = JSON.toJSONString(obj);
                        jSONArray2.add(JSON.parse(jSONString));
                        s00.b("命中deepClone else逻辑" + jSONString);
                    } else {
                        jSONArray2.add(obj);
                    }
                }
                jSONObject2.put(entry.getKey(), (Object) jSONArray2);
            } else if (entry.getValue() != null) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private JSONObject k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!(value instanceof JSONObject) && !(value instanceof JSONArray)) {
                jSONObject2.put(key, value);
            }
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(C6371a c6371a) {
        nz.g("DXFullTrace", "EventChain finish");
        if (c6371a != null) {
            zz.h(c6371a.q());
            if (c6371a.g() != null) {
                zz.l(c6371a.g());
            }
            if (c6371a.h() != null) {
                zz.l(c6371a.h());
            }
            c6371a.x(null);
            c6371a.y(null);
        }
        c6371a.c();
    }

    private FalcoAbilitySpan r(C6371a c6371a) {
        FalcoStage g;
        nz.f("DXFullTrace", "Atomic ftData is not null ", this.k);
        if (c6371a == null || c6371a.l() == null) {
            return null;
        }
        if (this.k.b() == "start") {
            FalcoBusinessSpan c = zz.c(c6371a.l().getBizType(), this.k.d());
            if (c == null) {
                return null;
            }
            c6371a.x(c);
            zz.m(c);
            zz.q(c, "DXEventChain_ChainName", c6371a.o());
            FalcoContainerSpan d = zz.d(c.context(), "DX", this.k.d());
            c6371a.y(d);
            c6371a.l().setOpenTracerSpan(d);
            zz.m(d);
            if (TextUtils.isEmpty(this.k.e())) {
                g = zz.f(d);
            } else {
                g = zz.g(d, this.k.c());
            }
            zz.r(g);
            c6371a.F(g);
            FalcoAbilitySpan a = zz.a(d.context(), "DX", "Atomic");
            zz.q(a, "DXEventChain_AbilityName", this.a);
            zz.p(a, "DXEventChain_AbilityType", this.b.longValue());
            return a;
        } else if (this.k.b() == "finish") {
            zz.h(c6371a.q());
            l(c6371a);
            return null;
        } else {
            return null;
        }
    }

    private void s() {
        JSONObject jSONObject;
        if (this.j == null && this.i == null && this.k == null) {
            if (TextUtils.isEmpty(this.d)) {
                nz.g("DXAtomicEventNode", "eventchain parse event info : atom event content is null");
                return;
            }
            JSONObject parseObject = JSON.parseObject(this.d);
            if (parseObject.containsKey(WXBridgeManager.METHOD_CALLBACK)) {
                this.j = (Map) JSON.parseObject(parseObject.getJSONObject(WXBridgeManager.METHOD_CALLBACK).toJSONString(), new C6370a(this), new Feature[0]);
            }
            if (parseObject.containsKey("params")) {
                this.g = parseObject.getJSONObject("params").toJSONString();
            }
            if (!parseObject.containsKey("ftData") || (jSONObject = parseObject.getJSONObject("ftData")) == null) {
                return;
            }
            this.k = new DXAtomicFTData(jSONObject);
        }
    }

    private void t() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.d)) {
            nz.g("DXAtomicEventNode", "eventchain parse event info : atom event content is null");
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        i(this.e, jSONObject2);
        JSONObject jSONObject3 = jSONObject2.getJSONObject(WXBridgeManager.METHOD_CALLBACK);
        if (jSONObject3 != null) {
            this.j = new HashMap();
            for (Map.Entry<String, Object> entry : jSONObject3.entrySet()) {
                Map<String, String> map = this.j;
                String key = entry.getKey();
                map.put(key, entry.getValue() + "");
            }
        }
        if (jSONObject2.containsKey("params")) {
            this.h = jSONObject2.getJSONObject("params");
            this.g = jSONObject2.getJSONObject("params").toJSONString();
        }
        if (!jSONObject2.containsKey("ftData") || (jSONObject = jSONObject2.getJSONObject("ftData")) == null) {
            return;
        }
        this.k = new DXAtomicFTData(jSONObject);
    }

    public DXAtomicEventNode h() {
        DXAtomicEventNode dXAtomicEventNode = new DXAtomicEventNode(this.a, this.b);
        dXAtomicEventNode.d = this.d;
        dXAtomicEventNode.c = this.c;
        dXAtomicEventNode.f = this.f;
        dXAtomicEventNode.e = this.e;
        return dXAtomicEventNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.taobao.android.dinamicx.eventchain.DXAtomicEventNode$1] */
    public oy j(final C6371a c6371a, final DXEventChainCallback dXEventChainCallback) {
        JSONObject parseObject;
        C9703t c9703t;
        DXRuntimeContext l;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        DXAtomicFTData dXAtomicFTData;
        if (c6371a == null) {
            return oy.b(ky.EVENT_CHAIN_ERROR_ATOMIC_EXECUTE_CONTEXT_IS_NULL);
        }
        C9192h d = c6371a.d();
        if (d == null) {
            return oy.b(ky.EVENT_CHAIN_ERROR_ATOMIC_EXECUTE_ABILITY_IS_NULL);
        }
        DXTraceUtil.a(2, "DX-AtomicEvent-Start", " : ", this.a);
        nz.f("DXFullTrace", "execute ", this.a, this.g, this.j);
        FalcoAbilitySpan falcoAbilitySpan = null;
        DXTraceUtil.a(2, "DX-AtomicEvent-构造Node");
        if (wt.k0()) {
            t();
        } else {
            s();
        }
        DXTraceUtil.d(2);
        if (wt.k0()) {
            parseObject = this.h;
        } else {
            parseObject = JSON.parseObject(this.g);
        }
        DXTraceUtil.a(2, "DX-AtomicEvent-执行表达式");
        f(parseObject, c6371a);
        this.i = parseObject;
        DXTraceUtil.d(2);
        if (c6371a.g() != null && c6371a.h() != null && (dXAtomicFTData = this.k) != null && !TextUtils.isEmpty(dXAtomicFTData.e())) {
            zz.h(c6371a.q());
            FalcoStage g = zz.g(c6371a.h(), this.k.c());
            zz.r(g);
            c6371a.F(g);
        }
        if (c6371a.g() != null && c6371a.h() != null) {
            falcoAbilitySpan = zz.b(zz.i(c6371a.h()), "DX", "Atomic");
            zz.q(falcoAbilitySpan, "DXEventChain_AbilityName", this.a);
            DXAtomicFTData dXAtomicFTData2 = this.k;
            if (dXAtomicFTData2 != null && dXAtomicFTData2.f() && (jSONObject2 = this.i) != null) {
                zz.n(falcoAbilitySpan, JSON.toJSONString(jSONObject2));
            }
            DXAtomicFTData dXAtomicFTData3 = this.k;
            if (dXAtomicFTData3 != null && dXAtomicFTData3.f() && (jSONObject = this.i) != null) {
                zz.n(falcoAbilitySpan, JSON.toJSONString(jSONObject));
            }
        }
        DXAtomicFTData dXAtomicFTData4 = this.k;
        if (dXAtomicFTData4 != null && !TextUtils.isEmpty(dXAtomicFTData4.b()) && !"none".equals(this.k.b()) && wt.f0() && (l = c6371a.l()) != null && l.getEngineContext().b().n()) {
            falcoAbilitySpan = r(c6371a);
        }
        nz.f("DXFullTrace", "atomic ", this.a, this.j);
        if (c6371a.g() != null && c6371a.h() != null && this.j != null) {
            c6371a.a();
        }
        JSONObject parseObject2 = JSON.parseObject(this.d);
        parseObject2.put("params", (Object) parseObject);
        if (falcoAbilitySpan != null) {
            zz.q(falcoAbilitySpan, "DXEventChain_AbilityParams", JSON.toJSONString(k(parseObject2.getJSONObject("params"))));
        }
        if (wt.k0()) {
            AKBaseAbility<C9586q> c = d.c(String.valueOf(this.b));
            this.l = c;
            if (c == null) {
                DXTraceUtil.d(2);
                return oy.b(ky.EVENT_CHAIN_ERROR_ABILITY_IS_NULL);
            }
        } else if (this.l == null) {
            AKBaseAbility<C9586q> c2 = d.c(String.valueOf(this.b));
            this.l = c2;
            if (c2 == null) {
                DXTraceUtil.d(2);
                return oy.b(ky.EVENT_CHAIN_ERROR_ABILITY_IS_NULL);
            }
        }
        this.l.d(falcoAbilitySpan);
        zz.q(falcoAbilitySpan, "DXEventChain_AbilityType", this.l.getClass().getSimpleName());
        AKIAbilityCallback a = new AKIAbilityCallback() { // from class: com.taobao.android.dinamicx.eventchain.DXAtomicEventNode.1
            FalcoAbilitySpan a = null;

            public AKIAbilityCallback a(FalcoAbilitySpan falcoAbilitySpan2) {
                this.a = falcoAbilitySpan2;
                return this;
            }

            @Override // com.taobao.android.abilitykit.AKIAbilityCallback
            public void callback(final String str, final C9392l c9392l) {
                FalcoAbilitySpan falcoAbilitySpan2;
                if (dXEventChainCallback != null && c9392l != null) {
                    if (DXAtomicEventNode.this.j == null) {
                        return;
                    }
                    c6371a.J();
                    if (c6371a.g() != null && c6371a.h() != null && (falcoAbilitySpan2 = this.a) != null) {
                        if (c9392l instanceof C9327k) {
                            zz.q(falcoAbilitySpan2, "DXEventChain_AbilityResult", JSON.toJSONString(c9392l));
                        }
                        if (DXAtomicEventNode.this.l != null && DXAtomicEventNode.this.l.e()) {
                            zz.l(this.a);
                        }
                    }
                    if (c6371a.g() != null && c6371a.h() != null && TextUtils.isEmpty(str) && c6371a.t() <= 0) {
                        nz.g("DXFullTrace", "EvnetChian finish callback ", " ", DXAtomicEventNode.this.a);
                        DXAtomicEventNode.this.l(c6371a);
                    }
                    if (c6371a.u()) {
                        nz.b("DXAtomicEventNode", "eventchain callback: event cancle");
                        return;
                    } else if (Looper.getMainLooper() == Looper.myLooper()) {
                        dXEventChainCallback.callback(new C6374c(str, (String) DXAtomicEventNode.this.j.get(str)), oy.e(c9392l));
                        return;
                    } else {
                        y00.m(new Runnable() { // from class: com.taobao.android.dinamicx.eventchain.DXAtomicEventNode.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                dXEventChainCallback.callback(new C6374c(str, (String) DXAtomicEventNode.this.j.get(str)), oy.e(c9392l));
                            }
                        });
                        return;
                    }
                }
                nz.g("DXAtomicEventNode", "eventchain callback is null or abilityExecuteResult is null [ " + DXAtomicEventNode.this.a);
            }
        }.a(falcoAbilitySpan);
        if (c6371a.g() != null && c6371a.h() != null && falcoAbilitySpan != null && (c6371a.e() instanceof C9703t) && (c9703t = (C9703t) c6371a.e()) != null) {
            c9703t.h(falcoAbilitySpan);
        }
        C9392l a2 = this.l.a(parseObject2, c6371a.e(), a);
        if (this.j == null && c6371a.g() != null && c6371a.h() != null && falcoAbilitySpan != null) {
            if (a2 instanceof C9327k) {
                zz.q(falcoAbilitySpan, "DXEventChain_AbilityResult", JSON.toJSONString(a2));
            }
            if (!(a2 instanceof C9428m)) {
                zz.l(falcoAbilitySpan);
            }
        }
        if (TextUtils.isEmpty(this.c) && c6371a.t() <= 0 && c6371a.g() != null && c6371a.h() != null) {
            nz.g("DXFullTrace", "EvnetChian finish  ", this.a);
            l(c6371a);
        }
        DXTraceUtil.d(2);
        return oy.e(a2);
    }

    public Map<String, String> m() {
        return this.j;
    }

    public String n() {
        return this.a;
    }

    public String o() {
        return this.c;
    }

    public JSONObject p() {
        return this.i;
    }

    public Long q() {
        return this.b;
    }

    public void u(String str) {
        this.d = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e = JSON.parseObject(this.d);
    }

    public void v(String str) {
        this.f = str;
    }

    public void w(String str) {
        this.c = str;
    }
}
