package com.youku.live.dago.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn;
import com.youku.live.dago.widgetlib.view.bottombar.BottomBarView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.SimpleWidgetDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.WidgetInitDTO;
import com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin;
import com.youku.live.livesdk.wkit.widget.LiveWeexWidget;
import com.youku.live.livesdk.wkit.widget.view.WeexWidgetView;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BottomBarWidget extends BaseWidget implements BaseBottomBarBtn.OnBtnClickListener, DagoChannelPlugin.Receiver, ICall, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String METHOD_CHAT_POSITION = "chatPosition";
    private static final String METHOD_CHAT_WIDTH = "chatWidth";
    private static final String METHOD_HIDE = "hide";
    private static final String METHOD_SHOW = "show";
    public static final String TAG = "DagoBottomBarWidget";
    public static final String WIDGET_NAME = "BottomBar";
    private BottomBarView mBottomBarView;
    private FrameLayout mRoot;

    private void fireGlobalEvent(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "295586144")) {
            ipChange.ipc$dispatch("295586144", new Object[]{this, str, map});
            return;
        }
        WXSDKInstance wXSDKInstance = null;
        LiveWeexWidget findLiveWeexWidget = findLiveWeexWidget("live-weex", "LiveWeex");
        if (findLiveWeexWidget != null) {
            View realView = findLiveWeexWidget.getRealView();
            if (realView instanceof WeexWidgetView) {
                wXSDKInstance = ((WeexWidgetView) realView).getWXSDKInstance();
            }
        }
        if (wXSDKInstance != null) {
            wXSDKInstance.fireGlobalEventCallback(str, map);
        }
    }

    private void initDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328808006")) {
            ipChange.ipc$dispatch("-328808006", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IPlugin findPluginByName = engineInstance.findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                ((DagoChannelPlugin) findPluginByName).addListener(this);
            }
        }
    }

    private void initDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1139869921")) {
            ipChange.ipc$dispatch("-1139869921", new Object[]{this});
        } else {
            getEngineInstance().addDataHandler("mtop.youku.live.com.livefullinfo", this);
        }
    }

    private void releaseDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652163197")) {
            ipChange.ipc$dispatch("-652163197", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IPlugin findPluginByName = engineInstance.findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                ((DagoChannelPlugin) findPluginByName).removeListener(this);
            }
        }
    }

    private void releaseDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904897334")) {
            ipChange.ipc$dispatch("904897334", new Object[]{this});
        } else {
            getEngineInstance().removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        }
    }

    private void updateAnchorInfoWidgetAttribute(LiveFullInfoData liveFullInfoData, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723491354")) {
            ipChange.ipc$dispatch("-723491354", new Object[]{this, liveFullInfoData, jSONObject});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "trustDataJson: " + jSONObject.toJSONString());
        BottomBarView bottomBarView = this.mBottomBarView;
        if (bottomBarView == null || liveFullInfoData == null) {
            return;
        }
        bottomBarView.setParams(liveFullInfoData);
        this.mBottomBarView.setOpenChat(jSONObject.getInteger("openChat").intValue());
    }

    private void updateWithLiveFullInfo(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184903612")) {
            ipChange.ipc$dispatch("-1184903612", new Object[]{this, liveFullInfoData});
            return;
        }
        WidgetInitDTO widgetInitDTO = liveFullInfoData.widgets;
        JSON json = null;
        List<SimpleWidgetDTO> list = widgetInitDTO != null ? widgetInitDTO.widgetList : null;
        if (list != null) {
            Iterator<SimpleWidgetDTO> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleWidgetDTO next = it.next();
                if (!TextUtils.isEmpty(next.name) && next.name.equals("chat")) {
                    json = next.trustData;
                    break;
                }
            }
        }
        if (json instanceof JSONObject) {
            updateAnchorInfoWidgetAttribute(liveFullInfoData, (JSONObject) json);
        }
    }

    @Override // com.youku.live.widgets.protocol.ICall
    public void call(IEngineInstance iEngineInstance, String str, Map<String, Object> map, IResult iResult, IResult iResult2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895280606")) {
            ipChange.ipc$dispatch("-895280606", new Object[]{this, iEngineInstance, str, map, iResult, iResult2});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "call : " + str);
        if ("show".equals(str)) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "call show");
            BottomBarView bottomBarView = this.mBottomBarView;
            if (bottomBarView != null) {
                bottomBarView.setOpenChat(1);
            }
        } else if ("hide".equals(str)) {
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "call hide");
            BottomBarView bottomBarView2 = this.mBottomBarView;
            if (bottomBarView2 != null) {
                bottomBarView2.setOpenChat(0);
            }
        } else if (METHOD_CHAT_WIDTH.equals(str)) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "call width: " + map);
            if (map.containsKey("width")) {
                float parseFloat = Float.parseFloat(String.valueOf(map.get("width")));
                BottomBarView bottomBarView3 = this.mBottomBarView;
                if (bottomBarView3 != null) {
                    bottomBarView3.setChatWidth((int) parseFloat);
                }
            }
        } else if (METHOD_CHAT_POSITION.equals(str)) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "call chatPosition: " + map);
            float parseFloat2 = map.containsKey("left") ? Float.parseFloat(String.valueOf(map.get("left"))) : 0.0f;
            float parseFloat3 = map.containsKey("top") ? Float.parseFloat(String.valueOf(map.get("top"))) : 0.0f;
            float parseFloat4 = map.containsKey("right") ? Float.parseFloat(String.valueOf(map.get("right"))) : 0.0f;
            float parseFloat5 = map.containsKey("bottom") ? Float.parseFloat(String.valueOf(map.get("bottom"))) : 0.0f;
            BottomBarView bottomBarView4 = this.mBottomBarView;
            if (bottomBarView4 != null) {
                bottomBarView4.setChatPosition((int) parseFloat2, (int) parseFloat3, (int) parseFloat4, (int) parseFloat5);
            }
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251504938")) {
            ipChange.ipc$dispatch("251504938", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "didDisappear: " + this.mBottomBarView);
        releaseDagoChannelListener();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544644340")) {
            ipChange.ipc$dispatch("544644340", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "didMount: " + this.mBottomBarView);
        BottomBarView bottomBarView = this.mBottomBarView;
        if (bottomBarView != null) {
            bottomBarView.setVisibility(0);
        }
        initDataCenter();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-422062963")) {
            ipChange.ipc$dispatch("-422062963", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "didUnmount: " + this.mBottomBarView);
        BottomBarView bottomBarView = this.mBottomBarView;
        if (bottomBarView != null) {
            bottomBarView.reset();
        }
        releaseDataCenter();
    }

    public LiveWeexWidget findLiveWeexWidget(String str, String str2) {
        List<IWidget> findWidgetsByName;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823329165")) {
            return (LiveWeexWidget) ipChange.ipc$dispatch("1823329165", new Object[]{this, str, str2});
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IWidget findWidgetById = engineInstance.findWidgetById(str);
            LiveWeexWidget liveWeexWidget = findWidgetById instanceof LiveWeexWidget ? (LiveWeexWidget) findWidgetById : null;
            if (liveWeexWidget != null || (findWidgetsByName = engineInstance.findWidgetsByName(str2)) == null) {
                return liveWeexWidget;
            }
            for (IWidget iWidget : findWidgetsByName) {
                if (iWidget instanceof LiveWeexWidget) {
                    return (LiveWeexWidget) iWidget;
                }
            }
            return liveWeexWidget;
        }
        return null;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239942809")) {
            return (View) ipChange.ipc$dispatch("1239942809", new Object[]{this, context});
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initHostView: " + context);
        this.mRoot = new FrameLayout(context);
        BottomBarView bottomBarView = new BottomBarView(context);
        this.mBottomBarView = bottomBarView;
        this.mRoot.addView(bottomBarView, -1, -1);
        return this.mRoot;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-273614351")) {
            ipChange.ipc$dispatch("-273614351", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
            return;
        }
        super.initWithData(iEngineInstance, iWidget, iWidgetData);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initWithData: " + this.mBottomBarView);
        this.mBottomBarView.initChilds(this);
    }

    @Override // com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn.OnBtnClickListener
    public void onClick(BaseBottomBarBtn baseBottomBarBtn) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179756767")) {
            ipChange.ipc$dispatch("-1179756767", new Object[]{this, baseBottomBarBtn});
        } else if (baseBottomBarBtn != null && baseBottomBarBtn.getType() == 0) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "onClick TYPE_EDIT");
            HashMap hashMap = new HashMap();
            hashMap.put("name", "chat");
            fireGlobalEvent("openWidgetEvent", hashMap);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111862035")) {
            ipChange.ipc$dispatch("1111862035", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str) && (obj instanceof LiveFullInfoData)) {
            updateWithLiveFullInfo((LiveFullInfoData) obj);
        }
    }

    @Override // com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.Receiver
    public void onMessage(DagoChannelPlugin.Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1584691525")) {
            ipChange.ipc$dispatch("1584691525", new Object[]{this, message});
        } else if (message == null || message.msgType == null) {
        } else {
            ((ILog) Dsl.getService(ILog.class)).i("LIVE_STATE_CHANGE", message.msgType);
            if (LiveManager.LIVE_STATE_CHANGE.equals(message.msgType)) {
                try {
                    ((ILog) Dsl.getService(ILog.class)).i("LIVE_STATE_CHANGE", JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("body").toJSONString());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959570023")) {
            ipChange.ipc$dispatch("1959570023", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "willAppear: " + this.mBottomBarView);
        initDagoChannelListener();
    }
}
