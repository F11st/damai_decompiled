package com.youku.live.dago.widgetlib;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.youku.live.dago.module.DagoLayoutWidgetModule;
import com.youku.live.dago.module.DagoPlayerInteract;
import com.youku.live.dago.widgetlib.ailpbaselib.framework.AILPAdapterFactory;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.AILPChatListYoukuAdapter;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.AILPChatListYoukuAdapterNew;
import com.youku.live.dago.widgetlib.component.AILPChatListComponent;
import com.youku.live.dago.widgetlib.component.AILPLikeViewComponent;
import com.youku.live.dago.widgetlib.component.DagoChatListComponent;
import com.youku.live.dago.widgetlib.component.DagoDanmuComponent;
import com.youku.live.dago.widgetlib.component.DagoLikeViewComponent;
import com.youku.live.dago.widgetlib.component.DagoUserListComponent;
import com.youku.live.dago.widgetlib.component.DagoYoukuVipHongbaoComponent;
import com.youku.live.dago.widgetlib.component.YKLAnchorInfoComponent;
import com.youku.live.dago.widgetlib.component.YKLAnimationViewComponent;
import com.youku.live.dago.widgetlib.component.YKLGiftBoardComponent;
import com.youku.live.dago.widgetlib.component.YKLGiftComboComponent;
import com.youku.live.dago.widgetlib.component.YKLGiftTrackComponent;
import com.youku.live.dago.widgetlib.component.YKLSliderComponent;
import com.youku.live.dago.widgetlib.module.DagoChatInputModule;
import com.youku.live.dago.widgetlib.module.DagoPrivateChatModule;
import com.youku.live.dago.widgetlib.module.LivePlayLogUploadModule;
import com.youku.live.dago.widgetlib.module.YKLDownloadModule;
import com.youku.live.dago.widgetlib.module.YKLNetModule;
import com.youku.live.dago.widgetlib.module.YKLPageModule;
import com.youku.live.dago.widgetlib.module.YKLScreenModule;
import com.youku.live.dago.widgetlib.module.YKLSystemInfoModule;
import com.youku.live.dago.widgetlib.module.YKLUserCardModule;
import com.youku.live.dago.widgetlib.plugin.YkImChannel;
import com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter;
import com.youku.live.dago.widgetlib.wedome.adapter.download.YKLDownloadAdapter;
import com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter;
import com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftComboAdapter;
import com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftTrackAdapter;
import com.youku.live.dago.widgetlib.wedome.adapter.net.YKLNetSysAdapter;
import com.youku.live.dago.widgetlib.wedome.framework.YKLAdapterFactory;
import com.youku.live.dago.widgetlib.wedome.image.DagoImageHelper;
import com.youku.live.dago.widgets.AnchorInfoWidget;
import com.youku.live.dago.widgets.BottomBarWidget;
import com.youku.live.dago.widgets.RoomInfoWidget;
import com.youku.live.widgets.WidgetSDKEngine;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoWidgetLib {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void registerAll(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1781665053")) {
            ipChange.ipc$dispatch("-1781665053", new Object[]{application});
            return;
        }
        AppContextUtils.init(application);
        DagoImageLoader.setImageLoader(new DagoImageHelper());
        WidgetSDKEngine.registerWidget(AnchorInfoWidget.WIDGET_NAME, AnchorInfoWidget.class);
        WidgetSDKEngine.registerWidget(BottomBarWidget.WIDGET_NAME, BottomBarWidget.class);
        WidgetSDKEngine.registerWidget(RoomInfoWidget.WIDGET_NAME, RoomInfoWidget.class);
        WidgetSDKEngine.registerPlugin("YkImChannel", YkImChannel.class);
        try {
            YKLAdapterFactory.getInstance().setInterface(YKLGiftBoardComponent.class, YKLGiftBoardAdapter.class);
            YKLAdapterFactory.getInstance().setInterface(YKLGiftTrackComponent.class, YKLGiftTrackAdapter.class);
            YKLAdapterFactory.getInstance().setInterface(YKLGiftComboComponent.class, YKLGiftComboAdapter.class);
            AILPAdapterFactory.getInstance().setInterface(AILPChatListComponent.class, AILPChatListYoukuAdapter.class);
            AILPAdapterFactory.getInstance().setInterface(AILPChatListComponent.class, AILPChatListYoukuAdapter.class, "block");
            AILPAdapterFactory.getInstance().setInterface(AILPChatListComponent.class, AILPChatListYoukuAdapterNew.class, "inline");
            YKLAdapterFactory.getInstance().setInterface(YKLAnimationViewComponent.class, YKLAnimationViewAdapter.class);
            YKLAdapterFactory.getInstance().setInterface(YKLNetModule.class, YKLNetSysAdapter.class);
            YKLAdapterFactory.getInstance().setInterface(YKLDownloadModule.class, YKLDownloadAdapter.class);
            WXSDKEngine.registerComponent("dago-user-list", DagoUserListComponent.class);
            WXSDKEngine.registerComponent("dago-gift-board", YKLGiftBoardComponent.class);
            WXSDKEngine.registerComponent("dago-gift-track", YKLGiftTrackComponent.class);
            WXSDKEngine.registerComponent("dago-gift-combo", YKLGiftComboComponent.class);
            WXSDKEngine.registerComponent("dago-chat-list", AILPChatListComponent.class);
            WXSDKEngine.registerComponent("dago-chat-list-ex", DagoChatListComponent.class);
            WXSDKEngine.registerComponent("dago-gift-animation", YKLAnimationViewComponent.class);
            WXSDKEngine.registerComponent("dago-like-fullscreen", DagoLikeViewComponent.class);
            WXSDKEngine.registerComponent("dago-like-view", AILPLikeViewComponent.class);
            WXSDKEngine.registerComponent("dago-anchor", YKLAnchorInfoComponent.class);
            WXSDKEngine.registerComponent("dago-slider", YKLSliderComponent.class);
            WXSDKEngine.registerComponent("dago-danmu", DagoDanmuComponent.class);
            WXSDKEngine.registerComponent("dago-youku-vip-hongbao", DagoYoukuVipHongbaoComponent.class);
            WXSDKEngine.registerModule("dago-page", YKLPageModule.class);
            WXSDKEngine.registerModule("dago-net", YKLNetModule.class);
            WXSDKEngine.registerModule("dago-screen", YKLScreenModule.class);
            WXSDKEngine.registerModule("dago-chat-input", DagoChatInputModule.class);
            WXSDKEngine.registerModule("dago-live-upload", LivePlayLogUploadModule.class);
            WXSDKEngine.registerModule("dago-download", YKLDownloadModule.class);
            WXSDKEngine.registerModule("dago-system-info", YKLSystemInfoModule.class);
            WXSDKEngine.registerModule("dago-user-card", YKLUserCardModule.class);
            WXSDKEngine.registerModule(DagoPlayerInteract.MODULE_NAME, DagoPlayerInteract.class);
            WXSDKEngine.registerModule(DagoLayoutWidgetModule.MODULE_NAME, DagoLayoutWidgetModule.class);
            WXSDKEngine.registerModule("dago-private-chat", DagoPrivateChatModule.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }
}
