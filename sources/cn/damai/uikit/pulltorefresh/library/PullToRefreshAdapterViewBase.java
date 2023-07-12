package cn.damai.uikit.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import cn.damai.uikit.R$dimen;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import cn.damai.uikit.pulltorefresh.library.internal.IndicatorLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View mEmptyView;
    private IndicatorLayout mIndicatorIvBottom;
    private IndicatorLayout mIndicatorIvTop;
    private boolean mLastItemVisible;
    private PullToRefreshBase.OnLastItemVisibleListener mOnLastItemVisibleListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private boolean mScrollEmptyView;
    private boolean mShowIndicator;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    private void addIndicatorViews() {
        IndicatorLayout indicatorLayout;
        IndicatorLayout indicatorLayout2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656217357")) {
            ipChange.ipc$dispatch("-1656217357", new Object[]{this});
            return;
        }
        PullToRefreshBase.Mode mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.showHeaderLoadingLayout() && this.mIndicatorIvTop == null) {
            this.mIndicatorIvTop = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R$dimen.margin_10dp);
            layoutParams.gravity = 53;
            refreshableViewWrapper.addView(this.mIndicatorIvTop, layoutParams);
        } else if (!mode.showHeaderLoadingLayout() && (indicatorLayout = this.mIndicatorIvTop) != null) {
            refreshableViewWrapper.removeView(indicatorLayout);
            this.mIndicatorIvTop = null;
        }
        if (mode.showFooterLoadingLayout() && this.mIndicatorIvBottom == null) {
            this.mIndicatorIvBottom = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = getResources().getDimensionPixelSize(R$dimen.margin_10dp);
            layoutParams2.gravity = 85;
            refreshableViewWrapper.addView(this.mIndicatorIvBottom, layoutParams2);
        } else if (mode.showFooterLoadingLayout() || (indicatorLayout2 = this.mIndicatorIvBottom) == null) {
        } else {
            refreshableViewWrapper.removeView(indicatorLayout2);
            this.mIndicatorIvBottom = null;
        }
    }

    private static FrameLayout.LayoutParams convertEmptyViewLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499731902")) {
            return (FrameLayout.LayoutParams) ipChange.ipc$dispatch("499731902", new Object[]{layoutParams});
        }
        FrameLayout.LayoutParams layoutParams2 = null;
        if (layoutParams != null) {
            layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                layoutParams2.gravity = ((LinearLayout.LayoutParams) layoutParams).gravity;
            } else {
                layoutParams2.gravity = 17;
            }
        }
        return layoutParams2;
    }

    private boolean getShowIndicatorInternal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-929604030") ? ((Boolean) ipChange.ipc$dispatch("-929604030", new Object[]{this})).booleanValue() : this.mShowIndicator && isPullToRefreshEnabled();
    }

    private boolean isFirstItemVisible() {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12988382")) {
            return ((Boolean) ipChange.ipc$dispatch("-12988382", new Object[]{this})).booleanValue();
        }
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter != null && !adapter.isEmpty()) {
            return ((AbsListView) this.mRefreshableView).getFirstVisiblePosition() <= 1 && (childAt = ((AbsListView) this.mRefreshableView).getChildAt(0)) != null && childAt.getTop() >= ((AbsListView) this.mRefreshableView).getTop();
        }
        Log.d("PullToRefresh", "isFirstItemVisible. Empty View.");
        return true;
    }

    private boolean isLastItemVisible() {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674594904")) {
            return ((Boolean) ipChange.ipc$dispatch("1674594904", new Object[]{this})).booleanValue();
        }
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter != null && !adapter.isEmpty()) {
            int count = ((AbsListView) this.mRefreshableView).getCount() - 1;
            int lastVisiblePosition = ((AbsListView) this.mRefreshableView).getLastVisiblePosition();
            Log.d("PullToRefresh", "isLastItemVisible. Last Item Position: " + count + " Last Visible Pos: " + lastVisiblePosition);
            return lastVisiblePosition >= count - 1 && (childAt = ((AbsListView) this.mRefreshableView).getChildAt(lastVisiblePosition - ((AbsListView) this.mRefreshableView).getFirstVisiblePosition())) != null && childAt.getBottom() <= ((AbsListView) this.mRefreshableView).getBottom();
        }
        Log.d("PullToRefresh", "isLastItemVisible. Empty View.");
        return true;
    }

    private void removeIndicatorViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1968990836")) {
            ipChange.ipc$dispatch("1968990836", new Object[]{this});
            return;
        }
        if (this.mIndicatorIvTop != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvTop);
            this.mIndicatorIvTop = null;
        }
        if (this.mIndicatorIvBottom != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvBottom);
            this.mIndicatorIvBottom = null;
        }
    }

    private void updateIndicatorViewsVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "399298525")) {
            ipChange.ipc$dispatch("399298525", new Object[]{this});
            return;
        }
        if (this.mIndicatorIvTop != null) {
            if (!isRefreshing() && isReadyForPullStart()) {
                if (!this.mIndicatorIvTop.isVisible()) {
                    this.mIndicatorIvTop.show();
                }
            } else if (this.mIndicatorIvTop.isVisible()) {
                this.mIndicatorIvTop.hide();
            }
        }
        if (this.mIndicatorIvBottom != null) {
            if (!isRefreshing() && isReadyForPullEnd()) {
                if (this.mIndicatorIvBottom.isVisible()) {
                    return;
                }
                this.mIndicatorIvBottom.show();
            } else if (this.mIndicatorIvBottom.isVisible()) {
                this.mIndicatorIvBottom.hide();
            }
        }
    }

    public boolean getShowIndicator() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1726183487") ? ((Boolean) ipChange.ipc$dispatch("1726183487", new Object[]{this})).booleanValue() : this.mShowIndicator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void handleStyledAttributes(TypedArray typedArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1008809152")) {
            ipChange.ipc$dispatch("-1008809152", new Object[]{this, typedArray});
        } else {
            this.mShowIndicator = typedArray.getBoolean(R$styleable.PullToRefresh_ptrShowIndicator, !isPullToRefreshOverScrollEnabled());
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullEnd() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1258528017") ? ((Boolean) ipChange.ipc$dispatch("1258528017", new Object[]{this})).booleanValue() : isLastItemVisible();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullStart() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2091116694") ? ((Boolean) ipChange.ipc$dispatch("-2091116694", new Object[]{this})).booleanValue() : isFirstItemVisible();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onPullToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1457371113")) {
            ipChange.ipc$dispatch("-1457371113", new Object[]{this});
            return;
        }
        super.onPullToRefresh();
        if (getShowIndicatorInternal()) {
            int i = a.a[getCurrentMode().ordinal()];
            if (i == 1) {
                this.mIndicatorIvBottom.pullToRefresh();
            } else if (i != 2) {
            } else {
                this.mIndicatorIvTop.pullToRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813680771")) {
            ipChange.ipc$dispatch("1813680771", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onRefreshing(z);
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onReleaseToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1513870721")) {
            ipChange.ipc$dispatch("-1513870721", new Object[]{this});
            return;
        }
        super.onReleaseToRefresh();
        if (getShowIndicatorInternal()) {
            int i = a.a[getCurrentMode().ordinal()];
            if (i == 1) {
                this.mIndicatorIvBottom.releaseToRefresh();
            } else if (i != 2) {
            } else {
                this.mIndicatorIvTop.releaseToRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onReset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756083101")) {
            ipChange.ipc$dispatch("-756083101", new Object[]{this});
            return;
        }
        super.onReset();
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "512562643")) {
            ipChange.ipc$dispatch("512562643", new Object[]{this, absListView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        Log.d("PullToRefresh", "First Visible: " + i + ". Visible Count: " + i2 + ". Total Items:" + i3);
        if (this.mOnLastItemVisibleListener != null) {
            if (i3 > 0 && i + i2 >= i3 - 1) {
                z = true;
            }
            this.mLastItemVisible = z;
        }
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1622802485")) {
            ipChange.ipc$dispatch("-1622802485", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        View view = this.mEmptyView;
        if (view == null || this.mScrollEmptyView) {
            return;
        }
        view.scrollTo(-i, -i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541814838")) {
            ipChange.ipc$dispatch("541814838", new Object[]{this, absListView, Integer.valueOf(i)});
            return;
        }
        if (i == 0 && (onLastItemVisibleListener = this.mOnLastItemVisibleListener) != null && this.mLastItemVisible) {
            onLastItemVisibleListener.onLastItemVisible();
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091821101")) {
            ipChange.ipc$dispatch("-2091821101", new Object[]{this, listAdapter});
        } else {
            ((AdapterView) this.mRefreshableView).setAdapter(listAdapter);
        }
    }

    public final void setEmptyView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1317862357")) {
            ipChange.ipc$dispatch("-1317862357", new Object[]{this, view});
            return;
        }
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (view != null) {
            view.setClickable(true);
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            FrameLayout.LayoutParams convertEmptyViewLayoutParams = convertEmptyViewLayoutParams(view.getLayoutParams());
            if (convertEmptyViewLayoutParams != null) {
                refreshableViewWrapper.addView(view, convertEmptyViewLayoutParams);
            } else {
                refreshableViewWrapper.addView(view);
            }
        }
        T t = this.mRefreshableView;
        if (t instanceof EmptyViewMethodAccessor) {
            ((EmptyViewMethodAccessor) t).setEmptyViewInternal(view);
        } else {
            ((AbsListView) t).setEmptyView(view);
        }
        this.mEmptyView = view;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758181937")) {
            ipChange.ipc$dispatch("-1758181937", new Object[]{this, onItemClickListener});
        } else {
            ((AbsListView) this.mRefreshableView).setOnItemClickListener(onItemClickListener);
        }
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272225164")) {
            ipChange.ipc$dispatch("-272225164", new Object[]{this, onLastItemVisibleListener});
        } else {
            this.mOnLastItemVisibleListener = onLastItemVisibleListener;
        }
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "984071926")) {
            ipChange.ipc$dispatch("984071926", new Object[]{this, onScrollListener});
        } else {
            this.mOnScrollListener = onScrollListener;
        }
    }

    public final void setScrollEmptyView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636531104")) {
            ipChange.ipc$dispatch("1636531104", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mScrollEmptyView = z;
        }
    }

    public void setShowIndicator(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361202797")) {
            ipChange.ipc$dispatch("1361202797", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mShowIndicator = z;
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void updateUIForMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745297276")) {
            ipChange.ipc$dispatch("-1745297276", new Object[]{this});
            return;
        }
        super.updateUIForMode();
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }
}
