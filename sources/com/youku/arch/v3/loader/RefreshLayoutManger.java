package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/youku/arch/v3/loader/RefreshLayoutManger;", "Lcom/youku/arch/v3/loader/ILoadingViewListener;", "", DXRecyclerLayout.LOAD_MORE_NO_DATA_STRING, "Ltb/wt2;", "setNoMore", "onNextPageLoading", "", "message", "onLoadNextFailure", "onLoadNextSuccess", "onAllPageLoaded", "onLoading", "onFailure", "onNoData", "onNoNetwork", "onSuccess", "onFailureWithData", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "refreshLayout", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "getRefreshLayout", "()Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "setRefreshLayout", "(Lcom/scwang/smartrefresh/layout/api/RefreshLayout;)V", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RefreshLayoutManger implements ILoadingViewListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int FOOTER_HEIGHT_DP_LOADING = 63;
    public static final int FOOTER_HEIGHT_DP_NOMORE = 53;
    @Nullable
    private RefreshLayout refreshLayout;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/loader/RefreshLayoutManger$Companion;", "", "", "FOOTER_HEIGHT_DP_LOADING", "I", "FOOTER_HEIGHT_DP_NOMORE", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    private final void setNoMore(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1688979481")) {
            ipChange.ipc$dispatch("-1688979481", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            RefreshLayout refreshLayout = this.refreshLayout;
            if (refreshLayout != null) {
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        } else {
            RefreshLayout refreshLayout2 = this.refreshLayout;
            if (refreshLayout2 != null) {
                refreshLayout2.setEnableLoadMore(true);
            }
            RefreshLayout refreshLayout3 = this.refreshLayout;
            if (refreshLayout3 != null) {
                refreshLayout3.finishLoadMore();
            }
        }
        RefreshLayout refreshLayout4 = this.refreshLayout;
        if (refreshLayout4 != null) {
            refreshLayout4.setEnableAutoLoadMore(!z);
        }
        if (z) {
            RefreshLayout refreshLayout5 = this.refreshLayout;
            if (refreshLayout5 != null) {
                refreshLayout5.setFooterHeight(53.0f);
            }
        } else {
            RefreshLayout refreshLayout6 = this.refreshLayout;
            if (refreshLayout6 != null) {
                refreshLayout6.setFooterHeight(63.0f);
            }
        }
        RefreshLayout refreshLayout7 = this.refreshLayout;
        if (refreshLayout7 == null) {
            return;
        }
        refreshLayout7.setNoMoreData(z);
    }

    @Nullable
    public final RefreshLayout getRefreshLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1285772939") ? (RefreshLayout) ipChange.ipc$dispatch("-1285772939", new Object[]{this}) : this.refreshLayout;
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onAllPageLoaded() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2092536623")) {
            ipChange.ipc$dispatch("2092536623", new Object[]{this});
        } else {
            setNoMore(true);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onFailure(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1148980228")) {
            ipChange.ipc$dispatch("1148980228", new Object[]{this, str});
            return;
        }
        RefreshLayout refreshLayout = this.refreshLayout;
        if (refreshLayout == null) {
            return;
        }
        refreshLayout.finishRefresh();
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onFailureWithData(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900661420")) {
            ipChange.ipc$dispatch("-900661420", new Object[]{this, str});
        } else {
            onFailure(str);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoadNextFailure(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-381910371")) {
            ipChange.ipc$dispatch("-381910371", new Object[]{this, str});
            return;
        }
        RefreshLayout refreshLayout = this.refreshLayout;
        if (refreshLayout == null) {
            return;
        }
        refreshLayout.finishLoadMore(false);
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoadNextSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "869018234")) {
            ipChange.ipc$dispatch("869018234", new Object[]{this});
        } else {
            setNoMore(false);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923486264")) {
            ipChange.ipc$dispatch("-923486264", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNextPageLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1985314166")) {
            ipChange.ipc$dispatch("-1985314166", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883383707")) {
            ipChange.ipc$dispatch("883383707", new Object[]{this});
            return;
        }
        RefreshLayout refreshLayout = this.refreshLayout;
        if (refreshLayout == null) {
            return;
        }
        refreshLayout.finishRefresh();
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNoNetwork() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165370999")) {
            ipChange.ipc$dispatch("1165370999", new Object[]{this});
            return;
        }
        RefreshLayout refreshLayout = this.refreshLayout;
        if (refreshLayout == null) {
            return;
        }
        refreshLayout.finishRefresh();
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065297503")) {
            ipChange.ipc$dispatch("-2065297503", new Object[]{this});
            return;
        }
        RefreshLayout refreshLayout = this.refreshLayout;
        if (refreshLayout != null) {
            refreshLayout.finishRefresh();
        }
        RefreshLayout refreshLayout2 = this.refreshLayout;
        if (refreshLayout2 == null) {
            return;
        }
        refreshLayout2.setEnableAutoLoadMore(true);
    }

    public final void setRefreshLayout(@Nullable RefreshLayout refreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875537961")) {
            ipChange.ipc$dispatch("-1875537961", new Object[]{this, refreshLayout});
        } else {
            this.refreshLayout = refreshLayout;
        }
    }
}
