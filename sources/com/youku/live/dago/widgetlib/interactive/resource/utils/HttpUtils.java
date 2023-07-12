package com.youku.live.dago.widgetlib.interactive.resource.utils;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.util.ReflectUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HttpUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String HTTP_GET_RESOURCE = "mtop.youku.live.resource.get";
    public static String HTTP_GET_RESOURCE_GROUP_LIST = "mtop.youku.live.resource.app.get";
    public static String HTTP_GET_RESOURCE_LIST = "mtop.youku.live.resource.app.get";

    private static void buildMtopBussiness(MtopBusiness mtopBusiness, String str, Map<String, String> map, boolean z, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2081564288")) {
            ipChange.ipc$dispatch("2081564288", new Object[]{mtopBusiness, str, map, Boolean.valueOf(z), mtopFinishListener});
            return;
        }
        mtopBusiness.reqMethod(z ? MethodEnum.GET : MethodEnum.POST);
        mtopBusiness.headers(buildRequestHeader(str, map));
        mtopBusiness.registerListener(mtopFinishListener);
    }

    private static void buildMtopRequest(MtopRequest mtopRequest, String str, String str2, boolean z, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028277732")) {
            ipChange.ipc$dispatch("1028277732", new Object[]{mtopRequest, str, str2, Boolean.valueOf(z), map});
            return;
        }
        mtopRequest.setApiName(str);
        mtopRequest.setVersion(str2);
        mtopRequest.setNeedEcode(z);
        mtopRequest.setData(ReflectUtil.convertMapToDataStr(map));
    }

    private static Map<String, String> buildRequestHeader(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1093644823") ? (Map) ipChange.ipc$dispatch("-1093644823", new Object[]{str, map}) : new HashMap();
    }

    private static void doRequest(Context context, String str, String str2, Map<String, String> map, boolean z, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1132260315")) {
            ipChange.ipc$dispatch("1132260315", new Object[]{context, str, str2, map, Boolean.valueOf(z), mtopFinishListener});
        } else {
            buildMtopRequest(new MtopRequest(), str, str2, false, map);
        }
    }

    public static void getResourceById(Context context, String str, String str2, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1195462072")) {
            ipChange.ipc$dispatch("1195462072", new Object[]{context, str, str2, mtopFinishListener});
            return;
        }
        HashMap hashMap = new HashMap(16);
        hashMap.put("appName", str);
        String str3 = HTTP_GET_RESOURCE;
        hashMap.put("resId", str2);
        doRequest(context, str3, "1.0", hashMap, true, mtopFinishListener);
    }
}
