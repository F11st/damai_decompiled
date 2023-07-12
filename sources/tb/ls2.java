package tb;

import java.lang.reflect.Method;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ls2 {
    private static Class<?> a;
    private static Method b;

    public static void a(String str, int i, Object obj, Object obj2, Object obj3, String... strArr) {
        Class<?> cls;
        try {
            if (c() == null || (cls = a) == null) {
                return;
            }
            b.invoke(cls, str, Integer.valueOf(i), obj, obj2, obj3, strArr);
        } catch (Exception e) {
            TBSdkLog.e("MtopWVPlugin.UTAdapter", "UTAdapter commit(String pageName,int eventId, Object arg1,Object arg2,Object arg3,String ... kvs) failed ---" + e.toString());
        }
    }

    public static void b(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        try {
            a(str, i, str2, str3, str4, d(map));
        } catch (Throwable unused) {
        }
    }

    public static Method c() {
        Method method = b;
        if (method != null) {
            return method;
        }
        try {
            Class<?> loadClass = ls2.class.getClassLoader().loadClass("com.taobao.statistic.TBS$Ext");
            a = loadClass;
            if (loadClass != null) {
                b = loadClass.getDeclaredMethod("commitEvent", String.class, Integer.TYPE, Object.class, Object.class, Object.class, String[].class);
            }
        } catch (Exception e) {
            TBSdkLog.e("MtopWVPlugin.UTAdapter", "Connot Found \"TBS.Ext.commitEvent(String, int, Object, Object, Object, String...)\" Method ---" + e.toString());
        }
        return b;
    }

    private static String[] d(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return new String[0];
        }
        String[] strArr = new String[map.size()];
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                strArr[0] = "";
            } else {
                strArr[0] = key + "=" + value;
            }
        }
        return strArr;
    }
}
