package cn.damai.ultron.net;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import cn.damai.ultron.net.api.UltronCreateOrder;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.device.UTDevice;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import tb.vt2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UltronParamsMaker {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Map<String, String> addExtraParams(Context context, Map<String, String> map) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-575357006")) {
            return (Map) ipChange.ipc$dispatch("-575357006", new Object[]{context, map});
        }
        if (map == null) {
            map = new HashMap<>();
        }
        String str2 = map.get(Request.K_EXPARAMS);
        JSONObject jSONObject = null;
        try {
            jSONObject = str2 != null ? JSON.parseObject(str2) : new JSONObject();
        } catch (Exception unused) {
            vt2.b("ParamsMaker", "exParams json 转换错误");
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            str = context.getResources().getConfiguration().locale.toString();
        } catch (Exception unused2) {
            vt2.b("ParamsMaker", "addExtraParams", "获取locale 参数报错");
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("websiteLanguage", (Object) str);
        }
        putData(map, Request.K_EXPARAMS, jSONObject.toJSONString());
        return map;
    }

    public static int getPurchaseFrom(Intent intent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1125549124") ? ((Integer) ipChange.ipc$dispatch("1125549124", new Object[]{intent})).intValue() : intent.getIntExtra("purchase_from", 3);
    }

    private static Map<String, String> getQueryParameterMap(Uri uri) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1148771468")) {
            return (Map) ipChange.ipc$dispatch("1148771468", new Object[]{uri});
        }
        if (uri != null && !uri.isOpaque()) {
            String encodedQuery = uri.getEncodedQuery();
            if (encodedQuery == null) {
                return new HashMap();
            }
            HashMap hashMap = new HashMap();
            do {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                hashMap.put(Uri.decode(encodedQuery.substring(i, indexOf2)), Uri.decode(indexOf2 < indexOf ? encodedQuery.substring(indexOf2 + 1, indexOf) : ""));
                i = indexOf + 1;
            } while (i < encodedQuery.length());
            return hashMap;
        }
        return new HashMap();
    }

    public static Map<String, String> makeAdjustOrderParams(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "269698813")) {
            return (Map) ipChange.ipc$dispatch("269698813", new Object[]{str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("feature", "{\"gzip\":\"true\"}");
        hashMap.put("params", str);
        return hashMap;
    }

    public static Map<String, String> makeBuildOrderParams(Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "33186457")) {
            return (Map) ipChange.ipc$dispatch("33186457", new Object[]{context, intent});
        }
        HashMap hashMap = new HashMap();
        int intExtra = intent.getIntExtra("purchase_from", 2);
        if (intExtra == 1) {
            Map map = (Map) intent.getSerializableExtra("buildOrderParams");
            if (map != null) {
                return addExtraParams(context, map);
            }
            hashMap.put("buyNow", "false");
            putData(hashMap, "cartIds", trimCartIds(intent.getStringExtra("cartIds")));
            putData(hashMap, "buyParam", intent.getStringExtra("buyParam"));
            putData(hashMap, "bookingDate", intent.getStringExtra("bookingDate"));
            putData(hashMap, "entranceDate", intent.getStringExtra("entranceDate"));
        } else if (intExtra == 2) {
            hashMap.put("buyNow", "true");
            putData(hashMap, "itemId", intent.getStringExtra("itemId"));
            putData(hashMap, Request.K_EXPARAMS, intent.getStringExtra(Request.K_EXPARAMS));
            putData(hashMap, "buyParam", intent.getStringExtra("buyParam"));
            return addExtraParams(context, hashMap);
        }
        return addExtraParams(context, getQueryParameterMap(intent.getData()));
    }

    public static Map<String, String> makeCreateOrderParams(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893902222")) {
            return (Map) ipChange.ipc$dispatch("-893902222", new Object[]{context});
        }
        HashMap hashMap = new HashMap();
        String utdid = UTDevice.getUtdid(context);
        if (!TextUtils.isEmpty(utdid)) {
            hashMap.put(UltronCreateOrder.K_ORDER_MARKER, "v:utdid=" + utdid);
        }
        return hashMap;
    }

    private static void putData(Map<String, String> map, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218207133")) {
            ipChange.ipc$dispatch("218207133", new Object[]{map, str, str2});
        } else if (str2 != null) {
            map.put(str, str2);
        }
    }

    private static String trimCartIds(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-796617353") ? (String) ipChange.ipc$dispatch("-796617353", new Object[]{str}) : (str == null || !str.endsWith(",")) ? str : str.substring(0, str.length() - 1);
    }

    private static String urlDecode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225370754")) {
            return (String) ipChange.ipc$dispatch("-1225370754", new Object[]{str});
        }
        if (str != null) {
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        return null;
    }
}
