package com.taobao.weex.ui.view.refresh.core;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXSwipeLayout extends FrameLayout implements NestedScrollingChild, NestedScrollingParent {
    private static final float DAMPING = 0.4f;
    private static final int INVALID = -1;
    private static final int LOAD_MORE = 1;
    private static final int PULL_REFRESH = 0;
    private static final float overFlow = 1.0f;
    private WXRefreshView footerView;
    private WXRefreshView headerView;
    private boolean isConfirm;
    private volatile float loadingViewFlowHeight;
    private volatile float loadingViewHeight;
    private int mCurrentAction;
    private ViewParent mNestedScrollAcceptedParent;
    private boolean mNestedScrollInProgress;
    private NestedScrollingChildHelper mNestedScrollingChildHelper;
    private NestedScrollingParentHelper mNestedScrollingParentHelper;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    private int mProgressBgColor;
    private int mProgressColor;
    private boolean mPullLoadEnable;
    private boolean mPullRefreshEnable;
    private final List<OnRefreshOffsetChangedListener> mRefreshOffsetChangedListeners;
    private int mRefreshViewBgColor;
    private volatile boolean mRefreshing;
    private View mTargetView;
    private WXOnLoadingListener onLoadingListener;
    private WXOnRefreshListener onRefreshListener;
    private volatile float refreshViewFlowHeight;
    private volatile float refreshViewHeight;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnRefreshOffsetChangedListener {
        void onOffsetChanged(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface WXOnLoadingListener {
        void onLoading();

        void onPullingUp(float f, int i, float f2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface WXOnRefreshListener {
        void onPullingDown(float f, int i, float f2);

        void onRefresh();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class WXRefreshAnimatorListener implements Animator.AnimatorListener {
        WXRefreshAnimatorListener() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public WXSwipeLayout(Context context) {
        super(context);
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mRefreshOffsetChangedListeners = new LinkedList();
        this.mPullRefreshEnable = false;
        this.mPullLoadEnable = false;
        this.mRefreshing = false;
        this.refreshViewHeight = 0.0f;
        this.loadingViewHeight = 0.0f;
        this.refreshViewFlowHeight = 0.0f;
        this.loadingViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        initAttrs(context, null);
    }

    private double calculateDistanceY(View view, int i) {
        int measuredHeight;
        double abs = (((measuredHeight - Math.abs(view.getY())) / 1.0d) / view.getMeasuredHeight()) * 0.4000000059604645d;
        if (abs <= 0.01d) {
            abs = 0.01d;
        }
        return abs * i;
    }

    private void handlerAction() {
        if (isRefreshing()) {
            return;
        }
        this.isConfirm = false;
        if (this.mPullRefreshEnable && this.mCurrentAction == 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.headerView.getLayoutParams();
            if (layoutParams.height >= this.refreshViewHeight) {
                startRefresh(layoutParams.height);
            } else {
                int i = layoutParams.height;
                if (i > 0) {
                    resetHeaderView(i);
                } else {
                    resetRefreshState();
                }
            }
        }
        if (this.mPullLoadEnable && this.mCurrentAction == 1) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.footerView.getLayoutParams();
            if (layoutParams2.height >= this.loadingViewHeight) {
                startLoadmore(layoutParams2.height);
                return;
            }
            int i2 = layoutParams2.height;
            if (i2 > 0) {
                resetFootView(i2);
            } else {
                resetLoadmoreState();
            }
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        if (getChildCount() <= 1) {
            this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
            this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(false);
            if (isInEditMode() && attributeSet == null) {
                return;
            }
            this.mRefreshViewBgColor = 0;
            this.mProgressBgColor = 0;
            this.mProgressColor = SupportMenu.CATEGORY_MASK;
            return;
        }
        throw new RuntimeException("WXSwipeLayout should not have more than one child");
    }

    private boolean moveSpinner(float f) {
        if (this.mRefreshing) {
            return false;
        }
        if (!canChildScrollUp() && this.mPullRefreshEnable && this.mCurrentAction == 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.headerView.getLayoutParams();
            int i = (int) (layoutParams.height + f);
            layoutParams.height = i;
            if (i < 0) {
                layoutParams.height = 0;
            }
            if (layoutParams.height == 0) {
                this.isConfirm = false;
                this.mCurrentAction = -1;
            }
            this.headerView.setLayoutParams(layoutParams);
            this.onRefreshListener.onPullingDown(f, layoutParams.height, this.refreshViewFlowHeight);
            notifyOnRefreshOffsetChangedListener(layoutParams.height);
            this.headerView.setProgressRotation(layoutParams.height / this.refreshViewFlowHeight);
            moveTargetView(layoutParams.height);
            return true;
        } else if (!canChildScrollDown() && this.mPullLoadEnable && this.mCurrentAction == 1) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.footerView.getLayoutParams();
            int i2 = (int) (layoutParams2.height - f);
            layoutParams2.height = i2;
            if (i2 < 0) {
                layoutParams2.height = 0;
            }
            if (layoutParams2.height == 0) {
                this.isConfirm = false;
                this.mCurrentAction = -1;
            }
            this.footerView.setLayoutParams(layoutParams2);
            this.onLoadingListener.onPullingUp(f, layoutParams2.height, this.loadingViewFlowHeight);
            this.footerView.setProgressRotation(layoutParams2.height / this.loadingViewFlowHeight);
            moveTargetView(-layoutParams2.height);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTargetView(float f) {
        this.mTargetView.setTranslationY(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnRefreshOffsetChangedListener(int i) {
        int size = this.mRefreshOffsetChangedListeners.size();
        for (int i2 = 0; i2 < size && i2 < this.mRefreshOffsetChangedListeners.size(); i2++) {
            OnRefreshOffsetChangedListener onRefreshOffsetChangedListener = this.mRefreshOffsetChangedListeners.get(i2);
            if (onRefreshOffsetChangedListener != null) {
                onRefreshOffsetChangedListener.onOffsetChanged(i);
            }
        }
    }

    private void resetFootView(int i) {
        this.footerView.stopAnimation();
        this.footerView.setStartEndTrim(0.5f, 1.25f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WXSwipeLayout.this.footerView.getLayoutParams();
                layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                WXSwipeLayout.this.footerView.setLayoutParams(layoutParams);
                WXSwipeLayout.this.moveTargetView(-layoutParams.height);
            }
        });
        ofFloat.addListener(new WXRefreshAnimatorListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.8
            @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WXSwipeLayout.this.resetLoadmoreState();
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private void resetHeaderView(int i) {
        this.headerView.stopAnimation();
        this.headerView.setStartEndTrim(0.0f, 0.75f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WXSwipeLayout.this.headerView.getLayoutParams();
                int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                layoutParams.height = floatValue;
                WXSwipeLayout.this.notifyOnRefreshOffsetChangedListener(floatValue);
                WXSwipeLayout.this.headerView.setLayoutParams(layoutParams);
                WXSwipeLayout.this.moveTargetView(layoutParams.height);
            }
        });
        ofFloat.addListener(new WXRefreshAnimatorListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.4
            @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WXSwipeLayout.this.resetRefreshState();
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetLoadmoreState() {
        this.mRefreshing = false;
        this.isConfirm = false;
        this.mCurrentAction = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRefreshState() {
        this.mRefreshing = false;
        this.isConfirm = false;
        this.mCurrentAction = -1;
    }

    private void setRefreshView() {
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 0);
        WXRefreshView wXRefreshView = new WXRefreshView(getContext());
        this.headerView = wXRefreshView;
        wXRefreshView.setStartEndTrim(0.0f, 0.75f);
        this.headerView.setBackgroundColor(this.mRefreshViewBgColor);
        this.headerView.setProgressBgColor(this.mProgressBgColor);
        this.headerView.setProgressColor(this.mProgressColor);
        this.headerView.setContentGravity(80);
        addView(this.headerView, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, 0);
        layoutParams2.gravity = 80;
        WXRefreshView wXRefreshView2 = new WXRefreshView(getContext());
        this.footerView = wXRefreshView2;
        wXRefreshView2.setStartEndTrim(0.5f, 1.25f);
        this.footerView.setBackgroundColor(this.mRefreshViewBgColor);
        this.footerView.setProgressBgColor(this.mProgressBgColor);
        this.footerView.setProgressColor(this.mProgressColor);
        this.footerView.setContentGravity(48);
        addView(this.footerView, layoutParams2);
    }

    private void startLoadmore(int i) {
        this.mRefreshing = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, this.loadingViewHeight);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WXSwipeLayout.this.footerView.getLayoutParams();
                layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                WXSwipeLayout.this.footerView.setLayoutParams(layoutParams);
                WXSwipeLayout.this.moveTargetView(-layoutParams.height);
            }
        });
        ofFloat.addListener(new WXRefreshAnimatorListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.6
            @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WXSwipeLayout.this.footerView.startAnimation();
                if (WXSwipeLayout.this.onLoadingListener != null) {
                    WXSwipeLayout.this.onLoadingListener.onLoading();
                }
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private void startRefresh(int i) {
        this.mRefreshing = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, this.refreshViewHeight);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WXSwipeLayout.this.headerView.getLayoutParams();
                int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                layoutParams.height = floatValue;
                WXSwipeLayout.this.notifyOnRefreshOffsetChangedListener(floatValue);
                WXSwipeLayout.this.headerView.setLayoutParams(layoutParams);
                WXSwipeLayout.this.moveTargetView(layoutParams.height);
            }
        });
        ofFloat.addListener(new WXRefreshAnimatorListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.2
            @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WXSwipeLayout.this.headerView.startAnimation();
                if (WXSwipeLayout.this.onRefreshListener != null) {
                    WXSwipeLayout.this.onRefreshListener.onRefresh();
                }
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void addOnRefreshOffsetChangedListener(@Nullable OnRefreshOffsetChangedListener onRefreshOffsetChangedListener) {
        if (onRefreshOffsetChangedListener == null || this.mRefreshOffsetChangedListeners.contains(onRefreshOffsetChangedListener)) {
            return;
        }
        this.mRefreshOffsetChangedListeners.add(onRefreshOffsetChangedListener);
    }

    public void addTargetView(View view) {
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        setRefreshView();
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean canChildScrollDown() {
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return ViewCompat.canScrollVertically(view, 1) || this.mTargetView.getScrollY() > 0;
            }
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() > 0) {
                return absListView.getLastVisiblePosition() == ((ListAdapter) absListView.getAdapter()).getCount() - 1 && absListView.getChildAt(absListView.getChildCount() - 1).getBottom() <= absListView.getMeasuredHeight();
            }
            return false;
        }
        return ViewCompat.canScrollVertically(view, 1);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean canChildScrollUp() {
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return ViewCompat.canScrollVertically(view, -1) || this.mTargetView.getScrollY() > 0;
            }
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() > 0) {
                return absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop();
            }
            return false;
        }
        return ViewCompat.canScrollVertically(view, -1);
    }

    public float dipToPx(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public void finishPullLoad() {
        if (this.mCurrentAction == 1) {
            WXRefreshView wXRefreshView = this.footerView;
            resetFootView(wXRefreshView == null ? 0 : wXRefreshView.getMeasuredHeight());
        }
    }

    public void finishPullRefresh() {
        if (this.mCurrentAction == 0) {
            WXRefreshView wXRefreshView = this.headerView;
            resetHeaderView(wXRefreshView == null ? 0 : wXRefreshView.getMeasuredHeight());
        }
    }

    public WXRefreshView getFooterView() {
        return this.footerView;
    }

    public WXRefreshView getHeaderView() {
        return this.headerView;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public boolean isPullLoadEnable() {
        return this.mPullLoadEnable;
    }

    public boolean isPullRefreshEnable() {
        return this.mPullRefreshEnable;
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mTargetView == null && getChildCount() > 0) {
            this.mTargetView = getChildAt(0);
        }
        if (this.mTargetView != null) {
            if (this.headerView == null || this.footerView == null) {
                setRefreshView();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((!this.mPullRefreshEnable && !this.mPullLoadEnable) || !isEnabled() || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (isNestedScrollingEnabled()) {
            return dispatchNestedFling(f, f2, z);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        if (isNestedScrollingEnabled()) {
            return dispatchNestedPreFling(f, f2);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        ViewParent viewParent;
        int[] iArr2 = this.mParentScrollConsumed;
        if (isNestedScrollingEnabled() && dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        } else if (this.mPullRefreshEnable || this.mPullLoadEnable) {
            if (!canChildScrollUp() && isNestedScrollingEnabled() && (viewParent = this.mNestedScrollAcceptedParent) != null && viewParent != this.mTargetView) {
                ViewGroup viewGroup = (ViewGroup) viewParent;
                if (viewGroup.getChildCount() > 0) {
                    int childCount = viewGroup.getChildCount();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        View childAt = viewGroup.getChildAt(i3);
                        if (childAt.getVisibility() == 8 || childAt.getMeasuredHeight() <= 0) {
                            i3++;
                        } else if (childAt.getTop() < 0) {
                            return;
                        }
                    }
                }
            }
            int calculateDistanceY = (int) calculateDistanceY(view, i2);
            this.mRefreshing = false;
            if (!this.isConfirm) {
                if (calculateDistanceY < 0 && !canChildScrollUp()) {
                    this.mCurrentAction = 0;
                    this.isConfirm = true;
                } else if (calculateDistanceY > 0 && !canChildScrollDown() && !this.mRefreshing) {
                    this.mCurrentAction = 1;
                    this.isConfirm = true;
                }
            }
            if (moveSpinner(-calculateDistanceY)) {
                if (!canChildScrollUp() && this.mPullRefreshEnable && this.mTargetView.getTranslationY() > 0.0f && i2 > 0) {
                    iArr[1] = iArr[1] + i2;
                } else if (!canChildScrollDown() && this.mPullLoadEnable && this.mTargetView.getTranslationY() < 0.0f && i2 < 0) {
                    iArr[1] = iArr[1] + i2;
                } else {
                    iArr[1] = iArr[1] + calculateDistanceY;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        if (isNestedScrollingEnabled()) {
            dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        if (isNestedScrollingEnabled()) {
            startNestedScroll(i & 2);
            this.mNestedScrollInProgress = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.mRefreshing || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        handlerAction();
        if (isNestedScrollingEnabled()) {
            this.mNestedScrollInProgress = true;
            stopNestedScroll();
        }
    }

    public boolean removeOnRefreshOffsetChangedListener(@Nullable OnRefreshOffsetChangedListener onRefreshOffsetChangedListener) {
        if (onRefreshOffsetChangedListener != null) {
            return this.mRefreshOffsetChangedListeners.remove(onRefreshOffsetChangedListener);
        }
        return false;
    }

    public void setLoadingBgColor(int i) {
        this.footerView.setBackgroundColor(i);
    }

    public void setLoadingHeight(int i) {
        this.loadingViewHeight = i;
        this.loadingViewFlowHeight = this.loadingViewHeight * 1.0f;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
    }

    public void setOnLoadingListener(WXOnLoadingListener wXOnLoadingListener) {
        this.onLoadingListener = wXOnLoadingListener;
    }

    public void setOnRefreshListener(WXOnRefreshListener wXOnRefreshListener) {
        this.onRefreshListener = wXOnRefreshListener;
    }

    public void setPullLoadEnable(boolean z) {
        this.mPullLoadEnable = z;
    }

    public void setPullRefreshEnable(boolean z) {
        this.mPullRefreshEnable = z;
    }

    public void setRefreshBgColor(int i) {
        this.headerView.setBackgroundColor(i);
    }

    public void setRefreshHeight(int i) {
        this.refreshViewHeight = i;
        this.refreshViewFlowHeight = this.refreshViewHeight * 1.0f;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        boolean startNestedScroll = this.mNestedScrollingChildHelper.startNestedScroll(i);
        if (startNestedScroll && this.mNestedScrollAcceptedParent == null) {
            ViewParent parent = getParent();
            View view = this;
            while (true) {
                if (parent == null) {
                    break;
                } else if (ViewParentCompat.onStartNestedScroll(parent, view, this, i)) {
                    this.mNestedScrollAcceptedParent = parent;
                    break;
                } else {
                    if (parent instanceof View) {
                        view = (View) parent;
                    }
                    parent = parent.getParent();
                    view = view;
                }
            }
        }
        return startNestedScroll;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
        if (this.mNestedScrollAcceptedParent != null) {
            this.mNestedScrollAcceptedParent = null;
        }
    }

    public WXSwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mRefreshOffsetChangedListeners = new LinkedList();
        this.mPullRefreshEnable = false;
        this.mPullLoadEnable = false;
        this.mRefreshing = false;
        this.refreshViewHeight = 0.0f;
        this.loadingViewHeight = 0.0f;
        this.refreshViewFlowHeight = 0.0f;
        this.loadingViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        initAttrs(context, attributeSet);
    }

    public WXSwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mRefreshOffsetChangedListeners = new LinkedList();
        this.mPullRefreshEnable = false;
        this.mPullLoadEnable = false;
        this.mRefreshing = false;
        this.refreshViewHeight = 0.0f;
        this.loadingViewHeight = 0.0f;
        this.refreshViewFlowHeight = 0.0f;
        this.loadingViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        initAttrs(context, attributeSet);
    }

    @TargetApi(21)
    public WXSwipeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mRefreshOffsetChangedListeners = new LinkedList();
        this.mPullRefreshEnable = false;
        this.mPullLoadEnable = false;
        this.mRefreshing = false;
        this.refreshViewHeight = 0.0f;
        this.loadingViewHeight = 0.0f;
        this.refreshViewFlowHeight = 0.0f;
        this.loadingViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        initAttrs(context, attributeSet);
    }
}
