package com.alibaba.pictures.ut;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.ut.ExposureDog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.UTTracker;
import com.ut.mini.exposure.TrackerFrameLayout;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.youku.live.dago.liveplayback.widget.Constants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.qv2;
import tb.ss2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ExposureDog {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private Boolean c = Boolean.FALSE;
    private String d;
    private String e;
    private String f;
    private String g;
    private final Lazy h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final Handler m;
    private final View n;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class ExpGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private Runnable a;
        @NotNull
        private View$OnAttachStateChangeListenerC3648a b;
        @NotNull
        private View c;

        public ExpGlobalLayoutListener(@NotNull View$OnAttachStateChangeListenerC3648a view$OnAttachStateChangeListenerC3648a, @NotNull View view) {
            b41.i(view$OnAttachStateChangeListenerC3648a, "attachListener");
            b41.i(view, "view");
            this.b = view$OnAttachStateChangeListenerC3648a;
            this.c = view;
        }

        @NotNull
        public final View$OnAttachStateChangeListenerC3648a a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "214107030") ? (View$OnAttachStateChangeListenerC3648a) ipChange.ipc$dispatch("214107030", new Object[]{this}) : this.b;
        }

        @Nullable
        public final Runnable b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-983512390") ? (Runnable) ipChange.ipc$dispatch("-983512390", new Object[]{this}) : this.a;
        }

        @NotNull
        public final View c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1815061820") ? (View) ipChange.ipc$dispatch("1815061820", new Object[]{this}) : this.c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1759818441")) {
                ipChange.ipc$dispatch("1759818441", new Object[]{this});
            } else if (this.b.a() > 0) {
                this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Runnable runnable = this.a;
                if (runnable != null) {
                    this.c.removeCallbacks(runnable);
                }
            } else if (DogCat.INSTANCE.u(this.c)) {
                this.b.b(SystemClock.elapsedRealtime());
                this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Runnable runnable2 = this.a;
                if (runnable2 != null) {
                    this.c.removeCallbacks(runnable2);
                }
            } else {
                Runnable runnable3 = this.a;
                if (runnable3 != null) {
                    this.c.removeCallbacks(runnable3);
                } else {
                    this.a = new Runnable() { // from class: com.alibaba.pictures.ut.ExposureDog$ExpGlobalLayoutListener$onGlobalLayout$1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public final void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1455625637")) {
                                ipChange2.ipc$dispatch("1455625637", new Object[]{this});
                                return;
                            }
                            if (ExposureDog.ExpGlobalLayoutListener.this.a().a() == 0 && DogCat.INSTANCE.u(ExposureDog.ExpGlobalLayoutListener.this.c())) {
                                ViewTreeObserver viewTreeObserver = ExposureDog.ExpGlobalLayoutListener.this.c().getViewTreeObserver();
                                b41.h(viewTreeObserver, "view.viewTreeObserver");
                                if (viewTreeObserver.isAlive()) {
                                    ExposureDog.ExpGlobalLayoutListener.this.a().b(SystemClock.elapsedRealtime());
                                    ExposureDog.ExpGlobalLayoutListener.this.c().getViewTreeObserver().removeOnGlobalLayoutListener(ExposureDog.ExpGlobalLayoutListener.this);
                                    ExposureDog.ExpGlobalLayoutListener.this.c().removeCallbacks(ExposureDog.ExpGlobalLayoutListener.this.b());
                                    return;
                                }
                            }
                            ExposureDog.ExpGlobalLayoutListener.this.c().postDelayed(ExposureDog.ExpGlobalLayoutListener.this.b(), 500L);
                        }
                    };
                }
                this.c.postDelayed(this.a, 500L);
            }
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/alibaba/pictures/ut/ExposureDog$ExposureObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Ljava/lang/Runnable;", "Ltb/wt2;", "onResume", "onDestroy", "run", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "Landroidx/fragment/app/FragmentActivity;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "Lcom/alibaba/pictures/ut/ExposureDog;", "exposureDog", "Lcom/alibaba/pictures/ut/ExposureDog;", "getExposureDog", "()Lcom/alibaba/pictures/ut/ExposureDog;", "setExposureDog", "(Lcom/alibaba/pictures/ut/ExposureDog;)V", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/alibaba/pictures/ut/ExposureDog;)V", "ut_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public static final class ExposureObserver implements LifecycleObserver, Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private FragmentActivity activity;
        @Nullable
        private ExposureDog exposureDog;
        @Nullable
        private Handler handler = new Handler(Looper.getMainLooper());

        public ExposureObserver(@Nullable FragmentActivity fragmentActivity, @Nullable ExposureDog exposureDog) {
            this.activity = fragmentActivity;
            this.exposureDog = exposureDog;
        }

        @Nullable
        public final FragmentActivity getActivity() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1808389486") ? (FragmentActivity) ipChange.ipc$dispatch("-1808389486", new Object[]{this}) : this.activity;
        }

        @Nullable
        public final ExposureDog getExposureDog() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1973248980") ? (ExposureDog) ipChange.ipc$dispatch("-1973248980", new Object[]{this}) : this.exposureDog;
        }

        @Nullable
        public final Handler getHandler() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1047556546") ? (Handler) ipChange.ipc$dispatch("1047556546", new Object[]{this}) : this.handler;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            Lifecycle lifecycle;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-772343433")) {
                ipChange.ipc$dispatch("-772343433", new Object[]{this});
                return;
            }
            FragmentActivity fragmentActivity = this.activity;
            if (fragmentActivity != null && (lifecycle = fragmentActivity.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            this.activity = null;
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.handler = null;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1614047124")) {
                ipChange.ipc$dispatch("-1614047124", new Object[]{this});
                return;
            }
            Handler handler = this.handler;
            if (handler != null) {
                handler.postDelayed(this, 400L);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-792663097")) {
                ipChange.ipc$dispatch("-792663097", new Object[]{this});
                return;
            }
            ExposureDog exposureDog = this.exposureDog;
            if (exposureDog != null) {
                exposureDog.l();
            }
            onDestroy();
        }

        public final void setActivity(@Nullable FragmentActivity fragmentActivity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-308334486")) {
                ipChange.ipc$dispatch("-308334486", new Object[]{this, fragmentActivity});
            } else {
                this.activity = fragmentActivity;
            }
        }

        public final void setExposureDog(@Nullable ExposureDog exposureDog) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-180571170")) {
                ipChange.ipc$dispatch("-180571170", new Object[]{this, exposureDog});
            } else {
                this.exposureDog = exposureDog;
            }
        }

        public final void setHandler(@Nullable Handler handler) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1759173568")) {
                ipChange.ipc$dispatch("1759173568", new Object[]{this, handler});
            } else {
                this.handler = handler;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.ut.ExposureDog$a */
    /* loaded from: classes8.dex */
    public static final class View$OnAttachStateChangeListenerC3648a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private Map<String, String> a;
        @NotNull
        private JSONArray b;
        private long c;
        @Nullable
        private ViewTreeObserver.OnGlobalLayoutListener d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @NotNull
        private String g;
        @Nullable
        private Map<String, String> h;

        public View$OnAttachStateChangeListenerC3648a(@NotNull View view, @Nullable String str, @Nullable String str2, @NotNull String str3, @Nullable Map<String, String> map) {
            b41.i(view, "view");
            b41.i(str3, "block");
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = map;
            this.a = new HashMap();
            this.b = new JSONArray();
            if (view.getWindowId() != null) {
                if (DogCat.INSTANCE.u(view)) {
                    this.c = SystemClock.elapsedRealtime();
                }
                this.d = new ExpGlobalLayoutListener(this, view);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
            }
        }

        public final long a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1989735510") ? ((Long) ipChange.ipc$dispatch("1989735510", new Object[]{this})).longValue() : this.c;
        }

        public final void b(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1831925330")) {
                ipChange.ipc$dispatch("-1831925330", new Object[]{this, Long.valueOf(j)});
            } else {
                this.c = j;
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1558798919")) {
                ipChange.ipc$dispatch("1558798919", new Object[]{this, view});
                return;
            }
            b41.i(view, "v");
            if (this.c != 0) {
                return;
            }
            if (DogCat.INSTANCE.u(view)) {
                this.c = SystemClock.elapsedRealtime();
            } else if (this.d == null) {
                this.d = new ExpGlobalLayoutListener(this, view);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-814321404")) {
                ipChange.ipc$dispatch("-814321404", new Object[]{this, view});
                return;
            }
            b41.i(view, "v");
            this.c = this.c > 0 ? SystemClock.elapsedRealtime() - this.c : 0L;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) Constants.ACTION_PARAMS_AREA, (String) Double.valueOf(1.0d));
            jSONObject.put((JSONObject) "duration", (String) Long.valueOf(this.c));
            jSONObject.put((JSONObject) "exargs", (String) this.h);
            String str = this.f;
            if (str == null) {
                str = DogCat.INSTANCE.r(view);
            }
            if (str == null) {
                str = DogCat.INSTANCE.f();
            }
            DogCat dogCat = DogCat.INSTANCE;
            String a = dogCat.a(str, null);
            String B = dogCat.B(a);
            if (B == null) {
                B = dogCat.m(view);
            }
            if (!(a == null || a.length() == 0)) {
                jSONObject.put((JSONObject) "spm", a);
            }
            jSONObject.put((JSONObject) "viewid", B);
            this.b.add(jSONObject);
            Map<String, String> map = this.a;
            String jSONString = this.b.toJSONString();
            b41.h(jSONString, "js.toJSONString()");
            map.put("expdata", jSONString);
            String str2 = this.e;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (z) {
                UTPageHitHelper uTPageHitHelper = UTPageHitHelper.getInstance();
                b41.h(uTPageHitHelper, "UTPageHitHelper.getInstance()");
                this.e = uTPageHitHelper.getCurrentPageName();
            }
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(this.e, 2201, this.g, null, null, this.a);
            UTAnalytics uTAnalytics = UTAnalytics.getInstance();
            b41.h(uTAnalytics, "UTAnalytics.getInstance()");
            uTAnalytics.getDefaultTracker().send(uTOriginalCustomHitBuilder.build());
            try {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.d);
                view.removeOnAttachStateChangeListener(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.ut.ExposureDog$b */
    /* loaded from: classes8.dex */
    public static final class ViewTreeObserver$OnGlobalLayoutListenerC3649b implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean a;
        private long b;

        ViewTreeObserver$OnGlobalLayoutListenerC3649b() {
            this.a = ExposureDog.this.n.getVisibility() == 0;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1169347549")) {
                ipChange.ipc$dispatch("1169347549", new Object[]{this});
                return;
            }
            if (!this.a) {
                this.a = ExposureDog.this.n.getVisibility() == 0;
                this.b = SystemClock.elapsedRealtime();
            }
            if (!this.a || ExposureDog.this.n.getVisibility() == 0 || SystemClock.elapsedRealtime() - this.b < 500) {
                return;
            }
            ExposureDog.this.n.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            UTAnalytics uTAnalytics = UTAnalytics.getInstance();
            b41.h(uTAnalytics, "UTAnalytics.getInstance()");
            uTAnalytics.getDefaultTracker().commitExposureData();
        }
    }

    public ExposureDog(@Nullable View view) {
        Lazy b;
        this.n = view;
        b = C8177b.b(new Function0<HashMap<String, String>>() { // from class: com.alibaba.pictures.ut.ExposureDog$params$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "863780026") ? (HashMap) ipChange.ipc$dispatch("863780026", new Object[]{this}) : new HashMap<>();
            }
        });
        this.h = b;
        this.m = new Handler(Looper.getMainLooper());
    }

    private final void m() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1796384296")) {
            ipChange.ipc$dispatch("-1796384296", new Object[]{this});
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) Constants.ACTION_PARAMS_AREA, (String) Double.valueOf(1.0d));
        jSONObject.put((JSONObject) "duration", (String) 0);
        jSONObject.put((JSONObject) "exargs", (String) p());
        t(this.n, this.e, null);
        String str = this.f;
        if (!(str == null || str.length() == 0)) {
            jSONObject.put((JSONObject) "spm", this.f);
        }
        jSONObject.put((JSONObject) "viewid", this.b);
        jSONArray.add(jSONObject);
        HashMap hashMap = new HashMap();
        String jSONString = jSONArray.toJSONString();
        b41.h(jSONString, "js.toJSONString()");
        hashMap.put("expdata", jSONString);
        String str2 = this.d;
        if (str2 == null || str2.length() == 0) {
            UTPageHitHelper uTPageHitHelper = UTPageHitHelper.getInstance();
            b41.h(uTPageHitHelper, "UTPageHitHelper.getInstance()");
            this.d = uTPageHitHelper.getCurrentPageName();
        }
        String str3 = this.d;
        if (str3 != null && str3.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(this.d, 2201, this.a, null, null, hashMap);
        UTAnalytics uTAnalytics = UTAnalytics.getInstance();
        b41.h(uTAnalytics, "UTAnalytics.getInstance()");
        uTAnalytics.getDefaultTracker().send(uTOriginalCustomHitBuilder.build());
    }

    private final void n(View view, String str, String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925154073")) {
            ipChange.ipc$dispatch("1925154073", new Object[]{this, view, str, str2, str3, map});
        } else if (str3 != null) {
            view.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC3648a(view, str, str2, str3, map));
        } else {
            qv2.c("exposureWindow-error,block==null");
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(FragmentActivity fragmentActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422428782")) {
            ipChange.ipc$dispatch("1422428782", new Object[]{this, fragmentActivity});
        } else if (fragmentActivity == null) {
        } else {
            try {
                ViewGroup viewGroup = (ViewGroup) fragmentActivity.findViewById(16908290);
                if (viewGroup == null || viewGroup.getChildCount() <= 0) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                if (childAt instanceof TrackerFrameLayout) {
                    Method declaredMethod = ((TrackerFrameLayout) childAt).getClass().getDeclaredMethod(AgooConstants.MESSAGE_TRACE, Integer.TYPE, Boolean.TYPE);
                    b41.h(declaredMethod, "root.javaClass.getDeclar…:class.javaPrimitiveType)");
                    if (declaredMethod != null) {
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(childAt, 0, Boolean.TRUE);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> p() {
        IpChange ipChange = $ipChange;
        return (Map) (AndroidInstantRuntime.support(ipChange, "-1543852504") ? ipChange.ipc$dispatch("-1543852504", new Object[]{this}) : this.h.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(View view, String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-941948411")) {
            ipChange.ipc$dispatch("-941948411", new Object[]{this, view, str, str2});
            return;
        }
        if ((str == null || str.length() == 0) && this.i) {
            str = this.a + '.' + this.b;
        }
        DogCat dogCat = DogCat.INSTANCE;
        String a = dogCat.a(str, str2);
        if (a == null) {
            a = dogCat.f();
        }
        this.f = a;
        String str3 = this.b;
        if (((str3 == null || str3.length() == 0) ? true : true) || (!b41.d(this.c, Boolean.TRUE))) {
            StringBuilder sb = new StringBuilder();
            String str4 = this.f;
            if (str4 == null) {
                str4 = "view";
            }
            sb.append(str4);
            sb.append(JSMethod.NOT_SET);
            sb.append(dogCat.m(view));
            this.b = sb.toString();
        }
    }

    private final void u(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "889229445")) {
            ipChange.ipc$dispatch("889229445", new Object[]{this, runnable});
            return;
        }
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        b41.h(mainLooper, "Looper.getMainLooper()");
        if (currentThread == mainLooper.getThread()) {
            runnable.run();
        } else {
            this.m.post(runnable);
        }
    }

    private final void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508159462")) {
            ipChange.ipc$dispatch("-1508159462", new Object[]{this});
            return;
        }
        View view = this.n;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC3649b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String y(View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-73986931")) {
            return (String) ipChange.ipc$dispatch("-73986931", new Object[]{this, view});
        }
        String str = this.g;
        String q = str == null || str.length() == 0 ? DogCat.INSTANCE.q(this.d) : this.g;
        this.g = q;
        if (q != null && q.length() != 0) {
            z = false;
        }
        if (z) {
            String str2 = null;
            for (int i = 0; str2 == null && view != null && i <= 100; i++) {
                Object tag = view.getTag(ss2.b());
                if (!(tag instanceof String)) {
                    tag = null;
                }
                str2 = (String) tag;
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    parent = null;
                }
                view = (View) parent;
            }
            this.g = str2;
        }
        return this.g;
    }

    @NotNull
    public final ExposureDog j(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1105378751")) {
            return (ExposureDog) ipChange.ipc$dispatch("1105378751", new Object[]{this, str});
        }
        this.a = str;
        return this;
    }

    public final void k() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-722982556")) {
            ipChange.ipc$dispatch("-722982556", new Object[]{this});
            return;
        }
        String str = this.d;
        if (!(str == null || str.length() == 0)) {
            this.d = DogCat.INSTANCE.j(this.d);
        }
        String str2 = this.a;
        if (str2 == null || str2.length() == 0) {
            this.a = DogCat.INSTANCE.l(this.d, this.e);
        }
        if (this.n == null) {
            m();
            return;
        }
        if (this.l) {
            v();
        }
        if (this.k) {
            String str3 = this.a;
            if (!((str3 == null || str3.length() == 0) ? true : true)) {
                try {
                    UTAnalytics uTAnalytics = UTAnalytics.getInstance();
                    b41.h(uTAnalytics, "UTAnalytics.getInstance()");
                    uTAnalytics.getDefaultTracker().setCommitImmediatelyExposureBlock(this.a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.j) {
            n(this.n, this.d, this.e, this.a, p());
        } else {
            l();
        }
    }

    public final void l() {
        List t0;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1622017516")) {
            ipChange.ipc$dispatch("-1622017516", new Object[]{this});
            return;
        }
        View view = this.n;
        if (view == null) {
            return;
        }
        final Activity n = DogCat.n(view);
        if (!(n instanceof FragmentActivity)) {
            qv2.c("error exposure " + this.a + ' ' + this.n + " in " + n);
            return;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) n;
        Lifecycle lifecycle = fragmentActivity.getLifecycle();
        b41.h(lifecycle, "activity.lifecycle");
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            String str = this.e;
            if (str == null) {
                str = DogCat.INSTANCE.r(this.n);
            }
            this.e = str;
            if (!((str == null || str.length() == 0) ? true : true)) {
                String str2 = this.e;
                b41.f(str2);
                t0 = StringsKt__StringsKt.t0(str2, new String[]{"."}, false, 0, 6, null);
                if (t0.size() >= 3) {
                    u(new Runnable() { // from class: com.alibaba.pictures.ut.ExposureDog$exposure$1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public final void run() {
                            String str3;
                            Map p;
                            String str4;
                            String str5;
                            String str6;
                            Map<String, String> p2;
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-1122201232")) {
                                ipChange2.ipc$dispatch("-1122201232", new Object[]{this});
                                return;
                            }
                            ExposureDog exposureDog = ExposureDog.this;
                            View view2 = exposureDog.n;
                            str3 = ExposureDog.this.e;
                            exposureDog.t(view2, str3, null);
                            p = ExposureDog.this.p();
                            str4 = ExposureDog.this.f;
                            p.put("spm", str4);
                            UTAnalytics uTAnalytics = UTAnalytics.getInstance();
                            b41.h(uTAnalytics, "UTAnalytics.getInstance()");
                            UTTracker defaultTracker = uTAnalytics.getDefaultTracker();
                            View view3 = ExposureDog.this.n;
                            str5 = ExposureDog.this.a;
                            str6 = ExposureDog.this.b;
                            p2 = ExposureDog.this.p();
                            defaultTracker.setExposureTag(view3, str5, str6, p2);
                            ExposureDog.this.o((FragmentActivity) n);
                        }
                    });
                    return;
                }
            }
            this.n.post(new Runnable() { // from class: com.alibaba.pictures.ut.ExposureDog$exposure$2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    String y;
                    String str3;
                    Map p;
                    String str4;
                    String str5;
                    String str6;
                    Map<String, String> p2;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1318714737")) {
                        ipChange2.ipc$dispatch("-1318714737", new Object[]{this});
                        return;
                    }
                    ExposureDog exposureDog = ExposureDog.this;
                    y = exposureDog.y(exposureDog.n);
                    ExposureDog exposureDog2 = ExposureDog.this;
                    View view2 = exposureDog2.n;
                    str3 = ExposureDog.this.e;
                    exposureDog2.t(view2, str3, y);
                    p = ExposureDog.this.p();
                    str4 = ExposureDog.this.f;
                    p.put("spm", str4);
                    UTAnalytics uTAnalytics = UTAnalytics.getInstance();
                    b41.h(uTAnalytics, "UTAnalytics.getInstance()");
                    UTTracker defaultTracker = uTAnalytics.getDefaultTracker();
                    View view3 = ExposureDog.this.n;
                    str5 = ExposureDog.this.a;
                    str6 = ExposureDog.this.b;
                    p2 = ExposureDog.this.p();
                    defaultTracker.setExposureTag(view3, str5, str6, p2);
                    ExposureDog.this.o((FragmentActivity) n);
                }
            });
            return;
        }
        fragmentActivity.getLifecycle().addObserver(new ExposureObserver(fragmentActivity, this));
    }

    @NotNull
    public final ExposureDog q(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94757762")) {
            return (ExposureDog) ipChange.ipc$dispatch("-94757762", new Object[]{this, str});
        }
        this.d = str;
        return this;
    }

    @NotNull
    public final ExposureDog r(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1379296375")) {
            return (ExposureDog) ipChange.ipc$dispatch("-1379296375", new Object[]{this, str, str2});
        }
        if (str != null && str2 != null) {
            p().put(str, str2);
        }
        return this;
    }

    @NotNull
    public final ExposureDog s(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-704211421")) {
            return (ExposureDog) ipChange.ipc$dispatch("-704211421", new Object[]{this, map});
        }
        if (map != null) {
            p().putAll(map);
        }
        return this;
    }

    @NotNull
    public final ExposureDog w(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "723432313")) {
            return (ExposureDog) ipChange.ipc$dispatch("723432313", new Object[]{this, str, str2, str3});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return x(str2, str3);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        if (str2 == null) {
            str2 = "default";
        }
        sb.append(str2);
        sb.append('.');
        if (str3 == null) {
            str3 = "0";
        }
        sb.append(str3);
        this.e = sb.toString();
        return this;
    }

    @NotNull
    public final ExposureDog x(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011603067")) {
            return (ExposureDog) ipChange.ipc$dispatch("-2011603067", new Object[]{this, str, str2});
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "default";
        }
        sb.append(str);
        sb.append('.');
        if (str2 == null) {
            str2 = "0";
        }
        sb.append(str2);
        this.e = sb.toString();
        return this;
    }

    @NotNull
    public final ExposureDog z(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "56758232")) {
            return (ExposureDog) ipChange.ipc$dispatch("56758232", new Object[]{this, str});
        }
        this.b = str;
        this.c = Boolean.TRUE;
        return this;
    }
}
