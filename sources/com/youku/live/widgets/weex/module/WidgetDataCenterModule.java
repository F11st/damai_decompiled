package com.youku.live.widgets.weex.module;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
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
/* loaded from: classes3.dex */
public class WidgetDataCenterModule extends WXModule implements Destroyable, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, JSCallback> mJsListeners;

    private Map<String, JSCallback> getJsListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860585445")) {
            return (Map) ipChange.ipc$dispatch("1860585445", new Object[]{this});
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

    @JSMethod
    public void addListener(String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-514805031")) {
            ipChange.ipc$dispatch("-514805031", new Object[]{this, str, jSCallback});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            boolean containsKey = getJsListeners().containsKey(str);
            getJsListeners().put(str, jSCallback);
            if (containsKey) {
                return;
            }
            widgetEngineInstance.addDataHandler(str, this);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "873644448")) {
            ipChange.ipc$dispatch("873644448", new Object[]{this});
            return;
        }
        Map<String, JSCallback> map = this.mJsListeners;
        this.mJsListeners = null;
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null && map != null) {
            for (Map.Entry<String, JSCallback> entry : map.entrySet()) {
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
        if (AndroidInstantRuntime.support(ipChange, "-1935992783")) {
            ipChange.ipc$dispatch("-1935992783", new Object[]{this, str, obj, obj2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("key", str);
        hashMap.put("newValue", obj);
        hashMap.put("oldValue", obj2);
        JSCallback jSCallback = getJsListeners().get(str);
        if (jSCallback != null) {
            jSCallback.invokeAndKeepAlive(hashMap);
        }
    }

    @JSMethod
    public void pick(String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251568751")) {
            ipChange.ipc$dispatch("1251568751", new Object[]{this, str, jSCallback});
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
        if (AndroidInstantRuntime.support(ipChange, "358330495")) {
            ipChange.ipc$dispatch("358330495", new Object[]{this, str, str2});
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
        if (AndroidInstantRuntime.support(ipChange, "1728440034")) {
            ipChange.ipc$dispatch("1728440034", new Object[]{this, str});
            return;
        }
        getJsListeners().remove(str);
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler(str, this);
        }
    }

    @JSMethod
    public void removeListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "181804767")) {
            ipChange.ipc$dispatch("181804767", new Object[]{this});
        } else {
            destroy();
        }
    }
}
