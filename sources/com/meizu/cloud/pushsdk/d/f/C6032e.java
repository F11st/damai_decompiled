package com.meizu.cloud.pushsdk.d.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.C9796v;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.f.e */
/* loaded from: classes10.dex */
public class C6032e {
    private static final String a = "e";

    public static long a(String str) {
        long j;
        long j2 = 0;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                j = 1;
            } else if (charAt <= 2047) {
                j = 2;
            } else {
                if (charAt >= 55296 && charAt <= 57343) {
                    j2 += 4;
                    i++;
                } else if (charAt < 65535) {
                    j = 3;
                } else {
                    j2 += 4;
                }
                i++;
            }
            j2 += j;
            i++;
        }
        return j2;
    }

    private static Object a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            return obj;
        }
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj;
        }
        if (obj instanceof Collection) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj2 : (Collection) obj) {
                jSONArray.put(a(obj2));
            }
            return jSONArray;
        } else if (obj.getClass().isArray()) {
            JSONArray jSONArray2 = new JSONArray();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONArray2.put(a(Array.get(obj, i)));
            }
            return jSONArray2;
        } else if (obj instanceof Map) {
            return a((Map) obj);
        } else {
            if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
                return obj;
            }
            if (obj.getClass().getPackage().getName().startsWith("java.")) {
                return obj.toString();
            }
            return null;
        }
    }

    public static String a() {
        return Long.toString(System.currentTimeMillis());
    }

    public static JSONObject a(Map map) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new JSONObject(map);
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object a2 = a(entry.getValue());
            try {
                jSONObject.put(str, a2);
            } catch (JSONException e) {
                C6030c.a(a, "Could not put key '%s' and value '%s' into new JSONObject: %s", str, a2, e);
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static boolean a(long j, long j2, long j3) {
        return j > j2 - j3;
    }

    public static boolean a(Context context) {
        try {
            String str = a;
            C6030c.c(str, "Checking tracker internet connectivity.", new Object[0]);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            C6030c.b(str, "Tracker connection online: %s", Boolean.valueOf(z));
            return z;
        } catch (Exception e) {
            C6030c.a(a, "Security exception checking connection: %s", e.toString());
            return true;
        }
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static String b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
            return null;
        } catch (Exception e) {
            C6030c.a(a, "getCarrier: %s", e.toString());
            return null;
        }
    }

    public static String c(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperator(telephonyManager);
            }
            return null;
        } catch (Exception e) {
            String str = a;
            C6030c.a(str, "getOperator error " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    @TargetApi(19)
    public static Point d(Context context) {
        WindowManager windowManager;
        Point point = new Point();
        Display display = null;
        try {
            windowManager = (WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW);
        } catch (Exception unused) {
            String str = a;
            C6030c.a(str, "Display.getSize isn't available on older devices.", new Object[0]);
            if (display != null) {
                point.x = display.getWidth();
                point.y = display.getHeight();
            } else {
                C6030c.a(str, "error get display", new Object[0]);
            }
        }
        if (windowManager == null) {
            return null;
        }
        display = windowManager.getDefaultDisplay();
        Display.class.getMethod("getSize", Point.class);
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(display, point);
        return point;
    }
}
