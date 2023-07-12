package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private LoadingLayout mFooterLoadingView;
    private LoadingLayout mHeaderLoadingView;
    private boolean mListViewExtrasEnabled;
    private FrameLayout mLvFooterLoadingFrame;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class InternalListView extends ListView implements EmptyViewMethodAccessor {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean mAddedLvFooter;

        public InternalListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mAddedLvFooter = false;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1576664912")) {
                ipChange.ipc$dispatch("1576664912", new Object[]{this, canvas});
                return;
            }
            try {
                super.dispatchDraw(canvas);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1545212777")) {
                return ((Boolean) ipChange.ipc$dispatch("-1545212777", new Object[]{this, motionEvent})).booleanValue();
            }
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // android.widget.AdapterView, cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-944166929")) {
                ipChange.ipc$dispatch("-944166929", new Object[]{this, view});
            } else {
                PullToRefreshListView.this.setEmptyView(view);
            }
        }

        @Override // cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-156349172")) {
                ipChange.ipc$dispatch("-156349172", new Object[]{this, view});
            } else {
                super.setEmptyView(view);
            }
        }

        @Override // android.widget.AdapterView
        public void setAdapter(ListAdapter listAdapter) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1137979279")) {
                ipChange.ipc$dispatch("1137979279", new Object[]{this, listAdapter});
                return;
            }
            if (PullToRefreshListView.this.mLvFooterLoadingFrame != null && !this.mAddedLvFooter) {
                addFooterView(PullToRefreshListView.this.mLvFooterLoadingFrame, null, false);
                this.mAddedLvFooter = true;
            }
            super.setAdapter(listAdapter);
        }
    }

    /* compiled from: Taobao */
    @TargetApi(9)
    /* loaded from: classes8.dex */
    public final class InternalListViewSDK9 extends InternalListView {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalListViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "236636318")) {
                return ((Boolean) ipChange.ipc$dispatch("236636318", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})).booleanValue();
            }
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            C2536b.d(PullToRefreshListView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.pulltorefresh.library.PullToRefreshListView$a */
    /* loaded from: classes8.dex */
    static /* synthetic */ class C2533a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public PullToRefreshListView(Context context) {
        super(context);
    }

    protected ListView createListView(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480213363")) {
            return (ListView) ipChange.ipc$dispatch("-480213363", new Object[]{this, context, attributeSet});
        }
        if (Build.VERSION.SDK_INT >= 9) {
            return new InternalListViewSDK9(context, attributeSet);
        }
        return new InternalListView(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public C2535a createLoadingLayoutProxy(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245772312")) {
            return (C2535a) ipChange.ipc$dispatch("1245772312", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        C2535a createLoadingLayoutProxy = super.createLoadingLayoutProxy(z, z2);
        if (this.mListViewExtrasEnabled) {
            PullToRefreshBase.Mode mode = getMode();
            if (z && mode.showHeaderLoadingLayout()) {
                createLoadingLayoutProxy.a(this.mHeaderLoadingView);
            }
            if (z2 && mode.showFooterLoadingLayout()) {
                createLoadingLayoutProxy.a(this.mFooterLoadingView);
            }
        }
        return createLoadingLayoutProxy;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1339559965") ? (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("-1339559965", new Object[]{this}) : PullToRefreshBase.Orientation.VERTICAL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshAdapterViewBase, cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void handleStyledAttributes(TypedArray typedArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816250028")) {
            ipChange.ipc$dispatch("1816250028", new Object[]{this, typedArray});
            return;
        }
        super.handleStyledAttributes(typedArray);
        boolean z = typedArray.getBoolean(R$styleable.PullToRefresh_ptrListViewExtrasEnabled, true);
        this.mListViewExtrasEnabled = z;
        if (z) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
            FrameLayout frameLayout = new FrameLayout(getContext());
            LoadingLayout createLoadingLayout = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, typedArray);
            this.mHeaderLoadingView = createLoadingLayout;
            createLoadingLayout.setVisibility(8);
            frameLayout.addView(this.mHeaderLoadingView, layoutParams);
            ((ListView) this.mRefreshableView).addHeaderView(frameLayout, null, false);
            this.mLvFooterLoadingFrame = new FrameLayout(getContext());
            LoadingLayout createLoadingLayout2 = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, typedArray);
            this.mFooterLoadingView = createLoadingLayout2;
            createLoadingLayout2.setVisibility(8);
            this.mLvFooterLoadingFrame.addView(this.mFooterLoadingView, layoutParams);
            if (typedArray.hasValue(R$styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
                return;
            }
            setScrollingWhileRefreshingEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshAdapterViewBase, cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onRefreshing(boolean z) {
        LoadingLayout footerLayout;
        LoadingLayout loadingLayout;
        LoadingLayout loadingLayout2;
        int count;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407705705")) {
            ipChange.ipc$dispatch("-1407705705", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
        if (this.mListViewExtrasEnabled && getShowViewWhileRefreshing() && adapter != null && !adapter.isEmpty()) {
            super.onRefreshing(false);
            int i2 = C2533a.a[getCurrentMode().ordinal()];
            if (i2 != 1 && i2 != 2) {
                footerLayout = getHeaderLayout();
                loadingLayout = this.mHeaderLoadingView;
                loadingLayout2 = this.mFooterLoadingView;
                i = getScrollY() + getHeaderSize();
                count = 0;
            } else {
                footerLayout = getFooterLayout();
                loadingLayout = this.mFooterLoadingView;
                loadingLayout2 = this.mHeaderLoadingView;
                int scrollY = getScrollY() - getFooterSize();
                count = ((ListView) this.mRefreshableView).getCount() - 1;
                i = scrollY;
            }
            footerLayout.reset();
            footerLayout.hideAllViews();
            loadingLayout2.setVisibility(8);
            loadingLayout.setVisibility(0);
            loadingLayout.refreshing();
            if (z) {
                disableLoadingLayoutVisibilityChanges();
                setHeaderScroll(i);
                ((ListView) this.mRefreshableView).setSelection(count);
                smoothScrollTo(0);
                return;
            }
            return;
        }
        super.onRefreshing(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshAdapterViewBase, cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onReset() {
        LoadingLayout footerLayout;
        LoadingLayout loadingLayout;
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "375881847")) {
            ipChange.ipc$dispatch("375881847", new Object[]{this});
        } else if (!this.mListViewExtrasEnabled) {
            super.onReset();
        } else {
            int i3 = C2533a.a[getCurrentMode().ordinal()];
            if (i3 != 1 && i3 != 2) {
                footerLayout = getHeaderLayout();
                loadingLayout = this.mHeaderLoadingView;
                i = -getHeaderSize();
                if (Math.abs(((ListView) this.mRefreshableView).getFirstVisiblePosition() - 0) > 1) {
                    i2 = 0;
                }
            } else {
                footerLayout = getFooterLayout();
                loadingLayout = this.mFooterLoadingView;
                int count = ((ListView) this.mRefreshableView).getCount() - 1;
                int footerSize = getFooterSize();
                i2 = Math.abs(((ListView) this.mRefreshableView).getLastVisiblePosition() - count) <= 1 ? 1 : 0;
                r3 = count;
                i = footerSize;
            }
            if (loadingLayout.getVisibility() == 0) {
                footerLayout.showInvisibleViews();
                loadingLayout.setVisibility(8);
                if (i2 != 0 && getState() != PullToRefreshBase.State.MANUAL_REFRESHING) {
                    ((ListView) this.mRefreshableView).setSelection(r3);
                    setHeaderScroll(i);
                }
            }
            super.onReset();
        }
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897540594")) {
            return (ListView) ipChange.ipc$dispatch("897540594", new Object[]{this, context, attributeSet});
        }
        ListView createListView = createListView(context, attributeSet);
        createListView.setId(16908298);
        return createListView;
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }
}
