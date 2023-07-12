package cn.damai.baseview.pull.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import cn.damai.uikit.R$string;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final float FRICTION = 2.0f;
    static final int MANUAL_REFRESHING = 3;
    public static final int MODE_BOTH = 3;
    public static final int MODE_PULL_DOWN_TO_REFRESH = 1;
    public static final int MODE_PULL_UP_TO_REFRESH = 2;
    static final int PULL_TO_REFRESH = 0;
    static final int REFRESHING = 2;
    static final int RELEASE_TO_REFRESH = 1;
    private int currentMode;
    private PullToRefreshBase<T>.SmoothScrollRunnable currentSmoothScrollRunnable;
    private boolean disableScrollingWhileRefreshing;
    private LoadingLayout footerLayout;
    private final Handler handler;
    private int headerHeight;
    private LoadingLayout headerLayout;
    private float initialMotionY;
    private boolean isBeingDragged;
    private boolean isPullToRefreshEnabled;
    private float lastAddMontionY;
    private float lastMotionX;
    private float lastMotionY;
    private int mode;
    private OnRefreshListener onRefreshListener;
    private OnUpOrDownListener onUpOrDownListener;
    T refreshableView;
    private int state;
    private int touchSlop;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnUpOrDownListener {
        void ondown();

        void onup();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
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
            if (AndroidInstantRuntime.support(ipChange, "590523708")) {
                ipChange.ipc$dispatch("590523708", new Object[]{this});
                return;
            }
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                int round = this.scrollFromY - Math.round((this.scrollFromY - this.scrollToY) * this.interpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 190, 1000L), 0L)) / 1000.0f));
                this.currentY = round;
                PullToRefreshBase.this.setHeaderScroll(round);
            }
            if (!this.continueRunning || this.scrollToY == this.currentY) {
                return;
            }
            this.handler.postDelayed(this, 16L);
        }

        public void stop() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1988306497")) {
                ipChange.ipc$dispatch("1988306497", new Object[]{this});
                return;
            }
            this.continueRunning = false;
            this.handler.removeCallbacks(this);
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.isBeingDragged = false;
        this.state = 0;
        this.mode = 1;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.handler = new Handler();
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002716255")) {
            ipChange.ipc$dispatch("-1002716255", new Object[]{this, context, attributeSet});
            return;
        }
        setOrientation(1);
        this.touchSlop = ViewConfiguration.getTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PullToRefresh);
        int i2 = R$styleable.PullToRefresh_mode;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mode = obtainStyledAttributes.getInteger(i2, 1);
        }
        T createRefreshableView = createRefreshableView(context, attributeSet);
        this.refreshableView = createRefreshableView;
        addRefreshableView(context, createRefreshableView);
        String string = context.getString(R$string.pull_to_refresh_pull_label);
        String string2 = context.getString(R$string.pull_to_refresh_refreshing_label);
        String string3 = context.getString(R$string.pull_to_refresh_release_label);
        int i3 = this.mode;
        if (i3 == 1 || i3 == 3) {
            i = -1;
            LoadingLayout loadingLayout = new LoadingLayout(context, 1, string3, string, string2);
            this.headerLayout = loadingLayout;
            addView(loadingLayout, 0, new LinearLayout.LayoutParams(-1, -2));
            measureView(this.headerLayout);
            this.headerHeight = this.headerLayout.getMeasuredHeight();
        } else {
            i = -1;
        }
        int i4 = this.mode;
        if (i4 == 2 || i4 == 3) {
            LoadingLayout loadingLayout2 = new LoadingLayout(context, 2, string3, string, string2);
            this.footerLayout = loadingLayout2;
            addView(loadingLayout2, new LinearLayout.LayoutParams(i, -2));
            measureView(this.footerLayout);
            this.headerHeight = this.footerLayout.getMeasuredHeight();
        }
        int i5 = R$styleable.PullToRefresh_headerTextColor;
        if (obtainStyledAttributes.hasValue(i5)) {
            int color = obtainStyledAttributes.getColor(i5, -16777216);
            LoadingLayout loadingLayout3 = this.headerLayout;
            if (loadingLayout3 != null) {
                loadingLayout3.setTextColor(color);
            }
            LoadingLayout loadingLayout4 = this.footerLayout;
            if (loadingLayout4 != null) {
                loadingLayout4.setTextColor(color);
            }
        }
        int i6 = R$styleable.PullToRefresh_headerBackground;
        if (obtainStyledAttributes.hasValue(i6)) {
            setBackgroundResource(obtainStyledAttributes.getResourceId(i6, i));
        }
        int i7 = R$styleable.PullToRefresh_adapterViewBackground;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.refreshableView.setBackgroundResource(obtainStyledAttributes.getResourceId(i7, i));
        }
        obtainStyledAttributes.recycle();
        int i8 = this.mode;
        if (i8 == 2) {
            setPadding(0, 0, 0, -this.headerHeight);
        } else if (i8 != 3) {
            setPadding(0, -this.headerHeight, 0, 0);
        } else {
            int i9 = this.headerHeight;
            setPadding(0, -i9, 0, -i9);
        }
        int i10 = this.mode;
        if (i10 != 3) {
            this.currentMode = i10;
        }
    }

    private boolean isReadyForPull() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891972230")) {
            return ((Boolean) ipChange.ipc$dispatch("-891972230", new Object[]{this})).booleanValue();
        }
        int i = this.mode;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                return isReadyForPullUp() || isReadyForPullDown();
            }
            return isReadyForPullUp();
        }
        return isReadyForPullDown();
    }

    private void measureView(View view) {
        int makeMeasureSpec;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1324662806")) {
            ipChange.ipc$dispatch("1324662806", new Object[]{this, view});
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
        int round;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392261710")) {
            return ((Boolean) ipChange.ipc$dispatch("1392261710", new Object[]{this})).booleanValue();
        }
        int scrollY = getScrollY();
        if (this.currentMode != 2) {
            round = Math.round(Math.min(this.initialMotionY - this.lastMotionY, 0.0f) / FRICTION);
        } else {
            round = Math.round(Math.max(this.initialMotionY - this.lastMotionY, 0.0f) / FRICTION);
        }
        setHeaderScroll(round);
        if (round != 0) {
            if (this.state == 0 && this.headerHeight < Math.abs(round)) {
                this.state = 1;
                int i = this.currentMode;
                if (i == 1) {
                    this.headerLayout.releaseToRefresh();
                } else if (i == 2) {
                    this.footerLayout.releaseToRefresh();
                }
                return true;
            } else if (this.state == 1 && this.headerHeight >= Math.abs(round)) {
                this.state = 0;
                int i2 = this.currentMode;
                if (i2 == 1) {
                    this.headerLayout.pullToRefresh();
                } else if (i2 == 2) {
                    this.footerLayout.pullToRefresh();
                }
                return true;
            }
        }
        return scrollY != round;
    }

    protected void addRefreshableView(Context context, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685062468")) {
            ipChange.ipc$dispatch("-685062468", new Object[]{this, context, t});
        } else {
            addView(t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public final T getAdapterView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2068928433") ? (T) ipChange.ipc$dispatch("-2068928433", new Object[]{this}) : this.refreshableView;
    }

    protected final int getCurrentMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-437738472") ? ((Integer) ipChange.ipc$dispatch("-437738472", new Object[]{this})).intValue() : this.currentMode;
    }

    protected final LoadingLayout getFooterLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1018681871") ? (LoadingLayout) ipChange.ipc$dispatch("-1018681871", new Object[]{this}) : this.footerLayout;
    }

    protected final int getHeaderHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "313701736") ? ((Integer) ipChange.ipc$dispatch("313701736", new Object[]{this})).intValue() : this.headerHeight;
    }

    protected final LoadingLayout getHeaderLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-415403421") ? (LoadingLayout) ipChange.ipc$dispatch("-415403421", new Object[]{this}) : this.headerLayout;
    }

    protected final int getMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1131908231") ? ((Integer) ipChange.ipc$dispatch("-1131908231", new Object[]{this})).intValue() : this.mode;
    }

    public final T getRefreshableView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1455869527") ? (T) ipChange.ipc$dispatch("-1455869527", new Object[]{this}) : this.refreshableView;
    }

    public final boolean hasPullFromTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1195935651") ? ((Boolean) ipChange.ipc$dispatch("1195935651", new Object[]{this})).booleanValue() : this.currentMode != 2;
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-509955806") ? ((Boolean) ipChange.ipc$dispatch("-509955806", new Object[]{this})).booleanValue() : this.disableScrollingWhileRefreshing;
    }

    public final boolean isPullToRefreshEnabled() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "223420287") ? ((Boolean) ipChange.ipc$dispatch("223420287", new Object[]{this})).booleanValue() : this.isPullToRefreshEnabled;
    }

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public final boolean isRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-842167458")) {
            return ((Boolean) ipChange.ipc$dispatch("-842167458", new Object[]{this})).booleanValue();
        }
        int i = this.state;
        return i == 2 || i == 3;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnUpOrDownListener onUpOrDownListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137023034")) {
            return ((Boolean) ipChange.ipc$dispatch("1137023034", new Object[]{this, motionEvent})).booleanValue();
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
                        if (isReadyForPull()) {
                            float y = motionEvent.getY();
                            this.initialMotionY = y;
                            this.lastMotionY = y;
                            this.lastMotionX = motionEvent.getX();
                            this.isBeingDragged = false;
                        }
                    } else if (action == 2) {
                        if (motionEvent.getY() - this.lastAddMontionY > 20.0f) {
                            OnUpOrDownListener onUpOrDownListener2 = this.onUpOrDownListener;
                            if (onUpOrDownListener2 != null) {
                                onUpOrDownListener2.ondown();
                            }
                        } else if (motionEvent.getY() - this.lastAddMontionY < -20.0f && (onUpOrDownListener = this.onUpOrDownListener) != null) {
                            onUpOrDownListener.onup();
                        }
                        if (isReadyForPull()) {
                            float y2 = motionEvent.getY();
                            float f = y2 - this.lastMotionY;
                            float abs = Math.abs(f);
                            float abs2 = Math.abs(motionEvent.getX() - this.lastMotionX);
                            if (abs > this.touchSlop && abs > abs2) {
                                int i = this.mode;
                                if ((i == 1 || i == 3) && f >= 1.0E-4f && isReadyForPullDown()) {
                                    this.lastMotionY = y2;
                                    this.isBeingDragged = true;
                                    if (this.mode == 3) {
                                        this.currentMode = 1;
                                    }
                                } else {
                                    int i2 = this.mode;
                                    if ((i2 == 2 || i2 == 3) && f <= 1.0E-4f && isReadyForPullUp()) {
                                        this.lastMotionY = y2;
                                        this.isBeingDragged = true;
                                        if (this.mode == 3) {
                                            this.currentMode = 2;
                                        }
                                    }
                                }
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
        if (AndroidInstantRuntime.support(ipChange, "-2102519222")) {
            ipChange.ipc$dispatch("-2102519222", new Object[]{this});
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
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.baseview.pull.lib.PullToRefreshBase.$ipChange
            java.lang.String r1 = "-2145477718"
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
            boolean r0 = r6.isPullToRefreshEnabled
            if (r0 != 0) goto L23
            return r4
        L23:
            boolean r0 = r6.isRefreshing()
            if (r0 == 0) goto L2e
            boolean r0 = r6.disableScrollingWhileRefreshing
            if (r0 == 0) goto L2e
            return r5
        L2e:
            int r0 = r7.getAction()
            if (r0 != 0) goto L3b
            int r0 = r7.getEdgeFlags()
            if (r0 == 0) goto L3b
            return r4
        L3b:
            int r0 = r7.getAction()
            if (r0 == 0) goto L72
            if (r0 == r5) goto L57
            if (r0 == r3) goto L49
            r7 = 3
            if (r0 == r7) goto L57
            goto L81
        L49:
            boolean r0 = r6.isBeingDragged
            if (r0 == 0) goto L81
            float r7 = r7.getY()
            r6.lastMotionY = r7
            r6.pullEvent()
            return r5
        L57:
            boolean r7 = r6.isBeingDragged
            if (r7 == 0) goto L81
            r6.isBeingDragged = r4
            int r7 = r6.state
            if (r7 != r5) goto L6e
            cn.damai.baseview.pull.lib.PullToRefreshBase$OnRefreshListener r7 = r6.onRefreshListener
            if (r7 == 0) goto L6e
            r6.setRefreshingInternal(r5)
            cn.damai.baseview.pull.lib.PullToRefreshBase$OnRefreshListener r7 = r6.onRefreshListener
            r7.onRefresh()
            goto L71
        L6e:
            r6.smoothScrollTo(r4)
        L71:
            return r5
        L72:
            boolean r0 = r6.isReadyForPull()
            if (r0 == 0) goto L81
            float r7 = r7.getY()
            r6.initialMotionY = r7
            r6.lastMotionY = r7
            return r5
        L81:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.baseview.pull.lib.PullToRefreshBase.onTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void resetHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-240515837")) {
            ipChange.ipc$dispatch("-240515837", new Object[]{this});
            return;
        }
        this.state = 0;
        this.isBeingDragged = false;
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.reset();
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.reset();
        }
        smoothScrollTo(0);
    }

    public final void setDisableScrollingWhileRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1803493394")) {
            ipChange.ipc$dispatch("1803493394", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.disableScrollingWhileRefreshing = z;
        }
    }

    protected final void setHeaderScroll(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1832971296")) {
            ipChange.ipc$dispatch("-1832971296", new Object[]{this, Integer.valueOf(i)});
        } else {
            scrollTo(0, i);
        }
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863070925")) {
            ipChange.ipc$dispatch("863070925", new Object[]{this, Boolean.valueOf(z)});
        } else {
            getRefreshableView().setLongClickable(z);
        }
    }

    public final void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068187350")) {
            ipChange.ipc$dispatch("-2068187350", new Object[]{this, onRefreshListener});
        } else {
            this.onRefreshListener = onRefreshListener;
        }
    }

    public final void setOnUpOrDownListener(OnUpOrDownListener onUpOrDownListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378013802")) {
            ipChange.ipc$dispatch("-378013802", new Object[]{this, onUpOrDownListener});
        } else {
            this.onUpOrDownListener = onUpOrDownListener;
        }
    }

    public void setPullLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-331615576")) {
            ipChange.ipc$dispatch("-331615576", new Object[]{this, str});
            return;
        }
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setPullLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setPullLabel(str);
        }
    }

    public final void setPullToRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1604522397")) {
            ipChange.ipc$dispatch("1604522397", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isPullToRefreshEnabled = z;
        }
    }

    public final void setRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599970570")) {
            ipChange.ipc$dispatch("-1599970570", new Object[]{this});
        } else {
            setRefreshing(true);
        }
    }

    protected void setRefreshingInternal(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184689157")) {
            ipChange.ipc$dispatch("-1184689157", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.state = 2;
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.refreshing();
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.refreshing();
        }
        if (z) {
            smoothScrollTo(this.currentMode == 1 ? -this.headerHeight : this.headerHeight);
        }
    }

    public void setRefreshingLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961660682")) {
            ipChange.ipc$dispatch("961660682", new Object[]{this, str});
            return;
        }
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setRefreshingLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setRefreshingLabel(str);
        }
    }

    public void setReleaseLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111423226")) {
            ipChange.ipc$dispatch("1111423226", new Object[]{this, str});
            return;
        }
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setReleaseLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setReleaseLabel(str);
        }
    }

    protected final void smoothScrollTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411503598")) {
            ipChange.ipc$dispatch("411503598", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.currentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (getScrollY() != i) {
            PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(this.handler, getScrollY(), i);
            this.currentSmoothScrollRunnable = smoothScrollRunnable2;
            this.handler.post(smoothScrollRunnable2);
        }
    }

    public final void setRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940565662")) {
            ipChange.ipc$dispatch("1940565662", new Object[]{this, Boolean.valueOf(z)});
        } else if (isRefreshing()) {
        } else {
            setRefreshingInternal(z);
            this.state = 3;
        }
    }

    public PullToRefreshBase(Context context, int i) {
        super(context);
        this.isBeingDragged = false;
        this.state = 0;
        this.mode = 1;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.handler = new Handler();
        this.mode = i;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isBeingDragged = false;
        this.state = 0;
        this.mode = 1;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.handler = new Handler();
        init(context, attributeSet);
    }
}
