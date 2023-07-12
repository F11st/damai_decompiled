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
import tb.h;
import tb.k;
import tb.ky;
import tb.l;
import tb.m;
import tb.m80;
import tb.nz;
import tb.oy;
import tb.q;
import tb.s00;
import tb.t;
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
    /* loaded from: classes11.dex */
    public class a extends TypeReference<Map<String, String>> {
        a(DXAtomicEventNode dXAtomicEventNode) {
        }
    }

    public DXAtomicEventNode(String str, Long l) {
        this.a = "";
        this.b = -1L;
        this.a = str;
        this.b = l;
    }

    private void e(JSONArray jSONArray, com.taobao.android.dinamicx.eventchain.a aVar) {
        for (int i = 0; i < jSONArray.size(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                f((JSONObject) obj, aVar);
            } else if (obj instanceof JSONArray) {
                e((JSONArray) obj, aVar);
            } else {
                jSONArray.set(i, g(obj.toString(), aVar));
            }
        }
    }

    private void f(JSONObject jSONObject, com.taobao.android.dinamicx.eventchain.a aVar) {
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                f((JSONObject) value, aVar);
            } else if (value instanceof JSONArray) {
                e((JSONArray) value, aVar);
            } else {
                Object g = g(value.toString(), aVar);
                if (g == null) {
                    jSONObject.put(key, "");
                } else {
                    jSONObject.put(key, g);
                }
            }
        }
    }

    private Object g(String str, com.taobao.android.dinamicx.eventchain.a aVar) {
        return (str.startsWith(m80.DINAMIC_PREFIX_AT) && str.endsWith("}")) ? aVar.n().b(str).b(null, aVar.l()) : str;
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
    public void l(com.taobao.android.dinamicx.eventchain.a aVar) {
        nz.g("DXFullTrace", "EventChain finish");
        if (aVar != null) {
            zz.h(aVar.q());
            if (aVar.g() != null) {
                zz.l(aVar.g());
            }
            if (aVar.h() != null) {
                zz.l(aVar.h());
            }
            aVar.x(null);
            aVar.y(null);
        }
        aVar.c();
    }

    private FalcoAbilitySpan r(com.taobao.android.dinamicx.eventchain.a aVar) {
        FalcoStage g;
        nz.f("DXFullTrace", "Atomic ftData is not null ", this.k);
        if (aVar == null || aVar.l() == null) {
            return null;
        }
        if (this.k.b() == "start") {
            FalcoBusinessSpan c = zz.c(aVar.l().getBizType(), this.k.d());
            if (c == null) {
                return null;
            }
            aVar.x(c);
            zz.m(c);
            zz.q(c, "DXEventChain_ChainName", aVar.o());
            FalcoContainerSpan d = zz.d(c.context(), "DX", this.k.d());
            aVar.y(d);
            aVar.l().setOpenTracerSpan(d);
            zz.m(d);
            if (TextUtils.isEmpty(this.k.e())) {
                g = zz.f(d);
            } else {
                g = zz.g(d, this.k.c());
            }
            zz.r(g);
            aVar.F(g);
            FalcoAbilitySpan a2 = zz.a(d.context(), "DX", "Atomic");
            zz.q(a2, "DXEventChain_AbilityName", this.a);
            zz.p(a2, "DXEventChain_AbilityType", this.b.longValue());
            return a2;
        } else if (this.k.b() == "finish") {
            zz.h(aVar.q());
            l(aVar);
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
                this.j = (Map) JSON.parseObject(parseObject.getJSONObject(WXBridgeManager.METHOD_CALLBACK).toJSONString(), new a(this), new Feature[0]);
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
    public oy j(final com.taobao.android.dinamicx.eventchain.a aVar, final DXEventChainCallback dXEventChainCallback) {
        JSONObject parseObject;
        t tVar;
        DXRuntimeContext l;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        DXAtomicFTData dXAtomicFTData;
        if (aVar == null) {
            return oy.b(ky.EVENT_CHAIN_ERROR_ATOMIC_EXECUTE_CONTEXT_IS_NULL);
        }
        h d = aVar.d();
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
        f(parseObject, aVar);
        this.i = parseObject;
        DXTraceUtil.d(2);
        if (aVar.g() != null && aVar.h() != null && (dXAtomicFTData = this.k) != null && !TextUtils.isEmpty(dXAtomicFTData.e())) {
            zz.h(aVar.q());
            FalcoStage g = zz.g(aVar.h(), this.k.c());
            zz.r(g);
            aVar.F(g);
        }
        if (aVar.g() != null && aVar.h() != null) {
            falcoAbilitySpan = zz.b(zz.i(aVar.h()), "DX", "Atomic");
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
        if (dXAtomicFTData4 != null && !TextUtils.isEmpty(dXAtomicFTData4.b()) && !"none".equals(this.k.b()) && wt.f0() && (l = aVar.l()) != null && l.getEngineContext().b().n()) {
            falcoAbilitySpan = r(aVar);
        }
        nz.f("DXFullTrace", "atomic ", this.a, this.j);
        if (aVar.g() != null && aVar.h() != null && this.j != null) {
            aVar.a();
        }
        JSONObject parseObject2 = JSON.parseObject(this.d);
        parseObject2.put("params", (Object) parseObject);
        if (falcoAbilitySpan != null) {
            zz.q(falcoAbilitySpan, "DXEventChain_AbilityParams", JSON.toJSONString(k(parseObject2.getJSONObject("params"))));
        }
        if (wt.k0()) {
            AKBaseAbility<q> c = d.c(String.valueOf(this.b));
            this.l = c;
            if (c == null) {
                DXTraceUtil.d(2);
                return oy.b(ky.EVENT_CHAIN_ERROR_ABILITY_IS_NULL);
            }
        } else if (this.l == null) {
            AKBaseAbility<q> c2 = d.c(String.valueOf(this.b));
            this.l = c2;
            if (c2 == null) {
                DXTraceUtil.d(2);
                return oy.b(ky.EVENT_CHAIN_ERROR_ABILITY_IS_NULL);
            }
        }
        this.l.d(falcoAbilitySpan);
        zz.q(falcoAbilitySpan, "DXEventChain_AbilityType", this.l.getClass().getSimpleName());
        AKIAbilityCallback a2 = new AKIAbilityCallback() { // from class: com.taobao.android.dinamicx.eventchain.DXAtomicEventNode.1
            FalcoAbilitySpan a = null;

            public AKIAbilityCallback a(FalcoAbilitySpan falcoAbilitySpan2) {
                this.a = falcoAbilitySpan2;
                return this;
            }

            @Override // com.taobao.android.abilitykit.AKIAbilityCallback
            public void callback(final String str, final l lVar) {
                FalcoAbilitySpan falcoAbilitySpan2;
                if (dXEventChainCallback != null && lVar != null) {
                    if (DXAtomicEventNode.this.j == null) {
                        return;
                    }
                    aVar.J();
                    if (aVar.g() != null && aVar.h() != null && (falcoAbilitySpan2 = this.a) != null) {
                        if (lVar instanceof k) {
                            zz.q(falcoAbilitySpan2, "DXEventChain_AbilityResult", JSON.toJSONString(lVar));
                        }
                        if (DXAtomicEventNode.this.l != null && DXAtomicEventNode.this.l.e()) {
                            zz.l(this.a);
                        }
                    }
                    if (aVar.g() != null && aVar.h() != null && TextUtils.isEmpty(str) && aVar.t() <= 0) {
                        nz.g("DXFullTrace", "EvnetChian finish callback ", " ", DXAtomicEventNode.this.a);
                        DXAtomicEventNode.this.l(aVar);
                    }
                    if (aVar.u()) {
                        nz.b("DXAtomicEventNode", "eventchain callback: event cancle");
                        return;
                    } else if (Looper.getMainLooper() == Looper.myLooper()) {
                        dXEventChainCallback.callback(new c(str, (String) DXAtomicEventNode.this.j.get(str)), oy.e(lVar));
                        return;
                    } else {
                        y00.m(new Runnable() { // from class: com.taobao.android.dinamicx.eventchain.DXAtomicEventNode.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                dXEventChainCallback.callback(new c(str, (String) DXAtomicEventNode.this.j.get(str)), oy.e(lVar));
                            }
                        });
                        return;
                    }
                }
                nz.g("DXAtomicEventNode", "eventchain callback is null or abilityExecuteResult is null [ " + DXAtomicEventNode.this.a);
            }
        }.a(falcoAbilitySpan);
        if (aVar.g() != null && aVar.h() != null && falcoAbilitySpan != null && (aVar.e() instanceof t) && (tVar = (t) aVar.e()) != null) {
            tVar.h(falcoAbilitySpan);
        }
        l a3 = this.l.a(parseObject2, aVar.e(), a2);
        if (this.j == null && aVar.g() != null && aVar.h() != null && falcoAbilitySpan != null) {
            if (a3 instanceof k) {
                zz.q(falcoAbilitySpan, "DXEventChain_AbilityResult", JSON.toJSONString(a3));
            }
            if (!(a3 instanceof m)) {
                zz.l(falcoAbilitySpan);
            }
        }
        if (TextUtils.isEmpty(this.c) && aVar.t() <= 0 && aVar.g() != null && aVar.h() != null) {
            nz.g("DXFullTrace", "EvnetChian finish  ", this.a);
            l(aVar);
        }
        DXTraceUtil.d(2);
        return oy.e(a3);
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
