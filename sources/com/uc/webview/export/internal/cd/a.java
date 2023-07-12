package com.uc.webview.export.internal.cd;

import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.n;
import com.uc.webview.export.internal.utility.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class a {
    private static Map<String, String> a;
    private static String b;

    public static void a(String str) {
        int indexOf;
        int indexOf2;
        if (str != null && !str.startsWith("JSON_CMD") && (indexOf2 = str.indexOf("JSON_CMD")) != -1) {
            str = str.substring(indexOf2);
        }
        if (!p.a(str) && str.startsWith("JSON_CMD")) {
            C0350a.a(str);
        }
        if (str != null && !str.startsWith("JSON_CD") && (indexOf = str.indexOf("JSON_CD")) != -1) {
            str = str.substring(indexOf);
        }
        if (!p.a(str) && str.startsWith("JSON_CD")) {
            str.contains("pub_key");
        }
        b = str;
    }

    public static String b(String str) {
        return C0350a.b(str);
    }

    public static Boolean c(String str) {
        Map<String, String> map = a;
        String str2 = map == null ? null : map.get(str);
        return Boolean.valueOf(str2 == null ? true : "true".equalsIgnoreCase(str2));
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.cd.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class C0350a {
        private static String a = "InnerImpl";
        private static Object b = new Object();
        private static String c;
        private static Map<String, String> d;
        private static boolean e;

        public static void a(String str) {
            if (str.startsWith("JSON_CMD")) {
                synchronized (b) {
                    c = str.substring(8);
                    d = null;
                    e = false;
                }
                try {
                    n.a(new b());
                } catch (Exception e2) {
                    Log.e(a, "parser", e2);
                }
            }
        }

        public static String b(String str) {
            Map<String, String> map;
            a();
            if (c == null || d == null) {
                return null;
            }
            synchronized (b) {
                if (c == null || (map = d) == null) {
                    return null;
                }
                return map.get(str);
            }
        }

        public static void a() {
            String str;
            if (c == null || d != null || e) {
                return;
            }
            synchronized (b) {
                if (c != null && d == null && !e) {
                    try {
                        String str2 = a;
                        Log.d(str2, ".parser sCD : " + c);
                        IWaStat.WaStat.stat(IWaStat.CD_JOSN_CMD_PARSR_COUNT);
                        HashMap hashMap = new HashMap();
                        JSONObject jSONObject = new JSONObject(c);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String obj = jSONObject.get(next).toString();
                            String str3 = a;
                            Log.d(str3, ".parser key : " + next + " value: " + obj);
                            hashMap.put(next, obj);
                        }
                        d = hashMap;
                        IWaStat.WaStat.stat(IWaStat.CD_JOSN_CMD_PARSR_SUCCESS);
                    } catch (ClassCastException e2) {
                        String str4 = a;
                        Log.d(str4, ".parser cd exception java.lang.ClassCastException " + e2);
                        Log.d(a, ".parser faulure!!");
                        e = true;
                        str = IWaStat.CD_JOSN_CMD_PARSR_FAILUE;
                        IWaStat.WaStat.stat(str);
                    } catch (JSONException e3) {
                        String str5 = a;
                        Log.d(str5, ".parser cd exception org.json.JSONException " + e3);
                        Log.d(a, ".parser faulure!!");
                        e = true;
                        str = IWaStat.CD_JOSN_CMD_PARSR_FAILUE;
                        IWaStat.WaStat.stat(str);
                    } catch (Throwable th) {
                        String str6 = a;
                        Log.d(str6, ".parser cd exception java.lang.Throwable " + th);
                        Log.d(a, ".parser faulure!!");
                        e = true;
                        str = IWaStat.CD_JOSN_CMD_PARSR_FAILUE;
                        IWaStat.WaStat.stat(str);
                    }
                }
            }
        }
    }
}
