package com.youku.live.dago.liveplayback.widget.plugins.danmu;

import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmuPlugin extends AbsPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private DanmuView mDanmuView;

    public DanmuPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mDanmuView = new DanmuView(alixPlayerContext.getContext(), alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId);
        this.mAttachToParent = true;
    }

    public View getDanmuView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690489888")) {
            return (View) ipChange.ipc$dispatch("-690489888", new Object[]{this});
        }
        this.mDanmuView.show();
        View inflatedView = this.mDanmuView.getInflatedView();
        this.mHolderView = inflatedView;
        return inflatedView;
    }
}
