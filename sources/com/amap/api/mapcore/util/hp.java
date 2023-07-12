package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.lu2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class hp {

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.hp$a */
    /* loaded from: classes10.dex */
    static class C4578a {
        public static hp a = new hp();
    }

    private static gm a(String str, List<gm> list) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; list != null && i < list.size(); i++) {
            gm gmVar = list.get(i);
            if (gmVar != null) {
                String[] g = gmVar.g();
                for (String str2 : g) {
                    if (!TextUtils.isEmpty(g[i]) && str.contains(str2)) {
                        return gmVar;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private JSONArray a(String str) {
        if (str == null) {
            str = "";
        }
        String[] strArr = {"AMapPboRenderThread", "GLThread", "AMapGlRenderThread", "AMapThreadUtil", "GNaviMap", lu2.MAIN};
        JSONArray jSONArray = new JSONArray();
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread != null && !str.equals(thread.getName())) {
                for (int i = 0; i < 6; i++) {
                    String str2 = strArr[i];
                    String name = thread.getName();
                    if (((TextUtils.isEmpty(str2) || TextUtils.isEmpty(name) || (!str2.contains(name) && !name.contains(str2))) ? false : true) && a(thread) != null) {
                        jSONArray.put(a(thread));
                    }
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject a(Thread thread) {
        if (thread == null || thread.getStackTrace() == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("threadName", thread.getName());
            jSONObject.put("threadGroup", thread.getThreadGroup());
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement);
                stringBuffer.append("<br />");
            }
            jSONObject.put("stacks", stringBuffer.toString());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final boolean a(Context context, String str, String str2, List<gm> list, boolean z, gm gmVar) {
        String str3 = "";
        if (str2 != null) {
            for (Thread thread : Thread.getAllStackTraces().keySet()) {
                if (thread != null && !TextUtils.isEmpty(thread.getName()) && (str2.contains(thread.getName()) || thread.getName().contains(str2))) {
                    StackTraceElement[] stackTrace = thread.getStackTrace();
                    if (stackTrace != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            stringBuffer.append("at ");
                            stringBuffer.append(stackTraceElement);
                            stringBuffer.append("<br />");
                        }
                        str3 = stringBuffer.toString();
                    }
                }
            }
            str3 = null;
        }
        gm a = a(str3, list);
        if (z && a == null) {
            return false;
        }
        String str4 = str + "<br />" + str3;
        JSONArray a2 = a(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashStack", str4);
            jSONObject.put("backStacks", a2);
        } catch (Throwable unused) {
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return false;
        }
        if (!z && a == null) {
            hd.b(context, gmVar, jSONObject2, "NATIVE_APP_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
            return true;
        }
        hd.a(context, a, jSONObject2, "NATIVE_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
        return true;
    }
}
