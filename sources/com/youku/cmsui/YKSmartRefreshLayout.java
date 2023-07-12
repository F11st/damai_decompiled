package com.youku.cmsui;

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
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
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
import com.scwang.smartrefresh.layout.util.DelayedRunnable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.scwang.smartrefresh.layout.util.ViscousFluidInterpolator;
import com.youku.resource.R;
import com.youku.resource.widget.YKPageRefreshHeader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.df2;
import tb.l80;
import tb.m72;
import tb.zd2;

/* compiled from: Taobao */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
public class YKSmartRefreshLayout extends ViewGroup implements NestedScrollingParent, RefreshLayout {
    protected static DefaultRefreshFooterCreator sFooterCreator = new DefaultRefreshFooterCreator() { // from class: com.youku.cmsui.YKSmartRefreshLayout.1
        @Override // com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator
        @NonNull
        public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout refreshLayout) {
            return new BallPulseFooter(context);
        }
    };
    protected static DefaultRefreshHeaderCreator sHeaderCreator = new DefaultRefreshHeaderCreator() { // from class: com.youku.cmsui.YKSmartRefreshLayout.2
        @Override // com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator
        @NonNull
        public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout refreshLayout) {
            return new BezierRadarHeader(context);
        }
    };
    protected static boolean sManualFooterCreator;
    protected Runnable animationRunnable;
    protected boolean isAutoRefresh;
    protected boolean mAblePullingDownWhenRefreshing;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableFooterFollowWhenLoadFinished;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
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
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected l80 mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected float mHeaderTriggerRate;
    protected boolean mInterceptEventWhenStatueChanged;
    protected boolean mIsBeingDragged;
    protected RefreshKernel mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected float mLastTouchX;
    protected float mLastTouchY;
    protected List<DelayedRunnable> mListDelayedRunnable;
    protected OnLoadMoreListener mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected boolean mManualNestedScrolling;
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
    protected boolean mSupportDragHDirection;
    protected boolean mSupportNestedHScroll;
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
    /* renamed from: com.youku.cmsui.YKSmartRefreshLayout$11  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass11 implements Runnable {
        final /* synthetic */ float val$dragRate;
        final /* synthetic */ int val$lastingTime;

        AnonymousClass11(float f, int i) {
            this.val$dragRate = f;
            this.val$lastingTime = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            RefreshInternal refreshInternal = yKSmartRefreshLayout.mRefreshHeader;
            if (refreshInternal instanceof YKPageRefreshHeader) {
                yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(0, Math.min(((YKPageRefreshHeader) refreshInternal).mRefreshingHeight, yKSmartRefreshLayout.mHeaderHeight));
            } else {
                yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(yKSmartRefreshLayout.mSpinner, (int) (yKSmartRefreshLayout.mHeaderHeight * this.val$dragRate));
            }
            YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
            yKSmartRefreshLayout2.reboundAnimator.setDuration(yKSmartRefreshLayout2.mReboundDuration);
            YKSmartRefreshLayout.this.reboundAnimator.setInterpolator(new DecelerateInterpolator());
            YKSmartRefreshLayout.this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.cmsui.YKSmartRefreshLayout.11.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    YKSmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
                }
            });
            YKSmartRefreshLayout.this.reboundAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.youku.cmsui.YKSmartRefreshLayout.11.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                    yKSmartRefreshLayout3.reboundAnimator = null;
                    yKSmartRefreshLayout3.postDelayed(new Runnable() { // from class: com.youku.cmsui.YKSmartRefreshLayout.11.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
                            if (yKSmartRefreshLayout4.mState == RefreshState.None) {
                                yKSmartRefreshLayout4.mKernel.animSpinner(0);
                            }
                        }
                    }, AnonymousClass11.this.val$lastingTime);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                    yKSmartRefreshLayout3.mLastTouchX = yKSmartRefreshLayout3.getMeasuredWidth() / 2;
                }
            });
            YKSmartRefreshLayout.this.reboundAnimator.start();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.cmsui.YKSmartRefreshLayout$13  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState;

        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.RefreshFinish.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.LoadFinish.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.TwoLevelReleased.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.TwoLevelFinish.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.TwoLevel.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.cmsui.YKSmartRefreshLayout$9  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass9 implements Runnable {
        final /* synthetic */ boolean val$noMoreData;
        final /* synthetic */ boolean val$success;

        AnonymousClass9(boolean z, boolean z2) {
            this.val$success = z;
            this.val$noMoreData = z2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
            if (r1.mRefreshContent.canLoadMore() != false) goto L22;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 228
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass9.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
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
            YKSmartRefreshLayout.this.postDelayed(this, this.mFrameDelay);
        }

        @Override // java.lang.Runnable
        public void run() {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            if (yKSmartRefreshLayout.animationRunnable != this || yKSmartRefreshLayout.mState.isFinishing) {
                return;
            }
            if (Math.abs(yKSmartRefreshLayout.mSpinner) >= Math.abs(this.mSmoothDistance)) {
                if (this.mSmoothDistance != 0) {
                    int i = this.mFrame + 1;
                    this.mFrame = i;
                    this.mVelocity = (float) (this.mVelocity * Math.pow(0.44999998807907104d, i));
                } else {
                    int i2 = this.mFrame + 1;
                    this.mFrame = i2;
                    this.mVelocity = (float) (this.mVelocity * Math.pow(0.8500000238418579d, i2));
                }
            } else {
                int i3 = this.mFrame + 1;
                this.mFrame = i3;
                this.mVelocity = (float) (this.mVelocity * Math.pow(0.949999988079071d, i3));
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f = this.mVelocity * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
            if (Math.abs(f) >= 1.0f) {
                this.mLastTime = currentAnimationTimeMillis;
                float f2 = this.mOffset + f;
                this.mOffset = f2;
                YKSmartRefreshLayout.this.moveSpinnerInfinitely(f2);
                YKSmartRefreshLayout.this.postDelayed(this, this.mFrameDelay);
                return;
            }
            YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
            yKSmartRefreshLayout2.animationRunnable = null;
            if (Math.abs(yKSmartRefreshLayout2.mSpinner) >= Math.abs(this.mSmoothDistance)) {
                YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                yKSmartRefreshLayout3.animSpinner(this.mSmoothDistance, 0, yKSmartRefreshLayout3.mReboundInterpolator, Math.min(Math.max((int) DensityUtil.px2dp(Math.abs(YKSmartRefreshLayout.this.mSpinner - this.mSmoothDistance)), 30), 100) * 10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class FlingRunnable implements Runnable {
        int mOffset;
        float mVelocity;
        int mFrame = 0;
        int mFrameDelay = 10;
        float mDamping = 0.95f;
        long mLastTime = AnimationUtils.currentAnimationTimeMillis();

        FlingRunnable(float f) {
            this.mVelocity = f;
            this.mOffset = YKSmartRefreshLayout.this.mSpinner;
        }

        @Override // java.lang.Runnable
        public void run() {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            if (yKSmartRefreshLayout.animationRunnable != this || yKSmartRefreshLayout.mState.isFinishing) {
                return;
            }
            int i = this.mFrame + 1;
            this.mFrame = i;
            this.mVelocity = (float) (this.mVelocity * Math.pow(this.mDamping, i));
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f = this.mVelocity * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
            if (Math.abs(f) > 1.0f) {
                this.mLastTime = currentAnimationTimeMillis;
                int i2 = (int) (this.mOffset + f);
                this.mOffset = i2;
                YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                if (yKSmartRefreshLayout2.mSpinner * i2 > 0) {
                    yKSmartRefreshLayout2.mKernel.moveSpinner(i2, true);
                    YKSmartRefreshLayout.this.postDelayed(this, this.mFrameDelay);
                    return;
                }
                yKSmartRefreshLayout2.animationRunnable = null;
                yKSmartRefreshLayout2.mKernel.moveSpinner(0, true);
                zd2.fling(YKSmartRefreshLayout.this.mRefreshContent.getScrollableView(), (int) (-this.mVelocity));
                YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                if (!yKSmartRefreshLayout3.mFooterLocked || f <= 0.0f) {
                    return;
                }
                yKSmartRefreshLayout3.mFooterLocked = false;
                return;
            }
            YKSmartRefreshLayout.this.animationRunnable = null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
            if (r0.mSpinner >= (-r0.mFooterHeight)) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
            if (r0.mSpinner > r0.mHeaderHeight) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Runnable start() {
            /*
                r11 = this;
                com.youku.cmsui.YKSmartRefreshLayout r0 = com.youku.cmsui.YKSmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                boolean r2 = r1.isFinishing
                r3 = 0
                if (r2 == 0) goto La
                return r3
            La:
                int r2 = r0.mSpinner
                if (r2 == 0) goto L97
                boolean r1 = r1.isOpening
                if (r1 != 0) goto L20
                boolean r1 = r0.mFooterNoMoreData
                if (r1 == 0) goto L4d
                boolean r1 = r0.mEnableFooterFollowWhenLoadFinished
                if (r1 == 0) goto L4d
                boolean r0 = r0.isEnableLoadMore()
                if (r0 == 0) goto L4d
            L20:
                com.youku.cmsui.YKSmartRefreshLayout r0 = com.youku.cmsui.YKSmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
                if (r1 == r2) goto L36
                boolean r1 = r0.mFooterNoMoreData
                if (r1 == 0) goto L3f
                boolean r1 = r0.mEnableFooterFollowWhenLoadFinished
                if (r1 == 0) goto L3f
                boolean r0 = r0.isEnableLoadMore()
                if (r0 == 0) goto L3f
            L36:
                com.youku.cmsui.YKSmartRefreshLayout r0 = com.youku.cmsui.YKSmartRefreshLayout.this
                int r1 = r0.mSpinner
                int r0 = r0.mFooterHeight
                int r0 = -r0
                if (r1 < r0) goto L4d
            L3f:
                com.youku.cmsui.YKSmartRefreshLayout r0 = com.youku.cmsui.YKSmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto L97
                int r1 = r0.mSpinner
                int r0 = r0.mHeaderHeight
                if (r1 <= r0) goto L97
            L4d:
                r0 = 0
                com.youku.cmsui.YKSmartRefreshLayout r1 = com.youku.cmsui.YKSmartRefreshLayout.this
                int r1 = r1.mSpinner
                float r2 = r11.mVelocity
                r4 = r1
            L55:
                int r5 = r1 * r4
                if (r5 <= 0) goto L97
                double r5 = (double) r2
                float r2 = r11.mDamping
                double r7 = (double) r2
                int r0 = r0 + 1
                double r9 = (double) r0
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
                if (r6 >= 0) goto L93
                com.youku.cmsui.YKSmartRefreshLayout r0 = com.youku.cmsui.YKSmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                boolean r2 = r1.isOpening
                if (r2 == 0) goto L92
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto L8b
                int r5 = r0.mHeaderHeight
                if (r4 > r5) goto L92
            L8b:
                if (r1 == r2) goto L97
                int r0 = r0.mFooterHeight
                int r0 = -r0
                if (r4 >= r0) goto L97
            L92:
                return r3
            L93:
                float r4 = (float) r4
                float r4 = r4 + r5
                int r4 = (int) r4
                goto L55
            L97:
                com.youku.cmsui.YKSmartRefreshLayout r0 = com.youku.cmsui.YKSmartRefreshLayout.this
                int r1 = r11.mFrameDelay
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.cmsui.YKSmartRefreshLayout.FlingRunnable.start():java.lang.Runnable");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class MyScrollBoundaryDecider extends m72 {
        MyScrollBoundaryDecider() {
        }

        @Override // tb.m72, com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider
        public boolean canLoadMore(View view) {
            return ScrollBoundaryUtil.canLoadMore(view, this.mActionEvent, this.mEnableLoadMoreWhenContentNotFull);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class RefreshKernelImpl implements RefreshKernel {
        public RefreshKernelImpl() {
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public ValueAnimator animSpinner(int i) {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            return yKSmartRefreshLayout.animSpinner(i, 0, yKSmartRefreshLayout.mReboundInterpolator, yKSmartRefreshLayout.mReboundDuration);
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel finishTwoLevel() {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            if (yKSmartRefreshLayout.mState == RefreshState.TwoLevel) {
                yKSmartRefreshLayout.mKernel.setState(RefreshState.TwoLevelFinish);
                if (YKSmartRefreshLayout.this.mSpinner == 0) {
                    moveSpinner(0, false);
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                } else {
                    animSpinner(0).setDuration(YKSmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshContent getRefreshContent() {
            return YKSmartRefreshLayout.this.mRefreshContent;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshLayout getRefreshLayout() {
            return YKSmartRefreshLayout.this;
        }

        /* JADX WARN: Removed duplicated region for block: B:116:0x01a4  */
        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.scwang.smartrefresh.layout.api.RefreshKernel moveSpinner(int r19, boolean r20) {
            /*
                Method dump skipped, instructions count: 738
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.cmsui.YKSmartRefreshLayout.RefreshKernelImpl.moveSpinner(int, boolean):com.scwang.smartrefresh.layout.api.RefreshKernel");
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestDefaultTranslationContentFor(@NonNull RefreshInternal refreshInternal, boolean z) {
            RefreshInternal refreshInternal2 = YKSmartRefreshLayout.this.mRefreshHeader;
            if (refreshInternal2 != null && refreshInternal2.getView() == refreshInternal.getView()) {
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                if (!yKSmartRefreshLayout.mManualHeaderTranslationContent) {
                    yKSmartRefreshLayout.mManualHeaderTranslationContent = true;
                    yKSmartRefreshLayout.mEnableHeaderTranslationContent = z;
                }
            } else {
                RefreshInternal refreshInternal3 = YKSmartRefreshLayout.this.mRefreshFooter;
                if (refreshInternal3 != null && refreshInternal3.getView() == refreshInternal.getView()) {
                    YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                    if (!yKSmartRefreshLayout2.mManualFooterTranslationContent) {
                        yKSmartRefreshLayout2.mManualFooterTranslationContent = true;
                        yKSmartRefreshLayout2.mEnableFooterTranslationContent = z;
                    }
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestDrawBackgroundFor(RefreshInternal refreshInternal, int i) {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            if (yKSmartRefreshLayout.mPaint == null && i != 0) {
                yKSmartRefreshLayout.mPaint = new Paint();
            }
            RefreshInternal refreshInternal2 = YKSmartRefreshLayout.this.mRefreshHeader;
            if (refreshInternal2 != null && refreshInternal2.getView() == refreshInternal.getView()) {
                YKSmartRefreshLayout.this.mHeaderBackgroundColor = i;
            } else {
                RefreshInternal refreshInternal3 = YKSmartRefreshLayout.this.mRefreshFooter;
                if (refreshInternal3 != null && refreshInternal3.getView() == refreshInternal.getView()) {
                    YKSmartRefreshLayout.this.mFooterBackgroundColor = i;
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestFloorDuration(int i) {
            YKSmartRefreshLayout.this.mFloorDuration = i;
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestNeedTouchEventFor(@NonNull RefreshInternal refreshInternal, boolean z) {
            RefreshInternal refreshInternal2 = YKSmartRefreshLayout.this.mRefreshHeader;
            if (refreshInternal2 != null && refreshInternal2.getView() == refreshInternal.getView()) {
                YKSmartRefreshLayout.this.mHeaderNeedTouchEventWhenRefreshing = z;
            } else {
                RefreshInternal refreshInternal3 = YKSmartRefreshLayout.this.mRefreshFooter;
                if (refreshInternal3 != null && refreshInternal3.getView() == refreshInternal.getView()) {
                    YKSmartRefreshLayout.this.mFooterNeedTouchEventWhenLoading = z;
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestRemeasureHeightFor(@NonNull RefreshInternal refreshInternal) {
            RefreshInternal refreshInternal2 = YKSmartRefreshLayout.this.mRefreshHeader;
            if (refreshInternal2 != null && refreshInternal2.getView() == refreshInternal.getView()) {
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                l80 l80Var = yKSmartRefreshLayout.mHeaderHeightStatus;
                if (l80Var.b) {
                    yKSmartRefreshLayout.mHeaderHeightStatus = l80Var.c();
                }
            } else {
                RefreshInternal refreshInternal3 = YKSmartRefreshLayout.this.mRefreshFooter;
                if (refreshInternal3 != null && refreshInternal3.getView() == refreshInternal.getView()) {
                    YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                    l80 l80Var2 = yKSmartRefreshLayout2.mFooterHeightStatus;
                    if (l80Var2.b) {
                        yKSmartRefreshLayout2.mFooterHeightStatus = l80Var2.c();
                    }
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel setState(@NonNull RefreshState refreshState) {
            Log.d("RefreshKernelImpl", "setState " + refreshState);
            switch (AnonymousClass13.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState.ordinal()]) {
                case 1:
                    YKSmartRefreshLayout.this.resetStatus();
                    return null;
                case 2:
                    YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                    if (!yKSmartRefreshLayout.mState.isOpening && yKSmartRefreshLayout.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownToRefresh);
                        return null;
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    if (YKSmartRefreshLayout.this.isEnableLoadMore()) {
                        YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                        RefreshState refreshState2 = yKSmartRefreshLayout2.mState;
                        if (!refreshState2.isOpening && !refreshState2.isFinishing && (!yKSmartRefreshLayout2.mFooterNoMoreData || !yKSmartRefreshLayout2.mEnableFooterFollowWhenLoadFinished)) {
                            yKSmartRefreshLayout2.notifyStateChanged(RefreshState.PullUpToLoad);
                            return null;
                        }
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                    if (!yKSmartRefreshLayout3.mState.isOpening && yKSmartRefreshLayout3.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                        YKSmartRefreshLayout.this.resetStatus();
                        return null;
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    return null;
                case 5:
                    if (YKSmartRefreshLayout.this.isEnableLoadMore()) {
                        YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
                        if (!yKSmartRefreshLayout4.mState.isOpening && (!yKSmartRefreshLayout4.mFooterNoMoreData || !yKSmartRefreshLayout4.mEnableFooterFollowWhenLoadFinished)) {
                            yKSmartRefreshLayout4.notifyStateChanged(RefreshState.PullUpCanceled);
                            YKSmartRefreshLayout.this.resetStatus();
                            return null;
                        }
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    return null;
                case 6:
                    YKSmartRefreshLayout yKSmartRefreshLayout5 = YKSmartRefreshLayout.this;
                    if (!yKSmartRefreshLayout5.mState.isOpening && yKSmartRefreshLayout5.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToRefresh);
                        return null;
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    if (YKSmartRefreshLayout.this.isEnableLoadMore()) {
                        YKSmartRefreshLayout yKSmartRefreshLayout6 = YKSmartRefreshLayout.this;
                        RefreshState refreshState3 = yKSmartRefreshLayout6.mState;
                        if (!refreshState3.isOpening && !refreshState3.isFinishing && (!yKSmartRefreshLayout6.mFooterNoMoreData || !yKSmartRefreshLayout6.mEnableFooterFollowWhenLoadFinished)) {
                            yKSmartRefreshLayout6.notifyStateChanged(RefreshState.ReleaseToLoad);
                            return null;
                        }
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    YKSmartRefreshLayout yKSmartRefreshLayout7 = YKSmartRefreshLayout.this;
                    if (!yKSmartRefreshLayout7.mState.isOpening && yKSmartRefreshLayout7.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    YKSmartRefreshLayout yKSmartRefreshLayout8 = YKSmartRefreshLayout.this;
                    if (!yKSmartRefreshLayout8.mState.isOpening && yKSmartRefreshLayout8.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshReleased);
                        return null;
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    YKSmartRefreshLayout yKSmartRefreshLayout9 = YKSmartRefreshLayout.this;
                    if (!yKSmartRefreshLayout9.mState.isOpening && yKSmartRefreshLayout9.isEnableLoadMore()) {
                        YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadReleased);
                        return null;
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    return null;
                case 11:
                    YKSmartRefreshLayout.this.setStateRefreshing();
                    return null;
                case 12:
                    YKSmartRefreshLayout.this.setStateLoading();
                    return null;
                case 13:
                    YKSmartRefreshLayout yKSmartRefreshLayout10 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout10.mState == RefreshState.Refreshing) {
                        yKSmartRefreshLayout10.notifyStateChanged(RefreshState.RefreshFinish);
                        return null;
                    }
                    return null;
                case 14:
                    YKSmartRefreshLayout yKSmartRefreshLayout11 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout11.mState == RefreshState.Loading) {
                        yKSmartRefreshLayout11.notifyStateChanged(RefreshState.LoadFinish);
                        return null;
                    }
                    return null;
                case 15:
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelReleased);
                    return null;
                case 16:
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelFinish);
                    return null;
                case 17:
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevel);
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel startTwoLevel(boolean z) {
            if (z) {
                AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.youku.cmsui.YKSmartRefreshLayout.RefreshKernelImpl.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        YKSmartRefreshLayout.this.mKernel.setState(RefreshState.TwoLevel);
                        YKSmartRefreshLayout.this.postDelayed(new Runnable() { // from class: com.youku.cmsui.YKSmartRefreshLayout.RefreshKernelImpl.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                RefreshKernelImpl.this.finishTwoLevel();
                            }
                        }, YKSmartRefreshLayout.this.mFloorDuration);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        YKSmartRefreshLayout.this.mKernel.setState(RefreshState.TwoLevel);
                        YKSmartRefreshLayout.this.postDelayed(new Runnable() { // from class: com.youku.cmsui.YKSmartRefreshLayout.RefreshKernelImpl.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                RefreshKernelImpl.this.finishTwoLevel();
                            }
                        }, YKSmartRefreshLayout.this.mFloorDuration);
                    }
                };
                ValueAnimator animSpinner = animSpinner(YKSmartRefreshLayout.this.getMeasuredHeight());
                if (animSpinner != null) {
                    YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                    if (animSpinner == yKSmartRefreshLayout.reboundAnimator) {
                        animSpinner.setDuration(yKSmartRefreshLayout.mFloorDuration);
                        animSpinner.addListener(animatorListenerAdapter);
                    }
                }
                animatorListenerAdapter.onAnimationEnd(null);
            } else if (animSpinner(0) == null) {
                YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
            }
            return this;
        }
    }

    public YKSmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
        sFooterCreator = defaultRefreshFooterCreator;
        sManualFooterCreator = true;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
        sHeaderCreator = defaultRefreshHeaderCreator;
    }

    public ValueAnimator animSpinner(int i, int i2, Interpolator interpolator, int i3) {
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
            this.reboundAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.youku.cmsui.YKSmartRefreshLayout.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                    yKSmartRefreshLayout.reboundAnimator = null;
                    if (yKSmartRefreshLayout.mSpinner == 0) {
                        RefreshState refreshState = yKSmartRefreshLayout.mState;
                        RefreshState refreshState2 = RefreshState.None;
                        if (refreshState == refreshState2 || refreshState.isOpening) {
                            return;
                        }
                        yKSmartRefreshLayout.notifyStateChanged(refreshState2);
                        return;
                    }
                    RefreshState refreshState3 = yKSmartRefreshLayout.mState;
                    if (refreshState3 != yKSmartRefreshLayout.mViceState) {
                        yKSmartRefreshLayout.setViceState(refreshState3);
                    }
                }
            });
            this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.cmsui.YKSmartRefreshLayout.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    YKSmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator2.getAnimatedValue()).intValue(), false);
                }
            });
            this.reboundAnimator.setStartDelay(i2);
            this.reboundAnimator.start();
            return this.reboundAnimator;
        }
        return null;
    }

    protected void animSpinnerBounce(float f) {
        RefreshState refreshState;
        if (this.reboundAnimator == null) {
            if (f > 0.0f && ((refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                this.animationRunnable = new BounceRunnable(f, this.mHeaderHeight);
            } else if (f < 0.0f && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenLoadFinished && this.mFooterNoMoreData && isEnableLoadMore()) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableLoadMore() && this.mState != RefreshState.Refreshing)))) {
                this.animationRunnable = new BounceRunnable(f, -this.mFooterHeight);
            } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
                this.animationRunnable = new BounceRunnable(f, 0);
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMore() {
        int i = this.mReboundDuration;
        int i2 = this.mFooterHeight;
        float f = i2 * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoLoadMore(0, i, f / i2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefresh() {
        int i = this.mHandler == null ? 400 : 0;
        int i2 = this.mReboundDuration;
        int i3 = this.mHeaderHeight;
        float f = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * i3 * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f / i3);
    }

    public boolean autoRefreshNoLoad(int i) {
        int i2 = this.mHeaderHeight;
        float f = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * i2 * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoRefreshNoLoad(0, i, f / i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        View scrollableView = this.mRefreshContent.getScrollableView();
        return i < 0 ? this.mEnableOverScrollDrag || isEnableRefresh() || com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil.canScrollUp(scrollableView) : i <= 0 || this.mEnableOverScrollDrag || isEnableLoadMore() || com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil.canScrollDown(scrollableView);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void computeScroll() {
        float currY;
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY < 0 && ((this.mEnableOverScrollDrag || isEnableRefresh()) && this.mRefreshContent.canRefresh())) || (finalY > 0 && ((this.mEnableOverScrollDrag || isEnableLoadMore()) && this.mRefreshContent.canLoadMore()))) {
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

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0147, code lost:
        if (r6 != 3) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        if (r4.isFinishing == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ce, code lost:
        if (r4.isHeader == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00dc, code lost:
        if (r4.isFinishing == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e0, code lost:
        if (r4.isFooter == false) goto L74;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 894
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.cmsui.YKSmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        Paint paint;
        Paint paint2;
        RefreshContent refreshContent = this.mRefreshContent;
        View view2 = refreshContent != null ? refreshContent.getView() : null;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null && refreshInternal.getView() == view) {
            if (!isEnableRefresh() || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i = this.mHeaderBackgroundColor;
                if (i != 0 && (paint2 = this.mPaint) != null) {
                    paint2.setColor(i);
                    if (this.mRefreshHeader.getSpinnerStyle() == df2.Scale) {
                        max = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == df2.Translate) {
                        max = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect(view.getLeft(), view.getTop(), view.getRight(), max, this.mPaint);
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
            if (!isEnableLoadMore() || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i2 = this.mFooterBackgroundColor;
                if (i2 != 0 && (paint = this.mPaint) != null) {
                    paint.setColor(i2);
                    if (this.mRefreshFooter.getSpinnerStyle() == df2.Scale) {
                        min = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == df2.Translate) {
                        min = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect(view.getLeft(), min, view.getRight(), view.getBottom(), this.mPaint);
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
    public YKSmartRefreshLayout getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedParent.getNestedScrollAxes();
    }

    public Interpolator getReboundInterpolator() {
        return this.mReboundInterpolator;
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
    public RefreshState getState() {
        return this.mState;
    }

    public YKSmartRefreshLayout hideLoadingMoreFooterWhenNoMoreData(boolean z) {
        if (this.mRefreshFooter != null && this.mRefreshContent != null) {
            notifyStateChanged(RefreshState.LoadFinish);
            boolean z2 = true;
            int onFinish = this.mRefreshFooter.onFinish(this, true);
            OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
            if (onMultiPurposeListener != null) {
                RefreshInternal refreshInternal = this.mRefreshFooter;
                if (refreshInternal instanceof RefreshFooter) {
                    onMultiPurposeListener.onFooterFinish((RefreshFooter) refreshInternal, true);
                }
            }
            if (onFinish < Integer.MAX_VALUE) {
                z2 = (this.mEnableFooterFollowWhenLoadFinished && this.mSpinner < 0 && this.mRefreshContent.canLoadMore()) ? false : false;
                int i = this.mSpinner;
                int max = i - (z2 ? Math.max(i, -this.mFooterHeight) : 0);
                if (this.mIsBeingDragged) {
                    this.mTouchSpinner = this.mSpinner - max;
                    this.mTouchY = this.mLastTouchY;
                    this.mIsBeingDragged = false;
                    long currentTimeMillis = System.currentTimeMillis();
                    float f = max;
                    super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, this.mLastTouchX, this.mTouchY + f + (this.mTouchSlop * 2), 0));
                    super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, this.mLastTouchX, this.mTouchY + f, 0));
                } else if (this.mTotalUnconsumed != 0) {
                    this.mDragDirection = tryDragDirectionToH();
                    this.mTotalUnconsumed = 0;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis2, currentTimeMillis2, 3, this.mLastTouchX, this.mTouchY + max, 0));
                }
                this.mRefreshContent.getScrollableView().scrollBy(0, z ? this.mSpinner : -this.mSpinner);
                this.mKernel.moveSpinner(0, false);
                resetStatus();
            }
        }
        return this;
    }

    protected boolean interceptByAnimator(int i) {
        if (i == 0) {
            this.animationRunnable = null;
            if (this.reboundAnimator != null) {
                RefreshState refreshState = this.mState;
                if (refreshState.isFinishing) {
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
        }
        return this.reboundAnimator != null;
    }

    public boolean isAutoRefresh() {
        return this.isAutoRefresh;
    }

    public boolean isDispatchEventWhenStatueChanged() {
        return this.mInterceptEventWhenStatueChanged;
    }

    public boolean isEnableLoadMore() {
        return this.mEnableLoadMore && !this.mEnablePureScrollMode;
    }

    public boolean isEnableRefresh() {
        return this.mEnableRefresh && !this.mEnablePureScrollMode;
    }

    public boolean isIdle() {
        return this.mState == RefreshState.None;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mNestedChild.isNestedScrollingEnabled();
    }

    public boolean isSupportDragHDirection() {
        return this.mSupportDragHDirection;
    }

    public boolean isSupportNestedHScroll() {
        return this.mSupportNestedHScroll;
    }

    protected void moveSpinnerInfinitely(float f) {
        RefreshState refreshState;
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == RefreshState.TwoLevel && f > 0.0f) {
            this.mKernel.moveSpinner(Math.min((int) f, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f >= 0.0f) {
            if (this.mAblePullingDownWhenRefreshing) {
                int i = this.mHeaderHeight;
                if (f < i) {
                    this.mKernel.moveSpinner((int) f, true);
                } else {
                    double d = (this.mHeaderMaxDragRate - 1.0f) * i;
                    int max = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                    int i2 = this.mHeaderHeight;
                    double d2 = max - i2;
                    double max2 = Math.max(0.0f, (f - i2) * this.mDragRate);
                    double d3 = -max2;
                    if (d2 == 0.0d) {
                        d2 = 1.0d;
                    }
                    this.mKernel.moveSpinner(((int) Math.min(d * (1.0d - Math.pow(100.0d, d3 / d2)), max2)) + this.mHeaderHeight, true);
                }
            }
        } else if (f < 0.0f && (refreshState2 == RefreshState.Loading || ((this.mEnableFooterFollowWhenLoadFinished && this.mFooterNoMoreData && isEnableLoadMore()) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableLoadMore())))) {
            int i3 = this.mFooterHeight;
            if (f > (-i3)) {
                this.mKernel.moveSpinner((int) f, true);
            } else {
                double d4 = (this.mFooterMaxDragRate - 1.0f) * i3;
                int max3 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i4 = this.mFooterHeight;
                double d5 = max3 - i4;
                double d6 = -Math.min(0.0f, (i4 + f) * this.mDragRate);
                double d7 = -d6;
                if (d5 == 0.0d) {
                    d5 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) (-Math.min(d4 * (1.0d - Math.pow(100.0d, d7 / d5)), d6))) - this.mFooterHeight, true);
            }
        } else if (f >= 0.0f) {
            double d8 = this.mHeaderMaxDragRate * this.mHeaderHeight;
            double max4 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double max5 = Math.max(0.0f, this.mDragRate * f);
            double d9 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.mKernel.moveSpinner((int) Math.min(d8 * (1.0d - Math.pow(100.0d, d9 / max4)), max5), true);
        } else {
            double d10 = this.mFooterMaxDragRate * this.mFooterHeight;
            double max6 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double d11 = -Math.min(0.0f, this.mDragRate * f);
            double d12 = -d11;
            if (max6 == 0.0d) {
                max6 = 1.0d;
            }
            this.mKernel.moveSpinner((int) (-Math.min(d10 * (1.0d - Math.pow(100.0d, d12 / max6)), d11)), true);
        }
        if (!this.mEnableAutoLoadMore || this.mFooterNoMoreData || !isEnableLoadMore() || f >= 0.0f || (refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish) {
            return;
        }
        setStateDirectLoading();
        if (this.mDisableContentWhenLoading) {
            this.animationRunnable = null;
            this.mKernel.animSpinner(-this.mFooterHeight);
        }
    }

    public void notifyStateChanged(RefreshState refreshState) {
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
            if (this.mState == RefreshState.None && this.isAutoRefresh) {
                this.isAutoRefresh = false;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RefreshInternal refreshInternal;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            List<DelayedRunnable> list = this.mListDelayedRunnable;
            if (list != null) {
                Iterator<DelayedRunnable> it = list.iterator();
                while (it.hasNext()) {
                    Runnable runnable = (DelayedRunnable) it.next();
                    this.mHandler.postDelayed(runnable, ((DelayedRunnable) runnable).delayMillis);
                }
                this.mListDelayedRunnable.clear();
                this.mListDelayedRunnable = null;
            }
            if (this.mRefreshHeader == null) {
                setRefreshHeader(sHeaderCreator.createRefreshHeader(getContext(), this));
            }
            if (this.mRefreshFooter == null) {
                setRefreshFooter(sFooterCreator.createRefreshFooter(getContext(), this));
            } else {
                this.mEnableLoadMore = this.mEnableLoadMore || !this.mManualLoadMore;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RefreshInternal refreshInternal2 = this.mRefreshHeader;
                    if ((refreshInternal2 == null || childAt != refreshInternal2.getView()) && ((refreshInternal = this.mRefreshFooter) == null || childAt != refreshInternal.getView())) {
                        this.mRefreshContent = new RefreshContentWrapper(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int dp2px = DensityUtil.dp2px(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, -1, -1);
                RefreshContentWrapper refreshContentWrapper = new RefreshContentWrapper(textView);
                this.mRefreshContent = refreshContentWrapper;
                refreshContentWrapper.getView().setPadding(dp2px, dp2px, dp2px, dp2px);
            }
            int i2 = this.mFixedHeaderViewId;
            View findViewById = i2 > 0 ? findViewById(i2) : null;
            int i3 = this.mFixedFooterViewId;
            View findViewById2 = i3 > 0 ? findViewById(i3) : null;
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, findViewById2);
            if (this.mSpinner != 0) {
                notifyStateChanged(RefreshState.None);
                RefreshContent refreshContent = this.mRefreshContent;
                this.mSpinner = 0;
                refreshContent.moveSpinner(0);
            }
            if (!this.mManualNestedScrolling && !isNestedScrollingEnabled()) {
                post(new Runnable() { // from class: com.youku.cmsui.YKSmartRefreshLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        for (ViewParent parent = YKSmartRefreshLayout.this.getParent(); parent != null; parent = parent.getParent()) {
                            if (parent instanceof NestedScrollingParent) {
                                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                                if (((NestedScrollingParent) parent).onStartNestedScroll(yKSmartRefreshLayout, yKSmartRefreshLayout, 2)) {
                                    YKSmartRefreshLayout.this.setNestedScrollingEnabled(true);
                                    YKSmartRefreshLayout.this.mManualNestedScrolling = false;
                                    return;
                                }
                            }
                        }
                    }
                });
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
        if (refreshInternal5 != null && refreshInternal5.getSpinnerStyle() != df2.FixedBehind) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        RefreshInternal refreshInternal6 = this.mRefreshFooter;
        if (refreshInternal6 == null || refreshInternal6.getSpinnerStyle() == df2.FixedBehind) {
            return;
        }
        super.bringChildToFront(this.mRefreshFooter.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mKernel.moveSpinner(0, true);
        notifyStateChanged(RefreshState.None);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        this.mManualLoadMore = true;
        this.mManualNestedScrolling = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0052  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onFinishInflate() {
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
            boolean r10 = com.youku.cmsui.YKSmartUtil.isContentView(r9)
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
            com.youku.cmsui.RefreshContentWrapper r4 = new com.youku.cmsui.RefreshContentWrapper
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
        throw new UnsupportedOperationException("Method not decompiled: com.youku.cmsui.YKSmartRefreshLayout.onFinishInflate():void");
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
            RefreshContent refreshContent = this.mRefreshContent;
            boolean z2 = true;
            if (refreshContent != null && refreshContent.getView() == childAt) {
                boolean z3 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefresh() && this.mRefreshHeader != null;
                View view = this.mRefreshContent.getView();
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int max = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop + Math.max(this.mRefreshHeader.getView().getBottom(), this.mHeaderInsetStart);
                int measuredWidth = view.getMeasuredWidth() + i7;
                int measuredHeight = (view.getMeasuredHeight() + max) - Math.max(this.mRefreshHeader.getView().getBottom(), this.mHeaderInsetStart);
                if (z3 && (this.mEnableHeaderTranslationContent || this.mRefreshHeader.getSpinnerStyle() == df2.FixedBehind)) {
                    int i8 = this.mHeaderHeight;
                    max += i8;
                    measuredHeight += i8;
                }
                view.layout(i7, max, measuredWidth, measuredHeight);
            }
            RefreshInternal refreshInternal = this.mRefreshHeader;
            if (refreshInternal != null && refreshInternal.getView() == childAt) {
                boolean z4 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefresh();
                View view2 = this.mRefreshHeader.getView();
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                int i9 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                int i10 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                int measuredWidth2 = view2.getMeasuredWidth() + i9;
                int measuredHeight2 = view2.getMeasuredHeight() + i10;
                if (!z4 && this.mRefreshHeader.getSpinnerStyle() == df2.Translate) {
                    int i11 = i10 - measuredHeight2;
                    measuredHeight2 = this.mHeaderInsetStart;
                    i10 = i11 + measuredHeight2;
                }
                view2.layout(i9, i10, measuredWidth2, measuredHeight2);
            }
            RefreshInternal refreshInternal2 = this.mRefreshFooter;
            if (refreshInternal2 != null && refreshInternal2.getView() == childAt) {
                z2 = (isInEditMode() && this.mEnablePreviewInEditMode && isEnableLoadMore()) ? false : false;
                View view3 = this.mRefreshFooter.getView();
                LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                df2 spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                int i12 = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
                int measuredHeight3 = (((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                if (!z2 && spinnerStyle != df2.FixedFront && spinnerStyle != df2.FixedBehind) {
                    if (spinnerStyle == df2.Scale && this.mSpinner < 0) {
                        i5 = Math.max(isEnableLoadMore() ? -this.mSpinner : 0, 0);
                    }
                    view3.layout(i12, measuredHeight3, view3.getMeasuredWidth() + i12, view3.getMeasuredHeight() + measuredHeight3);
                } else {
                    i5 = this.mFooterHeight;
                }
                measuredHeight3 -= i5;
                view3.layout(i12, measuredHeight3, view3.getMeasuredWidth() + i12, view3.getMeasuredHeight() + measuredHeight3);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        RefreshInternal refreshInternal;
        RefreshInternal refreshInternal2;
        int i3;
        int i4;
        boolean z = isInEditMode() && this.mEnablePreviewInEditMode;
        int childCount = super.getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            RefreshInternal refreshInternal3 = this.mRefreshHeader;
            if (refreshInternal3 != null && refreshInternal3.getView() == childAt) {
                View view = this.mRefreshHeader.getView();
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width);
                if (this.mHeaderHeightStatus.gteReplaceWith(l80.XmlLayoutUnNotify)) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                } else if (this.mRefreshHeader.getSpinnerStyle() == df2.MatchLayout) {
                    if (this.mHeaderHeightStatus.b) {
                        i4 = 0;
                    } else {
                        super.measureChild(view, childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), Integer.MIN_VALUE));
                        i4 = view.getMeasuredHeight();
                    }
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                    if (i4 > 0 && i4 != view.getMeasuredHeight()) {
                        this.mHeaderHeight = i4 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    }
                } else {
                    int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    if (i7 > 0) {
                        l80 l80Var = this.mHeaderHeightStatus;
                        l80 l80Var2 = l80.XmlExactUnNotify;
                        if (l80Var.a(l80Var2)) {
                            this.mHeaderHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            this.mHeaderHeightStatus = l80Var2;
                        }
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams).height, 1073741824));
                    } else if (i7 == -2) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight = view.getMeasuredHeight();
                        if (measuredHeight > 0) {
                            l80 l80Var3 = this.mHeaderHeightStatus;
                            l80 l80Var4 = l80.XmlWrapUnNotify;
                            if (l80Var3.a(l80Var4)) {
                                this.mHeaderHeightStatus = l80Var4;
                                this.mHeaderHeight = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            }
                        }
                        if (measuredHeight <= 0) {
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                        }
                    } else if (i7 == -1) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                    } else {
                        view.measure(childMeasureSpec, i2);
                    }
                }
                if (this.mRefreshHeader.getSpinnerStyle() == df2.Scale && !z) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((Math.max(0, isEnableRefresh() ? this.mSpinner : 0) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                }
                l80 l80Var5 = this.mHeaderHeightStatus;
                if (!l80Var5.b) {
                    this.mHeaderHeightStatus = l80Var5.b();
                    RefreshInternal refreshInternal4 = this.mRefreshHeader;
                    RefreshKernel refreshKernel = this.mKernel;
                    int i8 = this.mHeaderHeight;
                    refreshInternal4.onInitialized(refreshKernel, i8, (int) (this.mHeaderMaxDragRate * i8));
                }
                if (z && isEnableRefresh()) {
                    i5 += view.getMeasuredHeight();
                }
            }
            RefreshInternal refreshInternal5 = this.mRefreshFooter;
            if (refreshInternal5 != null && refreshInternal5.getView() == childAt) {
                View view2 = this.mRefreshFooter.getView();
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).width);
                if (this.mFooterHeightStatus.gteReplaceWith(l80.XmlLayoutUnNotify)) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), 1073741824));
                } else if (this.mRefreshFooter.getSpinnerStyle() == df2.MatchLayout) {
                    if (this.mFooterHeightStatus.b) {
                        i3 = 0;
                    } else {
                        super.measureChild(view2, childMeasureSpec2, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, Integer.MIN_VALUE));
                        i3 = view2.getMeasuredHeight();
                    }
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 1073741824));
                    if (i3 > 0 && i3 != view2.getMeasuredHeight()) {
                        this.mHeaderHeight = i3 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                    }
                } else {
                    int i9 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                    if (i9 > 0) {
                        l80 l80Var6 = this.mFooterHeightStatus;
                        l80 l80Var7 = l80.XmlExactUnNotify;
                        if (l80Var6.a(l80Var7)) {
                            this.mFooterHeight = ((ViewGroup.MarginLayoutParams) layoutParams2).height + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                            this.mFooterHeightStatus = l80Var7;
                        }
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams2).height, 1073741824));
                    } else if (i9 == -2) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight2 = view2.getMeasuredHeight();
                        if (measuredHeight2 > 0) {
                            l80 l80Var8 = this.mFooterHeightStatus;
                            l80 l80Var9 = l80.XmlWrapUnNotify;
                            if (l80Var8.a(l80Var9)) {
                                this.mFooterHeightStatus = l80Var9;
                                this.mFooterHeight = view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                            }
                        }
                        if (measuredHeight2 <= 0) {
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), 1073741824));
                        }
                    } else if (i9 == -1) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), 1073741824));
                    } else {
                        view2.measure(childMeasureSpec2, i2);
                    }
                }
                if (this.mRefreshFooter.getSpinnerStyle() == df2.Scale && !z) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((Math.max(0, this.mEnableLoadMore ? -this.mSpinner : 0) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), 1073741824));
                }
                l80 l80Var10 = this.mFooterHeightStatus;
                if (!l80Var10.b) {
                    this.mFooterHeightStatus = l80Var10.b();
                    RefreshInternal refreshInternal6 = this.mRefreshFooter;
                    RefreshKernel refreshKernel2 = this.mKernel;
                    int i10 = this.mFooterHeight;
                    refreshInternal6.onInitialized(refreshKernel2, i10, (int) (this.mFooterMaxDragRate * i10));
                }
                if (z && isEnableLoadMore()) {
                    i5 += view2.getMeasuredHeight();
                }
            }
            RefreshContent refreshContent = this.mRefreshContent;
            if (refreshContent != null && refreshContent.getView() == childAt) {
                View view3 = this.mRefreshContent.getView();
                LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                view3.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + ((z && isEnableRefresh() && (refreshInternal2 = this.mRefreshHeader) != null && (this.mEnableHeaderTranslationContent || refreshInternal2.getSpinnerStyle() == df2.FixedBehind)) ? this.mHeaderHeight : 0) + ((z && isEnableLoadMore() && (refreshInternal = this.mRefreshFooter) != null && (this.mEnableFooterTranslationContent || refreshInternal.getSpinnerStyle() == df2.FixedBehind)) ? this.mFooterHeight : 0), ((ViewGroup.MarginLayoutParams) layoutParams3).height));
                i5 += view3.getMeasuredHeight();
            }
        }
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), View.resolveSize(i5, i2));
        this.mLastTouchX = getMeasuredWidth() / 2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z) {
        return this.mNestedChild.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        return (this.mFooterLocked && f2 > 0.0f) || startFlingIfNeed(Float.valueOf(-f2)) || this.mNestedChild.dispatchNestedPreFling(f, f2);
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
            RefreshState refreshState = this.mViceState;
            if (refreshState.isOpening || refreshState == RefreshState.None) {
                if (this.mSpinner > 0) {
                    this.mKernel.setState(RefreshState.PullDownToRefresh);
                } else {
                    this.mKernel.setState(RefreshState.PullUpToLoad);
                }
            }
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
        this.mNestedChild.dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if (i5 != 0) {
            if (this.mEnableOverScrollDrag || ((i5 < 0 && isEnableRefresh()) || (i5 > 0 && isEnableLoadMore()))) {
                if (this.mViceState == RefreshState.None) {
                    this.mKernel.setState(i5 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                }
                int i6 = this.mTotalUnconsumed - i5;
                this.mTotalUnconsumed = i6;
                moveSpinnerInfinitely(i6);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        this.mNestedParent.onNestedScrollAccepted(view, view2, i);
        this.mNestedChild.startNestedScroll(i & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        return (isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0) && (this.mEnableOverScrollDrag || isEnableRefresh() || isEnableLoadMore());
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
            if (this.mVelocityTracker.getYVelocity() > -1000.0f && this.mSpinner > getMeasuredHeight() / 2) {
                ValueAnimator animSpinner = this.mKernel.animSpinner(getMeasuredHeight());
                if (animSpinner != null) {
                    animSpinner.setDuration(this.mFloorDuration);
                }
            } else if (this.mIsBeingDragged) {
                this.mKernel.finishTwoLevel();
            }
        } else if (refreshState != RefreshState.Loading && (!this.mEnableFooterFollowWhenLoadFinished || !this.mFooterNoMoreData || this.mSpinner >= 0 || !isEnableLoadMore())) {
            RefreshState refreshState2 = this.mState;
            if (refreshState2 == RefreshState.Refreshing) {
                if (getRefreshHeader() instanceof YKPageRefreshHeader) {
                    if (this.mSpinner > ((YKPageRefreshHeader) getRefreshHeader()).mRefreshingHeight) {
                        this.mKernel.animSpinner(((YKPageRefreshHeader) getRefreshHeader()).mRefreshingHeight);
                        return;
                    } else if (this.mSpinner < 0) {
                        this.mKernel.animSpinner(0);
                        return;
                    } else {
                        return;
                    }
                }
                int i = this.mSpinner;
                int i2 = this.mHeaderHeight;
                if (i > i2) {
                    this.mKernel.animSpinner(i2);
                } else if (i < 0) {
                    this.mKernel.animSpinner(0);
                }
            } else if (refreshState2 == RefreshState.PullDownToRefresh) {
                this.mKernel.setState(RefreshState.PullDownCanceled);
            } else if (refreshState2 == RefreshState.PullUpToLoad) {
                this.mKernel.setState(RefreshState.PullUpCanceled);
            } else if (refreshState2 == RefreshState.ReleaseToRefresh) {
                setStateRefreshing();
            } else if (refreshState2 == RefreshState.ReleaseToLoad) {
                setStateLoading();
            } else if (refreshState2 == RefreshState.ReleaseToTwoLevel) {
                this.mKernel.setState(RefreshState.TwoLevelReleased);
            } else if (this.mSpinner != 0) {
                this.mKernel.animSpinner(0);
            }
        } else {
            int i3 = this.mSpinner;
            int i4 = this.mFooterHeight;
            if (i3 < (-i4)) {
                this.mKernel.animSpinner(-i4);
            } else if (i3 > 0) {
                this.mKernel.animSpinner(0);
            }
        }
    }

    @Override // android.view.View
    public boolean post(@NonNull Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler == null) {
            List<DelayedRunnable> list = this.mListDelayedRunnable;
            if (list == null) {
                list = new ArrayList<>();
            }
            this.mListDelayedRunnable = list;
            list.add(new DelayedRunnable(runnable, 0L));
            return false;
        }
        return handler.post(new DelayedRunnable(runnable, 0L));
    }

    @Override // android.view.View
    public boolean postDelayed(@NonNull Runnable runnable, long j) {
        if (j == 0) {
            new DelayedRunnable(runnable, 0L).run();
            return true;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            List<DelayedRunnable> list = this.mListDelayedRunnable;
            if (list == null) {
                list = new ArrayList<>();
            }
            this.mListDelayedRunnable = list;
            list.add(new DelayedRunnable(runnable, j));
            return false;
        }
        return handler.postDelayed(new DelayedRunnable(runnable, 0L), j);
    }

    protected void resetStatus() {
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2 && this.mSpinner == 0) {
            notifyStateChanged(refreshState2);
        }
        if (this.mSpinner != 0) {
            this.mKernel.animSpinner(0);
        }
    }

    public YKSmartRefreshLayout setAblePullingDownWhenRefreshing(boolean z) {
        this.mAblePullingDownWhenRefreshing = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableNestedScroll(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    public YKSmartRefreshLayout setInterceptEventWhenStatueChanged(boolean z) {
        this.mInterceptEventWhenStatueChanged = z;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mManualNestedScrolling = true;
        this.mNestedChild.setNestedScrollingEnabled(z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshContent(@NonNull View view) {
        return setRefreshContent(view, -1, -1);
    }

    protected void setStateDirectLoading() {
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(refreshState2);
            OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
            if (onLoadMoreListener != null) {
                onLoadMoreListener.onLoadMore(this);
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
            onMultiPurposeListener.onLoadMore(this);
            int i2 = this.mFooterHeight;
            this.mOnMultiPurposeListener.onFooterStartAnimator((RefreshFooter) this.mRefreshFooter, i2, (int) (this.mFooterMaxDragRate * i2));
        }
    }

    protected void setStateLoading() {
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.youku.cmsui.YKSmartRefreshLayout.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                YKSmartRefreshLayout.this.setStateDirectLoading();
            }
        };
        notifyStateChanged(RefreshState.LoadReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(-this.mFooterHeight);
        if (animSpinner != null) {
            animSpinner.addListener(animatorListenerAdapter);
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
            animatorListenerAdapter.onAnimationEnd(null);
        }
    }

    protected void setStateRefreshing() {
        ValueAnimator animSpinner;
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.youku.cmsui.YKSmartRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                YKSmartRefreshLayout.this.mLastOpenTime = System.currentTimeMillis();
                YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.Refreshing);
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                OnRefreshListener onRefreshListener = yKSmartRefreshLayout.mRefreshListener;
                if (onRefreshListener != null) {
                    onRefreshListener.onRefresh(yKSmartRefreshLayout);
                } else if (yKSmartRefreshLayout.mOnMultiPurposeListener == null) {
                    yKSmartRefreshLayout.finishRefresh(3000);
                }
                YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                RefreshInternal refreshInternal = yKSmartRefreshLayout2.mRefreshHeader;
                if (refreshInternal != null) {
                    int i = yKSmartRefreshLayout2.mHeaderHeight;
                    refreshInternal.onStartAnimator(yKSmartRefreshLayout2, i, (int) (yKSmartRefreshLayout2.mHeaderMaxDragRate * i));
                }
                YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                OnMultiPurposeListener onMultiPurposeListener = yKSmartRefreshLayout3.mOnMultiPurposeListener;
                if (onMultiPurposeListener == null || !(yKSmartRefreshLayout3.mRefreshHeader instanceof RefreshHeader)) {
                    return;
                }
                onMultiPurposeListener.onRefresh(yKSmartRefreshLayout3);
                YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
                int i2 = yKSmartRefreshLayout4.mHeaderHeight;
                yKSmartRefreshLayout4.mOnMultiPurposeListener.onHeaderStartAnimator((RefreshHeader) yKSmartRefreshLayout4.mRefreshHeader, i2, (int) (yKSmartRefreshLayout4.mHeaderMaxDragRate * i2));
            }
        };
        notifyStateChanged(RefreshState.RefreshReleased);
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal instanceof YKPageRefreshHeader) {
            animSpinner = this.mKernel.animSpinner(Math.min(this.mSpinner, Math.min(((YKPageRefreshHeader) refreshInternal).mRefreshingHeight, this.mHeaderHeight)));
        } else {
            animSpinner = this.mKernel.animSpinner(this.mHeaderHeight);
        }
        if (animSpinner != null) {
            animSpinner.addListener(animatorListenerAdapter);
        }
        RefreshInternal refreshInternal2 = this.mRefreshHeader;
        if (refreshInternal2 != null) {
            int i = this.mHeaderHeight;
            refreshInternal2.onReleased(this, i, (int) (this.mHeaderMaxDragRate * i));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal3 = this.mRefreshHeader;
            if (refreshInternal3 instanceof RefreshHeader) {
                int i2 = this.mHeaderHeight;
                onMultiPurposeListener.onHeaderReleased((RefreshHeader) refreshInternal3, i2, (int) (this.mHeaderMaxDragRate * i2));
            }
        }
        if (animSpinner == null) {
            animatorListenerAdapter.onAnimationEnd(null);
        }
    }

    public YKSmartRefreshLayout setSupportDragHDirection(boolean z) {
        this.mSupportDragHDirection = z;
        return this;
    }

    public YKSmartRefreshLayout setSupportNestedHScroll(boolean z) {
        this.mSupportNestedHScroll = z;
        return this;
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

    protected boolean startFlingIfNeed(Float f) {
        RefreshState refreshState;
        float yVelocity = f == null ? this.mVelocityTracker.getYVelocity() : f.floatValue();
        if (Math.abs(yVelocity) > this.mMinimumVelocity) {
            if ((yVelocity < 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableOverScrollDrag || isEnableLoadMore())) || ((this.mState == RefreshState.Loading && this.mSpinner >= 0) || (this.mEnableAutoLoadMore && isEnableLoadMore())))) || (yVelocity > 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableOverScrollDrag || isEnableRefresh())) || (this.mState == RefreshState.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-yVelocity), 0, 0, StandOutWindow.StandOutLayoutParams.AUTO_POSITION, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
            if (this.mSpinner * yVelocity < 0.0f && (refreshState = this.mState) != RefreshState.TwoLevel && refreshState != this.mViceState) {
                this.animationRunnable = new FlingRunnable(yVelocity).start();
                return true;
            }
        }
        return false;
    }

    public char tryDragDirectionToH() {
        if (this.mSupportDragHDirection) {
            return 'h';
        }
        return this.mDragDirection;
    }

    public YKSmartRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean autoRefreshNoLoad(int i, int i2, float f) {
        if (this.mState == RefreshState.None && isEnableRefresh()) {
            ValueAnimator valueAnimator = this.reboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            AnonymousClass11 anonymousClass11 = new AnonymousClass11(f, i2);
            if (i > 0) {
                this.reboundAnimator = new ValueAnimator();
                postDelayed(anonymousClass11, i);
            } else {
                anonymousClass11.run();
            }
            this.isAutoRefresh = true;
            return true;
        }
        return false;
    }

    public boolean autoLoadMore(int i, final int i2, final float f) {
        if (this.mState == RefreshState.None && isEnableLoadMore() && !this.mFooterNoMoreData) {
            ValueAnimator valueAnimator = this.reboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            Runnable runnable = new Runnable() { // from class: com.youku.cmsui.YKSmartRefreshLayout.12
                @Override // java.lang.Runnable
                public void run() {
                    YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                    yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(yKSmartRefreshLayout.mSpinner, -((int) (yKSmartRefreshLayout.mFooterHeight * f)));
                    YKSmartRefreshLayout.this.reboundAnimator.setDuration(i2);
                    YKSmartRefreshLayout.this.reboundAnimator.setInterpolator(new DecelerateInterpolator());
                    YKSmartRefreshLayout.this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.cmsui.YKSmartRefreshLayout.12.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            YKSmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator2.getAnimatedValue()).intValue(), true);
                        }
                    });
                    YKSmartRefreshLayout.this.reboundAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.youku.cmsui.YKSmartRefreshLayout.12.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                            yKSmartRefreshLayout2.reboundAnimator = null;
                            RefreshState refreshState = yKSmartRefreshLayout2.mState;
                            RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                            if (refreshState != refreshState2) {
                                yKSmartRefreshLayout2.mKernel.setState(refreshState2);
                            }
                            YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                            if (yKSmartRefreshLayout3.mEnableAutoLoadMore) {
                                yKSmartRefreshLayout3.mEnableAutoLoadMore = false;
                                yKSmartRefreshLayout3.overSpinner();
                                YKSmartRefreshLayout.this.mEnableAutoLoadMore = true;
                                return;
                            }
                            yKSmartRefreshLayout3.overSpinner();
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                            yKSmartRefreshLayout2.mLastTouchX = yKSmartRefreshLayout2.getMeasuredWidth() / 2;
                            YKSmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpToLoad);
                        }
                    });
                    YKSmartRefreshLayout.this.reboundAnimator.start();
                }
            };
            if (i > 0) {
                this.reboundAnimator = new ValueAnimator();
                postDelayed(runnable, i);
                return true;
            }
            runnable.run();
            return true;
        }
        return false;
    }

    public boolean autoRefresh(int i, final int i2, final float f) {
        if (this.mState == RefreshState.None && isEnableRefresh()) {
            ValueAnimator valueAnimator = this.reboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            Runnable runnable = new Runnable() { // from class: com.youku.cmsui.YKSmartRefreshLayout.10
                @Override // java.lang.Runnable
                public void run() {
                    YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                    RefreshInternal refreshInternal = yKSmartRefreshLayout.mRefreshHeader;
                    if (refreshInternal instanceof YKPageRefreshHeader) {
                        yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(0, Math.min(((YKPageRefreshHeader) refreshInternal).mRefreshingHeight, yKSmartRefreshLayout.mHeaderHeight));
                    } else {
                        yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(yKSmartRefreshLayout.mSpinner, (int) (yKSmartRefreshLayout.mHeaderHeight * f));
                    }
                    YKSmartRefreshLayout.this.reboundAnimator.setDuration(i2);
                    YKSmartRefreshLayout.this.reboundAnimator.setInterpolator(new DecelerateInterpolator());
                    YKSmartRefreshLayout.this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.cmsui.YKSmartRefreshLayout.10.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            YKSmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator2.getAnimatedValue()).intValue(), true);
                        }
                    });
                    YKSmartRefreshLayout.this.reboundAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.youku.cmsui.YKSmartRefreshLayout.10.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                            yKSmartRefreshLayout2.reboundAnimator = null;
                            RefreshState refreshState = yKSmartRefreshLayout2.mState;
                            RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                            if (refreshState != refreshState2) {
                                yKSmartRefreshLayout2.mKernel.setState(refreshState2);
                            }
                            YKSmartRefreshLayout.this.overSpinner();
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                            yKSmartRefreshLayout2.mLastTouchX = yKSmartRefreshLayout2.getMeasuredWidth() / 2;
                            YKSmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
                        }
                    });
                    YKSmartRefreshLayout.this.reboundAnimator.start();
                }
            };
            this.isAutoRefresh = true;
            if (i > 0) {
                this.reboundAnimator = new ValueAnimator();
                postDelayed(runnable, i);
            } else {
                runnable.run();
            }
            return true;
        }
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setDisableContentWhenLoading(boolean z) {
        this.mDisableContentWhenLoading = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setDisableContentWhenRefresh(boolean z) {
        this.mDisableContentWhenRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setDragRate(float f) {
        this.mDragRate = f;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableAutoLoadMore(boolean z) {
        this.mEnableAutoLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableClipFooterWhenFixedBehind(boolean z) {
        this.mEnableClipFooterWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableClipHeaderWhenFixedBehind(boolean z) {
        this.mEnableClipHeaderWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableFooterFollowWhenLoadFinished(boolean z) {
        this.mEnableFooterFollowWhenLoadFinished = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableFooterTranslationContent(boolean z) {
        this.mEnableFooterTranslationContent = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableHeaderTranslationContent(boolean z) {
        this.mEnableHeaderTranslationContent = z;
        this.mManualHeaderTranslationContent = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableLoadMore(boolean z) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.mEnableLoadMoreWhenContentNotFull = z;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setEnableLoadMoreWhenContentNotFull(z);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableOverScrollBounce(boolean z) {
        this.mEnableOverScrollBounce = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableOverScrollDrag(boolean z) {
        this.mEnableOverScrollDrag = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnablePureScrollMode(boolean z) {
        this.mEnablePureScrollMode = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableScrollContentWhenLoaded(boolean z) {
        this.mEnableScrollContentWhenLoaded = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableScrollContentWhenRefreshed(boolean z) {
        this.mEnableScrollContentWhenRefreshed = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setFooterHeight(float f) {
        int dp2px;
        if (this.mFooterHeightStatus.a(l80.CodeExact) && (dp2px = DensityUtil.dp2px(f)) != this.mFooterHeight) {
            this.mFooterHeight = dp2px;
            this.mFooterHeightStatus = l80.CodeExactUnNotify;
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal != null) {
                refreshInternal.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setFooterInsetStart(float f) {
        this.mFooterInsetStart = DensityUtil.dp2px(f);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setFooterMaxDragRate(float f) {
        this.mFooterMaxDragRate = f;
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal != null && this.mHandler != null) {
            RefreshKernel refreshKernel = this.mKernel;
            int i = this.mFooterHeight;
            refreshInternal.onInitialized(refreshKernel, i, (int) (i * f));
        } else {
            this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setFooterTriggerRate(float f) {
        this.mFooterTriggerRate = f;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setHeaderHeight(float f) {
        if (this.mHeaderHeightStatus.a(l80.CodeExact)) {
            this.mHeaderHeight = DensityUtil.dp2px(f);
            this.mHeaderHeightStatus = l80.CodeExactUnNotify;
            RefreshInternal refreshInternal = this.mRefreshHeader;
            if (refreshInternal != null) {
                refreshInternal.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setHeaderInsetStart(float f) {
        this.mHeaderInsetStart = DensityUtil.dp2px(f);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setHeaderMaxDragRate(float f) {
        this.mHeaderMaxDragRate = f;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null && this.mHandler != null) {
            RefreshKernel refreshKernel = this.mKernel;
            int i = this.mHeaderHeight;
            refreshInternal.onInitialized(refreshKernel, i, (int) (f * i));
        } else {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setHeaderTriggerRate(float f) {
        this.mHeaderTriggerRate = f;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal instanceof YKPageRefreshHeader) {
            ((YKPageRefreshHeader) refreshInternal).mHeaderTriggerRate = f;
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setNoMoreData(boolean z) {
        this.mFooterNoMoreData = z;
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if ((refreshInternal instanceof RefreshFooter) && !((RefreshFooter) refreshInternal).setNoMoreData(z)) {
            PrintStream printStream = System.out;
            printStream.println("Footer:" + this.mRefreshFooter + " Prompt completion is not supported.(不支持提示完成)");
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mLoadMoreListener = onLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || onLoadMoreListener == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setOnMultiPurposeListener(OnMultiPurposeListener onMultiPurposeListener) {
        this.mOnMultiPurposeListener = onMultiPurposeListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        this.mRefreshListener = onRefreshLoadMoreListener;
        this.mLoadMoreListener = onRefreshLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || onRefreshLoadMoreListener == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setPrimaryColors(@ColorInt int... iArr) {
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
    public YKSmartRefreshLayout setPrimaryColorsId(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = zd2.getColor(getContext(), iArr[i]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setReboundDuration(int i) {
        this.mReboundDuration = i;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setReboundInterpolator(@NonNull Interpolator interpolator) {
        this.mReboundInterpolator = interpolator;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.scwang.smartrefresh.layout.api.RefreshLayout setRefreshContent(@androidx.annotation.NonNull android.view.View r3, int r4, int r5) {
        /*
            r2 = this;
            com.scwang.smartrefresh.layout.api.RefreshContent r0 = r2.mRefreshContent
            if (r0 == 0) goto Lb
            android.view.View r0 = r0.getView()
            super.removeView(r0)
        Lb:
            r0 = 0
            com.youku.cmsui.YKSmartRefreshLayout$LayoutParams r1 = new com.youku.cmsui.YKSmartRefreshLayout$LayoutParams
            r1.<init>(r4, r5)
            super.addView(r3, r0, r1)
            com.scwang.smartrefresh.layout.api.RefreshInternal r4 = r2.mRefreshHeader
            if (r4 == 0) goto L37
            tb.df2 r4 = r4.getSpinnerStyle()
            tb.df2 r5 = tb.df2.FixedBehind
            if (r4 != r5) goto L37
            super.bringChildToFront(r3)
            com.scwang.smartrefresh.layout.api.RefreshInternal r4 = r2.mRefreshFooter
            if (r4 == 0) goto L59
            tb.df2 r4 = r4.getSpinnerStyle()
            if (r4 == r5) goto L59
            com.scwang.smartrefresh.layout.api.RefreshInternal r4 = r2.mRefreshFooter
            android.view.View r4 = r4.getView()
            super.bringChildToFront(r4)
            goto L59
        L37:
            com.scwang.smartrefresh.layout.api.RefreshInternal r4 = r2.mRefreshFooter
            if (r4 == 0) goto L59
            tb.df2 r4 = r4.getSpinnerStyle()
            tb.df2 r5 = tb.df2.FixedBehind
            if (r4 != r5) goto L59
            super.bringChildToFront(r3)
            com.scwang.smartrefresh.layout.api.RefreshInternal r4 = r2.mRefreshHeader
            if (r4 == 0) goto L59
            tb.df2 r4 = r4.getSpinnerStyle()
            if (r4 != r5) goto L59
            com.scwang.smartrefresh.layout.api.RefreshInternal r4 = r2.mRefreshHeader
            android.view.View r4 = r4.getView()
            super.bringChildToFront(r4)
        L59:
            com.youku.cmsui.RefreshContentWrapper r4 = new com.youku.cmsui.RefreshContentWrapper
            r4.<init>(r3)
            r2.mRefreshContent = r4
            android.os.Handler r3 = r2.mHandler
            if (r3 == 0) goto L8c
            int r3 = r2.mFixedHeaderViewId
            r4 = 0
            if (r3 <= 0) goto L6e
            android.view.View r3 = r2.findViewById(r3)
            goto L6f
        L6e:
            r3 = r4
        L6f:
            int r5 = r2.mFixedFooterViewId
            if (r5 <= 0) goto L77
            android.view.View r4 = r2.findViewById(r5)
        L77:
            com.scwang.smartrefresh.layout.api.RefreshContent r5 = r2.mRefreshContent
            com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider r0 = r2.mScrollBoundaryDecider
            r5.setScrollBoundaryDecider(r0)
            com.scwang.smartrefresh.layout.api.RefreshContent r5 = r2.mRefreshContent
            boolean r0 = r2.mEnableLoadMoreWhenContentNotFull
            r5.setEnableLoadMoreWhenContentNotFull(r0)
            com.scwang.smartrefresh.layout.api.RefreshContent r5 = r2.mRefreshContent
            com.scwang.smartrefresh.layout.api.RefreshKernel r0 = r2.mKernel
            r5.setUpComponent(r0, r3, r4)
        L8c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.cmsui.YKSmartRefreshLayout.setRefreshContent(android.view.View, int, int):com.scwang.smartrefresh.layout.api.RefreshLayout");
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider) {
        this.mScrollBoundaryDecider = scrollBoundaryDecider;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setScrollBoundaryDecider(scrollBoundaryDecider);
        }
        return this;
    }

    public YKSmartRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFloorDuration = 250;
        this.mReboundDuration = 250;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenLoadFinished = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mManualLoadMore = false;
        this.mManualNestedScrolling = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mScrollBoundaryDecider = new MyScrollBoundaryDecider();
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
        this.mSupportDragHDirection = true;
        this.mInterceptEventWhenStatueChanged = true;
        this.mSupportNestedHScroll = true;
        this.mKernel = new RefreshKernelImpl();
        RefreshState refreshState = RefreshState.None;
        this.mState = refreshState;
        this.mViceState = refreshState;
        this.mLastOpenTime = 0L;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mAblePullingDownWhenRefreshing = true;
        this.isAutoRefresh = false;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        super.setClipToPadding(false);
        DensityUtil densityUtil = new DensityUtil();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics());
        this.mReboundInterpolator = new ViscousFluidInterpolator();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mNestedChild;
        int i2 = R.styleable.SmartRefreshLayout_srlEnableNestedScrolling;
        nestedScrollingChildHelper.setNestedScrollingEnabled(obtainStyledAttributes.getBoolean(i2, nestedScrollingChildHelper.isNestedScrollingEnabled()));
        this.mDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        int i3 = R.styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.mEnableLoadMore = obtainStyledAttributes.getBoolean(i3, this.mEnableLoadMore);
        int i4 = R.styleable.SmartRefreshLayout_srlHeaderHeight;
        this.mHeaderHeight = obtainStyledAttributes.getDimensionPixelOffset(i4, densityUtil.dip2px(100.0f));
        int i5 = R.styleable.SmartRefreshLayout_srlFooterHeight;
        this.mFooterHeight = obtainStyledAttributes.getDimensionPixelOffset(i5, densityUtil.dip2px(60.0f));
        this.mHeaderInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, 0);
        this.mFooterInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, 0);
        this.mDisableContentWhenRefresh = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        int i6 = R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.mEnableHeaderTranslationContent = obtainStyledAttributes.getBoolean(i6, this.mEnableHeaderTranslationContent);
        this.mEnableFooterTranslationContent = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        this.mEnableFooterFollowWhenLoadFinished = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenLoadFinished);
        this.mEnableClipHeaderWhenFixedBehind = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        int i7 = R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag;
        this.mEnableOverScrollDrag = obtainStyledAttributes.getBoolean(i7, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, -1);
        this.mFixedFooterViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, -1);
        if (this.mEnablePureScrollMode && !obtainStyledAttributes.hasValue(i7)) {
            this.mEnableOverScrollDrag = true;
        }
        this.mManualLoadMore = obtainStyledAttributes.hasValue(i3);
        this.mManualNestedScrolling = this.mManualNestedScrolling || obtainStyledAttributes.hasValue(i2);
        this.mManualHeaderTranslationContent = obtainStyledAttributes.hasValue(i6);
        this.mHeaderHeightStatus = obtainStyledAttributes.hasValue(i4) ? l80.XmlLayoutUnNotify : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = obtainStyledAttributes.hasValue(i5) ? l80.XmlLayoutUnNotify : this.mFooterHeightStatus;
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter) {
        return setRefreshFooter(refreshFooter, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader) {
        return setRefreshHeader(refreshHeader, -1, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter, int i, int i2) {
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal != null) {
            super.removeView(refreshInternal.getView());
        }
        this.mRefreshFooter = refreshFooter;
        this.mFooterBackgroundColor = 0;
        this.mFooterNeedTouchEventWhenLoading = false;
        this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        this.mEnableLoadMore = !this.mManualLoadMore || this.mEnableLoadMore;
        if (this.mRefreshFooter.getSpinnerStyle() == df2.FixedBehind) {
            super.addView(this.mRefreshFooter.getView(), 0, new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshFooter.getView(), i, i2);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader, int i, int i2) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            super.removeView(refreshInternal.getView());
        }
        this.mRefreshHeader = refreshHeader;
        this.mHeaderBackgroundColor = 0;
        this.mHeaderNeedTouchEventWhenRefreshing = false;
        this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        if (refreshHeader.getSpinnerStyle() == df2.FixedBehind) {
            super.addView(this.mRefreshHeader.getView(), 0, new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshHeader.getView(), i, i2);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMore() {
        return finishLoadMore(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishRefresh() {
        return finishRefresh(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMore(int i) {
        return finishLoadMore(i, true, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishRefresh(int i) {
        return finishRefresh(i, true);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class LayoutParams extends SmartRefreshLayout.LayoutParams {
        public int backgroundColor;
        public df2 spinnerStyle;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.backgroundColor = 0;
            this.spinnerStyle = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.backgroundColor = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.backgroundColor);
            int i = R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i)) {
                this.spinnerStyle = df2.values()[obtainStyledAttributes.getInt(i, df2.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.backgroundColor = 0;
            this.spinnerStyle = null;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.backgroundColor = 0;
            this.spinnerStyle = null;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.backgroundColor = 0;
            this.spinnerStyle = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMore(boolean z) {
        return finishLoadMore(z ? Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))) : 0, z, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishRefresh(boolean z) {
        return finishRefresh(z ? Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))) : 0, z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMore(int i, boolean z, boolean z2) {
        postDelayed(new AnonymousClass9(z, z2), i <= 0 ? 1L : i);
        return this;
    }

    public YKSmartRefreshLayout finishRefresh(int i, final boolean z) {
        postDelayed(new Runnable() { // from class: com.youku.cmsui.YKSmartRefreshLayout.8
            @Override // java.lang.Runnable
            public void run() {
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                if (yKSmartRefreshLayout.mState != RefreshState.Refreshing || yKSmartRefreshLayout.mRefreshHeader == null || yKSmartRefreshLayout.mRefreshContent == null) {
                    return;
                }
                yKSmartRefreshLayout.notifyStateChanged(RefreshState.RefreshFinish);
                YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                int onFinish = yKSmartRefreshLayout2.mRefreshHeader.onFinish(yKSmartRefreshLayout2, z);
                YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                OnMultiPurposeListener onMultiPurposeListener = yKSmartRefreshLayout3.mOnMultiPurposeListener;
                if (onMultiPurposeListener != null) {
                    RefreshInternal refreshInternal = yKSmartRefreshLayout3.mRefreshHeader;
                    if (refreshInternal instanceof RefreshHeader) {
                        onMultiPurposeListener.onHeaderFinish((RefreshHeader) refreshInternal, z);
                    }
                }
                if (onFinish < Integer.MAX_VALUE) {
                    YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout4.mIsBeingDragged) {
                        yKSmartRefreshLayout4.mTouchSpinner = 0;
                        yKSmartRefreshLayout4.mTouchY = yKSmartRefreshLayout4.mLastTouchY;
                        yKSmartRefreshLayout4.mIsBeingDragged = false;
                        long currentTimeMillis = System.currentTimeMillis();
                        YKSmartRefreshLayout yKSmartRefreshLayout5 = YKSmartRefreshLayout.this;
                        YKSmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, yKSmartRefreshLayout5.mLastTouchX, (yKSmartRefreshLayout5.mTouchY + yKSmartRefreshLayout5.mSpinner) - (yKSmartRefreshLayout5.mTouchSlop * 2), 0));
                        YKSmartRefreshLayout yKSmartRefreshLayout6 = YKSmartRefreshLayout.this;
                        YKSmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, yKSmartRefreshLayout6.mLastTouchX, yKSmartRefreshLayout6.mTouchY + yKSmartRefreshLayout6.mSpinner, 0));
                    }
                    YKSmartRefreshLayout yKSmartRefreshLayout7 = YKSmartRefreshLayout.this;
                    int i2 = yKSmartRefreshLayout7.mSpinner;
                    if (i2 <= 0) {
                        if (i2 < 0) {
                            yKSmartRefreshLayout7.animSpinner(0, onFinish, yKSmartRefreshLayout7.mReboundInterpolator, yKSmartRefreshLayout7.mReboundDuration);
                            return;
                        }
                        yKSmartRefreshLayout7.mKernel.moveSpinner(0, false);
                        YKSmartRefreshLayout.this.resetStatus();
                        return;
                    }
                    ValueAnimator animSpinner = yKSmartRefreshLayout7.animSpinner(0, onFinish, yKSmartRefreshLayout7.mReboundInterpolator, yKSmartRefreshLayout7.mReboundDuration);
                    YKSmartRefreshLayout yKSmartRefreshLayout8 = YKSmartRefreshLayout.this;
                    ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished = yKSmartRefreshLayout8.mEnableScrollContentWhenRefreshed ? yKSmartRefreshLayout8.mRefreshContent.scrollContentWhenFinished(yKSmartRefreshLayout8.mSpinner) : null;
                    if (animSpinner == null || scrollContentWhenFinished == null) {
                        return;
                    }
                    animSpinner.addUpdateListener(scrollContentWhenFinished);
                }
            }
        }, i <= 0 ? 1L : i);
        return this;
    }
}
