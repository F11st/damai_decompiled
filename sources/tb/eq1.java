package tb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.application.common.IAppPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class eq1 extends ra {
    private static String W = "";
    private static String X;
    private static final List<String> Y = new ArrayList(4);
    private long F;
    private long G;
    private long H;
    private List<a80> I;
    private int J;
    private long[] K;
    private long[] L;
    private long M;
    private boolean N;
    public boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private boolean V;

    public eq1(pp1 pp1Var) {
        super(pp1Var);
        this.H = 0L;
        this.J = 0;
        this.L = new long[2];
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = false;
        this.R = true;
        this.S = true;
        this.T = true;
        this.U = 1;
        this.V = true;
    }

    private void m(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            long b = ho2.b(t52.a(map.get("navStartTime"), -1L));
            this.M = b;
            yu1.d(this.e, "navStartTime", b);
            yu1.d(this.e, "navStartActivityTime", ho2.b(t52.a(map.get("navStartActivityTime"), -1L)));
            this.d.G(this.M);
            if (this.d.a() != null) {
                this.e.addProperty("isFirstLoad", Boolean.valueOf(lu0.q.a(m3.b(this.d.a()))));
            } else if (this.d.e() != null) {
                this.e.addProperty("isFirstLoad", Boolean.valueOf(lu0.q.a(mp0.a(this.d.e()))));
            }
            yu1.b(this.e, "fullPageName", map.get("fullPageName"));
            yu1.b(this.e, "activityName", map.get("activityName"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private JSONObject n(Map map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Object obj : map.keySet()) {
                jSONObject.put(String.valueOf(obj), map.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void o(Activity activity) {
        String str;
        if (activity == null) {
            return;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("referrer");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    Uri parse = Uri.parse(stringExtra);
                    str = parse.getHost() + parse.getPath();
                } catch (Exception e) {
                    str = e.getMessage();
                }
                this.e.addProperty("referer", str);
            }
        }
        str = "null";
        this.e.addProperty("referer", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void d() {
        super.d();
        this.e.stage("procedureStartTime", ho2.a());
        this.e.addProperty("errorCode", 1);
        this.e.addProperty("installType", lu0.g);
        this.e.addProperty("timestampInterval", Long.valueOf(System.currentTimeMillis() - SystemClock.uptimeMillis()));
        this.e.addProperty("leaveType", "other");
        yu1.b(this.e, "groupRelatedId", this.d.i());
        long[] jArr = this.L;
        jArr[0] = 0;
        jArr[1] = 0;
        this.I = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.ra, com.taobao.monitor.impl.processor.AbsProcessor
    public void e() {
        if (this.Q || !this.e.isAlive()) {
            return;
        }
        if (this.N) {
            this.e.addProperty("utSession", dt2.a().getUtsid());
        }
        if (this.d.l() != null) {
            this.e.addProperty("pageCalculateType", "view_manual_calculate");
        }
        this.Q = true;
        IAppPreferences d = com.taobao.application.common.b.d();
        e30.a("PageProcessor", "errorCode", Integer.valueOf(this.U));
        this.e.addProperty("totalVisibleDuration", Long.valueOf(this.H));
        this.e.addProperty("deviceLevel", Integer.valueOf(d.getInt("deviceLevel", -1)));
        this.e.addProperty("runtimeLevel", Integer.valueOf(k4.d().f().d));
        this.e.addProperty("cpuUsageOfDevice", Float.valueOf(k4.d().b().d));
        this.e.addProperty("memoryRuntimeLevel", Integer.valueOf(k4.d().e().k));
        yu1.d(this.e, "firstFrameTime", this.d.d());
        this.e.addStatistic("gcCount", Integer.valueOf(this.E));
        this.e.addStatistic("fps", this.z.toString());
        this.e.addStatistic("frozenFrameCount", Integer.valueOf(this.A));
        this.e.addStatistic("slowFrameCount", Integer.valueOf(this.B));
        this.e.addStatistic("jankCount", Integer.valueOf(this.C));
        this.e.addStatistic("image", Integer.valueOf(this.r));
        this.e.addStatistic("imageOnRequest", Integer.valueOf(this.r));
        this.e.addStatistic("imageSuccessCount", Integer.valueOf(this.s));
        this.e.addStatistic("imageFailedCount", Integer.valueOf(this.t));
        this.e.addStatistic("imageCanceledCount", Integer.valueOf(this.u));
        this.e.addStatistic("network", Integer.valueOf(this.v));
        this.e.addStatistic("networkOnRequest", Integer.valueOf(this.v));
        this.e.addStatistic("networkSuccessCount", Integer.valueOf(this.w));
        this.e.addStatistic("networkFailedCount", Integer.valueOf(this.x));
        this.e.addStatistic("networkCanceledCount", Integer.valueOf(this.y));
        this.e.addStatistic("renderFrameCount", Integer.valueOf(this.d.f()));
        this.e.addStatistic("blockRenderFrameCount", Integer.valueOf(this.d.b()));
        this.e.addStatistic("frozenRenderFrameCount", Integer.valueOf(this.d.g()));
        this.e.addStatistic("mainBlockFrameCauses", n(this.d.k()));
        this.e.addStatistic("importantBlockFrameCauses", n(this.d.j()));
        this.e.stage("procedureEndTime", ho2.a());
        this.e.end();
        super.e();
    }

    @Override // tb.ra
    protected String f() {
        return "/pageLoad";
    }

    @Override // tb.ra
    protected void j(String str) {
        if (this.P) {
            this.P = false;
            this.e.addProperty("leaveType", str);
            this.e.stage("leaveTime", ho2.a());
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i, long j) {
        e30.a("PageProcessor", "onChanged", Integer.valueOf(i), Long.valueOf(j));
        if (i == 1) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("timestamp", Long.valueOf(j));
            this.e.event("foreground2Background", hashMap);
            return;
        }
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("timestamp", Long.valueOf(j));
        this.e.event("background2Foreground", hashMap2);
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j) {
        if (sy2.a(activity, this.d.o())) {
            int action = keyEvent.getAction();
            int keyCode = keyEvent.getKeyCode();
            if (action == 0) {
                if (keyCode == 4 || keyCode == 3) {
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("timestamp", Long.valueOf(j));
                    hashMap.put("key", Integer.valueOf(keyEvent.getKeyCode()));
                    this.e.event("keyEvent", hashMap);
                }
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher.LowMemoryListener
    public void onLowMemory() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(ho2.a()));
        this.e.event("onLowMemory", hashMap);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageAppear() {
        e30.a("PageProcessor", "onPageAppear", this.d.m());
        long a = ho2.a();
        this.G = a;
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(a));
        this.e.event("onPageAppear", hashMap);
        W = this.d.m();
        if (this.d.t()) {
            X = this.d.m();
        }
        if (this.O && this.K != null) {
            this.O = false;
            long[] a2 = qp2.a();
            long[] jArr = this.L;
            long j = jArr[0];
            long j2 = a2[0];
            long[] jArr2 = this.K;
            jArr[0] = j + (j2 - jArr2[0]);
            jArr[1] = jArr[1] + (a2[1] - jArr2[1]);
        }
        this.K = qp2.a();
        lu0.p = this.d.m();
        lu0.n = a;
        if (jd0.r && this.d.t()) {
            int i = this.J;
            if (i == 0) {
                this.J = i + 1;
            } else {
                this.I.add(a80.a().b("R"));
            }
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
    public void onPageClickTime(long j) {
        e30.a("PageProcessor", "onPageClickTime", Long.valueOf(j));
        this.e.stage("jumpTime", j);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageCreate(String str, String str2, Map<String, Object> map) {
        e30.a("PageProcessor", "onPageCreate", str, str2, map);
        this.F = ho2.a();
        this.K = qp2.a();
        if (this.d.n() > 0) {
            this.F = this.d.n();
        }
        List<String> list = Y;
        if (list.size() < 10) {
            list.add(str);
        }
        m(map);
        this.e.stage("loadStartTime", this.F);
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(this.F));
        this.e.event("onPageCreate", hashMap);
        yu1.c(this.e, "fromPageName", W);
        yu1.c(this.e, "lastJumpPage", X);
        this.e.addProperty("pageName", str);
        yu1.c(this.e, "schemaUrl", str2);
        this.e.addProperty("isFirstLaunch", Boolean.valueOf(lu0.d));
        this.e.addProperty("lastValidTime", Long.valueOf(lu0.n));
        this.e.addProperty("lastValidLinksPage", list.toString());
        this.e.addProperty("lastValidPage", lu0.p);
        this.e.addProperty("loadType", "push");
        yu1.a(this.e, "jumpTime", lu0.m);
        lu0.m = -1L;
        this.e.stage("jumpTime", -1L);
        if (jd0.r && this.d.t()) {
            o(this.d.a());
            this.I.add(a80.a().b("C"));
        }
        this.d.w();
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageDestroy() {
        e30.a("PageProcessor", "onPageDestroy");
        long a = ho2.a();
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(a));
        this.e.event("onPageDestroy", hashMap);
        if (this.K != null) {
            long[] a2 = qp2.a();
            long[] jArr = this.L;
            long j = jArr[0];
            long j2 = a2[0];
            long[] jArr2 = this.K;
            jArr[0] = j + (j2 - jArr2[0]);
            jArr[1] = jArr[1] + (a2[1] - jArr2[1]);
        }
        if (jd0.r) {
            this.e.addProperty("runtimeInfo", this.I.toString());
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageDisappear() {
        e30.a("PageProcessor", "onPageDisappear");
        long a = ho2.a();
        this.H += a - this.G;
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(a));
        this.e.event("onPageDisappear", hashMap);
        if (this.K != null) {
            long[] a2 = qp2.a();
            long[] jArr = this.L;
            long j = jArr[0];
            long j2 = a2[0];
            long[] jArr2 = this.K;
            jArr[0] = j + (j2 - jArr2[0]);
            jArr[1] = jArr[1] + (a2[1] - jArr2[1]);
            this.K = a2;
        }
        if (jd0.r && this.d.t()) {
            this.I.add(a80.a().b(ExifInterface.LATITUDE_SOUTH));
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageInteractive(long j) {
        e30.a("PageProcessor", "onPageInteractive", Long.valueOf(j));
        if (this.T) {
            this.T = false;
            this.U = 0;
            this.e.addProperty("interactiveDuration", Long.valueOf(j - this.F));
            this.e.addProperty("loadDuration", Long.valueOf(j - this.F));
            this.e.stage("interactiveTime", j);
            this.e.addProperty("errorCode", 0);
            this.e.addStatistic("totalRx", Long.valueOf(this.L[0]));
            this.e.addStatistic("totalTx", Long.valueOf(this.L[1]));
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageLoadError(int i) {
        e30.a("PageProcessor", "onPageLoadError", Integer.valueOf(i));
        if (this.U == 1) {
            this.e.addProperty("errorCode", Integer.valueOf(i));
            this.U = i;
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
    public void onPageNavStartTime(long j) {
        e30.a("PageProcessor", "onPageNavStartTime", Long.valueOf(j));
        this.M = j;
        this.e.stage("navStartTime", j);
        this.d.G(j);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageRenderPercent(float f, long j) {
        e30.a("PageProcessor", "onPageRenderPercent", Float.valueOf(f), Long.valueOf(j));
        if (this.S) {
            this.e.addProperty("onRenderPercent", Float.valueOf(f));
            this.e.addProperty("drawPercentTime", Long.valueOf(j));
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageRenderStart(long j) {
        e30.a("PageProcessor", "onPageRenderStart", Long.valueOf(j));
        if (this.R) {
            this.e.addProperty("pageInitDuration", Long.valueOf(j - this.F));
            this.e.stage("renderStartTime", j);
            this.R = false;
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageVisible(long j) {
        e30.a("PageProcessor", "onPageVisible", Long.valueOf(j));
        if (this.S) {
            this.S = false;
            this.e.addProperty("displayDuration", Long.valueOf(j - this.F));
            this.e.stage("displayedTime", j);
            this.e.stage("firstScreenPaint", j);
            if (!this.N || TextUtils.isEmpty(dt2.a().getUtsid())) {
                return;
            }
            this.e.addProperty("utSession", dt2.a().getUtsid());
            this.N = false;
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j) {
        if (sy2.a(activity, this.d.o())) {
            if (this.V) {
                this.e.stage("firstInteractiveTime", j);
                this.e.addProperty("firstInteractiveDuration", Long.valueOf(j - this.F));
                this.V = false;
            }
            List<String> list = Y;
            list.clear();
            list.add(m3.d(activity));
            lu0.p = m3.d(activity);
            lu0.n = j;
        }
    }
}
