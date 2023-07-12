package com.youku.live.livesdk.widgets.module;

import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.protocol.IDataBridgeHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoDataCenterModule extends WXModule implements Destroyable, IDataBridgeHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "DagoDataCenterModule";
    private Map<String, List<JSCallback>> mJsListeners;

    private Map<String, List<JSCallback>> getJsListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586066899")) {
            return (Map) ipChange.ipc$dispatch("-1586066899", new Object[]{this});
        }
        if (this.mJsListeners == null) {
            synchronized (this) {
                if (this.mJsListeners == null) {
                    this.mJsListeners = new HashMap();
                }
            }
        }
        return this.mJsListeners;
    }

    private List<JSCallback> getJsListenersByKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-253765357")) {
            return (List) ipChange.ipc$dispatch("-253765357", new Object[]{this, str});
        }
        Map<String, List<JSCallback>> map = this.mJsListeners;
        if (map == null) {
            LinkedList linkedList = new LinkedList();
            synchronized (this) {
                if (this.mJsListeners == null) {
                    this.mJsListeners = new HashMap();
                }
                this.mJsListeners.put(str, linkedList);
            }
            return linkedList;
        }
        List<JSCallback> list = map.get(str);
        if (list == null) {
            LinkedList linkedList2 = new LinkedList();
            synchronized (this) {
                Map<String, List<JSCallback>> map2 = this.mJsListeners;
                if (map2 != null && (list = map2.get(str)) == null) {
                    this.mJsListeners.put(str, linkedList2);
                    list = linkedList2;
                }
            }
        }
        return list;
    }

    @JSMethod
    public void addListener(String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677678815")) {
            ipChange.ipc$dispatch("-677678815", new Object[]{this, str, jSCallback});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).e(TAG, "addlistener:" + str);
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            boolean containsKey = getJsListeners().containsKey(str);
            getJsListenersByKey(str).add(jSCallback);
            if (containsKey) {
                return;
            }
            widgetEngineInstance.addDataHandler(str, (IDataBridgeHandler) this);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1433623976")) {
            ipChange.ipc$dispatch("-1433623976", new Object[]{this});
            return;
        }
        Map<String, List<JSCallback>> map = this.mJsListeners;
        this.mJsListeners = null;
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null && map != null) {
            for (Map.Entry<String, List<JSCallback>> entry : map.entrySet()) {
                widgetEngineInstance.removeDataHandler(entry.getKey(), this);
            }
        }
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-795847447")) {
            ipChange.ipc$dispatch("-795847447", new Object[]{this, str, obj, obj2});
            return;
        }
        ILog iLog = (ILog) Dsl.getService(ILog.class);
        StringBuilder sb = new StringBuilder();
        sb.append("onDataChanged:");
        sb.append(str);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append(obj != null ? JSON.toJSONString(obj) : "null");
        iLog.e(TAG, sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("key", str);
        hashMap.put("newValue", obj);
        hashMap.put("oldValue", obj2);
        List<JSCallback> jsListenersByKey = getJsListenersByKey(str);
        if (jsListenersByKey != null) {
            for (JSCallback jSCallback : jsListenersByKey) {
                if (jSCallback != null) {
                    jSCallback.invokeAndKeepAlive(hashMap);
                }
            }
        }
    }

    @JSMethod
    public void pick(String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1764184281")) {
            ipChange.ipc$dispatch("-1764184281", new Object[]{this, str, jSCallback});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance == null) {
            if (jSCallback != null) {
                jSCallback.invoke(null);
                return;
            }
            return;
        }
        Object data = widgetEngineInstance.getData(str);
        if (jSCallback != null) {
            jSCallback.invoke(data);
        }
    }

    @JSMethod
    public void put(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1620790985")) {
            ipChange.ipc$dispatch("-1620790985", new Object[]{this, str, str2});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.putData(str, str2);
        }
    }

    @JSMethod
    public void removeListener(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006697258")) {
            ipChange.ipc$dispatch("2006697258", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).e(TAG, "removeListener:" + str);
        getJsListeners().remove(str);
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler(str, this);
        }
    }

    @JSMethod
    public void removeListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1788856215")) {
            ipChange.ipc$dispatch("1788856215", new Object[]{this});
        } else {
            destroy();
        }
    }
}
