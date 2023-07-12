package com.youku.live.livesdk.wkit;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.slide.plugin.SlideWVPlugin;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.youku.live.livesdk.widgets.module.DagoChannelModule;
import com.youku.live.livesdk.widgets.module.DagoDataCenterModule;
import com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin;
import com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV3Plugin;
import com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV4Plugin;
import com.youku.live.livesdk.widgets.widget.DagoBackBtnWidget;
import com.youku.live.livesdk.widgets.widget.DagoPGCBackgroundWidget;
import com.youku.live.livesdk.wkit.module.DagoApp;
import com.youku.live.livesdk.wkit.module.DagoExitPlayer;
import com.youku.live.livesdk.wkit.module.DagoModal;
import com.youku.live.livesdk.wkit.module.DagoNavigate;
import com.youku.live.livesdk.wkit.module.DagoToast;
import com.youku.live.livesdk.wkit.module.DagoUser;
import com.youku.live.livesdk.wkit.module.Screen;
import com.youku.live.livesdk.wkit.plugin.ScreenPlugin;
import com.youku.live.livesdk.wkit.widget.BaseBackWidget;
import com.youku.live.livesdk.wkit.widget.BaseStackWidget;
import com.youku.live.livesdk.wkit.widget.LiveWeexWidget;
import com.youku.live.livesdk.wkit.widget.ModalWidget;
import com.youku.live.livesdk.wkit.widget.WeexWidget;
import com.youku.live.livesdk.wkit.widget.slide.BaseSlideWidget;
import com.youku.live.widgets.WidgetSDKEngine;
import java.util.HashMap;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WidgetKitMananger {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void initWithContext(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802564365")) {
            ipChange.ipc$dispatch("-1802564365", new Object[]{context});
            return;
        }
        WidgetSDKEngine.initWithParams(new HashMap());
        WidgetSDKEngine.registerWidget("LiveSlide", BaseSlideWidget.class);
        WidgetSDKEngine.registerWidget("LRLiveSlide", BaseSlideWidget.class);
        WidgetSDKEngine.registerWidget(SlideWVPlugin.SLIDE_PLUGIN_NAME, BaseSlideWidget.class);
        WidgetSDKEngine.registerWidget("Back", BaseBackWidget.class);
        WidgetSDKEngine.registerWidget("Stack", BaseStackWidget.class);
        WidgetSDKEngine.registerWidget("LiveWeex", LiveWeexWidget.class);
        WidgetSDKEngine.registerWidget(gn1.TYPE_OPEN_URL_WEEX, WeexWidget.class);
        WidgetSDKEngine.registerWidget(ModalWidget.WIDGET_NAME, ModalWidget.class);
        WidgetSDKEngine.registerPlugin("DagoChannel", DagoChannelPlugin.class);
        WidgetSDKEngine.registerPlugin("LiveFullInfoV3", DagoLiveFullInfoV3Plugin.class);
        WidgetSDKEngine.registerPlugin("LiveFullInfoV4", DagoLiveFullInfoV4Plugin.class);
        WidgetSDKEngine.registerWidget("BackBtn", DagoBackBtnWidget.class);
        WidgetSDKEngine.registerWidget(DagoPGCBackgroundWidget.WIDGET_NAME, DagoPGCBackgroundWidget.class);
        WidgetSDKEngine.registerPlugin("Screen", ScreenPlugin.class);
        try {
            WXSDKEngine.registerModule("dg-data-center", DagoDataCenterModule.class);
            WXSDKEngine.registerModule("dago-channel", DagoChannelModule.class);
            WXSDKEngine.registerModule("dago-data-center", DagoDataCenterModule.class);
            WXSDKEngine.registerModule("dg-screen", Screen.class);
            WXSDKEngine.registerModule("dago-application", DagoApp.class);
            WXSDKEngine.registerModule("dago-modal", DagoModal.class);
            WXSDKEngine.registerModule("dago-user", DagoUser.class);
            WXSDKEngine.registerModule("dago-toast", DagoToast.class);
            WXSDKEngine.registerModule("dago-exit-player", DagoExitPlayer.class);
            WXSDKEngine.registerModule("dago-navigate", DagoNavigate.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }
}
