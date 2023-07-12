package com.taobao.monitor.impl.processor.launcher;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.FrameMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.application.common.C6673b;
import com.taobao.application.common.IAppLaunchListener;
import com.taobao.application.common.impl.C6674a;
import com.taobao.monitor.impl.common.ProcessStart;
import com.taobao.monitor.impl.processor.AbsProcessor;
import com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.ApplicationGCDispatcher;
import com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.FragmentFunctionListener;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.ImageStageDispatcher;
import com.taobao.monitor.impl.trace.NetworkStageDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import com.taobao.monitor.procedure.C6817d;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.C8934b0;
import tb.bv1;
import tb.dp2;
import tb.dt2;
import tb.fu0;
import tb.ho2;
import tb.jd0;
import tb.k4;
import tb.lu0;
import tb.m3;
import tb.nu2;
import tb.pp1;
import tb.qp2;
import tb.t52;
import tb.tu1;
import tb.uu1;
import tb.wu1;
import tb.xu1;
import tb.zp1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LauncherProcessor extends AbsProcessor implements ActivityLifeCycleDispatcher.IActivityLifeCycle, ApplicationBackgroundChangedDispatcher.BackgroundChangedListener, ApplicationGCDispatcher.ApplicationGCListener, ApplicationLowMemoryDispatcher.LowMemoryListener, FPSDispatcher.FPSListener, FragmentFunctionListener, ImageStageDispatcher.IImageStageListener, NetworkStageDispatcher.INetworkStageListener, PageLeaveDispatcher.PageLeaveListener, RenderDispatcher.PageRenderStandard, WindowEventDispatcher.OnEventListener {
    public static final String COLD = "COLD";
    public static final String HOT = "HOT";
    public static volatile String S = "COLD";
    public static boolean T = false;
    public static String U = "onlyPullProcess";
    public static final String WARM = "WARM";
    private String A;
    private volatile boolean B;
    IAppLaunchListener C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private Map<String, Long> N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    protected String d;
    private String e;
    private IProcedure f;
    private IDispatcher g;
    private IDispatcher h;
    private IDispatcher i;
    private IDispatcher j;
    private IDispatcher k;
    private IDispatcher l;
    private IDispatcher m;
    private IDispatcher n;
    private IDispatcher o;
    private IDispatcher p;
    private IDispatcher q;
    private List<String> r;
    private List<String> s;
    private List<Integer> t;
    private int u;
    private int v;
    private long w;
    private boolean x;
    private long[] y;
    private HashMap<String, Integer> z;

    public LauncherProcessor() {
        super(false);
        this.r = new ArrayList(4);
        this.s = new ArrayList(4);
        this.t = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.x = false;
        this.z = new HashMap<>();
        this.A = S;
        this.B = false;
        this.C = C6674a.g().d();
        this.D = true;
        this.M = true;
        this.N = new HashMap();
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = false;
        d();
    }

    private void h() {
        this.w = COLD.equals(S) ? lu0.j : ho2.a();
        this.f.addProperty("errorCode", 1);
        this.f.addProperty("launchType", S);
        this.f.addProperty("isFirstInstall", Boolean.valueOf(lu0.b));
        this.f.addProperty("isFirstLaunch", Boolean.valueOf(lu0.d));
        this.f.addProperty("installType", lu0.g);
        this.f.addProperty("oppoCPUResource", lu0.l);
        this.f.addProperty("leaveType", "other");
        this.f.addProperty("lastProcessStartTime", Long.valueOf(lu0.k));
        this.f.addProperty("systemInitDuration", Long.valueOf(lu0.j - lu0.i));
        this.f.addProperty("timestampInterval", Long.valueOf(System.currentTimeMillis() - SystemClock.uptimeMillis()));
        this.f.addProperty("channelExistWhenLaunch", Boolean.valueOf(bv1.b()));
        this.f.stage("processStartTime", lu0.i);
        this.f.stage("launchStartTime", lu0.j);
        lu0.b = false;
        lu0.d = false;
        if (WARM.equals(S)) {
            this.f.addProperty("warnType", U);
        }
    }

    private void j() {
        if (this.B) {
            return;
        }
        this.C.onLaunchChanged(!this.A.equals(COLD), 4);
        this.B = true;
    }

    private int k() {
        return !this.A.equals(COLD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void d() {
        super.d();
        this.y = qp2.a();
        IProcedure launcherProcedure = wu1.b.getLauncherProcedure();
        this.f = launcherProcedure;
        if (launcherProcedure == null || !launcherProcedure.isAlive()) {
            IProcedure createProcedure = tu1.b.createProcedure(dp2.a("/startup"), new C6817d.C6819b().g(false).k(true).j(jd0.E).i(true).h(null).f());
            this.f = createProcedure;
            createProcedure.begin();
            uu1.PROCEDURE_MANAGER.s(this.f);
            SharedPreferences.Editor edit = fu0.e().a().getSharedPreferences(xu1.DEFAULT_SAVE_DIR, 0).edit();
            edit.putString(nu2.KEY_LAST_LAUNCH_SESSION, this.f.topicSession());
            edit.apply();
        }
        this.f.stage("procedureStartTime", ho2.a());
        this.g = a(C8934b0.WINDOW_EVENT_DISPATCHER);
        this.h = a(C8934b0.APPLICATION_LOW_MEMORY_DISPATCHER);
        this.i = a(C8934b0.PAGE_RENDER_DISPATCHER);
        this.j = a(C8934b0.ACTIVITY_FPS_DISPATCHER);
        this.k = a(C8934b0.APPLICATION_GC_DISPATCHER);
        this.l = a(C8934b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
        this.m = a(C8934b0.NETWORK_STAGE_DISPATCHER);
        this.n = a(C8934b0.IMAGE_STAGE_DISPATCHER);
        this.o = a(C8934b0.FRAGMENT_LIFECYCLE_FUNCTION_DISPATCHER);
        this.p = a(C8934b0.PAGE_RENDER_DISPATCHER);
        this.q = a(C8934b0.PAGE_LEAVE_DISPATCHER);
        this.h.addListener(this);
        this.j.addListener(this);
        this.k.addListener(this);
        this.g.addListener(this);
        this.i.addListener(this);
        this.l.addListener(this);
        this.m.addListener(this);
        this.n.addListener(this);
        this.o.addListener(this);
        this.p.addListener(this);
        this.q.addListener(this);
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void e() {
        if (this.R) {
            return;
        }
        this.R = true;
        j();
        if (this.D) {
            this.f.addProperty("utSession", dt2.a().getUtsid());
        }
        if (!TextUtils.isEmpty(this.d)) {
            this.f.addProperty("currentPageName", this.d.substring(this.d.lastIndexOf(".") + 1));
            this.f.addProperty("fullPageName", this.d);
            try {
                if (!TextUtils.isEmpty(this.d) && this.N.containsKey(this.d)) {
                    long longValue = this.N.get(this.d).longValue();
                    this.f.addProperty("appInitDuration", Long.valueOf(longValue - this.w));
                    this.f.stage("renderStartTime", longValue);
                }
            } catch (Exception unused) {
            }
        }
        this.N.clear();
        this.f.addProperty("processStartType", Integer.valueOf(ProcessStart.a()));
        this.f.addProperty("linkPageName", this.r.toString());
        this.f.addProperty("linkPageUrl", this.s.toString());
        this.r.clear();
        this.s.clear();
        this.f.addProperty("deviceLevel", Integer.valueOf(C6673b.d().getInt("deviceLevel", -1)));
        this.f.addProperty("runtimeLevel", Integer.valueOf(k4.d().f().d));
        this.f.addProperty("cpuUsageOfDevcie", Float.valueOf(k4.d().b().d));
        this.f.addProperty("memoryRuntimeLevel", Integer.valueOf(k4.d().e().k));
        this.f.addProperty("hasSplash", Boolean.valueOf(lu0.c));
        this.f.addStatistic("gcCount", Integer.valueOf(this.v));
        this.f.addStatistic("fps", this.t.toString());
        this.f.addStatistic("jankCount", Integer.valueOf(this.u));
        this.f.addStatistic("image", Integer.valueOf(this.E));
        this.f.addStatistic("imageOnRequest", Integer.valueOf(this.E));
        this.f.addStatistic("imageSuccessCount", Integer.valueOf(this.F));
        this.f.addStatistic("imageFailedCount", Integer.valueOf(this.G));
        this.f.addStatistic("imageCanceledCount", Integer.valueOf(this.H));
        this.f.addStatistic("network", Integer.valueOf(this.I));
        this.f.addStatistic("networkOnRequest", Integer.valueOf(this.I));
        this.f.addStatistic("networkSuccessCount", Integer.valueOf(this.J));
        this.f.addStatistic("networkFailedCount", Integer.valueOf(this.K));
        this.f.addStatistic("networkCanceledCount", Integer.valueOf(this.L));
        long[] a = qp2.a();
        this.f.addStatistic("totalRx", Long.valueOf(a[0] - this.y[0]));
        this.f.addStatistic("totalTx", Long.valueOf(a[1] - this.y[1]));
        this.f.stage("procedureEndTime", ho2.a());
        lu0.c = false;
        this.l.removeListener(this);
        this.h.removeListener(this);
        this.k.removeListener(this);
        this.j.removeListener(this);
        this.g.removeListener(this);
        this.i.removeListener(this);
        this.n.removeListener(this);
        this.m.removeListener(this);
        this.o.removeListener(this);
        this.p.removeListener(this);
        this.q.removeListener(this);
        this.f.end();
        super.e();
    }

    @Override // com.taobao.monitor.impl.trace.FPSDispatcher.FPSListener
    public void frameDataPerSecond(int i, int i2, int i3, int i4, List<FrameMetrics> list) {
        if (this.t.size() < 200) {
            this.t.add(Integer.valueOf(i));
            this.u += i2;
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationGCDispatcher.ApplicationGCListener
    public void gc() {
        this.v++;
    }

    protected boolean i(Activity activity) {
        return m3.b(activity).equals(this.d);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityCreated(Activity activity, Map<String, Object> map, long j) {
        String d = m3.d(activity);
        this.e = m3.b(activity);
        String b = t52.b(map.get("schemaUrl"), "");
        if (!this.x) {
            this.f.addProperty("systemRecovery", Boolean.FALSE);
            if (COLD.equals(S) && this.e.equals(lu0.e)) {
                this.f.addProperty("systemRecovery", Boolean.TRUE);
                this.d = this.e;
                this.r.add(d);
            }
            Object obj = map.get("outLink");
            if (obj != null) {
                this.f.addProperty("outLink", obj);
            }
            Object obj2 = map.get("blackPage");
            if (obj2 != null) {
                this.f.addProperty("blackPage", obj2);
            }
            if (!TextUtils.isEmpty(b)) {
                this.f.addProperty("schemaUrl", b);
            }
            this.f.addProperty("firstPageName", d);
            this.f.stage("firstPageCreateTime", j);
            this.A = S;
            S = HOT;
            this.x = true;
        }
        if (this.r.size() < 10) {
            if (TextUtils.isEmpty(this.d)) {
                this.r.add(d);
            }
            if (!TextUtils.isEmpty(b)) {
                this.s.add(b);
            }
        }
        if (TextUtils.isEmpty(this.d) && !zp1.e(this.e) && (zp1.k() || zp1.i(this.e))) {
            this.d = this.e;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j));
        hashMap.put("pageName", d);
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityDestroyed(Activity activity, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j));
        hashMap.put("pageName", m3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityPaused(Activity activity, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j));
        hashMap.put("pageName", m3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityResumed(Activity activity, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j));
        hashMap.put("pageName", m3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, hashMap);
        if (!this.D || TextUtils.isEmpty(dt2.a().getUtsid())) {
            return;
        }
        fu0.e().d().post(new Runnable() { // from class: com.taobao.monitor.impl.processor.launcher.LauncherProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                LauncherProcessor.this.f.addProperty("utSession", dt2.a().getUtsid());
                LauncherProcessor.this.D = false;
            }
        });
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityStarted(Activity activity, long j) {
        if (HOT.equals(S) && !this.x) {
            this.x = true;
            String b = m3.b(activity);
            this.e = b;
            this.d = b;
            if (activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getDataString())) {
                this.f.addProperty("schemaUrl", activity.getIntent().getDataString());
            }
            this.f.addProperty("firstPageName", m3.b(activity));
            this.f.stage("firstPageCreateTime", j);
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j));
        hashMap.put("pageName", m3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STARTED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityStopped(Activity activity, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j));
        hashMap.put("pageName", m3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i, long j) {
        if (i == 1) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("timestamp", Long.valueOf(j));
            this.f.event("foreground2Background", hashMap);
        }
    }

    @Override // com.taobao.monitor.impl.trace.FragmentFunctionListener
    public void onFunction(Activity activity, Fragment fragment, String str, long j) {
        int valueOf;
        if (fragment == null || activity == null || !TextUtils.equals(activity.getClass().getName(), this.e)) {
            return;
        }
        String str2 = fragment.getClass().getSimpleName() + JSMethod.NOT_SET + str;
        Integer num = this.z.get(str2);
        if (num == null) {
            valueOf = 0;
        } else {
            valueOf = Integer.valueOf(num.intValue() + 1);
        }
        this.z.put(str2, valueOf);
        this.f.stage(str2 + valueOf, j);
    }

    @Override // com.taobao.monitor.impl.trace.ImageStageDispatcher.IImageStageListener
    public void onImageStage(int i) {
        if (i == 0) {
            this.E++;
        } else if (i == 1) {
            this.F++;
        } else if (i == 2) {
            this.G++;
        } else if (i == 3) {
            this.H++;
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j) {
        int action = keyEvent.getAction();
        int keyCode = keyEvent.getKeyCode();
        if (action == 0) {
            if (keyCode == 4 || keyCode == 3) {
                if (TextUtils.isEmpty(this.d)) {
                    this.d = m3.b(activity);
                    if (activity != null) {
                        try {
                            if (this.N.containsKey(m3.b(activity))) {
                                long longValue = this.N.get(activity.getClass().getName()).longValue();
                                this.f.addProperty("appInitDuration", Long.valueOf(longValue - this.w));
                                this.f.stage("renderStartTime", longValue);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                HashMap hashMap = new HashMap(2);
                hashMap.put("timestamp", Long.valueOf(j));
                hashMap.put("key", Integer.valueOf(keyEvent.getKeyCode()));
                this.f.event("keyEvent", hashMap);
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.PageLeaveDispatcher.PageLeaveListener
    public void onLeave(pp1 pp1Var, int i) {
        if (pp1Var != null && pp1Var.t() && i(pp1Var.a())) {
            this.f.stage("leaveTime", ho2.a());
            if (i == -5) {
                this.f.addProperty("leaveType", "jumpNextPage");
            } else if (i == -4) {
                this.f.addProperty("leaveType", "back");
            }
            b();
        }
        if (i == -3) {
            this.f.stage("leaveTime", ho2.a());
            this.f.addProperty("leaveType", "F2B");
            b();
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher.LowMemoryListener
    public void onLowMemory() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(ho2.a()));
        this.f.event("onLowMemory", hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.NetworkStageDispatcher.INetworkStageListener
    public void onNetworkStage(int i) {
        if (i == 0) {
            this.I++;
        } else if (i == 1) {
            this.J++;
        } else if (i == 2) {
            this.K++;
        } else if (i == 3) {
            this.L++;
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageInteractive(pp1 pp1Var, long j) {
        Activity a;
        if (this.P && (a = pp1Var.a()) != null && i(a)) {
            this.f.addProperty("interactiveDuration", Long.valueOf(j - this.w));
            this.f.addProperty("launchDuration", Long.valueOf(j - this.w));
            this.f.stage("interactiveTime", j);
            this.C.onLaunchChanged(k(), 2);
            j();
            this.P = false;
            if (pp1Var.l() != null) {
                onPageLoadError(pp1Var, 0);
                this.f.addProperty("errorCode", 0);
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageLoadError(pp1 pp1Var, int i) {
        Activity a = pp1Var.a();
        if (this.Q && a != null && i(a)) {
            this.f.addProperty("errorCode", Integer.valueOf(i));
            this.Q = false;
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderPercent(pp1 pp1Var, float f, long j) {
        Activity a = pp1Var.a();
        if (a == null || !i(a)) {
            return;
        }
        this.f.addProperty("onRenderPercent", Float.valueOf(f));
        this.f.addProperty("drawPercentTime", Long.valueOf(j));
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderStart(pp1 pp1Var, long j) {
        Activity a = pp1Var.a();
        String h = pp1Var.h();
        if (TextUtils.isEmpty(h) || a == null || this.N.containsKey(h)) {
            return;
        }
        this.N.put(pp1Var.h(), Long.valueOf(j));
        if (i(a)) {
            this.f.addProperty("appInitDuration", Long.valueOf(j - this.w));
            this.f.stage("renderStartTime", j);
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageVisible(pp1 pp1Var, long j) {
        Activity a = pp1Var.a();
        if (a == null || !this.O) {
            return;
        }
        if (!zp1.e(this.e) && TextUtils.isEmpty(this.d)) {
            this.d = this.e;
        }
        if (i(a)) {
            this.f.addProperty("displayDuration", Long.valueOf(j - this.w));
            this.f.stage("displayedTime", j);
            this.f.stage("firstScreenPaint", j);
            this.C.onLaunchChanged(k(), 1);
            this.O = false;
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j) {
        if (!this.M || zp1.e(m3.b(activity))) {
            return;
        }
        if (TextUtils.isEmpty(this.d)) {
            String b = m3.b(activity);
            this.d = b;
            try {
                if (!TextUtils.isEmpty(b) && this.N.containsKey(this.d)) {
                    long longValue = this.N.get(this.d).longValue();
                    this.f.addProperty("appInitDuration", Long.valueOf(longValue - this.w));
                    this.f.stage("renderStartTime", longValue);
                }
            } catch (Exception unused) {
            }
        }
        if (i(activity)) {
            this.f.stage("firstInteractiveTime", j);
            this.f.addProperty("firstInteractiveDuration", Long.valueOf(j - this.w));
            this.M = false;
        }
    }

    public LauncherProcessor(String str) {
        super(false);
        this.r = new ArrayList(4);
        this.s = new ArrayList(4);
        this.t = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.x = false;
        this.z = new HashMap<>();
        this.A = S;
        this.B = false;
        this.C = C6674a.g().d();
        this.D = true;
        this.M = true;
        this.N = new HashMap();
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = false;
        S = str;
        this.A = str;
        d();
    }
}
