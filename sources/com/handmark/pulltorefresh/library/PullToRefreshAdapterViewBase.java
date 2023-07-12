package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$styleable;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.handmark.pulltorefresh.library.internal.IndicatorLayout;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {
    private View mEmptyView;
    private IndicatorLayout mIndicatorIvBottom;
    private IndicatorLayout mIndicatorIvTop;
    private PullToRefreshBase.OnLastItemVisibleListener mOnLastItemVisibleListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mSavedLastVisibleIndex;
    private boolean mScrollEmptyView;
    private boolean mShowIndicator;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_UP_TO_REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_DOWN_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        this.mSavedLastVisibleIndex = -1;
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    private void addIndicatorViews() {
        IndicatorLayout indicatorLayout;
        IndicatorLayout indicatorLayout2;
        PullToRefreshBase.Mode mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.canPullDown() && this.mIndicatorIvTop == null) {
            this.mIndicatorIvTop = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_DOWN_TO_REFRESH);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R$dimen.indicator_right_padding);
            layoutParams.gravity = 53;
            refreshableViewWrapper.addView(this.mIndicatorIvTop, layoutParams);
        } else if (!mode.canPullDown() && (indicatorLayout = this.mIndicatorIvTop) != null) {
            refreshableViewWrapper.removeView(indicatorLayout);
            this.mIndicatorIvTop = null;
        }
        if (mode.canPullUp() && this.mIndicatorIvBottom == null) {
            this.mIndicatorIvBottom = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_UP_TO_REFRESH);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = getResources().getDimensionPixelSize(R$dimen.indicator_right_padding);
            layoutParams2.gravity = 85;
            refreshableViewWrapper.addView(this.mIndicatorIvBottom, layoutParams2);
        } else if (mode.canPullUp() || (indicatorLayout2 = this.mIndicatorIvBottom) == null) {
        } else {
            refreshableViewWrapper.removeView(indicatorLayout2);
            this.mIndicatorIvBottom = null;
        }
    }

    private boolean getShowIndicatorInternal() {
        return this.mShowIndicator && isPullToRefreshEnabled();
    }

    private boolean isFirstItemVisible() {
        View childAt;
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        return ((AbsListView) this.mRefreshableView).getFirstVisiblePosition() == 0 && (childAt = ((AbsListView) this.mRefreshableView).getChildAt(0)) != null && childAt.getTop() >= ((AbsListView) this.mRefreshableView).getTop();
    }

    private boolean isLastItemVisible() {
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = ((AbsListView) this.mRefreshableView).getLastVisiblePosition();
        if (lastVisiblePosition >= (((AbsListView) this.mRefreshableView).getCount() - 1) - 1) {
            View childAt = ((AbsListView) this.mRefreshableView).getChildAt(lastVisiblePosition - ((AbsListView) this.mRefreshableView).getFirstVisiblePosition());
            return childAt != null && childAt.getBottom() <= ((AbsListView) this.mRefreshableView).getBottom();
        }
        return false;
    }

    private void removeIndicatorViews() {
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
        if (this.mIndicatorIvTop != null) {
            if (!isRefreshing() && isReadyForPullDown()) {
                if (!this.mIndicatorIvTop.isVisible()) {
                    this.mIndicatorIvTop.show();
                }
            } else if (this.mIndicatorIvTop.isVisible()) {
                this.mIndicatorIvTop.hide();
            }
        }
        if (this.mIndicatorIvBottom != null) {
            if (!isRefreshing() && isReadyForPullUp()) {
                if (this.mIndicatorIvBottom.isVisible()) {
                    return;
                }
                this.mIndicatorIvBottom.show();
            } else if (this.mIndicatorIvBottom.isVisible()) {
                this.mIndicatorIvBottom.hide();
            }
        }
    }

    @Override // android.view.View
    public abstract ContextMenu.ContextMenuInfo getContextMenuInfo();

    public boolean getShowIndicator() {
        return this.mShowIndicator;
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected void handleStyledAttributes(TypedArray typedArray) {
        this.mShowIndicator = typedArray.getBoolean(R$styleable.PullToRefresh_ptrShowIndicator, !isPullToRefreshOverScrollEnabled());
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        return isFirstItemVisible();
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        return isLastItemVisible();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void onPullToRefresh() {
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
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void onReleaseToRefresh() {
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

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener = this.mOnLastItemVisibleListener;
        if (onLastItemVisibleListener != null) {
            int i4 = i + i2;
            if (i2 > 0 && i4 + 1 == i3 && i4 != this.mSavedLastVisibleIndex) {
                this.mSavedLastVisibleIndex = i4;
                onLastItemVisibleListener.onLastItemVisible();
            }
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
        super.onScrollChanged(i, i2, i3, i4);
        View view = this.mEmptyView;
        if (view == null || this.mScrollEmptyView) {
            return;
        }
        view.scrollTo(-i, -i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void resetHeader() {
        super.resetHeader();
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        ((AbsListView) this.mRefreshableView).setAdapter(listAdapter);
    }

    public final void setEmptyView(View view) {
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        View view2 = this.mEmptyView;
        if (view2 != null) {
            refreshableViewWrapper.removeView(view2);
        }
        if (view != null) {
            view.setClickable(true);
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            refreshableViewWrapper.addView(view, -1, -1);
            T t = this.mRefreshableView;
            if (t instanceof EmptyViewMethodAccessor) {
                ((EmptyViewMethodAccessor) t).setEmptyViewInternal(view);
            } else {
                ((AbsListView) t).setEmptyView(view);
            }
            this.mEmptyView = view;
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ((AbsListView) this.mRefreshableView).setOnItemClickListener(onItemClickListener);
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener) {
        this.mOnLastItemVisibleListener = onLastItemVisibleListener;
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void setRefreshingInternal(boolean z) {
        super.setRefreshingInternal(z);
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    public final void setScrollEmptyView(boolean z) {
        this.mScrollEmptyView = z;
    }

    public void setShowIndicator(boolean z) {
        this.mShowIndicator = z;
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void updateUIForMode() {
        super.updateUIForMode();
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSavedLastVisibleIndex = -1;
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        this.mSavedLastVisibleIndex = -1;
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }
}
