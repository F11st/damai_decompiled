package tb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.RequiresApi;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.procedure.IPage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
@RequiresApi(api = 16)
/* loaded from: classes11.dex */
public class ud2 implements Choreographer.FrameCallback, ViewTreeObserver.OnScrollChangedListener {
    public static final int BLOCK_FRAME_TIME = 300;
    public static final int FROZEN_FRAME_TIME = 700;
    public static final int JANK_FRAME_TIME = 32;
    public static final int SLOW_FRAME_TIME = 17;
    private FPSDispatcher a;
    private final WeakReference<Activity> b;
    private final WeakReference<pp1> c;
    private ArrayList<FrameMetrics> k;
    private b o;
    private boolean d = false;
    private boolean e = true;
    private long f = 0;
    public int g = 0;
    private int h = 0;
    public int i = 0;
    private int j = 0;
    private long l = -1;
    private boolean m = false;
    private boolean n = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @RequiresApi(24)
    /* loaded from: classes11.dex */
    public class b implements Window.OnFrameMetricsAvailableListener {
        private b() {
        }

        @RequiresApi(24)
        @SuppressLint({"WrongConstant"})
        private void a(FrameMetrics frameMetrics) {
            FrameMetrics frameMetrics2 = new FrameMetrics(frameMetrics);
            pb1.b("SlideFrameCollector", "FrameMetrics", "=======================================================");
            pb1.b("SlideFrameCollector", "FrameMetrics", "每一帧的渲染流程为", "Vsync发出->抛主线程->主线程执行：处理输入事件->处理动画->measure->layout->draw->render线程同步->向GPU发送绘制命令->交换缓冲队列");
            pb1.b("SlideFrameCollector", "FrameMetrics", "绘制的该帧是否是第一帧, 0 不是, 1 是，FIRST_DRAW_FRAME : " + frameMetrics2.getMetric(9));
            pb1.b("SlideFrameCollector", "FrameMetrics", "UI 线程响应并开始处理渲染的等待时间 UNKNOWN_DELAY_DURATION : " + (frameMetrics2.getMetric(0) / 1000000));
            pb1.b("SlideFrameCollector", "FrameMetrics", "处理输入事件 INPUT_HANDLING_DURATION : " + (frameMetrics2.getMetric(1) / 1000000));
            pb1.b("SlideFrameCollector", "FrameMetrics", "动画执行回调时间 ANIMATION_DURATION : " + (frameMetrics2.getMetric(2) / 1000000));
            pb1.b("SlideFrameCollector", "FrameMetrics", "measure和layout耗时 和LAYOUT_MEASURE_DURATION : " + (frameMetrics2.getMetric(3) / 1000000));
            pb1.b("SlideFrameCollector", "FrameMetrics", "draw 耗时 DRAW_DURATION : " + (frameMetrics2.getMetric(4) / 1000000));
            pb1.b("SlideFrameCollector", "FrameMetrics", "render线程同步耗时 SYNC_DURATION : " + (frameMetrics2.getMetric(5) / 1000000));
            pb1.b("SlideFrameCollector", "FrameMetrics", "向 GPU 发送绘制命令花费的时间 COMMAND_ISSUE_DURATION : " + (frameMetrics2.getMetric(6) / 1000000));
            pb1.b("SlideFrameCollector", "FrameMetrics", "交换缓冲队列耗时 SWAP_BUFFERS_DURATION : " + (frameMetrics2.getMetric(7) / 1000000));
            pb1.b("SlideFrameCollector", "FrameMetrics", "总耗时 TOTAL_DURATION : " + (frameMetrics2.getMetric(8) / 1000000));
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                pb1.b("SlideFrameCollector", "FrameMetrics", "vsync 信号发出的时间戳 VSYNC_TIMESTAMP : " + frameMetrics2.getMetric(11));
            }
            if (i >= 26) {
                pb1.b("SlideFrameCollector", "FrameMetrics", "在主线程开始执行回调的时间 INTENDED_VSYNC_TIMESTAMP : " + frameMetrics2.getMetric(10));
            }
            pb1.b("SlideFrameCollector", "卡顿帧主要原因：" + c(frameMetrics2, null, frameMetrics2.getMetric(8)));
            pb1.b("SlideFrameCollector", "FrameMetrics", "=======================================================");
            pb1.b("SlideFrameCollector", "FrameMetrics", StringUtils.LF);
        }

        private void b(FrameMetrics frameMetrics, pp1 pp1Var, long j) {
            if (pp1Var == null) {
                return;
            }
            long j2 = (long) (j * 0.3d);
            if (frameMetrics.getMetric(0) > j2) {
                pp1Var.C("UNKNOWN_DELAY");
            }
            if (frameMetrics.getMetric(1) > j2) {
                pp1Var.C("INPUT_HANDLING");
            }
            if (frameMetrics.getMetric(2) > j2) {
                pp1Var.C("ANIMATION");
            }
            if (frameMetrics.getMetric(3) > j2) {
                pp1Var.C("LAYOUT_MEASURE");
            }
            if (frameMetrics.getMetric(4) > j2) {
                pp1Var.C("DRAW");
            }
            if (frameMetrics.getMetric(5) > j2) {
                pp1Var.C("SYNC");
            }
            if (frameMetrics.getMetric(6) > j2) {
                pp1Var.C("COMMAND_ISSUE");
            }
            if (frameMetrics.getMetric(7) > j2) {
                pp1Var.C("SWAP_BUFFERS");
            }
        }

