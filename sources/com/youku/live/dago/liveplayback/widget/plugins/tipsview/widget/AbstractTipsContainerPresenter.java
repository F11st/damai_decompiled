package com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.kubus.Event;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.TipsConfig;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.TipsPluginContract;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.util.TipsShowConditionCheckUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class AbstractTipsContainerPresenter {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final Context mContext;
    protected TipsConfig mCurrTipsConfig;
    protected ITipsContainerView mCurrTipsView;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    protected final AlixPlayerContext mPlayerContext;
    private final TipsPosition mPosition;
    protected final TipsPluginContract.TipsPluginView mTipsViewHolder;

    public AbstractTipsContainerPresenter(AlixPlayerContext alixPlayerContext, TipsPluginContract.TipsPluginView tipsPluginView, TipsPosition tipsPosition, Context context) {
        this.mTipsViewHolder = tipsPluginView;
        this.mContext = context;
        this.mPosition = tipsPosition;
        this.mPlayerContext = alixPlayerContext;
    }

    private void createTipsView(TipsConfig tipsConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585474369")) {
            ipChange.ipc$dispatch("-585474369", new Object[]{this, tipsConfig});
            return;
        }
        this.mCurrTipsConfig = tipsConfig;
        if (tipsConfig != null) {
            this.mCurrTipsView = createViewByConfig(this.mContext, tipsConfig);
        }
        if (this.mCurrTipsView == null) {
            this.mCurrTipsConfig = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTipsView(ITipsContainerView iTipsContainerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1048530849")) {
            ipChange.ipc$dispatch("1048530849", new Object[]{this, iTipsContainerView});
        } else if (iTipsContainerView != null) {
            iTipsContainerView.animHide();
        }
    }

    protected abstract void addTips(FrameLayout frameLayout, View view);

    public void clearDelayDisMissRunnable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-3465379")) {
            ipChange.ipc$dispatch("-3465379", new Object[]{this});
        } else {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
    }

    protected abstract ITipsContainerView createViewByConfig(Context context, TipsConfig tipsConfig);

    public void forceHideTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1089826167")) {
            ipChange.ipc$dispatch("-1089826167", new Object[]{this});
        } else {
            hideTipsView(this.mCurrTipsView);
        }
    }

    public String getShowTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1668926877")) {
            return (String) ipChange.ipc$dispatch("1668926877", new Object[]{this});
        }
        TipsConfig tipsConfig = this.mCurrTipsConfig;
        if (tipsConfig == null) {
            return null;
        }
        return tipsConfig.getTipsKey();
    }

    public int getShowTipsLevel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013181526")) {
            return ((Integer) ipChange.ipc$dispatch("1013181526", new Object[]{this})).intValue();
        }
        TipsConfig tipsConfig = this.mCurrTipsConfig;
        if (tipsConfig == null) {
            return 0;
        }
        return tipsConfig.getTipsLevel();
    }

    public void hideTips(String str) {
        TipsConfig tipsConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577275796")) {
            ipChange.ipc$dispatch("-1577275796", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || (tipsConfig = this.mCurrTipsConfig) == null || !str.equalsIgnoreCase(tipsConfig.getTipsKey())) {
        } else {
            hideTipsView(this.mCurrTipsView);
        }
    }

    public boolean isControlBarShowing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1353339379")) {
            return ((Boolean) ipChange.ipc$dispatch("-1353339379", new Object[]{this})).booleanValue();
        }
        Event stickyEvent = this.mPlayerContext.getEventBus().getStickyEvent(ApiConstants.EventType.ON_CONTROL_VISIBILITY_CHANGE);
        return stickyEvent != null && ((Boolean) stickyEvent.data).booleanValue();
    }

    public boolean isTipsShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854951233")) {
            return ((Boolean) ipChange.ipc$dispatch("1854951233", new Object[]{this})).booleanValue();
        }
        ITipsContainerView iTipsContainerView = this.mCurrTipsView;
        return iTipsContainerView != null && iTipsContainerView.getView().getVisibility() == 0;
    }

    public abstract void notifyTipsDidHide(String str);

    public abstract void notifyTipsDidShow(String str);

    public void onControlShowChange(boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "1760316337")) {
            ipChange.ipc$dispatch("1760316337", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        TipsConfig tipsConfig = this.mCurrTipsConfig;
        if (tipsConfig != null && tipsConfig.getTipsPresenter() != null) {
            z2 = this.mCurrTipsConfig.getTipsPresenter().onControlShowChange(this.mPlayerContext.isLandScreen() ? 1 : 0, z);
        }
        ITipsContainerView iTipsContainerView = this.mCurrTipsView;
        if (iTipsContainerView == null || z2) {
            return;
        }
        iTipsContainerView.onControlShowChange(this.mPlayerContext.isLandScreen() ? 1 : 0, z);
    }

    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "740708819")) {
            ipChange.ipc$dispatch("740708819", new Object[]{this});
            return;
        }
        clearDelayDisMissRunnable();
        this.mCurrTipsConfig = null;
        this.mCurrTipsView = null;
    }

    public void onScreenModeChange(Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-243768071")) {
            ipChange.ipc$dispatch("-243768071", new Object[]{this, num});
        } else if (this.mCurrTipsConfig == null || this.mCurrTipsView == null) {
        } else {
            boolean isControlBarShowing = isControlBarShowing();
            if (this.mCurrTipsConfig.getTipsPresenter() != null ? this.mCurrTipsConfig.getTipsPresenter().onScreenModeChanged(num, isControlBarShowing) : false) {
                return;
            }
            this.mCurrTipsView.onScreenModeChanged(num.intValue(), isControlBarShowing);
        }
    }

    public void onTipsViewHided(TipsConfig tipsConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-553647782")) {
            ipChange.ipc$dispatch("-553647782", new Object[]{this, tipsConfig});
            return;
        }
        if (tipsConfig != null && tipsConfig == this.mCurrTipsConfig) {
            this.mCurrTipsConfig = null;
            this.mCurrTipsView = null;
        }
        if (tipsConfig == null || TextUtils.isEmpty(tipsConfig.getTipsKey())) {
            return;
        }
        notifyTipsDidHide(tipsConfig.getTipsKey());
    }

    public void showTips(TipsConfig tipsConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394217925")) {
            ipChange.ipc$dispatch("-394217925", new Object[]{this, tipsConfig});
            return;
        }
        TipsShowConditionCheckUtil.updateRemoteConfig(tipsConfig);
        if (!TipsShowConditionCheckUtil.canShowTips(this.mPlayerContext, tipsConfig) || tipsConfig == null || tipsConfig.getTipsPresenter() == null) {
            return;
        }
        int tipsLevel = tipsConfig.getTipsLevel();
        TipsConfig tipsConfig2 = this.mCurrTipsConfig;
        if (tipsConfig2 != null && tipsLevel < tipsConfig2.getTipsLevel()) {
            if (this.mCurrTipsConfig != null) {
                tipsConfig.getTipsPresenter().ignoredByHighLevel(this.mCurrTipsConfig.getTipsLevel(), this.mCurrTipsConfig.getTipsKey());
                return;
            }
            return;
        }
        hideTipsView(this.mCurrTipsView);
        createTipsView(tipsConfig);
        if (this.mCurrTipsView != null) {
            this.mTipsViewHolder.show();
            addTips(this.mTipsViewHolder.getHolderView(), this.mCurrTipsView.getView());
            this.mCurrTipsView.getView().setVisibility(8);
            this.mCurrTipsView.animShow();
            TipsShowConditionCheckUtil.recordTipsHasShown(this.mPlayerContext, tipsConfig);
            if (tipsConfig.getDisplayTime() > 0) {
                updateDelayDismiss(tipsConfig.getDisplayTime());
            }
        }
    }

    protected void updateDelayDismiss(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-560400648")) {
            ipChange.ipc$dispatch("-560400648", new Object[]{this, Long.valueOf(j)});
            return;
        }
        clearDelayDisMissRunnable();
        if (j < 0) {
            return;
        }
        Long l = TipsConfig.MAX_DISPLAY_DURATION;
        if (j > l.longValue()) {
            j = l.longValue();
        }
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.AbstractTipsContainerPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-628442122")) {
                    ipChange2.ipc$dispatch("-628442122", new Object[]{this});
                    return;
                }
                AbstractTipsContainerPresenter abstractTipsContainerPresenter = AbstractTipsContainerPresenter.this;
                abstractTipsContainerPresenter.hideTipsView(abstractTipsContainerPresenter.mCurrTipsView);
            }
        }, j);
    }
}
