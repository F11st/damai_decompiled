package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.sdk.m.y.C4366b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.d.e */
/* loaded from: classes12.dex */
public final class C4104e {
    public static Map<String, String> a;
    public static final String[] b = {"AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AC4", "AC10", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15"};

    public static String a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            String str2 = map.get(str);
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            if (i != 0) {
                str3 = "&";
            }
            sb.append(str3);
            sb.append(str);
            sb.append("=");
            sb.append(str2);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        Map<String, String> map2;
        synchronized (C4104e.class) {
            if (a == null) {
                c(context, map);
            }
            a.putAll(C4103d.a());
            map2 = a;
        }
        return map2;
    }

    public static synchronized void a() {
        synchronized (C4104e.class) {
            a = null;
        }
    }

    public static synchronized String b(Context context, Map<String, String> map) {
        String[] strArr;
        String a2;
        synchronized (C4104e.class) {
            a(context, map);
            TreeMap treeMap = new TreeMap();
            for (String str : b) {
                if (a.containsKey(str)) {
                    treeMap.put(str, a.get(str));
                }
            }
            a2 = C4366b.a(a(treeMap));
        }
        return a2;
    }

    public static synchronized void c(Context context, Map<String, String> map) {
        synchronized (C4104e.class) {
            TreeMap treeMap = new TreeMap();
            a = treeMap;
            treeMap.putAll(C4101b.a(context, map));
            a.putAll(C4103d.a(context));
            a.putAll(C4102c.a(context));
            a.putAll(C4100a.a(context, map));
        }
    }
}
