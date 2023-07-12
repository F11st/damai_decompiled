package com.alibaba.gaiax;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Trace;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.data.GXDataImpl;
import com.alibaba.gaiax.data.cache.GXTemplateInfoSource;
import com.alibaba.gaiax.render.utils.GXContainerUtils;
import com.alibaba.gaiax.render.utils.GXIManualExposureEventListener;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.GXIViewVisibleChange;
import com.alibaba.gaiax.template.GXStyleConvert;
import com.alibaba.gaiax.utils.GXGlobalCache;
import com.uc.webview.export.extension.UCCore;
import com.youku.gaiax.api.data.EventParams;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.as0;
import tb.b41;
import tb.bq0;
import tb.cq0;
import tb.hh1;
import tb.k50;
import tb.kr0;
import tb.l81;
import tb.ld2;
import tb.os0;
import tb.pq0;
import tb.ps0;
import tb.qr0;
import tb.qs0;
import tb.sr0;
import tb.vr0;
import tb.wq0;
import tb.zq0;
import tb.zr0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXTemplateEngine {
    @NotNull
    public static final C3337a Companion = new C3337a(null);
    @NotNull
    private static final Lazy<GXTemplateEngine> d;
    public Context a;
    @NotNull
    private final Lazy b;
    @NotNull
    private final Lazy c;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXIAdapter;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface GXIAdapter {
        void init(@NotNull Context context);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXICustomViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface GXICustomViewBindData extends GXIViewBindData {
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$j;", "gxTextData", "", "onTextProcess", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface GXIDataListener {
        @Nullable
        CharSequence onTextProcess(@NotNull C3348j c3348j);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$e;", "gxGesture", "Ltb/wt2;", "onGestureEvent", "Lcom/alibaba/gaiax/GXTemplateEngine$g;", "gxScroll", "onScrollEvent", "Lcom/alibaba/gaiax/GXTemplateEngine$b;", "gxAnimation", "onAnimationEvent", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface GXIEventListener {

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.GXTemplateEngine$GXIEventListener$a */
        /* loaded from: classes6.dex */
        public static final class C3335a {
            public static void a(@NotNull GXIEventListener gXIEventListener, @NotNull C3338b c3338b) {
                b41.i(gXIEventListener, "this");
                b41.i(c3338b, "gxAnimation");
            }

            public static void b(@NotNull GXIEventListener gXIEventListener, @NotNull C3342e c3342e) {
                b41.i(gXIEventListener, "this");
                b41.i(c3342e, "gxGesture");
            }

            public static void c(@NotNull GXIEventListener gXIEventListener, @NotNull C3344g c3344g) {
                b41.i(gXIEventListener, "this");
                b41.i(c3344g, "gxScroll");
            }
        }

        void onAnimationEvent(@NotNull C3338b c3338b);

        void onGestureEvent(@NotNull C3342e c3342e);

        void onScrollEvent(@NotNull C3344g c3344g);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$k;", "gxTrack", "Ltb/wt2;", "onTrackEvent", "onManualClickTrackEvent", "onManualExposureTrackEvent", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface GXITrackListener {

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.GXTemplateEngine$GXITrackListener$a */
        /* loaded from: classes6.dex */
        public static final class C3336a {
            public static void a(@NotNull GXITrackListener gXITrackListener, @NotNull C3349k c3349k) {
                b41.i(gXITrackListener, "this");
                b41.i(c3349k, "gxTrack");
            }

            public static void b(@NotNull GXITrackListener gXITrackListener, @NotNull C3349k c3349k) {
                b41.i(gXITrackListener, "this");
                b41.i(c3349k, "gxTrack");
            }

            public static void c(@NotNull GXITrackListener gXITrackListener, @NotNull C3349k c3349k) {
                b41.i(gXITrackListener, "this");
                b41.i(c3349k, "gxTrack");
            }
        }

        void onManualClickTrackEvent(@NotNull C3349k c3349k);

        void onManualExposureTrackEvent(@NotNull C3349k c3349k);

        void onTrackEvent(@NotNull C3349k c3349k);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$a */
    /* loaded from: classes6.dex */
    public static final class C3337a {
        private C3337a() {
        }

        public /* synthetic */ C3337a(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXTemplateEngine a() {
            return (GXTemplateEngine) GXTemplateEngine.d.getValue();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$b */
    /* loaded from: classes6.dex */
    public static final class C3338b {
        @NotNull
        public static final C3339a Companion = new C3339a(null);
        @NotNull
        public static final String STATE_END = "END";
        @NotNull
        public static final String STATE_START = "START";
        @Nullable
        private String a;
        @Nullable
        private String b;
        @Nullable
        private View c;
        @Nullable
        private JSONObject d;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.GXTemplateEngine$b$a */
        /* loaded from: classes6.dex */
        public static final class C3339a {
            private C3339a() {
            }

            public /* synthetic */ C3339a(k50 k50Var) {
                this();
            }
        }

        @Nullable
        public final JSONObject a() {
            return this.d;
        }

        @Nullable
        public final String b() {
            return this.b;
        }

        @Nullable
        public final String c() {
            return this.a;
        }

        @Nullable
        public final View d() {
            return this.c;
        }

        public final void e(@Nullable JSONObject jSONObject) {
            this.d = jSONObject;
        }

        public final void f(@Nullable JSONObject jSONObject) {
        }

        public final void g(@Nullable String str) {
            this.b = str;
        }

        public final void h(@Nullable String str) {
            this.a = str;
        }

        public final void i(@Nullable View view) {
            this.c = view;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$c */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC3340c {
        @Nullable
        private Integer a;
        @Nullable
        private View b;
        @Nullable
        private String c;

        @Nullable
        public final Integer a() {
            return this.a;
        }

        @Nullable
        public final String b() {
            return this.c;
        }

        @Nullable
        public final View c() {
            return this.b;
        }

        public final void d(@Nullable Integer num) {
            this.a = num;
        }

        public final void e(@Nullable String str) {
            this.c = str;
        }

        public final void f(@Nullable C3347i c3347i) {
        }

        public final void g(@Nullable View view) {
            this.b = view;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$d */
    /* loaded from: classes6.dex */
    public static final class C3341d {
        @Nullable
        private Integer a;
        @Nullable
        private JSONObject b;
        @Nullable
        private os0 c;
        @Nullable
        private qs0 d;

        @Nullable
        public final os0 a() {
            return this.c;
        }

        @Nullable
        public final JSONObject b() {
            return this.b;
        }

        @Nullable
        public final Integer c() {
            return this.a;
        }

        @Nullable
        public final qs0 d() {
            return this.d;
        }

        public final void e(@Nullable os0 os0Var) {
            this.c = os0Var;
        }

        public final void f(@Nullable JSONObject jSONObject) {
            this.b = jSONObject;
        }

        public final void g(@Nullable Integer num) {
            this.a = num;
        }

        public final void h(@Nullable qs0 qs0Var) {
            this.d = qs0Var;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$e */
    /* loaded from: classes6.dex */
    public static class C3342e {
        @Nullable
        private JSONObject eventParams;
        @NotNull
        private String gestureType = EventParams.CLICK_TYPE_TAP;
        @Nullable
        private Integer index;
        @Nullable
        private String nodeId;
        @Nullable
        private C3347i templateItem;
        @Nullable
        private View view;

        @Nullable
        public final JSONObject getEventParams() {
            return this.eventParams;
        }

        @NotNull
        public final String getGestureType() {
            return this.gestureType;
        }

        @Nullable
        public final Integer getIndex() {
            return this.index;
        }

        @Nullable
        public final String getNodeId() {
            return this.nodeId;
        }

        @Nullable
        public final C3347i getTemplateItem() {
            return this.templateItem;
        }

        @Nullable
        public final View getView() {
            return this.view;
        }

        public final void setEventParams(@Nullable JSONObject jSONObject) {
            this.eventParams = jSONObject;
        }

        public final void setGestureType(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.gestureType = str;
        }

        public final void setIndex(@Nullable Integer num) {
            this.index = num;
        }

        public final void setNodeId(@Nullable String str) {
            this.nodeId = str;
        }

        public final void setTemplateItem(@Nullable C3347i c3347i) {
            this.templateItem = c3347i;
        }

        public final void setView(@Nullable View view) {
            this.view = view;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$f */
    /* loaded from: classes6.dex */
    public static final class C3343f {
        @Nullable
        private Float a;
        @Nullable
        private Float b;

        public C3343f(@Nullable Float f, @Nullable Float f2) {
            this.a = f;
            this.b = f2;
        }

        @Nullable
        public final Float a() {
            return this.b;
        }

        @Nullable
        public final Float b() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C3343f) {
                C3343f c3343f = (C3343f) obj;
                return b41.d(this.a, c3343f.a) && b41.d(this.b, c3343f.b);
            }
            return false;
        }

        public int hashCode() {
            Float f = this.a;
            int hashCode = (f == null ? 0 : f.hashCode()) * 31;
            Float f2 = this.b;
            return hashCode + (f2 != null ? f2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "GXMeasureSize(width=" + this.a + ", height=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$g */
    /* loaded from: classes6.dex */
    public static final class C3344g {
        @NotNull
        public static final C3345a Companion = new C3345a(null);
        @NotNull
        public static final String TYPE_ON_SCROLLED = "onScrolled";
        @NotNull
        public static final String TYPE_ON_SCROLL_STATE_CHANGED = "onScrollStateChanged";
        @NotNull
        private String a = "";
        @Nullable
        private View b;
        private int c;
        private int d;
        private int e;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.GXTemplateEngine$g$a */
        /* loaded from: classes6.dex */
        public static final class C3345a {
            private C3345a() {
            }

            public /* synthetic */ C3345a(k50 k50Var) {
                this();
            }
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.d;
        }

        public final int c() {
            return this.e;
        }

        @NotNull
        public final String d() {
            return this.a;
        }

        @Nullable
        public final View e() {
            return this.b;
        }

        public final void f(int i) {
            this.c = i;
        }

        public final void g(int i) {
            this.d = i;
        }

        public final void h(int i) {
            this.e = i;
        }

        public final void i(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.a = str;
        }

        public final void j(@Nullable View view) {
            this.b = view;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$h */
    /* loaded from: classes6.dex */
    public static final class C3346h {
        @NotNull
        private final JSONObject a;
        @Nullable
        private Object b;
        private int c;
        @Nullable
        private GXIDataListener d;
        @Nullable
        private GXIEventListener e;
        @Nullable
        private GXITrackListener f;

        public C3346h(@NotNull JSONObject jSONObject) {
            b41.i(jSONObject, "data");
            this.a = jSONObject;
            this.c = -1;
        }

        @NotNull
        public final JSONObject a() {
            return this.a;
        }

        @Nullable
        public final GXIDataListener b() {
            return this.d;
        }

        @Nullable
        public final GXIEventListener c() {
            return this.e;
        }

        public final int d() {
            return this.c;
        }

        @Nullable
        public final Object e() {
            return this.b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C3346h) && b41.d(this.a, ((C3346h) obj).a);
        }

        @Nullable
        public final GXITrackListener f() {
            return this.f;
        }

        public final void g(@Nullable GXIDataListener gXIDataListener) {
            this.d = gXIDataListener;
        }

        public final void h(@Nullable GXIEventListener gXIEventListener) {
            this.e = gXIEventListener;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public final void i(int i) {
            this.c = i;
        }

        public final void j(@Nullable Object obj) {
            this.b = obj;
        }

        public final void k(@Nullable GXITrackListener gXITrackListener) {
            this.f = gXITrackListener;
        }

        @NotNull
        public String toString() {
            return "GXTemplateData(data=" + this.a + ')';
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$i */
    /* loaded from: classes6.dex */
    public static final class C3347i {
        @NotNull
        private final Context a;
        @NotNull
        private String b;
        @NotNull
        private final String c;
        @NotNull
        private String d;
        @NotNull
        private String e;
        private boolean f;

        public C3347i(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            b41.i(str, hh1.DIMEN_BIZ);
            b41.i(str2, "templateId");
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = "";
            this.e = "";
        }

        @NotNull
        public final String a() {
            return this.b;
        }

        @NotNull
        public final String b() {
            return this.d;
        }

        @NotNull
        public final Context c() {
            return this.a;
        }

        @NotNull
        public final String d() {
            return this.c;
        }

        @NotNull
        public final String e() {
            return this.e;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (b41.d(C3347i.class, obj == null ? null : obj.getClass())) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.GXTemplateEngine.GXTemplateItem");
                C3347i c3347i = (C3347i) obj;
                return b41.d(this.b, c3347i.b) && b41.d(this.c, c3347i.c);
            }
            return false;
        }

        public final boolean f() {
            return this.f;
        }

        public final void g(boolean z) {
            this.f = z;
        }

        public final void h(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.e = str;
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        @NotNull
        public String toString() {
            return "GXTemplateItem(bizId='" + this.b + "', templateId='" + this.c + "')";
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$j */
    /* loaded from: classes6.dex */
    public static final class C3348j extends AbstractC3340c {
        @Nullable
        private CharSequence d;
        @Nullable
        private JSONObject e;

        @Nullable
        public final JSONObject h() {
            return this.e;
        }

        @Nullable
        public final CharSequence i() {
            return this.d;
        }

        public final void j(@Nullable JSONObject jSONObject) {
            this.e = jSONObject;
        }

        public final void k(@Nullable pq0 pq0Var) {
        }

        public final void l(@Nullable JSONObject jSONObject) {
        }

        public final void m(@Nullable CharSequence charSequence) {
            this.d = charSequence;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$k */
    /* loaded from: classes6.dex */
    public static final class C3349k {
        @Nullable
        private View a;
        @Nullable
        private String b;
        @Nullable
        private Integer c;
        @Nullable
        private JSONObject d;

        @Nullable
        public final Integer a() {
            return this.c;
        }

        @Nullable
        public final String b() {
            return this.b;
        }

        @Nullable
        public final JSONObject c() {
            return this.d;
        }

        @Nullable
        public final View d() {
            return this.a;
        }

        public final void e(@Nullable Integer num) {
            this.c = num;
        }

        public final void f(@Nullable String str) {
            this.b = str;
        }

        public final void g(@Nullable C3347i c3347i) {
        }

        public final void h(@Nullable JSONObject jSONObject) {
            this.d = jSONObject;
        }

        public final void i(@Nullable View view) {
            this.a = view;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.GXTemplateEngine$l */
    /* loaded from: classes6.dex */
    public static final class C3350l implements GXIManualExposureEventListener {
        final /* synthetic */ GXIEventListener a;
        final /* synthetic */ os0 b;

        C3350l(GXIEventListener gXIEventListener, os0 os0Var) {
            this.a = gXIEventListener;
            this.b = os0Var;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onAnimationEvent(@NotNull C3338b c3338b) {
            b41.i(c3338b, "gxAnimation");
            GXIEventListener gXIEventListener = this.a;
            if (gXIEventListener == null) {
                return;
            }
            gXIEventListener.onAnimationEvent(c3338b);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onGestureEvent(@NotNull C3342e c3342e) {
            b41.i(c3342e, "gxGesture");
            GXIEventListener gXIEventListener = this.a;
            if (gXIEventListener == null) {
                return;
            }
            gXIEventListener.onGestureEvent(c3342e);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onScrollEvent(@NotNull C3344g c3344g) {
            b41.i(c3344g, "gxScroll");
            GXIEventListener gXIEventListener = this.a;
            if (gXIEventListener != null) {
                gXIEventListener.onScrollEvent(c3344g);
            }
            if (this.b.u() && b41.d(C3344g.TYPE_ON_SCROLL_STATE_CHANGED, c3344g.d()) && c3344g.c() == 0) {
                GXContainerUtils.INSTANCE.e(this.b);
            }
        }
    }

    static {
        Lazy<GXTemplateEngine> b;
        b = C8177b.b(new Function0<GXTemplateEngine>() { // from class: com.alibaba.gaiax.GXTemplateEngine$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXTemplateEngine invoke() {
                return new GXTemplateEngine();
            }
        });
        d = b;
    }

    public GXTemplateEngine() {
        Lazy b;
        Lazy b2;
        b = C8177b.b(new Function0<GXDataImpl>() { // from class: com.alibaba.gaiax.GXTemplateEngine$data$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXDataImpl invoke() {
                return new GXDataImpl(GXTemplateEngine.this.g());
            }
        });
        this.b = b;
        b2 = C8177b.b(new Function0<as0>() { // from class: com.alibaba.gaiax.GXTemplateEngine$render$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final as0 invoke() {
                return new as0();
            }
        });
        this.c = b2;
    }

    private final GXIAdapter n() {
        try {
            Object newInstance = Class.forName("com.alibaba.gaiax.adapter.GXAdapter").newInstance();
            if (newInstance != null) {
                return (GXIAdapter) newInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.alibaba.gaiax.GXTemplateEngine.GXIAdapter");
        } catch (Exception unused) {
            return null;
        }
    }

    private final void o(View view, C3346h c3346h, C3343f c3343f) {
        os0 b = os0.Companion.b(view);
        if (b != null) {
            boolean z = false;
            if (b.z()) {
                kr0 kr0Var = kr0.INSTANCE;
                if (kr0Var.b()) {
                    kr0Var.a("reuse root node, skip bindDataOnlyNodeTree");
                }
                b.K(false);
                return;
            }
            kr0 kr0Var2 = kr0.INSTANCE;
            if (kr0Var2.b()) {
                kr0Var2.a("internalBindDataOnlyNodeTree gxMeasureSize=" + c3343f + " gxTemplateItem=" + b.r());
            }
            b.R(c3346h);
            w(b);
            if (c3343f != null) {
                C3343f n = b.n();
                b.P(c3343f);
                b.J((b41.c(n.b(), c3343f.b()) && b41.c(n.a(), c3343f.a())) ? true : true);
                if (b.y()) {
                    ps0.a(b);
                    x(b);
                }
            }
            l().a(b);
            return;
        }
        throw new IllegalArgumentException("Not found templateContext from targetView");
    }

    private final void p(View view, C3346h c3346h, C3343f c3343f) {
        os0 b = os0.Companion.b(view);
        if (b != null) {
            if (c3343f != null) {
                b.P(c3343f);
            }
            b.R(c3346h);
            l().b(b);
            b.J(false);
            return;
        }
        throw new IllegalArgumentException("Not found templateContext from targetView");
    }

    private final os0 q(C3347i c3347i, C3343f c3343f, C3341d c3341d) {
        os0 a = os0.Companion.a(c3347i, c3343f, h().b(c3347i), c3341d == null ? null : c3341d.d());
        os0 a2 = c3341d != null ? c3341d.a() : null;
        if (a2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(c3341d.c());
            sb.append('-');
            JSONObject b = c3341d.b();
            sb.append(b != null ? b.hashCode() : 0);
            String sb2 = sb.toString();
            if (ps0.h(a2, sb2)) {
                a.L(ps0.i(a2, sb2));
                a.K(true);
                return a;
            }
        }
        l().c(a);
        return a;
    }

    private final View r(os0 os0Var) {
        return l().d(os0Var);
    }

    public static /* synthetic */ void v(GXTemplateEngine gXTemplateEngine, C3347i c3347i, C3343f c3343f, qs0 qs0Var, int i, Object obj) {
        if ((i & 4) != 0) {
            qs0Var = null;
        }
        gXTemplateEngine.u(c3347i, c3343f, qs0Var);
    }

    private final void w(os0 os0Var) {
        C3346h p;
        C3346h p2 = os0Var.p();
        GXIEventListener c = p2 == null ? null : p2.c();
        CopyOnWriteArraySet<GXIContainer> d2 = os0Var.d();
        boolean z = false;
        if (d2 != null && (!d2.isEmpty())) {
            z = true;
        }
        if (!z || (c instanceof GXIManualExposureEventListener) || (p = os0Var.p()) == null) {
            return;
        }
        p.h(new C3350l(c, os0Var));
    }

    private final void x(os0 os0Var) {
        qr0 j = os0Var.j();
        if (j != null) {
            os0Var.C();
            GXGlobalCache.C3417a c3417a = GXGlobalCache.Companion;
            c3417a.a().b();
            ld2<Float> ld2Var = new ld2<>(os0Var.n().b(), os0Var.n().a());
            vr0 vr0Var = vr0.INSTANCE;
            vr0Var.k(j, ld2Var);
            l81 b = j.n().b();
            if (b == null) {
                return;
            }
            c3417a.a().g(os0Var.r(), b);
            vr0Var.a(j, b);
        }
    }

    public final void b(@NotNull View view, @NotNull C3346h c3346h, @Nullable C3343f c3343f) {
        b41.i(view, "view");
        b41.i(c3346h, "gxTemplateData");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("bindDataOnlyNodeTree");
        }
        try {
            zr0 zr0Var = zr0.INSTANCE;
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("GX bindDataOnlyNodeTree");
            }
            o(view, c3346h, c3343f);
            if (!zr0Var.b() || Build.VERSION.SDK_INT < 18) {
                return;
            }
            Trace.endSection();
        } catch (Exception e) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e);
                return;
            }
            throw e;
        }
    }

    public final void c(@NotNull View view, @NotNull C3346h c3346h, @Nullable C3343f c3343f) {
        b41.i(view, "view");
        b41.i(c3346h, "gxTemplateData");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("bindDataOnlyViewTree");
        }
        try {
            zr0 zr0Var = zr0.INSTANCE;
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("GX bindDataOnlyViewTree");
            }
            p(view, c3346h, c3343f);
            if (!zr0Var.b() || Build.VERSION.SDK_INT < 18) {
                return;
            }
            Trace.endSection();
        } catch (Exception e) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e);
                return;
            }
            throw e;
        }
    }

    public final void d() {
        GXGlobalCache.Companion.a().b();
        GXTemplateInfoSource.Companion.a().b();
    }

    @Nullable
    public final os0 e(@NotNull C3347i c3347i, @NotNull C3343f c3343f, @Nullable C3341d c3341d) {
        b41.i(c3347i, "gxTemplateItem");
        b41.i(c3343f, "gxMeasureSize");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("createViewOnlyNodeTree");
        }
        try {
            zr0 zr0Var = zr0.INSTANCE;
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("GX createViewOnlyNodeTree");
            }
            os0 q = q(c3347i, c3343f, c3341d);
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.endSection();
            }
            return q;
        } catch (Exception e) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e);
                return null;
            }
            throw e;
        }
    }

    @Nullable
    public final View f(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("createViewOnlyViewTree");
        }
        try {
            zr0 zr0Var = zr0.INSTANCE;
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("GX createViewOnlyViewTree");
            }
            View r = r(os0Var);
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.endSection();
            }
            return r;
        } catch (Exception e) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e);
                return null;
            }
            throw e;
        }
    }

    @NotNull
    public final Context g() {
        Context context = this.a;
        if (context != null) {
            return context;
        }
        b41.A(WPKFactory.INIT_KEY_CONTEXT);
        return null;
    }

    @NotNull
    public final GXDataImpl h() {
        return (GXDataImpl) this.b.getValue();
    }

    @Nullable
    public final qr0 i(@Nullable View view, @NotNull String str) {
        qr0 j;
        b41.i(str, "id");
        os0 b = os0.Companion.b(view);
        if (b == null || (j = b.j()) == null) {
            return null;
        }
        return sr0.c(j, str);
    }

    @Nullable
    public final os0 j(@Nullable View view) {
        if (view == null) {
            return null;
        }
        return os0.Companion.b(view);
    }

    @Nullable
    public final View k(@Nullable View view, @NotNull String str) {
        qr0 j;
        b41.i(str, "id");
        os0 b = os0.Companion.b(view);
        if (b == null || (j = b.j()) == null) {
            return null;
        }
        return sr0.d(j, str);
    }

    @NotNull
    public final as0 l() {
        return (as0) this.c.getValue();
    }

    @NotNull
    public final GXTemplateEngine m(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Context applicationContext = context.getApplicationContext();
        b41.h(applicationContext, "context.applicationContext");
        z(applicationContext);
        GXStyleConvert a = GXStyleConvert.Companion.a();
        AssetManager assets = context.getAssets();
        b41.h(assets, "context.assets");
        a.x(assets);
        GXRegisterCenter.Companion.a().y(new zq0()).F(GXTemplateInfoSource.Companion.a(), 0).G(new bq0(g()), 0).G(new cq0(g()), 1);
        GXIAdapter n = n();
        if (n != null) {
            n.init(context);
        }
        return this;
    }

    public final void s(@NotNull View view) {
        b41.i(view, "targetView");
        if (view instanceof GXIViewVisibleChange) {
            ((GXIViewVisibleChange) view).onVisibleChanged(true);
        }
        os0 b = os0.Companion.b(view);
        if (b == null) {
            return;
        }
        b.D(true);
        b.A();
        GXContainerUtils.INSTANCE.e(b);
    }

    public final void t(@NotNull View view) {
        b41.i(view, "targetView");
        if (view instanceof GXIViewVisibleChange) {
            ((GXIViewVisibleChange) view).onVisibleChanged(false);
        }
        os0 b = os0.Companion.b(view);
        if (b == null) {
            return;
        }
        b.D(false);
        GXContainerUtils.INSTANCE.f(b);
    }

    public final void u(@NotNull C3347i c3347i, @NotNull C3343f c3343f, @Nullable qs0 qs0Var) {
        b41.i(c3347i, "gxTemplateItem");
        b41.i(c3343f, "gxMeasureSize");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("prepareView");
        }
        try {
            if (GXGlobalCache.Companion.a().e(c3347i)) {
                return;
            }
            zr0 zr0Var = zr0.INSTANCE;
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("GX prepareView");
            }
            l().e(os0.Companion.a(c3347i, c3343f, h().b(c3347i), qs0Var));
            if (!zr0Var.b() || Build.VERSION.SDK_INT < 18) {
                return;
            }
            Trace.endSection();
        } catch (Exception e) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e);
                return;
            }
            throw e;
        }
    }

    public final void y(@NotNull View view) {
        b41.i(view, "gxView");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("resetView");
        }
        try {
            os0 b = os0.Companion.b(view);
            if (b == null) {
                return;
            }
            l().f(b);
        } catch (Exception e) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e);
                return;
            }
            throw e;
        }
    }

    public final void z(@NotNull Context context) {
        b41.i(context, "<set-?>");
        this.a = context;
    }
}
