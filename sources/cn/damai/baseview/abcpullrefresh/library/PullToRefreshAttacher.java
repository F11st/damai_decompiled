package cn.damai.baseview.abcpullrefresh.library;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import cn.damai.baseview.abcpullrefresh.library.listeners.HeaderViewListener;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnLoadMoreListener;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnRefreshListener;
import cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.WeakHashMap;
import tb.lw0;
import tb.pw2;

/* compiled from: Taobao */
@TargetApi(14)
/* loaded from: classes.dex */
public class PullToRefreshAttacher {
    private static transient /* synthetic */ IpChange $ipChange;
    private EnvironmentDelegate a;
    private lw0 b;
    private OnRefreshListener c;
    private OnLoadMoreListener d;
    private Activity e;
    private View f;
    private HeaderViewListener g;
    private final int h;
    private final float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private boolean o;
    private boolean p;
    private View q;
    private final WeakHashMap<View, ViewDelegate> r;
    private final boolean s;
    private final int t;
    private final boolean u;
    private final AddHeaderViewRunnable y;
    private boolean v = false;
    private final int[] w = new int[2];
    private final Rect x = new Rect();
    private final Runnable z = new Runnable() { // from class: cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-399607200")) {
                ipChange.ipc$dispatch("-399607200", new Object[]{this});
            } else {
                PullToRefreshAttacher.this.s();
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class AddHeaderViewRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;

        private AddHeaderViewRunnable() {
        }

        private View getDecorView() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-976758741") ? (View) ipChange.ipc$dispatch("-976758741", new Object[]{this}) : PullToRefreshAttacher.this.k().getWindow().getDecorView();
        }

