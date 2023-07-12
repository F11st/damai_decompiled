package com.youku.live.dago.liveplayback.widget.plugins.error;

import android.content.res.Configuration;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.ActivityLifeCycleListener;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.Callable;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.kubus.EventBus;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BaseErrorPlugin extends AbsPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private ActivityLifeCycleListener mActivityLifeCycleListener;
    private EventBus mEventBus;
    protected BaseErrorView mView;

    public BaseErrorPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mActivityLifeCycleListener = new ActivityLifeCycleListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.error.BaseErrorPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplugin.ActivityLifeCycleListener
            public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1235033457")) {
                    ipChange.ipc$dispatch("-1235033457", new Object[]{this, Boolean.valueOf(z), configuration});
                } else {
                    BaseErrorPlugin.this.mView.onPictureInPictureModeChanged(z, configuration);
                }
            }
        };
        BaseErrorView baseErrorView = new BaseErrorView(alixPlayerContext.getActivity(), this);
        this.mView = baseErrorView;
        this.mHolderView = baseErrorView.getHolderView();
        this.mEventBus = alixPlayerContext.getEventBus();
        alixPlayerContext.addActivityLifeCycleListener(this.mActivityLifeCycleListener);
    }

    public EventBus getEventBus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1057330103") ? (EventBus) ipChange.ipc$dispatch("1057330103", new Object[]{this}) : this.mEventBus;
    }

    public boolean isFullScreen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391286130")) {
            return ((Boolean) ipChange.ipc$dispatch("1391286130", new Object[]{this})).booleanValue();
        }
        Callable<String> callable = this.mPlayerContext.getCallable();
        return callable != null && "2".equals(callable.call("screenMode"));
    }

    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503493471")) {
            ipChange.ipc$dispatch("-503493471", new Object[]{this});
            return;
        }
        Callable<String> callable = this.mPlayerContext.getCallable();
        if (callable != null) {
            callable.call("finish");
        }
    }

    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99532795")) {
            ipChange.ipc$dispatch("99532795", new Object[]{this});
        }
    }
}
