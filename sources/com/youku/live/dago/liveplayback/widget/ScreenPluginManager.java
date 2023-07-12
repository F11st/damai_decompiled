package com.youku.live.dago.liveplayback.widget;

import android.os.Handler;
import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.PluginManager;
import com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ScreenPluginManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private IScreenPluginManagerListener mIScreenPluginManagerListener;
    private AlixPlayerContext mPlayerContext;
    private PluginManager mPluginManager;
    private List<BaseScreenPlugin> mPlugins = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface IScreenPluginManagerListener {
        void onVisibilityChange(boolean z);
    }

    public ScreenPluginManager(AlixPlayerContext alixPlayerContext, PluginManager pluginManager, BaseScreenPlugin... baseScreenPluginArr) {
        this.mPluginManager = pluginManager;
        this.mPlayerContext = alixPlayerContext;
        for (BaseScreenPlugin baseScreenPlugin : baseScreenPluginArr) {
            if (baseScreenPlugin != null) {
                this.mPlugins.add(baseScreenPlugin);
            }
        }
    }

    public void hideAll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1907830782")) {
            ipChange.ipc$dispatch("1907830782", new Object[]{this});
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        for (BaseScreenPlugin baseScreenPlugin : this.mPlugins) {
            baseScreenPlugin.hide();
        }
        IScreenPluginManagerListener iScreenPluginManagerListener = this.mIScreenPluginManagerListener;
        if (iScreenPluginManagerListener != null) {
            iScreenPluginManagerListener.onVisibilityChange(false);
        }
    }

    public boolean isShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077854230")) {
            return ((Boolean) ipChange.ipc$dispatch("-1077854230", new Object[]{this})).booleanValue();
        }
        for (BaseScreenPlugin baseScreenPlugin : this.mPlugins) {
            if (baseScreenPlugin.getHolderView() != null && baseScreenPlugin.getHolderView().isShown()) {
                return true;
            }
        }
        return false;
    }

    public void setScreenPluginManageerListener(IScreenPluginManagerListener iScreenPluginManagerListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "298035960")) {
            ipChange.ipc$dispatch("298035960", new Object[]{this, iScreenPluginManagerListener});
        } else {
            this.mIScreenPluginManagerListener = iScreenPluginManagerListener;
        }
    }
}
