package tb;

import android.view.FrameMetrics;
import com.taobao.monitor.impl.processor.AbsProcessor;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.ApplicationGCDispatcher;
import com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.ImageStageDispatcher;
import com.taobao.monitor.impl.trace.NetworkStageDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import com.taobao.monitor.procedure.C6817d;
import com.taobao.monitor.procedure.IPage;
import com.taobao.monitor.procedure.IProcedure;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ra extends AbsProcessor implements ApplicationBackgroundChangedDispatcher.BackgroundChangedListener, ApplicationGCDispatcher.ApplicationGCListener, ApplicationLowMemoryDispatcher.LowMemoryListener, CustomPageLifecycleDispatcher.CustomPageLifecycle, FPSDispatcher.FPSListener, ImageStageDispatcher.IImageStageListener, NetworkStageDispatcher.INetworkStageListener, PageLeaveDispatcher.PageLeaveListener, RenderDispatcher.PageRenderStandard, WindowEventDispatcher.OnEventListener, IPage.PageBeginStandard, IPage.PageDataSetter, IPage.PageLifecycleCallback, IPage.PageRenderStandard {
    protected int A;
    protected int B;
    protected int C;
    protected final List<FrameMetrics> D;
    protected int E;
    protected final pp1 d;
    protected IProcedure e;
    protected CustomPageLifecycleDispatcher f;
    private WindowEventDispatcher g;
    private ApplicationLowMemoryDispatcher h;
    private FPSDispatcher i;
    private ApplicationGCDispatcher j;
    private ApplicationBackgroundChangedDispatcher k;
    private NetworkStageDispatcher l;
    private ImageStageDispatcher m;
    private RenderDispatcher n;
    private PageLeaveDispatcher o;
    protected boolean p;
    protected boolean q;
    protected int r;
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected int w;
    protected int x;
    protected int y;
    protected final List<Integer> z;

    public ra() {
        this.p = true;
        this.q = true;
        this.z = new ArrayList();
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = new ArrayList();
        this.E = 0;
        this.d = new pp1();
    }

    public void addProperty(String str, Object obj) {
        this.e.addProperty(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void e() {
        super.e();
        if (!ca0.c(this.f)) {
            this.f.removeListener(this);
        }
        if (!ca0.c(this.h)) {
            this.h.removeListener(this);
        }
        if (!ca0.c(this.g)) {
            this.g.removeListener(this);
        }
        if (!ca0.c(this.i)) {
            this.i.removeListener(this);
        }
        if (!ca0.c(this.j)) {
            this.j.removeListener(this);
        }
        if (!ca0.c(this.k)) {
            this.k.removeListener(this);
        }
        if (!ca0.c(this.m)) {
            this.m.removeListener(this);
        }
        if (!ca0.c(this.l)) {
            this.l.removeListener(this);
        }
        if (!ca0.c(this.n)) {
            this.n.removeListener(this);
        }
        if (!ca0.c(this.o)) {
            this.o.removeListener(this);
        }
        uu1.PROCEDURE_MANAGER.p(this.d);
    }

    protected abstract String f();

    public void frameDataPerSecond(int i, int i2, int i3, int i4, List<FrameMetrics> list) {
        if (this.z.size() >= 200 || !this.q) {
            return;
        }
        this.C += i2;
        this.A += i3;
        this.B += i4;
        this.z.add(Integer.valueOf(i));
        if (this.D.size() > 200 || list == null) {
            return;
        }
        this.D.addAll(list);
    }

    protected void g() {
        IDispatcher a = a(C8934b0.WINDOW_EVENT_DISPATCHER);
        if (a instanceof WindowEventDispatcher) {
            this.g = (WindowEventDispatcher) a;
        }
        IDispatcher a2 = a(C8934b0.APPLICATION_LOW_MEMORY_DISPATCHER);
        if (a2 instanceof ApplicationLowMemoryDispatcher) {
            this.h = (ApplicationLowMemoryDispatcher) a2;
        }
        IDispatcher a3 = a(C8934b0.ACTIVITY_FPS_DISPATCHER);
        if (a3 instanceof FPSDispatcher) {
            this.i = (FPSDispatcher) a3;
        }
        IDispatcher a4 = a(C8934b0.APPLICATION_GC_DISPATCHER);
        if (a4 instanceof ApplicationGCDispatcher) {
            this.j = (ApplicationGCDispatcher) a4;
        }
        IDispatcher a5 = a(C8934b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
        if (a5 instanceof ApplicationBackgroundChangedDispatcher) {
            this.k = (ApplicationBackgroundChangedDispatcher) a5;
        }
        IDispatcher a6 = a(C8934b0.NETWORK_STAGE_DISPATCHER);
        if (a6 instanceof NetworkStageDispatcher) {
            this.l = (NetworkStageDispatcher) a6;
        }
        IDispatcher a7 = a(C8934b0.IMAGE_STAGE_DISPATCHER);
        if (a7 instanceof ImageStageDispatcher) {
            this.m = (ImageStageDispatcher) a7;
        }
        IDispatcher a8 = a(C8934b0.PAGE_RENDER_DISPATCHER);
        if (a8 instanceof RenderDispatcher) {
            this.n = (RenderDispatcher) a8;
        }
        IDispatcher a9 = a(C8934b0.PAGE_LEAVE_DISPATCHER);
        if (a9 instanceof PageLeaveDispatcher) {
            this.o = (PageLeaveDispatcher) a9;
        }
        if (!ca0.c(this.j)) {
            this.j.addListener(this);
        }
        if (!ca0.c(this.h)) {
            this.h.addListener(this);
        }
        if (!ca0.c(this.g)) {
            this.g.addListener(this);
        }
        if (!ca0.c(this.i)) {
            this.i.addListener(this);
        }
        if (!ca0.c(this.k)) {
            this.k.addListener(this);
        }
        if (!ca0.c(this.l)) {
            this.l.addListener(this);
        }
        if (!ca0.c(this.m)) {
            this.m.addListener(this);
        }
        if (!ca0.c(this.n)) {
            this.n.addListener(this);
        }
        if (ca0.c(this.o)) {
            return;
        }
        this.o.addListener(this);
    }

    public void gc() {
        if (this.q) {
            this.E++;
        }
    }

    protected void h() {
        IProcedure createProcedure = tu1.b.createProcedure(dp2.a(f()), new C6817d.C6819b().g(false).k(true).i(true).h(null).f());
        this.e = createProcedure;
        createProcedure.begin();
        if (this.d.a() != null) {
            uu1.PROCEDURE_MANAGER.l(this.d.a(), this.d, this.e);
        } else if (this.d.e() != null) {
            uu1.PROCEDURE_MANAGER.n(this.d.e(), this.d, this.e);
        } else {
            uu1.PROCEDURE_MANAGER.o(this.d, this.e);
        }
    }

    protected boolean i(pp1 pp1Var) {
        return pp1Var != null && pp1Var == this.d;
    }

    protected void j(String str) {
    }

    public void k(boolean z) {
        this.p = z;
    }

    protected void l() {
        IDispatcher b = ca0.b(C8934b0.CUSTOM_PAGE_LIFECYCLE_DISPATCHER);
        if (b instanceof CustomPageLifecycleDispatcher) {
            this.f = (CustomPageLifecycleDispatcher) b;
        }
        if (ca0.c(this.f)) {
            return;
        }
        this.f.addListener(this);
    }

    public void onEvent(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("ext", obj);
        this.e.event(str, hashMap);
    }

    public void onImageStage(int i) {
        if (this.q) {
            if (i == 0) {
                this.r++;
            } else if (i == 1) {
                this.s++;
            } else if (i == 2) {
                this.t++;
            } else if (i == 3) {
                this.u++;
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.PageLeaveDispatcher.PageLeaveListener
    public void onLeave(pp1 pp1Var, int i) {
        if (i(pp1Var)) {
            if (i == -5) {
                j("jumpNextPage");
            } else if (i == -4) {
                j("back");
                b();
            } else if (i != -3) {
            } else {
                j("F2B");
                b();
            }
        }
    }

    public void onNetworkStage(int i) {
        if (this.q) {
            if (i == 0) {
                this.v++;
            } else if (i == 1) {
                this.w++;
            } else if (i == 2) {
                this.x++;
            } else if (i == 3) {
                this.y++;
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageAppear(pp1 pp1Var) {
        if (i(pp1Var)) {
            this.q = true;
            onPageAppear();
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageCreate(pp1 pp1Var, Map<String, Object> map) {
        if (i(pp1Var)) {
            g();
            d();
            onPageCreate(pp1Var.m(), pp1Var.p(), map);
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDestroy(pp1 pp1Var) {
        if (i(pp1Var)) {
            onPageDestroy();
            b();
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDisappear(pp1 pp1Var) {
        if (i(pp1Var)) {
            this.q = false;
            onPageDisappear();
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageInteractive(pp1 pp1Var, long j) {
        if (this.p && i(pp1Var)) {
            onPageInteractive(j);
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageLoadError(pp1 pp1Var, int i) {
        if (this.p && i(pp1Var)) {
            onPageLoadError(i);
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderPercent(pp1 pp1Var, float f, long j) {
        if (this.p && i(pp1Var)) {
            onPageRenderPercent(f, j);
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderStart(pp1 pp1Var, long j) {
        if (this.p && i(pp1Var)) {
            onPageRenderStart(j);
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageVisible(pp1 pp1Var, long j) {
        if (this.p && i(pp1Var)) {
            onPageVisible(j);
        }
    }

    public void onStage(String str, long j) {
        this.e.stage(str, j);
    }

    public ra(pp1 pp1Var) {
        this.p = true;
        this.q = true;
        this.z = new ArrayList();
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = new ArrayList();
        this.E = 0;
        this.d = pp1Var;
        l();
        h();
    }
}