        private String c(FrameMetrics frameMetrics, pp1 pp1Var, long j) {
            String str;
            String str2;
            long j2 = j / 2;
            if (frameMetrics.getMetric(0) > j2) {
                str2 = "UNKNOWN_DELAY";
                str = "主线程卡顿";
            } else {
                str = "default";
                str2 = "DEFAULT";
            }
            if (frameMetrics.getMetric(1) > j2) {
                str2 = "INPUT_HANDLING";
                str = "输入事件处理耗时过长";
            }
            if (frameMetrics.getMetric(2) > j2) {
                str2 = "ANIMATION";
                str = "动画处理耗时过长";
            }
            if (frameMetrics.getMetric(3) > j2) {
                str2 = "LAYOUT_MEASURE";
                str = "layout 和 measure 太慢，布局过于复杂";
            }
            if (frameMetrics.getMetric(4) > j2) {
                str2 = "DRAW";
                str = "draw 耗时过长";
            }
            if (frameMetrics.getMetric(5) > j2) {
                str2 = "SYNC";
                str = "render线程同步耗时过长";
            }
            if (frameMetrics.getMetric(6) > j2) {
                str2 = "COMMAND_ISSUE";
                str = "向 GPU 发送绘制命令花费的耗时过长";
            }
            if (frameMetrics.getMetric(7) > j2) {
                str2 = "SWAP_BUFFERS";
                str = "交换缓冲队列耗时过长";
            }
            if (pp1Var != null) {
                pp1Var.E(str2);
                if ("DEFAULT".equals(str2)) {
                    b(frameMetrics, pp1Var, j);
                }
            }
            return str;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        @RequiresApi(24)
        public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
            long metric = frameMetrics.getMetric(8);
            long j = metric / 1000000;
            pp1 pp1Var = ud2.this.c == null ? null : (pp1) ud2.this.c.get();
            if (j > jd0.z) {
                a(frameMetrics);
            }
            if (pp1Var == null || frameMetrics.getMetric(9) == 0) {
                return;
            }
            pp1Var.r();
            if (j > 300) {
                c(frameMetrics, pp1Var, metric);
                pp1Var.q();
            }
            if (j > 700) {
                pp1Var.s();
            }
        }
    }

    public ud2(Activity activity, IPage iPage) {
        this.b = new WeakReference<>(activity);
        if (iPage instanceof pp1) {
            this.c = new WeakReference<>((pp1) iPage);
        } else {
            this.c = null;
        }
        c();
        b(activity);
    }

    private void b(Activity activity) {
        Window window;
        View decorView;
        int i = Build.VERSION.SDK_INT;
        if (i < 16 || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnScrollChangedListener(this);
            if (jd0.A && i >= 24) {
                if (this.o == null) {
                    this.o = new b();
                }
                window.addOnFrameMetricsAvailableListener(this.o, fu0.e().d());
            }
            d();
        }
    }

    private void c() {
        IDispatcher b2 = ca0.b(b0.ACTIVITY_FPS_DISPATCHER);
        if (b2 instanceof FPSDispatcher) {
            this.a = (FPSDispatcher) b2;
        }
    }

    @RequiresApi(16)
    private void d() {
        if (!jd0.w || this.d) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(this);
    }

    private void e(long j) {
        long j2 = j - this.l;
        this.l = j;
        if (this.f + j2 > 1000) {
            if (!ca0.c(this.a)) {
                this.a.f(this.j, this.h, this.i, this.g, this.k);
            }
            this.f = 0L;
            this.j = 0;
            this.h = 0;
            this.i = 0;
            this.g = 0;
            this.m = false;
            this.k = null;
            if (!this.n) {
                return;
            }
        }
        this.n = false;
        if (j2 > 17) {
            this.g++;
            if (j2 > 32) {
                this.h++;
            }
            if (j2 > 700) {
                this.i++;
            }
        }
        this.f += j2;
        this.j++;
    }

    @Override // android.view.Choreographer.FrameCallback
    @RequiresApi(16)
    public void doFrame(long j) {
        long j2 = j / 1000000;
        d();
        if (this.e) {
            this.l = j2;
            this.e = false;
            this.n = false;
        } else if (!this.m) {
            this.l = j2;
            this.n = false;
        } else {
            e(j2);
        }
    }

    public void f() {
        WeakReference<Activity> weakReference;
        Activity activity;
        Window window;
        ViewTreeObserver viewTreeObserver;
        b bVar;
        this.d = true;
        int i = Build.VERSION.SDK_INT;
        if (i < 16 || (weakReference = this.b) == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        if (i >= 24 && (bVar = this.o) != null) {
            window.removeOnFrameMetricsAvailableListener(bVar);
        }
        Choreographer.getInstance().removeFrameCallback(this);
        View decorView = window.getDecorView();
        if (decorView == null || (viewTreeObserver = decorView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    @RequiresApi(16)
    public void onScrollChanged() {
        this.m = true;
        this.n = true;
    }
}
