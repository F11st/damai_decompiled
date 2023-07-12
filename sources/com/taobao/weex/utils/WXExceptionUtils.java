package com.taobao.weex.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.adapter.IWXJSExceptionAdapter;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXJSExceptionInfo;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.performance.WXStateRecord;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.gz2;
import tb.jn1;
import tb.oz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXExceptionUtils {
    private static Set<String> a = new CopyOnWriteArraySet();
    public static String degradeUrl = "BundleUrlDefaultDegradeUrl";

    private static boolean a(String str, WXErrorCode wXErrorCode, String str2) {
        Set<String> set;
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        if (wXErrorCode == null || wXErrorCode.getErrorGroup() == WXErrorCode.ErrorGroup.JS) {
            if (TextUtils.isEmpty(str)) {
                str = "instanceIdNull";
            }
            if (str2.length() > 200) {
                str2 = str2.substring(0, 200);
            }
            WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str);
            if (wXSDKInstance == null) {
                set = a;
            } else {
                set = wXSDKInstance.getApmForInstance().q;
            }
            if (set == null) {
                return true;
            }
            if (set.contains(str2)) {
                return false;
            }
            set.add(str2);
            return true;
        }
        return true;
    }

    private static String b(WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance == null || wXSDKInstance.getApmForInstance() == null || wXSDKInstance.getApmForInstance().d.isEmpty()) {
            return "noStageRecord";
        }
        ArrayList<Map.Entry> arrayList = new ArrayList(wXSDKInstance.getApmForInstance().d.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Long>>() { // from class: com.taobao.weex.utils.WXExceptionUtils.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
                return (int) (entry.getValue().longValue() - entry2.getValue().longValue());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : arrayList) {
            sb.append((String) entry.getKey());
            sb.append(jn1.CONDITION_IF_MIDDLE);
            sb.append(entry.getValue());
            sb.append("->");
        }
        return sb.toString();
    }

    public static void commitCriticalExceptionRT(@Nullable String str, @Nullable WXErrorCode wXErrorCode, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map) {
        try {
            WXLogUtils.e("weex", "commitCriticalExceptionRT :" + wXErrorCode + "exception" + str3);
            WXStateRecord.d().k(str, str3);
            IWXConfigAdapter J = WXSDKManager.v().J();
            if (!(J != null ? "true".equalsIgnoreCase(J.getConfig(oz2.WXAPM_CONFIG_GROUP, "check_repeat_report", "true")) : true ? a(str, wXErrorCode, str3) : true)) {
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        commitCriticalExceptionWithDefaultUrl("BundleUrlDefault", str, wXErrorCode, str2, str3, map);
    }

    public static void commitCriticalExceptionWithDefaultUrl(@Nullable String str, @Nullable String str2, @Nullable WXErrorCode wXErrorCode, @Nullable String str3, @Nullable String str4, @Nullable Map<String, String> map) {
        String str5;
        String str6;
        IWXJSExceptionAdapter p = WXSDKManager.v().p();
        if (TextUtils.isEmpty(str)) {
            str = "BundleUrlDefault";
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        map2.put("wxSdkInitStartTime", String.valueOf(WXEnvironment.sSDKInitStart));
        map2.put("wxSDKInitCostTime", String.valueOf(WXEnvironment.sSDKInitTime));
        map2.put("wxSDKCurExceptionTime", String.valueOf(System.currentTimeMillis()));
        map2.put("wxUseRuntimeApi", String.valueOf(WXEnvironment.sUseRunTimeApi));
        if (!TextUtils.isEmpty(str2)) {
            WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str2);
            if (wXSDKInstance != null) {
                str = wXSDKInstance.getApmForInstance().m;
                Object obj = wXSDKInstance.getApmForInstance().j.get(WXInstanceApm.VALUE_BUNDLE_LOAD_LENGTH);
                map2.put(WXInstanceApm.VALUE_BUNDLE_LOAD_LENGTH, obj instanceof Integer ? String.valueOf(obj) : "unknownLength");
                map2.put("templateInfo", wXSDKInstance.getTemplateInfo());
                if (TextUtils.isEmpty(str) || str.equals("default")) {
                    if (!TextUtils.equals(degradeUrl, "BundleUrlDefaultDegradeUrl")) {
                        str = degradeUrl;
                    } else {
                        str = WXSDKInstance.requestUrl;
                    }
                }
                for (Map.Entry<String, String> entry : wXSDKInstance.getContainerInfo().entrySet()) {
                    map2.put(entry.getKey(), entry.getValue());
                }
                map2.put("wxStageList", b(wXSDKInstance));
                String template = wXSDKInstance.getTemplate();
                map2.put("wxTemplateOfBundle", template == null ? "has recycle by gc" : template.substring(0, Math.min(template.length(), 300)));
                Long l = wXSDKInstance.getApmForInstance().d.get(WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START);
                if (l == null) {
                    l = wXSDKInstance.getApmForInstance().d.get(WXInstanceApm.KEY_PAGE_STAGES_RENDER_ORGIGIN);
                }
                if (l != null) {
                    map2.put("wxUseTime", String.valueOf(WXUtils.getFixUnixTime() - l.longValue()));
                }
            }
            str5 = str;
            str6 = str2;
        } else {
            if (map2.size() > 0) {
                str = TextUtils.isEmpty(map2.get("weexUrl")) ? map2.get("weexUrl") : map2.get("bundleUrl");
            }
            str5 = str;
            str6 = "InstanceIdDefalut";
        }
        String str7 = map2.get("errorCode");
        if (str7 != null && str7.length() > 200) {
            map2.remove("errorCode");
        }
        WXJSExceptionInfo wXJSExceptionInfo = new WXJSExceptionInfo(str6, str5, wXErrorCode, str3, str4, map2);
        if (p != null) {
            p.onJSException(wXJSExceptionInfo);
        }
        gz2.b(wXJSExceptionInfo, str2);
    }
}
