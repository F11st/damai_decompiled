package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baseproject.ui.R$styleable;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {
    public static final String TAG = "PullToRefreshListView";
    private LoadingLayout mFooterLoadingView;
    private LoadingLayout mHeaderLoadingView;
    private FrameLayout mLvFooterLoadingFrame;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class InternalListView extends ListView implements EmptyViewMethodAccessor {
        private boolean mAddedLvFooter;

        public InternalListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mAddedLvFooter = false;
        }

        @Override // android.widget.AbsListView, android.view.View
        public void draw(Canvas canvas) {
            try {
                super.draw(canvas);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.widget.AbsListView, android.view.View
        public ContextMenu.ContextMenuInfo getContextMenuInfo() {
            return super.getContextMenuInfo();
        }

        @Override // android.widget.ListView, android.widget.AbsListView
        protected void layoutChildren() {
            try {
                super.layoutChildren();
            } catch (IllegalStateException unused) {
            } catch (Exception unused2) {
                for (int i = 0; i < getAdapter().getCount(); i++) {
                }
            }
        }

        @Override // android.widget.AdapterView, com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            PullToRefreshListView.this.setEmptyView(view);
        }

        @Override // com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }

        @Override // android.widget.AdapterView
        public void setAdapter(ListAdapter listAdapter) {
            if (!this.mAddedLvFooter) {
                addFooterView(PullToRefreshListView.this.mLvFooterLoadingFrame, null, false);
                this.mAddedLvFooter = true;
            }
            super.setAdapter(listAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @TargetApi(9)
    /* loaded from: classes10.dex */
    public final class InternalListViewSDK9 extends InternalListView {
        public InternalListViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            com.handmark.pulltorefresh.library.a.d(PullToRefreshListView.this, i2, i4, z);
            return overScrollBy;
        }
    }

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

    public PullToRefreshListView(Context context) {
        super(context);
        setDisableScrollingWhileRefreshing(false);
    }

    protected ListView createListView(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 9) {
            return new InternalListViewSDK9(context, attributeSet);
        }
        return new InternalListView(context, attributeSet);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase, android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return ((InternalListView) getRefreshableView()).getContextMenuInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase, com.handmark.pulltorefresh.library.PullToRefreshBase
    public void resetHeader() {
        LoadingLayout footerLayout;
        LoadingLayout loadingLayout;
        int count;
        int footerHeight;
        ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
        if (getShowViewWhileRefreshing() && adapter != null && !adapter.isEmpty()) {
            if (a.a[getCurrentMode().ordinal()] != 1) {
                footerLayout = getHeaderLayout();
                loadingLayout = this.mHeaderLoadingView;
                int i = -getHeaderHeight();
                r2 = Math.abs(((ListView) this.mRefreshableView).getFirstVisiblePosition() - 0) <= 1;
                footerHeight = i;
                count = 0;
            } else {
                footerLayout = getFooterLayout();
                loadingLayout = this.mFooterLoadingView;
                count = ((ListView) this.mRefreshableView).getCount() - 1;
                footerHeight = getFooterHeight();
                if (Math.abs(((ListView) this.mRefreshableView).getLastVisiblePosition() - count) > 1) {
                    r2 = false;
                }
            }
            footerLayout.setVisibility(0);
            if (r2 && getState() != 9 && loadingLayout.getVisibility() == 0) {
                ((ListView) this.mRefreshableView).setSelection(count);
                setHeaderScroll(footerHeight);
            }
            loadingLayout.setVisibility(8);
            super.resetHeader();
            return;
        }
        super.resetHeader();
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase, com.handmark.pulltorefresh.library.IPullToRefresh
    public void setLastUpdatedLabel(CharSequence charSequence) {
        super.setLastUpdatedLabel(charSequence);
        LoadingLayout loadingLayout = this.mHeaderLoadingView;
        if (loadingLayout != null) {
            loadingLayout.setSubHeaderText(charSequence);
        }
        LoadingLayout loadingLayout2 = this.mFooterLoadingView;
        if (loadingLayout2 != null) {
            loadingLayout2.setSubHeaderText(charSequence);
        }
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase, com.handmark.pulltorefresh.library.IPullToRefresh
    public void setLoadingDrawable(Drawable drawable, PullToRefreshBase.Mode mode) {
        super.setLoadingDrawable(drawable, mode);
        if (this.mHeaderLoadingView != null && mode.canPullDown()) {
            this.mHeaderLoadingView.setLoadingDrawable(drawable);
        }
        if (this.mFooterLoadingView == null || !mode.canPullUp()) {
            return;
        }
        this.mFooterLoadingView.setLoadingDrawable(drawable);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase, com.handmark.pulltorefresh.library.IPullToRefresh
    public void setPullLabel(CharSequence charSequence, PullToRefreshBase.Mode mode) {
        super.setPullLabel(charSequence, mode);
        if (this.mHeaderLoadingView != null && mode.canPullDown()) {
            this.mHeaderLoadingView.setPullLabel(charSequence);
        }
        if (this.mFooterLoadingView == null || !mode.canPullUp()) {
            return;
        }
        this.mFooterLoadingView.setPullLabel(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase, com.handmark.pulltorefresh.library.PullToRefreshBase
    public void setRefreshingInternal(boolean z) {
        LoadingLayout footerLayout;
        int count;
        int scrollY;
        LoadingLayout loadingLayout;
        ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
        if (getShowViewWhileRefreshing() && adapter != null && !adapter.isEmpty()) {
            super.setRefreshingInternal(false);
            if (a.a[getCurrentMode().ordinal()] != 1) {
                footerLayout = getHeaderLayout();
                loadingLayout = this.mHeaderLoadingView;
                scrollY = getScrollY() + getFooterHeight();
                count = 0;
            } else {
                footerLayout = getFooterLayout();
                LoadingLayout loadingLayout2 = this.mFooterLoadingView;
                count = ((ListView) this.mRefreshableView).getCount() - 1;
                scrollY = getScrollY() - getHeaderHeight();
                loadingLayout = loadingLayout2;
            }
            if (z) {
                setHeaderScroll(scrollY);
            }
            footerLayout.setVisibility(4);
            loadingLayout.setVisibility(0);
            loadingLayout.refreshing();
            if (z) {
                ((ListView) this.mRefreshableView).setSelection(count);
                smoothScrollTo(0);
                return;
            }
            return;
        }
        super.setRefreshingInternal(z);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase, com.handmark.pulltorefresh.library.IPullToRefresh
    public void setRefreshingLabel(CharSequence charSequence, PullToRefreshBase.Mode mode) {
        super.setRefreshingLabel(charSequence, mode);
        if (this.mHeaderLoadingView != null && mode.canPullDown()) {
            this.mHeaderLoadingView.setRefreshingLabel(charSequence);
        }
        if (this.mFooterLoadingView == null || !mode.canPullUp()) {
            return;
        }
        this.mFooterLoadingView.setRefreshingLabel(charSequence);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase, com.handmark.pulltorefresh.library.IPullToRefresh
    public void setReleaseLabel(CharSequence charSequence, PullToRefreshBase.Mode mode) {
        super.setReleaseLabel(charSequence, mode);
        if (this.mHeaderLoadingView != null && mode.canPullDown()) {
            this.mHeaderLoadingView.setReleaseLabel(charSequence);
        }
        if (this.mFooterLoadingView == null || !mode.canPullUp()) {
            return;
        }
        this.mFooterLoadingView.setReleaseLabel(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public final ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ListView createListView = createListView(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PullToRefresh);
        FrameLayout frameLayout = new FrameLayout(context);
        LoadingLayout createLoadingLayout = createLoadingLayout(context, PullToRefreshBase.Mode.PULL_DOWN_TO_REFRESH, obtainStyledAttributes);
        this.mHeaderLoadingView = createLoadingLayout;
        frameLayout.addView(createLoadingLayout, -1, -2);
        this.mHeaderLoadingView.setVisibility(8);
        createListView.addHeaderView(frameLayout, null, false);
        this.mLvFooterLoadingFrame = new FrameLayout(context);
        LoadingLayout createLoadingLayout2 = createLoadingLayout(context, PullToRefreshBase.Mode.PULL_UP_TO_REFRESH, obtainStyledAttributes);
        this.mFooterLoadingView = createLoadingLayout2;
        this.mLvFooterLoadingFrame.addView(createLoadingLayout2, -1, -2);
        this.mFooterLoadingView.setVisibility(8);
        obtainStyledAttributes.recycle();
        createListView.setId(16908298);
        return createListView;
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDisableScrollingWhileRefreshing(false);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        setDisableScrollingWhileRefreshing(false);
    }
}
