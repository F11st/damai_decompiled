package com.youku.live.dago.widgetlib.module;

import android.app.Activity;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLPageModule extends WXModule implements Destroyable, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ANIMATED_CLOSE = "0";
    private static final String ANIMATED_KEY = "animated";
    private static final String ANIMATED_OPEN = "1";
    public static final String DAGO_CONTAINER_QUIT_BLOCKER = "dagoContainerQuitBlockerProp";
    public static final String DAGO_CONTAINER_QUIT_EVENT = "onDagoContainerQuitEvent";
    private static final String NOTIFY_CL0SE = "0";
    private static final String NOTIFY_KEY = "notify";
    private static final String NOTIFY_OPEN = "1";
    public static final String WX_BACK_NOTIFY = "DAGOBackNotify";

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063927581")) {
            ipChange.ipc$dispatch("-1063927581", new Object[]{this});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.addDataHandler("onDagoContainerQuitEvent", this);
        }
    }

    private void onReceiveQuitEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333188535")) {
            ipChange.ipc$dispatch("-1333188535", new Object[]{this});
            return;
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.fireGlobalEventCallback(WX_BACK_NOTIFY, new HashMap());
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1266663920")) {
            ipChange.ipc$dispatch("1266663920", new Object[]{this});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler("onDagoContainerQuitEvent", this);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "69283840")) {
            ipChange.ipc$dispatch("69283840", new Object[]{this});
        } else {
            releaseWithNothing();
        }
    }

    @JSMethod
    public void exitWxPage(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "949803011")) {
            ipChange.ipc$dispatch("949803011", new Object[]{this, map, jSCallback, jSCallback2});
            return;
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null) {
            jSCallback2.invoke(null);
        } else if (!(wXSDKInstance.getContext() instanceof Activity)) {
            jSCallback2.invoke(null);
        } else {
            Activity activity = (Activity) this.mWXSDKInstance.getContext();
            String str = map.get("animated");
            if (!TextUtils.isEmpty(str) && activity != null) {
                if ("1".equals(str)) {
                    activity.finish();
                    jSCallback.invoke(null);
                    return;
                } else if ("0".equals(str)) {
                    activity.finish();
                    jSCallback.invoke(null);
                    return;
                } else {
                    jSCallback2.invoke(null);
                    return;
                }
            }
            jSCallback2.invoke(null);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698908527")) {
            ipChange.ipc$dispatch("-1698908527", new Object[]{this, str, obj, obj2});
        } else if ("onDagoContainerQuitEvent".equals(str)) {
            onReceiveQuitEvent();
        }
    }

    @JSMethod
    public void setBackNotify(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707586973")) {
            ipChange.ipc$dispatch("707586973", new Object[]{this, map, jSCallback, jSCallback2});
            return;
        }
        initWithNothing();
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        String str = map.get("notify");
        if (TextUtils.isEmpty(str)) {
            jSCallback2.invoke(null);
        } else if ("1".equals(str)) {
            if (widgetEngineInstance != null) {
                widgetEngineInstance.putDataOnly("dagoContainerQuitBlockerProp", Boolean.TRUE);
            }
            jSCallback.invoke(null);
        } else if ("0".equals(str)) {
            if (widgetEngineInstance != null) {
                widgetEngineInstance.putDataOnly("dagoContainerQuitBlockerProp", Boolean.FALSE);
            }
            jSCallback.invoke(null);
        } else {
            jSCallback2.invoke(null);
        }
    }
}
