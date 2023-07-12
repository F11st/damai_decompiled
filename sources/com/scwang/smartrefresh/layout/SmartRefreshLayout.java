package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import tb.df2;
import tb.g12;
import tb.l80;
import tb.zd2;

/* compiled from: Taobao */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes7.dex */
public class SmartRefreshLayout extends ViewGroup implements NestedScrollingParent, RefreshLayout {
    protected static ViewGroup.MarginLayoutParams sDefaultMarginLP = new ViewGroup.MarginLayoutParams(-1, -1);
    protected static DefaultRefreshFooterCreator sFooterCreator;
    protected static DefaultRefreshHeaderCreator sHeaderCreator;
    protected static DefaultRefreshInitializer sRefreshInitializer;
    protected Runnable animationRunnable;
    protected boolean mAttachedToWindow;
    protected int mCurrentVelocity;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableFooterFollowWhenNoMoreData;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
    protected boolean mEnableNestedScrolling;
    protected boolean mEnableOverScrollBounce;
    protected boolean mEnableOverScrollDrag;
    protected boolean mEnablePreviewInEditMode;
    protected boolean mEnablePureScrollMode;
    protected boolean mEnableRefresh;
    protected boolean mEnableScrollContentWhenLoaded;
    protected boolean mEnableScrollContentWhenRefreshed;
    protected MotionEvent mFalsifyEvent;
    protected int mFixedFooterViewId;
    protected int mFixedHeaderViewId;
    protected int mFloorDuration;
    protected int mFooterBackgroundColor;
    protected int mFooterHeight;
    protected l80 mFooterHeightStatus;
    protected int mFooterInsetStart;
    protected boolean mFooterLocked;
    protected float mFooterMaxDragRate;
    protected boolean mFooterNeedTouchEventWhenLoading;
    protected boolean mFooterNoMoreData;
    protected boolean mFooterNoMoreDataEffective;
    protected int mFooterTranslationViewId;
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected l80 mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected int mHeaderTranslationViewId;
    protected float mHeaderTriggerRate;
    protected boolean mIsBeingDragged;
    protected RefreshKernel mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected float mLastTouchX;
    protected float mLastTouchY;
    protected OnLoadMoreListener mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected int mMaximumVelocity;
    protected int mMinimumVelocity;
    protected NestedScrollingChildHelper mNestedChild;
    protected boolean mNestedInProgress;
    protected NestedScrollingParentHelper mNestedParent;
    protected OnMultiPurposeListener mOnMultiPurposeListener;
    protected Paint mPaint;
    protected int[] mParentOffsetInWindow;
    protected int[] mPrimaryColors;
    protected int mReboundDuration;
    protected Interpolator mReboundInterpolator;
    protected RefreshContent mRefreshContent;
    protected RefreshInternal mRefreshFooter;
    protected RefreshInternal mRefreshHeader;
    protected OnRefreshListener mRefreshListener;
    protected int mScreenHeightPixels;
    protected ScrollBoundaryDecider mScrollBoundaryDecider;
    protected Scroller mScroller;
    protected int mSpinner;
    protected RefreshState mState;
    protected boolean mSuperDispatchTouchEvent;
    protected int mTotalUnconsumed;
    protected int mTouchSlop;
    protected int mTouchSpinner;
    protected float mTouchX;
    protected float mTouchY;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalPermit;
    protected RefreshState mViceState;
    protected ValueAnimator reboundAnimator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$7  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass7 implements Runnable {
        int count = 0;
        final /* synthetic */ int val$more;
        final /* synthetic */ boolean val$noMoreData;
        final /* synthetic */ boolean val$success;

        AnonymousClass7(int i, boolean z, boolean z2) {
            this.val$more = i;
            this.val$noMoreData = z;
            this.val$success = z2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
            if (r2.mRefreshContent.canLoadMore() != false) goto L46;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 298
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass7.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class BounceRunnable implements Runnable {
        int mSmoothDistance;
        float mVelocity;
        int mFrame = 0;
        int mFrameDelay = 10;
        float mOffset = 0.0f;
        long mLastTime = AnimationUtils.currentAnimationTimeMillis();

        BounceRunnable(float f, int i) {
            this.mVelocity = f;
            this.mSmoothDistance = i;
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.mFrameDelay);
            if (f > 0.0f) {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable != this || smartRefreshLayout.mState.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.mSpinner) >= Math.abs(this.mSmoothDistance)) {
                if (this.mSmoothDistance != 0) {
                    int i = this.mFrame + 1;
                    this.mFrame = i;
                    this.mVelocity = (float) (this.mVelocity * Math.pow(0.44999998807907104d, i * 2));
                } else {
                    int i2 = this.mFrame + 1;
                    this.mFrame = i2;
                    this.mVelocity = (float) (this.mVelocity * Math.pow(0.8500000238418579d, i2 * 2));
                }
            } else {
                int i3 = this.mFrame + 1;
                this.mFrame = i3;
                this.mVelocity = (float) (this.mVelocity * Math.pow(0.949999988079071d, i3 * 2));
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f = this.mVelocity * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
            if (Math.abs(f) >= 1.0f) {
                this.mLastTime = currentAnimationTimeMillis;
                float f2 = this.mOffset + f;
                this.mOffset = f2;
                SmartRefreshLayout.this.moveSpinnerInfinitely(f2);
                SmartRefreshLayout.this.mHandler.postDelayed(this, this.mFrameDelay);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshState refreshState = smartRefreshLayout2.mViceState;
            boolean z = refreshState.isDragging;
            if (z && refreshState.isHeader) {
                smartRefreshLayout2.mKernel.setState(RefreshState.PullDownCanceled);
            } else if (z && refreshState.isFooter) {
                smartRefreshLayout2.mKernel.setState(RefreshState.PullUpCanceled);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.animationRunnable = null;
            if (Math.abs(smartRefreshLayout3.mSpinner) >= Math.abs(this.mSmoothDistance)) {
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.animSpinner(this.mSmoothDistance, 0, smartRefreshLayout4.mReboundInterpolator, Math.min(Math.max((int) zd2.px2dp(Math.abs(SmartRefreshLayout.this.mSpinner - this.mSmoothDistance)), 30), 100) * 10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class FlingRunnable implements Runnable {
        int mOffset;
        float mVelocity;
        int mFrame = 0;
        int mFrameDelay = 10;
        float mDamping = 0.98f;
        long mStartTime = 0;
        long mLastTime = AnimationUtils.currentAnimationTimeMillis();

        FlingRunnable(float f) {
            this.mVelocity = f;
            this.mOffset = SmartRefreshLayout.this.mSpinner;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable != this || smartRefreshLayout.mState.isFinishing) {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float pow = (float) (this.mVelocity * Math.pow(this.mDamping, ((float) (currentAnimationTimeMillis - this.mStartTime)) / (1000.0f / this.mFrameDelay)));
            this.mVelocity = pow;
            float f = pow * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
            if (Math.abs(f) > 1.0f) {
                this.mLastTime = currentAnimationTimeMillis;
                int i = (int) (this.mOffset + f);
                this.mOffset = i;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (smartRefreshLayout2.mSpinner * i > 0) {
                    smartRefreshLayout2.mKernel.moveSpinner(i, true);
                    SmartRefreshLayout.this.mHandler.postDelayed(this, this.mFrameDelay);
                    return;
                }
                smartRefreshLayout2.animationRunnable = null;
                smartRefreshLayout2.mKernel.moveSpinner(0, true);
                zd2.fling(SmartRefreshLayout.this.mRefreshContent.getScrollableView(), (int) (-this.mVelocity));
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                if (!smartRefreshLayout3.mFooterLocked || f <= 0.0f) {
                    return;
                }
                smartRefreshLayout3.mFooterLocked = false;
                return;
            }
            SmartRefreshLayout.this.animationRunnable = null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:
            if (r0.mSpinner >= (-r0.mFooterHeight)) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
            if (r0.mSpinner > r0.mHeaderHeight) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Runnable start() {
            /*
                r11 = this;
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                boolean r2 = r1.isFinishing
                r3 = 0
                if (r2 == 0) goto La
                return r3
            La:
                int r2 = r0.mSpinner
                if (r2 == 0) goto Lab
                boolean r1 = r1.isOpening
                if (r1 != 0) goto L26
                boolean r1 = r0.mFooterNoMoreData
                if (r1 == 0) goto L59
                boolean r1 = r0.mEnableFooterFollowWhenNoMoreData
                if (r1 == 0) goto L59
                boolean r1 = r0.mFooterNoMoreDataEffective
                if (r1 == 0) goto L59
                boolean r1 = r0.mEnableLoadMore
                boolean r0 = r0.isEnableRefreshOrLoadMore(r1)
                if (r0 == 0) goto L59
            L26:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
                if (r1 == r2) goto L42
                boolean r1 = r0.mFooterNoMoreData
                if (r1 == 0) goto L4b
                boolean r1 = r0.mEnableFooterFollowWhenNoMoreData
                if (r1 == 0) goto L4b
                boolean r1 = r0.mFooterNoMoreDataEffective
                if (r1 == 0) goto L4b
                boolean r1 = r0.mEnableLoadMore
                boolean r0 = r0.isEnableRefreshOrLoadMore(r1)
                if (r0 == 0) goto L4b
            L42:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r0.mSpinner
                int r0 = r0.mFooterHeight
                int r0 = -r0
                if (r1 < r0) goto L59
            L4b:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto Lab
                int r1 = r0.mSpinner
                int r0 = r0.mHeaderHeight
                if (r1 <= r0) goto Lab
            L59:
                r0 = 0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.mSpinner
                float r2 = r11.mVelocity
                r4 = r1
            L61:
                int r5 = r1 * r4
                if (r5 <= 0) goto Lab
                double r5 = (double) r2
                float r2 = r11.mDamping
                double r7 = (double) r2
                int r0 = r0 + 1
                int r2 = r11.mFrameDelay
                int r2 = r2 * r0
                float r2 = (float) r2
                r9 = 1092616192(0x41200000, float:10.0)
                float r2 = r2 / r9
                double r9 = (double) r2
                double r7 = java.lang.Math.pow(r7, r9)
                double r5 = r5 * r7
                float r2 = (float) r5
                int r5 = r11.mFrameDelay
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r2
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto La7
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                boolean r2 = r1.isOpening
                if (r2 == 0) goto La6
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto L9f
                int r5 = r0.mHeaderHeight
                if (r4 > r5) goto La6
            L9f:
                if (r1 == r2) goto Lab
                int r0 = r0.mFooterHeight
                int r0 = -r0
                if (r4 >= r0) goto Lab
            La6:
                return r3
            La7:
                float r4 = (float) r4
                float r4 = r4 + r5
                int r4 = (int) r4
                goto L61
            Lab:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r11.mStartTime = r0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.os.Handler r0 = r0.mHandler
                int r1 = r11.mFrameDelay
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.FlingRunnable.start():java.lang.Runnable");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[RefreshState.RefreshFinish.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[RefreshState.LoadFinish.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[RefreshState.TwoLevelReleased.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[RefreshState.TwoLevelFinish.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[RefreshState.TwoLevel.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.setStateDirectLoading(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.mLastOpenTime = System.currentTimeMillis();
            SmartRefreshLayout.this.notifyStateChanged(RefreshState.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            OnRefreshListener onRefreshListener = smartRefreshLayout.mRefreshListener;
            if (onRefreshListener != null) {
                if (this.a) {
                    onRefreshListener.onRefresh(smartRefreshLayout);
                }
            } else if (smartRefreshLayout.mOnMultiPurposeListener == null) {
                smartRefreshLayout.finishRefresh(3000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshInternal refreshInternal = smartRefreshLayout2.mRefreshHeader;
            if (refreshInternal != null) {
                int i = smartRefreshLayout2.mHeaderHeight;
                refreshInternal.onStartAnimator(smartRefreshLayout2, i, (int) (smartRefreshLayout2.mHeaderMaxDragRate * i));
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout3.mOnMultiPurposeListener;
            if (onMultiPurposeListener == null || !(smartRefreshLayout3.mRefreshHeader instanceof RefreshHeader)) {
                return;
            }
            if (this.a) {
                onMultiPurposeListener.onRefresh(smartRefreshLayout3);
            }
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            int i2 = smartRefreshLayout4.mHeaderHeight;
            smartRefreshLayout4.mOnMultiPurposeListener.onHeaderStartAnimator((RefreshHeader) smartRefreshLayout4.mRefreshHeader, i2, (int) (smartRefreshLayout4.mHeaderMaxDragRate * i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RefreshState refreshState;
            RefreshState refreshState2;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.reboundAnimator = null;
            if (smartRefreshLayout.mSpinner == 0 && (refreshState = smartRefreshLayout.mState) != (refreshState2 = RefreshState.None) && !refreshState.isOpening && !refreshState.isDragging) {
                smartRefreshLayout.notifyStateChanged(refreshState2);
                return;
            }
            RefreshState refreshState3 = smartRefreshLayout.mState;
            if (refreshState3 != smartRefreshLayout.mViceState) {
                smartRefreshLayout.setViceState(refreshState3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class f implements RefreshKernel {

        /* compiled from: Taobao */
        /* loaded from: classes7.dex */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.TwoLevel);
            }
        }

        public f() {
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public ValueAnimator animSpinner(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.animSpinner(i, 0, smartRefreshLayout.mReboundInterpolator, smartRefreshLayout.mReboundDuration);
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel finishTwoLevel() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mState == RefreshState.TwoLevel) {
                smartRefreshLayout.mKernel.setState(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.mSpinner == 0) {
                    moveSpinner(0, false);
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                } else {
                    animSpinner(0).setDuration(SmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshContent getRefreshContent() {
            return SmartRefreshLayout.this.mRefreshContent;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshLayout getRefreshLayout() {
            return SmartRefreshLayout.this;
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.scwang.smartrefresh.layout.api.RefreshKernel moveSpinner(int r19, boolean r20) {
            /*
                Method dump skipped, instructions count: 897
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.f.moveSpinner(int, boolean):com.scwang.smartrefresh.layout.api.RefreshKernel");
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestDefaultTranslationContentFor(@NonNull RefreshInternal refreshInternal, boolean z) {
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.mManualHeaderTranslationContent) {
                    smartRefreshLayout.mManualHeaderTranslationContent = true;
                    smartRefreshLayout.mEnableHeaderTranslationContent = z;
                }
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.mManualFooterTranslationContent) {
                    smartRefreshLayout2.mManualFooterTranslationContent = true;
                    smartRefreshLayout2.mEnableFooterTranslationContent = z;
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestDrawBackgroundFor(@NonNull RefreshInternal refreshInternal, int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mPaint == null && i != 0) {
                smartRefreshLayout.mPaint = new Paint();
            }
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderBackgroundColor = i;
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterBackgroundColor = i;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestFloorDuration(int i) {
            SmartRefreshLayout.this.mFloorDuration = i;
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestNeedTouchEventFor(@NonNull RefreshInternal refreshInternal, boolean z) {
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderNeedTouchEventWhenRefreshing = z;
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterNeedTouchEventWhenLoading = z;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestRemeasureHeightFor(@NonNull RefreshInternal refreshInternal) {
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                l80 l80Var = smartRefreshLayout.mHeaderHeightStatus;
                if (l80Var.b) {
                    smartRefreshLayout.mHeaderHeightStatus = l80Var.c();
                }
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                l80 l80Var2 = smartRefreshLayout2.mFooterHeightStatus;
                if (l80Var2.b) {
                    smartRefreshLayout2.mFooterHeightStatus = l80Var2.c();
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel setState(@NonNull RefreshState refreshState) {
            switch (a.a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.mState;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.mSpinner == 0) {
                        smartRefreshLayout.notifyStateChanged(refreshState3);
                        return null;
                    } else if (smartRefreshLayout.mSpinner != 0) {
                        animSpinner(0);
                        return null;
                    } else {
                        return null;
                    }
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.mState.isOpening && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.isEnableRefreshOrLoadMore(smartRefreshLayout3.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.mState;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.mFooterNoMoreData || !smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout4.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout4.notifyStateChanged(RefreshState.PullUpToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.mState.isOpening && smartRefreshLayout5.isEnableRefreshOrLoadMore(smartRefreshLayout5.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                        setState(RefreshState.None);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.isEnableRefreshOrLoadMore(smartRefreshLayout6.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.mState.isOpening && (!smartRefreshLayout7.mFooterNoMoreData || !smartRefreshLayout7.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout7.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout7.notifyStateChanged(RefreshState.PullUpCanceled);
                            setState(RefreshState.None);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    return null;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.mState.isOpening && smartRefreshLayout8.isEnableRefreshOrLoadMore(smartRefreshLayout8.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.isEnableRefreshOrLoadMore(smartRefreshLayout9.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.mState;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.mFooterNoMoreData || !smartRefreshLayout10.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout10.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout10.notifyStateChanged(RefreshState.ReleaseToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.mState.isOpening && smartRefreshLayout11.isEnableRefreshOrLoadMore(smartRefreshLayout11.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.mState.isOpening && smartRefreshLayout12.isEnableRefreshOrLoadMore(smartRefreshLayout12.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.mState.isOpening && smartRefreshLayout13.isEnableRefreshOrLoadMore(smartRefreshLayout13.mEnableLoadMore)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    return null;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    return null;
                case 13:
                    SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                    if (smartRefreshLayout14.mState == RefreshState.Refreshing) {
                        smartRefreshLayout14.notifyStateChanged(RefreshState.RefreshFinish);
                        return null;
                    }
                    return null;
                case 14:
                    SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                    if (smartRefreshLayout15.mState == RefreshState.Loading) {
                        smartRefreshLayout15.notifyStateChanged(RefreshState.LoadFinish);
                        return null;
                    }
                    return null;
                case 15:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelReleased);
                    return null;
                case 16:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelFinish);
                    return null;
                case 17:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevel);
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel startTwoLevel(boolean z) {
            if (z) {
                a aVar = new a();
                ValueAnimator animSpinner = animSpinner(SmartRefreshLayout.this.getMeasuredHeight());
                if (animSpinner != null) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (animSpinner == smartRefreshLayout.reboundAnimator) {
                        animSpinner.setDuration(smartRefreshLayout.mFloorDuration);
                        animSpinner.addListener(aVar);
                    }
                }
                aVar.onAnimationEnd(null);
            } else if (animSpinner(0) == null) {
                SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
        sFooterCreator = defaultRefreshFooterCreator;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
        sHeaderCreator = defaultRefreshHeaderCreator;
    }

    public static void setDefaultRefreshInitializer(@NonNull DefaultRefreshInitializer defaultRefreshInitializer) {
        sRefreshInitializer = defaultRefreshInitializer;
    }

    protected ValueAnimator animSpinner(int i, int i2, Interpolator interpolator, int i3) {
        if (this.mSpinner != i) {
            ValueAnimator valueAnimator = this.reboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.animationRunnable = null;
            ValueAnimator ofInt = ValueAnimator.ofInt(this.mSpinner, i);
            this.reboundAnimator = ofInt;
            ofInt.setDuration(i3);
            this.reboundAnimator.setInterpolator(interpolator);
            this.reboundAnimator.addListener(new d());
            this.reboundAnimator.addUpdateListener(new e());
            this.reboundAnimator.setStartDelay(i2);
            this.reboundAnimator.start();
            return this.reboundAnimator;
        }
        return null;
    }

    protected void animSpinnerBounce(float f2) {
        RefreshState refreshState;
        if (this.reboundAnimator == null) {
            if (f2 > 0.0f && ((refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                this.animationRunnable = new BounceRunnable(f2, this.mHeaderHeight);
            } else if (f2 < 0.0f && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mState != RefreshState.Refreshing)))) {
                this.animationRunnable = new BounceRunnable(f2, -this.mFooterHeight);
            } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
                this.animationRunnable = new BounceRunnable(f2, 0);
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMore() {
        int i = this.mReboundDuration;
        int i2 = this.mFooterHeight;
        float f2 = i2 * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoLoadMore(0, i, f2 / i2, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMoreAnimationOnly() {
        int i = this.mReboundDuration;
        int i2 = this.mFooterHeight;
        float f2 = i2 * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoLoadMore(0, i, f2 / i2, true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefresh() {
        int i = this.mAttachedToWindow ? 0 : 400;
        int i2 = this.mReboundDuration;
        int i3 = this.mHeaderHeight;
        float f2 = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * i3 * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f2 / i3, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefreshAnimationOnly() {
        int i = this.mAttachedToWindow ? 0 : 400;
        int i2 = this.mReboundDuration;
        int i3 = this.mHeaderHeight;
        float f2 = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * i3 * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f2 / i3, true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout closeHeaderOrFooter() {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.Refreshing) {
            finishRefresh();
        } else if (refreshState == RefreshState.Loading) {
            finishLoadMore();
        } else if (this.mSpinner != 0) {
            animSpinner(0, 0, this.mReboundInterpolator, this.mReboundDuration);
        }
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        float currY;
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && this.mRefreshContent.canRefresh())) || (finalY > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && this.mRefreshContent.canLoadMore()))) {
                if (this.mVerticalPermit) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        currY = finalY > 0 ? -this.mScroller.getCurrVelocity() : this.mScroller.getCurrVelocity();
                    } else {
                        currY = ((this.mScroller.getCurrY() - finalY) * 1.0f) / Math.max(this.mScroller.getDuration() - this.mScroller.timePassed(), 1);
                    }
                    animSpinnerBounce(currY);
                }
                this.mScroller.forceFinished(true);
                return;
            }
            this.mVerticalPermit = true;
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
        if (r4.isFinishing == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        if (r4.isHeader == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d8, code lost:
        if (r4.isFinishing == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00dc, code lost:
        if (r4.isFooter == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0108, code lost:
        if (r6 != 3) goto L98;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 858
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        Paint paint;
        Paint paint2;
        RefreshContent refreshContent = this.mRefreshContent;
        View view2 = refreshContent != null ? refreshContent.getView() : null;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null && refreshInternal.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableRefresh) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i = this.mHeaderBackgroundColor;
                if (i != 0 && (paint2 = this.mPaint) != null) {
                    paint2.setColor(i);
                    if (this.mRefreshHeader.getSpinnerStyle().c) {
                        max = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == df2.Translate) {
                        max = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), max, this.mPaint);
                }
                if (this.mEnableClipHeaderWhenFixedBehind && this.mRefreshHeader.getSpinnerStyle() == df2.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null && refreshInternal2.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableLoadMore) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i2 = this.mFooterBackgroundColor;
                if (i2 != 0 && (paint = this.mPaint) != null) {
                    paint.setColor(i2);
                    if (this.mRefreshFooter.getSpinnerStyle().c) {
                        min = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == df2.Translate) {
                        min = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, min, getWidth(), view.getBottom(), this.mPaint);
                }
                if (this.mEnableClipFooterWhenFixedBehind && this.mRefreshFooter.getSpinnerStyle() == df2.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore() {
        return finishLoadMore(true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh() {
        return finishRefresh(true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefreshWithNoMoreData() {
        return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedParent.getNestedScrollAxes();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Nullable
    public RefreshFooter getRefreshFooter() {
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal instanceof RefreshFooter) {
            return (RefreshFooter) refreshInternal;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Nullable
    public RefreshHeader getRefreshHeader() {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal instanceof RefreshHeader) {
            return (RefreshHeader) refreshInternal;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @NonNull
    public RefreshState getState() {
        return this.mState;
    }

    protected boolean interceptAnimatorByAction(int i) {
        if (i == 0) {
            if (this.reboundAnimator != null) {
                RefreshState refreshState = this.mState;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.mKernel.setState(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.mKernel.setState(RefreshState.PullUpToLoad);
                }
                this.reboundAnimator.cancel();
                this.reboundAnimator = null;
            }
            this.animationRunnable = null;
        }
        return this.reboundAnimator != null;
    }

    protected boolean isEnableRefreshOrLoadMore(boolean z) {
        return z && !this.mEnablePureScrollMode;
    }

    protected boolean isEnableTranslationContent(boolean z, RefreshInternal refreshInternal) {
        return z || this.mEnablePureScrollMode || refreshInternal == null || refreshInternal.getSpinnerStyle() == df2.FixedBehind;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mEnableNestedScrolling && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore);
    }

    protected void moveSpinnerInfinitely(float f2) {
        RefreshState refreshState;
        float f3 = (!this.mNestedInProgress || this.mEnableLoadMoreWhenContentNotFull || f2 >= 0.0f || this.mRefreshContent.canLoadMore()) ? f2 : 0.0f;
        if (f3 > this.mScreenHeightPixels * 5 && getTag() == null) {
            Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
            setTag("你这么死拉，臣妾做不到啊！");
        }
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == RefreshState.TwoLevel && f3 > 0.0f) {
            this.mKernel.moveSpinner(Math.min((int) f3, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f3 >= 0.0f) {
            int i = this.mHeaderHeight;
            if (f3 < i) {
                this.mKernel.moveSpinner((int) f3, true);
            } else {
                double d2 = (this.mHeaderMaxDragRate - 1.0f) * i;
                int max = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i2 = this.mHeaderHeight;
                double d3 = max - i2;
                double max2 = Math.max(0.0f, (f3 - i2) * this.mDragRate);
                double d4 = -max2;
                if (d3 == 0.0d) {
                    d3 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) Math.min(d2 * (1.0d - Math.pow(100.0d, d4 / d3)), max2)) + this.mHeaderHeight, true);
            }
        } else if (f3 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) {
            int i3 = this.mFooterHeight;
            if (f3 > (-i3)) {
                this.mKernel.moveSpinner((int) f3, true);
            } else {
                double d5 = (this.mFooterMaxDragRate - 1.0f) * i3;
                int max3 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i4 = this.mFooterHeight;
                double d6 = max3 - i4;
                double d7 = -Math.min(0.0f, (i4 + f3) * this.mDragRate);
                double d8 = -d7;
                if (d6 == 0.0d) {
                    d6 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) (-Math.min(d5 * (1.0d - Math.pow(100.0d, d8 / d6)), d7))) - this.mFooterHeight, true);
            }
        } else if (f3 >= 0.0f) {
            double d9 = this.mHeaderMaxDragRate * this.mHeaderHeight;
            double max4 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double max5 = Math.max(0.0f, this.mDragRate * f3);
            double d10 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.mKernel.moveSpinner((int) Math.min(d9 * (1.0d - Math.pow(100.0d, d10 / max4)), max5), true);
        } else {
            double d11 = this.mFooterMaxDragRate * this.mFooterHeight;
            double max6 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double d12 = -Math.min(0.0f, this.mDragRate * f3);
            double d13 = -d12;
            if (max6 == 0.0d) {
                max6 = 1.0d;
            }
            this.mKernel.moveSpinner((int) (-Math.min(d11 * (1.0d - Math.pow(100.0d, d13 / max6)), d12)), true);
        }
        if (!this.mEnableAutoLoadMore || this.mFooterNoMoreData || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || f3 >= 0.0f || (refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish) {
            return;
        }
        if (this.mDisableContentWhenLoading) {
            this.animationRunnable = null;
            this.mKernel.animSpinner(-this.mFooterHeight);
        }
        setStateDirectLoading(false);
        this.mHandler.postDelayed(new Runnable() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.5
            @Override // java.lang.Runnable
            public void run() {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                OnLoadMoreListener onLoadMoreListener = smartRefreshLayout.mLoadMoreListener;
                if (onLoadMoreListener != null) {
                    onLoadMoreListener.onLoadMore(smartRefreshLayout);
                } else if (smartRefreshLayout.mOnMultiPurposeListener == null) {
                    smartRefreshLayout.finishLoadMore(2000);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout2.mOnMultiPurposeListener;
                if (onMultiPurposeListener != null) {
                    onMultiPurposeListener.onLoadMore(smartRefreshLayout2);
                }
            }
        }, this.mReboundDuration);
    }

    protected void notifyStateChanged(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2 != refreshState) {
            this.mState = refreshState;
            this.mViceState = refreshState;
            RefreshInternal refreshInternal = this.mRefreshHeader;
            RefreshInternal refreshInternal2 = this.mRefreshFooter;
            OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
            if (refreshInternal != null) {
                refreshInternal.onStateChanged(this, refreshState2, refreshState);
            }
            if (refreshInternal2 != null) {
                refreshInternal2.onStateChanged(this, refreshState2, refreshState);
            }
            if (onMultiPurposeListener != null) {
                onMultiPurposeListener.onStateChanged(this, refreshState2, refreshState);
            }
            if (refreshState == RefreshState.LoadFinish) {
                this.mFooterLocked = false;
            }
        } else if (this.mViceState != refreshState2) {
            this.mViceState = refreshState2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RefreshInternal refreshInternal;
        super.onAttachedToWindow();
        boolean z = true;
        this.mAttachedToWindow = true;
        if (!isInEditMode()) {
            if (this.mRefreshHeader == null) {
                DefaultRefreshHeaderCreator defaultRefreshHeaderCreator = sHeaderCreator;
                if (defaultRefreshHeaderCreator != null) {
                    setRefreshHeader(defaultRefreshHeaderCreator.createRefreshHeader(getContext(), this));
                } else {
                    setRefreshHeader(new BezierRadarHeader(getContext()));
                }
            }
            if (this.mRefreshFooter == null) {
                DefaultRefreshFooterCreator defaultRefreshFooterCreator = sFooterCreator;
                if (defaultRefreshFooterCreator != null) {
                    setRefreshFooter(defaultRefreshFooterCreator.createRefreshFooter(getContext(), this));
                } else {
                    boolean z2 = this.mEnableLoadMore;
                    setRefreshFooter(new BallPulseFooter(getContext()));
                    this.mEnableLoadMore = z2;
                }
            } else {
                if (!this.mEnableLoadMore && this.mManualLoadMore) {
                    z = false;
                }
                this.mEnableLoadMore = z;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RefreshInternal refreshInternal2 = this.mRefreshHeader;
                    if ((refreshInternal2 == null || childAt != refreshInternal2.getView()) && ((refreshInternal = this.mRefreshFooter) == null || childAt != refreshInternal.getView())) {
                        this.mRefreshContent = new g12(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int dp2px = zd2.dp2px(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R$string.srl_content_empty);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                g12 g12Var = new g12(textView);
                this.mRefreshContent = g12Var;
                g12Var.getView().setPadding(dp2px, dp2px, dp2px, dp2px);
            }
            View findViewById = findViewById(this.mFixedHeaderViewId);
            View findViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, findViewById2);
            if (this.mSpinner != 0) {
                notifyStateChanged(RefreshState.None);
                RefreshContent refreshContent = this.mRefreshContent;
                this.mSpinner = 0;
                refreshContent.moveSpinner(0, this.mHeaderTranslationViewId, this.mFooterTranslationViewId);
            }
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null) {
            RefreshInternal refreshInternal3 = this.mRefreshHeader;
            if (refreshInternal3 != null) {
                refreshInternal3.setPrimaryColors(iArr);
            }
            RefreshInternal refreshInternal4 = this.mRefreshFooter;
            if (refreshInternal4 != null) {
                refreshInternal4.setPrimaryColors(this.mPrimaryColors);
            }
        }
        RefreshContent refreshContent2 = this.mRefreshContent;
        if (refreshContent2 != null) {
            super.bringChildToFront(refreshContent2.getView());
        }
        RefreshInternal refreshInternal5 = this.mRefreshHeader;
        if (refreshInternal5 != null && refreshInternal5.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        RefreshInternal refreshInternal6 = this.mRefreshFooter;
        if (refreshInternal6 == null || !refreshInternal6.getSpinnerStyle().b) {
            return;
        }
        super.bringChildToFront(this.mRefreshFooter.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        this.mKernel.moveSpinner(0, true);
        notifyStateChanged(RefreshState.None);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mManualLoadMore = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.mFooterLocked = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0052  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onFinishInflate() {
        /*
            r11 = this;
            super.onFinishInflate()
            int r0 = super.getChildCount()
            r1 = 3
            if (r0 > r1) goto L9e
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = 0
        Lf:
            r7 = 2
            r8 = 1
            if (r4 >= r0) goto L33
            android.view.View r9 = super.getChildAt(r4)
            boolean r10 = tb.zd2.isContentView(r9)
            if (r10 == 0) goto L24
            if (r6 < r7) goto L21
            if (r4 != r8) goto L24
        L21:
            r5 = r4
            r6 = 2
            goto L30
        L24:
            boolean r7 = r9 instanceof com.scwang.smartrefresh.layout.api.RefreshInternal
            if (r7 != 0) goto L30
            if (r6 >= r8) goto L30
            if (r4 <= 0) goto L2e
            r6 = 1
            goto L2f
        L2e:
            r6 = 0
        L2f:
            r5 = r4
        L30:
            int r4 = r4 + 1
            goto Lf
        L33:
            if (r5 < 0) goto L4d
            tb.g12 r4 = new tb.g12
            android.view.View r6 = super.getChildAt(r5)
            r4.<init>(r6)
            r11.mRefreshContent = r4
            if (r5 != r8) goto L48
            if (r0 != r1) goto L46
            r1 = 0
            goto L4f
        L46:
            r1 = 0
            goto L4e
        L48:
            if (r0 != r7) goto L4d
            r1 = -1
            r7 = 1
            goto L4f
        L4d:
            r1 = -1
        L4e:
            r7 = -1
        L4f:
            r4 = 0
        L50:
            if (r4 >= r0) goto L9d
            android.view.View r5 = super.getChildAt(r4)
            if (r4 == r1) goto L8b
            if (r4 == r7) goto L65
            if (r1 != r2) goto L65
            com.scwang.smartrefresh.layout.api.RefreshInternal r6 = r11.mRefreshHeader
            if (r6 != 0) goto L65
            boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.api.RefreshHeader
            if (r6 == 0) goto L65
            goto L8b
        L65:
            if (r4 == r7) goto L6d
            if (r7 != r2) goto L9a
            boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.api.RefreshFooter
            if (r6 == 0) goto L9a
        L6d:
            boolean r6 = r11.mEnableLoadMore
            if (r6 != 0) goto L78
            boolean r6 = r11.mManualLoadMore
            if (r6 != 0) goto L76
            goto L78
        L76:
            r6 = 0
            goto L79
        L78:
            r6 = 1
        L79:
            r11.mEnableLoadMore = r6
            boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.api.RefreshFooter
            if (r6 == 0) goto L82
            com.scwang.smartrefresh.layout.api.RefreshFooter r5 = (com.scwang.smartrefresh.layout.api.RefreshFooter) r5
            goto L88
        L82:
            com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper r6 = new com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper
            r6.<init>(r5)
            r5 = r6
        L88:
            r11.mRefreshFooter = r5
            goto L9a
        L8b:
            boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.api.RefreshHeader
            if (r6 == 0) goto L92
            com.scwang.smartrefresh.layout.api.RefreshHeader r5 = (com.scwang.smartrefresh.layout.api.RefreshHeader) r5
            goto L98
        L92:
            com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper r6 = new com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper
            r6.<init>(r5)
            r5 = r6
        L98:
            r11.mRefreshHeader = r5
        L9a:
            int r4 = r4 + 1
            goto L50
        L9d:
            return
        L9e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "最多只支持3个子View，Most only support three sub view"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            if (childAt.getVisibility() != 8 && childAt.getTag(R$string.srl_component_falsify) != childAt) {
                RefreshContent refreshContent = this.mRefreshContent;
                boolean z2 = true;
                if (refreshContent != null && refreshContent.getView() == childAt) {
                    boolean z3 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mRefreshHeader != null;
                    View view = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i7 = marginLayoutParams.leftMargin + paddingLeft;
                    int i8 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i7;
                    int measuredHeight = view.getMeasuredHeight() + i8;
                    if (z3 && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) {
                        int i9 = this.mHeaderHeight;
                        i8 += i9;
                        measuredHeight += i9;
                    }
                    view.layout(i7, i8, measuredWidth, measuredHeight);
                }
                RefreshInternal refreshInternal = this.mRefreshHeader;
                if (refreshInternal != null && refreshInternal.getView() == childAt) {
                    boolean z4 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh);
                    View view2 = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int i10 = marginLayoutParams2.leftMargin;
                    int i11 = marginLayoutParams2.topMargin + this.mHeaderInsetStart;
                    int measuredWidth2 = view2.getMeasuredWidth() + i10;
                    int measuredHeight2 = view2.getMeasuredHeight() + i11;
                    if (!z4 && this.mRefreshHeader.getSpinnerStyle() == df2.Translate) {
                        int i12 = this.mHeaderHeight;
                        i11 -= i12;
                        measuredHeight2 -= i12;
                    }
                    view2.layout(i10, i11, measuredWidth2, measuredHeight2);
                }
                RefreshInternal refreshInternal2 = this.mRefreshFooter;
                if (refreshInternal2 != null && refreshInternal2.getView() == childAt) {
                    z2 = (isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) ? false : false;
                    View view3 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    df2 spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                    int i13 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mEnableFooterFollowWhenNoMoreData && this.mRefreshContent != null && this.mRefreshFooter.getSpinnerStyle() == df2.Translate && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        View view4 = this.mRefreshContent.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == df2.MatchLayout) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.mFooterInsetStart;
                    } else {
                        if (!z2 && spinnerStyle != df2.FixedFront && spinnerStyle != df2.FixedBehind) {
                            if (spinnerStyle.c && this.mSpinner < 0) {
                                i5 = Math.max(isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0, 0);
                            }
                        } else {
                            i5 = this.mFooterHeight;
                        }
                        measuredHeight3 -= i5;
                    }
                    view3.layout(i13, measuredHeight3, view3.getMeasuredWidth() + i13, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ec  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 768
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        return this.mNestedChild.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        return (this.mFooterLocked && f3 > 0.0f) || startFlingIfNeed(-f3) || this.mNestedChild.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr) {
        int i3 = this.mTotalUnconsumed;
        int i4 = 0;
        if (i2 * i3 > 0) {
            if (Math.abs(i2) > Math.abs(this.mTotalUnconsumed)) {
                int i5 = this.mTotalUnconsumed;
                this.mTotalUnconsumed = 0;
                i4 = i5;
            } else {
                this.mTotalUnconsumed -= i2;
                i4 = i2;
            }
            moveSpinnerInfinitely(this.mTotalUnconsumed);
        } else if (i2 > 0 && this.mFooterLocked) {
            int i6 = i3 - i2;
            this.mTotalUnconsumed = i6;
            moveSpinnerInfinitely(i6);
            i4 = i2;
        }
        this.mNestedChild.dispatchNestedPreScroll(i, i2 - i4, iArr, null);
        iArr[1] = iArr[1] + i4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4) {
        ScrollBoundaryDecider scrollBoundaryDecider;
        ScrollBoundaryDecider scrollBoundaryDecider2;
        boolean dispatchNestedScroll = this.mNestedChild.dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if ((i5 < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (scrollBoundaryDecider2 = this.mScrollBoundaryDecider) == null || scrollBoundaryDecider2.canRefresh(this.mRefreshContent.getView())))) || (i5 > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (scrollBoundaryDecider = this.mScrollBoundaryDecider) == null || scrollBoundaryDecider.canLoadMore(this.mRefreshContent.getView()))))) {
            RefreshState refreshState = this.mViceState;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.mKernel.setState(i5 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!dispatchNestedScroll) {
                    ViewParent parent = getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            int i6 = this.mTotalUnconsumed - i5;
            this.mTotalUnconsumed = i6;
            moveSpinnerInfinitely(i6);
        }
        if (!this.mFooterLocked || i2 >= 0) {
            return;
        }
        this.mFooterLocked = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        this.mNestedParent.onNestedScrollAccepted(view, view2, i);
        this.mNestedChild.startNestedScroll(i & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
        interceptAnimatorByAction(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        return (isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0) && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.mNestedParent.onStopNestedScroll(view);
        this.mNestedInProgress = false;
        this.mTotalUnconsumed = 0;
        overSpinner();
        this.mNestedChild.stopNestedScroll();
    }

    protected void overSpinner() {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.mCurrentVelocity > -1000 && this.mSpinner > getMeasuredHeight() / 2) {
                ValueAnimator animSpinner = this.mKernel.animSpinner(getMeasuredHeight());
                if (animSpinner != null) {
                    animSpinner.setDuration(this.mFloorDuration);
                    return;
                }
                return;
            } else if (this.mIsBeingDragged) {
                this.mKernel.finishTwoLevel();
                return;
            } else {
                return;
            }
        }
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2 && (!this.mEnableFooterFollowWhenNoMoreData || !this.mFooterNoMoreData || !this.mFooterNoMoreDataEffective || this.mSpinner >= 0 || !isEnableRefreshOrLoadMore(this.mEnableLoadMore))) {
            RefreshState refreshState3 = this.mState;
            RefreshState refreshState4 = RefreshState.Refreshing;
            if (refreshState3 == refreshState4) {
                int i = this.mSpinner;
                int i2 = this.mHeaderHeight;
                if (i > i2) {
                    this.mKernel.animSpinner(i2);
                    return;
                } else if (i < 0) {
                    this.mKernel.animSpinner(0);
                    return;
                } else {
                    return;
                }
            } else if (refreshState3 == RefreshState.PullDownToRefresh) {
                this.mKernel.setState(RefreshState.PullDownCanceled);
                return;
            } else if (refreshState3 == RefreshState.PullUpToLoad) {
                this.mKernel.setState(RefreshState.PullUpCanceled);
                return;
            } else if (refreshState3 == RefreshState.ReleaseToRefresh) {
                this.mKernel.setState(refreshState4);
                return;
            } else if (refreshState3 == RefreshState.ReleaseToLoad) {
                this.mKernel.setState(refreshState2);
                return;
            } else if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
                this.mKernel.setState(RefreshState.TwoLevelReleased);
                return;
            } else if (refreshState3 == RefreshState.RefreshReleased) {
                if (this.reboundAnimator == null) {
                    this.mKernel.animSpinner(this.mHeaderHeight);
                    return;
                }
                return;
            } else if (refreshState3 == RefreshState.LoadReleased) {
                if (this.reboundAnimator == null) {
                    this.mKernel.animSpinner(-this.mFooterHeight);
                    return;
                }
                return;
            } else if (this.mSpinner != 0) {
                this.mKernel.animSpinner(0);
                return;
            } else {
                return;
            }
        }
        int i3 = this.mSpinner;
        int i4 = this.mFooterHeight;
        if (i3 < (-i4)) {
            this.mKernel.animSpinner(-i4);
        } else if (i3 > 0) {
            this.mKernel.animSpinner(0);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout resetNoMoreData() {
        return setNoMoreData(false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setDisableContentWhenLoading(boolean z) {
        this.mDisableContentWhenLoading = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setDisableContentWhenRefresh(boolean z) {
        this.mDisableContentWhenRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setDragRate(float f2) {
        this.mDragRate = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableAutoLoadMore(boolean z) {
        this.mEnableAutoLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableClipFooterWhenFixedBehind(boolean z) {
        this.mEnableClipFooterWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableClipHeaderWhenFixedBehind(boolean z) {
        this.mEnableClipHeaderWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Deprecated
    public RefreshLayout setEnableFooterFollowWhenLoadFinished(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableFooterFollowWhenNoMoreData(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableFooterTranslationContent(boolean z) {
        this.mEnableFooterTranslationContent = z;
        this.mManualFooterTranslationContent = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableHeaderTranslationContent(boolean z) {
        this.mEnableHeaderTranslationContent = z;
        this.mManualHeaderTranslationContent = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableLoadMore(boolean z) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.mEnableLoadMoreWhenContentNotFull = z;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setEnableLoadMoreWhenContentNotFull(z);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableNestedScroll(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableOverScrollBounce(boolean z) {
        this.mEnableOverScrollBounce = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableOverScrollDrag(boolean z) {
        this.mEnableOverScrollDrag = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnablePureScrollMode(boolean z) {
        this.mEnablePureScrollMode = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableScrollContentWhenLoaded(boolean z) {
        this.mEnableScrollContentWhenLoaded = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableScrollContentWhenRefreshed(boolean z) {
        this.mEnableScrollContentWhenRefreshed = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterHeight(float f2) {
        int dp2px = zd2.dp2px(f2);
        if (dp2px == this.mFooterHeight) {
            return this;
        }
        l80 l80Var = this.mFooterHeightStatus;
        l80 l80Var2 = l80.CodeExact;
        if (l80Var.a(l80Var2)) {
            this.mFooterHeight = dp2px;
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal != null && this.mAttachedToWindow && this.mFooterHeightStatus.b) {
                df2 spinnerStyle = refreshInternal.getSpinnerStyle();
                if (spinnerStyle != df2.MatchLayout && !spinnerStyle.c) {
                    View view = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i = marginLayoutParams.leftMargin;
                    int measuredHeight = ((marginLayoutParams.topMargin + getMeasuredHeight()) - this.mFooterInsetStart) - (spinnerStyle != df2.Translate ? this.mFooterHeight : 0);
                    view.layout(i, measuredHeight, view.getMeasuredWidth() + i, view.getMeasuredHeight() + measuredHeight);
                }
                this.mFooterHeightStatus = l80Var2;
                RefreshInternal refreshInternal2 = this.mRefreshFooter;
                RefreshKernel refreshKernel = this.mKernel;
                int i2 = this.mFooterHeight;
                refreshInternal2.onInitialized(refreshKernel, i2, (int) (this.mFooterMaxDragRate * i2));
            } else {
                this.mFooterHeightStatus = l80.CodeExactUnNotify;
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterInsetStart(float f2) {
        this.mFooterInsetStart = zd2.dp2px(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterMaxDragRate(float f2) {
        this.mFooterMaxDragRate = f2;
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal != null && this.mAttachedToWindow) {
            RefreshKernel refreshKernel = this.mKernel;
            int i = this.mFooterHeight;
            refreshInternal.onInitialized(refreshKernel, i, (int) (i * f2));
        } else {
            this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterTriggerRate(float f2) {
        this.mFooterTriggerRate = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderHeight(float f2) {
        int dp2px = zd2.dp2px(f2);
        if (dp2px == this.mHeaderHeight) {
            return this;
        }
        l80 l80Var = this.mHeaderHeightStatus;
        l80 l80Var2 = l80.CodeExact;
        if (l80Var.a(l80Var2)) {
            this.mHeaderHeight = dp2px;
            RefreshInternal refreshInternal = this.mRefreshHeader;
            if (refreshInternal != null && this.mAttachedToWindow && this.mHeaderHeightStatus.b) {
                df2 spinnerStyle = refreshInternal.getSpinnerStyle();
                if (spinnerStyle != df2.MatchLayout && !spinnerStyle.c) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i = marginLayoutParams.leftMargin;
                    int i2 = (marginLayoutParams.topMargin + this.mHeaderInsetStart) - (spinnerStyle == df2.Translate ? this.mHeaderHeight : 0);
                    view.layout(i, i2, view.getMeasuredWidth() + i, view.getMeasuredHeight() + i2);
                }
                this.mHeaderHeightStatus = l80Var2;
                RefreshInternal refreshInternal2 = this.mRefreshHeader;
                RefreshKernel refreshKernel = this.mKernel;
                int i3 = this.mHeaderHeight;
                refreshInternal2.onInitialized(refreshKernel, i3, (int) (this.mHeaderMaxDragRate * i3));
            } else {
                this.mHeaderHeightStatus = l80.CodeExactUnNotify;
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderInsetStart(float f2) {
        this.mHeaderInsetStart = zd2.dp2px(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderMaxDragRate(float f2) {
        this.mHeaderMaxDragRate = f2;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null && this.mAttachedToWindow) {
            RefreshKernel refreshKernel = this.mKernel;
            int i = this.mHeaderHeight;
            refreshInternal.onInitialized(refreshKernel, i, (int) (f2 * i));
        } else {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderTriggerRate(float f2) {
        this.mHeaderTriggerRate = f2;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mEnableNestedScrolling = z;
        this.mNestedChild.setNestedScrollingEnabled(z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setNoMoreData(boolean z) {
        if (this.mState == RefreshState.Loading && z) {
            finishLoadMoreWithNoMoreData();
            return this;
        }
        if (this.mFooterNoMoreData != z) {
            this.mFooterNoMoreData = z;
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal instanceof RefreshFooter) {
                if (((RefreshFooter) refreshInternal).setNoMoreData(z)) {
                    this.mFooterNoMoreDataEffective = true;
                    if (this.mFooterNoMoreData && this.mEnableFooterFollowWhenNoMoreData && this.mSpinner > 0 && this.mRefreshFooter.getSpinnerStyle() == df2.Translate && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableRefresh, this.mRefreshHeader)) {
                        this.mRefreshFooter.getView().setTranslationY(this.mSpinner);
                    }
                } else {
                    this.mFooterNoMoreDataEffective = false;
                    new RuntimeException("Footer:" + this.mRefreshFooter + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mLoadMoreListener = onLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || onLoadMoreListener == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnMultiPurposeListener(OnMultiPurposeListener onMultiPurposeListener) {
        this.mOnMultiPurposeListener = onMultiPurposeListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        this.mRefreshListener = onRefreshLoadMoreListener;
        this.mLoadMoreListener = onRefreshLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || onRefreshLoadMoreListener == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setPrimaryColors(@ColorInt int... iArr) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            refreshInternal.setPrimaryColors(iArr);
        }
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null) {
            refreshInternal2.setPrimaryColors(iArr);
        }
        this.mPrimaryColors = iArr;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setPrimaryColorsId(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(getContext(), iArr[i]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setReboundDuration(int i) {
        this.mReboundDuration = i;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setReboundInterpolator(@NonNull Interpolator interpolator) {
        this.mReboundInterpolator = interpolator;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshContent(@NonNull View view) {
        return setRefreshContent(view, -1, -1);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter) {
        return setRefreshFooter(refreshFooter, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader) {
        return setRefreshHeader(refreshHeader, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider) {
        this.mScrollBoundaryDecider = scrollBoundaryDecider;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setScrollBoundaryDecider(scrollBoundaryDecider);
        }
        return this;
    }

    protected void setStateDirectLoading(boolean z) {
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(refreshState2);
            OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
            if (onLoadMoreListener != null) {
                if (z) {
                    onLoadMoreListener.onLoadMore(this);
                }
            } else if (this.mOnMultiPurposeListener == null) {
                finishLoadMore(2000);
            }
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal != null) {
                int i = this.mFooterHeight;
                refreshInternal.onStartAnimator(this, i, (int) (this.mFooterMaxDragRate * i));
            }
            OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
            if (onMultiPurposeListener == null || !(this.mRefreshFooter instanceof RefreshFooter)) {
                return;
            }
            if (z) {
                onMultiPurposeListener.onLoadMore(this);
            }
            int i2 = this.mFooterHeight;
            this.mOnMultiPurposeListener.onFooterStartAnimator((RefreshFooter) this.mRefreshFooter, i2, (int) (this.mFooterMaxDragRate * i2));
        }
    }

    protected void setStateLoading(boolean z) {
        b bVar = new b(z);
        notifyStateChanged(RefreshState.LoadReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(-this.mFooterHeight);
        if (animSpinner != null) {
            animSpinner.addListener(bVar);
        }
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal != null) {
            int i = this.mFooterHeight;
            refreshInternal.onReleased(this, i, (int) (this.mFooterMaxDragRate * i));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal2 = this.mRefreshFooter;
            if (refreshInternal2 instanceof RefreshFooter) {
                int i2 = this.mFooterHeight;
                onMultiPurposeListener.onFooterReleased((RefreshFooter) refreshInternal2, i2, (int) (this.mFooterMaxDragRate * i2));
            }
        }
        if (animSpinner == null) {
            bVar.onAnimationEnd(null);
        }
    }

    protected void setStateRefreshing(boolean z) {
        c cVar = new c(z);
        notifyStateChanged(RefreshState.RefreshReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(this.mHeaderHeight);
        if (animSpinner != null) {
            animSpinner.addListener(cVar);
        }
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            int i = this.mHeaderHeight;
            refreshInternal.onReleased(this, i, (int) (this.mHeaderMaxDragRate * i));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal2 = this.mRefreshHeader;
            if (refreshInternal2 instanceof RefreshHeader) {
                int i2 = this.mHeaderHeight;
                onMultiPurposeListener.onHeaderReleased((RefreshHeader) refreshInternal2, i2, (int) (this.mHeaderMaxDragRate * i2));
            }
        }
        if (animSpinner == null) {
            cVar.onAnimationEnd(null);
        }
    }

    protected void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            notifyStateChanged(RefreshState.None);
        }
        if (this.mViceState != refreshState) {
            this.mViceState = refreshState;
        }
    }

    protected boolean startFlingIfNeed(float f2) {
        if (f2 == 0.0f) {
            f2 = this.mCurrentVelocity;
        }
        if (Build.VERSION.SDK_INT > 27 && this.mRefreshContent != null) {
            getScaleY();
            View view = this.mRefreshContent.getView();
            if (getScaleY() == -1.0f && view.getScaleY() == -1.0f) {
                f2 = -f2;
            }
        }
        if (Math.abs(f2) > this.mMinimumVelocity) {
            int i = this.mSpinner;
            if (i * f2 < 0.0f) {
                RefreshState refreshState = this.mState;
                if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.Loading && (i >= 0 || !this.mFooterNoMoreData)) {
                    if (refreshState.isReleaseToOpening) {
                        return true;
                    }
                } else {
                    this.animationRunnable = new FlingRunnable(f2).start();
                    return true;
                }
            }
            if ((f2 < 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableLoadMore || this.mEnableOverScrollDrag)) || ((this.mState == RefreshState.Loading && i >= 0) || (this.mEnableAutoLoadMore && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) || (f2 > 0.0f && ((this.mEnableOverScrollBounce && this.mEnableRefresh) || this.mEnableOverScrollDrag || (this.mState == RefreshState.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-f2), 0, 0, StandOutWindow.StandOutLayoutParams.AUTO_POSITION, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFloorDuration = 300;
        this.mReboundDuration = 300;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mFixedHeaderViewId = -1;
        this.mFixedFooterViewId = -1;
        this.mHeaderTranslationViewId = -1;
        this.mFooterTranslationViewId = -1;
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenNoMoreData = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mEnableNestedScrolling = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mFooterNoMoreDataEffective = false;
        this.mManualLoadMore = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mParentOffsetInWindow = new int[2];
        this.mNestedChild = new NestedScrollingChildHelper(this);
        this.mNestedParent = new NestedScrollingParentHelper(this);
        l80 l80Var = l80.DefaultUnNotify;
        this.mHeaderHeightStatus = l80Var;
        this.mFooterHeightStatus = l80Var;
        this.mHeaderMaxDragRate = 2.5f;
        this.mFooterMaxDragRate = 2.5f;
        this.mHeaderTriggerRate = 1.0f;
        this.mFooterTriggerRate = 1.0f;
        this.mKernel = new f();
        RefreshState refreshState = RefreshState.None;
        this.mState = refreshState;
        this.mViceState = refreshState;
        this.mLastOpenTime = 0L;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mHandler = new Handler();
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics());
        this.mReboundInterpolator = new zd2(zd2.INTERPOLATOR_VISCOUS_FLUID);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFooterHeight = zd2.dp2px(60.0f);
        this.mHeaderHeight = zd2.dp2px(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        DefaultRefreshInitializer defaultRefreshInitializer = sRefreshInitializer;
        if (defaultRefreshInitializer != null) {
            defaultRefreshInitializer.initialize(context, this);
        }
        this.mDragRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = obtainStyledAttributes.getInt(R$styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        int i = R$styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.mEnableLoadMore = obtainStyledAttributes.getBoolean(i, this.mEnableLoadMore);
        int i2 = R$styleable.SmartRefreshLayout_srlHeaderHeight;
        this.mHeaderHeight = obtainStyledAttributes.getDimensionPixelOffset(i2, this.mHeaderHeight);
        int i3 = R$styleable.SmartRefreshLayout_srlFooterHeight;
        this.mFooterHeight = obtainStyledAttributes.getDimensionPixelOffset(i3, this.mFooterHeight);
        this.mHeaderInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlHeaderInsetStart, this.mHeaderInsetStart);
        this.mFooterInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlFooterInsetStart, this.mFooterInsetStart);
        this.mDisableContentWhenRefresh = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        int i4 = R$styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.mEnableHeaderTranslationContent = obtainStyledAttributes.getBoolean(i4, this.mEnableHeaderTranslationContent);
        int i5 = R$styleable.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.mEnableFooterTranslationContent = obtainStyledAttributes.getBoolean(i5, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableFooterFollowWhenNoMoreData = z;
        this.mEnableFooterFollowWhenNoMoreData = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z);
        this.mEnableClipHeaderWhenFixedBehind = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        this.mEnableOverScrollDrag = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.mFixedHeaderViewId);
        this.mFixedFooterViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedFooterViewId, this.mFixedFooterViewId);
        this.mHeaderTranslationViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.mHeaderTranslationViewId);
        this.mFooterTranslationViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.mFooterTranslationViewId);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.mEnableNestedScrolling);
        this.mEnableNestedScrolling = z2;
        this.mNestedChild.setNestedScrollingEnabled(z2);
        this.mManualLoadMore = this.mManualLoadMore || obtainStyledAttributes.hasValue(i);
        this.mManualHeaderTranslationContent = this.mManualHeaderTranslationContent || obtainStyledAttributes.hasValue(i4);
        this.mManualFooterTranslationContent = this.mManualFooterTranslationContent || obtainStyledAttributes.hasValue(i5);
        this.mHeaderHeightStatus = obtainStyledAttributes.hasValue(i2) ? l80.XmlLayoutUnNotify : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = obtainStyledAttributes.hasValue(i3) ? l80.XmlLayoutUnNotify : this.mFooterHeightStatus;
        int color = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        if (this.mEnablePureScrollMode && !this.mManualLoadMore && !this.mEnableLoadMore) {
            this.mEnableLoadMore = true;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMore(int i, final int i2, final float f2, final boolean z) {
        if (this.mState == RefreshState.None && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && !this.mFooterNoMoreData) {
            Runnable runnable = new Runnable() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.9

                /* compiled from: Taobao */
                /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$9$a */
                /* loaded from: classes7.dex */
                class a implements ValueAnimator.AnimatorUpdateListener {
                    a() {
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.reboundAnimator != null) {
                            smartRefreshLayout.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                        }
                    }
                }

                /* compiled from: Taobao */
                /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$9$b */
                /* loaded from: classes7.dex */
                class b extends AnimatorListenerAdapter {
                    b() {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.reboundAnimator != null) {
                            smartRefreshLayout.reboundAnimator = null;
                            RefreshState refreshState = smartRefreshLayout.mState;
                            RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                            if (refreshState != refreshState2) {
                                smartRefreshLayout.mKernel.setState(refreshState2);
                            }
                            AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                            SmartRefreshLayout.this.setStateLoading(!z);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (smartRefreshLayout.mViceState != RefreshState.Loading) {
                        return;
                    }
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.mLastTouchX = smartRefreshLayout2.getMeasuredWidth() / 2.0f;
                    SmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpToLoad);
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    smartRefreshLayout3.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout3.mSpinner, -((int) (smartRefreshLayout3.mFooterHeight * f2)));
                    SmartRefreshLayout.this.reboundAnimator.setDuration(i2);
                    SmartRefreshLayout.this.reboundAnimator.setInterpolator(new zd2(zd2.INTERPOLATOR_VISCOUS_FLUID));
                    SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new a());
                    SmartRefreshLayout.this.reboundAnimator.addListener(new b());
                    SmartRefreshLayout.this.reboundAnimator.start();
                }
            };
            setViceState(RefreshState.Loading);
            if (i > 0) {
                this.mHandler.postDelayed(runnable, i);
                return true;
            }
            runnable.run();
            return true;
        }
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Deprecated
    public boolean autoRefresh(int i) {
        int i2 = this.mReboundDuration;
        int i3 = this.mHeaderHeight;
        float f2 = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * i3 * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f2 / i3, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore(int i) {
        return finishLoadMore(i, true, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh(int i) {
        return finishRefresh(i, true, Boolean.FALSE);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshContent(@NonNull View view, int i, int i2) {
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            super.removeView(refreshContent.getView());
        }
        super.addView(view, getChildCount(), new LayoutParams(i, i2));
        this.mRefreshContent = new g12(view);
        if (this.mAttachedToWindow) {
            View findViewById = findViewById(this.mFixedHeaderViewId);
            View findViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, findViewById2);
        }
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null && refreshInternal.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null && refreshInternal2.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter, int i, int i2) {
        RefreshInternal refreshInternal;
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null) {
            super.removeView(refreshInternal2.getView());
        }
        this.mRefreshFooter = refreshFooter;
        this.mFooterLocked = false;
        this.mFooterBackgroundColor = 0;
        this.mFooterNoMoreDataEffective = false;
        this.mFooterNeedTouchEventWhenLoading = false;
        this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        this.mEnableLoadMore = !this.mManualLoadMore || this.mEnableLoadMore;
        if (this.mRefreshFooter.getSpinnerStyle().b) {
            super.addView(this.mRefreshFooter.getView(), getChildCount(), new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshFooter.getView(), 0, new LayoutParams(i, i2));
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null && (refreshInternal = this.mRefreshFooter) != null) {
            refreshInternal.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader, int i, int i2) {
        RefreshInternal refreshInternal;
        RefreshInternal refreshInternal2 = this.mRefreshHeader;
        if (refreshInternal2 != null) {
            super.removeView(refreshInternal2.getView());
        }
        this.mRefreshHeader = refreshHeader;
        this.mHeaderBackgroundColor = 0;
        this.mHeaderNeedTouchEventWhenRefreshing = false;
        this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        if (this.mRefreshHeader.getSpinnerStyle().b) {
            super.addView(this.mRefreshHeader.getView(), getChildCount(), new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshHeader.getView(), 0, new LayoutParams(i, i2));
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null && (refreshInternal = this.mRefreshHeader) != null) {
            refreshInternal.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefresh(int i, final int i2, final float f2, final boolean z) {
        if (this.mState == RefreshState.None && isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
            Runnable runnable = new Runnable() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.8

                /* compiled from: Taobao */
                /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$8$a */
                /* loaded from: classes7.dex */
                class a implements ValueAnimator.AnimatorUpdateListener {
                    a() {
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.reboundAnimator != null) {
                            smartRefreshLayout.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                        }
                    }
                }

                /* compiled from: Taobao */
                /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$8$b */
                /* loaded from: classes7.dex */
                class b extends AnimatorListenerAdapter {
                    b() {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.reboundAnimator != null) {
                            smartRefreshLayout.reboundAnimator = null;
                            RefreshState refreshState = smartRefreshLayout.mState;
                            RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                            if (refreshState != refreshState2) {
                                smartRefreshLayout.mKernel.setState(refreshState2);
                            }
                            AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                            SmartRefreshLayout.this.setStateRefreshing(!z);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (smartRefreshLayout.mViceState != RefreshState.Refreshing) {
                        return;
                    }
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.mLastTouchX = smartRefreshLayout2.getMeasuredWidth() / 2.0f;
                    SmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    smartRefreshLayout3.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout3.mSpinner, (int) (smartRefreshLayout3.mHeaderHeight * f2));
                    SmartRefreshLayout.this.reboundAnimator.setDuration(i2);
                    SmartRefreshLayout.this.reboundAnimator.setInterpolator(new zd2(zd2.INTERPOLATOR_VISCOUS_FLUID));
                    SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new a());
                    SmartRefreshLayout.this.reboundAnimator.addListener(new b());
                    SmartRefreshLayout.this.reboundAnimator.start();
                }
            };
            setViceState(RefreshState.Refreshing);
            if (i > 0) {
                this.mHandler.postDelayed(runnable, i);
                return true;
            }
            runnable.run();
            return true;
        }
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore(boolean z) {
        return finishLoadMore(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16 : 0, z, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh(boolean z) {
        if (z) {
            return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.FALSE);
        }
        return finishRefresh(0, false, null);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore(int i, boolean z, boolean z2) {
        int i2 = i >> 16;
        int i3 = (i << 16) >> 16;
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(i2, z2, z);
        if (i3 > 0) {
            this.mHandler.postDelayed(anonymousClass7, i3);
        } else {
            anonymousClass7.run();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh(int i, final boolean z, final Boolean bool) {
        final int i2 = i >> 16;
        int i3 = (i << 16) >> 16;
        Runnable runnable = new Runnable() { // from class: com.scwang.smartrefresh.layout.SmartRefreshLayout.6
            int count = 0;

            @Override // java.lang.Runnable
            public void run() {
                int i4 = this.count;
                if (i4 == 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState = smartRefreshLayout.mState;
                    RefreshState refreshState2 = RefreshState.None;
                    if (refreshState == refreshState2 && smartRefreshLayout.mViceState == RefreshState.Refreshing) {
                        smartRefreshLayout.mViceState = refreshState2;
                        return;
                    }
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                        smartRefreshLayout.reboundAnimator = null;
                        valueAnimator.cancel();
                        SmartRefreshLayout.this.mKernel.setState(refreshState2);
                        return;
                    } else if (refreshState != RefreshState.Refreshing || smartRefreshLayout.mRefreshHeader == null || smartRefreshLayout.mRefreshContent == null) {
                        return;
                    } else {
                        this.count = i4 + 1;
                        smartRefreshLayout.mHandler.postDelayed(this, i2);
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshFinish);
                        Boolean bool2 = bool;
                        if (bool2 != null) {
                            SmartRefreshLayout.this.setNoMoreData(bool2 == Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int onFinish = smartRefreshLayout2.mRefreshHeader.onFinish(smartRefreshLayout2, z);
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout3.mOnMultiPurposeListener;
                if (onMultiPurposeListener != null) {
                    RefreshInternal refreshInternal = smartRefreshLayout3.mRefreshHeader;
                    if (refreshInternal instanceof RefreshHeader) {
                        onMultiPurposeListener.onHeaderFinish((RefreshHeader) refreshInternal, z);
                    }
                }
                if (onFinish < Integer.MAX_VALUE) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.mIsBeingDragged || smartRefreshLayout4.mNestedInProgress) {
                        long currentTimeMillis = System.currentTimeMillis();
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        if (smartRefreshLayout5.mIsBeingDragged) {
                            float f2 = smartRefreshLayout5.mLastTouchY;
                            smartRefreshLayout5.mTouchY = f2;
                            smartRefreshLayout5.mTouchSpinner = 0;
                            smartRefreshLayout5.mIsBeingDragged = false;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout5.mLastTouchX, (f2 + smartRefreshLayout5.mSpinner) - (smartRefreshLayout5.mTouchSlop * 2), 0));
                            SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout6.mLastTouchX, smartRefreshLayout6.mLastTouchY + smartRefreshLayout6.mSpinner, 0));
                        }
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (smartRefreshLayout7.mNestedInProgress) {
                            smartRefreshLayout7.mTotalUnconsumed = 0;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout7.mLastTouchX, smartRefreshLayout7.mLastTouchY, 0));
                            SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                            smartRefreshLayout8.mNestedInProgress = false;
                            smartRefreshLayout8.mTouchSpinner = 0;
                        }
                    }
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    int i5 = smartRefreshLayout9.mSpinner;
                    if (i5 <= 0) {
                        if (i5 < 0) {
                            smartRefreshLayout9.animSpinner(0, onFinish, smartRefreshLayout9.mReboundInterpolator, smartRefreshLayout9.mReboundDuration);
                            return;
                        }
                        smartRefreshLayout9.mKernel.moveSpinner(0, false);
                        SmartRefreshLayout.this.mKernel.setState(RefreshState.None);
                        return;
                    }
                    ValueAnimator animSpinner = smartRefreshLayout9.animSpinner(0, onFinish, smartRefreshLayout9.mReboundInterpolator, smartRefreshLayout9.mReboundDuration);
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished = smartRefreshLayout10.mEnableScrollContentWhenRefreshed ? smartRefreshLayout10.mRefreshContent.scrollContentWhenFinished(smartRefreshLayout10.mSpinner) : null;
                    if (animSpinner == null || scrollContentWhenFinished == null) {
                        return;
                    }
                    animSpinner.addUpdateListener(scrollContentWhenFinished);
                }
            }
        };
        if (i3 > 0) {
            this.mHandler.postDelayed(runnable, i3);
        } else {
            runnable.run();
        }
        return this;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int backgroundColor;
        public df2 spinnerStyle;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.backgroundColor = 0;
            this.spinnerStyle = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout_Layout);
            this.backgroundColor = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.backgroundColor);
            int i = R$styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i)) {
                this.spinnerStyle = df2.values[obtainStyledAttributes.getInt(i, df2.Translate.a)];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.backgroundColor = 0;
            this.spinnerStyle = null;
        }
    }
}
