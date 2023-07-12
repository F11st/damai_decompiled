package cn.damai.h5container.refresh;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public interface JRefreshHeader {
    long failingRetention();

    int maxOffsetHeight();

    void onComplete(JRefreshLayout jRefreshLayout, boolean z);

    void onPrepare(JRefreshLayout jRefreshLayout);

    void onRefresh(JRefreshLayout jRefreshLayout);

    void onReset(JRefreshLayout jRefreshLayout);

    void onScroll(JRefreshLayout jRefreshLayout, int i, float f, boolean z);

    int refreshHeight();

    long succeedRetention();
}
