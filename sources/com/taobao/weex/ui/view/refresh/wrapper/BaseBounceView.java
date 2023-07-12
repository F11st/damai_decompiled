package com.taobao.weex.ui.view.refresh.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.view.WXLoadingLayout;
import com.taobao.weex.ui.view.WXRefreshLayout;
import com.taobao.weex.ui.view.refresh.core.WXRefreshView;
import com.taobao.weex.ui.view.refresh.core.WXSwipeLayout;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BaseBounceView<T extends View> extends FrameLayout {
    private T mInnerView;
    private int mOrientation;
    protected WXSwipeLayout swipeLayout;

    public BaseBounceView(Context context, int i) {
        this(context, null, i);
    }

    private WXSwipeLayout createBounceView(Context context) {
        WXSwipeLayout wXSwipeLayout = new WXSwipeLayout(context);
        this.swipeLayout = wXSwipeLayout;
        wXSwipeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        T innerView = setInnerView(context);
        this.mInnerView = innerView;
        if (innerView == null) {
            return null;
        }
        this.swipeLayout.addTargetView(innerView);
        addView(this.swipeLayout, -1, -1);
        return this.swipeLayout;
    }

    public void finishPullLoad() {
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.finishPullLoad();
        }
    }

    public void finishPullRefresh() {
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.finishPullRefresh();
        }
    }

    public T getInnerView() {
        return this.mInnerView;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public WXSwipeLayout getSwipeLayout() {
        return this.swipeLayout;
    }

    public void init(Context context) {
        createBounceView(context);
    }

    boolean isVertical() {
        return this.mOrientation == 1;
    }

    public abstract void onLoadmoreComplete();

    public abstract void onRefreshingComplete();

    public void removeFooterView(WXComponent wXComponent) {
        setLoadmoreEnable(false);
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout == null || wXSwipeLayout.getFooterView() == null) {
            return;
        }
        this.swipeLayout.setLoadingHeight(0);
        this.swipeLayout.getFooterView().removeView(wXComponent.getHostView());
        this.swipeLayout.finishPullLoad();
    }

    public void removeHeaderView(WXComponent wXComponent) {
        setRefreshEnable(false);
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout == null || wXSwipeLayout.getHeaderView() == null) {
            return;
        }
        this.swipeLayout.setRefreshHeight(0);
        this.swipeLayout.getHeaderView().removeView(wXComponent.getHostView());
        this.swipeLayout.finishPullRefresh();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view instanceof WXLoadingLayout) {
            finishPullLoad();
            setLoadmoreEnable(false);
            WXSwipeLayout wXSwipeLayout = this.swipeLayout;
            if (wXSwipeLayout != null) {
                wXSwipeLayout.removeView(wXSwipeLayout.getFooterView());
            }
        } else if (view instanceof WXRefreshLayout) {
            finishPullRefresh();
            setRefreshEnable(false);
            WXSwipeLayout wXSwipeLayout2 = this.swipeLayout;
            if (wXSwipeLayout2 != null) {
                wXSwipeLayout2.removeView(wXSwipeLayout2.getHeaderView());
            }
        } else {
            super.removeView(view);
        }
    }

    public void setFooterView(WXComponent wXComponent) {
        WXRefreshView footerView;
        int color;
        setLoadmoreEnable(true);
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout == null || (footerView = wXSwipeLayout.getFooterView()) == null || wXComponent == null) {
            return;
        }
        this.swipeLayout.setLoadingHeight((int) wXComponent.getLayoutHeight());
        String string = WXUtils.getString((String) wXComponent.getStyles().get("backgroundColor"), null);
        if (string != null && !TextUtils.isEmpty(string) && (color = WXResourceUtils.getColor(string)) != 0) {
            this.swipeLayout.setLoadingBgColor(color);
        }
        footerView.setRefreshView(wXComponent.getHostView());
    }

    public void setHeaderView(WXComponent wXComponent) {
        WXRefreshView headerView;
        int color;
        setRefreshEnable(true);
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout == null || (headerView = wXSwipeLayout.getHeaderView()) == null || wXComponent == null) {
            return;
        }
        this.swipeLayout.setRefreshHeight((int) wXComponent.getLayoutHeight());
        String string = WXUtils.getString((String) wXComponent.getStyles().get("backgroundColor"), null);
        if (string != null && !TextUtils.isEmpty(string) && (color = WXResourceUtils.getColor(string)) != 0) {
            this.swipeLayout.setRefreshBgColor(color);
        }
        headerView.setRefreshView(wXComponent.getHostView());
    }

    public abstract T setInnerView(Context context);

    public void setLoadmoreEnable(boolean z) {
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.setPullLoadEnable(z);
        }
    }

    public void setOnLoadingListener(WXSwipeLayout.WXOnLoadingListener wXOnLoadingListener) {
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.setOnLoadingListener(wXOnLoadingListener);
        }
    }

    public void setOnRefreshListener(WXSwipeLayout.WXOnRefreshListener wXOnRefreshListener) {
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.setOnRefreshListener(wXOnRefreshListener);
        }
    }

    public void setRefreshEnable(boolean z) {
        WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.setPullRefreshEnable(z);
        }
    }

    public BaseBounceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mOrientation = 1;
        this.mOrientation = i;
    }
}
