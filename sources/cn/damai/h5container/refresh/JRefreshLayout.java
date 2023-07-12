package cn.damai.h5container.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$styleable;
import cn.damai.h5container.DamaiWebView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class JRefreshLayout extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String LOG_TAG = "LOG_JRefreshLayout";
    private static final int MAX_OFFSET = 30;
    private int childScrollViewId;
    private int defaultMaxOffset;
    private int defaultRefreshHeight;
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private View mContentView;
    private int mCurrentOffset;
    private long mDurationOffset;
    private int mFlingSlop;
    private GestureDetectorCompat mGesture;
    private boolean mGestureExecute;
    private JRefreshHeader mHeader;
    private int mHeaderOffset;
    private View mHeaderView;
    private float mInitialDownY;
    private boolean mIsBeingDragged;
    private boolean mIsFling;
    private boolean mIsPinContent;
    private boolean mIsReset;
    private boolean mKeepHeaderWhenRefresh;
    private int mLastFlingY;
    private boolean mNestedScrollExecute;
    private boolean mNestedScrollInProgress;
    private ValueAnimator mOffsetAnimator;
    private boolean mRefreshEnable;
    private JRefreshListener mRefreshListener;
    private boolean mRefreshing;
    private JScrollListener mScrollListener;
    private OverScroller mScroller;
    private int mTouchSlop;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface JRefreshListener {
        void onRefresh(JRefreshLayout jRefreshLayout);
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface JScrollListener {
        void onScroll(int i, int i2, float f, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class RefreshGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private RefreshGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-256812603")) {
                return ((Boolean) ipChange.ipc$dispatch("-256812603", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            JRefreshLayout.this.mGestureExecute = true;
            int refreshHeight = JRefreshLayout.this.mHeader == null ? JRefreshLayout.this.defaultRefreshHeight : JRefreshLayout.this.mHeader.refreshHeight();
            if (f2 <= 0.0f || (JRefreshLayout.this.mRefreshing && JRefreshLayout.this.mKeepHeaderWhenRefresh && JRefreshLayout.this.mCurrentOffset < refreshHeight)) {
                if (Math.abs(f2) > JRefreshLayout.this.mFlingSlop) {
                    JRefreshLayout.this.mIsFling = true;
                    JRefreshLayout.this.mScroller.fling(0, 0, (int) f, (int) (-f2), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    JRefreshLayout.this.invalidate();
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "262474808")) {
                return ((Boolean) ipChange.ipc$dispatch("262474808", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            JRefreshLayout.this.mGestureExecute = true;
            int height = JRefreshLayout.this.mHeader == null ? JRefreshLayout.this.defaultMaxOffset == -1 ? JRefreshLayout.this.getHeight() : JRefreshLayout.this.defaultMaxOffset : JRefreshLayout.this.mHeader.maxOffsetHeight();
            if ((JRefreshLayout.this.mCurrentOffset != 0 || f2 <= 0.0f) && (JRefreshLayout.this.mCurrentOffset != height || f2 >= 0.0f)) {
                int i = -JRefreshLayout.this.calculateOffset((int) f2);
                if (JRefreshLayout.this.mCurrentOffset + i > height) {
                    i = height - JRefreshLayout.this.mCurrentOffset;
                } else if (JRefreshLayout.this.mCurrentOffset + i < 0) {
                    i = -JRefreshLayout.this.mCurrentOffset;
                }
                JRefreshLayout.this.moveView(i);
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    public JRefreshLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1163867955")) {
            ipChange.ipc$dispatch("-1163867955", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.mOffsetAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mOffsetAnimator = valueAnimator;
            valueAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        }
        cancelAnimator();
        if (!this.mKeepHeaderWhenRefresh) {
            i = 0;
        }
        if (this.mCurrentOffset == i) {
            return;
        }
        Log.d(LOG_TAG, "animTo " + this.mCurrentOffset + " to " + i);
        this.mOffsetAnimator.setDuration(this.mDurationOffset);
        this.mOffsetAnimator.setIntValues(this.mCurrentOffset, i);
        this.mOffsetAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateOffset(int i) {
        int maxOffsetHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967750759")) {
            return ((Integer) ipChange.ipc$dispatch("1967750759", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        JRefreshHeader jRefreshHeader = this.mHeader;
        if (jRefreshHeader == null) {
            maxOffsetHeight = this.defaultMaxOffset;
            if (maxOffsetHeight == -1) {
                maxOffsetHeight = getHeight();
            }
        } else {
            maxOffsetHeight = jRefreshHeader.maxOffsetHeight();
        }
        float f = i > 0 ? 0.8f : 1.0f - (this.mCurrentOffset / maxOffsetHeight);
        if (i > 0) {
            return Math.min(30, (int) Math.ceil(f * i));
        }
        return Math.max(-30, (int) Math.floor(f * i));
    }

    private boolean canChildScrollUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1124363922")) {
            return ((Boolean) ipChange.ipc$dispatch("1124363922", new Object[]{this})).booleanValue();
        }
        try {
            View view = this.mContentView;
            if (view instanceof DamaiWebView) {
                return view != null && ViewCompat.canScrollVertically(((DamaiWebView) view).getCoreView(), -1);
            }
            int i = this.childScrollViewId;
            return i > 0 ? view != null && ViewCompat.canScrollVertically(view.findViewById(i), -1) : (view == null || ((ViewGroup) view).getChildAt(0) == null || !ViewCompat.canScrollVertically(((ViewGroup) this.mContentView).getChildAt(0), -1)) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void cancelAnimator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498147521")) {
            ipChange.ipc$dispatch("498147521", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mOffsetAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.mOffsetAnimator.cancel();
    }

    private void finishSpinner() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-41947742")) {
            ipChange.ipc$dispatch("-41947742", new Object[]{this});
        } else if (this.mCurrentOffset <= 0) {
        } else {
            Log.d(LOG_TAG, "finishSpinner mCurrentOffset is " + this.mCurrentOffset + " , mRefreshing is " + this.mRefreshing);
            JRefreshHeader jRefreshHeader = this.mHeader;
            int refreshHeight = jRefreshHeader == null ? this.defaultRefreshHeight : jRefreshHeader.refreshHeight();
            if (this.mRefreshing) {
                if (this.mCurrentOffset >= refreshHeight / 2) {
                    i = refreshHeight;
                }
            } else {
                int i2 = this.mCurrentOffset;
                int i3 = (i2 < refreshHeight || !this.mIsReset) ? 0 : refreshHeight;
                if (i2 >= refreshHeight && this.mIsReset) {
                    this.mRefreshing = true;
                    this.mIsReset = false;
                    JRefreshHeader jRefreshHeader2 = this.mHeader;
                    if (jRefreshHeader2 != null) {
                        jRefreshHeader2.onRefresh(this);
                    }
                    JRefreshListener jRefreshListener = this.mRefreshListener;
                    if (jRefreshListener != null) {
                        jRefreshListener.onRefresh(this);
                    }
                }
                i = i3;
            }
            animTo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveView(int i) {
        JRefreshHeader jRefreshHeader;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1230876855")) {
            ipChange.ipc$dispatch("1230876855", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        JRefreshHeader jRefreshHeader2 = this.mHeader;
        int refreshHeight = jRefreshHeader2 == null ? this.defaultRefreshHeight : jRefreshHeader2.refreshHeight();
        if (!this.mRefreshing && this.mCurrentOffset == 0 && i > 0 && (jRefreshHeader = this.mHeader) != null) {
            jRefreshHeader.onPrepare(this);
        }
        z = (this.mCurrentOffset > getHeight() || this.mCurrentOffset == 0) ? true : true;
        this.mCurrentOffset += i;
        View view = this.mHeaderView;
        if (view != null) {
            view.offsetTopAndBottom(i);
        }
        if (!this.mIsPinContent) {
            this.mContentView.offsetTopAndBottom(i);
        }
        if (z) {
            invalidate();
        }
        JRefreshHeader jRefreshHeader3 = this.mHeader;
        if (jRefreshHeader3 != null) {
            int i2 = this.mCurrentOffset;
            jRefreshHeader3.onScroll(this, i2, i2 / refreshHeight, this.mRefreshing);
        }
        JScrollListener jScrollListener = this.mScrollListener;
        if (jScrollListener != null) {
            int i3 = this.mCurrentOffset;
            jScrollListener.onScroll(i, i3, i3 / refreshHeight, this.mRefreshing);
        }
        if (this.mRefreshing || i >= 0 || this.mCurrentOffset != 0) {
            return;
        }
        JRefreshHeader jRefreshHeader4 = this.mHeader;
        if (jRefreshHeader4 != null) {
            jRefreshHeader4.onReset(this);
        }
        this.mIsReset = true;
    }

    @Override // android.view.View
    public void computeScroll() {
        int maxOffsetHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-376314620")) {
            ipChange.ipc$dispatch("-376314620", new Object[]{this});
        } else if (this.mScroller.computeScrollOffset() && this.mIsFling) {
            int currY = this.mLastFlingY - this.mScroller.getCurrY();
            JRefreshHeader jRefreshHeader = this.mHeader;
            int refreshHeight = jRefreshHeader == null ? this.defaultRefreshHeight : jRefreshHeader.refreshHeight();
            JRefreshHeader jRefreshHeader2 = this.mHeader;
            if (jRefreshHeader2 == null) {
                maxOffsetHeight = this.defaultMaxOffset;
                if (maxOffsetHeight == -1) {
                    maxOffsetHeight = getHeight();
                }
            } else {
                maxOffsetHeight = jRefreshHeader2.maxOffsetHeight();
            }
            if (currY <= 0) {
                refreshHeight = maxOffsetHeight;
            }
            this.mLastFlingY = this.mScroller.getCurrY();
            if (this.mCurrentOffset > 0 || (currY > 0 && !canChildScrollUp())) {
                int i = this.mCurrentOffset;
                if (i + currY > refreshHeight) {
                    currY = refreshHeight - i;
                } else if (i + currY < 0) {
                    currY = -i;
                }
                moveView(currY);
                if (this.mCurrentOffset >= refreshHeight) {
                    this.mScroller.forceFinished(true);
                }
            } else if (currY < 0) {
                View view = this.mContentView;
                if (view instanceof RecyclerView) {
                    ((RecyclerView) view).fling(0, (int) this.mScroller.getCurrVelocity());
                } else if (view instanceof NestedScrollView) {
                    ((NestedScrollView) view).fling((int) this.mScroller.getCurrVelocity());
                } else if (view instanceof ScrollView) {
                    ((ScrollView) view).fling((int) this.mScroller.getCurrVelocity());
                }
                this.mScroller.forceFinished(true);
            }
            invalidate();
        } else if (this.mIsFling) {
            Log.d(LOG_TAG, "mScroll fling complete mCurrentOffset is " + this.mCurrentOffset);
            this.mIsFling = false;
            finishSpinner();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2036753818")) {
            return ((Boolean) ipChange.ipc$dispatch("-2036753818", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && !this.mNestedScrollExecute && !this.mGestureExecute) {
                finishSpinner();
            }
        } else {
            cancelAnimator();
            this.mIsFling = false;
            this.mLastFlingY = 0;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public JRefreshHeader getHeader() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1250931858") ? (JRefreshHeader) ipChange.ipc$dispatch("-1250931858", new Object[]{this}) : this.mHeader;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081811507")) {
            ipChange.ipc$dispatch("1081811507", new Object[]{this});
            return;
        }
        int childCount = getChildCount();
        if (childCount <= 2) {
            if (childCount == 1) {
                this.mContentView = getChildAt(0);
            } else if (childCount == 2) {
                if (getChildAt(0) instanceof JRefreshHeader) {
                    JRefreshHeader jRefreshHeader = (JRefreshHeader) getChildAt(0);
                    this.mHeader = jRefreshHeader;
                    this.mHeaderView = (View) jRefreshHeader;
                }
                this.mContentView = getChildAt(1);
            }
            View view = this.mHeaderView;
            if (view != null) {
                view.bringToFront();
            }
            super.onFinishInflate();
            return;
        }
        throw new IllegalStateException("JRefreshLayout111 can only accommodate two elements");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
        if (r0 != 3) goto L27;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.h5container.refresh.JRefreshLayout.$ipChange
            java.lang.String r1 = "-1027741021"
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
            boolean r0 = r6.isEnabled()
            if (r0 == 0) goto L81
            boolean r0 = r6.mRefreshEnable
            if (r0 != 0) goto L29
            goto L81
        L29:
            boolean r0 = r6.mNestedScrollInProgress
            if (r0 != 0) goto L81
            boolean r0 = r6.canChildScrollUp()
            if (r0 == 0) goto L34
            goto L81
        L34:
            boolean r0 = r6.mRefreshing
            if (r0 == 0) goto L41
            boolean r0 = r6.mIsPinContent
            if (r0 == 0) goto L41
            boolean r0 = r6.mKeepHeaderWhenRefresh
            if (r0 == 0) goto L41
            return r5
        L41:
            int r0 = r7.getAction()
            if (r0 == 0) goto L71
            if (r0 == r4) goto L6e
            if (r0 == r3) goto L4f
            r7 = 3
            if (r0 == r7) goto L6e
            goto L7e
        L4f:
            boolean r0 = r6.mIsBeingDragged
            if (r0 != 0) goto L63
            float r7 = r7.getY()
            float r0 = r6.mInitialDownY
            float r7 = r7 - r0
            int r0 = r6.mTouchSlop
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 <= 0) goto L63
            r6.mIsBeingDragged = r4
        L63:
            int r7 = r6.mCurrentOffset
            if (r7 <= 0) goto L7e
            boolean r7 = r6.mIsBeingDragged
            if (r7 != 0) goto L7e
            r6.mIsBeingDragged = r4
            goto L7e
        L6e:
            r6.mIsBeingDragged = r5
            goto L7e
        L71:
            r6.mIsBeingDragged = r5
            float r0 = r7.getY()
            r6.mInitialDownY = r0
            androidx.core.view.GestureDetectorCompat r0 = r6.mGesture
            r0.onTouchEvent(r7)
        L7e:
            boolean r7 = r6.mIsBeingDragged
            return r7
        L81:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.h5container.refresh.JRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041661979")) {
            ipChange.ipc$dispatch("2041661979", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        if (this.mHeaderView != null && !isInEditMode()) {
            LayoutParams layoutParams = (LayoutParams) this.mHeaderView.getLayoutParams();
            int paddingLeft = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int paddingTop = ((getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mHeaderView.getMeasuredHeight()) + this.mCurrentOffset + this.mHeaderOffset;
            this.mHeaderView.layout(paddingLeft, paddingTop, this.mHeaderView.getMeasuredWidth() + paddingLeft, this.mHeaderView.getMeasuredHeight() + paddingTop);
        }
        View view = this.mContentView;
        if (view != null) {
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            int paddingLeft2 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
            int paddingTop2 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + (this.mIsPinContent ? 0 : this.mCurrentOffset);
            this.mContentView.layout(paddingLeft2, paddingTop2, this.mContentView.getMeasuredWidth() + paddingLeft2, this.mContentView.getMeasuredHeight() + paddingTop2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674643497")) {
            ipChange.ipc$dispatch("674643497", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            measureChildWithMargins(getChildAt(i3), i, 0, i2, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212859304")) {
            return ((Boolean) ipChange.ipc$dispatch("1212859304", new Object[]{this, view, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})).booleanValue();
        }
        if (this.mRefreshing && f2 < (-this.mTouchSlop) && this.mKeepHeaderWhenRefresh) {
            this.mIsFling = true;
            this.mScroller.fling(0, 0, (int) f, (int) f2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            invalidate();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652827715")) {
            return ((Boolean) ipChange.ipc$dispatch("1652827715", new Object[]{this, view, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
        }
        this.mNestedScrollExecute = true;
        if (this.mCurrentOffset > 0) {
            JRefreshHeader jRefreshHeader = this.mHeader;
            int refreshHeight = jRefreshHeader == null ? this.defaultRefreshHeight : jRefreshHeader.refreshHeight();
            if ((f2 >= 0.0f || (this.mRefreshing && this.mKeepHeaderWhenRefresh && this.mCurrentOffset < refreshHeight)) && Math.abs(f2) > this.mFlingSlop) {
                this.mIsFling = true;
                this.mScroller.fling(0, 0, (int) f, (int) f2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                invalidate();
            }
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630278126")) {
            ipChange.ipc$dispatch("-1630278126", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), iArr});
            return;
        }
        this.mNestedScrollExecute = true;
        int i3 = this.mCurrentOffset;
        if (i3 <= 0 || i2 <= 0) {
            return;
        }
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 > i3) {
            i2 -= i3;
        }
        iArr[1] = i2;
        moveView(-i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int maxOffsetHeight;
        int i5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1938415917")) {
            ipChange.ipc$dispatch("-1938415917", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        JRefreshHeader jRefreshHeader = this.mHeader;
        if (jRefreshHeader == null) {
            maxOffsetHeight = this.defaultMaxOffset;
            if (maxOffsetHeight == -1) {
                maxOffsetHeight = getHeight();
            }
        } else {
            maxOffsetHeight = jRefreshHeader.maxOffsetHeight();
        }
        if (i4 >= 0 || canChildScrollUp() || (i5 = this.mCurrentOffset) >= maxOffsetHeight) {
            return;
        }
        if (i5 - i4 > maxOffsetHeight) {
            i4 = i5 - maxOffsetHeight;
        }
        moveView(-calculateOffset(i4));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939452811")) {
            ipChange.ipc$dispatch("939452811", new Object[]{this, view, view2, Integer.valueOf(i)});
            return;
        }
        this.mNestedScrollExecute = false;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1225193626") ? ((Boolean) ipChange.ipc$dispatch("-1225193626", new Object[]{this, view, view2, Integer.valueOf(i)})).booleanValue() : isEnabled() && this.mRefreshEnable && !((this.mRefreshing && this.mIsPinContent && this.mKeepHeaderWhenRefresh) || (i & 2) == 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760252469")) {
            ipChange.ipc$dispatch("1760252469", new Object[]{this, view});
            return;
        }
        if (!this.mIsFling && this.mNestedScrollExecute) {
            finishSpinner();
        }
        this.mNestedScrollExecute = false;
        this.mNestedScrollInProgress = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225362143")) {
            return ((Boolean) ipChange.ipc$dispatch("-225362143", new Object[]{this, motionEvent})).booleanValue();
        }
        if (!isEnabled() || this.mNestedScrollExecute || canChildScrollUp()) {
            return false;
        }
        this.mGesture.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (!this.mIsFling && this.mGestureExecute) {
                finishSpinner();
            }
            this.mGestureExecute = false;
        }
        return true;
    }

    public void refreshComplete(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672996448")) {
            ipChange.ipc$dispatch("1672996448", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mRefreshing) {
            JRefreshHeader jRefreshHeader = this.mHeader;
            if (jRefreshHeader != null) {
                jRefreshHeader.onComplete(this, z);
            }
            this.mRefreshing = false;
            if (this.mCurrentOffset == 0) {
                this.mIsReset = true;
                cancelAnimator();
                JRefreshHeader jRefreshHeader2 = this.mHeader;
                if (jRefreshHeader2 != null) {
                    jRefreshHeader2.onReset(this);
                    return;
                }
                return;
            }
            JRefreshHeader jRefreshHeader3 = this.mHeader;
            postDelayed(new Runnable() { // from class: cn.damai.h5container.refresh.JRefreshLayout.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "843699534")) {
                        ipChange2.ipc$dispatch("843699534", new Object[]{this});
                    } else {
                        JRefreshLayout.this.animTo(0);
                    }
                }
            }, jRefreshHeader3 == null ? 0L : z ? jRefreshHeader3.succeedRetention() : jRefreshHeader3.failingRetention());
        }
    }

    public void removeHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827828561")) {
            ipChange.ipc$dispatch("827828561", new Object[]{this});
            return;
        }
        View view = this.mHeaderView;
        if (view != null) {
            removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917411237")) {
            ipChange.ipc$dispatch("1917411237", new Object[]{this, Boolean.valueOf(z)});
        } else if (Build.VERSION.SDK_INT >= 21 || !(this.mContentView instanceof AbsListView)) {
            View view = this.mContentView;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setChildScrollViewId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1803536488")) {
            ipChange.ipc$dispatch("1803536488", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.childScrollViewId = i;
        }
    }

    public void setDefaultMaxOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717483213")) {
            ipChange.ipc$dispatch("-717483213", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.defaultMaxOffset = i;
        }
    }

    public void setDefaultRefreshHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1124348798")) {
            ipChange.ipc$dispatch("1124348798", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.defaultRefreshHeight = i;
        }
    }

    public void setDurationOffset(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349288357")) {
            ipChange.ipc$dispatch("349288357", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mDurationOffset = j;
        }
    }

    public void setFlingSlop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361835349")) {
            ipChange.ipc$dispatch("1361835349", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mFlingSlop = i;
        }
    }

    public void setHeaderOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1297951395")) {
            ipChange.ipc$dispatch("-1297951395", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mHeaderOffset = i;
        }
    }

    public void setHeaderView(JRefreshHeader jRefreshHeader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431267813")) {
            ipChange.ipc$dispatch("1431267813", new Object[]{this, jRefreshHeader});
        } else {
            setHeaderView(jRefreshHeader, -1, -2);
        }
    }

    public void setJRefreshListener(JRefreshListener jRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822484780")) {
            ipChange.ipc$dispatch("822484780", new Object[]{this, jRefreshListener});
        } else {
            this.mRefreshListener = jRefreshListener;
        }
    }

    public void setJScrollListener(JScrollListener jScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-6612932")) {
            ipChange.ipc$dispatch("-6612932", new Object[]{this, jScrollListener});
        } else {
            this.mScrollListener = jScrollListener;
        }
    }

    public void setKeepHeaderWhenRefresh(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602867231")) {
            ipChange.ipc$dispatch("602867231", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mKeepHeaderWhenRefresh = z;
        }
    }

    public void setPinContent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942423186")) {
            ipChange.ipc$dispatch("1942423186", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsPinContent = z;
        }
    }

    public void setRefreshEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1550432402")) {
            ipChange.ipc$dispatch("-1550432402", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mRefreshEnable = z;
        }
    }

    public void setTouchSlop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2092944328")) {
            ipChange.ipc$dispatch("-2092944328", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mTouchSlop = i;
        }
    }

    public void startRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "507969641")) {
            ipChange.ipc$dispatch("507969641", new Object[]{this});
        } else if (this.mRefreshing || !this.mRefreshEnable) {
        } else {
            postDelayed(new Runnable() { // from class: cn.damai.h5container.refresh.JRefreshLayout.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1040213039")) {
                        ipChange2.ipc$dispatch("1040213039", new Object[]{this});
                        return;
                    }
                    JRefreshLayout.this.mRefreshing = true;
                    JRefreshLayout.this.mIsReset = false;
                    if (JRefreshLayout.this.mHeader != null) {
                        JRefreshLayout.this.mHeader.onRefresh(JRefreshLayout.this);
                    }
                    if (JRefreshLayout.this.mRefreshListener != null) {
                        JRefreshLayout.this.mRefreshListener.onRefresh(JRefreshLayout.this);
                    }
                    JRefreshLayout.this.mContentView.scrollTo(0, 0);
                    JRefreshLayout jRefreshLayout = JRefreshLayout.this;
                    jRefreshLayout.animTo(jRefreshLayout.mHeader == null ? JRefreshLayout.this.defaultRefreshHeight : JRefreshLayout.this.mHeader.refreshHeight());
                }
            }, 100L);
        }
    }

    public JRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1266358038") ? (LayoutParams) ipChange.ipc$dispatch("-1266358038", new Object[]{this}) : new LayoutParams(-1, -1);
    }

    public void setHeaderView(JRefreshHeader jRefreshHeader, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059775749")) {
            ipChange.ipc$dispatch("1059775749", new Object[]{this, jRefreshHeader, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).width = i;
        ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).height = i2;
        setHeaderView(jRefreshHeader, generateDefaultLayoutParams);
    }

    public JRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRefreshing = false;
        this.mIsReset = true;
        this.mIsBeingDragged = true;
        this.mIsFling = false;
        this.mGestureExecute = false;
        this.mNestedScrollExecute = false;
        this.mNestedScrollInProgress = false;
        this.mDurationOffset = 200L;
        this.mKeepHeaderWhenRefresh = true;
        this.mIsPinContent = false;
        this.mRefreshEnable = true;
        this.mFlingSlop = 1000;
        this.mHeaderOffset = 0;
        this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: cn.damai.h5container.refresh.JRefreshLayout.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1333266649")) {
                    ipChange.ipc$dispatch("-1333266649", new Object[]{this, valueAnimator});
                    return;
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                JRefreshLayout jRefreshLayout = JRefreshLayout.this;
                jRefreshLayout.moveView(intValue - jRefreshLayout.mCurrentOffset);
            }
        };
        this.mScroller = new OverScroller(context);
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(context, new RefreshGestureListener());
        this.mGesture = gestureDetectorCompat;
        gestureDetectorCompat.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.JRefreshLayout);
        this.mIsPinContent = obtainStyledAttributes.getBoolean(R$styleable.JRefreshLayout_j_pin_content, false);
        this.mKeepHeaderWhenRefresh = obtainStyledAttributes.getBoolean(R$styleable.JRefreshLayout_j_keep_header, true);
        this.mDurationOffset = obtainStyledAttributes.getInt(R$styleable.JRefreshLayout_j_duration_offset, 200);
        this.mRefreshEnable = obtainStyledAttributes.getBoolean(R$styleable.JRefreshLayout_j_refresh_enable, true);
        this.defaultRefreshHeight = obtainStyledAttributes.getLayoutDimension(R$styleable.JRefreshLayout_j_def_refresh_height, Integer.MAX_VALUE);
        this.defaultMaxOffset = obtainStyledAttributes.getLayoutDimension(R$styleable.JRefreshLayout_j_def_max_offset, this.defaultMaxOffset);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-14611611") ? (LayoutParams) ipChange.ipc$dispatch("-14611611", new Object[]{this, attributeSet}) : new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-36928650") ? (LayoutParams) ipChange.ipc$dispatch("-36928650", new Object[]{this, layoutParams}) : new LayoutParams(layoutParams);
    }

    public void setHeaderView(JRefreshHeader jRefreshHeader, LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418536933")) {
            ipChange.ipc$dispatch("1418536933", new Object[]{this, jRefreshHeader, layoutParams});
            return;
        }
        removeHeader();
        this.mHeader = jRefreshHeader;
        View view = (View) jRefreshHeader;
        this.mHeaderView = view;
        addView(view, 0, layoutParams);
        this.mHeaderView.bringToFront();
    }
}
