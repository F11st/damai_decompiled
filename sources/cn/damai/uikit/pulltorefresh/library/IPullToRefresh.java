package cn.damai.uikit.pulltorefresh.library;

import android.view.View;
import android.view.animation.Interpolator;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IPullToRefresh<T extends View> {
    boolean demo();

    PullToRefreshBase.Mode getCurrentMode();

    boolean getFilterTouchEvents();

    ILoadingLayout getLoadingLayoutProxy();

    ILoadingLayout getLoadingLayoutProxy(boolean z, boolean z2);

    PullToRefreshBase.Mode getMode();

    T getRefreshableView();

    boolean getShowViewWhileRefreshing();

    PullToRefreshBase.State getState();

    boolean isPullToRefreshEnabled();

    boolean isPullToRefreshOverScrollEnabled();

    boolean isRefreshing();

    boolean isScrollingWhileRefreshingEnabled();

    void onRefreshComplete();

    void setFilterTouchEvents(boolean z);

    void setMode(PullToRefreshBase.Mode mode);

    void setOnPullEventListener(PullToRefreshBase.OnPullEventListener<T> onPullEventListener);

    void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2<T> onRefreshListener2);

    void setOnRefreshListener(PullToRefreshBase.OnRefreshListener<T> onRefreshListener);

    void setPullToRefreshOverScrollEnabled(boolean z);

    void setRefreshing();

    void setRefreshing(boolean z);

    void setScrollAnimationInterpolator(Interpolator interpolator);

    void setScrollingWhileRefreshingEnabled(boolean z);

    void setShowViewWhileRefreshing(boolean z);
}
