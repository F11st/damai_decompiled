package com.ut.mini.mtop;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.x.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.cv0;
import tb.ga;
import tb.hl2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class UTMtopConfigMgr {
    private static Map<String, Map<String, UTPageConfigValue>> mPageMap = new ConcurrentHashMap();
    private static Map<String, String> mPageUtparamMap = new ConcurrentHashMap();

    UTMtopConfigMgr() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void activateMtopConfig(final String str) {
        hl2.c().f(new Runnable() { // from class: com.ut.mini.mtop.UTMtopConfigMgr.1
            @Override // java.lang.Runnable
            public void run() {
                UTMtopConfigMgr.parseConfigData(str);
            }
        });
    }

    private static Map<String, String> getMapForPage(String str) {
        Map<String, UTPageConfigValue> map = mPageMap.get(str);
        if (map != null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, UTPageConfigValue> entry : map.entrySet()) {
                String key = entry.getKey();
                String valuesForKey = getValuesForKey(entry.getValue());
                if (!isEmpty(key) && !isEmpty(valuesForKey)) {
                    hashMap.put(key, valuesForKey);
                }
            }
            return hashMap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getUtparamCnt(String str) {
        if (isEmpty(str)) {
            return null;
        }
        try {
            return mPageUtparamMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getValuesForKey(UTPageConfigValue uTPageConfigValue) {
        if (uTPageConfigValue == null) {
            return null;
        }
        List<String> list = uTPageConfigValue.valueList;
        if (isEmpty(list)) {
            return null;
        }
        String str = uTPageConfigValue.separator;
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str2 : list) {
            if (z) {
                sb.append(str2);
                z = false;
            } else {
                sb.append(str);
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    static void parseConfig(String str) {
        if (isEmpty(str)) {
            return;
        }
        try {
            Map map = (Map) JSON.parseObject(str, Map.class);
            if (isEmpty(map)) {
                return;
            }
            Object obj = map.get(c.c);
            if (obj instanceof List) {
                List<JSONObject> list = (List) obj;
                synchronized (UTMtopConfigMgr.class) {
                    for (JSONObject jSONObject : list) {
                        UTMtopConfig uTMtopConfig = (UTMtopConfig) JSON.toJavaObject(jSONObject, UTMtopConfig.class);
                        List<UTMtopPageValue> list2 = uTMtopConfig.pageValueList;
                        if (!isEmpty(list2)) {
                            String str2 = uTMtopConfig.key;
                            String str3 = uTMtopConfig.separator;
                            for (UTMtopPageValue uTMtopPageValue : list2) {
                                String str4 = uTMtopPageValue.page;
                                List<String> list3 = uTMtopPageValue.valueList;
                                if (!isEmpty(str4) && !isEmpty(list3)) {
                                    Map<String, UTPageConfigValue> map2 = mPageMap.containsKey(str4) ? mPageMap.get(str4) : null;
                                    if (map2 == null) {
                                        map2 = new ConcurrentHashMap<>();
                                        mPageMap.put(str4, map2);
                                    }
                                    UTPageConfigValue uTPageConfigValue = map2.containsKey(str2) ? map2.get(str2) : null;
                                    if (uTPageConfigValue == null) {
                                        uTPageConfigValue = new UTPageConfigValue();
                                        uTPageConfigValue.separator = str3;
                                        map2.put(str2, uTPageConfigValue);
                                    }
                                    boolean z = false;
                                    for (String str5 : list3) {
                                        if (setValue(uTPageConfigValue, str5)) {
                                            z = true;
                                        }
                                    }
                                    if (z) {
                                        Map<String, String> mapForPage = getMapForPage(str4);
                                        if (!isEmpty(mapForPage)) {
                                            String jSONString = JSON.toJSONString(mapForPage);
                                            if (!isEmpty(str4)) {
                                                mPageUtparamMap.put(str4, jSONString);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void parseConfigData(String str) {
        byte[] b;
        try {
            Logger.f("UTMtopConfigMgr", "parseConfigData", str);
            byte[] a = ga.a(str.getBytes("UTF-8"), 2);
            if (a == null || (b = cv0.b(a)) == null) {
                return;
            }
            parseConfig(new String(b, 0, b.length));
        } catch (Throwable unused) {
        }
    }

    private static boolean setValue(UTPageConfigValue uTPageConfigValue, String str) {
        if (uTPageConfigValue.valueList.contains(str)) {
            return false;
        }
        uTPageConfigValue.valueList.add(str);
        return true;
    }

    private static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    private static boolean isEmpty(Map map) {
        return map == null || map.size() == 0;
    }
}