        public void finish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-534253526")) {
                ipChange.ipc$dispatch("-534253526", new Object[]{this});
            } else {
                getDecorView().removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1290718238")) {
                ipChange.ipc$dispatch("-1290718238", new Object[]{this});
            } else if (PullToRefreshAttacher.this.p()) {
            } else {
                if (getDecorView().getWindowToken() != null) {
                    PullToRefreshAttacher pullToRefreshAttacher = PullToRefreshAttacher.this;
                    pullToRefreshAttacher.c(pullToRefreshAttacher.f);
                    return;
                }
                start();
            }
        }

        public void start() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418981547")) {
                ipChange.ipc$dispatch("1418981547", new Object[]{this});
            } else {
                getDecorView().post(this);
            }
        }

        /* synthetic */ AddHeaderViewRunnable(PullToRefreshAttacher pullToRefreshAttacher, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements EnvironmentDelegate {
        private static transient /* synthetic */ IpChange $ipChange;

        a(PullToRefreshAttacher pullToRefreshAttacher) {
        }

        @Override // cn.damai.baseview.abcpullrefresh.library.EnvironmentDelegate
        public Context getContextForInflater(Activity activity) {
            ActionBar actionBar;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "330584219")) {
                return (Context) ipChange.ipc$dispatch("330584219", new Object[]{this, activity});
            }
            Context context = null;
            if (Build.VERSION.SDK_INT >= 14 && (actionBar = activity.getActionBar()) != null) {
                context = actionBar.getThemedContext();
            }
            return context == null ? activity : context;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PullToRefreshAttacher(Activity activity, d dVar) {
        if (activity != null) {
            if (dVar == null) {
                pw2.d("PullToRefreshAttacher", "Given null options so using default options.");
                dVar = new d();
            }
            this.e = activity;
            this.r = new WeakHashMap<>();
            this.i = dVar.d;
            this.s = dVar.e;
            this.t = dVar.f;
            this.u = dVar.g;
            EnvironmentDelegate environmentDelegate = dVar.a;
            this.a = environmentDelegate == null ? h() : environmentDelegate;
            lw0 lw0Var = dVar.c;
            this.b = lw0Var == null ? i() : lw0Var;
            this.h = ViewConfiguration.get(activity).getScaledTouchSlop();
            View inflate = LayoutInflater.from(this.a.getContextForInflater(activity)).inflate(dVar.b, (ViewGroup) activity.getWindow().getDecorView(), false);
            this.f = inflate;
            if (inflate != null) {
                inflate.setVisibility(4);
                this.b.f(activity, this.f);
                AddHeaderViewRunnable addHeaderViewRunnable = new AddHeaderViewRunnable(this, null);
                this.y = addHeaderViewRunnable;
                addHeaderViewRunnable.start();
                return;
            }
            throw new IllegalArgumentException("Must supply valid layout id for header.");
        }
        throw new IllegalArgumentException("activity cannot be null");
    }

    private void A(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1498860246")) {
            ipChange.ipc$dispatch("-1498860246", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.o = false;
        if (this.u) {
            m().removeCallbacks(this.z);
        }
        o();
    }

    private void H(View view, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004701607")) {
            ipChange.ipc$dispatch("2004701607", new Object[]{this, view, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (p() || this.o == z) {
        } else {
            B();
            if (z && e(z2)) {
                A(z2);
                J(view, z2);
                return;
            }
            A(z2);
        }
    }

    private void J(View view, boolean z) {
        OnRefreshListener onRefreshListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626219354")) {
            ipChange.ipc$dispatch("626219354", new Object[]{this, view, Boolean.valueOf(z)});
            return;
        }
        this.o = true;
        if (z && (onRefreshListener = this.c) != null) {
            onRefreshListener.onRefreshStarted(view);
        }
        I();
        if (this.u) {
            if (this.t > 0) {
                m().postDelayed(this.z, this.t);
            } else {
                m().post(this.z);
            }
        }
    }

    private boolean e(boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1667235438") ? ((Boolean) ipChange.ipc$dispatch("-1667235438", new Object[]{this, Boolean.valueOf(z)})).booleanValue() : (this.o || (z && this.c == null)) ? false : true;
    }

    private boolean f(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812872188")) {
            return ((Boolean) ipChange.ipc$dispatch("-1812872188", new Object[]{this, view})).booleanValue();
        }
        if (!this.n || !this.s || view == null || this.k - this.l < n(view)) {
            return false;
        }
        H(view, true, true);
        return true;
    }

    private float n(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1784166227") ? ((Float) ipChange.ipc$dispatch("1784166227", new Object[]{this, view})).floatValue() : view.getHeight() * this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164314414")) {
            return ((Boolean) ipChange.ipc$dispatch("164314414", new Object[]{this})).booleanValue();
        }
        if (this.v) {
            pw2.d("PullToRefreshAttacher", "PullToRefreshAttacher is destroyed.");
        }
        return this.v;
    }

    void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880507487")) {
            ipChange.ipc$dispatch("-880507487", new Object[]{this});
            return;
        }
        this.n = false;
        this.p = false;
        this.l = -1.0f;
        this.k = -1.0f;
        this.j = -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(HeaderViewListener headerViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1309595593")) {
            ipChange.ipc$dispatch("1309595593", new Object[]{this, headerViewListener});
        } else {
            this.g = headerViewListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(OnLoadMoreListener onLoadMoreListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155826668")) {
            ipChange.ipc$dispatch("-155826668", new Object[]{this, onLoadMoreListener});
        } else {
            this.d = onLoadMoreListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "952235459")) {
            ipChange.ipc$dispatch("952235459", new Object[]{this, onRefreshListener});
        } else {
            this.c = onRefreshListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void F() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1522896159")) {
            ipChange.ipc$dispatch("1522896159", new Object[]{this});
        } else {
            H(null, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void G(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536160252")) {
            ipChange.ipc$dispatch("-536160252", new Object[]{this, Boolean.valueOf(z)});
        } else {
            H(null, z, false);
        }
    }

    void I() {
        HeaderViewListener headerViewListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114396990")) {
            ipChange.ipc$dispatch("-2114396990", new Object[]{this});
            return;
        }
        K(this.f);
        if (!this.b.g() || (headerViewListener = this.g) == null) {
            return;
        }
        headerViewListener.onStateChanged(this.f, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970365147")) {
            ipChange.ipc$dispatch("-970365147", new Object[]{this, view});
            return;
        }
        this.e.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.x);
        WindowManager.LayoutParams layoutParams = null;
        if (view.getLayoutParams() instanceof WindowManager.LayoutParams) {
            layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
        } else if (view.getTag() instanceof WindowManager.LayoutParams) {
            layoutParams = (WindowManager.LayoutParams) view.getTag();
        }
        if (layoutParams != null) {
            int i = layoutParams.y;
            int i2 = this.x.top;
            if (i != i2) {
                layoutParams.y = i2;
                this.e.getWindowManager().updateViewLayout(view, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(Class<?> cls, ViewDelegate viewDelegate) {
        WeakHashMap<View, ViewDelegate> weakHashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883755883")) {
            ipChange.ipc$dispatch("1883755883", new Object[]{this, cls, viewDelegate});
            return;
        }
        for (View view : this.r.keySet()) {
            if (cls.isInstance(view) && (weakHashMap = this.r) != null && view != null) {
                weakHashMap.put(view, viewDelegate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1638843446")) {
            ipChange.ipc$dispatch("1638843446", new Object[]{this, view});
            return;
        }
        this.e.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.x);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.width;
            i2 = layoutParams.height;
        } else {
            i = -1;
            i2 = -2;
        }
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, i2, 1000, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, -3);
        layoutParams2.x = 0;
        layoutParams2.y = this.x.top;
        layoutParams2.gravity = 48;
        view.setTag(layoutParams2);
        this.e.getWindowManager().addView(view, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view, ViewDelegate viewDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629846138")) {
            ipChange.ipc$dispatch("-1629846138", new Object[]{this, view, viewDelegate});
        } else if (p()) {
        } else {
            if (view == null) {
                pw2.d("PullToRefreshAttacher", "Refreshable View is null.");
                return;
            }
            if (viewDelegate == null) {
                viewDelegate = c.b(view);
            }
            this.r.put(view, viewDelegate);
        }
    }

    void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730137677")) {
            ipChange.ipc$dispatch("-730137677", new Object[]{this});
        } else {
            this.r.clear();
        }
    }

    protected EnvironmentDelegate h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-178528960") ? (EnvironmentDelegate) ipChange.ipc$dispatch("-178528960", new Object[]{this}) : new a(this);
    }

    protected lw0 i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1005927488") ? (lw0) ipChange.ipc$dispatch("-1005927488", new Object[]{this}) : new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-326919329")) {
            ipChange.ipc$dispatch("-326919329", new Object[]{this});
        } else if (this.v) {
        } else {
            z(this.f);
            g();
            this.e = null;
            this.f = null;
            this.g = null;
            this.a = null;
            this.b = null;
            this.v = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Activity k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1622330888") ? (Activity) ipChange.ipc$dispatch("-1622330888", new Object[]{this}) : this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public lw0 l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "906189551") ? (lw0) ipChange.ipc$dispatch("906189551", new Object[]{this}) : this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1703485651") ? (View) ipChange.ipc$dispatch("1703485651", new Object[]{this}) : this.f;
    }

    void o() {
        HeaderViewListener headerViewListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "775451293")) {
            ipChange.ipc$dispatch("775451293", new Object[]{this});
        } else if (!this.b.a() || (headerViewListener = this.g) == null) {
        } else {
            headerViewListener.onStateChanged(this.f, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean q() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1591006788") ? ((Boolean) ipChange.ipc$dispatch("1591006788", new Object[]{this})).booleanValue() : this.o;
    }

    final boolean r(View view, MotionEvent motionEvent) {
        ViewDelegate viewDelegate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540322716")) {
            return ((Boolean) ipChange.ipc$dispatch("1540322716", new Object[]{this, view, motionEvent})).booleanValue();
        }
        if (view.isShown() && this.r.containsKey(view)) {
            view.getLocationOnScreen(this.w);
            int[] iArr = this.w;
            int i = iArr[0];
            int i2 = iArr[1];
            this.x.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (this.x.contains(rawX, rawY) && (viewDelegate = this.r.get(view)) != null) {
                Rect rect = this.x;
                return viewDelegate.isReadyForPull(view, rawX - rect.left, rawY - rect.top);
            }
        }
        return false;
    }

    void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219329062")) {
            ipChange.ipc$dispatch("219329062", new Object[]{this});
        } else if (p()) {
        } else {
            this.b.d();
            HeaderViewListener headerViewListener = this.g;
            if (headerViewListener != null) {
                headerViewListener.onStateChanged(this.f, 1);
            }
        }
    }

    public void t(Configuration configuration) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726597860")) {
            ipChange.ipc$dispatch("-726597860", new Object[]{this, configuration});
            return;
        }
        lw0 lw0Var = this.b;
        if (lw0Var == null || (activity = this.e) == null || configuration == null) {
            return;
        }
        lw0Var.b(activity, configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (r2 != 3) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean u(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher.$ipChange
            java.lang.String r1 = "1417065364"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L1e
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r6
            r2[r5] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L1e:
            boolean r0 = r6.q()
            if (r0 == 0) goto L25
            return r3
        L25:
            float r0 = r7.getX()
            float r1 = r7.getY()
            int r2 = r7.getAction()
            if (r2 == 0) goto L74
            if (r2 == r5) goto L70
            if (r2 == r4) goto L3b
            r7 = 3
            if (r2 == r7) goto L70
            goto L9d
        L3b:
            boolean r7 = r6.n
            if (r7 != 0) goto L9d
            float r7 = r6.j
            r2 = 0
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 <= 0) goto L9d
            float r7 = r1 - r7
            float r2 = r6.m
            float r0 = r0 - r2
            float r2 = java.lang.Math.abs(r7)
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L64
            int r0 = r6.h
            float r0 = (float) r0
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 <= 0) goto L64
            r6.n = r5
            r6.x(r1)
            goto L9d
        L64:
            int r0 = r6.h
            int r0 = -r0
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L9d
            r6.B()
            goto L9d
        L70:
            r6.B()
            goto L9d
        L74:
            boolean r2 = r6.e(r5)
            if (r2 == 0) goto L9d
            java.util.WeakHashMap<android.view.View, cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate> r2 = r6.r
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L84:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L9d
            java.lang.Object r3 = r2.next()
            android.view.View r3 = (android.view.View) r3
            boolean r4 = r6.r(r3, r7)
            if (r4 == 0) goto L84
            r6.m = r0
            r6.j = r1
            r6.q = r3
            goto L84
        L9d:
            boolean r7 = r6.n
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher.u(android.view.MotionEvent):boolean");
    }

    void v(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448009275")) {
            ipChange.ipc$dispatch("1448009275", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float n = n(view);
        float f2 = f - this.l;
        if (f2 < n) {
            this.b.c(f2 / n);
        } else if (this.s) {
            this.b.e();
        } else {
            H(view, true, true);
        }
    }

    void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805078403")) {
            ipChange.ipc$dispatch("1805078403", new Object[]{this});
        } else if (this.o) {
        } else {
            A(true);
        }
    }

    void x(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1632557852")) {
            ipChange.ipc$dispatch("-1632557852", new Object[]{this, Float.valueOf(f)});
            return;
        }
        I();
        this.l = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
        if (r0 != 3) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean y(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher.$ipChange
            java.lang.String r1 = "873624336"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L1e
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r6
            r2[r5] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L1e:
            int r0 = r7.getAction()
            if (r0 != 0) goto L26
            r6.p = r5
        L26:
            boolean r0 = r6.p
            if (r0 == 0) goto L32
            boolean r0 = r6.n
            if (r0 != 0) goto L32
            r6.u(r7)
            return r5
        L32:
            android.view.View r0 = r6.q
            if (r0 != 0) goto L37
            return r4
        L37:
            int r0 = r7.getAction()
            if (r0 == r5) goto L76
            if (r0 == r3) goto L43
            r7 = 3
            if (r0 == r7) goto L76
            goto L85
        L43:
            boolean r0 = r6.q()
            if (r0 == 0) goto L4a
            return r4
        L4a:
            float r7 = r7.getY()
            boolean r0 = r6.n
            if (r0 == 0) goto L85
            float r0 = r6.k
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 == 0) goto L85
            float r0 = r7 - r0
            int r1 = r6.h
            int r1 = -r1
            float r1 = (float) r1
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 < 0) goto L6f
            android.view.View r1 = r6.q
            r6.v(r1, r7)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L85
            r6.k = r7
            goto L85
        L6f:
            r6.w()
            r6.B()
            goto L85
        L76:
            android.view.View r7 = r6.q
            r6.f(r7)
            boolean r7 = r6.n
            if (r7 == 0) goto L82
            r6.w()
        L82:
            r6.B()
        L85:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher.y(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "94210704")) {
            ipChange.ipc$dispatch("94210704", new Object[]{this, view});
            return;
        }
        this.y.finish();
        if (view.getWindowToken() != null) {
            this.e.getWindowManager().removeViewImmediate(view);
        }
    }
}
