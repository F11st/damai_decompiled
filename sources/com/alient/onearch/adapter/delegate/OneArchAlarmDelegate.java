package com.alient.onearch.adapter.delegate;

import com.ali.user.open.core.util.ParamsConstants;
import com.alient.onearch.adapter.monitor.CMSMtopMonitorPoint;
import com.alient.onearch.adapter.monitor.CMSRenderMonitorPoint;
import com.alient.onearch.adapter.monitor.MonitorConstant;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.LoaderEvent;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.tq2;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u000f"}, d2 = {"Lcom/alient/onearch/adapter/delegate/OneArchAlarmDelegate;", "Lcom/alient/onearch/adapter/delegate/BasicDelegate;", "Lcom/youku/kubus/Event;", "event", "Ltb/wt2;", "onReceiveComponentNotSupport", "onReceiveModuleChildrenEmpty", "onReceiveComponentChildrenEmpty", "onReceiveItemDataEmpty", "onReceiveCoroutineRunFailed", "onReceiveComponentRenderFailed", "onReceiveRemoteRequestFailed", "onReceiveRemoteRequestSuccess", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class OneArchAlarmDelegate extends BasicDelegate {
    @Subscribe(eventType = {ArchExceptionEvent.COMPONENT_CHILDREN_EMPTY})
    public final void onReceiveComponentChildrenEmpty(@NotNull Event event) {
        b41.i(event, "event");
    }

    @Subscribe(eventType = {ArchExceptionEvent.COMPONENT_NOT_SUPPORT})
    public final void onReceiveComponentNotSupport(@NotNull Event event) {
        b41.i(event, "event");
    }

    @Subscribe(eventType = {ArchExceptionEvent.COMPONENT_RENDER_FAILED})
    public final void onReceiveComponentRenderFailed(@NotNull Event event) {
        b41.i(event, "event");
        Object obj = event.data;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap == null) {
            return;
        }
        Object obj2 = hashMap.get("type");
        Object obj3 = obj2 instanceof Integer ? (Integer) obj2 : null;
        Object obj4 = hashMap.get("errorMsg");
        String str = obj4 instanceof String ? (String) obj4 : null;
        CMSRenderMonitorPoint.Companion companion = CMSRenderMonitorPoint.Companion;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("scope", "component");
        if (obj3 == null) {
            obj3 = "none";
        }
        hashMap.put("type", obj3);
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("errorMsg", str);
        wt2 wt2Var = wt2.INSTANCE;
        companion.commitCMSRenderMonitorFail(MonitorConstant.COMPONENT_RENDER_ERROR, "ComponentRenderFailed", linkedHashMap);
    }

    @Subscribe(eventType = {ArchExceptionEvent.COROUTINE_RUN_FAILED})
    public final void onReceiveCoroutineRunFailed(@NotNull Event event) {
        b41.i(event, "event");
        if (AppInfoProviderProxy.isDebuggable()) {
            return;
        }
        Object obj = event.data;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap == null) {
            return;
        }
        Object obj2 = hashMap.get("errorMsg");
        String str = obj2 instanceof String ? (String) obj2 : null;
        CMSRenderMonitorPoint.Companion companion = CMSRenderMonitorPoint.Companion;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("errorMsg", str);
        wt2 wt2Var = wt2.INSTANCE;
        companion.commitCMSRenderMonitorFail(MonitorConstant.COROUTINE_RUN_FAILED, "CoroutineRunFailed", linkedHashMap);
    }

    @Subscribe(eventType = {ArchExceptionEvent.ITEM_DATA_EMPTY})
    public final void onReceiveItemDataEmpty(@NotNull Event event) {
        b41.i(event, "event");
    }

    @Subscribe(eventType = {ArchExceptionEvent.MODULE_CHILDREN_EMPTY})
    public final void onReceiveModuleChildrenEmpty(@NotNull Event event) {
        b41.i(event, "event");
    }

    @Subscribe(eventType = {LoaderEvent.REMOTE_REQUEST_FAILED})
    public final void onReceiveRemoteRequestFailed(@NotNull Event event) {
        String str;
        String str2;
        b41.i(event, "event");
        if (AppInfoProviderProxy.isDebuggable()) {
            return;
        }
        Object obj = event.data;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap == null) {
            return;
        }
        Object obj2 = hashMap.get("apiName");
        String str3 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = hashMap.get(ParamsConstants.Key.PARAM_TRACE_ID);
        String str4 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = hashMap.get("retCode");
        String str5 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = hashMap.get("retMessage");
        String str6 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = hashMap.get("apiParams");
        Map map = tq2.n(obj6) ? (Map) obj6 : null;
        if (map != null && (str2 = (String) map.get("patternName")) != null) {
            str3 = ((Object) str3) + '_' + str2;
        }
        if (map != null && (str = (String) map.get("patternVersion")) != null) {
            str3 = ((Object) str3) + '_' + str;
        }
        Object obj7 = hashMap.get("responseData");
        String str7 = obj7 instanceof String ? (String) obj7 : null;
        CMSMtopMonitorPoint.Companion companion = CMSMtopMonitorPoint.Companion;
        String str8 = str3 == null ? "" : str3;
        String str9 = str5 == null ? "" : str5;
        String str10 = str6 == null ? "" : str6;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str4 == null) {
            str4 = "";
        }
        linkedHashMap.put(ParamsConstants.Key.PARAM_TRACE_ID, str4);
        if (str7 == null) {
            str7 = "";
        }
        linkedHashMap.put("responseData", str7);
        wt2 wt2Var = wt2.INSTANCE;
        companion.commitCMSMtopMonitorFail(str8, str9, str10, linkedHashMap, false);
    }

    @Subscribe(eventType = {LoaderEvent.REMOTE_REQUEST_SUCCESS})
    public final void onReceiveRemoteRequestSuccess(@NotNull Event event) {
        String str;
        String str2;
        b41.i(event, "event");
        if (AppInfoProviderProxy.isDebuggable()) {
            return;
        }
        Object obj = event.data;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap == null) {
            return;
        }
        Object obj2 = hashMap.get("apiName");
        String str3 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = hashMap.get(ParamsConstants.Key.PARAM_TRACE_ID);
        String str4 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = hashMap.get("retCode");
        String str5 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = hashMap.get("retMessage");
        String str6 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = hashMap.get("apiParams");
        Map map = tq2.n(obj6) ? (Map) obj6 : null;
        if (map != null && (str2 = (String) map.get("patternName")) != null) {
            str3 = ((Object) str3) + '_' + str2;
        }
        if (map != null && (str = (String) map.get("patternVersion")) != null) {
            str3 = ((Object) str3) + '_' + str;
        }
        CMSMtopMonitorPoint.Companion companion = CMSMtopMonitorPoint.Companion;
        String str7 = str3 == null ? "" : str3;
        String str8 = str5 == null ? "" : str5;
        String str9 = str6 == null ? "" : str6;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str4 == null) {
            str4 = "";
        }
        linkedHashMap.put(ParamsConstants.Key.PARAM_TRACE_ID, str4);
        wt2 wt2Var = wt2.INSTANCE;
        companion.commitCMSMtopMonitorFail(str7, str8, str9, linkedHashMap, true);
    }
}
