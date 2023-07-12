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
    public static final a Companion = new a(null);
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
        CharSequence onTextProcess(@NotNull j jVar);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$e;", "gxGesture", "Ltb/wt2;", "onGestureEvent", "Lcom/alibaba/gaiax/GXTemplateEngine$g;", "gxScroll", "onScrollEvent", "Lcom/alibaba/gaiax/GXTemplateEngine$b;", "gxAnimation", "onAnimationEvent", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface GXIEventListener {

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class a {
            public static void a(@NotNull GXIEventListener gXIEventListener, @NotNull b bVar) {
                b41.i(gXIEventListener, "this");
                b41.i(bVar, "gxAnimation");
            }

            public static void b(@NotNull GXIEventListener gXIEventListener, @NotNull e eVar) {
                b41.i(gXIEventListener, "this");
                b41.i(eVar, "gxGesture");
            }

            public static void c(@NotNull GXIEventListener gXIEventListener, @NotNull g gVar) {
                b41.i(gXIEventListener, "this");
                b41.i(gVar, "gxScroll");
            }
        }

        void onAnimationEvent(@NotNull b bVar);

        void onGestureEvent(@NotNull e eVar);

        void onScrollEvent(@NotNull g gVar);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$k;", "gxTrack", "Ltb/wt2;", "onTrackEvent", "onManualClickTrackEvent", "onManualExposureTrackEvent", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface GXITrackListener {

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class a {
            public static void a(@NotNull GXITrackListener gXITrackListener, @NotNull k kVar) {
                b41.i(gXITrackListener, "this");
                b41.i(kVar, "gxTrack");
            }

            public static void b(@NotNull GXITrackListener gXITrackListener, @NotNull k kVar) {
                b41.i(gXITrackListener, "this");
                b41.i(kVar, "gxTrack");
            }

            public static void c(@NotNull GXITrackListener gXITrackListener, @NotNull k kVar) {
                b41.i(gXITrackListener, "this");
                b41.i(kVar, "gxTrack");
            }
        }

        void onManualClickTrackEvent(@NotNull k kVar);

        void onManualExposureTrackEvent(@NotNull k kVar);

        void onTrackEvent(@NotNull k kVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXTemplateEngine a() {
            return (GXTemplateEngine) GXTemplateEngine.d.getValue();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class b {
        @NotNull
        public static final a Companion = new a(null);
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
        /* loaded from: classes6.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(k50 k50Var) {
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
    /* loaded from: classes6.dex */
    public static abstract class c {
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

        public final void f(@Nullable i iVar) {
        }

        public final void g(@Nullable View view) {
            this.b = view;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class d {
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
    /* loaded from: classes6.dex */
    public static class e {
        @Nullable
        private JSONObject eventParams;
        @NotNull
        private String gestureType = EventParams.CLICK_TYPE_TAP;
        @Nullable
        private Integer index;
        @Nullable
        private String nodeId;
        @Nullable
        private i templateItem;
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
        public final i getTemplateItem() {
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

        public final void setTemplateItem(@Nullable i iVar) {
            this.templateItem = iVar;
        }

        public final void setView(@Nullable View view) {
            this.view = view;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class f {
        @Nullable
        private Float a;
        @Nullable
        private Float b;

        public f(@Nullable Float f, @Nullable Float f2) {
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
            if (obj instanceof f) {
                f fVar = (f) obj;
                return b41.d(this.a, fVar.a) && b41.d(this.b, fVar.b);
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
    /* loaded from: classes6.dex */
    public static final class g {
        @NotNull
        public static final a Companion = new a(null);
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
        /* loaded from: classes6.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(k50 k50Var) {
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
    /* loaded from: classes6.dex */
    public static final class h {
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

        public h(@NotNull JSONObject jSONObject) {
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
            return (obj instanceof h) && b41.d(this.a, ((h) obj).a);
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
    /* loaded from: classes6.dex */
    public static final class i {
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

        public i(@NotNull Context context, @NotNull String str, @NotNull String str2) {
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
            if (b41.d(i.class, obj == null ? null : obj.getClass())) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.GXTemplateEngine.GXTemplateItem");
                i iVar = (i) obj;
                return b41.d(this.b, iVar.b) && b41.d(this.c, iVar.c);
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
    /* loaded from: classes6.dex */
    public static final class j extends c {
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
    /* loaded from: classes6.dex */
    public static final class k {
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

        public final void g(@Nullable i iVar) {
        }

        public final void h(@Nullable JSONObject jSONObject) {
            this.d = jSONObject;
        }

        public final void i(@Nullable View view) {
            this.a = view;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class l implements GXIManualExposureEventListener {
        final /* synthetic */ GXIEventListener a;
        final /* synthetic */ os0 b;

        l(GXIEventListener gXIEventListener, os0 os0Var) {
            this.a = gXIEventListener;
            this.b = os0Var;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onAnimationEvent(@NotNull b bVar) {
            b41.i(bVar, "gxAnimation");
            GXIEventListener gXIEventListener = this.a;
            if (gXIEventListener == null) {
                return;
            }
            gXIEventListener.onAnimationEvent(bVar);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onGestureEvent(@NotNull e eVar) {
            b41.i(eVar, "gxGesture");
            GXIEventListener gXIEventListener = this.a;
            if (gXIEventListener == null) {
                return;
            }
            gXIEventListener.onGestureEvent(eVar);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onScrollEvent(@NotNull g gVar) {
            b41.i(gVar, "gxScroll");
            GXIEventListener gXIEventListener = this.a;
            if (gXIEventListener != null) {
                gXIEventListener.onScrollEvent(gVar);
            }
            if (this.b.u() && b41.d(g.TYPE_ON_SCROLL_STATE_CHANGED, gVar.d()) && gVar.c() == 0) {
                GXContainerUtils.INSTANCE.e(this.b);
            }
        }
    }

    static {
        Lazy<GXTemplateEngine> b2;
        b2 = kotlin.b.b(new Function0<GXTemplateEngine>() { // from class: com.alibaba.gaiax.GXTemplateEngine$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXTemplateEngine invoke() {
                return new GXTemplateEngine();
            }
        });
        d = b2;
    }

    public GXTemplateEngine() {
        Lazy b2;
        Lazy b3;
        b2 = kotlin.b.b(new Function0<GXDataImpl>() { // from class: com.alibaba.gaiax.GXTemplateEngine$data$2
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
        this.b = b2;
        b3 = kotlin.b.b(new Function0<as0>() { // from class: com.alibaba.gaiax.GXTemplateEngine$render$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final as0 invoke() {
                return new as0();
            }
        });
        this.c = b3;
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

    private final void o(View view, h hVar, f fVar) {
        os0 b2 = os0.Companion.b(view);
        if (b2 != null) {
            boolean z = false;
            if (b2.z()) {
                kr0 kr0Var = kr0.INSTANCE;
                if (kr0Var.b()) {
                    kr0Var.a("reuse root node, skip bindDataOnlyNodeTree");
                }
                b2.K(false);
                return;
            }
            kr0 kr0Var2 = kr0.INSTANCE;
            if (kr0Var2.b()) {
                kr0Var2.a("internalBindDataOnlyNodeTree gxMeasureSize=" + fVar + " gxTemplateItem=" + b2.r());
            }
            b2.R(hVar);
            w(b2);
            if (fVar != null) {
                f n = b2.n();
                b2.P(fVar);
                b2.J((b41.c(n.b(), fVar.b()) && b41.c(n.a(), fVar.a())) ? true : true);
                if (b2.y()) {
                    ps0.a(b2);
                    x(b2);
                }
            }
            l().a(b2);
            return;
        }
        throw new IllegalArgumentException("Not found templateContext from targetView");
    }

    private final void p(View view, h hVar, f fVar) {
        os0 b2 = os0.Companion.b(view);
        if (b2 != null) {
            if (fVar != null) {
                b2.P(fVar);
            }
            b2.R(hVar);
            l().b(b2);
            b2.J(false);
            return;
        }
        throw new IllegalArgumentException("Not found templateContext from targetView");
    }

    private final os0 q(i iVar, f fVar, d dVar) {
        os0 a2 = os0.Companion.a(iVar, fVar, h().b(iVar), dVar == null ? null : dVar.d());
        os0 a3 = dVar != null ? dVar.a() : null;
        if (a3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(dVar.c());
            sb.append('-');
            JSONObject b2 = dVar.b();
            sb.append(b2 != null ? b2.hashCode() : 0);
            String sb2 = sb.toString();
            if (ps0.h(a3, sb2)) {
                a2.L(ps0.i(a3, sb2));
                a2.K(true);
                return a2;
            }
        }
        l().c(a2);
        return a2;
    }

    private final View r(os0 os0Var) {
        return l().d(os0Var);
    }

    public static /* synthetic */ void v(GXTemplateEngine gXTemplateEngine, i iVar, f fVar, qs0 qs0Var, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            qs0Var = null;
        }
        gXTemplateEngine.u(iVar, fVar, qs0Var);
    }

    private final void w(os0 os0Var) {
        h p;
        h p2 = os0Var.p();
        GXIEventListener c2 = p2 == null ? null : p2.c();
        CopyOnWriteArraySet<GXIContainer> d2 = os0Var.d();
        boolean z = false;
        if (d2 != null && (!d2.isEmpty())) {
            z = true;
        }
        if (!z || (c2 instanceof GXIManualExposureEventListener) || (p = os0Var.p()) == null) {
            return;
        }
        p.h(new l(c2, os0Var));
    }

    private final void x(os0 os0Var) {
        qr0 j2 = os0Var.j();
        if (j2 != null) {
            os0Var.C();
            GXGlobalCache.a aVar = GXGlobalCache.Companion;
            aVar.a().b();
            ld2<Float> ld2Var = new ld2<>(os0Var.n().b(), os0Var.n().a());
            vr0 vr0Var = vr0.INSTANCE;
            vr0Var.k(j2, ld2Var);
            l81 b2 = j2.n().b();
            if (b2 == null) {
                return;
            }
            aVar.a().g(os0Var.r(), b2);
            vr0Var.a(j2, b2);
        }
    }

    public final void b(@NotNull View view, @NotNull h hVar, @Nullable f fVar) {
        b41.i(view, "view");
        b41.i(hVar, "gxTemplateData");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("bindDataOnlyNodeTree");
        }
        try {
            zr0 zr0Var = zr0.INSTANCE;
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("GX bindDataOnlyNodeTree");
            }
            o(view, hVar, fVar);
            if (!zr0Var.b() || Build.VERSION.SDK_INT < 18) {
                return;
            }
            Trace.endSection();
        } catch (Exception e2) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e2);
                return;
            }
            throw e2;
        }
    }

    public final void c(@NotNull View view, @NotNull h hVar, @Nullable f fVar) {
        b41.i(view, "view");
        b41.i(hVar, "gxTemplateData");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("bindDataOnlyViewTree");
        }
        try {
            zr0 zr0Var = zr0.INSTANCE;
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("GX bindDataOnlyViewTree");
            }
            p(view, hVar, fVar);
            if (!zr0Var.b() || Build.VERSION.SDK_INT < 18) {
                return;
            }
            Trace.endSection();
        } catch (Exception e2) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e2);
                return;
            }
            throw e2;
        }
    }

    public final void d() {
        GXGlobalCache.Companion.a().b();
        GXTemplateInfoSource.Companion.a().b();
    }

    @Nullable
    public final os0 e(@NotNull i iVar, @NotNull f fVar, @Nullable d dVar) {
        b41.i(iVar, "gxTemplateItem");
        b41.i(fVar, "gxMeasureSize");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("createViewOnlyNodeTree");
        }
        try {
            zr0 zr0Var = zr0.INSTANCE;
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("GX createViewOnlyNodeTree");
            }
            os0 q = q(iVar, fVar, dVar);
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.endSection();
            }
            return q;
        } catch (Exception e2) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e2);
                return null;
            }
            throw e2;
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
        } catch (Exception e2) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e2);
                return null;
            }
            throw e2;
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
        qr0 j2;
        b41.i(str, "id");
        os0 b2 = os0.Companion.b(view);
        if (b2 == null || (j2 = b2.j()) == null) {
            return null;
        }
        return sr0.c(j2, str);
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
        qr0 j2;
        b41.i(str, "id");
        os0 b2 = os0.Companion.b(view);
        if (b2 == null || (j2 = b2.j()) == null) {
            return null;
        }
        return sr0.d(j2, str);
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
        GXStyleConvert a2 = GXStyleConvert.Companion.a();
        AssetManager assets = context.getAssets();
        b41.h(assets, "context.assets");
        a2.x(assets);
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
        os0 b2 = os0.Companion.b(view);
        if (b2 == null) {
            return;
        }
        b2.D(true);
        b2.A();
        GXContainerUtils.INSTANCE.e(b2);
    }

    public final void t(@NotNull View view) {
        b41.i(view, "targetView");
        if (view instanceof GXIViewVisibleChange) {
            ((GXIViewVisibleChange) view).onVisibleChanged(false);
        }
        os0 b2 = os0.Companion.b(view);
        if (b2 == null) {
            return;
        }
        b2.D(false);
        GXContainerUtils.INSTANCE.f(b2);
    }

    public final void u(@NotNull i iVar, @NotNull f fVar, @Nullable qs0 qs0Var) {
        b41.i(iVar, "gxTemplateItem");
        b41.i(fVar, "gxMeasureSize");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("prepareView");
        }
        try {
            if (GXGlobalCache.Companion.a().e(iVar)) {
                return;
            }
            zr0 zr0Var = zr0.INSTANCE;
            if (zr0Var.b() && Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection("GX prepareView");
            }
            l().e(os0.Companion.a(iVar, fVar, h().b(iVar), qs0Var));
            if (!zr0Var.b() || Build.VERSION.SDK_INT < 18) {
                return;
            }
            Trace.endSection();
        } catch (Exception e2) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e2);
                return;
            }
            throw e2;
        }
    }

    public final void y(@NotNull View view) {
        b41.i(view, "gxView");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("resetView");
        }
        try {
            os0 b2 = os0.Companion.b(view);
            if (b2 == null) {
                return;
            }
            l().f(b2);
        } catch (Exception e2) {
            wq0 wq0Var = wq0.INSTANCE;
            if (wq0Var.b()) {
                wq0Var.a(e2);
                return;
            }
            throw e2;
        }
    }

    public final void z(@NotNull Context context) {
        b41.i(context, "<set-?>");
        this.a = context;
    }
}
