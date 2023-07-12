package com.youku.live.widgets.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.config.model.WidgetEngineRenderModel;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class WidgetEngineRenderConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private static WidgetEngineRenderConfig sInstance;
    private WidgetEngineRenderModel mRenderModel = new WidgetEngineRenderModel();

    public static WidgetEngineRenderConfig getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-960642597")) {
            return (WidgetEngineRenderConfig) ipChange.ipc$dispatch("-960642597", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (WidgetEngineRenderConfig.class) {
                if (sInstance == null) {
                    sInstance = new WidgetEngineRenderConfig();
                }
            }
        }
        return sInstance;
    }

    private WidgetEngineRenderModel getRenderModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "913543996")) {
            return (WidgetEngineRenderModel) ipChange.ipc$dispatch("913543996", new Object[]{this});
        }
        if (this.mRenderModel == null) {
            synchronized (this) {
                if (this.mRenderModel == null) {
                    this.mRenderModel = new WidgetEngineRenderModel();
                }
            }
        }
        return this.mRenderModel;
    }

    public boolean isAppearLevelPlugin(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1367715569") ? ((Boolean) ipChange.ipc$dispatch("-1367715569", new Object[]{this, str})).booleanValue() : getRenderModel().isAppearRenderPlugin(str);
    }

    public boolean isAppearLevelWidget(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1900849822") ? ((Boolean) ipChange.ipc$dispatch("1900849822", new Object[]{this, str})).booleanValue() : getRenderModel().isAppearRenderWidget(str);
    }
}
