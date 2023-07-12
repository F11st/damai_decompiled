package com.youku.live.widgets;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.live.widgets.render.RenderMananger;
import com.youku.live.widgets.weex.module.WidgetEventDispatcherModule;
import com.youku.live.widgets.weex.module.WidgetLayerManangerModule;
import com.youku.live.widgets.widgets.web.WebWidget;
import com.youku.live.widgets.widgets.weex.WeexWidget;
import java.util.Map;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class WidgetSDKEngine {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "YoukuLiveWidgetKit";
    private static WidgetSDKEngine sManager;
    private static Orientation sOrientation = Orientation.ORIENTATION_PORTAIT;
    private RenderMananger mRenderManager;

    private WidgetSDKEngine() {
        this(new RenderMananger());
    }

    public static WidgetSDKEngine getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618495365")) {
            return (WidgetSDKEngine) ipChange.ipc$dispatch("-1618495365", new Object[0]);
        }
        if (sManager == null) {
            synchronized (WidgetSDKEngine.class) {
                if (sManager == null) {
                    sManager = new WidgetSDKEngine();
                }
            }
        }
        return sManager;
    }

    public static Orientation getOrientation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1716607565") ? (Orientation) ipChange.ipc$dispatch("1716607565", new Object[0]) : sOrientation;
    }

    public static void initWithParams(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1144056861")) {
            ipChange.ipc$dispatch("-1144056861", new Object[]{map});
            return;
        }
        registerWidget("Web", WebWidget.class);
        registerWidget(gn1.TYPE_OPEN_URL_WEEX, WeexWidget.class);
        try {
            WXSDKEngine.registerModule("dg-layer-manager", WidgetLayerManangerModule.class);
            WXSDKEngine.registerModule("dg-event-dispatcher", WidgetEventDispatcherModule.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }

    public static void registerPlugin(String str, Class<? extends IPlugin> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961085141")) {
            ipChange.ipc$dispatch("-961085141", new Object[]{str, cls});
        } else {
            WidgetSDKManager.getInstance().registerPlugin(str, cls);
        }
    }

    public static void registerWidget(String str, Class<? extends IWidget> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1195317116")) {
            ipChange.ipc$dispatch("1195317116", new Object[]{str, cls});
        } else {
            WidgetSDKManager.getInstance().registerWidget(str, cls);
        }
    }

    public static void setOrientation(Orientation orientation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1373280521")) {
            ipChange.ipc$dispatch("1373280521", new Object[]{orientation});
        } else {
            sOrientation = orientation;
        }
    }

    public RenderMananger getRenderMananger() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1669107067") ? (RenderMananger) ipChange.ipc$dispatch("-1669107067", new Object[]{this}) : this.mRenderManager;
    }

    private WidgetSDKEngine(RenderMananger renderMananger) {
        this.mRenderManager = renderMananger;
    }
}
