package tb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zp1 {
    private static List<String> a = new ArrayList();
    private static List<String> b = new ArrayList();
    private static List<String> c;
    private static List<String> d;
    private static Map<String, Boolean> e;

    static {
        new ArrayList();
        c = new ArrayList();
        d = new ArrayList();
        e = new HashMap();
    }

    public static void a(String str) {
        a.add(str);
    }

    public static void b(String str, boolean z) {
        e.put(str, Boolean.valueOf(z));
    }

    public static void c(String str) {
        d.add(str);
    }

    public static void d(String str) {
        b.add(str);
    }

    public static boolean e(String str) {
        return a.contains(str);
    }

    public static boolean f(String str) {
        return c.contains(str);
    }

    public static boolean g(String str) {
        return e.containsKey(str);
    }

    public static boolean h(String str) {
        return d.contains(str);
    }

    public static boolean i(String str) {
        return b.contains(str);
    }

    public static boolean j(String str) {
        return e.get(str).booleanValue();
    }

    public static boolean k() {
        return b.isEmpty();
    }
}
