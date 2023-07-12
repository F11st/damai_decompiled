package com.alibaba.gaiax.render.node;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import app.visly.stretch.AlignContent;
import app.visly.stretch.AlignItems;
import app.visly.stretch.AlignSelf;
import app.visly.stretch.Direction;
import app.visly.stretch.Display;
import app.visly.stretch.FlexDirection;
import app.visly.stretch.FlexWrap;
import app.visly.stretch.JustifyContent;
import app.visly.stretch.Node;
import app.visly.stretch.Overflow;
import app.visly.stretch.PositionType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.GXViewExtKt;
import com.alibaba.gaiax.render.view.basic.GXIImageView;
import com.alibaba.gaiax.render.view.basic.GXProgressView;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import com.alibaba.gaiax.render.view.basic.GXText;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXContainerViewAdapter;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.alibaba.gaiax.render.view.container.slider.GXSliderViewAdapter;
import com.alibaba.gaiax.render.view.container.slider.GXViewPager;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.animation.GXIAnimation;
import com.alibaba.gaiax.template.animation.GXPropAnimationSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.ar0;
import tb.b41;
import tb.br0;
import tb.er0;
import tb.f81;
import tb.fr0;
import tb.fs0;
import tb.gr0;
import tb.js0;
import tb.k80;
import tb.ld2;
import tb.ls0;
import tb.lz1;
import tb.mr0;
import tb.os0;
import tb.pq0;
import tb.qr0;
import tb.qs0;
import tb.rq0;
import tb.rr0;
import tb.rs0;
import tb.ss0;
import tb.uq0;
import tb.vq0;
import tb.vr0;
import tb.wt2;
import tb.xq0;
import tb.zp0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXNodeTreeUpdate {
    @NotNull
    public static final GXNodeTreeUpdate INSTANCE = new GXNodeTreeUpdate();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class Style {
        @NotNull
        public static final Style INSTANCE = new Style();

        private Style() {
        }

        private final void A(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            qs0 m = qr0Var.o().m();
            JSON f = m == null ? null : m.f(jSONObject);
            JSONObject jSONObject2 = f instanceof JSONObject ? (JSONObject) f : null;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            B(os0Var, qr0Var, jSONObject2);
            List<qr0> d = qr0Var.d();
            if (d == null) {
                return;
            }
            for (qr0 qr0Var2 : d) {
                INSTANCE.C(os0Var, qr0Var2, jSONObject2);
            }
        }

        private final void B(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            q(os0Var, qr0Var);
            r(os0Var, qr0Var, jSONObject);
            t(os0Var, qr0Var, jSONObject);
            s(os0Var, qr0Var, jSONObject);
            p(os0Var, qr0Var, jSONObject);
        }

        private final void D(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            B(os0Var, qr0Var, jSONObject);
            List<qr0> d = qr0Var.d();
            if (d == null) {
                return;
            }
            for (qr0 qr0Var2 : d) {
                INSTANCE.C(os0Var, qr0Var2, jSONObject);
            }
        }

        private final void a(os0 os0Var, qr0 qr0Var, pq0 pq0Var, View view) {
            if (!qr0Var.J() || pq0Var.b().a() == null) {
                return;
            }
            ((GXView) view).setBackdropFilter(os0Var, pq0Var.b().a());
        }

        private final void b(qr0 qr0Var, pq0 pq0Var) {
            GXShadowLayout b;
            if ((qr0Var.J() || qr0Var.y()) && (b = qr0Var.b()) != null) {
                b.setStyle(pq0Var.b());
            }
        }

        private final void c(View view, pq0 pq0Var, qr0 qr0Var) {
            GXViewExtKt.f(view, pq0Var.b().o());
            if (qr0Var.u()) {
                return;
            }
            GXViewExtKt.m(view, pq0Var.b().o(), pq0Var.b().K());
            GXViewExtKt.p(view, pq0Var.b().O());
            GXViewExtKt.q(view, pq0Var.b().Q());
            GXViewExtKt.e(view, pq0Var.b());
            GXViewExtKt.r(view, pq0Var.b());
        }

        private final void d(os0 os0Var, View view, qr0 qr0Var) {
            if (qr0Var.t()) {
                if (qr0Var.w()) {
                    f(os0Var, view, qr0Var);
                } else if (qr0Var.G()) {
                    l(view, qr0Var);
                }
            }
        }

        private final void e(GXIViewBindData gXIViewBindData, qs0 qs0Var, JSONObject jSONObject) {
            gXIViewBindData.onBindData(qs0Var.d(jSONObject));
        }

        private final void f(os0 os0Var, View view, qr0 qr0Var) {
            er0 c = qr0Var.o().i().c();
            if (c == null) {
                return;
            }
            GXViewExtKt.k(view, os0Var, c, qr0Var.h());
            GXViewExtKt.l(view, qr0Var.k(), c.g(), c.i());
        }

        private final void g(GXIViewBindData gXIViewBindData, qs0 qs0Var, JSONObject jSONObject) {
            gXIViewBindData.onBindData(qs0Var.d(jSONObject));
        }

        private final void h(GXIViewBindData gXIViewBindData, qs0 qs0Var, JSONObject jSONObject) {
            gXIViewBindData.onBindData(qs0Var.d(jSONObject));
        }

        private final void i(GXIViewBindData gXIViewBindData, qs0 qs0Var, JSONObject jSONObject) {
            GXProgressView gXProgressView = gXIViewBindData instanceof GXProgressView ? (GXProgressView) gXIViewBindData : null;
            if (gXProgressView != null) {
                gXProgressView.setConfig(qs0Var.i().g());
            }
            if (gXProgressView == null) {
                return;
            }
            gXProgressView.onBindData(qs0Var.d(jSONObject));
        }

        private final void j(os0 os0Var, GXIViewBindData gXIViewBindData, pq0 pq0Var, gr0 gr0Var, qs0 qs0Var, JSONObject jSONObject) {
            GXTemplateEngine.GXIDataListener b;
            CharSequence b2;
            JSONObject d = qs0Var.d(jSONObject);
            CharSequence charSequence = null;
            Object obj = d == null ? null : d.get("value");
            if ((obj instanceof String) && (b2 = fr0.INSTANCE.b((View) gXIViewBindData, qs0Var, jSONObject, (String) obj)) != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putAll(d);
                jSONObject2.put((JSONObject) "value", (String) b2);
                gXIViewBindData.onBindData(jSONObject2);
                return;
            }
            GXTemplateEngine.h p = os0Var.p();
            if ((p == null ? null : p.b()) != null) {
                GXTemplateEngine.j jVar = new GXTemplateEngine.j();
                jVar.m(obj instanceof CharSequence ? (CharSequence) obj : null);
                jVar.g((View) gXIViewBindData);
                jVar.e(gr0Var.d());
                jVar.f(os0Var.r());
                jVar.k(pq0Var);
                jVar.l(d);
                jVar.d(Integer.valueOf(os0Var.h()));
                jVar.j(qs0Var.h(jSONObject));
                GXTemplateEngine.h p2 = os0Var.p();
                if (p2 != null && (b = p2.b()) != null) {
                    charSequence = b.onTextProcess(jVar);
                }
                if (charSequence != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (d != null) {
                        jSONObject3.putAll(d);
                    }
                    jSONObject3.put((JSONObject) "value", (String) charSequence);
                    gXIViewBindData.onBindData(jSONObject3);
                    return;
                }
                return;
            }
            gXIViewBindData.onBindData(d);
        }

        private final void k(os0 os0Var, View view, qr0 qr0Var, qs0 qs0Var, JSONObject jSONObject) {
            GXContainerViewAdapter gXContainerViewAdapter;
            JSON f = qs0Var.f(jSONObject);
            JSONArray jSONArray = f instanceof JSONArray ? (JSONArray) f : null;
            if (jSONArray == null) {
                GXRegisterCenter.b d = GXRegisterCenter.Companion.a().d();
                boolean z = false;
                if (d != null && d.f()) {
                    z = true;
                }
                if (z) {
                    jSONArray = new JSONArray();
                } else {
                    throw new IllegalArgumentException("Scroll or Grid must be have a array data source");
                }
            }
            JSONObject h = qs0Var.h(jSONObject);
            GXContainer gXContainer = (GXContainer) view;
            os0Var.t();
            CopyOnWriteArraySet<GXIContainer> d2 = os0Var.d();
            if (d2 != null) {
                d2.add(gXContainer);
            }
            if (gXContainer.getAdapter() != null) {
                RecyclerView.Adapter adapter = gXContainer.getAdapter();
                Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.alibaba.gaiax.render.view.container.GXContainerViewAdapter");
                gXContainerViewAdapter = (GXContainerViewAdapter) adapter;
            } else {
                gXContainerViewAdapter = new GXContainerViewAdapter(os0Var, gXContainer);
                gXContainer.setAdapter(gXContainerViewAdapter);
            }
            gXContainerViewAdapter.q(qr0Var);
            GXRegisterCenter.GXIExtensionScroll o = GXRegisterCenter.Companion.a().o();
            if (o != null) {
                o.scrollIndex(os0Var, gXContainer, h);
            }
            gXContainer.setItemAnimator(null);
            gXContainerViewAdapter.p(jSONArray);
            gXContainerViewAdapter.l();
            if (gXContainerViewAdapter.k()) {
                GXViewExtKt.u(gXContainer);
            }
        }

        private final void l(View view, qr0 qr0Var) {
            fs0 h = qr0Var.o().i().h();
            if (h == null) {
                return;
            }
            GXViewExtKt.s(view, h.b(), qr0Var.h());
            Rect k = qr0Var.k();
            int h2 = h.h();
            if (h.b() == 0) {
                if (k.top == 0 && k.bottom == 0) {
                    GXViewExtKt.o(view, k.left, k.right, h2);
                    return;
                }
                if (h2 != 0) {
                    GXViewExtKt.n(view, h2);
                }
                GXViewExtKt.t(view, k);
                return;
            }
            if (h2 != 0) {
                GXViewExtKt.y(view, h2);
            }
            GXViewExtKt.t(view, k);
        }

        private final void m(os0 os0Var, View view, qr0 qr0Var, qs0 qs0Var, JSONObject jSONObject) {
            GXSliderViewAdapter gXSliderViewAdapter;
            JSON f = qs0Var.f(jSONObject);
            JSONArray jSONArray = f instanceof JSONArray ? (JSONArray) f : null;
            if (jSONArray == null) {
                GXRegisterCenter.b d = GXRegisterCenter.Companion.a().d();
                boolean z = false;
                if (d != null && d.f()) {
                    z = true;
                }
                if (z) {
                    jSONArray = new JSONArray();
                } else {
                    throw new IllegalArgumentException("Slider or Grid must be have a array data source");
                }
            }
            GXSliderView gXSliderView = (GXSliderView) view;
            os0Var.t();
            CopyOnWriteArraySet<GXIContainer> d2 = os0Var.d();
            if (d2 != null) {
                d2.add(gXSliderView);
            }
            gXSliderView.setTemplateContext(os0Var);
            GXViewPager viewPager = gXSliderView.getViewPager();
            if ((viewPager == null ? null : viewPager.getAdapter()) != null) {
                GXViewPager viewPager2 = gXSliderView.getViewPager();
                PagerAdapter adapter = viewPager2 != null ? viewPager2.getAdapter() : null;
                Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.alibaba.gaiax.render.view.container.slider.GXSliderViewAdapter");
                gXSliderViewAdapter = (GXSliderViewAdapter) adapter;
            } else {
                gXSliderViewAdapter = new GXSliderViewAdapter(os0Var, qr0Var);
                GXViewPager viewPager3 = gXSliderView.getViewPager();
                if (viewPager3 != null) {
                    viewPager3.setAdapter(gXSliderViewAdapter);
                }
            }
            gXSliderViewAdapter.f(qr0Var.o().i().i());
            gXSliderView.setConfig(qr0Var.o().i().i());
            gXSliderViewAdapter.g(jSONArray);
            gXSliderView.setPageSize(jSONArray.size());
            gXSliderView.onBindData(jSONObject);
        }

        private final void n(os0 os0Var, GXIViewBindData gXIViewBindData, pq0 pq0Var, gr0 gr0Var, qs0 qs0Var, JSONObject jSONObject) {
            GXTemplateEngine.GXIDataListener b;
            CharSequence onTextProcess;
            Object obj;
            JSONObject d = qs0Var.d(jSONObject);
            GXTemplateEngine.h p = os0Var.p();
            String str = null;
            if ((p == null ? null : p.b()) != null) {
                GXTemplateEngine.j jVar = new GXTemplateEngine.j();
                if (d != null && (obj = d.get("value")) != null) {
                    str = obj.toString();
                }
                jVar.m(str);
                jVar.g((View) gXIViewBindData);
                jVar.e(gr0Var.d());
                jVar.f(os0Var.r());
                jVar.k(pq0Var);
                jVar.l(d);
                jVar.d(Integer.valueOf(os0Var.h()));
                jVar.j(qs0Var.h(jSONObject));
                GXTemplateEngine.h p2 = os0Var.p();
                if (p2 != null && (b = p2.b()) != null && (onTextProcess = b.onTextProcess(jVar)) != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (d != null) {
                        jSONObject2.putAll(d);
                    }
                    jSONObject2.put((JSONObject) "value", (String) onTextProcess);
                    gXIViewBindData.onBindData(jSONObject2);
                    return;
                }
            }
            gXIViewBindData.onBindData(d);
        }

        private final void o(GXIViewBindData gXIViewBindData, qs0 qs0Var, JSONObject jSONObject) {
            gXIViewBindData.onBindData(qs0Var.d(jSONObject));
        }

        private final void p(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            GXIExpression a;
            GXIExpression a2;
            String string;
            zp0 a3 = qr0Var.o().a();
            Object expression = (a3 == null || (a = a3.a()) == null) ? null : a.expression();
            JSONObject jSONObject2 = expression instanceof JSONObject ? (JSONObject) expression : null;
            if (jSONObject2 == null) {
                return;
            }
            zp0 a4 = qr0Var.o().a();
            Object value = (a4 == null || (a2 = a4.a()) == null) ? null : a2.value(jSONObject);
            JSONObject jSONObject3 = value instanceof JSONObject ? (JSONObject) value : null;
            if (jSONObject3 == null || (string = jSONObject3.getString("type")) == null) {
                return;
            }
            if (jSONObject3.getBooleanValue(zp0.KEY_TRIGGER)) {
                if (b41.d(xq0.INSTANCE.c(os0Var.q().n(), jSONObject3.get("state")), Boolean.TRUE)) {
                    u(os0Var, qr0Var, jSONObject2, jSONObject3, string);
                    return;
                }
                return;
            }
            u(os0Var, qr0Var, jSONObject2, jSONObject3, string);
        }

        private final void q(os0 os0Var, qr0 qr0Var) {
            View q = qr0Var.q();
            if (q == null) {
                return;
            }
            pq0 b = qr0Var.o().b();
            a(os0Var, qr0Var, b, q);
            b(qr0Var, b);
            if ((q instanceof GXText) && (qr0Var.I() || qr0Var.F() || qr0Var.x())) {
                ((GXText) q).setTextStyle(b);
            } else if ((q instanceof GXIImageView) && qr0Var.y()) {
                ((GXIImageView) q).setImageStyle(os0Var, b);
            } else if (qr0Var.t()) {
                d(os0Var, q, qr0Var);
            }
            c(q, b, qr0Var);
        }

        private final void r(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            View q;
            if (qr0Var.o().e() == null || (q = qr0Var.q()) == null || !(q instanceof GXIViewBindData)) {
                return;
            }
            pq0 b = qr0Var.o().b();
            gr0 i = qr0Var.o().i();
            if (qr0Var.u()) {
                e((GXIViewBindData) q, qr0Var.o(), jSONObject);
            } else if (qr0Var.I()) {
                n(os0Var, (GXIViewBindData) q, b, i, qr0Var.o(), jSONObject);
            } else if (qr0Var.F()) {
                j(os0Var, (GXIViewBindData) q, b, i, qr0Var.o(), jSONObject);
            } else if (qr0Var.x()) {
                g((GXIViewBindData) q, qr0Var.o(), jSONObject);
            } else if (qr0Var.y()) {
                h((GXIViewBindData) q, qr0Var.o(), jSONObject);
            } else if (qr0Var.E()) {
                i((GXIViewBindData) q, qr0Var.o(), jSONObject);
            } else if (!qr0Var.G() && !qr0Var.w()) {
                if (qr0Var.H()) {
                    m(os0Var, q, qr0Var, qr0Var.o(), jSONObject);
                } else if (qr0Var.J() || qr0Var.v()) {
                    o((GXIViewBindData) q, qr0Var.o(), jSONObject);
                }
            } else {
                k(os0Var, q, qr0Var, qr0Var.o(), jSONObject);
            }
            os0Var.E(os0Var.c() + 1);
        }

        private final void s(final os0 os0Var, qr0 qr0Var, JSON json) {
            Boolean bool;
            if ((json instanceof JSONObject) && !qr0Var.o().b().b().W()) {
                View q = qr0Var.q();
                JSONObject h = qr0Var.o().h(json);
                if (h != null && (bool = h.getBoolean("enable")) != null) {
                    boolean booleanValue = bool.booleanValue();
                    if (q != null) {
                        q.setEnabled(booleanValue);
                    }
                    if (!booleanValue) {
                        return;
                    }
                }
                if (q instanceof RecyclerView) {
                    GXTemplateEngine.h p = os0Var.p();
                    if ((p == null ? null : p.c()) != null) {
                        RecyclerView recyclerView = (RecyclerView) q;
                        recyclerView.clearOnScrollListeners();
                        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.alibaba.gaiax.render.node.GXNodeTreeUpdate$Style$nodeViewEvent$2
                            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int i) {
                                GXTemplateEngine.GXIEventListener c;
                                b41.i(recyclerView2, "recyclerView");
                                GXTemplateEngine.g gVar = new GXTemplateEngine.g();
                                gVar.i(GXTemplateEngine.g.TYPE_ON_SCROLL_STATE_CHANGED);
                                gVar.j(recyclerView2);
                                gVar.h(i);
                                GXTemplateEngine.h p2 = os0.this.p();
                                if (p2 == null || (c = p2.c()) == null) {
                                    return;
                                }
                                c.onScrollEvent(gVar);
                            }

                            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                            public void onScrolled(@NotNull RecyclerView recyclerView2, int i, int i2) {
                                GXTemplateEngine.GXIEventListener c;
                                b41.i(recyclerView2, "recyclerView");
                                GXTemplateEngine.g gVar = new GXTemplateEngine.g();
                                gVar.i(GXTemplateEngine.g.TYPE_ON_SCROLLED);
                                gVar.j(recyclerView2);
                                gVar.f(i);
                                gVar.g(i2);
                                GXTemplateEngine.h p2 = os0.this.p();
                                if (p2 == null || (c = p2.c()) == null) {
                                    return;
                                }
                                c.onScrollEvent(gVar);
                            }
                        });
                    }
                }
                if (qr0Var.o().g() != null) {
                    GXINodeEvent f = qr0Var.f();
                    if (f == null) {
                        GXRegisterCenter.GXIExtensionNodeEvent n = GXRegisterCenter.Companion.a().n();
                        GXINodeEvent create = n != null ? n.create() : null;
                        f = create == null ? new rr0() : create;
                    }
                    qr0Var.Q(f);
                    GXINodeEvent f2 = qr0Var.f();
                    if (f2 != null) {
                        f2.addDataBindingEvent(os0Var, qr0Var, (JSONObject) json);
                        return;
                    }
                    throw new IllegalArgumentException("Not support the event");
                }
            }
        }

        private final void t(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            JSONObject jSONObject2;
            GXTemplateEngine.GXITrackListener f;
            View q = qr0Var.q();
            if (q == null) {
                return;
            }
            qs0 o = qr0Var.o();
            if (o.b().b().W()) {
                return;
            }
            ss0 l = o.l();
            if (l != null) {
                Object value = l.a().value(jSONObject);
                jSONObject2 = value instanceof JSONObject ? (JSONObject) value : null;
                if (jSONObject2 == null) {
                    return;
                }
                GXTemplateEngine.k kVar = new GXTemplateEngine.k();
                kVar.i(q);
                kVar.h(jSONObject2);
                kVar.f(o.i().d());
                kVar.g(os0Var.r());
                kVar.e(-1);
                if (os0Var.i() == null) {
                    os0Var.I(new LinkedHashMap());
                }
                Map<String, GXTemplateEngine.k> i = os0Var.i();
                if (i == null) {
                    return;
                }
                i.put(o.j(), kVar);
                return;
            }
            vq0 g = o.g();
            if (g == null) {
                return;
            }
            Object value2 = g.a().value(jSONObject);
            jSONObject2 = value2 instanceof JSONObject ? (JSONObject) value2 : null;
            if (jSONObject2 == null) {
                return;
            }
            GXTemplateEngine.k kVar2 = new GXTemplateEngine.k();
            kVar2.i(q);
            kVar2.h(jSONObject2);
            kVar2.f(o.i().d());
            kVar2.g(os0Var.r());
            kVar2.e(-1);
            GXTemplateEngine.h p = os0Var.p();
            if (p == null || (f = p.f()) == null) {
                return;
            }
            f.onTrackEvent(kVar2);
        }

        private final void u(os0 os0Var, qr0 qr0Var, JSONObject jSONObject, JSONObject jSONObject2, String str) {
            boolean q;
            boolean q2;
            GXIAnimation gXIAnimation;
            q = o.q(f81.TAG, str, true);
            if (q) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(zp0.KEY_LOTTIE_ANIMATOR);
                if (jSONObject3 == null) {
                    GXRegisterCenter.b d = GXRegisterCenter.Companion.a().d();
                    if (!(d != null && d.d())) {
                        return;
                    }
                    jSONObject3 = jSONObject2;
                }
                gXIAnimation = mr0.Companion.a(jSONObject3);
            } else {
                q2 = o.q("PROP", str, true);
                if (q2) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject(zp0.KEY_PROP_ANIMATOR_SET);
                    if (jSONObject4 == null) {
                        return;
                    }
                    gXIAnimation = GXPropAnimationSet.Companion.a(jSONObject4);
                } else {
                    gXIAnimation = null;
                }
            }
            if (gXIAnimation instanceof GXPropAnimationSet) {
                View q3 = qr0Var.q();
                if (q3 == null) {
                    return;
                }
                ((GXPropAnimationSet) gXIAnimation).c(os0Var, qr0Var, q3);
            } else if (gXIAnimation instanceof mr0) {
                ((mr0) gXIAnimation).playAnimation(os0Var, qr0Var, jSONObject, jSONObject2);
            }
        }

        private final void v(qr0 qr0Var) {
            View q;
            if (qr0Var.o().e() == null || (q = qr0Var.q()) == null || !(q instanceof GXIViewBindData)) {
                return;
            }
            ((GXIViewBindData) q).onResetData();
        }

        private final void x(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            B(os0Var, qr0Var, jSONObject);
        }

        private final void y(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            qs0 m = qr0Var.o().m();
            JSON f = m == null ? null : m.f(jSONObject);
            JSONObject jSONObject2 = f instanceof JSONObject ? (JSONObject) f : null;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            B(os0Var, qr0Var, jSONObject2);
        }

        private final void z(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            if (qr0Var.o().p()) {
                y(os0Var, qr0Var, jSONObject);
            } else {
                A(os0Var, qr0Var, jSONObject);
            }
        }

        public final void C(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONObject jSONObject) {
            b41.i(os0Var, "gxTemplateContext");
            b41.i(qr0Var, "gxNode");
            b41.i(jSONObject, "templateData");
            if (qr0Var.B()) {
                z(os0Var, qr0Var, jSONObject);
            } else if (qr0Var.t()) {
                x(os0Var, qr0Var, jSONObject);
            } else {
                D(os0Var, qr0Var, jSONObject);
            }
        }

        public final void w(@NotNull qr0 qr0Var) {
            b41.i(qr0Var, "gxNode");
            v(qr0Var);
            List<qr0> d = qr0Var.d();
            if (d == null) {
                return;
            }
            for (qr0 qr0Var2 : d) {
                INSTANCE.w(qr0Var2);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        private final boolean a(qr0 qr0Var) {
            if (qr0Var == null) {
                return true;
            }
            Node c = qr0Var.n().c();
            if (c != null) {
                return (c.getStyle().getDisplay() == Display.Flex) && a(qr0Var.l());
            }
            throw new IllegalArgumentException("stretch node is null, please check!");
        }

        private final boolean b(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            ld2<k80> A;
            k80 a;
            ld2<k80> h;
            k80 a2;
            boolean z;
            ld2<k80> v;
            k80 a3;
            JSON f = qr0Var.o().f(jSONObject);
            JSONArray jSONArray = f instanceof JSONArray ? (JSONArray) f : null;
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            Node c = qr0Var.n().c();
            if (c != null) {
                app.visly.stretch.Style style = c.getStyle();
                br0 a4 = qr0Var.o().b().a();
                ld2<k80> V = a4.V();
                k80 a5 = V != null ? V.a() : null;
                Float t = a4.t();
                if (qr0Var.G()) {
                    fs0 h2 = qr0Var.o().i().h();
                    if (h2 != null) {
                        boolean z2 = h2.j() && t == null && (a5 == null || b41.d(a5, k80.a.INSTANCE) || b41.d(a5, k80.d.INSTANCE));
                        GXRegisterCenter.GXIExtensionDynamicProperty h3 = GXRegisterCenter.Companion.a().h();
                        if (h3 != null) {
                            GXRegisterCenter.GXIExtensionDynamicProperty.a aVar = new GXRegisterCenter.GXIExtensionDynamicProperty.a("scroll-compute-container-height", Boolean.valueOf(z2));
                            aVar.f(a4);
                            wt2 wt2Var = wt2.INSTANCE;
                            Object convert = h3.convert(aVar);
                            if (convert != null) {
                                z2 = ((Boolean) convert).booleanValue();
                            }
                        }
                        if (z2 && (v = vr0.INSTANCE.v(os0Var, qr0Var, jSONArray)) != null && (a3 = v.a()) != null) {
                            ld2<k80> V2 = a4.V();
                            if (V2 != null) {
                                V2.c(a3);
                            }
                            z = true;
                        }
                        z = false;
                    } else {
                        throw new IllegalArgumentException("Want to updateContainerLayout, but gxScrollConfig is null");
                    }
                } else if (qr0Var.w()) {
                    er0 c2 = qr0Var.o().i().c();
                    if (c2 != null) {
                        boolean z3 = c2.n() && t == null && (a5 == null || b41.d(a5, k80.a.INSTANCE) || b41.d(a5, k80.d.INSTANCE));
                        GXRegisterCenter.GXIExtensionDynamicProperty h4 = GXRegisterCenter.Companion.a().h();
                        if (h4 != null) {
                            GXRegisterCenter.GXIExtensionDynamicProperty.a aVar2 = new GXRegisterCenter.GXIExtensionDynamicProperty.a("grid-compute-container-height", Boolean.valueOf(z3));
                            aVar2.g(c2);
                            aVar2.f(a4);
                            wt2 wt2Var2 = wt2.INSTANCE;
                            Object convert2 = h4.convert(aVar2);
                            if (convert2 != null) {
                                z3 = ((Boolean) convert2).booleanValue();
                            }
                        }
                        if (z3 && (h = vr0.INSTANCE.h(os0Var, qr0Var, jSONArray)) != null && (a2 = h.a()) != null) {
                            ld2<k80> V3 = a4.V();
                            if (V3 != null) {
                                V3.c(a2);
                            }
                            z = true;
                        }
                        z = false;
                    } else {
                        throw new IllegalArgumentException("Want to updateContainerLayout, but gxGridConfig is null");
                    }
                } else {
                    if (qr0Var.H()) {
                        if ((a5 == null || b41.d(a5, k80.a.INSTANCE) || b41.d(a5, k80.d.INSTANCE)) && (A = vr0.INSTANCE.A(os0Var, qr0Var, jSONArray)) != null && (a = A.a()) != null) {
                            ld2<k80> V4 = a4.V();
                            if (V4 != null) {
                                V4.c(a);
                            }
                            z = true;
                        }
                    }
                    z = false;
                }
                Boolean f2 = f(os0Var, qr0Var);
                if (f2 != null) {
                    z = f2.booleanValue();
                }
                if (z) {
                    style.safeFree();
                    style.safeInit();
                    c.safeSetStyle(style);
                    c.safeMarkDirty();
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("stretch node is null, please check!");
        }

        private final void c(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            qr0Var.n().d();
            qr0Var.o().n(os0Var, null, jSONObject);
            j(os0Var, qr0Var, jSONObject);
        }

        private final Boolean d(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            Node c = qr0Var.n().c();
            if (c != null) {
                ls0 b = qr0Var.o().b().b();
                if (b41.d(b.q(), Boolean.TRUE) && a(qr0Var)) {
                    if (!os0Var.x() && !os0Var.w()) {
                        return e(os0Var, qr0Var, qr0Var.o(), qr0Var.n(), b, jSONObject, c.getStyle());
                    }
                    if (os0Var.f() == null) {
                        os0Var.G(new LinkedHashSet());
                    }
                    Set<uq0> f = os0Var.f();
                    if (f != null) {
                        f.add(new uq0(os0Var, qr0Var, jSONObject));
                    }
                }
                return null;
            }
            throw new IllegalArgumentException("stretch node is null, please check!");
        }

        private final Boolean e(os0 os0Var, qr0 qr0Var, qs0 qs0Var, js0 js0Var, ls0 ls0Var, JSONObject jSONObject, app.visly.stretch.Style style) {
            ld2<k80> a = ar0.INSTANCE.a(os0Var, qr0Var, qs0Var, js0Var, jSONObject);
            if (a == null) {
                return null;
            }
            rs0.INSTANCE.b(a, style.getSize());
            GXRegisterCenter.GXIExtensionDynamicProperty h = GXRegisterCenter.Companion.a().h();
            if (h != null) {
                GXRegisterCenter.GXIExtensionDynamicProperty.a aVar = new GXRegisterCenter.GXIExtensionDynamicProperty.a("size", style.getSize());
                aVar.e(ls0Var);
                wt2 wt2Var = wt2.INSTANCE;
                h.convert(aVar);
            }
            if (!(style.getFlexGrow() == 0.0f)) {
                style.setFlexGrow(0.0f);
            }
            return Boolean.TRUE;
        }

        private final Boolean f(os0 os0Var, qr0 qr0Var) {
            lz1<k80> Q;
            br0 a = qr0Var.o().b().a();
            ls0 b = qr0Var.o().b().b();
            Node c = qr0Var.n().c();
            if (c != null) {
                app.visly.stretch.Style style = c.getStyle();
                Boolean bool = null;
                Display n = a.n();
                if (n != null) {
                    style.setDisplay(n);
                    bool = Boolean.TRUE;
                }
                Float g = a.g();
                if (g != null) {
                    style.setAspectRatio(Float.valueOf(g.floatValue()));
                    bool = Boolean.TRUE;
                }
                Direction l = a.l();
                if (l != null) {
                    style.setDirection(l);
                    bool = Boolean.TRUE;
                }
                FlexDirection r = a.r();
                if (r != null) {
                    style.setFlexDirection(r);
                    bool = Boolean.TRUE;
                }
                FlexWrap x = a.x();
                if (x != null) {
                    style.setFlexWrap(x);
                    bool = Boolean.TRUE;
                }
                Overflow K = a.K();
                if (K != null) {
                    style.setOverflow(K);
                    bool = Boolean.TRUE;
                }
                AlignItems c2 = a.c();
                if (c2 != null) {
                    style.setAlignItems(c2);
                    bool = Boolean.TRUE;
                }
                AlignSelf e = a.e();
                if (e != null) {
                    style.setAlignSelf(e);
                    bool = Boolean.TRUE;
                }
                AlignContent a2 = a.a();
                if (a2 != null) {
                    style.setAlignContent(a2);
                    bool = Boolean.TRUE;
                }
                JustifyContent z = a.z();
                if (z != null) {
                    style.setJustifyContent(z);
                    bool = Boolean.TRUE;
                }
                PositionType S = a.S();
                if (S != null) {
                    style.setPositionType(S);
                    bool = Boolean.TRUE;
                }
                if (style.getPositionType() == PositionType.Absolute && (Q = a.Q()) != null) {
                    rs0.INSTANCE.a(Q, style.getPosition());
                    bool = Boolean.TRUE;
                }
                lz1<k80> C = a.C();
                if (C != null) {
                    rs0.INSTANCE.a(C, style.getMargin());
                    bool = Boolean.TRUE;
                }
                lz1<k80> N = a.N();
                if (N != null) {
                    rs0.INSTANCE.a(N, style.getPadding());
                    bool = Boolean.TRUE;
                }
                lz1<k80> j = a.j();
                if (j != null) {
                    rs0.INSTANCE.a(j, style.getBorder());
                    bool = Boolean.TRUE;
                }
                Float t = a.t();
                if (t != null) {
                    style.setFlexGrow(t.floatValue());
                    os0Var.b();
                    bool = Boolean.TRUE;
                }
                Float v = a.v();
                if (v != null) {
                    style.setFlexShrink(v.floatValue());
                    bool = Boolean.TRUE;
                }
                ld2<k80> V = a.V();
                if (V != null) {
                    rs0.INSTANCE.b(V, style.getSize());
                    GXRegisterCenter.GXIExtensionDynamicProperty h = GXRegisterCenter.Companion.a().h();
                    if (h != null) {
                        GXRegisterCenter.GXIExtensionDynamicProperty.a aVar = new GXRegisterCenter.GXIExtensionDynamicProperty.a("size", style.getSize());
                        aVar.e(b);
                        wt2 wt2Var = wt2.INSTANCE;
                        h.convert(aVar);
                    }
                    bool = Boolean.TRUE;
                }
                ld2<k80> I = a.I();
                if (I != null) {
                    rs0.INSTANCE.b(I, style.getMinSize());
                    GXRegisterCenter.GXIExtensionDynamicProperty h2 = GXRegisterCenter.Companion.a().h();
                    if (h2 != null) {
                        GXRegisterCenter.GXIExtensionDynamicProperty.a aVar2 = new GXRegisterCenter.GXIExtensionDynamicProperty.a("min-size", style.getMinSize());
                        aVar2.e(b);
                        wt2 wt2Var2 = wt2.INSTANCE;
                        h2.convert(aVar2);
                    }
                    bool = Boolean.TRUE;
                }
                ld2<k80> F = a.F();
                if (F == null) {
                    return bool;
                }
                rs0.INSTANCE.b(F, style.getMaxSize());
                GXRegisterCenter.GXIExtensionDynamicProperty h3 = GXRegisterCenter.Companion.a().h();
                if (h3 != null) {
                    GXRegisterCenter.GXIExtensionDynamicProperty.a aVar3 = new GXRegisterCenter.GXIExtensionDynamicProperty.a("max-size", style.getMaxSize());
                    aVar3.e(b);
                    wt2 wt2Var3 = wt2.INSTANCE;
                    h3.convert(aVar3);
                }
                return Boolean.TRUE;
            }
            throw new IllegalArgumentException("stretch node is null, please check!");
        }

        private final void g(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            qs0 m = qr0Var.o().m();
            JSON f = m == null ? null : m.f(jSONObject);
            if (f instanceof JSONArray) {
                GXRegisterCenter.b d = GXRegisterCenter.Companion.a().d();
                boolean z = false;
                if (d != null && d.a()) {
                    z = true;
                }
                if (z) {
                    qs0 m2 = qr0Var.o().m();
                    rq0 e = m2 == null ? null : m2.e();
                    qs0 m3 = qr0Var.o().m();
                    if (m3 != null) {
                        m3.D(qr0Var.o().e());
                    }
                    qr0Var.o().D(e);
                    qr0Var.o().C();
                    qs0 m4 = qr0Var.o().m();
                    f = m4 == null ? null : m4.f(jSONObject);
                } else {
                    throw new IllegalArgumentException("update nest container need a JSONObject, but the result is a JSONArray");
                }
            }
            JSONObject jSONObject2 = f instanceof JSONObject ? (JSONObject) f : null;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            qr0Var.n().d();
            qr0Var.o().n(os0Var, jSONObject, jSONObject2);
            j(os0Var, qr0Var, jSONObject2);
        }

        private final void h(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            if (qr0Var.o().p()) {
                g(os0Var, qr0Var, jSONObject);
            } else {
                i(os0Var, qr0Var, jSONObject);
            }
        }

        private final void i(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            qs0 m = qr0Var.o().m();
            JSON f = m == null ? null : m.f(jSONObject);
            JSONObject jSONObject2 = f instanceof JSONObject ? (JSONObject) f : null;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            qr0Var.n().d();
            qr0Var.o().n(os0Var, jSONObject, jSONObject2);
            j(os0Var, qr0Var, jSONObject2);
            List<qr0> d = qr0Var.d();
            if (d == null) {
                return;
            }
            for (qr0 qr0Var2 : d) {
                INSTANCE.k(os0Var, qr0Var2, jSONObject2);
            }
        }

        private final void j(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            if (qr0Var.t()) {
                if (b(os0Var, qr0Var, jSONObject)) {
                    os0Var.F(true);
                }
            } else if (n(os0Var, qr0Var, jSONObject)) {
                os0Var.F(true);
            }
        }

        private final void k(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            qr0Var.L(os0Var);
            if (qr0Var.B()) {
                h(os0Var, qr0Var, jSONObject);
            } else if (qr0Var.t()) {
                c(os0Var, qr0Var, jSONObject);
            } else {
                o(os0Var, qr0Var, jSONObject);
            }
        }

        private final boolean n(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            Boolean f = f(os0Var, qr0Var);
            boolean booleanValue = f == null ? false : f.booleanValue();
            Boolean d = d(os0Var, qr0Var, jSONObject);
            if (d != null) {
                booleanValue = d.booleanValue();
            }
            Node c = qr0Var.n().c();
            if (c != null) {
                app.visly.stretch.Style style = c.getStyle();
                if (booleanValue) {
                    style.safeFree();
                    style.safeInit();
                    c.safeSetStyle(style);
                    c.safeMarkDirty();
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("stretch node is null, please check!");
        }

        private final void o(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            qr0Var.n().d();
            qr0Var.o().n(os0Var, null, jSONObject);
            j(os0Var, qr0Var, jSONObject);
            List<qr0> d = qr0Var.d();
            if (d == null) {
                return;
            }
            for (qr0 qr0Var2 : d) {
                INSTANCE.k(os0Var, qr0Var2, jSONObject);
            }
        }

        private final boolean p(os0 os0Var, qr0 qr0Var, JSONObject jSONObject) {
            qs0 o = qr0Var.o();
            js0 n = qr0Var.n();
            Node c = qr0Var.n().c();
            if (c != null) {
                app.visly.stretch.Style style = c.getStyle();
                if (b41.d(e(os0Var, qr0Var, o, n, qr0Var.o().b().b(), jSONObject, style), Boolean.TRUE)) {
                    style.safeFree();
                    style.safeInit();
                    c.safeSetStyle(style);
                    c.safeMarkDirty();
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("stretch node is null, please check!");
        }

        public final void l(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONObject jSONObject, @NotNull ld2<Float> ld2Var) {
            b41.i(os0Var, "gxTemplateContext");
            b41.i(qr0Var, "gxNode");
            b41.i(jSONObject, "templateData");
            b41.i(ld2Var, "size");
            k(os0Var, qr0Var, jSONObject);
            if (os0Var.v()) {
                vr0.INSTANCE.j(qr0Var, ld2Var);
            }
        }

        public final void m(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull ld2<Float> ld2Var) {
            b41.i(os0Var, "gxTemplateContext");
            b41.i(qr0Var, "rootNode");
            b41.i(ld2Var, "size");
            Set<uq0> f = os0Var.f();
            boolean z = false;
            if (f != null && (f.isEmpty() ^ true)) {
                Set<uq0> f2 = os0Var.f();
                if (f2 != null) {
                    for (uq0 uq0Var : f2) {
                        if (INSTANCE.p(uq0Var.b(), uq0Var.a(), uq0Var.c())) {
                            z = true;
                        }
                    }
                }
                Set<uq0> f3 = os0Var.f();
                if (f3 != null) {
                    f3.clear();
                }
                if (z) {
                    vr0.INSTANCE.j(qr0Var, ld2Var);
                }
            }
        }
    }

    private GXNodeTreeUpdate() {
    }

    public final void a(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        qr0 j = os0Var.j();
        if (j != null) {
            GXTemplateEngine.h p = os0Var.p();
            JSONObject a2 = p == null ? null : p.a();
            if (a2 != null) {
                ld2<Float> ld2Var = new ld2<>(os0Var.n().b(), os0Var.n().a());
                a aVar = a.INSTANCE;
                aVar.l(os0Var, j, a2, ld2Var);
                aVar.m(os0Var, j, ld2Var);
                return;
            }
            throw new IllegalArgumentException("Data is null");
        }
        throw new IllegalArgumentException("RootNode is null(buildNodeLayout)");
    }

    public final void b(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        qr0 j = os0Var.j();
        if (j != null) {
            GXTemplateEngine.h p = os0Var.p();
            JSONObject a2 = p == null ? null : p.a();
            if (a2 != null) {
                Style.INSTANCE.C(os0Var, j, a2);
                return;
            }
            throw new IllegalArgumentException("Data is null");
        }
        throw new IllegalArgumentException("RootNode is null(buildViewStyle)");
    }

    public final void c(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        qr0 j = os0Var.j();
        if (j != null) {
            Style.INSTANCE.w(j);
            return;
        }
        throw new IllegalArgumentException("RootNode is null(resetView)");
    }
}
