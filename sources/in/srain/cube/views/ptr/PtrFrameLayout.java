package in.srain.cube.views.ptr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.TextView;
import tb.px1;
import tb.rx1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PtrFrameLayout extends ViewGroup {
    public static boolean DEBUG = false;
    private static final boolean DEBUG_LAYOUT = true;
    private static byte FLAG_AUTO_REFRESH_AT_ONCE = 1;
    private static byte FLAG_AUTO_REFRESH_BUT_LATER = 2;
    private static byte FLAG_ENABLE_NEXT_PTR_AT_ONCE = 4;
    private static byte FLAG_PIN_CONTENT = 8;
    private static int ID = 1;
    private static byte MASK_AUTO_REFRESH = 3;
    public static final byte PTR_STATUS_COMPLETE = 4;
    public static final byte PTR_STATUS_INIT = 1;
    public static final byte PTR_STATUS_LOADING = 3;
    public static final byte PTR_STATUS_PREPARE = 2;
    protected final String LOG_TAG;
    private int mContainerId;
    protected View mContent;
    private boolean mDisableWhenHorizontalMove;
    private int mDurationToClose;
    private int mDurationToCloseHeader;
    private int mFlag;
    private boolean mHasSendCancelEvent;
    private int mHeaderHeight;
    private int mHeaderId;
    private View mHeaderView;
    private boolean mKeepHeaderWhenRefresh;
    private MotionEvent mLastMoveEvent;
    private int mLoadingMinTime;
    private long mLoadingStartTime;
    private int mPagingTouchSlop;
    private Runnable mPerformRefreshCompleteDelay;
    private boolean mPreventForHorizontal;
    private PtrHandler mPtrHandler;
    private rx1 mPtrIndicator;
    private a mPtrUIHandlerHolder;
    private boolean mPullToRefresh;
    private PtrUIHandlerHook mRefreshCompleteHook;
    private ScrollChecker mScrollChecker;
    private byte mStatus;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class ScrollChecker implements Runnable {
        private boolean mIsRunning = false;
        private int mLastFlingY;
        private Scroller mScroller;
        private int mStart;
        private int mTo;

        public ScrollChecker() {
            this.mScroller = new Scroller(PtrFrameLayout.this.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            reset();
            if (this.mScroller.isFinished()) {
                return;
            }
            this.mScroller.forceFinished(true);
        }

        private void finish() {
            if (PtrFrameLayout.DEBUG) {
                PtrFrameLayout ptrFrameLayout = PtrFrameLayout.this;
                px1.f(ptrFrameLayout.LOG_TAG, "finish, currentPos:%s", Integer.valueOf(ptrFrameLayout.mPtrIndicator.d()));
            }
            reset();
            PtrFrameLayout.this.onPtrScrollFinish();
        }

        private void reset() {
            this.mIsRunning = false;
            this.mLastFlingY = 0;
            PtrFrameLayout.this.removeCallbacks(this);
        }

        public void abortIfWorking() {
            if (this.mIsRunning) {
                if (!this.mScroller.isFinished()) {
                    this.mScroller.forceFinished(true);
                }
                PtrFrameLayout.this.onPtrScrollAbort();
                reset();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = !this.mScroller.computeScrollOffset() || this.mScroller.isFinished();
            int currY = this.mScroller.getCurrY();
            int i = currY - this.mLastFlingY;
            if (PtrFrameLayout.DEBUG && i != 0) {
                px1.f(PtrFrameLayout.this.LOG_TAG, "scroll: %s, start: %s, to: %s, currentPos: %s, current :%s, last: %s, delta: %s", Boolean.valueOf(z), Integer.valueOf(this.mStart), Integer.valueOf(this.mTo), Integer.valueOf(PtrFrameLayout.this.mPtrIndicator.d()), Integer.valueOf(currY), Integer.valueOf(this.mLastFlingY), Integer.valueOf(i));
            }
            if (!z) {
                this.mLastFlingY = currY;
                PtrFrameLayout.this.movePos(i);
                PtrFrameLayout.this.post(this);
                return;
            }
            finish();
        }

        public void tryToScrollTo(int i, int i2) {
            if (PtrFrameLayout.this.mPtrIndicator.s(i)) {
                return;
            }
            int d = PtrFrameLayout.this.mPtrIndicator.d();
            this.mStart = d;
            this.mTo = i;
            int i3 = i - d;
            if (PtrFrameLayout.DEBUG) {
                px1.b(PtrFrameLayout.this.LOG_TAG, "tryToScrollTo: start: %s, distance:%s, to:%s", Integer.valueOf(d), Integer.valueOf(i3), Integer.valueOf(i));
            }
            PtrFrameLayout.this.removeCallbacks(this);
            this.mLastFlingY = 0;
            if (!this.mScroller.isFinished()) {
                this.mScroller.forceFinished(true);
            }
            this.mScroller.startScroll(0, 0, 0, i3, i2);
            PtrFrameLayout.this.post(this);
            this.mIsRunning = true;
        }
    }

    public PtrFrameLayout(Context context) {
        this(context, null);
    }

    private void clearFlag() {
        this.mFlag &= ~MASK_AUTO_REFRESH;
    }

    private void layoutChildren() {
        int d = this.mPtrIndicator.d();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        View view = this.mHeaderView;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i = marginLayoutParams.leftMargin + paddingLeft;
            int i2 = ((marginLayoutParams.topMargin + paddingTop) + d) - this.mHeaderHeight;
            int measuredWidth = this.mHeaderView.getMeasuredWidth() + i;
            int measuredHeight = this.mHeaderView.getMeasuredHeight() + i2;
            this.mHeaderView.layout(i, i2, measuredWidth, measuredHeight);
            if (DEBUG) {
                px1.b(this.LOG_TAG, "onLayout header: %s %s %s %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            }
        }
        if (this.mContent != null) {
            if (isPinContent()) {
                d = 0;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mContent.getLayoutParams();
            int i3 = paddingLeft + marginLayoutParams2.leftMargin;
            int i4 = paddingTop + marginLayoutParams2.topMargin + d;
            int measuredWidth2 = this.mContent.getMeasuredWidth() + i3;
            int measuredHeight2 = this.mContent.getMeasuredHeight() + i4;
            if (DEBUG) {
                px1.b(this.LOG_TAG, "onLayout content: %s %s %s %s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(measuredWidth2), Integer.valueOf(measuredHeight2));
            }
            this.mContent.layout(i3, i4, measuredWidth2, measuredHeight2);
        }
    }

    private void measureContentView(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin, marginLayoutParams.height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void movePos(float f) {
        int i = 0;
        if (f < 0.0f && this.mPtrIndicator.t()) {
            if (DEBUG) {
                px1.c(this.LOG_TAG, String.format("has reached the top", new Object[0]));
                return;
            }
            return;
        }
        int d = this.mPtrIndicator.d() + ((int) f);
        if (!this.mPtrIndicator.L(d)) {
            i = d;
        } else if (DEBUG) {
            px1.c(this.LOG_TAG, String.format("over top", new Object[0]));
        }
        this.mPtrIndicator.D(i);
        updatePos(i - this.mPtrIndicator.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUIRefreshComplete(boolean z) {
        if (this.mPtrIndicator.q() && !z && this.mRefreshCompleteHook != null) {
            if (DEBUG) {
                px1.a(this.LOG_TAG, "notifyUIRefreshComplete mRefreshCompleteHook run.");
            }
            this.mRefreshCompleteHook.takeOver();
            return;
        }
        if (this.mPtrUIHandlerHolder.e()) {
            if (DEBUG) {
                px1.d(this.LOG_TAG, "PtrUIHandler: onUIRefreshComplete");
            }
            this.mPtrUIHandlerHolder.onUIRefreshComplete(this);
        }
        this.mPtrIndicator.A();
        tryScrollBackToTopAfterComplete();
        tryToNotifyReset();
    }

    private void onRelease(boolean z) {
        tryToPerformRefresh();
        byte b = this.mStatus;
        if (b != 3) {
            if (b == 4) {
                notifyUIRefreshComplete(false);
            } else {
                tryScrollBackToTopAbortRefresh();
            }
        } else if (this.mKeepHeaderWhenRefresh) {
            if (!this.mPtrIndicator.u() || z) {
                return;
            }
            this.mScrollChecker.tryToScrollTo(this.mPtrIndicator.g(), this.mDurationToClose);
        } else {
            tryScrollBackToTopWhileLoading();
        }
    }

    private boolean performAutoRefreshButLater() {
        return (this.mFlag & MASK_AUTO_REFRESH) == FLAG_AUTO_REFRESH_BUT_LATER;
    }

    private void performRefresh() {
        this.mLoadingStartTime = System.currentTimeMillis();
        if (this.mPtrUIHandlerHolder.e()) {
            this.mPtrUIHandlerHolder.onUIRefreshBegin(this);
            if (DEBUG) {
                px1.d(this.LOG_TAG, "PtrUIHandler: onUIRefreshBegin");
            }
        }
        PtrHandler ptrHandler = this.mPtrHandler;
        if (ptrHandler != null) {
            ptrHandler.onRefreshBegin(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performRefreshComplete() {
        this.mStatus = (byte) 4;
        if (this.mScrollChecker.mIsRunning && isAutoRefresh()) {
            if (DEBUG) {
                px1.b(this.LOG_TAG, "performRefreshComplete do nothing, scrolling: %s, auto refresh: %s", Boolean.valueOf(this.mScrollChecker.mIsRunning), Integer.valueOf(this.mFlag));
                return;
            }
            return;
        }
        notifyUIRefreshComplete(false);
    }

    private void sendCancelEvent() {
        if (DEBUG) {
            px1.a(this.LOG_TAG, "send cancel event");
        }
        MotionEvent motionEvent = this.mLastMoveEvent;
        if (motionEvent == null) {
            return;
        }
        dispatchTouchEventSupper(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime() + ViewConfiguration.getLongPressTimeout(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
    }

    private void sendDownEvent() {
        if (DEBUG) {
            px1.a(this.LOG_TAG, "send down event");
        }
        MotionEvent motionEvent = this.mLastMoveEvent;
        dispatchTouchEventSupper(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
    }

    private void tryScrollBackToTop() {
        if (this.mPtrIndicator.w()) {
            return;
        }
        this.mScrollChecker.tryToScrollTo(0, this.mDurationToCloseHeader);
    }

    private void tryScrollBackToTopAbortRefresh() {
        tryScrollBackToTop();
    }

    private void tryScrollBackToTopAfterComplete() {
        tryScrollBackToTop();
    }

    private void tryScrollBackToTopWhileLoading() {
        tryScrollBackToTop();
    }

    private boolean tryToNotifyReset() {
        byte b = this.mStatus;
        if ((b == 4 || b == 2) && this.mPtrIndicator.t()) {
            if (this.mPtrUIHandlerHolder.e()) {
                this.mPtrUIHandlerHolder.onUIReset(this);
                if (DEBUG) {
                    px1.d(this.LOG_TAG, "PtrUIHandler: onUIReset");
                }
            }
            this.mStatus = (byte) 1;
            clearFlag();
            return true;
        }
        return false;
    }

    private boolean tryToPerformRefresh() {
        if (this.mStatus != 2) {
            return false;
        }
        if ((this.mPtrIndicator.u() && isAutoRefresh()) || this.mPtrIndicator.v()) {
            this.mStatus = (byte) 3;
            performRefresh();
        }
        return false;
    }

    private void updatePos(int i) {
        if (i == 0) {
            return;
        }
        boolean w = this.mPtrIndicator.w();
        if (w && !this.mHasSendCancelEvent && this.mPtrIndicator.r()) {
            this.mHasSendCancelEvent = true;
            sendCancelEvent();
        }
        if ((this.mPtrIndicator.o() && this.mStatus == 1) || (this.mPtrIndicator.m() && this.mStatus == 4 && isEnabledNextPtrAtOnce())) {
            this.mStatus = (byte) 2;
            this.mPtrUIHandlerHolder.onUIRefreshPrepare(this);
            if (DEBUG) {
                px1.e(this.LOG_TAG, "PtrUIHandler: onUIRefreshPrepare, mFlag %s", Integer.valueOf(this.mFlag));
            }
        }
        if (this.mPtrIndicator.n()) {
            tryToNotifyReset();
            if (w) {
                sendDownEvent();
            }
        }
        if (this.mStatus == 2) {
            if (w && !isAutoRefresh() && this.mPullToRefresh && this.mPtrIndicator.b()) {
                tryToPerformRefresh();
            }
            if (performAutoRefreshButLater() && this.mPtrIndicator.p()) {
                tryToPerformRefresh();
            }
        }
        if (DEBUG) {
            px1.f(this.LOG_TAG, "updatePos: change: %s, current: %s last: %s, top: %s, headerHeight: %s", Integer.valueOf(i), Integer.valueOf(this.mPtrIndicator.d()), Integer.valueOf(this.mPtrIndicator.f()), Integer.valueOf(this.mContent.getTop()), Integer.valueOf(this.mHeaderHeight));
        }
        this.mHeaderView.offsetTopAndBottom(i);
        if (!isPinContent()) {
            this.mContent.offsetTopAndBottom(i);
        }
        invalidate();
        if (this.mPtrUIHandlerHolder.e()) {
            this.mPtrUIHandlerHolder.onUIPositionChange(this, w, this.mStatus, this.mPtrIndicator);
        }
        onPositionChange(w, this.mStatus, this.mPtrIndicator);
    }

    public void addPtrUIHandler(PtrUIHandler ptrUIHandler) {
        a.a(this.mPtrUIHandlerHolder, ptrUIHandler);
    }

    public void autoRefresh() {
        autoRefresh(true, this.mDurationToCloseHeader);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void disableWhenHorizontalMove(boolean z) {
        this.mDisableWhenHorizontalMove = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.srain.cube.views.ptr.PtrFrameLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean dispatchTouchEventSupper(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public View getContentView() {
        return this.mContent;
    }

    public float getDurationToClose() {
        return this.mDurationToClose;
    }

    public long getDurationToCloseHeader() {
        return this.mDurationToCloseHeader;
    }

    public int getHeaderHeight() {
        return this.mHeaderHeight;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public int getOffsetToKeepHeaderWhileLoading() {
        return this.mPtrIndicator.g();
    }

    public int getOffsetToRefresh() {
        return this.mPtrIndicator.h();
    }

    public float getRatioOfHeaderToHeightRefresh() {
        return this.mPtrIndicator.k();
    }

    public float getResistance() {
        return this.mPtrIndicator.l();
    }

    public boolean isAutoRefresh() {
        return (this.mFlag & MASK_AUTO_REFRESH) > 0;
    }

    public boolean isEnabledNextPtrAtOnce() {
        return (this.mFlag & FLAG_ENABLE_NEXT_PTR_AT_ONCE) > 0;
    }

    public boolean isKeepHeaderWhenRefresh() {
        return this.mKeepHeaderWhenRefresh;
    }

    public boolean isPinContent() {
        return (this.mFlag & FLAG_PIN_CONTENT) > 0;
    }

    public boolean isPullToRefresh() {
        return this.mPullToRefresh;
    }

    public boolean isRefreshing() {
        return this.mStatus == 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ScrollChecker scrollChecker = this.mScrollChecker;
        if (scrollChecker != null) {
            scrollChecker.destroy();
        }
        Runnable runnable = this.mPerformRefreshCompleteDelay;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        int childCount = getChildCount();
        if (childCount <= 2) {
            if (childCount == 2) {
                int i = this.mHeaderId;
                if (i != 0 && this.mHeaderView == null) {
                    this.mHeaderView = findViewById(i);
                }
                int i2 = this.mContainerId;
                if (i2 != 0 && this.mContent == null) {
                    this.mContent = findViewById(i2);
                }
                if (this.mContent == null || this.mHeaderView == null) {
                    View childAt = getChildAt(0);
                    View childAt2 = getChildAt(1);
                    if (childAt instanceof PtrUIHandler) {
                        this.mHeaderView = childAt;
                        this.mContent = childAt2;
                    } else if (childAt2 instanceof PtrUIHandler) {
                        this.mHeaderView = childAt2;
                        this.mContent = childAt;
                    } else {
                        View view = this.mContent;
                        if (view == null && this.mHeaderView == null) {
                            this.mHeaderView = childAt;
                            this.mContent = childAt2;
                        } else {
                            View view2 = this.mHeaderView;
                            if (view2 == null) {
                                if (view == childAt) {
                                    childAt = childAt2;
                                }
                                this.mHeaderView = childAt;
                            } else {
                                if (view2 == childAt) {
                                    childAt = childAt2;
                                }
                                this.mContent = childAt;
                            }
                        }
                    }
                }
            } else if (childCount == 1) {
                this.mContent = getChildAt(0);
            } else {
                TextView textView = new TextView(getContext());
                textView.setClickable(true);
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText("The content view in PtrFrameLayout is empty. Do you forget to specify its id in xml layout file?");
                this.mContent = textView;
                addView(textView);
            }
            View view3 = this.mHeaderView;
            if (view3 != null) {
                view3.bringToFront();
            }
            super.onFinishInflate();
            return;
        }
        throw new IllegalStateException("PtrFrameLayout only can host 2 elements");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutChildren();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (DEBUG) {
            px1.b(this.LOG_TAG, "onMeasure frame: width: %s, height: %s, padding: %s %s %s %s", Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getPaddingLeft()), Integer.valueOf(getPaddingRight()), Integer.valueOf(getPaddingTop()), Integer.valueOf(getPaddingBottom()));
        }
        View view = this.mHeaderView;
        if (view != null) {
            measureChildWithMargins(view, i, 0, i2, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mHeaderView.getLayoutParams();
            int measuredHeight = this.mHeaderView.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            this.mHeaderHeight = measuredHeight;
            this.mPtrIndicator.E(measuredHeight);
        }
        View view2 = this.mContent;
        if (view2 != null) {
            measureContentView(view2, i, i2);
            if (DEBUG) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mContent.getLayoutParams();
                px1.b(this.LOG_TAG, "onMeasure content, width: %s, height: %s, margin: %s %s %s %s", Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()), Integer.valueOf(marginLayoutParams2.leftMargin), Integer.valueOf(marginLayoutParams2.topMargin), Integer.valueOf(marginLayoutParams2.rightMargin), Integer.valueOf(marginLayoutParams2.bottomMargin));
                px1.b(this.LOG_TAG, "onMeasure, currentPos: %s, lastPos: %s, top: %s", Integer.valueOf(this.mPtrIndicator.d()), Integer.valueOf(this.mPtrIndicator.f()), Integer.valueOf(this.mContent.getTop()));
            }
        }
    }

    protected void onPositionChange(boolean z, byte b, rx1 rx1Var) {
    }

    protected void onPtrScrollAbort() {
        if (this.mPtrIndicator.q() && isAutoRefresh()) {
            if (DEBUG) {
                px1.a(this.LOG_TAG, "call onRelease after scroll abort");
            }
            onRelease(true);
        }
    }

    protected void onPtrScrollFinish() {
        if (this.mPtrIndicator.q() && isAutoRefresh()) {
            if (DEBUG) {
                px1.a(this.LOG_TAG, "call onRelease after scroll finish");
            }
            onRelease(true);
        }
    }

    public final void refreshComplete() {
        if (DEBUG) {
            px1.d(this.LOG_TAG, "refreshComplete");
        }
        PtrUIHandlerHook ptrUIHandlerHook = this.mRefreshCompleteHook;
        if (ptrUIHandlerHook != null) {
            ptrUIHandlerHook.reset();
        }
        int currentTimeMillis = (int) (this.mLoadingMinTime - (System.currentTimeMillis() - this.mLoadingStartTime));
        if (currentTimeMillis <= 0) {
            if (DEBUG) {
                px1.a(this.LOG_TAG, "performRefreshComplete at once");
            }
            performRefreshComplete();
            return;
        }
        postDelayed(this.mPerformRefreshCompleteDelay, currentTimeMillis);
        if (DEBUG) {
            px1.b(this.LOG_TAG, "performRefreshComplete after delay: %s", Integer.valueOf(currentTimeMillis));
        }
    }

    public void removePtrUIHandler(PtrUIHandler ptrUIHandler) {
        this.mPtrUIHandlerHolder = a.f(this.mPtrUIHandlerHolder, ptrUIHandler);
    }

    public void setDurationToClose(int i) {
        this.mDurationToClose = i;
    }

    public void setDurationToCloseHeader(int i) {
        this.mDurationToCloseHeader = i;
    }

    public void setEnabledNextPtrAtOnce(boolean z) {
        if (z) {
            this.mFlag |= FLAG_ENABLE_NEXT_PTR_AT_ONCE;
        } else {
            this.mFlag &= ~FLAG_ENABLE_NEXT_PTR_AT_ONCE;
        }
    }

    public void setHeaderView(View view) {
        View view2 = this.mHeaderView;
        if (view2 != null && view != null && view2 != view) {
            removeView(view2);
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LayoutParams(-1, -2));
        }
        this.mHeaderView = view;
        addView(view);
    }

    @Deprecated
    public void setInterceptEventWhileWorking(boolean z) {
    }

    public void setKeepHeaderWhenRefresh(boolean z) {
        this.mKeepHeaderWhenRefresh = z;
    }

    public void setLoadingMinTime(int i) {
        this.mLoadingMinTime = i;
    }

    public void setOffsetToKeepHeaderWhileLoading(int i) {
        this.mPtrIndicator.G(i);
    }

    public void setOffsetToRefresh(int i) {
        this.mPtrIndicator.H(i);
    }

    public void setPinContent(boolean z) {
        if (z) {
            this.mFlag |= FLAG_PIN_CONTENT;
        } else {
            this.mFlag &= ~FLAG_PIN_CONTENT;
        }
    }

    public void setPtrHandler(PtrHandler ptrHandler) {
        this.mPtrHandler = ptrHandler;
    }

    public void setPtrIndicator(rx1 rx1Var) {
        rx1 rx1Var2 = this.mPtrIndicator;
        if (rx1Var2 != null && rx1Var2 != rx1Var) {
            rx1Var.a(rx1Var2);
        }
        this.mPtrIndicator = rx1Var;
    }

    public void setPullToRefresh(boolean z) {
        this.mPullToRefresh = z;
    }

    public void setRatioOfHeaderHeightToRefresh(float f) {
        this.mPtrIndicator.I(f);
    }

    public void setRefreshCompleteHook(PtrUIHandlerHook ptrUIHandlerHook) {
        this.mRefreshCompleteHook = ptrUIHandlerHook;
        ptrUIHandlerHook.setResumeAction(new Runnable() { // from class: in.srain.cube.views.ptr.PtrFrameLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (PtrFrameLayout.DEBUG) {
                    px1.a(PtrFrameLayout.this.LOG_TAG, "mRefreshCompleteHook resume.");
                }
                PtrFrameLayout.this.notifyUIRefreshComplete(true);
            }
        });
    }

    public void setResistance(float f) {
        this.mPtrIndicator.J(f);
    }

    public PtrFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void autoRefresh(boolean z) {
        autoRefresh(z, this.mDurationToCloseHeader);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public PtrFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatus = (byte) 1;
        StringBuilder sb = new StringBuilder();
        sb.append("ptr-frame-");
        int i2 = ID + 1;
        ID = i2;
        sb.append(i2);
        this.LOG_TAG = sb.toString();
        this.mHeaderId = 0;
        this.mContainerId = 0;
        this.mDurationToClose = 200;
        this.mDurationToCloseHeader = 1000;
        this.mKeepHeaderWhenRefresh = true;
        this.mPullToRefresh = false;
        this.mPtrUIHandlerHolder = a.c();
        this.mDisableWhenHorizontalMove = false;
        this.mFlag = 0;
        this.mPreventForHorizontal = false;
        this.mLoadingMinTime = 500;
        this.mLoadingStartTime = 0L;
        this.mHasSendCancelEvent = false;
        this.mPerformRefreshCompleteDelay = new Runnable() { // from class: in.srain.cube.views.ptr.PtrFrameLayout.1
            @Override // java.lang.Runnable
            public void run() {
                PtrFrameLayout.this.performRefreshComplete();
            }
        };
        this.mPtrIndicator = new rx1();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PtrFrameLayout, 0, 0);
        if (obtainStyledAttributes != null) {
            this.mHeaderId = obtainStyledAttributes.getResourceId(R$styleable.PtrFrameLayout_ptr_header, this.mHeaderId);
            this.mContainerId = obtainStyledAttributes.getResourceId(R$styleable.PtrFrameLayout_ptr_content, this.mContainerId);
            rx1 rx1Var = this.mPtrIndicator;
            rx1Var.J(obtainStyledAttributes.getFloat(R$styleable.PtrFrameLayout_ptr_resistance, rx1Var.l()));
            this.mDurationToClose = obtainStyledAttributes.getInt(R$styleable.PtrFrameLayout_ptr_duration_to_close, this.mDurationToClose);
            this.mDurationToCloseHeader = obtainStyledAttributes.getInt(R$styleable.PtrFrameLayout_ptr_duration_to_close_header, this.mDurationToCloseHeader);
            this.mPtrIndicator.I(obtainStyledAttributes.getFloat(R$styleable.PtrFrameLayout_ptr_ratio_of_header_height_to_refresh, this.mPtrIndicator.k()));
            this.mKeepHeaderWhenRefresh = obtainStyledAttributes.getBoolean(R$styleable.PtrFrameLayout_ptr_keep_header_when_refresh, this.mKeepHeaderWhenRefresh);
            this.mPullToRefresh = obtainStyledAttributes.getBoolean(R$styleable.PtrFrameLayout_ptr_pull_to_fresh, this.mPullToRefresh);
            obtainStyledAttributes.recycle();
        }
        this.mScrollChecker = new ScrollChecker();
        this.mPagingTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public void autoRefresh(boolean z, int i) {
        if (this.mStatus != 1) {
            return;
        }
        this.mFlag |= z ? FLAG_AUTO_REFRESH_AT_ONCE : FLAG_AUTO_REFRESH_BUT_LATER;
        this.mStatus = (byte) 2;
        if (this.mPtrUIHandlerHolder.e()) {
            this.mPtrUIHandlerHolder.onUIRefreshPrepare(this);
            if (DEBUG) {
                px1.e(this.LOG_TAG, "PtrUIHandler: onUIRefreshPrepare, mFlag %s", Integer.valueOf(this.mFlag));
            }
        }
        this.mScrollChecker.tryToScrollTo(this.mPtrIndicator.h(), i);
        if (z) {
            this.mStatus = (byte) 3;
            performRefresh();
        }
    }
}
