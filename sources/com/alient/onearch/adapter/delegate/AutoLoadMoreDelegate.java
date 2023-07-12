package com.alient.onearch.adapter.delegate;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.event.Subject;
import com.youku.arch.v3.page.FragmentInterceptor;
import com.youku.arch.v3.page.GenericFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u001c\u0010\b\u001a\b\u0018\u00010\u0007R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate;", "Lcom/alient/onearch/adapter/delegate/BasicDelegate;", "Lcom/youku/arch/v3/page/GenericFragment;", Subject.FRAGMENT, "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "onFragmentDestroy", "Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate$ScrollListener;", "scrollListener", "Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate$ScrollListener;", "", "threshold", "I", "<init>", "()V", "ScrollListener", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class AutoLoadMoreDelegate extends BasicDelegate {
    @Nullable
    private ScrollListener scrollListener;
    private int threshold = 3;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate$ScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "getLastVisiblePosition", "dx", Constants.Name.DISTANCE_Y, "Ltb/wt2;", GXTemplateEngine.C3344g.TYPE_ON_SCROLLED, "<init>", "(Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public final class ScrollListener extends RecyclerView.OnScrollListener {
        final /* synthetic */ AutoLoadMoreDelegate this$0;

        public ScrollListener(AutoLoadMoreDelegate autoLoadMoreDelegate) {
            b41.i(autoLoadMoreDelegate, "this$0");
            this.this$0 = autoLoadMoreDelegate;
        }

        private final int getLastVisiblePosition(RecyclerView recyclerView) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager == null) {
                return 0;
            }
            return linearLayoutManager.findLastVisibleItemPosition();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
            GenericFragment fragment;
            RefreshLayout refreshLayout;
            GenericFragment fragment2;
            FragmentInterceptor fragmentInterceptor;
            b41.i(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i, i2);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter == null) {
                return;
            }
            AutoLoadMoreDelegate autoLoadMoreDelegate = this.this$0;
            if (getLastVisiblePosition(recyclerView) != adapter.getItemCount() - autoLoadMoreDelegate.threshold || (fragment = autoLoadMoreDelegate.getFragment()) == null || (refreshLayout = fragment.getRefreshLayout()) == null || (fragment2 = autoLoadMoreDelegate.getFragment()) == null || (fragmentInterceptor = fragment2.getFragmentInterceptor()) == null) {
                return;
            }
            fragmentInterceptor.onLoadMore(refreshLayout);
        }
    }

    @Override // com.alient.onearch.adapter.delegate.BasicDelegate
    public void init(@NotNull GenericFragment genericFragment) {
        b41.i(genericFragment, Subject.FRAGMENT);
        super.init(genericFragment);
        ScrollListener scrollListener = new ScrollListener(this);
        RecyclerView recyclerView = genericFragment.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(scrollListener);
        }
        wt2 wt2Var = wt2.INSTANCE;
        this.scrollListener = scrollListener;
    }

    @Override // com.alient.onearch.adapter.delegate.BasicDelegate
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        this.scrollListener = null;
    }
}
