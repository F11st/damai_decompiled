package com.taobao.monitor.impl.data.visible;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.application.common.IPageListener;
import com.taobao.application.common.impl.C6674a;
import com.taobao.monitor.impl.data.IExecutor;
import com.taobao.monitor.impl.data.PageLoadCalculate;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import com.youku.arch.v3.event.Subject;
import java.lang.ref.WeakReference;
import tb.C8934b0;
import tb.ca0;
import tb.e30;
import tb.fu0;
import tb.ho2;
import tb.pb1;
import tb.pp1;
import tb.sp1;
import tb.sy2;
import tb.uu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class VisibleCalculator implements PageLoadCalculate.IPageLoadPercent, WindowEventDispatcher.OnEventListener, Runnable {
    private static final String ACTIVITY_FRAGMENT_PAGE_NAME = "page_name";
    private static final String ACTIVITY_FRAGMENT_TYPE = "type";
    private static final String ACTIVITY_FRAGMENT_VISIBLE_ACTION = "ACTIVITY_FRAGMENT_VISIBLE_ACTION";
    private static final String ACTIVITY_FRAGMENT_VISIBLE_STATUS = "status";
    private static final int DRAW_TIME_OUT = 20000;
    public static final float PAGE_LOAD_PERCENT = 0.7f;
    private static final String TAG = "VisibleCollector";
    private float DownX;
    private float DownY;
    private int count;
    private volatile boolean isPageLoadCreated;
    private float moveX;
    private float moveY;
    private float oldDrawPercent;
    private final pp1 page;
    private final IPageListener pageListener;
    private IExecutor pageLoadCalculate;
    private final String pageName;
    private final Runnable timeoutRunnable;
    private boolean usableDispatched;
    private boolean visibleDispatched;
    private RenderDispatcher usableVisibleDispatcher = null;
    private WindowEventDispatcher windowEventDispatcher = null;
    private boolean isStopped = false;
    private int lastPageRenderError = 1;

    public VisibleCalculator(pp1 pp1Var) {
        IPageListener e = C6674a.g().e();
        this.pageListener = e;
        this.timeoutRunnable = new Runnable() { // from class: com.taobao.monitor.impl.data.visible.VisibleCalculator.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ca0.c(VisibleCalculator.this.usableVisibleDispatcher) && VisibleCalculator.this.lastPageRenderError == 1) {
                    VisibleCalculator.this.usableVisibleDispatcher.g(VisibleCalculator.this.page, -1);
                    VisibleCalculator.this.lastPageRenderError = -1;
                }
                VisibleCalculator.this.releasePageLoadCalculate();
            }
        };
        this.isPageLoadCreated = false;
        this.oldDrawPercent = 0.0f;
        this.visibleDispatched = false;
        this.count = 0;
        this.usableDispatched = false;
        this.DownX = 0.0f;
        this.DownY = 0.0f;
        this.moveX = 0.0f;
        this.moveY = 0.0f;
        if (pp1Var != null) {
            this.page = pp1Var;
            String m = pp1Var.m();
            this.pageName = m;
            e.onPageChanged(m, 0, ho2.a());
            pb1.d(TAG, "visibleStart", m);
            initDispatcher();
            return;
        }
        throw new IllegalArgumentException("Visible calculate must page not null");
    }

    private void dispatchVisibleChanged(long j) {
        if (this.visibleDispatched || this.isStopped) {
            return;
        }
        if (!ca0.c(this.usableVisibleDispatcher)) {
            e30.a(TAG, this.pageName, "visible", Long.valueOf(j));
            this.usableVisibleDispatcher.j(this.page, j);
            this.usableVisibleDispatcher.g(this.page, 0);
            this.lastPageRenderError = 0;
        }
        this.pageListener.onPageChanged(this.pageName, 2, j);
        releasePageLoadCalculate();
        this.visibleDispatched = true;
    }

    private void doSendPageFinishedEvent() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(fu0.e().a());
        Intent intent = new Intent(ACTIVITY_FRAGMENT_VISIBLE_ACTION);
        intent.putExtra(ACTIVITY_FRAGMENT_PAGE_NAME, this.pageName);
        if (this.page.a() != null) {
            intent.putExtra("type", "activity");
        } else if (this.page.e() != null) {
            intent.putExtra("type", Subject.FRAGMENT);
        } else {
            intent.putExtra("type", "unknown");
        }
        intent.putExtra("status", 1);
        localBroadcastManager.sendBroadcastSync(intent);
        pb1.d(TAG, "doSendPageFinishedEvent:" + this.pageName);
    }

    private int getScaledTouchSlop() {
        Context c = this.page.c();
        if (c != null) {
            return ViewConfiguration.get(c).getScaledTouchSlop();
        }
        return Integer.MAX_VALUE;
    }

    private boolean isMainPage(pp1 pp1Var) {
        if (pp1Var.t()) {
            return "com.taobao.tao.TBMainActivity".equals(pp1Var.h());
        }
        if (pp1Var.v()) {
            return "com.taobao.tao.homepage.HomepageFragment".equals(pp1Var.h());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releasePageLoadCalculate() {
        this.isStopped = true;
        if (this.pageLoadCalculate != null) {
            synchronized (this) {
                if (this.pageLoadCalculate != null) {
                    fu0.e().d().removeCallbacks(this.timeoutRunnable);
                    IExecutor iExecutor = this.pageLoadCalculate;
                    if (iExecutor != null) {
                        iExecutor.stop();
                    }
                    doSendPageFinishedEvent();
                    this.pageLoadCalculate = null;
                }
            }
        }
        if (ca0.c(this.windowEventDispatcher)) {
            return;
        }
        this.windowEventDispatcher.removeListener(this);
    }

    protected void dispatchUsableChanged(long j) {
        if (this.usableDispatched) {
            return;
        }
        e30.a(TAG, "usable", this.pageName);
        pb1.d(TAG, this.pageName, " usable", Long.valueOf(j));
        if (!ca0.c(this.usableVisibleDispatcher)) {
            this.usableVisibleDispatcher.f(this.page, j);
        }
        releasePageLoadCalculate();
        this.pageListener.onPageChanged(this.pageName, 3, j);
        this.usableDispatched = true;
    }

    public void errorNotify(int i) {
        if (this.lastPageRenderError == 1 && !ca0.c(this.usableVisibleDispatcher)) {
            this.usableVisibleDispatcher.g(this.page, i);
            this.lastPageRenderError = i;
        }
        this.isStopped = true;
    }

    protected void initDispatcher() {
        IDispatcher a = C8934b0.a(C8934b0.PAGE_RENDER_DISPATCHER);
        if (a instanceof RenderDispatcher) {
            this.usableVisibleDispatcher = (RenderDispatcher) a;
        }
        IDispatcher b = ca0.b(C8934b0.WINDOW_EVENT_DISPATCHER);
        if (b instanceof WindowEventDispatcher) {
            WindowEventDispatcher windowEventDispatcher = (WindowEventDispatcher) b;
            this.windowEventDispatcher = windowEventDispatcher;
            windowEventDispatcher.addListener(this);
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j) {
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j) {
        if (this.isStopped || this.visibleDispatched || this.lastPageRenderError != 1 || !sy2.a(activity, this.page.o())) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.DownX = motionEvent.getX();
            this.DownY = motionEvent.getY();
            this.moveX = 0.0f;
            this.moveY = 0.0f;
        } else if (action != 1) {
            if (action != 2) {
                return;
            }
            this.moveX += Math.abs(motionEvent.getX() - this.DownX);
            this.moveY += Math.abs(motionEvent.getY() - this.DownY);
            this.DownX = motionEvent.getX();
            this.DownY = motionEvent.getY();
        } else {
            float scaledTouchSlop = getScaledTouchSlop();
            if (this.moveX > scaledTouchSlop || this.moveY > scaledTouchSlop) {
                releasePageLoadCalculate();
                if (this.lastPageRenderError != 1 || ca0.c(this.usableVisibleDispatcher)) {
                    return;
                }
                this.usableVisibleDispatcher.g(this.page, -2);
                this.lastPageRenderError = -2;
            }
        }
    }

    @Override // com.taobao.monitor.impl.data.PageLoadCalculate.IPageLoadPercent
    public void pageLoadEndByTag(WeakReference<View> weakReference) {
        this.page.F(weakReference);
        uu1.PROCEDURE_MANAGER.t(this.page, weakReference);
    }

    @Override // com.taobao.monitor.impl.data.PageLoadCalculate.IPageLoadPercent
    public void pageLoadPercent(float f, long j) {
        String h;
        pb1.d(TAG, "visiblePercent", Float.valueOf(f), this.pageName);
        if (!this.page.t() && !this.page.v()) {
            h = this.page.m();
        } else {
            h = this.page.h();
        }
        float b = sp1.b(h);
        float f2 = isMainPage(this.page) ? 0.8f : 0.7f;
        if (Math.abs(f - this.oldDrawPercent) > 0.05f || f >= f2 || f >= b) {
            if (!ca0.c(this.usableVisibleDispatcher)) {
                this.usableVisibleDispatcher.h(this.page, f, ho2.a());
            }
            e30.a(TAG, "visiblePercent", Float.valueOf(f), this.pageName);
            if ((f >= f2 || f >= b) && !this.visibleDispatched && !this.isStopped) {
                dispatchVisibleChanged(j);
                run();
            }
            this.oldDrawPercent = f;
        }
    }

    @Override // com.taobao.monitor.impl.data.PageLoadCalculate.IPageLoadPercent
    public void pageRootViewChanged(View view) {
        this.page.L(view);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.count + 1;
        this.count = i;
        if (i > 2) {
            dispatchUsableChanged(ho2.a());
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this);
        handler.postDelayed(this, 16L);
    }

    public void startPageCalculateExecutor(View view) {
        String h;
        if (this.isPageLoadCreated || !this.page.w()) {
            return;
        }
        if (this.isStopped) {
            if (ca0.c(this.usableVisibleDispatcher) || this.lastPageRenderError != 1) {
                return;
            }
            this.usableVisibleDispatcher.g(this.page, -6);
            this.lastPageRenderError = -6;
            return;
        }
        if (!ca0.c(this.usableVisibleDispatcher)) {
            this.usableVisibleDispatcher.i(this.page, ho2.a());
        }
        if (!this.page.t() && !this.page.v()) {
            h = this.page.m();
        } else {
            h = this.page.h();
        }
        PageLoadCalculate pageLoadCalculate = new PageLoadCalculate(view, h);
        this.pageLoadCalculate = pageLoadCalculate;
        pageLoadCalculate.setLifecycle(this);
        this.pageLoadCalculate.execute();
        fu0.e().d().postDelayed(this.timeoutRunnable, 20000L);
        this.pageListener.onPageChanged(this.pageName, 1, ho2.a());
        this.isPageLoadCreated = true;
    }

    public void stopPageCalculateExecutor() {
        releasePageLoadCalculate();
    }
}
