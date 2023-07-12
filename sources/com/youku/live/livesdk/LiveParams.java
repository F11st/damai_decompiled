package com.youku.live.livesdk;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.youku.live.livesdk.constants.DagoDataCenterConstants;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.constants.SchemaConstants;
import com.youku.live.widgets.WidgetInstance;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LiveParams {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Map<String, String> parseParams(Uri uri, Bundle bundle, WidgetInstance widgetInstance) {
        List<String> pathSegments;
        long j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007149007")) {
            return (Map) ipChange.ipc$dispatch("2007149007", new Object[]{uri, bundle, widgetInstance});
        }
        HashMap hashMap = new HashMap();
        if (uri != null) {
            String uri2 = uri.toString();
            putData(widgetInstance, SDKConstants.SDK_PAGE_URL, uri2);
            hashMap.put(MtopJSBridge.MtopJSParam.PAGE_URL, uri2);
        }
        String str = null;
        if (uri != null && (pathSegments = uri.getPathSegments()) != null && pathSegments.size() > 0) {
            String str2 = pathSegments.get(0);
            try {
                j = Long.valueOf(str2).longValue();
            } catch (Exception unused) {
                j = -1;
            }
            if (j >= 0) {
                str = str2;
            }
        }
        if (TextUtils.isEmpty(str) && uri != null) {
            for (String str3 : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str3);
                hashMap.put(str3, queryParameter);
                if ("id".equals(str3)) {
                    str = queryParameter;
                }
            }
        }
        if (str != null) {
            putData(widgetInstance, DagoDataCenterConstants.DAGO_LIVE_ID, str);
            hashMap.put("id", str);
            hashMap.put("liveId", str);
        }
        if (uri != null) {
            String queryParameter2 = uri.getQueryParameter(SchemaConstants.SCHEMA_QUERY_WX_URL);
            if (!TextUtils.isEmpty(queryParameter2)) {
                putData(widgetInstance, SDKConstants.SDK_DEBUG_STATIC_WEEX_BUNDLE, URLDecoder.decode(queryParameter2));
            }
            String queryParameter3 = uri.getQueryParameter("sdkversion");
            if (!TextUtils.isEmpty(queryParameter3)) {
                putData(widgetInstance, SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION, URLDecoder.decode(queryParameter3));
            }
            String queryParameter4 = uri.getQueryParameter("layout");
            if (!TextUtils.isEmpty(queryParameter4)) {
                putData(widgetInstance, SDKConstants.SDK_DEBUG_LAYOUT, URLDecoder.decode(queryParameter4));
            }
        }
        if (bundle != null) {
            for (String str4 : bundle.keySet()) {
                Object obj = bundle.get(str4);
                if (obj instanceof String) {
                    hashMap.put(str4, (String) obj);
                }
            }
        }
        return hashMap;
    }

    private static void putData(WidgetInstance widgetInstance, String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1542411571")) {
            ipChange.ipc$dispatch("-1542411571", new Object[]{widgetInstance, str, obj});
        } else if (widgetInstance != null) {
            widgetInstance.putData(str, obj);
        }
    }
}
