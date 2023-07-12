package com.youku.live.dago.module;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoLayoutWidgetModule extends WXModule implements Destroyable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MODULE_NAME = "dago-layout-widget";

    private static IWidget findWidget(IEngineInstance iEngineInstance, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1961633144")) {
            return (IWidget) ipChange.ipc$dispatch("1961633144", new Object[]{iEngineInstance, str});
        }
        if (iEngineInstance == null || str == null) {
            return null;
        }
        return iEngineInstance.findWidgetById(str);
    }

    @JSMethod
    public void call(String str, String str2, JSONObject jSONObject, final JSCallback jSCallback, final JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114356214")) {
            ipChange.ipc$dispatch("2114356214", new Object[]{this, str, str2, jSONObject, jSCallback, jSCallback2});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(MODULE_NAME, "call widgetName: " + str + ", methodName: " + str2 + ", methodParams: " + jSONObject.toJSONString());
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        IWidget findWidget = findWidget(widgetEngineInstance, str);
        if (findWidget instanceof ICall) {
            ((ICall) findWidget).call(widgetEngineInstance, str2, jSONObject, jSCallback != null ? new IResult() { // from class: com.youku.live.dago.module.DagoLayoutWidgetModule.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.widgets.protocol.IResult
                public void onResult(Map<String, Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2031323632")) {
                        ipChange2.ipc$dispatch("2031323632", new Object[]{this, map});
                        return;
                    }
                    JSCallback jSCallback3 = jSCallback;
                    if (jSCallback3 != null) {
                        jSCallback3.invoke(map);
                    }
                }
            } : null, jSCallback2 != null ? new IResult() { // from class: com.youku.live.dago.module.DagoLayoutWidgetModule.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.widgets.protocol.IResult
                public void onResult(Map<String, Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2042639759")) {
                        ipChange2.ipc$dispatch("2042639759", new Object[]{this, map});
                        return;
                    }
                    JSCallback jSCallback3 = jSCallback2;
                    if (jSCallback3 != null) {
                        jSCallback3.invoke(map);
                    }
                }
            } : null);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356112524")) {
            ipChange.ipc$dispatch("356112524", new Object[]{this});
        }
    }
}
