package cn.damai.trade.newtradeorder.ui.orderdetail.ui.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class LinearPullToRefreshView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final float FRICTION = 2.0f;
    static final int MANUAL_REFRESHING = 3;
    static final int PULL_TO_REFRESH = 0;
    static final int REFRESHING = 2;
    static final int RELEASE_TO_REFRESH = 1;
    private SmoothScrollRunnable currentSmoothScrollRunnable;
    private boolean disableScrollingWhileRefreshing;
    private final Handler handler;
    private int headerHeight;
    private PullToRefreshHeaderView headerLayout;
    private float initialMotionY;
    private boolean isBeingDragged;
    private boolean isPullToRefreshEnabled;
    private float lastAddMontionY;
    private float lastMotionX;
    private float lastMotionY;
    private OnRefreshListener onRefreshListener;
    private OnUpOrDownListener onUpOrDownListener;
    private int state;
    private int touchSlop;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnRefreshListener {
        void onRefresh();

        void pullEventMove(int i, int i2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnUpOrDownListener {
        void ondown();

        void onup();
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public final class SmoothScrollRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        static final int ANIMATION_DURATION_MS = 190;
        static final int ANIMATION_FPS = 16;
        private final Handler handler;
        private final int scrollFromY;
        private final int scrollToY;
        private boolean continueRunning = true;
        private long startTime = -1;
        private int currentY = -1;
        private final Interpolator interpolator = new AccelerateDecelerateInterpolator();

        public SmoothScrollRunnable(Handler handler, int i, int i2) {
            this.handler = handler;
            this.scrollFromY = i;
            this.scrollToY = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1376226182")) {
                ipChange.ipc$dispatch("-1376226182", new Object[]{this});
                return;
            }
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                int round = this.scrollFromY - Math.round((this.scrollFromY - this.scrollToY) * this.interpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 190, 1000L), 0L)) / 1000.0f));
                this.currentY = round;
                LinearPullToRefreshView.this.setHeaderScroll(round);
            }
            if (!this.continueRunning || this.scrollToY == this.currentY) {
                return;
            }
            this.handler.postDelayed(this, 16L);
        }

        public void stop() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1148602051")) {
                ipChange.ipc$dispatch("1148602051", new Object[]{this});
                return;
            }
            this.continueRunning = false;
            this.handler.removeCallbacks(this);
        }
    }

    public LinearPullToRefreshView(Context context) {
        super(context);
        this.isBeingDragged = false;
        this.state = 0;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.handler = new Handler();
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798673945")) {
            ipChange.ipc$dispatch("1798673945", new Object[]{this});
            return;
        }
        setOrientation(1);
        this.touchSlop = ViewConfiguration.getTouchSlop();
        this.headerLayout = PullToRefreshHeaderView.getInstance(getContext());
        addView(this.headerLayout, 0, new LinearLayout.LayoutParams(-1, -2));
        measureView(this.headerLayout);
        int measuredHeight = this.headerLayout.getMeasuredHeight();
        this.headerHeight = measuredHeight;
        setPadding(0, -measuredHeight, 0, 0);
    }

    private void measureView(View view) {
        int makeMeasureSpec;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1177837356")) {
            ipChange.ipc$dispatch("-1177837356", new Object[]{this, view});
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private boolean pullEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1074487600")) {
            return ((Boolean) ipChange.ipc$dispatch("-1074487600", new Object[]{this})).booleanValue();
        }
        int scrollY = getScrollY();
        int round = Math.round(Math.min(this.initialMotionY - this.lastMotionY, 0.0f) / FRICTION);
        setHeaderScroll(round);
        OnRefreshListener onRefreshListener = this.onRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.pullEventMove(2, round);
        }
        if (round != 0) {
            if (this.state == 0 && this.headerHeight < Math.abs(round)) {
                this.state = 1;
                this.headerLayout.onRelease();
                return true;
            } else if (this.state == 1 && this.headerHeight >= Math.abs(round)) {
                this.state = 0;
                this.headerLayout.onRelease();
                return true;
            }
        }
        if (Math.abs(round) >= this.headerHeight) {
            this.headerLayout.onMove(false, false, Math.abs(round));
        } else {
            this.headerLayout.onReset();
        }
        return scrollY != round;
    }

    protected final int getHeaderHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1313197974") ? ((Integer) ipChange.ipc$dispatch("-1313197974", new Object[]{this})).intValue() : this.headerHeight;
    }

    public final PullToRefreshHeaderView getHeaderLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "64896308") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("64896308", new Object[]{this}) : this.headerLayout;
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-449957980") ? ((Boolean) ipChange.ipc$dispatch("-449957980", new Object[]{this})).booleanValue() : this.disableScrollingWhileRefreshing;
    }

    public final boolean isPullToRefreshEnabled() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-927228355") ? ((Boolean) ipChange.ipc$dispatch("-927228355", new Object[]{this})).booleanValue() : this.isPullToRefreshEnabled;
    }

    public final boolean isRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880427108")) {
            return ((Boolean) ipChange.ipc$dispatch("-880427108", new Object[]{this})).booleanValue();
        }
        int i = this.state;
        return i == 2 || i == 3;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnUpOrDownListener onUpOrDownListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445950660")) {
            return ((Boolean) ipChange.ipc$dispatch("-1445950660", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.isPullToRefreshEnabled) {
            if (isRefreshing() && this.disableScrollingWhileRefreshing) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 3 && action != 1) {
                if (action == 0 || !this.isBeingDragged) {
                    if (action == 0) {
                        this.lastAddMontionY = motionEvent.getY();
                        float y = motionEvent.getY();
                        this.initialMotionY = y;
                        this.lastMotionY = y;
                        this.lastMotionX = motionEvent.getX();
                        this.isBeingDragged = false;
                    } else if (action == 2) {
                        if (motionEvent.getY() - this.lastAddMontionY > 20.0f) {
                            OnUpOrDownListener onUpOrDownListener2 = this.onUpOrDownListener;
                            if (onUpOrDownListener2 != null) {
                                onUpOrDownListener2.ondown();
                            }
                        } else if (motionEvent.getY() - this.lastAddMontionY < -20.0f && (onUpOrDownListener = this.onUpOrDownListener) != null) {
                            onUpOrDownListener.onup();
                        }
                        float y2 = motionEvent.getY();
                        float f = y2 - this.lastMotionY;
                        float abs = Math.abs(f);
                        float abs2 = Math.abs(motionEvent.getX() - this.lastMotionX);
                        if (abs > this.touchSlop && abs > abs2) {
                            if (f >= 1.0E-4f) {
                                this.lastMotionY = y2;
                                this.isBeingDragged = true;
                            } else if (f <= 1.0E-4f) {
                                this.lastMotionY = y2;
                                this.isBeingDragged = false;
                            }
                        }
                    }
                    return this.isBeingDragged;
                }
                return true;
            }
            this.isBeingDragged = false;
            return false;
        }
        return false;
    }

    public final void onRefreshComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109922508")) {
            ipChange.ipc$dispatch("2109922508", new Object[]{this});
        } else if (this.state != 0) {
            resetHeader();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r0 != 3) goto L25;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.LinearPullToRefreshView.$ipChange
            java.lang.String r1 = "-1595941272"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L1e
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r5] = r6
            r2[r4] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L1e:
            boolean r0 = r6.isPullToRefreshEnabled
            if (r0 != 0) goto L23
            return r5
        L23:
            boolean r0 = r6.isRefreshing()
            if (r0 == 0) goto L2e
            boolean r0 = r6.disableScrollingWhileRefreshing
            if (r0 == 0) goto L2e
            return r4
        L2e:
            int r0 = r7.getAction()
            if (r0 != 0) goto L3b
            int r0 = r7.getEdgeFlags()
            if (r0 == 0) goto L3b
            return r5
        L3b:
            int r0 = r7.getAction()
            if (r0 == 0) goto L86
            if (r0 == r4) goto L57
            if (r0 == r3) goto L49
            r7 = 3
            if (r0 == r7) goto L57
            goto L85
        L49:
            boolean r0 = r6.isBeingDragged
            if (r0 == 0) goto L85
            float r7 = r7.getY()
            r6.lastMotionY = r7
            r6.pullEvent()
            return r4
        L57:
            boolean r7 = r6.isBeingDragged
            if (r7 == 0) goto L85
            r6.isBeingDragged = r5
            int r7 = r6.state
            if (r7 != r4) goto L7a
            cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.LinearPullToRefreshView$OnRefreshListener r7 = r6.onRefreshListener
            if (r7 == 0) goto L7a
            r6.setRefreshingInternal(r4)
            cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView r7 = r6.headerLayout
            r0 = 10000(0x2710, float:1.4013E-41)
            r7.onMove(r5, r5, r0)
            cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView r7 = r6.headerLayout
            r7.onRefresh()
            cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.LinearPullToRefreshView$OnRefreshListener r7 = r6.onRefreshListener
            r7.onRefresh()
            goto L84
        L7a:
            r6.smoothScrollTo(r5)
            cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.LinearPullToRefreshView$OnRefreshListener r7 = r6.onRefreshListener
            if (r7 == 0) goto L84
            r7.pullEventMove(r4, r5)
        L84:
            return r4
        L85:
            return r5
        L86:
            float r7 = r7.getY()
            r6.initialMotionY = r7
            r6.lastMotionY = r7
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.LinearPullToRefreshView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void resetHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "35344645")) {
            ipChange.ipc$dispatch("35344645", new Object[]{this});
            return;
        }
        this.state = 0;
        this.isBeingDragged = false;
        PullToRefreshHeaderView pullToRefreshHeaderView = this.headerLayout;
        if (pullToRefreshHeaderView != null) {
            pullToRefreshHeaderView.onReset();
        }
        smoothScrollTo(0);
        this.headerLayout.onComplete();
    }

    public final void setDisableScrollingWhileRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-668137964")) {
            ipChange.ipc$dispatch("-668137964", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.disableScrollingWhileRefreshing = z;
        }
    }

    protected final void setHeaderScroll(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727254754")) {
            ipChange.ipc$dispatch("-727254754", new Object[]{this, Integer.valueOf(i)});
        } else {
            scrollTo(0, i);
        }
    }

    public final void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792353678")) {
            ipChange.ipc$dispatch("1792353678", new Object[]{this, onRefreshListener});
        } else {
            this.onRefreshListener = onRefreshListener;
        }
    }

    public final void setOnUpOrDownListener(OnUpOrDownListener onUpOrDownListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145363856")) {
            ipChange.ipc$dispatch("-2145363856", new Object[]{this, onUpOrDownListener});
        } else {
            this.onUpOrDownListener = onUpOrDownListener;
        }
    }

    public final void setPullToRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362227493")) {
            ipChange.ipc$dispatch("-362227493", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isPullToRefreshEnabled = z;
        }
    }

    public final void setRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508947576")) {
            ipChange.ipc$dispatch("1508947576", new Object[]{this});
            return;
        }
        setRefreshing(true);
        this.headerLayout.onRefresh();
    }

    protected void setRefreshingInternal(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959629497")) {
            ipChange.ipc$dispatch("1959629497", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.state = 2;
        PullToRefreshHeaderView pullToRefreshHeaderView = this.headerLayout;
        if (pullToRefreshHeaderView != null) {
            pullToRefreshHeaderView.onRefresh();
        }
        if (z) {
            smoothScrollTo(-this.headerHeight);
        }
    }

    protected final void smoothScrollTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215396112")) {
            ipChange.ipc$dispatch("-1215396112", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        SmoothScrollRunnable smoothScrollRunnable = this.currentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (getScrollY() != i) {
            SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(this.handler, getScrollY(), i);
            this.currentSmoothScrollRunnable = smoothScrollRunnable2;
            this.handler.post(smoothScrollRunnable2);
        }
    }

    public final void setRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-467219620")) {
            ipChange.ipc$dispatch("-467219620", new Object[]{this, Boolean.valueOf(z)});
        } else if (isRefreshing()) {
        } else {
            setRefreshingInternal(z);
            this.state = 3;
        }
    }

    public LinearPullToRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isBeingDragged = false;
        this.state = 0;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.handler = new Handler();
        init();
    }
}
