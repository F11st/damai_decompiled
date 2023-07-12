package com.youku.live.widgets.widgets.weex;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.live.widgets.protocol.IEngineInstance;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class WeexHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static IEngineInstance getWidgetEngineInstance(WXModule wXModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724313650")) {
            return (IEngineInstance) ipChange.ipc$dispatch("-724313650", new Object[]{wXModule});
        }
        if (wXModule == null) {
            return null;
        }
        WXSDKInstance wXSDKInstance = wXModule.mWXSDKInstance;
        if (wXSDKInstance instanceof WeexInstance) {
            return ((WeexInstance) wXSDKInstance).getEngineInstance();
        }
        return null;
    }

    public static boolean isWidgetContainer(WXModule wXModule) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1574983077") ? ((Boolean) ipChange.ipc$dispatch("-1574983077", new Object[]{wXModule})).booleanValue() : wXModule != null && (wXModule.mWXSDKInstance instanceof WeexInstance);
    }

    public static IEngineInstance getWidgetEngineInstance(WXComponent wXComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211750444")) {
            return (IEngineInstance) ipChange.ipc$dispatch("-211750444", new Object[]{wXComponent});
        }
        if (wXComponent == null) {
            return null;
        }
        WXSDKInstance wXComponent2 = wXComponent.getInstance();
        if (wXComponent2 instanceof WeexInstance) {
            return ((WeexInstance) wXComponent2).getEngineInstance();
        }
        return null;
    }
}
