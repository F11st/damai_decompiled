package com.handmark.pulltorefresh.library;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Interpolator;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IPullToRefresh<T extends View> {
    PullToRefreshBase.Mode getCurrentMode();

    boolean getFilterTouchEvents();

    PullToRefreshBase.Mode getMode();

    T getRefreshableView();

    boolean getShowViewWhileRefreshing();

    boolean isDisableScrollingWhileRefreshing();

    boolean isPullToRefreshEnabled();

    boolean isPullToRefreshOverScrollEnabled();

    boolean isRefreshing();

    void onRefreshComplete();

    void setDisableScrollingWhileRefreshing(boolean z);

    void setFilterTouchEvents(boolean z);

    void setLastUpdatedLabel(CharSequence charSequence);

    void setLoadingDrawable(Drawable drawable);

    void setLoadingDrawable(Drawable drawable, PullToRefreshBase.Mode mode);

    void setMode(PullToRefreshBase.Mode mode);

    void setOnPullEventListener(PullToRefreshBase.OnPullEventListener<T> onPullEventListener);

    void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2<T> onRefreshListener2);

    void setOnRefreshListener(PullToRefreshBase.OnRefreshListener<T> onRefreshListener);

    void setPullLabel(CharSequence charSequence);

    void setPullLabel(CharSequence charSequence, PullToRefreshBase.Mode mode);

    void setPullToRefreshOverScrollEnabled(boolean z);

    void setRefreshing();

    void setRefreshing(boolean z);

    void setRefreshingLabel(CharSequence charSequence);

    void setRefreshingLabel(CharSequence charSequence, PullToRefreshBase.Mode mode);

    void setReleaseLabel(CharSequence charSequence);

    void setReleaseLabel(CharSequence charSequence, PullToRefreshBase.Mode mode);

    void setScrollAnimationInterpolator(Interpolator interpolator);

    void setShowViewWhileRefreshing(boolean z);
}
