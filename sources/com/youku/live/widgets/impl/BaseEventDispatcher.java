package com.youku.live.widgets.impl;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.monitor.OnlineMonitor;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.protocol.IEventDispatcher;
import com.youku.live.widgets.protocol.IEventHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import tb.hh1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseEventDispatcher implements IEventDispatcher {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, List<IEventHandler>> mHandlerMap;

    private List<IEventHandler> getEventHandlerOfType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "888650903")) {
            return (List) ipChange.ipc$dispatch("888650903", new Object[]{this, str});
        }
        Map<String, List<IEventHandler>> handlerMap = getHandlerMap();
        List<IEventHandler> list = handlerMap.containsKey(str) ? handlerMap.get(str) : null;
        if (list == null) {
            LinkedList linkedList = new LinkedList();
            handlerMap.put(str, linkedList);
            return linkedList;
        }
        return list;
    }

    private Map<String, List<IEventHandler>> getHandlerMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2049675434")) {
            return (Map) ipChange.ipc$dispatch("2049675434", new Object[]{this});
        }
        if (this.mHandlerMap == null) {
            synchronized (this) {
                if (this.mHandlerMap == null) {
                    this.mHandlerMap = new HashMap();
                }
            }
        }
        return this.mHandlerMap;
    }

    @Override // com.youku.live.widgets.protocol.IEventDispatcher
    public boolean addEventHandler(String str, IEventHandler iEventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701446754")) {
            return ((Boolean) ipChange.ipc$dispatch("-701446754", new Object[]{this, str, iEventHandler})).booleanValue();
        }
        if (iEventHandler == null) {
            OnlineMonitor.loge(WidgetSDKEngine.TAG, new HashMap<String, String>(str, iEventHandler) { // from class: com.youku.live.widgets.impl.BaseEventDispatcher.1
                final /* synthetic */ String val$eventTypeIn;
                final /* synthetic */ IEventHandler val$handlerIn;

                {
                    this.val$eventTypeIn = str;
                    this.val$handlerIn = iEventHandler;
                    put("errorCode", "");
                    put(hh1.DIMEN_MESSAGE, "BaseEventDispatcher.addEventHandler(" + str + "," + iEventHandler + jn1.BRACKET_END_STR);
                }
            });
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        getEventHandlerOfType(str).add(iEventHandler);
        return true;
    }

    public void clear() {
        List<IEventHandler> value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1081654160")) {
            ipChange.ipc$dispatch("-1081654160", new Object[]{this});
            return;
        }
        Map<String, List<IEventHandler>> handlerMap = getHandlerMap();
        for (Map.Entry<String, List<IEventHandler>> entry : handlerMap.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.clear();
            }
        }
        handlerMap.clear();
        this.mHandlerMap = null;
    }

    @Override // com.youku.live.widgets.protocol.IEventDispatcher
    public void deleteEventHandler(String str, IEventHandler iEventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454430604")) {
            ipChange.ipc$dispatch("-1454430604", new Object[]{this, str, iEventHandler});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        getEventHandlerOfType(str).remove(iEventHandler);
    }

    @Override // com.youku.live.widgets.protocol.IEventDispatcher
    public void postEvent(int i, String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1428381989")) {
            ipChange.ipc$dispatch("-1428381989", new Object[]{this, Integer.valueOf(i), str, map});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        for (IEventHandler iEventHandler : getEventHandlerOfType(str)) {
            if (iEventHandler != null) {
                iEventHandler.onEvent(str, map);
            }
        }
    }
}
