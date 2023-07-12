package cn.damai.tetris.core;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface IRecyclerView {

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnLoadMoreListener {
        void onLoadMore(View view);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    void setLoadMoreEnabled(boolean z);

    void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener);

    void setOnRefreshListener(OnRefreshListener onRefreshListener);

    void setRefreshEnabled(boolean z);

    void setRefreshHeaderView(View view);
}
