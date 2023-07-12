package cn.damai.uikit.irecycler;

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
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.uikit.irecycler.widget.LoadMoreView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.pw2;
import tb.vc2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DamaiRootRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final boolean DEBUG = false;
    private static final int STATUS_DEFAULT = 0;
    private static final int STATUS_REFRESHING = 3;
    private static final int STATUS_RELEASE_TO_REFRESH = 2;
    private static final int STATUS_SWIPING_TO_REFRESH = 1;
    private static final String TAG = IRecyclerView.class.getSimpleName();
    private boolean intercept;
    private boolean keepListenLoadMore;
    @LayoutRes
    int loadMoreFooterLayoutRes;
    private int mActivePointerId;
    Animator.AnimatorListener mAnimationListener;
    ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private Context mContext;
    public LinearLayout mFooterViewContainer;
    public LinearLayout mHeaderViewContainer;
    private boolean mIsAutoRefreshing;
    private boolean mIsAutoToDefault;
    private int mLastTouchX;
    private int mLastTouchY;
    private boolean mLoadMoreEnabled;
    public FrameLayout mLoadMoreFooterContainer;
    private View mLoadMoreFooterView;
    private OnLoadMoreListener mOnLoadMoreListener;
    private OnLoadMoreScrollListener mOnLoadMoreScrollListener;
    private OnRefreshListener mOnRefreshListener;
    private boolean mRefreshEnabled;
    private int mRefreshFinalMoveOffset;
    public RefreshHeaderLayout mRefreshHeaderContainer;
    private View mRefreshHeaderView;
    RefreshTrigger mRefreshTrigger;
    ValueAnimator mScrollAnimator;
    private int mStatus;
    private int mTouchSlop;
    @LayoutRes
    int refreshHeaderLayoutRes;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1196951402")) {
                ipChange.ipc$dispatch("1196951402", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            DamaiRootRecyclerView.this.setRefreshHeaderContainerHeight(intValue);
            int i = DamaiRootRecyclerView.this.mStatus;
            if (i == 1) {
                DamaiRootRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (i == 2) {
                DamaiRootRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (i != 3) {
            } else {
                DamaiRootRecyclerView.this.mRefreshTrigger.onMove(true, true, intValue);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b extends vc2 {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-959605350")) {
                ipChange.ipc$dispatch("-959605350", new Object[]{this, animator});
                return;
            }
            int unused = DamaiRootRecyclerView.this.mStatus;
            int i = DamaiRootRecyclerView.this.mStatus;
            if (i == 1) {
                if (DamaiRootRecyclerView.this.mIsAutoRefreshing) {
                    DamaiRootRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = DamaiRootRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                    DamaiRootRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                    DamaiRootRecyclerView.this.setStatus(3);
                    if (DamaiRootRecyclerView.this.mOnRefreshListener != null) {
                        DamaiRootRecyclerView.this.mOnRefreshListener.onRefresh();
                        DamaiRootRecyclerView.this.mRefreshTrigger.onRefresh();
                        return;
                    }
                    return;
                }
                DamaiRootRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                DamaiRootRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                DamaiRootRecyclerView.this.setStatus(0);
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                DamaiRootRecyclerView.this.mIsAutoRefreshing = false;
                DamaiRootRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                DamaiRootRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                DamaiRootRecyclerView.this.setStatus(0);
                DamaiRootRecyclerView.this.mRefreshTrigger.onReset();
            } else {
                if (!DamaiRootRecyclerView.this.mIsAutoToDefault) {
                    DamaiRootRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = DamaiRootRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                    DamaiRootRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                    DamaiRootRecyclerView.this.setStatus(3);
                } else {
                    DamaiRootRecyclerView.this.setStatus(0);
                }
                if (DamaiRootRecyclerView.this.mOnRefreshListener != null) {
                    DamaiRootRecyclerView.this.mOnRefreshListener.onRefresh();
                    DamaiRootRecyclerView.this.mRefreshTrigger.onRefresh();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c implements RefreshTrigger {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onComplete() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "458191548")) {
                ipChange.ipc$dispatch("458191548", new Object[]{this});
            } else if (DamaiRootRecyclerView.this.mRefreshHeaderView == null || !(DamaiRootRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) DamaiRootRecyclerView.this.mRefreshHeaderView).onComplete();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onMove(boolean z, boolean z2, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2003217185")) {
                ipChange.ipc$dispatch("-2003217185", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)});
            } else if (DamaiRootRecyclerView.this.mRefreshHeaderView == null || !(DamaiRootRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) DamaiRootRecyclerView.this.mRefreshHeaderView).onMove(z, z2, i);
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "511194010")) {
                ipChange.ipc$dispatch("511194010", new Object[]{this});
            } else if (DamaiRootRecyclerView.this.mRefreshHeaderView == null || !(DamaiRootRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) DamaiRootRecyclerView.this.mRefreshHeaderView).onRefresh();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onRelease() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-684097810")) {
                ipChange.ipc$dispatch("-684097810", new Object[]{this});
            } else if (DamaiRootRecyclerView.this.mRefreshHeaderView == null || !(DamaiRootRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) DamaiRootRecyclerView.this.mRefreshHeaderView).onRelease();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onReset() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1529422682")) {
                ipChange.ipc$dispatch("-1529422682", new Object[]{this});
            } else if (DamaiRootRecyclerView.this.mRefreshHeaderView == null || !(DamaiRootRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) DamaiRootRecyclerView.this.mRefreshHeaderView).onReset();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onStart(boolean z, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1228313761")) {
                ipChange.ipc$dispatch("1228313761", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (DamaiRootRecyclerView.this.mRefreshHeaderView == null || !(DamaiRootRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
            } else {
                ((RefreshTrigger) DamaiRootRecyclerView.this.mRefreshHeaderView).onStart(z, i, i2);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LoadMoreView.Status.values().length];
            a = iArr;
            try {
                iArr[LoadMoreView.Status.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LoadMoreView.Status.GONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LoadMoreView.Status.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LoadMoreView.Status.THE_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LoadMoreView.Status.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public DamaiRootRecyclerView(Context context) {
        this(context, null);
    }

    private void ensureFooterViewContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-667014237")) {
            ipChange.ipc$dispatch("-667014237", new Object[]{this});
        } else if (this.mFooterViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mFooterViewContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.mFooterViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureHeaderViewContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506448747")) {
            ipChange.ipc$dispatch("-506448747", new Object[]{this});
        } else if (this.mHeaderViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mHeaderViewContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.mHeaderViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureLoadMoreFooterContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741943015")) {
            ipChange.ipc$dispatch("-1741943015", new Object[]{this});
        } else if (this.mLoadMoreFooterContainer == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.mLoadMoreFooterContainer = frameLayout;
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureRefreshHeaderContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "653189389")) {
            ipChange.ipc$dispatch("653189389", new Object[]{this});
        } else if (this.mRefreshHeaderContainer == null) {
            RefreshHeaderLayout refreshHeaderLayout = new RefreshHeaderLayout(getContext());
            this.mRefreshHeaderContainer = refreshHeaderLayout;
            refreshHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        }
    }

    private void fingerMove(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111882951")) {
            ipChange.ipc$dispatch("-2111882951", new Object[]{this, Integer.valueOf(i)});
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
        return AndroidInstantRuntime.support(ipChange, "2123636965") ? ((Integer) ipChange.ipc$dispatch("2123636965", new Object[]{this, motionEvent, Integer.valueOf(i)})).intValue() : (int) (MotionEventCompat.getX(motionEvent, i) + 0.5f);
    }

    private int getMotionEventY(MotionEvent motionEvent, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1820530394") ? ((Integer) ipChange.ipc$dispatch("-1820530394", new Object[]{this, motionEvent, Integer.valueOf(i)})).intValue() : (int) (MotionEventCompat.getY(motionEvent, i) + 0.5f);
    }

    private String getStatusLog(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1912311205") ? (String) ipChange.ipc$dispatch("1912311205", new Object[]{this, Integer.valueOf(i)}) : i != 0 ? i != 1 ? i != 2 ? i != 3 ? "status_illegal!" : "status_refreshing" : "status_release_to_refresh" : "status_swiping_to_refresh" : "status_default";
    }

    private boolean isFingerDragging() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1051986438") ? ((Boolean) ipChange.ipc$dispatch("1051986438", new Object[]{this})).booleanValue() : getScrollState() == 1;
    }

    private boolean isRefreshTrigger(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "823356505") ? ((Boolean) ipChange.ipc$dispatch("823356505", new Object[]{this, view})).booleanValue() : view instanceof RefreshTrigger;
    }

    private void move(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546665104")) {
            ipChange.ipc$dispatch("-1546665104", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 0) {
            int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight() + i;
            setRefreshHeaderContainerHeight(measuredHeight);
            this.mRefreshTrigger.onMove(false, false, measuredHeight);
        }
    }

    private void onFingerUpStartAnimating() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167450277")) {
            ipChange.ipc$dispatch("167450277", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "562983746")) {
            ipChange.ipc$dispatch("562983746", new Object[]{this, motionEvent});
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
        if (AndroidInstantRuntime.support(ipChange, "738916543")) {
            ipChange.ipc$dispatch("738916543", new Object[]{this});
        } else {
            pw2.d(TAG, getStatusLog(this.mStatus));
        }
    }

    private void removeLoadMoreFooterView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1321642821")) {
            ipChange.ipc$dispatch("1321642821", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mLoadMoreFooterContainer;
        if (frameLayout != null) {
            frameLayout.removeView(this.mLoadMoreFooterView);
        }
    }

    private void removeRefreshHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367162211")) {
            ipChange.ipc$dispatch("-1367162211", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "179536063")) {
            ipChange.ipc$dispatch("179536063", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRefreshHeaderContainer.getLayoutParams().height = i;
        this.mRefreshHeaderContainer.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426968529")) {
            ipChange.ipc$dispatch("1426968529", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mStatus = i;
        }
    }

    private void startScrollAnimation(int i, Interpolator interpolator, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "994454449")) {
            ipChange.ipc$dispatch("994454449", new Object[]{this, Integer.valueOf(i), interpolator, Integer.valueOf(i2), Integer.valueOf(i3)});
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
        if (AndroidInstantRuntime.support(ipChange, "1898011500")) {
            ipChange.ipc$dispatch("1898011500", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onStart(true, this.mRefreshHeaderView.getMeasuredHeight(), this.mRefreshFinalMoveOffset);
        startScrollAnimation(400, new AccelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), this.mRefreshHeaderView.getMeasuredHeight());
    }

    private void startScrollRefreshingStatusToDefaultStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411083348")) {
            ipChange.ipc$dispatch("411083348", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onComplete();
        startScrollAnimation(400, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
    }

    private void startScrollReleaseStatusToRefreshingStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159011814")) {
            ipChange.ipc$dispatch("1159011814", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onRelease();
        startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), this.mRefreshHeaderView.getMeasuredHeight());
    }

    private void startScrollSwipingToRefreshStatusToDefaultStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283535658")) {
            ipChange.ipc$dispatch("-283535658", new Object[]{this});
        } else {
            startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
        }
    }

    public void addFooterView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1682466381")) {
            ipChange.ipc$dispatch("1682466381", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "86075583")) {
            ipChange.ipc$dispatch("86075583", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "-1440118913")) {
            return ((Boolean) ipChange.ipc$dispatch("-1440118913", new Object[]{this})).booleanValue();
        }
        View view = this.mLoadMoreFooterView;
        if (view == null || !(view instanceof LoadMoreFooterView)) {
            return false;
        }
        return ((LoadMoreFooterView) view).canLoadMore();
    }

    public boolean canTriggerRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974291735")) {
            return ((Boolean) ipChange.ipc$dispatch("1974291735", new Object[]{this})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "634881931")) {
            return (LinearLayout) ipChange.ipc$dispatch("634881931", new Object[]{this});
        }
        ensureFooterViewContainer();
        return this.mFooterViewContainer;
    }

    public LinearLayout getHeaderContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1854252419")) {
            return (LinearLayout) ipChange.ipc$dispatch("-1854252419", new Object[]{this});
        }
        ensureHeaderViewContainer();
        return this.mHeaderViewContainer;
    }

    public RecyclerView.Adapter getIAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1047497338") ? (RecyclerView.Adapter) ipChange.ipc$dispatch("-1047497338", new Object[]{this}) : ((WrapperAdapter) getAdapter()).a();
    }

    public View getLoadMoreFooterView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "893415991") ? (View) ipChange.ipc$dispatch("893415991", new Object[]{this}) : this.mLoadMoreFooterView;
    }

    public View getRefreshHeaderView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "336378287") ? (View) ipChange.ipc$dispatch("336378287", new Object[]{this}) : this.mRefreshHeaderView;
    }

    public WrapperAdapter getWrapAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2082243653") ? (WrapperAdapter) ipChange.ipc$dispatch("-2082243653", new Object[]{this}) : (WrapperAdapter) getAdapter();
    }

    public void initContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-162716299")) {
            ipChange.ipc$dispatch("-162716299", new Object[]{this});
            return;
        }
        ensureRefreshHeaderContainer();
        ensureHeaderViewContainer();
        ensureFooterViewContainer();
        ensureLoadMoreFooterContainer();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116135969")) {
            return ((Boolean) ipChange.ipc$dispatch("1116135969", new Object[]{this, motionEvent})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "1887181991")) {
            ipChange.ipc$dispatch("1887181991", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.uikit.irecycler.DamaiRootRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847272483")) {
            ipChange.ipc$dispatch("1847272483", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566380853")) {
            ipChange.ipc$dispatch("566380853", new Object[]{this, adapter});
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
        if (AndroidInstantRuntime.support(ipChange, "-1241480982")) {
            ipChange.ipc$dispatch("-1241480982", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.intercept = z;
        }
    }

    public void setIsAutoToDefault(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091600187")) {
            ipChange.ipc$dispatch("2091600187", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsAutoToDefault = z;
        }
    }

    public void setKeepListenLoadMore(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1821070039")) {
            ipChange.ipc$dispatch("1821070039", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.keepListenLoadMore = z;
        }
    }

    public void setLoadMoreEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459274540")) {
            ipChange.ipc$dispatch("-1459274540", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mLoadMoreEnabled = z;
        if (z) {
            OnLoadMoreScrollListener onLoadMoreScrollListener = this.mOnLoadMoreScrollListener;
            if (onLoadMoreScrollListener == null) {
                this.mOnLoadMoreScrollListener = new OnLoadMoreScrollListener() { // from class: cn.damai.uikit.irecycler.DamaiRootRecyclerView.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.uikit.irecycler.OnLoadMoreScrollListener
                    public void b(RecyclerView recyclerView) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "585860800")) {
                            ipChange2.ipc$dispatch("585860800", new Object[]{this, recyclerView});
                        } else if (DamaiRootRecyclerView.this.mOnLoadMoreListener != null && DamaiRootRecyclerView.this.mStatus == 0 && DamaiRootRecyclerView.this.keepListenLoadMore) {
                            DamaiRootRecyclerView.this.mOnLoadMoreListener.onLoadMore(DamaiRootRecyclerView.this.mLoadMoreFooterView);
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
        if (AndroidInstantRuntime.support(ipChange, "-1270264183")) {
            ipChange.ipc$dispatch("-1270264183", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "-1440272181")) {
            ipChange.ipc$dispatch("-1440272181", new Object[]{this, status});
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
        if (AndroidInstantRuntime.support(ipChange, "-1892555890")) {
            ipChange.ipc$dispatch("-1892555890", new Object[]{this, onLoadMoreListener});
        } else {
            this.mOnLoadMoreListener = onLoadMoreListener;
        }
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771126620")) {
            ipChange.ipc$dispatch("-771126620", new Object[]{this, onRefreshListener});
        } else {
            this.mOnRefreshListener = onRefreshListener;
        }
    }

    public void setRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138582166")) {
            ipChange.ipc$dispatch("138582166", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mRefreshEnabled = z;
        }
    }

    public void setRefreshFinalMoveOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012278562")) {
            ipChange.ipc$dispatch("-2012278562", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mRefreshFinalMoveOffset = i;
        }
    }

    public void setRefreshHeaderView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1219707513")) {
            ipChange.ipc$dispatch("1219707513", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "1601187799")) {
            ipChange.ipc$dispatch("1601187799", new Object[]{this, Boolean.valueOf(z)});
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
            pw2.b(str, "isRefresh = " + z + " current status = " + this.mStatus);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826236099")) {
            ipChange.ipc$dispatch("826236099", new Object[]{this, Integer.valueOf(i)});
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

    public void setWrapperAdapter(WrapperAdapter wrapperAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750182834")) {
            ipChange.ipc$dispatch("-750182834", new Object[]{this, wrapperAdapter});
        } else {
            super.setAdapter(wrapperAdapter);
        }
    }

    public DamaiRootRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DamaiRootRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.refreshHeaderLayoutRes = -1;
        this.loadMoreFooterLayoutRes = -1;
        this.keepListenLoadMore = true;
        this.mActivePointerId = -1;
        this.mLastTouchX = 0;
        this.mLastTouchY = 0;
        this.mAnimatorUpdateListener = new a();
        this.mAnimationListener = new b();
        this.mRefreshTrigger = new c();
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

    public void setLoadMoreStatus(LoadMoreView.Status status, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471636262")) {
            ipChange.ipc$dispatch("-471636262", new Object[]{this, status, str});
            return;
        }
        View view = this.mLoadMoreFooterView;
        if (view == null || !(view instanceof LoadMoreView)) {
            return;
        }
        int i = d.a[status.ordinal()];
        if (i == 1) {
            setKeepListenLoadMore(true);
        } else if (i == 2) {
            setKeepListenLoadMore(false);
        } else if (i == 3) {
            setKeepListenLoadMore(false);
        } else if (i == 4) {
            setKeepListenLoadMore(false);
        } else if (i == 5) {
            setKeepListenLoadMore(true);
        }
        ((LoadMoreView) this.mLoadMoreFooterView).setStatus(status, str);
    }

    public void setLoadMoreFooterView(@LayoutRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101794938")) {
            ipChange.ipc$dispatch("2101794938", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "1530587242")) {
            ipChange.ipc$dispatch("1530587242", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ensureRefreshHeaderContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mRefreshHeaderContainer, false);
        if (inflate != null) {
            setRefreshHeaderView(inflate);
        }
    }
}
