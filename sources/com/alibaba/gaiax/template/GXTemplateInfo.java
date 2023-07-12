package com.alibaba.gaiax.template;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.alibaba.poplayer.trigger.view.TrackingService;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.core.Constants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C9796v;
import tb.b41;
import tb.gr0;
import tb.k50;
import tb.ns0;
import tb.pq0;
import tb.qq0;
import tb.rq0;
import tb.sq0;
import tb.ss0;
import tb.vq0;
import tb.wt2;
import tb.xq0;
import tb.yq0;
import tb.zp0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXTemplateInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final gr0 a;
    @NotNull
    private final Map<String, pq0> b;
    @Nullable
    private final Map<String, rq0> c;
    @Nullable
    private final Map<String, vq0> d;
    @Nullable
    private final Map<String, ss0> e;
    @Nullable
    private final Map<String, zp0> f;
    @Nullable
    private final Map<String, GXIExpression> g;
    @Nullable
    private final String h;
    @Nullable
    private String i;
    @Nullable
    private List<GXTemplateInfo> j;
    public ns0 k;
    public JSONObject l;
    public JSONObject m;
    @NotNull
    private final Lazy n;
    @NotNull
    private final Map<String, gr0> o;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        private final Map<String, zp0> a(String str, JSONObject jSONObject) {
            zp0 a;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    if ((key.length() > 0) && (value instanceof JSONObject) && (a = zp0.Companion.a(str, (JSONObject) value)) != null) {
                        linkedHashMap.put(key, a);
                    }
                }
            }
            return linkedHashMap;
        }

        private final Map<String, GXIExpression> b(String str, JSONObject jSONObject) {
            GXIExpression a;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    if ((key.length() > 0) && (a = xq0.INSTANCE.a(str, value)) != null) {
                        linkedHashMap.put(key, a);
                    }
                }
            }
            return linkedHashMap;
        }

        private final Map<String, pq0> c(Map<String, pq0> map, JSONObject jSONObject, gr0 gr0Var) {
            String d = gr0Var.d();
            JSONObject jSONObject2 = jSONObject.getJSONObject(gr0Var.a());
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject(d);
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            if ((!jSONObject2.isEmpty()) || (!jSONObject3.isEmpty())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putAll(jSONObject2);
                jSONObject4.putAll(jSONObject3);
                map.put(d, pq0.Companion.a(jSONObject4));
            }
            for (gr0 gr0Var2 : gr0Var.e()) {
                GXTemplateInfo.Companion.c(map, jSONObject, gr0Var2);
            }
            return map;
        }

        private final Map<String, pq0> d(gr0 gr0Var, JSONObject jSONObject) {
            return c(new LinkedHashMap(), jSONObject, gr0Var);
        }

        private final Map<String, rq0> e(String str, JSONObject jSONObject) {
            rq0 a;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null && (a = sq0.INSTANCE.a(str, value)) != null) {
                    linkedHashMap.put(key, a);
                }
            }
            return linkedHashMap;
        }

        private final Map<String, vq0> f(String str, JSONObject jSONObject) {
            GXIExpression a;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    if ((key.length() > 0) && (a = xq0.INSTANCE.a(str, value)) != null) {
                        linkedHashMap.put(key, new vq0(a));
                    }
                }
            }
            return linkedHashMap;
        }

        private final GXTemplateInfo h(ns0 ns0Var) {
            JSONObject i = yq0.i(ns0Var.f());
            if (!i.isEmpty()) {
                JSONObject e = qq0.Companion.a().e(ns0Var.b());
                JSONObject i2 = yq0.i(ns0Var.c());
                String e2 = ns0Var.e();
                JSONObject jSONObject = i2.getJSONObject("data");
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                JSONObject jSONObject2 = i2.getJSONObject("event");
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                JSONObject jSONObject3 = i2.getJSONObject(TrackingService.OPER_TRACK);
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                }
                JSONObject jSONObject4 = i2.getJSONObject(Constants.CONFIG);
                if (jSONObject4 == null) {
                    jSONObject4 = new JSONObject();
                }
                JSONObject jSONObject5 = i2.getJSONObject(C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
                if (jSONObject5 == null) {
                    jSONObject5 = new JSONObject();
                }
                String string = i.getString("edge-insets");
                if (string != null) {
                    if (!e.containsKey(ns0Var.d())) {
                        e.put((JSONObject) ns0Var.d(), (String) new JSONObject());
                    }
                    JSONObject jSONObject6 = e.getJSONObject(ns0Var.d());
                    if (jSONObject6 != null) {
                        jSONObject6.put("edge-insets", (Object) string);
                    }
                }
                String string2 = i.getString("exp-version");
                gr0 a = gr0.Companion.a(i);
                Map<String, pq0> d = d(a, e);
                Map<String, rq0> e3 = e(string2, jSONObject);
                Map<String, vq0> f = f(string2, jSONObject2);
                Map<String, ss0> i3 = i(string2, jSONObject3);
                Map<String, GXIExpression> b = b(string2, jSONObject4);
                Map<String, zp0> a2 = a(string2, jSONObject5);
                if (e2.length() == 0) {
                    e2 = null;
                }
                GXTemplateInfo gXTemplateInfo = new GXTemplateInfo(a, d, e3, f, i3, a2, b, e2);
                gXTemplateInfo.D(ns0Var);
                gXTemplateInfo.A(e);
                gXTemplateInfo.B(i2);
                gXTemplateInfo.C(i);
                gXTemplateInfo.z(jSONObject4);
                gXTemplateInfo.y(string2);
                return gXTemplateInfo;
            }
            throw new IllegalArgumentException("Template layer mustn't empty");
        }

        private final Map<String, ss0> i(String str, JSONObject jSONObject) {
            GXIExpression a;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    if ((key.length() > 0) && (a = xq0.INSTANCE.a(str, value)) != null) {
                        linkedHashMap.put(key, new ss0(a));
                    }
                }
            }
            return linkedHashMap;
        }

        private final void j(gr0 gr0Var, Function1<? super gr0, wt2> function1) {
            for (gr0 gr0Var2 : gr0Var.e()) {
                if (gr0Var2.s()) {
                    function1.invoke(gr0Var2);
                }
                GXTemplateInfo.Companion.j(gr0Var2, function1);
            }
        }

        private final void k(final GXTemplateInfo gXTemplateInfo, final GXTemplateEngine.C3347i c3347i) {
            j(gXTemplateInfo.p(), new Function1<gr0, wt2>() { // from class: com.alibaba.gaiax.template.GXTemplateInfo$Companion$initChildren$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(gr0 gr0Var) {
                    invoke2(gr0Var);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull gr0 gr0Var) {
                    b41.i(gr0Var, AdvanceSetting.NETWORK_TYPE);
                    GXTemplateInfo.Companion companion = GXTemplateInfo.Companion;
                    GXTemplateEngine.C3347i c3347i2 = new GXTemplateEngine.C3347i(GXTemplateEngine.C3347i.this.c(), GXTemplateEngine.C3347i.this.a(), gr0Var.d());
                    GXTemplateEngine.C3347i c3347i3 = GXTemplateEngine.C3347i.this;
                    c3347i2.g(c3347i3.f());
                    c3347i2.h(c3347i3.e());
                    wt2 wt2Var = wt2.INSTANCE;
                    GXTemplateInfo g = companion.g(c3347i2);
                    if (gXTemplateInfo.k() == null) {
                        gXTemplateInfo.x(new ArrayList());
                    }
                    List<GXTemplateInfo> k = gXTemplateInfo.k();
                    if (k == null) {
                        return;
                    }
                    k.add(g);
                }
            });
        }

        @NotNull
        public final GXTemplateInfo g(@NotNull GXTemplateEngine.C3347i c3347i) {
            b41.i(c3347i, "templateItem");
            GXTemplateInfo h = h(GXTemplateEngine.Companion.a().h().d().getTemplate(c3347i));
            GXTemplateInfo.Companion.k(h, c3347i);
            return h;
        }

        @NotNull
        public final JSONObject l(@NotNull String str) {
            b41.i(str, "value");
            return qq0.Companion.a().e(str);
        }

        @NotNull
        public final JSONObject m(@NotNull String str) {
            b41.i(str, "value");
            return yq0.i(str);
        }

        @NotNull
        public final JSONObject n(@NotNull String str) {
            b41.i(str, "value");
            return yq0.i(str);
        }
    }

    public GXTemplateInfo(@NotNull gr0 gr0Var, @NotNull Map<String, pq0> map, @Nullable Map<String, rq0> map2, @Nullable Map<String, vq0> map3, @Nullable Map<String, ss0> map4, @Nullable Map<String, zp0> map5, @Nullable Map<String, GXIExpression> map6, @Nullable String str) {
        Lazy b;
        b41.i(gr0Var, "layer");
        b41.i(map, "css");
        this.a = gr0Var;
        this.b = map;
        this.c = map2;
        this.d = map3;
        this.e = map4;
        this.f = map5;
        this.g = map6;
        this.h = str;
        b = C8177b.b(new Function0<Boolean>() { // from class: com.alibaba.gaiax.template.GXTemplateInfo$isJsExist$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean b2;
                b2 = GXTemplateInfo.this.b();
                return Boolean.valueOf(b2);
            }
        });
        this.n = b;
        this.o = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b() {
        String str = this.h;
        if (b41.d(str == null ? null : Boolean.valueOf(str.length() > 0), Boolean.TRUE)) {
            return true;
        }
        List<GXTemplateInfo> list = this.j;
        if (list != null) {
            for (GXTemplateInfo gXTemplateInfo : list) {
                if (gXTemplateInfo.b()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final gr0 h(String str, gr0 gr0Var) {
        if (b41.d(str, gr0Var.d())) {
            return gr0Var;
        }
        for (gr0 gr0Var2 : gr0Var.e()) {
            gr0 h = h(str, gr0Var2);
            if (h != null) {
                return h;
            }
        }
        return null;
    }

    private final void w(GXTemplateInfo gXTemplateInfo) {
        for (Map.Entry<String, pq0> entry : gXTemplateInfo.b.entrySet()) {
            entry.getValue().a().X();
        }
        List<GXTemplateInfo> list = gXTemplateInfo.j;
        if (list == null) {
            return;
        }
        for (GXTemplateInfo gXTemplateInfo2 : list) {
            w(gXTemplateInfo2);
        }
    }

    public final void A(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "<set-?>");
    }

    public final void B(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "<set-?>");
        this.l = jSONObject;
    }

    public final void C(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "<set-?>");
    }

    public final void D(@NotNull ns0 ns0Var) {
        b41.i(ns0Var, "<set-?>");
        this.k = ns0Var;
    }

    @Nullable
    public final zp0 c(@NotNull String str) {
        b41.i(str, "id");
        Map<String, zp0> map = this.f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Nullable
    public final pq0 d(@NotNull String str) {
        b41.i(str, "id");
        return this.b.get(str);
    }

    @Nullable
    public final rq0 e(@NotNull String str) {
        b41.i(str, "id");
        Map<String, rq0> map = this.c;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GXTemplateInfo) {
            GXTemplateInfo gXTemplateInfo = (GXTemplateInfo) obj;
            return b41.d(this.a, gXTemplateInfo.a) && b41.d(this.b, gXTemplateInfo.b) && b41.d(this.c, gXTemplateInfo.c) && b41.d(this.d, gXTemplateInfo.d) && b41.d(this.e, gXTemplateInfo.e) && b41.d(this.f, gXTemplateInfo.f) && b41.d(this.g, gXTemplateInfo.g) && b41.d(this.h, gXTemplateInfo.h);
        }
        return false;
    }

    @Nullable
    public final vq0 f(@NotNull String str) {
        b41.i(str, "id");
        Map<String, vq0> map = this.d;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Nullable
    public final gr0 g(@NotNull String str) {
        b41.i(str, "id");
        gr0 gr0Var = this.o.get(str);
        if (gr0Var == null) {
            gr0 h = h(str, this.a);
            if (h == null) {
                return null;
            }
            this.o.put(str, h);
            return h;
        }
        return gr0Var;
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Map<String, rq0> map = this.c;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, vq0> map2 = this.d;
        int hashCode3 = (hashCode2 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, ss0> map3 = this.e;
        int hashCode4 = (hashCode3 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, zp0> map4 = this.f;
        int hashCode5 = (hashCode4 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, GXIExpression> map5 = this.g;
        int hashCode6 = (hashCode5 + (map5 == null ? 0 : map5.hashCode())) * 31;
        String str = this.h;
        return hashCode6 + (str != null ? str.hashCode() : 0);
    }

    @Nullable
    public final ss0 i(@NotNull String str) {
        b41.i(str, "id");
        Map<String, ss0> map = this.e;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Nullable
    public final GXTemplateInfo j(@NotNull String str) {
        b41.i(str, "id");
        List<GXTemplateInfo> list = this.j;
        if (list == null) {
            return null;
        }
        for (GXTemplateInfo gXTemplateInfo : list) {
            if (b41.d(gXTemplateInfo.p().d(), str)) {
                return gXTemplateInfo;
            }
        }
        return null;
    }

    @Nullable
    public final List<GXTemplateInfo> k() {
        return this.j;
    }

    @NotNull
    public final JSONObject l(@Nullable JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Map<String, GXIExpression> map = this.g;
        if (map != null) {
            for (Map.Entry<String, GXIExpression> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue().value(jSONObject);
                if (value == null) {
                    value = "";
                }
                jSONObject2.put((JSONObject) key, (String) value);
            }
        }
        return jSONObject2;
    }

    @Nullable
    public final Map<String, rq0> m() {
        return this.c;
    }

    @Nullable
    public final String n() {
        return this.i;
    }

    @Nullable
    public final String o() {
        return this.h;
    }

    @NotNull
    public final gr0 p() {
        return this.a;
    }

    @NotNull
    public final JSONObject q() {
        JSONObject jSONObject = this.m;
        if (jSONObject != null) {
            return jSONObject;
        }
        b41.A("rawConfigJson");
        return null;
    }

    @NotNull
    public final JSONObject r() {
        JSONObject jSONObject = this.l;
        if (jSONObject != null) {
            return jSONObject;
        }
        b41.A("rawDataBindingJson");
        return null;
    }

    @NotNull
    public final ns0 s() {
        ns0 ns0Var = this.k;
        if (ns0Var != null) {
            return ns0Var;
        }
        b41.A(com.youku.arch.v3.data.Constants.TEMPLATE);
        return null;
    }

    public final boolean t() {
        return ((Boolean) this.n.getValue()).booleanValue();
    }

    @NotNull
    public String toString() {
        return "GXTemplateInfo(layer=" + this.a + ", css=" + this.b + ", data=" + this.c + ", event=" + this.d + ", track=" + this.e + ", animation=" + this.f + ", config=" + this.g + ", js=" + ((Object) this.h) + ')';
    }

    public final boolean u() {
        return b41.d(this.a.k(), "gaia-template");
    }

    public final void v() {
        w(this);
    }

    public final void x(@Nullable List<GXTemplateInfo> list) {
        this.j = list;
    }

    public final void y(@Nullable String str) {
        this.i = str;
    }

    public final void z(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "<set-?>");
        this.m = jSONObject;
    }
}
