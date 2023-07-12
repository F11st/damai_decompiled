package com.taobao.android.speed;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import com.tencent.open.SocialConstants;
import com.ut.mini.UTAnalytics;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TBSpeed {
    public static final String TAO_SUB_EDITION_DEFAULT = "";
    public static final String TAO_SUB_EDITION_SPEED_DEFAULT = "speed_-1";
    public static final String TAO_SUB_EDITION_SPEED_GRAY = "speed_-2";
    public static final String TAO_SUB_EDITION_STANDARD_GRAY = "standard_-2";
    private static OConfigListener a = null;
    private static boolean b = true;
    private static boolean c;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    private static boolean g;
    private static Map<String, Boolean> h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static String m;
    private static String[] n;
    private static Context o;
    private static String p;
    private static Object q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.speed.TBSpeed$a */
    /* loaded from: classes11.dex */
    public static class C6636a extends TypeReference<Map<String, Boolean>> {
        C6636a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.speed.TBSpeed$b */
    /* loaded from: classes11.dex */
    public static class C6637b implements OConfigListener {
        C6637b() {
        }

        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            Map<String, String> configs = OrangeConfig.getInstance().getConfigs(str);
            String str2 = configs == null ? "" : configs.get("isSpeedEnable");
            boolean booleanValue = TextUtils.isEmpty(str2) ? true : Boolean.valueOf(str2).booleanValue();
            if (TBSpeed.b != booleanValue) {
                TBSpeed.g("taobao_speed_switch_enable", booleanValue);
                boolean unused = TBSpeed.b = booleanValue;
                Log.e("TBSpeed", "orange update, set speedSwithEnable=" + booleanValue);
                TBSpeed.i(TBSpeed.l, TBSpeed.h, true);
            }
            String str3 = configs == null ? "" : configs.get("speedOpen");
            boolean booleanValue2 = TextUtils.isEmpty(str3) ? false : Boolean.valueOf(str3).booleanValue();
            if (TBSpeed.c != booleanValue2) {
                TBSpeed.g("taobao_speed_open", booleanValue2);
                Log.e("TBSpeed", "orange update, set speedOpen=" + booleanValue2);
            }
            String str4 = configs == null ? "" : configs.get("speedGray");
            boolean booleanValue3 = TextUtils.isEmpty(str4) ? false : Boolean.valueOf(str4).booleanValue();
            if (TBSpeed.d != booleanValue3) {
                TBSpeed.g("taobao_speed_gray", booleanValue3);
                Log.e("TBSpeed", "orange update, set speedGray=" + booleanValue3);
            }
            String str5 = configs != null ? configs.get("speedBlackList") : "";
            if (TextUtils.equals(str5, TBSpeed.m)) {
                return;
            }
            TBSpeed.h("taobao_speed_open_blacklist", str5);
            Log.e("TBSpeed", "orange update, set blackListSP=" + str5);
        }
    }

    static {
        new LinkedList();
        q = new Object();
    }

    private static boolean a(String str, boolean z) {
        Context context = o;
        if (context == null) {
            return z;
        }
        try {
            return b(context).getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    private static SharedPreferences b(Context context) {
        return context.getSharedPreferences("taobao_speed", 0);
    }

    private static String c(String str, String str2) {
        Context context = o;
        if (context == null) {
            return str2;
        }
        try {
            return b(context).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void d() {
        String c2;
        if (f) {
            return;
        }
        synchronized (q) {
            if (f) {
                return;
            }
            k = c("taobao_speed_desc", "");
            boolean a2 = a("taobao_speed_switch_enable", true);
            b = a2;
            if (!a2) {
                j = "";
                f = true;
                Log.e("TBSpeed", "init speedSwithEnable=false");
                return;
            }
            boolean a3 = a("taobao_speed_proxy_enable", false);
            e = a3;
            if (a3) {
                g = true;
                j = TAO_SUB_EDITION_SPEED_DEFAULT;
                f = true;
                Log.e("TBSpeed", "init speedProxyEnable=true, set isClientSpeed=true");
                return;
            }
            String c3 = c("taobao_speed_open_blacklist", "");
            m = c3;
            if (!TextUtils.isEmpty(c3)) {
                n = m.split(",");
            }
            Log.e("TBSpeed", "init openBlackLlist, set openBlackLlist=" + m);
            boolean a4 = a("taobao_speed_open", false);
            c = a4;
            if (a4) {
                g = true;
                f = true;
                Log.e("TBSpeed", "init speedOpen=true, set isClientSpeed=true");
                return;
            }
            boolean a5 = a("taobao_speed_gray", false);
            d = a5;
            if (a5) {
                e();
                f = true;
                Log.e("TBSpeed", "init speedGray=true, set isClientSpeed=" + g);
                return;
            }
            i = c("taobao_sub_edition_pass_params", "");
            String c4 = c("taobao_sub_edition", "");
            j = c4;
            l = c4;
            try {
                c2 = c("taobao_speed_biz_map", "");
                Log.w("TBSpeed", "read bizMapJson=" + c2);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(c2)) {
                f = true;
                return;
            }
            h = (Map) JSON.parseObject(c2, new C6636a(), new Feature[0]);
            f = true;
        }
    }

    private static void e() {
        String c2 = c("taobao_speed_utdid", "");
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        try {
            if (Math.abs(c2.hashCode() % 100) < 50) {
                g = true;
            } else {
                g = false;
            }
        } catch (Throwable unused) {
        }
    }

    private static void f() {
        try {
            if (a == null) {
                a = new C6637b();
                boolean z = true;
                OrangeConfig.getInstance().registerListener(new String[]{"taobao_speed"}, a, true);
                Map<String, String> configs = OrangeConfig.getInstance().getConfigs("taobao_speed");
                String str = configs == null ? "" : configs.get("isSpeedEnable");
                if (!TextUtils.isEmpty(str)) {
                    z = Boolean.valueOf(str).booleanValue();
                }
                b = z;
            }
        } catch (Throwable th) {
            Log.e("TBSpeed", "register orange listener failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(String str, boolean z) {
        Context context = o;
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = b(context).edit();
            edit.putBoolean(str, z);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    public static String getCurrentSpeedStatus() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("speedOpen=");
        stringBuffer.append(c);
        stringBuffer.append(", speedGray=");
        stringBuffer.append(d);
        stringBuffer.append(", speedSwitch=");
        stringBuffer.append(b);
        stringBuffer.append(", speedProxy=");
        stringBuffer.append(e);
        stringBuffer.append(", blackList=");
        stringBuffer.append(m);
        stringBuffer.append(", bizIds=");
        Map<String, Boolean> map = h;
        if (map != null && !map.isEmpty()) {
            for (String str : h.keySet()) {
                Boolean bool = h.get(str);
                if (bool != null && bool.booleanValue()) {
                    stringBuffer.append(str);
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String getHomeBuckets() {
        return p;
    }

    public static String getSpeedDesc(Context context) {
        try {
            if (o == null && context != null) {
                o = context.getApplicationContext();
            }
            d();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(k)) {
            return null;
        }
        return k;
    }

    public static String getSpeedPassParams() {
        return i;
    }

    public static String getSubEdition() {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(String str, String str2) {
        Context context = o;
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = b(context).edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i(String str, Map<String, Boolean> map, boolean z) {
        synchronized (TBSpeed.class) {
            if (!c && !d) {
                if (e) {
                    str = TAO_SUB_EDITION_SPEED_DEFAULT;
                } else if (!b) {
                    str = "";
                    map.clear();
                }
                if (map != null) {
                    if (!map.equals(h)) {
                        h("taobao_speed_biz_map", JSON.toJSONString(map));
                    }
                } else {
                    h("taobao_speed_biz_map", "");
                }
                if (!TextUtils.equals(str, l)) {
                    l = str;
                    Log.e("TBSpeed", "save subEdition " + str);
                    h("taobao_sub_edition", str);
                    if (z) {
                        j = str;
                        h = map;
                        if (TextUtils.equals(str, TAO_SUB_EDITION_SPEED_DEFAULT)) {
                            g = true;
                        } else {
                            g = false;
                        }
                        Log.e("TBSpeed", "updateSpeedStatus, set isClientSpeed " + g);
                        updateUTParams();
                    }
                }
            }
        }
    }

    @Deprecated
    public static boolean isSpeedEdition(Context context) {
        return false;
    }

    public static boolean isSpeedEdition(Context context, String str) {
        try {
            if (o == null && context != null) {
                o = context.getApplicationContext();
            }
            d();
        } catch (Throwable unused) {
        }
        if (g) {
            String[] strArr = n;
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return false;
                }
            }
            return true;
        }
        Map<String, Boolean> map = h;
        if (map == null || !map.containsKey(str)) {
            return false;
        }
        return h.get(str).booleanValue();
    }

    @Deprecated
    public static void registerSpeedSwitchListener(ISpeedSwitchListener iSpeedSwitchListener) {
    }

    public static void setSpeedEdition(Context context, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            h("taobao_speed_desc", map.get(SocialConstants.PARAM_APP_DESC));
            for (String str2 : map.keySet()) {
                if (Boolean.valueOf(map.get(str2)).booleanValue()) {
                    hashMap.put(str2, Boolean.TRUE);
                }
            }
        }
        try {
            if (o == null) {
                o = context.getApplicationContext();
            }
            d();
            f();
            i(str, hashMap, false);
        } catch (Throwable unused) {
        }
    }

    public static void setSpeedPassParams(String str) {
        if (c || d || TextUtils.equals(i, str)) {
            return;
        }
        i = str;
        h("taobao_sub_edition_pass_params", str);
    }

    @Deprecated
    public static void unregisterSpeedSwitchListener(ISpeedSwitchListener iSpeedSwitchListener) {
    }

    public static void updateHomeBuckets(String str) {
        p = str;
    }

    public static void updateSpeedProxy(Context context, boolean z) {
        if (!c && !d) {
            try {
                if (e == z) {
                    return;
                }
                e = z;
                g("taobao_speed_proxy_enable", z);
                Log.d("TBSpeed", "update proxy, set speedProxyEnable=" + e);
                i(z ? TAO_SUB_EDITION_SPEED_DEFAULT : "", h, true);
            } catch (Throwable unused) {
            }
        }
    }

    public static void updateSpeedUtdid(String str) {
        if (o != null && TextUtils.isEmpty(c("taobao_speed_utdid", ""))) {
            h("taobao_speed_utdid", str);
        }
    }

    public static void updateUTParams() {
        String str;
        if (c) {
            return;
        }
        if (d) {
            str = g ? TAO_SUB_EDITION_SPEED_GRAY : TAO_SUB_EDITION_STANDARD_GRAY;
        } else {
            str = j;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                UTAnalytics.getInstance().getDefaultTracker().setGlobalProperty("x-v-s", str);
            } else {
                UTAnalytics.getInstance().getDefaultTracker().removeGlobalProperty("x-v-s");
            }
        } catch (Throwable unused) {
        }
    }
}
