package tb;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.log.IDXRemoteDebugLog;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.youku.arch.v3.data.Constants;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class s00 {
    public static IDXRemoteDebugLog a;

    private static String a(String str, String str2, DXTemplateItem dXTemplateItem, Map<String, String> map, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        sb.append(str);
        sb.append("]:");
        sb.append(str2);
        sb.append("|");
        JSONObject jSONObject = new JSONObject();
        if (dXTemplateItem != null) {
            jSONObject.put(Constants.TEMPLATE, (Object) dXTemplateItem.name);
            jSONObject.put("version", (Object) Long.valueOf(dXTemplateItem.version));
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), (Object) entry.getValue());
            }
        }
        if (str3 != null) {
            jSONObject.put("error", (Object) str3);
        }
        sb.append(jSONObject.toJSONString());
        return sb.toString();
    }

    public static void b(String str) {
        d(nz.TAG, nz.TAG, str);
    }

    public static void c(String str, String str2, DXTemplateItem dXTemplateItem, Map<String, String> map, String str3) {
        d(nz.TAG, nz.TAG, a(str, str2, dXTemplateItem, map, str3));
    }

    public static void d(String str, String str2, String str3) {
        IDXRemoteDebugLog iDXRemoteDebugLog = a;
        if (iDXRemoteDebugLog != null) {
            try {
                iDXRemoteDebugLog.loge(str, str2, str3);
                return;
            } catch (Throwable unused) {
                Log.i(str2, str3);
                return;
            }
        }
        Log.i(str2, str3);
    }

    public static void e(String str) {
        f(nz.TAG, nz.TAG, str);
    }

    public static void f(String str, String str2, String str3) {
        IDXRemoteDebugLog iDXRemoteDebugLog = a;
        if (iDXRemoteDebugLog != null) {
            try {
                iDXRemoteDebugLog.logi(str, str2, str3);
                return;
            } catch (Throwable unused) {
                Log.i(str2, str3);
                return;
            }
        }
        Log.i(str2, str3);
    }

    public static void g(IDXRemoteDebugLog iDXRemoteDebugLog) {
        a = iDXRemoteDebugLog;
    }
}
