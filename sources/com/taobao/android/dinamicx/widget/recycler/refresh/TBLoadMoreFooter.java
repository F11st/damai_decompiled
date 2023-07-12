package com.taobao.android.dinamicx.widget.recycler.refresh;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class TBLoadMoreFooter extends RelativeLayout {
    protected TBSwipeRefreshLayout.OnPushLoadMoreListener mPushLoadMoreListener;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum LoadMoreState {
        NONE,
        PUSH_TO_LOAD,
        RELEASE_TO_LOAD,
        LOADING
    }

    public TBLoadMoreFooter(Context context) {
        super(context);
    }

    public abstract void changeToState(LoadMoreState loadMoreState);

    public abstract LoadMoreState getCurrentState();

    public abstract TextView getLoadMoreTipView();

    public abstract void setLoadMoreTipColor(@ColorInt int i);

    public abstract void setLoadMoreTips(String[] strArr);

    public abstract void setProgress(float f);

    public void setPushLoadMoreListener(TBSwipeRefreshLayout.OnPushLoadMoreListener onPushLoadMoreListener) {
        this.mPushLoadMoreListener = onPushLoadMoreListener;
    }
}
