package tb;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.ut.mini.UTAnalytics;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ms2 {
    private static Map<String, JSONObject> a = new HashMap();
    private static Map<String, Object> b = new HashMap();
    private static Map<String, Object> c = new HashMap();

    public static Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.get(next) != null) {
                    hashMap.put(next, jSONObject.get(next) + "");
                } else {
                    hashMap.put(next, "");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static void b(String str) {
        Map<String, String> a2 = a(str);
        if (a2 == null || a2.isEmpty()) {
            return;
        }
        ft2 ft2Var = new ft2();
        ft2Var.d(a2.get("kn"));
        ft2Var.e(a2.get("v"));
        ft2Var.f(a2.get(ft2.TYPE_FAR));
        UTAnalytics.getInstance().getDefaultTracker().addTPKItem(ft2Var);
    }

    public static Object c(String str) {
        return a.get(str);
    }

    public static Map d() {
        return c;
    }

    public static Object e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pageSpmPre", UTAnalytics.getInstance().getDefaultTracker().getPageSpmPre((Activity) context));
        } catch (Exception e) {
            Log.e("ut4aplus", "", e);
        }
        return jSONObject;
    }

    public static Object f(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pageSpmUrl", UTAnalytics.getInstance().getDefaultTracker().getPageSpmUrl((Activity) context));
        } catch (Exception e) {
            Log.e("ut4aplus", "", e);
        }
        return jSONObject;
    }

    public static Map g() {
        return b;
    }

    private static void h(Context context, Map<String, String> map) {
        try {
            if (map.containsKey("isRefresh")) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("_h5_refresh", "1");
                UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(context, hashMap);
            }
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }

    private static void i(Context context) {
        try {
            HashMap hashMap = new HashMap(1);
            hashMap.put("ut4aplus", "1");
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(context, hashMap);
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }

    public static void j(Context context, String str) {
        mb1.e("params", str);
        try {
            Map<String, String> a2 = a(str);
            if (context != null) {
                if ("true".equals(a2.get("isSPA"))) {
                    UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(context);
                }
                UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(context);
            } else {
                mb1.e(null, "cannot get pageObject");
            }
            h(context, a2);
            i(context);
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }

    public static void k(Context context, String str) {
        mb1.e(null, "params", str);
        try {
            new JSONObject(str);
        } catch (Exception e) {
            Log.e("ut4aplus", "", e);
        }
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(context);
    }

    public static void l(String str) {
        a.remove(str);
    }

    public static void m(Context context) {
    }

    public static void n(String str, String str2) {
        try {
            a.put(str, new JSONObject(str2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void o(String str) {
        Map<String, String> a2 = a(str);
        if (a2 == null || a2.isEmpty()) {
            return;
        }
        for (String str2 : a2.keySet()) {
            UTAnalytics.getInstance().getDefaultTracker().setGlobalProperty(str2, a2.get(str2));
        }
    }

    public static void p(String str) {
        UTAnalytics.getInstance().turnOnRealTimeDebug(a(str));
    }

    public static void q(String str) {
        mb1.e(null, "params", str);
        try {
            UTAnalytics.getInstance().getDefaultTracker().updateNextPageProperties(a(str));
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }

    public static void r(String str) {
        mb1.e(null, "params", str);
        try {
            UTAnalytics.getInstance().getDefaultTracker().updateNextPageUtparam(str);
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }

    public static void s(Context context, String str) {
        mb1.e(null, "params", str);
        try {
            UTAnalytics.getInstance().getDefaultTracker().updatePageName(context, a(str).get("pageName"));
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }

    public static void t(Context context, String str) {
        mb1.e(null, "params", str);
        try {
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(context, a(str));
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }

    public static void u(Context context, String str) {
        mb1.e(null, "params", str);
        try {
            String str2 = a(str).get("pageURL");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            UTAnalytics.getInstance().getDefaultTracker().updatePageUrl(context, Uri.parse(str2));
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }

    public static void v(Context context, String str) {
        mb1.d(null, "params", str);
        try {
            UTAnalytics.getInstance().getDefaultTracker().updatePageUtparam(context, str);
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }

    public static void w(String str) {
        UTAnalytics.getInstance().updateSessionProperties(a(str));
    }

    public static void x(String str) {
        Map<String, String> a2 = a(str);
        UTAnalytics.getInstance().updateUserAccount(a2.get("userNick"), a2.get("userId"), a2.get("openId"));
    }

    public static void y(String str) {
        UTAnalytics.getInstance().userRegister(a(str).get("userNick"));
    }

    public static void z(String str) {
        Map hashMap;
        try {
            Map<String, String> a2 = a(str);
            if (a2 != null) {
                String remove = a2.remove("pageName");
                int intValue = Integer.valueOf(a2.remove("eventId") + "").intValue();
                String remove2 = a2.remove("arg1");
                String remove3 = a2.remove("arg2");
                String remove4 = a2.remove(UTDataCollectorNodeColumn.ARG3);
                String remove5 = a2.remove("args");
                if (!TextUtils.isEmpty(remove5)) {
                    hashMap = a(remove5);
                } else {
                    hashMap = new HashMap();
                }
                UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(remove, intValue, remove2, remove3, remove4, hashMap).build());
            }
        } catch (Throwable th) {
            Log.e("ut4aplus", "", th);
        }
    }
}
