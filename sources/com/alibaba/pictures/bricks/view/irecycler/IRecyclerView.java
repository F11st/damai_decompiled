package com.alibaba.pictures.bricks.view.irecycler;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$styleable;
import com.alibaba.pictures.bricks.view.RefreshTrigger;
import com.alibaba.pictures.bricks.view.irecycler.LoadMoreFooterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.uc2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final boolean DEBUG = false;
    private static final int STATUS_DEFAULT = 0;
    private static final int STATUS_REFRESHING = 3;
    private static final int STATUS_RELEASE_TO_REFRESH = 2;
    private static final int STATUS_SWIPING_TO_REFRESH = 1;
    private static final String TAG = IRecyclerView.class.getSimpleName();
    private boolean intercept;
    @LayoutRes
    int loadMoreFooterLayoutRes;
    private int mActivePointerId;
    Animator.AnimatorListener mAnimationListener;
    ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private LinearLayout mFooterViewContainer;
    private LinearLayout mHeaderViewContainer;
    private boolean mIsAutoRefreshing;
    private boolean mIsAutoToDefault;
    private int mLastTouchX;
    private int mLastTouchY;
    private boolean mLoadMoreEnabled;
    private FrameLayout mLoadMoreFooterContainer;
    private View mLoadMoreFooterView;
    private int mMaxDownHeight;
    private OnLoadMoreListener mOnLoadMoreListener;
    private OnLoadMoreScrollListener mOnLoadMoreScrollListener;
    private OnRefreshListener mOnRefreshListener;
    private boolean mRefreshEnabled;
    private int mRefreshFinalMoveOffset;
    private RefreshHeaderLayout mRefreshHeaderContainer;
    private View mRefreshHeaderView;
    RefreshTrigger mRefreshTrigger;
    ValueAnimator mScrollAnimator;
    private int mStatus;
    @LayoutRes
    int refreshHeaderLayoutRes;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1110742181")) {
                ipChange.ipc$dispatch("-1110742181", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            IRecyclerView.this.setRefreshHeaderContainerHeight(intValue);
            int i = IRecyclerView.this.mStatus;
            if (i == 1) {
                IRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (i == 2) {
                IRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (i != 3) {
            } else {
                IRecyclerView.this.mRefreshTrigger.onMove(true, true, intValue);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b extends uc2 {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2146990731")) {
                ipChange.ipc$dispatch("2146990731", new Object[]{this, animator});
                return;
            }
            int unused = IRecyclerView.this.mStatus;
            int i = IRecyclerView.this.mStatus;
            if (i == 1) {
                if (IRecyclerView.this.mIsAutoRefreshing) {
                    IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = IRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                    IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                    IRecyclerView.this.setStatus(3);
                    if (IRecyclerView.this.mOnRefreshListener != null) {
                        IRecyclerView.this.mOnRefreshListener.onRefresh();
                        IRecyclerView.this.mRefreshTrigger.onRefresh();
                        return;
                    }
                    return;
                }
                IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                IRecyclerView.this.setStatus(0);
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                IRecyclerView.this.mIsAutoRefreshing = false;
                IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                IRecyclerView.this.setStatus(0);
                IRecyclerView.this.mRefreshTrigger.onReset();
            } else {
                if (!IRecyclerView.this.mIsAutoToDefault) {
                    IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = IRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                    IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                    IRecyclerView.this.setStatus(3);
                } else {
                    IRecyclerView.this.setStatus(0);
                }
                if (IRecyclerView.this.mOnRefreshListener != null) {
                    IRecyclerView.this.mOnRefreshListener.onRefresh();
                    IRecyclerView.this.mRefreshTrigger.onRefresh();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements RefreshTrigger {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
        public void onComplete() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "570579885")) {
                ipChange.ipc$dispatch("570579885", new Object[]{this});
            } else if (IRecyclerView.this.mRefreshHeaderView == null || !(IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onComplete();
            }
        }

        @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
        public void onMove(boolean z, boolean z2, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1168307762")) {
                ipChange.ipc$dispatch("-1168307762", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)});
            } else if (IRecyclerView.this.mRefreshHeaderView == null || !(IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onMove(z, z2, i);
            }
        }

        @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1346103433")) {
                ipChange.ipc$dispatch("1346103433", new Object[]{this});
            } else if (IRecyclerView.this.mRefreshHeaderView == null || !(IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onRefresh();
            }
        }

        @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
        public void onRelease() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "150811613")) {
                ipChange.ipc$dispatch("150811613", new Object[]{this});
            } else if (IRecyclerView.this.mRefreshHeaderView == null || !(IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onRelease();
            }
        }

        @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
        public void onReset() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-594476715")) {
                ipChange.ipc$dispatch("-594476715", new Object[]{this});
            } else if (IRecyclerView.this.mRefreshHeaderView == null || !(IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onReset();
            }
        }

        @Override // com.alibaba.pictures.bricks.view.RefreshTrigger
        public void onStart(boolean z, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1340702098")) {
                ipChange.ipc$dispatch("1340702098", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (IRecyclerView.this.mRefreshHeaderView == null || !(IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onStart(z, i, i2);
            }
        }
    }

    public IRecyclerView(Context context) {
        this(context, null);
    }

    private void ensureFooterViewContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1666126418")) {
            ipChange.ipc$dispatch("1666126418", new Object[]{this});
        } else if (this.mFooterViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mFooterViewContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.mFooterViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureHeaderViewContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826691908")) {
            ipChange.ipc$dispatch("1826691908", new Object[]{this});
        } else if (this.mHeaderViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mHeaderViewContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.mHeaderViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureLoadMoreFooterContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839121336")) {
            ipChange.ipc$dispatch("-839121336", new Object[]{this});
        } else if (this.mLoadMoreFooterContainer == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.mLoadMoreFooterContainer = frameLayout;
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureRefreshHeaderContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790691326")) {
            ipChange.ipc$dispatch("1790691326", new Object[]{this});
        } else if (this.mRefreshHeaderContainer == null) {
            RefreshHeaderLayout refreshHeaderLayout = new RefreshHeaderLayout(getContext());
            this.mRefreshHeaderContainer = refreshHeaderLayout;
            refreshHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        }
    }

    private void fingerMove(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276973528")) {
            ipChange.ipc$dispatch("-1276973528", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = (int) ((i * 0.5f) + 0.5d);
        int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight();
        int i3 = this.mRefreshFinalMoveOffset;
        int i4 = measuredHeight + i2;
        if (i3 > 0 && i4 > i3) {
            i2 = i3 - measuredHeight;
        }
        if (i4 < 0) {
            i2 = -measuredHeight;
        }
        move(i2);
    }

    private int getMotionEventX(MotionEvent motionEvent, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-429552106") ? ((Integer) ipChange.ipc$dispatch("-429552106", new Object[]{this, motionEvent, Integer.valueOf(i)})).intValue() : (int) (MotionEventCompat.getX(motionEvent, i) + 0.5f);
    }

    private int getMotionEventY(MotionEvent motionEvent, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-78752169") ? ((Integer) ipChange.ipc$dispatch("-78752169", new Object[]{this, motionEvent, Integer.valueOf(i)})).intValue() : (int) (MotionEventCompat.getY(motionEvent, i) + 0.5f);
    }

    private String getStatusLog(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-164987818") ? (String) ipChange.ipc$dispatch("-164987818", new Object[]{this, Integer.valueOf(i)}) : i != 0 ? i != 1 ? i != 2 ? i != 3 ? "status_illegal!" : "status_refreshing" : "status_release_to_refresh" : "status_swiping_to_refresh" : "status_default";
    }

    private boolean isFingerDragging() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1861685879") ? ((Boolean) ipChange.ipc$dispatch("1861685879", new Object[]{this})).booleanValue() : getScrollState() == 1;
    }

    private boolean isRefreshTrigger(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1762853960") ? ((Boolean) ipChange.ipc$dispatch("1762853960", new Object[]{this, view})).booleanValue() : view instanceof RefreshTrigger;
    }

    private void move(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "201168799")) {
            ipChange.ipc$dispatch("201168799", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 0) {
            int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight() + i;
            int i2 = this.mMaxDownHeight;
            if (i2 > 0 && measuredHeight > i2) {
                measuredHeight = i2;
            }
            setRefreshHeaderContainerHeight(measuredHeight);
            this.mRefreshTrigger.onMove(false, false, measuredHeight);
        }
    }

    private void onFingerUpStartAnimating() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-588571114")) {
            ipChange.ipc$dispatch("-588571114", new Object[]{this});
            return;
        }
        int i = this.mStatus;
        if (i == 2 && !this.mIsAutoToDefault) {
            startScrollReleaseStatusToRefreshingStatus();
        } else if (i == 1 || this.mIsAutoToDefault) {
            startScrollSwipingToRefreshStatusToDefaultStatus();
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476905841")) {
            ipChange.ipc$dispatch("1476905841", new Object[]{this, motionEvent});
            return;
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i = actionIndex != 0 ? 0 : 1;
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            this.mLastTouchX = getMotionEventX(motionEvent, i);
            this.mLastTouchY = getMotionEventY(motionEvent, i);
        }
    }

    private void printStatusLog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369926000")) {
            ipChange.ipc$dispatch("1369926000", new Object[]{this});
        } else {
            Log.i(TAG, getStatusLog(this.mStatus));
        }
    }

    private void removeLoadMoreFooterView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565621430")) {
            ipChange.ipc$dispatch("565621430", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mLoadMoreFooterContainer;
        if (frameLayout != null) {
            frameLayout.removeView(this.mLoadMoreFooterView);
        }
    }

    private void removeRefreshHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548112652")) {
            ipChange.ipc$dispatch("548112652", new Object[]{this});
            return;
        }
        RefreshHeaderLayout refreshHeaderLayout = this.mRefreshHeaderContainer;
        if (refreshHeaderLayout != null) {
            refreshHeaderLayout.removeView(this.mRefreshHeaderView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefreshHeaderContainerHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1054967600")) {
            ipChange.ipc$dispatch("1054967600", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRefreshHeaderContainer.getLayoutParams().height = i;
        this.mRefreshHeaderContainer.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345522434")) {
            ipChange.ipc$dispatch("345522434", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mStatus = i;
        }
    }

    private void startScrollAnimation(int i, Interpolator interpolator, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710027102")) {
            ipChange.ipc$dispatch("-1710027102", new Object[]{this, Integer.valueOf(i), interpolator, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        if (this.mScrollAnimator == null) {
            this.mScrollAnimator = new ValueAnimator();
        }
        this.mScrollAnimator.removeAllUpdateListeners();
        this.mScrollAnimator.removeAllListeners();
        this.mScrollAnimator.cancel();
        this.mScrollAnimator.setIntValues(i2, i3);
        this.mScrollAnimator.setDuration(i);
        this.mScrollAnimator.setInterpolator(interpolator);
        this.mScrollAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mScrollAnimator.addListener(this.mAnimationListener);
        this.mScrollAnimator.start();
    }

    private void startScrollDefaultStatusToRefreshingStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655177571")) {
            ipChange.ipc$dispatch("-655177571", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onStart(true, this.mRefreshHeaderView.getMeasuredHeight(), this.mRefreshFinalMoveOffset);
        startScrollAnimation(400, new AccelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), this.mRefreshHeaderView.getMeasuredHeight());
    }

    private void startScrollRefreshingStatusToDefaultStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2142105723")) {
            ipChange.ipc$dispatch("-2142105723", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onComplete();
        startScrollAnimation(400, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
    }

    private void startScrollReleaseStatusToRefreshingStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394177257")) {
            ipChange.ipc$dispatch("-1394177257", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onRelease();
        startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), this.mRefreshHeaderView.getMeasuredHeight());
    }

    private void startScrollSwipingToRefreshStatusToDefaultStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653171385")) {
            ipChange.ipc$dispatch("-1653171385", new Object[]{this});
        } else {
            startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
        }
    }

    public void addFooterView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1737069378")) {
            ipChange.ipc$dispatch("-1737069378", new Object[]{this, view});
            return;
        }
        ensureFooterViewContainer();
        this.mFooterViewContainer.addView(view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(adapter.getItemCount() - 2);
        }
    }

    public void addHeaderView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961507120")) {
            ipChange.ipc$dispatch("961507120", new Object[]{this, view});
            return;
        }
        ensureHeaderViewContainer();
        this.mHeaderViewContainer.addView(view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(1);
        }
    }

    public boolean canLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605209490")) {
            return ((Boolean) ipChange.ipc$dispatch("-605209490", new Object[]{this})).booleanValue();
        }
        View view = this.mLoadMoreFooterView;
        if (view == null || !(view instanceof LoadMoreFooterView)) {
            return false;
        }
        return ((LoadMoreFooterView) view).canLoadMore();
    }

    public boolean canTriggerRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305170630")) {
            return ((Boolean) ipChange.ipc$dispatch("1305170630", new Object[]{this})).booleanValue();
        }
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null || adapter.getItemCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return getChildLayoutPosition(childAt) == 0 && childAt.getTop() == this.mRefreshHeaderContainer.getTop();
    }

    public LinearLayout getFooterContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071445052")) {
            return (LinearLayout) ipChange.ipc$dispatch("1071445052", new Object[]{this});
        }
        ensureFooterViewContainer();
        return this.mFooterViewContainer;
    }

    public LinearLayout getHeaderContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417689298")) {
            return (LinearLayout) ipChange.ipc$dispatch("-1417689298", new Object[]{this});
        }
        ensureHeaderViewContainer();
        return this.mHeaderViewContainer;
    }

    public RecyclerView.Adapter getIAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1012920501") ? (RecyclerView.Adapter) ipChange.ipc$dispatch("1012920501", new Object[]{this}) : ((WrapperAdapter) getAdapter()).a();
    }

    public View getLoadMoreFooterView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1295746394") ? (View) ipChange.ipc$dispatch("-1295746394", new Object[]{this}) : this.mLoadMoreFooterView;
    }

    public View getRefreshHeaderView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1396807840") ? (View) ipChange.ipc$dispatch("-1396807840", new Object[]{this}) : this.mRefreshHeaderView;
    }

    public WrapperAdapter getWrapAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2028387310") ? (WrapperAdapter) ipChange.ipc$dispatch("2028387310", new Object[]{this}) : (WrapperAdapter) getAdapter();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1764690832")) {
            return ((Boolean) ipChange.ipc$dispatch("1764690832", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.intercept) {
            return true;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mLastTouchX = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.mLastTouchY = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
        } else if (actionMasked == 5) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            this.mLastTouchX = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.mLastTouchY = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572875882")) {
            ipChange.ipc$dispatch("-1572875882", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        View view = this.mRefreshHeaderView;
        if (view == null || view.getMeasuredHeight() <= this.mRefreshFinalMoveOffset) {
            return;
        }
        this.mRefreshFinalMoveOffset = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d7, code lost:
        if (r8.mStatus == 0) goto L20;
     */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.view.irecycler.IRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1668168604")) {
            ipChange.ipc$dispatch("-1668168604", new Object[]{this, adapter});
            return;
        }
        ensureRefreshHeaderContainer();
        ensureHeaderViewContainer();
        ensureFooterViewContainer();
        ensureLoadMoreFooterContainer();
        super.setAdapter(new WrapperAdapter(adapter, this.mRefreshHeaderContainer, this.mHeaderViewContainer, this.mFooterViewContainer, this.mLoadMoreFooterContainer));
    }

    public void setInterceptOnTouchEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091659673")) {
            ipChange.ipc$dispatch("1091659673", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.intercept = z;
        }
    }

    public void setIsAutoToDefault(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-983654614")) {
            ipChange.ipc$dispatch("-983654614", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsAutoToDefault = z;
        }
    }

    public void setLoadMoreEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-239562045")) {
            ipChange.ipc$dispatch("-239562045", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mLoadMoreEnabled = z;
        if (z) {
            OnLoadMoreScrollListener onLoadMoreScrollListener = this.mOnLoadMoreScrollListener;
            if (onLoadMoreScrollListener == null) {
                this.mOnLoadMoreScrollListener = new OnLoadMoreScrollListener() { // from class: com.alibaba.pictures.bricks.view.irecycler.IRecyclerView.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.alibaba.pictures.bricks.view.irecycler.OnLoadMoreScrollListener
                    public void b(RecyclerView recyclerView) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1627836719")) {
                            ipChange2.ipc$dispatch("1627836719", new Object[]{this, recyclerView});
                        } else if (IRecyclerView.this.mOnLoadMoreListener == null || IRecyclerView.this.mStatus != 0) {
                        } else {
                            IRecyclerView.this.mOnLoadMoreListener.onLoadMore(IRecyclerView.this.mLoadMoreFooterView);
                        }
                    }
                };
            } else {
                removeOnScrollListener(onLoadMoreScrollListener);
            }
            addOnScrollListener(this.mOnLoadMoreScrollListener);
            return;
        }
        if (this.mLoadMoreFooterView != null) {
            removeLoadMoreFooterView();
        }
        OnLoadMoreScrollListener onLoadMoreScrollListener2 = this.mOnLoadMoreScrollListener;
        if (onLoadMoreScrollListener2 != null) {
            removeOnScrollListener(onLoadMoreScrollListener2);
        }
    }

    public void setLoadMoreFooterView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414821382")) {
            ipChange.ipc$dispatch("-414821382", new Object[]{this, view});
            return;
        }
        if (this.mLoadMoreFooterView != null) {
            removeLoadMoreFooterView();
        }
        if (this.mLoadMoreFooterView != view) {
            this.mLoadMoreFooterView = view;
            ensureLoadMoreFooterContainer();
            this.mLoadMoreFooterContainer.addView(view);
        }
    }

    public void setLoadMoreStatus(LoadMoreFooterView.Status status) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386505927")) {
            ipChange.ipc$dispatch("1386505927", new Object[]{this, status});
            return;
        }
        View view = this.mLoadMoreFooterView;
        if (view == null || !(view instanceof LoadMoreFooterView)) {
            return;
        }
        ((LoadMoreFooterView) view).setStatus(status);
    }

    public void setMaxDownHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-467335559")) {
            ipChange.ipc$dispatch("-467335559", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mMaxDownHeight = i;
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "382188225")) {
            ipChange.ipc$dispatch("382188225", new Object[]{this, onLoadMoreListener});
        } else {
            this.mOnLoadMoreListener = onLoadMoreListener;
        }
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492357971")) {
            ipChange.ipc$dispatch("1492357971", new Object[]{this, onRefreshListener});
        } else {
            this.mOnRefreshListener = onRefreshListener;
        }
    }

    public void setRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870664391")) {
            ipChange.ipc$dispatch("870664391", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mRefreshEnabled = z;
        }
    }

    public void setRefreshFinalMoveOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595605007")) {
            ipChange.ipc$dispatch("1595605007", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mRefreshFinalMoveOffset = i;
        }
    }

    public void setRefreshHeaderView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-969454872")) {
            ipChange.ipc$dispatch("-969454872", new Object[]{this, view});
        } else if (isRefreshTrigger(view)) {
            if (this.mRefreshHeaderView != null) {
                removeRefreshHeaderView();
            }
            if (this.mRefreshHeaderView != view) {
                this.mRefreshHeaderView = view;
                ensureRefreshHeaderContainer();
                this.mRefreshHeaderContainer.addView(view);
            }
        } else {
            throw new ClassCastException("Refresh header view must be an implement of RefreshTrigger");
        }
    }

    public void setRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062770040")) {
            ipChange.ipc$dispatch("-2062770040", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int i = this.mStatus;
        if (i == 0 && z) {
            this.mIsAutoRefreshing = true;
            setStatus(1);
            startScrollDefaultStatusToRefreshingStatus();
        } else if (i == 3 && !z) {
            this.mIsAutoRefreshing = false;
            startScrollRefreshingStatusToDefaultStatus();
        } else {
            this.mIsAutoRefreshing = false;
            String str = TAG;
            Log.e(str, "isRefresh = " + z + " current status = " + this.mStatus);
        }
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.refreshHeaderLayoutRes = -1;
        this.loadMoreFooterLayoutRes = -1;
        this.mActivePointerId = -1;
        this.mLastTouchX = 0;
        this.mLastTouchY = 0;
        this.mMaxDownHeight = 0;
        this.mAnimatorUpdateListener = new a();
        this.mAnimationListener = new b();
        this.mRefreshTrigger = new c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BricksIRecyclerView, i, 0);
        try {
            boolean z = obtainStyledAttributes.getBoolean(R$styleable.BricksIRecyclerView_refreshEnabled, false);
            boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.BricksIRecyclerView_loadMoreEnabled, false);
            this.refreshHeaderLayoutRes = obtainStyledAttributes.getResourceId(R$styleable.BricksIRecyclerView_refreshHeaderLayout, -1);
            this.loadMoreFooterLayoutRes = obtainStyledAttributes.getResourceId(R$styleable.BricksIRecyclerView_loadMoreFooterLayout, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BricksIRecyclerView_refreshFinalMoveOffset, -1);
            obtainStyledAttributes.recycle();
            setRefreshEnabled(z);
            setLoadMoreEnabled(z2);
            int i2 = this.refreshHeaderLayoutRes;
            if (i2 != -1) {
                setRefreshHeaderView(i2);
            } else {
                int i3 = R$layout.bricks_layout_irecyclerview_classic_refresh_header;
                this.refreshHeaderLayoutRes = i3;
                setRefreshHeaderView(i3);
            }
            int i4 = this.loadMoreFooterLayoutRes;
            if (i4 != -1) {
                setLoadMoreFooterView(i4);
            } else {
                int i5 = R$layout.bricks_layout_irecyclerview_load_more_footer;
                this.loadMoreFooterLayoutRes = i5;
                setLoadMoreFooterView(i5);
            }
            if (dimensionPixelOffset != -1) {
                setRefreshFinalMoveOffset(dimensionPixelOffset);
            }
            setStatus(0);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setLoadMoreFooterView(@LayoutRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161557973")) {
            ipChange.ipc$dispatch("-1161557973", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ensureLoadMoreFooterContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mLoadMoreFooterContainer, false);
        if (inflate != null) {
            setLoadMoreFooterView(inflate);
        }
    }

    public void setRefreshHeaderView(@LayoutRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1148223129")) {
            ipChange.ipc$dispatch("1148223129", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ensureRefreshHeaderContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mRefreshHeaderContainer, false);
        if (inflate != null) {
            setRefreshHeaderView(inflate);
        }
    }
}
