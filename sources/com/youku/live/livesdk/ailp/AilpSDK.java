package com.youku.live.livesdk.ailp;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.WXComponent;
import com.uc.webview.export.extension.UCCore;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.pages.IAilpManangerInterface;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AilpSDK {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean isInitialized;

    private static Class<? extends WXComponent> getClassForWXComponent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1401037306")) {
            return (Class) ipChange.ipc$dispatch("1401037306", new Object[]{str});
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Class<? extends WXModule> getClassForWXModule(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032263307")) {
            return (Class) ipChange.ipc$dispatch("-1032263307", new Object[]{str});
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void initAilpBaseLib(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148244539")) {
            ipChange.ipc$dispatch("-148244539", new Object[]{application});
            return;
        }
        try {
            Class.forName("com.youku.live.ailpbaselib.utils.AppContextUtils").getMethod(UCCore.LEGACY_EVENT_INIT, Application.class).invoke(null, application);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    private static void initLiveSystemUtils(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586547245")) {
            ipChange.ipc$dispatch("-586547245", new Object[]{application});
            return;
        }
        try {
            Class.forName("com.youku.livesdk2.util.LiveSystemUtils").getField("sApplication").set(null, application);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    public static void registerAll(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102091467")) {
            ipChange.ipc$dispatch("102091467", new Object[]{application});
        } else if (isInitialized) {
        } else {
            isInitialized = true;
            try {
                ((IAilpManangerInterface) Dsl.getService(IAilpManangerInterface.class)).registerAll(application);
            } catch (Throwable unused) {
            }
        }
    }

    @Deprecated
    public static void registerAllOld(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-964789968")) {
            ipChange.ipc$dispatch("-964789968", new Object[]{application});
        } else if (isInitialized) {
        } else {
            isInitialized = true;
            initLiveSystemUtils(application);
            initAilpBaseLib(application);
            registerWeexElements();
            try {
                registerModules();
                registerComponents();
            } catch (WXException e) {
                e.printStackTrace();
            }
        }
    }

    public static void registerComponents() throws WXException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293774399")) {
            ipChange.ipc$dispatch("293774399", new Object[0]);
            return;
        }
        registerWXComponent("ykl-player", "com.youku.wedome.weex.component.YKLPlayerComponent");
        registerWXComponent("ykl-chat-list", "com.youku.live.ailpweex.weex.component.AILPChatListComponent");
        registerWXComponent("ykl-chat-list-sr", "com.youku.live.ailpweex.weex.component.AILPChatListComponentNew");
        registerWXComponent("ykl-like-view", "com.youku.live.ailpweex.weex.component.AILPLikeViewComponent");
        registerWXComponent("ykl-web", "com.youku.wedome.weex.component.YKLWebComponent");
        registerWXComponent("ykl-seekbar", "com.youku.wedome.weex.component.YKLSeekBarComponent");
        registerWXComponent("ykl-danmaku", "com.youku.wedome.weex.component.YKLDanmakuComponent");
        registerWXComponent("ykl-scene-selector", "com.youku.wedome.weex.component.YKLSceneSelectorComponent");
        registerWXComponent("ykl-animation", "com.youku.wedome.weex.component.YKLAnimationViewComponent");
        registerWXComponent("ykl-mask-layer", "com.youku.wedome.weex.component.YKLMaskLayerComponent");
        registerWXComponent("ykl-progress-animation-component", "com.youku.wedome.weex.component.YKLProgressAnimationComponent");
        registerWXComponent("ykl-gift-track", "com.youku.wedome.weex.component.YKLGiftTrackComponent");
        registerWXComponent("ykl-gift-board", "com.youku.wedome.weex.component.YKLGiftBoardComponent");
        registerWXComponent("ykl-gift-event", "com.youku.wedome.weex.component.YKLGiftBoardEventComponent");
        registerWXComponent("ykl-gift-combo", "com.youku.wedome.weex.component.YKLGiftComboComponent");
        registerWXComponent("ykl-bullet-list", "com.youku.wedome.weex.component.YKLBulletTimeComponent");
        registerWXComponent("ykl-bullet-list-vertical", "com.youku.wedome.weex.component.YKLBulletTimeVerticalComponent");
        registerWXComponent("ykl-bullet-alert", "com.youku.wedome.weex.component.SixDofFloatViewComponent");
        registerWXComponent("ykl-user-list", "com.youku.wedome.weex.component.YKLUserListComponent");
    }

    public static void registerModules() throws WXException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039436562")) {
            ipChange.ipc$dispatch("-2039436562", new Object[0]);
            return;
        }
        registerWXModule("ykl-calendar", "com.youku.wedome.weex.module.YKLCalendarModule");
        registerWXModule("ykl-nav", "com.youku.wedome.weex.module.YKLNavModule");
        registerWXModule("ailp-net", "com.youku.wedome.weex.module.YKLNetModule");
        registerWXModule("ykl-pay", "com.youku.wedome.weex.module.YKLPayModule");
        registerWXModule("ailp-router", "com.youku.wedome.weex.module.YKLRouterModule");
        registerWXModule("ailp-share", "com.youku.wedome.weex.module.YKLShareModule");
        registerWXModule("ailp-user", "com.youku.wedome.weex.module.YKLUserModule");
        registerWXModule("ykl-projection-screen", "com.youku.wedome.weex.module.YKLDlnaModule");
        registerWXModule("ykl-free-flow", "com.youku.wedome.weex.module.YKLFreeFlowWeexModule");
        registerWXModule("ykl-mtop", "com.youku.wedome.weex.module.YKLMtopModule");
        registerWXModule("ailp-page", "com.youku.wedome.weex.module.YKLPageModule");
        registerWXModule("ailp-screen", "com.youku.wedome.weex.module.YKLScreenModule");
        registerWXModule("ailp-logging", "com.youku.live.ailpweex.weex.module.AILPLoggingModule");
        registerWXModule("ailp-mclient", "com.youku.live.ailpweex.weex.module.AILPMClientModule");
        registerWXModule("ailp-analytics", "com.youku.live.ailpweex.weex.module.AILPAnalyticsModule");
        registerWXModule("ailp-chat-input", "com.youku.live.ailpweex.weex.module.AILPChatInputModule");
        registerWXModule("ailp-web", "com.youku.live.ailpweex.weex.module.AILPWebModule");
        registerWXModule("ailp-interactlive", "com.youku.live.ailpweex.weex.module.AILPInteractLiveModule");
        registerWXModule("ykl-live-info", "com.youku.wedome.weex.module.YKLLiveInfoModule");
        registerWXModule("ykl-setting", "com.youku.wedome.weex.module.YKLSettingModule");
        registerWXModule("ykl-maldives", "com.youku.wedome.weex.module.YKLMaldivesModule");
        registerWXModule("ykl-live-upload", "com.youku.wedome.weex.module.LivePlayLogUploadModule");
        registerWXModule("ykl-player-interact", "com.youku.wedome.weex.module.YKLPlayerInteractModule");
        registerWXModule("ykl-chatroom", "com.youku.wedome.weex.module.YKLChatRoomModule");
        registerWXModule("ykl-room-scene", "com.youku.wedome.weex.module.YKLRoomSceneModule");
        registerWXModule("ykl-stream-address", "com.youku.wedome.weex.module.YKLStreamAddressModule");
        registerWXModule("ykl-orange", "com.youku.wedome.weex.module.YKLOrangeModule");
        registerWXModule("ykl-system-info", "com.youku.wedome.weex.module.YKLSystemInfoModule");
        registerWXModule("ykl-download", "com.youku.wedome.weex.module.YKLDownloadModule");
    }

    private static void registerWXComponent(String str, String str2) throws WXException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120893357")) {
            ipChange.ipc$dispatch("120893357", new Object[]{str, str2});
            return;
        }
        Class<? extends WXComponent> classForWXComponent = getClassForWXComponent(str2);
        if (classForWXComponent != null) {
            WXSDKEngine.registerComponent(str, classForWXComponent);
        }
    }

    private static void registerWXModule(String str, String str2) throws WXException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-911090564")) {
            ipChange.ipc$dispatch("-911090564", new Object[]{str, str2});
            return;
        }
        Class<? extends WXModule> classForWXModule = getClassForWXModule(str2);
        if (classForWXModule != null) {
            WXSDKEngine.registerModule(str, classForWXModule);
        }
    }

    private static void registerWeexElements() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-609561603")) {
            ipChange.ipc$dispatch("-609561603", new Object[0]);
            return;
        }
        try {
            Class.forName("com.youku.wedome.YKLWeexSDK").getMethod("registerAll", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}
