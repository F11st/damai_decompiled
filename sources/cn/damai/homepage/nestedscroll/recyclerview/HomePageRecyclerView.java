package cn.damai.homepage.nestedscroll.recyclerview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnLoadMoreScrollListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.RefreshHeaderLayout;
import cn.damai.uikit.irecycler.RefreshTrigger;
import cn.damai.uikit.irecycler.WrapperAdapter;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.hb1;
import tb.vc2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class HomePageRecyclerView extends ParentRecyclerView {
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
    private Context mContext;
    private LinearLayout mFooterViewContainer;
    private LinearLayout mHeaderViewContainer;
    private boolean mIsAutoRefreshing;
    private boolean mIsAutoToDefault;
    private int mLastTouchX;
    private int mLastTouchY;
    private boolean mLoadMoreEnabled;
    private FrameLayout mLoadMoreFooterContainer;
    private View mLoadMoreFooterView;
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
    private int mTouchSlop;
    @LayoutRes
    int refreshHeaderLayoutRes;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.nestedscroll.recyclerview.HomePageRecyclerView$a */
    /* loaded from: classes14.dex */
    public class C1147a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1147a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-992578509")) {
                ipChange.ipc$dispatch("-992578509", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            HomePageRecyclerView.this.setRefreshHeaderContainerHeight(intValue);
            int i = HomePageRecyclerView.this.mStatus;
            if (i == 1) {
                HomePageRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (i == 2) {
                HomePageRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (i != 3) {
            } else {
                HomePageRecyclerView.this.mRefreshTrigger.onMove(true, true, intValue);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.nestedscroll.recyclerview.HomePageRecyclerView$b */
    /* loaded from: classes5.dex */
    public class C1148b extends vc2 {
        private static transient /* synthetic */ IpChange $ipChange;

        C1148b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1062872221")) {
                ipChange.ipc$dispatch("-1062872221", new Object[]{this, animator});
                return;
            }
            int unused = HomePageRecyclerView.this.mStatus;
            int i = HomePageRecyclerView.this.mStatus;
            if (i == 1) {
                if (HomePageRecyclerView.this.mIsAutoRefreshing) {
                    HomePageRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = HomePageRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                    HomePageRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                    HomePageRecyclerView.this.setStatus(3);
                    if (HomePageRecyclerView.this.mOnRefreshListener != null) {
                        HomePageRecyclerView.this.mOnRefreshListener.onRefresh();
                        HomePageRecyclerView.this.mRefreshTrigger.onRefresh();
                        return;
                    }
                    return;
                }
                HomePageRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                HomePageRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                HomePageRecyclerView.this.setStatus(0);
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                HomePageRecyclerView.this.mIsAutoRefreshing = false;
                HomePageRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                HomePageRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                HomePageRecyclerView.this.setStatus(0);
                HomePageRecyclerView.this.mRefreshTrigger.onReset();
            } else {
                if (!HomePageRecyclerView.this.mIsAutoToDefault) {
                    HomePageRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = HomePageRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                    HomePageRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                    HomePageRecyclerView.this.setStatus(3);
                } else {
                    HomePageRecyclerView.this.setStatus(0);
                }
                if (HomePageRecyclerView.this.mOnRefreshListener != null) {
                    HomePageRecyclerView.this.mOnRefreshListener.onRefresh();
                    HomePageRecyclerView.this.mRefreshTrigger.onRefresh();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.nestedscroll.recyclerview.HomePageRecyclerView$c */
    /* loaded from: classes5.dex */
    public class C1149c implements RefreshTrigger {
        private static transient /* synthetic */ IpChange $ipChange;

        C1149c() {
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onComplete() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2141789317")) {
                ipChange.ipc$dispatch("2141789317", new Object[]{this});
            } else if (HomePageRecyclerView.this.mRefreshHeaderView == null || !(HomePageRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) HomePageRecyclerView.this.mRefreshHeaderView).onComplete();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onMove(boolean z, boolean z2, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-286339594")) {
                ipChange.ipc$dispatch("-286339594", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)});
            } else if (HomePageRecyclerView.this.mRefreshHeaderView == null || !(HomePageRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) HomePageRecyclerView.this.mRefreshHeaderView).onMove(z, z2, i);
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2066895695")) {
                ipChange.ipc$dispatch("-2066895695", new Object[]{this});
            } else if (HomePageRecyclerView.this.mRefreshHeaderView == null || !(HomePageRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) HomePageRecyclerView.this.mRefreshHeaderView).onRefresh();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onRelease() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1032779781")) {
                ipChange.ipc$dispatch("1032779781", new Object[]{this});
            } else if (HomePageRecyclerView.this.mRefreshHeaderView == null || !(HomePageRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) HomePageRecyclerView.this.mRefreshHeaderView).onRelease();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onReset() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1080709251")) {
                ipChange.ipc$dispatch("-1080709251", new Object[]{this});
            } else if (HomePageRecyclerView.this.mRefreshHeaderView == null || !(HomePageRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) HomePageRecyclerView.this.mRefreshHeaderView).onReset();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onStart(boolean z, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1383055766")) {
                ipChange.ipc$dispatch("-1383055766", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (HomePageRecyclerView.this.mRefreshHeaderView == null || !(HomePageRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) HomePageRecyclerView.this.mRefreshHeaderView).onStart(z, i, i2);
            }
        }
    }

    public HomePageRecyclerView(Context context) {
        this(context, null);
    }

    private void ensureFooterViewContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-842895238")) {
            ipChange.ipc$dispatch("-842895238", new Object[]{this});
        } else if (this.mFooterViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mFooterViewContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.mFooterViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureHeaderViewContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-682329748")) {
            ipChange.ipc$dispatch("-682329748", new Object[]{this});
        } else if (this.mHeaderViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mHeaderViewContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.mHeaderViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureLoadMoreFooterContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-171700112")) {
            ipChange.ipc$dispatch("-171700112", new Object[]{this});
        } else if (this.mLoadMoreFooterContainer == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.mLoadMoreFooterContainer = frameLayout;
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureRefreshHeaderContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842389718")) {
            ipChange.ipc$dispatch("842389718", new Object[]{this});
        } else if (this.mRefreshHeaderContainer == null) {
            RefreshHeaderLayout refreshHeaderLayout = new RefreshHeaderLayout(getContext());
            this.mRefreshHeaderContainer = refreshHeaderLayout;
            refreshHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        }
    }

    private void fingerMove(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395005360")) {
            ipChange.ipc$dispatch("-395005360", new Object[]{this, Integer.valueOf(i)});
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
        return AndroidInstantRuntime.support(ipChange, "-1742387986") ? ((Integer) ipChange.ipc$dispatch("-1742387986", new Object[]{this, motionEvent, Integer.valueOf(i)})).intValue() : (int) (MotionEventCompat.getX(motionEvent, i) + 0.5f);
    }

    private int getMotionEventY(MotionEvent motionEvent, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1391588049") ? ((Integer) ipChange.ipc$dispatch("-1391588049", new Object[]{this, motionEvent, Integer.valueOf(i)})).intValue() : (int) (MotionEventCompat.getY(motionEvent, i) + 0.5f);
    }

    private String getStatusLog(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-949766354") ? (String) ipChange.ipc$dispatch("-949766354", new Object[]{this, Integer.valueOf(i)}) : i != 0 ? i != 1 ? i != 2 ? i != 3 ? "status_illegal!" : "status_refreshing" : "status_release_to_refresh" : "status_swiping_to_refresh" : "status_default";
    }

    private boolean isFingerDragging() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "656516943") ? ((Boolean) ipChange.ipc$dispatch("656516943", new Object[]{this})).booleanValue() : getScrollState() == 1;
    }

    private boolean isRefreshTrigger(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-584789904") ? ((Boolean) ipChange.ipc$dispatch("-584789904", new Object[]{this, view})).booleanValue() : view instanceof RefreshTrigger;
    }

    private void move(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906284999")) {
            ipChange.ipc$dispatch("1906284999", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 0) {
            int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight() + i;
            setRefreshHeaderContainerHeight(measuredHeight);
            this.mRefreshTrigger.onMove(false, false, measuredHeight);
        }
    }

    private void onFingerUpStartAnimating() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962892014")) {
            ipChange.ipc$dispatch("1962892014", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "248982937")) {
            ipChange.ipc$dispatch("248982937", new Object[]{this, motionEvent});
            return;
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i = actionIndex != 0 ? 0 : 1;
            try {
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            this.mLastTouchX = getMotionEventX(motionEvent, i);
            this.mLastTouchY = getMotionEventY(motionEvent, i);
        }
    }

    private void printStatusLog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-526298040")) {
            ipChange.ipc$dispatch("-526298040", new Object[]{this});
        } else {
            hb1.b(TAG, getStatusLog(this.mStatus));
        }
    }

    private void removeLoadMoreFooterView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1177882738")) {
            ipChange.ipc$dispatch("-1177882738", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mLoadMoreFooterContainer;
        if (frameLayout != null) {
            frameLayout.removeView(this.mLoadMoreFooterView);
        }
    }

    private void removeRefreshHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1724886732")) {
            ipChange.ipc$dispatch("-1724886732", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-1497928696")) {
            ipChange.ipc$dispatch("-1497928696", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRefreshHeaderContainer.getLayoutParams().height = i;
        this.mRefreshHeaderContainer.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1842784294")) {
            ipChange.ipc$dispatch("-1842784294", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mStatus = i;
        }
    }

    private void startScrollAnimation(int i, Interpolator interpolator, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1554792582")) {
            ipChange.ipc$dispatch("-1554792582", new Object[]{this, Integer.valueOf(i), interpolator, Integer.valueOf(i2), Integer.valueOf(i3)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1968013451")) {
            ipChange.ipc$dispatch("-1968013451", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onStart(true, this.mRefreshHeaderView.getMeasuredHeight(), this.mRefreshFinalMoveOffset);
        startScrollAnimation(400, new AccelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), this.mRefreshHeaderView.getMeasuredHeight());
    }

    private void startScrollRefreshingStatusToDefaultStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "840025693")) {
            ipChange.ipc$dispatch("840025693", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onComplete();
        startScrollAnimation(400, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
    }

    private void startScrollReleaseStatusToRefreshingStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1587954159")) {
            ipChange.ipc$dispatch("1587954159", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onRelease();
        startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), this.mRefreshHeaderView.getMeasuredHeight());
    }

    private void startScrollSwipingToRefreshStatusToDefaultStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "341299231")) {
            ipChange.ipc$dispatch("341299231", new Object[]{this});
        } else {
            startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
        }
    }

    public void addFooterView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "5001622")) {
            ipChange.ipc$dispatch("5001622", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "-1591389176")) {
            ipChange.ipc$dispatch("-1591389176", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "276758678")) {
            return ((Boolean) ipChange.ipc$dispatch("276758678", new Object[]{this})).booleanValue();
        }
        View view = this.mLoadMoreFooterView;
        if (view == null || !(view instanceof LoadMoreFooterView)) {
            return false;
        }
        return ((LoadMoreFooterView) view).canLoadMore();
    }

    public boolean canTriggerRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1695328018")) {
            return ((Boolean) ipChange.ipc$dispatch("-1695328018", new Object[]{this})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "179666708")) {
            return (LinearLayout) ipChange.ipc$dispatch("179666708", new Object[]{this});
        }
        ensureFooterViewContainer();
        return this.mFooterViewContainer;
    }

    public LinearLayout getHeaderContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985499654")) {
            return (LinearLayout) ipChange.ipc$dispatch("1985499654", new Object[]{this});
        }
        ensureHeaderViewContainer();
        return this.mHeaderViewContainer;
    }

    public RecyclerView.Adapter getIAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1530223325") ? (RecyclerView.Adapter) ipChange.ipc$dispatch("1530223325", new Object[]{this}) : ((WrapperAdapter) getAdapter()).a();
    }

    public View getLoadMoreFooterView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-213650738") ? (View) ipChange.ipc$dispatch("-213650738", new Object[]{this}) : this.mLoadMoreFooterView;
    }

    public View getRefreshHeaderView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-807712200") ? (View) ipChange.ipc$dispatch("-807712200", new Object[]{this}) : this.mRefreshHeaderView;
    }

    public WrapperAdapter getWrapAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1686513084") ? (WrapperAdapter) ipChange.ipc$dispatch("-1686513084", new Object[]{this}) : (WrapperAdapter) getAdapter();
    }

    @Override // cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110634056")) {
            return ((Boolean) ipChange.ipc$dispatch("-110634056", new Object[]{this, motionEvent})).booleanValue();
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
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex < 0) {
                return false;
            }
            int round = Math.round(MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
            int round2 = Math.round(MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
            if (getScrollState() != 1) {
                int i = round - this.mLastTouchX;
                int i2 = round2 - this.mLastTouchY;
                boolean z = getLayoutManager().canScrollHorizontally() && Math.abs(i) > this.mTouchSlop && (getLayoutManager().canScrollVertically() || Math.abs(i) > Math.abs(i2));
                if (getLayoutManager().canScrollVertically() && Math.abs(i2) > this.mTouchSlop && (getLayoutManager().canScrollHorizontally() || Math.abs(i2) > Math.abs(i))) {
                    z = true;
                }
                return z && super.onInterceptTouchEvent(motionEvent);
            }
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
        if (AndroidInstantRuntime.support(ipChange, "-690907714")) {
            ipChange.ipc$dispatch("-690907714", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        View view = this.mRefreshHeaderView;
        if (view == null || view.getMeasuredHeight() <= this.mRefreshFinalMoveOffset) {
            return;
        }
        this.mRefreshFinalMoveOffset = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00db, code lost:
        if (r8.mStatus == 0) goto L20;
     */
    @Override // cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.nestedscroll.recyclerview.HomePageRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "439126074")) {
            ipChange.ipc$dispatch("439126074", new Object[]{this, Boolean.valueOf(z)});
        } else {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150865780")) {
            ipChange.ipc$dispatch("-1150865780", new Object[]{this, adapter});
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
        if (AndroidInstantRuntime.support(ipChange, "-1417361983")) {
            ipChange.ipc$dispatch("-1417361983", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.intercept = z;
        }
    }

    public void setIsAutoToDefault(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755167570")) {
            ipChange.ipc$dispatch("1755167570", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsAutoToDefault = z;
        }
    }

    public void setLoadMoreEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795707157")) {
            ipChange.ipc$dispatch("-1795707157", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mLoadMoreEnabled = z;
        if (z) {
            OnLoadMoreScrollListener onLoadMoreScrollListener = this.mOnLoadMoreScrollListener;
            if (onLoadMoreScrollListener == null) {
                this.mOnLoadMoreScrollListener = new OnLoadMoreScrollListener() { // from class: cn.damai.homepage.nestedscroll.recyclerview.HomePageRecyclerView.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.uikit.irecycler.OnLoadMoreScrollListener
                    public void b(RecyclerView recyclerView) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-31393449")) {
                            ipChange2.ipc$dispatch("-31393449", new Object[]{this, recyclerView});
                        } else if (HomePageRecyclerView.this.mOnLoadMoreListener == null || HomePageRecyclerView.this.mStatus != 0) {
                        } else {
                            HomePageRecyclerView.this.mOnLoadMoreListener.onLoadMore(HomePageRecyclerView.this.mLoadMoreFooterView);
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
        if (AndroidInstantRuntime.support(ipChange, "-1229594414")) {
            ipChange.ipc$dispatch("-1229594414", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "940446356")) {
            ipChange.ipc$dispatch("940446356", new Object[]{this, status});
            return;
        }
        View view = this.mLoadMoreFooterView;
        if (view == null || !(view instanceof LoadMoreFooterView)) {
            return;
        }
        ((LoadMoreFooterView) view).setStatus(status);
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236681577")) {
            ipChange.ipc$dispatch("-1236681577", new Object[]{this, onLoadMoreListener});
        } else {
            this.mOnLoadMoreListener = onLoadMoreListener;
        }
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910107667")) {
            ipChange.ipc$dispatch("-1910107667", new Object[]{this, onRefreshListener});
        } else {
            this.mOnRefreshListener = onRefreshListener;
        }
    }

    public void setRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950480481")) {
            ipChange.ipc$dispatch("-1950480481", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mRefreshEnabled = z;
        }
    }

    public void setRefreshFinalMoveOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1125344999")) {
            ipChange.ipc$dispatch("1125344999", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mRefreshFinalMoveOffset = i;
        }
    }

    public void setRefreshHeaderView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112640784")) {
            ipChange.ipc$dispatch("112640784", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "335973216")) {
            ipChange.ipc$dispatch("335973216", new Object[]{this, Boolean.valueOf(z)});
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
            hb1.a(str, "isRefresh = " + z + " current status = " + this.mStatus);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679155380")) {
            ipChange.ipc$dispatch("-1679155380", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setScrollingTouchSlop(i);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.mContext);
        if (i == 0) {
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else if (i != 1) {
        } else {
            this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    public HomePageRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomePageRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.refreshHeaderLayoutRes = -1;
        this.loadMoreFooterLayoutRes = -1;
        this.mActivePointerId = -1;
        this.mLastTouchX = 0;
        this.mLastTouchY = 0;
        this.mAnimatorUpdateListener = new C1147a();
        this.mAnimationListener = new C1148b();
        this.mRefreshTrigger = new C1149c();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledEdgeSlop();
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IRecyclerView, i, 0);
        try {
            boolean z = obtainStyledAttributes.getBoolean(R$styleable.IRecyclerView_refreshEnabled, false);
            boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.IRecyclerView_loadMoreEnabled, false);
            this.refreshHeaderLayoutRes = obtainStyledAttributes.getResourceId(R$styleable.IRecyclerView_refreshHeaderLayout, -1);
            this.loadMoreFooterLayoutRes = obtainStyledAttributes.getResourceId(R$styleable.IRecyclerView_loadMoreFooterLayout, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.IRecyclerView_refreshFinalMoveOffset, -1);
            obtainStyledAttributes.recycle();
            setRefreshEnabled(z);
            setLoadMoreEnabled(z2);
            int i2 = this.refreshHeaderLayoutRes;
            if (i2 != -1) {
                setRefreshHeaderView(i2);
            } else {
                int i3 = R$layout.layout_irecyclerview_classic_refresh_header;
                this.refreshHeaderLayoutRes = i3;
                setRefreshHeaderView(i3);
            }
            int i4 = this.loadMoreFooterLayoutRes;
            if (i4 != -1) {
                setLoadMoreFooterView(i4);
            } else {
                int i5 = R$layout.layout_irecyclerview_load_more_footer;
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
        if (AndroidInstantRuntime.support(ipChange, "-403596541")) {
            ipChange.ipc$dispatch("-403596541", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "341389505")) {
            ipChange.ipc$dispatch("341389505", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ensureRefreshHeaderContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mRefreshHeaderContainer, false);
        if (inflate != null) {
            setRefreshHeaderView(inflate);
        }
    }
}
