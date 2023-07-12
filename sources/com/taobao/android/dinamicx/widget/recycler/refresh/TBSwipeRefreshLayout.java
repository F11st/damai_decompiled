package com.taobao.android.dinamicx.widget.recycler.refresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.android.dinamic.R$attr;
import com.taobao.android.dinamic.R$dimen;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBLoadMoreFooter;
import tb.qz;

/* compiled from: Taobao */
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes12.dex */
public class TBSwipeRefreshLayout extends ViewGroup {
    private static final int ANIMATE_TO_BOTTOM_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 300;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 300;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    private static final float DRAG_RATE = 1.0f;
    private static int FOOTER_VIEW_HEIGHT = 50;
    private static int FOOTER_VIEW_MAX_HEIGHT = 100;
    private static int HEADER_VIEW_HEIGHT = 72;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS = {R$attr.uik_swipeRefreshPullRefresh, R$attr.uik_swipeRefreshPushLoad, R$attr.uik_swipeRefreshSecondFloor, R$attr.uik_swipeRefreshHeaderHeight, R$attr.uik_swipeRefreshFooterHeight, R$attr.uik_swipeRefreshLazyPullRefresh, R$attr.uik_swipeRefreshLazyPushLoad};
    private static int MIN_GAP_DISTANCE_TO_SECOND_FLOOR = 20;
    private static final String TAG = "TBSwipeRefreshLayout";
    private int mActivePointerId;
    private long mAutoRefreshDuration;
    private int mContentHeight;
    protected int mCurrentTargetOffsetTop;
    private DecelerateInterpolator mDecelerateInterpolator;
    protected float mDensity;
    protected DisplayMetrics mDisplayMetrics;
    private int mDistance;
    private float mDragRate;
    private boolean mEnableTargetOffset;
    private TBLoadMoreFooter mFooterView;
    protected int mFooterViewHeight;
    private int mFooterViewIndex;
    protected int mFooterViewWidth;
    protected int mFrom;
    private TBAbsRefreshHeader mHeaderView;
    protected int mHeaderViewHeight;
    private int mHeaderViewIndex;
    protected int mHeaderViewWidth;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private boolean mIsMultiPointer;
    private float mLastMotionY;
    private boolean mLazyLoadMoreEnable;
    private boolean mLazyPullRefreshEnable;
    private boolean mLoadMoreEnabled;
    private boolean mLoadingMore;
    private int mMaxPullDistance;
    private int mMaxPushDistance;
    private int mNavigationBarHeight;
    private boolean mNotify;
    private OnChildScrollUpCallback mOnChildScrollUpCallback;
    private OnPushLoadMoreListener mOnPushLoadMoreListener;
    private boolean mOriginalOffsetCalculated;
    protected int mOriginalOffsetTop;
    private int mPositionY;
    private int mPreActivePointerId;
    private int mPreDistance;
    private int mPrePositionY;
    private boolean mPullRefreshEnabled;
    private OnPullRefreshListener mPullRefreshListener;
    private int mPushDistance;
    private Animator.AnimatorListener mRefreshListener;
    protected int mRefreshOffset;
    private boolean mRefreshing;
    private int mSecondFloorDistance;
    private boolean mSecondFloorEnabled;
    private int mStartY;
    private View mTarget;
    private boolean mTargetScrollWithLayout;
    private int mTotalDragDistance;
    protected int mTouchSlop;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(TBSwipeRefreshLayout tBSwipeRefreshLayout);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnPullRefreshListener {
        void onPullDistance(int i);

        void onRefresh();

        void onRefreshStateChanged(TBAbsRefreshHeader.RefreshState refreshState, TBAbsRefreshHeader.RefreshState refreshState2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnPushLoadMoreListener {
        void onLoadMore();

        void onLoadMoreStateChanged(TBLoadMoreFooter.LoadMoreState loadMoreState, TBLoadMoreFooter.LoadMoreState loadMoreState2);

        void onPushDistance(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout$a */
    /* loaded from: classes12.dex */
    class C6521a implements Animator.AnimatorListener {
        C6521a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (TBSwipeRefreshLayout.this.mHeaderView != null) {
                if (TBSwipeRefreshLayout.this.mRefreshing) {
                    if (TBSwipeRefreshLayout.this.mNotify && TBSwipeRefreshLayout.this.mPullRefreshListener != null) {
                        TBSwipeRefreshLayout.this.mPullRefreshListener.onRefresh();
                    }
                    TBSwipeRefreshLayout.this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.REFRESHING);
                } else {
                    TBSwipeRefreshLayout tBSwipeRefreshLayout = TBSwipeRefreshLayout.this;
                    tBSwipeRefreshLayout.updateHeaderPosition(tBSwipeRefreshLayout.mOriginalOffsetTop - tBSwipeRefreshLayout.mCurrentTargetOffsetTop);
                }
                TBSwipeRefreshLayout tBSwipeRefreshLayout2 = TBSwipeRefreshLayout.this;
                tBSwipeRefreshLayout2.mCurrentTargetOffsetTop = tBSwipeRefreshLayout2.mHeaderView.getTop();
                TBSwipeRefreshLayout.this.updatePullListenerCallBack();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout$b */
    /* loaded from: classes12.dex */
    public class C6522b implements Animator.AnimatorListener {
        C6522b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TBSwipeRefreshLayout.this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_END);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout$c */
    /* loaded from: classes12.dex */
    public class C6523c implements ValueAnimator.AnimatorUpdateListener {
        C6523c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TBSwipeRefreshLayout.this.mPushDistance = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TBSwipeRefreshLayout.this.updateFooterPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout$d */
    /* loaded from: classes12.dex */
    public class C6524d extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        C6524d(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a <= 0 || TBSwipeRefreshLayout.this.mOnPushLoadMoreListener == null) {
                TBSwipeRefreshLayout.this.mLoadingMore = false;
                TBSwipeRefreshLayout.this.mFooterView.changeToState(TBLoadMoreFooter.LoadMoreState.NONE);
                return;
            }
            TBSwipeRefreshLayout.this.mLoadingMore = true;
            TBSwipeRefreshLayout.this.mFooterView.changeToState(TBLoadMoreFooter.LoadMoreState.LOADING);
            TBSwipeRefreshLayout.this.mOnPushLoadMoreListener.onLoadMore();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout$e */
    /* loaded from: classes12.dex */
    public class C6525e implements ValueAnimator.AnimatorUpdateListener {
        C6525e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TBSwipeRefreshLayout.this.updateHeaderPosition(((Integer) valueAnimator.getAnimatedValue()).intValue() - TBSwipeRefreshLayout.this.mHeaderView.getTop());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout$f */
    /* loaded from: classes12.dex */
    public class C6526f implements ValueAnimator.AnimatorUpdateListener {
        C6526f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TBAbsRefreshHeader tBAbsRefreshHeader = TBSwipeRefreshLayout.this.mHeaderView;
            TBSwipeRefreshLayout tBSwipeRefreshLayout = TBSwipeRefreshLayout.this;
            int i = tBSwipeRefreshLayout.mFrom;
            tBAbsRefreshHeader.setProgress((intValue - i) / ((tBSwipeRefreshLayout.mOriginalOffsetTop - i) * 1.0f));
            TBSwipeRefreshLayout tBSwipeRefreshLayout2 = TBSwipeRefreshLayout.this;
            tBSwipeRefreshLayout2.updateHeaderPosition(intValue - tBSwipeRefreshLayout2.mHeaderView.getTop());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout$g */
    /* loaded from: classes12.dex */
    public class C6527g implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ValueAnimator a;

        C6527g(ValueAnimator valueAnimator) {
            this.a = valueAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TBSwipeRefreshLayout.this.updateHeaderPosition(((Integer) this.a.getAnimatedValue()).intValue() - TBSwipeRefreshLayout.this.mHeaderView.getTop());
        }
    }

    public TBSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void animateOffsetToBottomPosition(int i, Animator.AnimatorListener animatorListener) {
        this.mFrom = i;
        new ValueAnimator();
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mFrom, 0);
        ofInt.addUpdateListener(new C6527g(ofInt));
        ofInt.setDuration(300L);
        ofInt.setInterpolator(this.mDecelerateInterpolator);
        if (animatorListener != null) {
            ofInt.addListener(animatorListener);
        }
        ofInt.start();
    }

    private void animateOffsetToCorrectPosition(int i, Animator.AnimatorListener animatorListener) {
        int i2;
        int abs;
        this.mFrom = i;
        if (this.mEnableTargetOffset) {
            i2 = this.mHeaderViewHeight - Math.abs(this.mOriginalOffsetTop);
            abs = this.mRefreshOffset;
        } else {
            i2 = this.mHeaderViewHeight;
            abs = Math.abs(this.mOriginalOffsetTop);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mFrom, i2 - abs);
        if (animatorListener != null) {
            ofInt.addListener(animatorListener);
        }
        ofInt.addUpdateListener(new C6525e());
        ofInt.setDuration(300L);
        ofInt.setInterpolator(this.mDecelerateInterpolator);
        ofInt.start();
    }

    private void animateOffsetToStartPosition(int i, Animator.AnimatorListener animatorListener) {
        this.mFrom = i;
        ValueAnimator ofInt = ValueAnimator.ofInt(i, this.mOriginalOffsetTop);
        ofInt.addUpdateListener(new C6526f());
        ofInt.setDuration(300L);
        ofInt.setInterpolator(this.mDecelerateInterpolator);
        if (animatorListener != null) {
            ofInt.addListener(animatorListener);
        }
        ofInt.start();
    }

    @TargetApi(11)
    private void animatorFooterToBottom(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(150L);
        ofInt.addUpdateListener(new C6523c());
        ofInt.addListener(new C6524d(i2));
        ofInt.setInterpolator(this.mDecelerateInterpolator);
        ofInt.start();
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.mHeaderView) && !childAt.equals(this.mFooterView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private float getMotionEventY(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private boolean handlePullTouchEvent(MotionEvent motionEvent, int i) {
        int i2;
        int i3;
        if (i != 1) {
            if (i == 2) {
                if (this.mActivePointerId == -1) {
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                    this.mLastMotionY = motionEvent.getY();
                    this.mPreActivePointerId = this.mActivePointerId;
                }
                try {
                    int y = (int) MotionEventCompat.getY(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId));
                    if (this.mIsMultiPointer) {
                        int i4 = this.mPreActivePointerId;
                        int i5 = this.mActivePointerId;
                        if (i4 == i5) {
                            float f = y;
                            float f2 = this.mLastMotionY;
                            i2 = (int) (this.mDistance + (f - f2));
                            this.mPreDistance = i2;
                            this.mPrePositionY = (int) (this.mPositionY + (f - f2));
                        } else {
                            int i6 = this.mPreDistance;
                            int i7 = (int) (i6 + (y - this.mLastMotionY));
                            int i8 = this.mPrePositionY;
                            this.mPreActivePointerId = i5;
                            this.mDistance = i6;
                            this.mPositionY = i8;
                            i2 = i7;
                        }
                    } else {
                        i2 = y - this.mStartY;
                        this.mDistance = i2;
                        this.mPreDistance = i2;
                        this.mPositionY = y;
                        this.mPrePositionY = y;
                    }
                    if (this.mIsBeingDragged) {
                        int i9 = (int) (i2 * this.mDragRate);
                        int min = Math.min(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(this.mDisplayMetrics), (int) (i9 * ((float) ((i3 / (i3 + i9)) / 1.1d))));
                        int i10 = this.mMaxPullDistance;
                        if (i10 > 0) {
                            min = Math.min(min, i10);
                        }
                        float f3 = (min * 1.0f) / this.mTotalDragDistance;
                        if (f3 < 0.0f) {
                            return false;
                        }
                        float min2 = Math.min(1.0f, Math.abs(f3));
                        if (min < this.mTotalDragDistance) {
                            this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.PULL_TO_REFRESH);
                        } else if (this.mSecondFloorEnabled) {
                            if (min > this.mSecondFloorDistance) {
                                this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.PREPARE_TO_SECOND_FLOOR);
                            } else {
                                this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.RELEASE_TO_REFRESH);
                            }
                        } else {
                            this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.RELEASE_TO_REFRESH);
                        }
                        this.mHeaderView.setProgress(min2);
                        updateHeaderPosition(min - (this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop));
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            } else if (i != 3) {
                if (i == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    if (actionIndex < 0) {
                        return false;
                    }
                    this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    this.mIsMultiPointer = true;
                } else if (i == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
            }
            return true;
        }
        if (this.mActivePointerId == -1) {
            if (i == 1) {
                Log.e(TAG, "Got ACTION_UP event but don't have an active pointer id.");
            }
            return false;
        }
        this.mIsBeingDragged = false;
        if (this.mHeaderView.getCurrentState() == TBAbsRefreshHeader.RefreshState.PREPARE_TO_SECOND_FLOOR && this.mSecondFloorEnabled) {
            this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_START);
            animateOffsetToBottomPosition(this.mCurrentTargetOffsetTop, new C6522b());
        } else if (this.mHeaderView.getCurrentState() == TBAbsRefreshHeader.RefreshState.RELEASE_TO_REFRESH) {
            setRefreshing(true, true);
        } else {
            this.mRefreshing = false;
            this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.NONE);
            animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, null);
        }
        this.mActivePointerId = -1;
        this.mIsMultiPointer = false;
        this.mDistance = 0;
        this.mPositionY = 0;
        return false;
    }

    private boolean handlePushTouchEvent(MotionEvent motionEvent, int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    if (findPointerIndex < 0) {
                        Log.e(TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float y = (this.mInitialMotionY - MotionEventCompat.getY(motionEvent, findPointerIndex)) * this.mDragRate;
                    if (this.mIsBeingDragged) {
                        this.mPushDistance = Math.min((int) y, this.mMaxPushDistance);
                        updateFooterPosition();
                        if (this.mOnPushLoadMoreListener != null) {
                            if (this.mPushDistance >= this.mFooterViewHeight) {
                                this.mFooterView.changeToState(TBLoadMoreFooter.LoadMoreState.RELEASE_TO_LOAD);
                            } else {
                                this.mFooterView.changeToState(TBLoadMoreFooter.LoadMoreState.PUSH_TO_LOAD);
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 5) {
                        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                    } else if (i == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            int i2 = this.mActivePointerId;
            if (i2 == -1) {
                if (i == 1) {
                    Log.e(TAG, "Got ACTION_UP event but don't have an active pointer id.");
                }
                return false;
            }
            int findPointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex2 < 0) {
                return false;
            }
            float min = Math.min((this.mInitialMotionY - MotionEventCompat.getY(motionEvent, findPointerIndex2)) * this.mDragRate, this.mMaxPushDistance);
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            int i3 = this.mFooterViewHeight;
            if (min >= i3 && this.mOnPushLoadMoreListener != null) {
                this.mPushDistance = i3;
            } else {
                this.mPushDistance = 0;
            }
            animatorFooterToBottom((int) min, this.mPushDistance);
            return false;
        }
        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.mIsBeingDragged = false;
        return true;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = MotionEventCompat.getY(motionEvent, i);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
        }
        int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
        if (this.mActivePointerId == -1) {
            return;
        }
        this.mLastMotionY = MotionEventCompat.getY(motionEvent, pointerIndex);
    }

    private void startScaleUpAnimation(Animator.AnimatorListener animatorListener) {
        this.mHeaderView.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(getResources().getInteger(17694721));
        if (animatorListener != null) {
            ofInt.addListener(animatorListener);
        }
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFooterPosition() {
        this.mFooterView.setVisibility(0);
        this.mFooterView.bringToFront();
        if (Build.VERSION.SDK_INT < 19) {
            this.mFooterView.getParent().requestLayout();
        }
        this.mFooterView.offsetTopAndBottom(-this.mPushDistance);
        updateLoadMoreListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeaderPosition(int i) {
        this.mHeaderView.bringToFront();
        this.mHeaderView.offsetTopAndBottom(i);
        this.mTarget.offsetTopAndBottom(i);
        this.mCurrentTargetOffsetTop = this.mHeaderView.getTop();
        updatePullListenerCallBack();
    }

    private void updateLoadMoreListener() {
        OnPushLoadMoreListener onPushLoadMoreListener = this.mOnPushLoadMoreListener;
        if (onPushLoadMoreListener != null) {
            onPushLoadMoreListener.onPushDistance(this.mPushDistance);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePullListenerCallBack() {
        int i = this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop;
        OnPullRefreshListener onPullRefreshListener = this.mPullRefreshListener;
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onPullDistance(i);
        }
    }

    protected void createFooterView() {
        TBDefaultLoadMoreFooter tBDefaultLoadMoreFooter = new TBDefaultLoadMoreFooter(getContext());
        this.mFooterView = tBDefaultLoadMoreFooter;
        OnPushLoadMoreListener onPushLoadMoreListener = this.mOnPushLoadMoreListener;
        if (onPushLoadMoreListener != null) {
            tBDefaultLoadMoreFooter.setPushLoadMoreListener(onPushLoadMoreListener);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mFooterViewHeight);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        addView(this.mFooterView, layoutParams);
    }

    protected void createHeaderView() {
        TBRefreshHeader tBRefreshHeader = new TBRefreshHeader(getContext());
        this.mHeaderView = tBRefreshHeader;
        OnPullRefreshListener onPullRefreshListener = this.mPullRefreshListener;
        if (onPullRefreshListener != null) {
            tBRefreshHeader.setPullRefreshListener(onPullRefreshListener);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(this.mHeaderView, layoutParams);
    }

    public void enableLoadMore(boolean z) {
        this.mLoadMoreEnabled = z;
        if (z && this.mFooterView == null) {
            createFooterView();
        }
    }

    public void enablePullRefresh(boolean z) {
        this.mPullRefreshEnabled = z;
        if (z && this.mHeaderView == null) {
            createHeaderView();
        }
    }

    public void enableSecondFloor(boolean z) {
        this.mSecondFloorEnabled = z;
    }

    public void enableTargetOffset(boolean z) {
        this.mEnableTargetOffset = z;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3;
        int i4 = this.mHeaderViewIndex;
        if (i4 >= 0 || this.mFooterViewIndex >= 0) {
            if (i4 < 0 || (i3 = this.mFooterViewIndex) < 0) {
                if (i4 < 0) {
                    i4 = this.mFooterViewIndex;
                }
                return i2 == i + (-1) ? i4 : i2 >= i4 ? i2 + 1 : i2;
            } else if (i2 == i - 2) {
                return i4;
            } else {
                if (i2 == i - 1) {
                    return i3;
                }
                int i5 = i3 > i4 ? i3 : i4;
                if (i3 < i4) {
                    i4 = i3;
                }
                return (i2 < i4 || i2 >= i5 + (-1)) ? (i2 >= i5 || i2 == i5 + (-1)) ? i2 + 2 : i2 : i2 + 1;
            }
        }
        return i2;
    }

    public float getDistanceToRefresh() {
        return this.mTotalDragDistance;
    }

    public float getDistanceToSecondFloor() {
        return this.mSecondFloorDistance;
    }

    public int getFooterViewHeight() {
        return this.mFooterViewHeight;
    }

    public int getHeaderViewHeight() {
        return this.mHeaderViewHeight;
    }

    public TBLoadMoreFooter getLoadMoreFooter() {
        return this.mFooterView;
    }

    public TBAbsRefreshHeader getRefresHeader() {
        return this.mHeaderView;
    }

    public int getRefreshOffset() {
        return this.mRefreshOffset;
    }

    public boolean isChildScrollToBottom() {
        int lastVisiblePosition;
        if (isChildScrollToTop()) {
            return false;
        }
        View view = this.mTarget;
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int itemCount = recyclerView.getAdapter().getItemCount();
            if ((layoutManager instanceof LinearLayoutManager) && itemCount > 0) {
                if (((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == itemCount - 1) {
                    return true;
                }
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] iArr = new int[2];
                ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(iArr);
                if (Math.max(iArr[0], iArr[1]) == itemCount - 1) {
                    return true;
                }
            }
            return false;
        } else if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            int count = ((ListAdapter) absListView.getAdapter()).getCount();
            return (absListView.getFirstVisiblePosition() != 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop()) && (lastVisiblePosition = absListView.getLastVisiblePosition()) > 0 && count > 0 && lastVisiblePosition == count - 1;
        } else {
            if (view instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) view;
                View childAt = scrollView.getChildAt(scrollView.getChildCount() - 1);
                if (childAt != null && childAt.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()) == 0) {
                    return true;
                }
            } else if (view instanceof NestedScrollView) {
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                View childAt2 = nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);
                if (childAt2 != null && childAt2.getBottom() - (nestedScrollView.getHeight() + nestedScrollView.getScrollY()) == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isChildScrollToTop() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.mOnChildScrollUpCallback;
        if (onChildScrollUpCallback != null) {
            return !onChildScrollUpCallback.canChildScrollUp(this);
        }
        return !ViewCompat.canScrollVertically(this.mTarget, -1);
    }

    public boolean isRefreshing() {
        return (getRefresHeader() == null || getRefresHeader().getCurrentState() == TBAbsRefreshHeader.RefreshState.NONE) ? false : true;
    }

    public boolean isTargetScrollWithLayout() {
        return this.mTargetScrollWithLayout;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mDensity = displayMetrics.density;
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        this.mHeaderViewHeight = i;
        this.mFooterViewHeight = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TBLoadMoreFooter tBLoadMoreFooter;
        TBAbsRefreshHeader tBAbsRefreshHeader;
        ensureTarget();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean isChildScrollToTop = this.mPullRefreshEnabled ? isChildScrollToTop() : false;
        if (!isChildScrollToTop && (tBAbsRefreshHeader = this.mHeaderView) != null && tBAbsRefreshHeader.getCurrentState() != TBAbsRefreshHeader.RefreshState.NONE) {
            isChildScrollToTop = true;
        }
        TBAbsRefreshHeader tBAbsRefreshHeader2 = this.mHeaderView;
        isChildScrollToTop = (tBAbsRefreshHeader2 == null || tBAbsRefreshHeader2.getCurrentState() == TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_START || this.mHeaderView.getCurrentState() == TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_END) ? false : false;
        boolean isChildScrollToBottom = (this.mFooterView != null && this.mLoadMoreEnabled) ? isChildScrollToBottom() : false;
        if (!isChildScrollToBottom && (tBLoadMoreFooter = this.mFooterView) != null && tBLoadMoreFooter.getCurrentState() != TBLoadMoreFooter.LoadMoreState.NONE) {
            isChildScrollToBottom = true;
        }
        if (isChildScrollToTop || isChildScrollToBottom) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i = this.mActivePointerId;
                        if (i == -1) {
                            Log.e(TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        }
                        float motionEventY = getMotionEventY(motionEvent, i);
                        if (motionEventY == -1.0f) {
                            return false;
                        }
                        if (isChildScrollToBottom()) {
                            if (this.mInitialMotionY - motionEventY > this.mTouchSlop && !this.mIsBeingDragged) {
                                this.mIsBeingDragged = true;
                            }
                        } else if (isChildScrollToTop() && motionEventY - this.mInitialMotionY > this.mTouchSlop && !this.mIsBeingDragged) {
                            this.mIsBeingDragged = true;
                        }
                    } else if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                }
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
            } else {
                this.mStartY = (int) motionEvent.getY();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                if (this.mActivePointerId == -1) {
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    this.mLastMotionY = motionEvent.getY();
                    this.mPreActivePointerId = this.mActivePointerId;
                }
                this.mIsBeingDragged = false;
                float motionEventY2 = getMotionEventY(motionEvent, this.mActivePointerId);
                if (motionEventY2 == -1.0f) {
                    return false;
                }
                this.mInitialMotionY = motionEventY2;
                TBAbsRefreshHeader tBAbsRefreshHeader3 = this.mHeaderView;
                if (tBAbsRefreshHeader3 != null && tBAbsRefreshHeader3.getCurrentState() == TBAbsRefreshHeader.RefreshState.REFRESHING) {
                    setRefreshing(false);
                }
                TBLoadMoreFooter tBLoadMoreFooter2 = this.mFooterView;
                if (tBLoadMoreFooter2 != null && tBLoadMoreFooter2.getCurrentState() == TBLoadMoreFooter.LoadMoreState.LOADING) {
                    setLoadMore(false);
                }
            }
            return this.mIsBeingDragged;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TBAbsRefreshHeader tBAbsRefreshHeader;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        int i5 = this.mCurrentTargetOffsetTop + this.mContentHeight;
        if (!this.mTargetScrollWithLayout) {
            i5 = 0;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = (getPaddingTop() + i5) - this.mPushDistance;
        view.layout(paddingLeft, this.mEnableTargetOffset ? paddingTop : paddingTop - this.mRefreshOffset, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, (paddingTop + ((measuredHeight - getPaddingTop()) - getPaddingBottom())) - this.mRefreshOffset);
        int i6 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(getResources().getDisplayMetrics());
        TBAbsRefreshHeader tBAbsRefreshHeader2 = this.mHeaderView;
        if (tBAbsRefreshHeader2 != null) {
            this.mHeaderViewWidth = i6;
            int i7 = this.mCurrentTargetOffsetTop;
            tBAbsRefreshHeader2.layout(0, i7, i6, this.mContentHeight + i7);
        }
        if (!this.mSecondFloorEnabled && (tBAbsRefreshHeader = this.mHeaderView) != null) {
            tBAbsRefreshHeader.getSecondFloorView().setVisibility(8);
        }
        TBLoadMoreFooter tBLoadMoreFooter = this.mFooterView;
        if (tBLoadMoreFooter != null) {
            this.mFooterViewWidth = i6;
            int i8 = this.mPushDistance;
            tBLoadMoreFooter.layout(0, measuredHeight - i8, i6, (measuredHeight + this.mMaxPushDistance) - i8);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mHeaderViewIndex = -1;
        int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(getResources().getDisplayMetrics());
        TBAbsRefreshHeader tBAbsRefreshHeader = this.mHeaderView;
        if (tBAbsRefreshHeader != null) {
            this.mHeaderViewWidth = i3;
            tBAbsRefreshHeader.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824));
            int i4 = 0;
            while (true) {
                if (i4 >= getChildCount()) {
                    break;
                } else if (getChildAt(i4) == this.mHeaderView) {
                    this.mHeaderViewIndex = i4;
                    break;
                } else {
                    i4++;
                }
            }
        }
        this.mFooterViewIndex = -1;
        TBLoadMoreFooter tBLoadMoreFooter = this.mFooterView;
        if (tBLoadMoreFooter != null) {
            this.mFooterViewWidth = i3;
            tBLoadMoreFooter.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mMaxPushDistance, 1073741824));
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                if (getChildAt(i5) == this.mFooterView) {
                    this.mFooterViewIndex = i5;
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TBLoadMoreFooter tBLoadMoreFooter;
        TBAbsRefreshHeader tBAbsRefreshHeader;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean isChildScrollToTop = this.mPullRefreshEnabled ? isChildScrollToTop() : false;
        boolean z = true;
        if (!isChildScrollToTop && (tBAbsRefreshHeader = this.mHeaderView) != null && tBAbsRefreshHeader.getCurrentState() != TBAbsRefreshHeader.RefreshState.NONE) {
            isChildScrollToTop = true;
        }
        TBAbsRefreshHeader tBAbsRefreshHeader2 = this.mHeaderView;
        isChildScrollToTop = (tBAbsRefreshHeader2 == null || tBAbsRefreshHeader2.getCurrentState() == TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_START || this.mHeaderView.getCurrentState() == TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_END) ? false : false;
        boolean isChildScrollToBottom = (this.mFooterView != null && this.mLoadMoreEnabled) ? isChildScrollToBottom() : false;
        if (isChildScrollToBottom || (tBLoadMoreFooter = this.mFooterView) == null || tBLoadMoreFooter.getCurrentState() == TBLoadMoreFooter.LoadMoreState.NONE) {
            z = isChildScrollToBottom;
        }
        if (isChildScrollToTop || z) {
            if (isChildScrollToTop) {
                return handlePullTouchEvent(motionEvent, actionMasked);
            }
            if (z) {
                return handlePushTouchEvent(motionEvent, actionMasked);
            }
            return false;
        }
        return false;
    }

    public void setAutoRefreshing(boolean z) {
        if (this.mHeaderView == null) {
            return;
        }
        this.mNotify = z;
        ensureTarget();
        this.mRefreshing = true;
        this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.REFRESHING);
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, new Animator.AnimatorListener() { // from class: com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TBSwipeRefreshLayout.this.mRefreshListener.onAnimationEnd(animator);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TBSwipeRefreshLayout.this.setRefreshing(false);
                    }
                }, TBSwipeRefreshLayout.this.mAutoRefreshDuration);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    public void setAutoRefreshingDuration(long j) {
        if (j > 0) {
            this.mAutoRefreshDuration = j;
        }
    }

    public void setCustomRefreshHeight(int i) {
        int i2 = (int) (i * this.mDensity);
        this.mHeaderViewHeight = i2;
        this.mTotalDragDistance = i2;
        if (this.mSecondFloorDistance < i2) {
            this.mSecondFloorDistance = i2 + MIN_GAP_DISTANCE_TO_SECOND_FLOOR;
        }
    }

    public void setDistanceToRefresh(int i) {
        float f = i;
        float f2 = this.mDensity;
        if (((int) (f * f2)) < this.mHeaderViewHeight) {
            return;
        }
        int i2 = (int) (f * f2);
        this.mTotalDragDistance = i2;
        int i3 = this.mSecondFloorDistance - i2;
        int i4 = MIN_GAP_DISTANCE_TO_SECOND_FLOOR;
        if (i3 < i4) {
            this.mSecondFloorDistance = i2 + i4;
        }
    }

    public void setDistanceToSecondFloor(int i) {
        float f = i;
        float f2 = this.mDensity;
        if (((int) (f * f2)) - this.mTotalDragDistance < MIN_GAP_DISTANCE_TO_SECOND_FLOOR) {
            Log.e(TAG, "Distance to second floor must be more than 50dp longer than distance to refresh");
        } else {
            this.mSecondFloorDistance = (int) (f * f2);
        }
    }

    public void setDragRate(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.mDragRate = f;
        } else {
            Log.e(TAG, "Drag rate must be larger than 0 and smaller than 1!");
        }
    }

    public void setFooterView(TBLoadMoreFooter tBLoadMoreFooter) {
        if (tBLoadMoreFooter != null) {
            int indexOfChild = indexOfChild(this.mFooterView);
            TBLoadMoreFooter tBLoadMoreFooter2 = this.mFooterView;
            if (tBLoadMoreFooter2 != null && indexOfChild != -1) {
                removeView(tBLoadMoreFooter2);
            }
            this.mFooterView = tBLoadMoreFooter;
            tBLoadMoreFooter.setPushLoadMoreListener(this.mOnPushLoadMoreListener);
            addView(this.mFooterView, indexOfChild, new ViewGroup.LayoutParams(-1, this.mFooterViewHeight));
        }
    }

    public void setFooterViewHeight(int i) {
        float f = i;
        float f2 = this.mDensity;
        if (((int) (f * f2)) > this.mMaxPushDistance) {
            this.mMaxPushDistance = (int) (f * f2);
        }
        this.mFooterViewHeight = (int) (f * f2);
    }

    public void setHeaderView(TBAbsRefreshHeader tBAbsRefreshHeader) {
        if (tBAbsRefreshHeader != null) {
            int indexOfChild = indexOfChild(this.mHeaderView);
            TBAbsRefreshHeader tBAbsRefreshHeader2 = this.mHeaderView;
            if (tBAbsRefreshHeader2 != null && indexOfChild != -1) {
                removeView(tBAbsRefreshHeader2);
            }
            this.mHeaderView = tBAbsRefreshHeader;
            tBAbsRefreshHeader.setPullRefreshListener(this.mPullRefreshListener);
            addView(this.mHeaderView, indexOfChild, new ViewGroup.LayoutParams(-1, this.mHeaderViewHeight));
        }
    }

    public void setHeaderViewHeight(int i) {
        float f = i;
        float f2 = this.mDensity;
        if (((int) (f * f2)) < this.mRefreshOffset) {
            Log.d(TAG, "HeaderView height cannot be smaller than refresh offset.");
            return;
        }
        int i2 = (int) (f * f2);
        this.mHeaderViewHeight = i2;
        if (this.mTotalDragDistance < i2) {
            this.mTotalDragDistance = i2;
        }
        int i3 = this.mSecondFloorDistance;
        int i4 = this.mTotalDragDistance;
        if (i3 < i4) {
            this.mSecondFloorDistance = i4 + MIN_GAP_DISTANCE_TO_SECOND_FLOOR;
        }
    }

    public void setLoadMore(boolean z) {
        if (this.mFooterView == null || z || !this.mLoadingMore) {
            return;
        }
        animatorFooterToBottom(this.mFooterViewHeight, 0);
    }

    public void setLoadMoreTips(String[] strArr) {
        TBLoadMoreFooter tBLoadMoreFooter = this.mFooterView;
        if (tBLoadMoreFooter != null) {
            tBLoadMoreFooter.setLoadMoreTips(strArr);
        }
    }

    public void setMaxPullDistance(int i) {
        this.mMaxPullDistance = (int) (i * this.mDensity);
    }

    public void setMaxPushDistance(int i) {
        float f = i;
        float f2 = this.mDensity;
        if (((int) (f * f2)) < this.mFooterViewHeight) {
            Log.e(TAG, "Max push distance must be larger than footer view height!");
        } else {
            this.mMaxPushDistance = (int) (f * f2);
        }
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback onChildScrollUpCallback) {
        this.mOnChildScrollUpCallback = onChildScrollUpCallback;
    }

    public void setOnPullRefreshListener(OnPullRefreshListener onPullRefreshListener) {
        this.mPullRefreshListener = onPullRefreshListener;
        TBAbsRefreshHeader tBAbsRefreshHeader = this.mHeaderView;
        if (tBAbsRefreshHeader != null) {
            tBAbsRefreshHeader.setPullRefreshListener(onPullRefreshListener);
        }
    }

    public void setOnPushLoadMoreListener(OnPushLoadMoreListener onPushLoadMoreListener) {
        this.mOnPushLoadMoreListener = onPushLoadMoreListener;
        TBLoadMoreFooter tBLoadMoreFooter = this.mFooterView;
        if (tBLoadMoreFooter != null) {
            tBLoadMoreFooter.setPushLoadMoreListener(onPushLoadMoreListener);
        }
    }

    public void setRefreshOffset(int i) {
        setRefreshOffset(i, false);
    }

    public void setRefreshTips(String[] strArr) {
        TBAbsRefreshHeader tBAbsRefreshHeader = this.mHeaderView;
        if (tBAbsRefreshHeader != null) {
            tBAbsRefreshHeader.setRefreshTips(strArr);
        }
    }

    public void setRefreshing(boolean z) {
        if (this.mHeaderView == null) {
            return;
        }
        if (z && this.mRefreshing != z) {
            this.mRefreshing = z;
            updateHeaderPosition((this.mHeaderViewHeight + this.mOriginalOffsetTop) - this.mCurrentTargetOffsetTop);
            this.mNotify = false;
            startScaleUpAnimation(this.mRefreshListener);
            return;
        }
        setRefreshing(z, false);
    }

    public void setTargetScrollWithLayout(boolean z) {
        this.mTargetScrollWithLayout = z;
    }

    public TBSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeaderViewIndex = -1;
        this.mFooterViewIndex = -1;
        this.mLazyPullRefreshEnable = false;
        this.mLazyLoadMoreEnable = false;
        this.mTargetScrollWithLayout = true;
        this.mActivePointerId = -1;
        this.mDragRate = 1.0f;
        this.mTotalDragDistance = -1;
        this.mSecondFloorDistance = -1;
        this.mEnableTargetOffset = true;
        this.mPushDistance = 0;
        this.mAutoRefreshDuration = 2000L;
        this.mIsMultiPointer = false;
        this.mPositionY = 0;
        this.mPrePositionY = 0;
        this.mPreActivePointerId = -1;
        this.mContentHeight = -1;
        this.mNavigationBarHeight = -1;
        this.mRefreshListener = new C6521a();
        setWillNotDraw(false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mDisplayMetrics = displayMetrics;
        this.mDensity = displayMetrics.density;
        HEADER_VIEW_HEIGHT = (int) getResources().getDimension(R$dimen.uik_refresh_header_height);
        MIN_GAP_DISTANCE_TO_SECOND_FLOOR = (int) getResources().getDimension(R$dimen.uik_refresh_second_floor_gap);
        FOOTER_VIEW_HEIGHT = (int) getResources().getDimension(R$dimen.uik_refresh_footer_height);
        FOOTER_VIEW_MAX_HEIGHT = (int) getResources().getDimension(R$dimen.uik_refresh_footer_max_height);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        this.mPullRefreshEnabled = obtainStyledAttributes.getBoolean(0, false);
        this.mLoadMoreEnabled = obtainStyledAttributes.getBoolean(1, false);
        this.mSecondFloorEnabled = obtainStyledAttributes.getBoolean(2, false);
        this.mLazyPullRefreshEnable = obtainStyledAttributes.getBoolean(5, false);
        this.mLazyLoadMoreEnable = obtainStyledAttributes.getBoolean(6, false);
        if (this.mSecondFloorEnabled && !this.mPullRefreshEnabled) {
            Log.e(TAG, "Cannot enable second floor when pull to refresh disabled!");
            return;
        }
        this.mHeaderViewWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(this.mDisplayMetrics);
        this.mHeaderViewHeight = (int) obtainStyledAttributes.getDimension(3, HEADER_VIEW_HEIGHT);
        this.mFooterViewWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(this.mDisplayMetrics);
        this.mFooterViewHeight = (int) obtainStyledAttributes.getDimension(4, FOOTER_VIEW_HEIGHT);
        obtainStyledAttributes.recycle();
        if (this.mNavigationBarHeight == -1) {
            this.mNavigationBarHeight = qz.c((Activity) getContext());
        }
        if (this.mContentHeight == -1) {
            this.mContentHeight = qz.a((Activity) getContext());
        }
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        if (!this.mLazyPullRefreshEnable) {
            createHeaderView();
        }
        if (!this.mLazyLoadMoreEnable) {
            createFooterView();
        }
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.mRefreshOffset = 0;
        int i = HEADER_VIEW_HEIGHT;
        this.mTotalDragDistance = i;
        this.mSecondFloorDistance = i + MIN_GAP_DISTANCE_TO_SECOND_FLOOR;
        this.mMaxPushDistance = FOOTER_VIEW_MAX_HEIGHT;
        int i2 = (-this.mContentHeight) + 0;
        this.mOriginalOffsetTop = i2;
        this.mCurrentTargetOffsetTop = i2;
    }

    public void setRefreshOffset(int i, boolean z) {
        if (z) {
            int d = qz.d(getContext());
            this.mRefreshOffset = ((int) (i * getResources().getDisplayMetrics().density)) + d;
            this.mHeaderViewHeight += d;
        } else {
            this.mRefreshOffset = (int) (i * getResources().getDisplayMetrics().density);
        }
        int i2 = this.mRefreshOffset;
        int i3 = (-this.mContentHeight) + i2;
        this.mOriginalOffsetTop = i3;
        this.mCurrentTargetOffsetTop = i3;
        if (this.mHeaderViewHeight < i2) {
            Log.e(TAG, "Refresh offset cannot be larger than header view height.");
            this.mHeaderViewHeight = this.mRefreshOffset + ((int) (getResources().getDisplayMetrics().density * 24.0f));
        }
        int i4 = this.mTotalDragDistance;
        int i5 = this.mHeaderViewHeight;
        if (i4 < i5) {
            this.mTotalDragDistance = i5;
        }
        int i6 = this.mSecondFloorDistance;
        int i7 = this.mTotalDragDistance;
        if (i6 < i7) {
            this.mSecondFloorDistance = i7 + MIN_GAP_DISTANCE_TO_SECOND_FLOOR;
        }
    }

    public void setRefreshing(boolean z, boolean z2) {
        TBAbsRefreshHeader tBAbsRefreshHeader = this.mHeaderView;
        if (tBAbsRefreshHeader == null) {
            return;
        }
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (z) {
                this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.REFRESHING);
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
                return;
            }
            this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.NONE);
            animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        } else if (tBAbsRefreshHeader.getCurrentState() == TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_END) {
            this.mRefreshing = false;
            this.mHeaderView.changeToState(TBAbsRefreshHeader.RefreshState.NONE);
            animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        }
    }
}
