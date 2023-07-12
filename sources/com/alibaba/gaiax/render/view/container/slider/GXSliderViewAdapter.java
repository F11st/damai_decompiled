package com.alibaba.gaiax.render.view.container.slider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.basic.GXItemContainer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.C8212k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.is0;
import tb.l81;
import tb.ld2;
import tb.os0;
import tb.qr0;
import tb.qs0;
import tb.vr0;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/slider/GXSliderViewAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Ltb/os0;", "gxTemplateContext", "Ltb/qr0;", "gxNode", "<init>", "(Ltb/os0;Ltb/qr0;)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public final class GXSliderViewAdapter extends PagerAdapter {
    @NotNull
    private final os0 a;
    @NotNull
    private final qr0 b;
    private boolean c;
    @NotNull
    private final Map<String, View> d;
    @Nullable
    private is0 e;
    @NotNull
    private JSONArray f;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.slider.GXSliderViewAdapter$a */
    /* loaded from: classes6.dex */
    public static final class C3378a implements GXTemplateEngine.GXIEventListener {
        final /* synthetic */ int a;
        final /* synthetic */ GXSliderViewAdapter b;

        C3378a(int i, GXSliderViewAdapter gXSliderViewAdapter) {
            this.a = i;
            this.b = gXSliderViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onAnimationEvent(@NotNull GXTemplateEngine.C3338b c3338b) {
            GXTemplateEngine.GXIEventListener c;
            b41.i(c3338b, "gxAnimation");
            GXTemplateEngine.GXIEventListener.C3335a.a(this, c3338b);
            GXTemplateEngine.C3346h p = this.b.a().p();
            if (p == null || (c = p.c()) == null) {
                return;
            }
            c.onAnimationEvent(c3338b);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onGestureEvent(@NotNull GXTemplateEngine.C3342e c3342e) {
            GXTemplateEngine.GXIEventListener c;
            b41.i(c3342e, "gxGesture");
            GXTemplateEngine.GXIEventListener.C3335a.b(this, c3342e);
            c3342e.setIndex(Integer.valueOf(this.a));
            GXTemplateEngine.C3346h p = this.b.a().p();
            if (p == null || (c = p.c()) == null) {
                return;
            }
            c.onGestureEvent(c3342e);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onScrollEvent(@NotNull GXTemplateEngine.C3344g c3344g) {
            GXTemplateEngine.GXIEventListener c;
            b41.i(c3344g, "gxScroll");
            GXTemplateEngine.GXIEventListener.C3335a.c(this, c3344g);
            GXTemplateEngine.C3346h p = this.b.a().p();
            if (p == null || (c = p.c()) == null) {
                return;
            }
            c.onScrollEvent(c3344g);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.slider.GXSliderViewAdapter$b */
    /* loaded from: classes6.dex */
    public static final class C3379b implements GXTemplateEngine.GXITrackListener {
        final /* synthetic */ int a;
        final /* synthetic */ GXSliderViewAdapter b;

        C3379b(int i, GXSliderViewAdapter gXSliderViewAdapter) {
            this.a = i;
            this.b = gXSliderViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onManualClickTrackEvent(@NotNull GXTemplateEngine.C3349k c3349k) {
            GXTemplateEngine.GXITrackListener f;
            b41.i(c3349k, "gxTrack");
            c3349k.e(Integer.valueOf(this.a));
            GXTemplateEngine.C3346h p = this.b.a().p();
            if (p == null || (f = p.f()) == null) {
                return;
            }
            f.onManualClickTrackEvent(c3349k);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onManualExposureTrackEvent(@NotNull GXTemplateEngine.C3349k c3349k) {
            GXTemplateEngine.GXITrackListener f;
            b41.i(c3349k, "gxTrack");
            c3349k.e(Integer.valueOf(this.a));
            GXTemplateEngine.C3346h p = this.b.a().p();
            if (p == null || (f = p.f()) == null) {
                return;
            }
            f.onManualExposureTrackEvent(c3349k);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onTrackEvent(@NotNull GXTemplateEngine.C3349k c3349k) {
            GXTemplateEngine.GXITrackListener f;
            b41.i(c3349k, "gxTrack");
            c3349k.e(Integer.valueOf(this.a));
            GXTemplateEngine.C3346h p = this.b.a().p();
            if (p == null || (f = p.f()) == null) {
                return;
            }
            f.onTrackEvent(c3349k);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.slider.GXSliderViewAdapter$c */
    /* loaded from: classes6.dex */
    public static final class C3380c implements GXTemplateEngine.GXIDataListener {
        C3380c() {
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIDataListener
        @Nullable
        public CharSequence onTextProcess(@NotNull GXTemplateEngine.C3348j c3348j) {
            GXTemplateEngine.GXIDataListener b;
            b41.i(c3348j, "gxTextData");
            GXTemplateEngine.C3346h p = GXSliderViewAdapter.this.a().p();
            if (p == null || (b = p.b()) == null) {
                return null;
            }
            return b.onTextProcess(c3348j);
        }
    }

    public GXSliderViewAdapter(@NotNull os0 os0Var, @NotNull qr0 qr0Var) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        this.a = os0Var;
        this.b = qr0Var;
        this.d = new LinkedHashMap();
        this.f = new JSONArray();
    }

    private final ViewPager.LayoutParams b(l81 l81Var) {
        int e = l81Var == null ? -2 : (int) l81Var.e();
        int d = l81Var != null ? (int) l81Var.d() : -2;
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        ((ViewGroup.LayoutParams) layoutParams).width = e;
        ((ViewGroup.LayoutParams) layoutParams).height = d;
        return layoutParams;
    }

    private final String d(int i) {
        return b41.r("item_", Integer.valueOf(i));
    }

    private final GXTemplateEngine.C3347i e() {
        Pair pair;
        List<Pair<GXTemplateEngine.C3347i, qs0>> c = this.b.c();
        if (c == null || (pair = (Pair) C8212k.R(c)) == null) {
            return null;
        }
        return (GXTemplateEngine.C3347i) pair.getFirst();
    }

    @NotNull
    public final os0 a() {
        return this.a;
    }

    @Nullable
    public final View c(int i) {
        return this.d.get(d(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup viewGroup, int i, @NotNull Object obj) {
        b41.i(viewGroup, "container");
        b41.i(obj, "obj");
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
        this.d.remove(d(i));
    }

    public final void f(@Nullable is0 is0Var) {
        this.e = is0Var;
    }

    public final void g(@NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "data");
        this.c = this.a.y();
        this.f = jSONArray;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        is0 is0Var = this.e;
        boolean z = false;
        if (is0Var != null && !is0Var.m()) {
            z = true;
        }
        if (z) {
            return this.f.size();
        }
        return Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object obj) {
        b41.i(obj, "object");
        if (this.c) {
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i) {
        Pair pair;
        View f;
        b41.i(viewGroup, "container");
        int size = this.f.size() > 0 ? i % this.f.size() : i;
        GXTemplateEngine.C3347i e = e();
        if (e != null) {
            JSONObject jSONObject = this.f.getJSONObject(size);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = jSONObject;
            List<Pair<GXTemplateEngine.C3347i, qs0>> c = this.b.c();
            qs0 qs0Var = (c == null || (pair = (Pair) C8212k.R(c)) == null) ? null : (qs0) pair.getSecond();
            vr0 vr0Var = vr0.INSTANCE;
            ld2<Float> z = vr0Var.z(this.a, this.b);
            GXTemplateEngine.C3343f c3343f = new GXTemplateEngine.C3343f(z.b(), z.a());
            ViewPager.LayoutParams b = b(vr0Var.x(this.a, this.b, z, jSONObject2, size));
            Context context = viewGroup.getContext();
            b41.h(context, "container.context");
            GXItemContainer gXItemContainer = new GXItemContainer(context);
            gXItemContainer.setLayoutParams(b);
            GXRegisterCenter.GXIExtensionContainerItemBind f2 = GXRegisterCenter.Companion.a().f();
            if (f2 != null) {
                GXTemplateEngine.C3346h p = this.a.p();
                Object e2 = p == null ? null : p.e();
                GXTemplateEngine.C3341d c3341d = new GXTemplateEngine.C3341d();
                c3341d.g(Integer.valueOf(size));
                c3341d.f(jSONObject2);
                c3341d.e(a());
                c3341d.h(qs0Var);
                wt2 wt2Var = wt2.INSTANCE;
                f2.bindViewHolder(e2, gXItemContainer, c3343f, e, c3341d);
            } else {
                if (gXItemContainer.getChildCount() != 0) {
                    f = gXItemContainer.getChildAt(0);
                } else {
                    GXTemplateEngine.C3337a c3337a = GXTemplateEngine.Companion;
                    GXTemplateEngine.v(c3337a.a(), e, c3343f, null, 4, null);
                    GXTemplateEngine a = c3337a.a();
                    GXTemplateEngine.C3341d c3341d2 = new GXTemplateEngine.C3341d();
                    c3341d2.g(Integer.valueOf(size));
                    c3341d2.f(jSONObject2);
                    c3341d2.e(a());
                    c3341d2.h(qs0Var);
                    wt2 wt2Var2 = wt2.INSTANCE;
                    os0 e3 = a.e(e, c3343f, c3341d2);
                    if (e3 != null) {
                        f = c3337a.a().f(e3);
                        gXItemContainer.addView(f);
                    } else {
                        throw new IllegalArgumentException("Create GXTemplateContext fail, please check");
                    }
                }
                GXTemplateEngine.C3346h c3346h = new GXTemplateEngine.C3346h(jSONObject2);
                c3346h.h(new C3378a(size, this));
                c3346h.k(new C3379b(size, this));
                c3346h.g(new C3380c());
                if (f != null) {
                    GXTemplateEngine.C3337a c3337a2 = GXTemplateEngine.Companion;
                    c3337a2.a().b(f, c3346h, c3343f);
                    c3337a2.a().c(f, c3346h, c3343f);
                    gXItemContainer.getLayoutParams().width = f.getLayoutParams().width;
                }
            }
            viewGroup.addView(gXItemContainer);
            this.d.put(d(i), gXItemContainer);
            return gXItemContainer;
        }
        throw new IllegalArgumentException(b41.r("GXTemplateItem not exist, gxNode = ", this.b));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        b41.i(view, "view");
        b41.i(obj, "obj");
        return b41.d(view, obj);
    }
}
