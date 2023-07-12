package anet.channel.strategy.dispatch;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AmdcRuntimeInfo {
    private static volatile int a;
    private static volatile long b;
    private static IAmdcSign c;
    public static volatile double d;
    public static volatile double e;
    public static volatile String f;
    public static volatile String g;
    public static volatile String h;
    private static Map<String, String> i;
    private static volatile int j;
    private static volatile List<String> k;
    private static volatile boolean l;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface ControlMode {
        public static final int CONTROL_MODE_BLACK = 2;
        public static final int CONTROL_MODE_NONE = 0;
        public static final int CONTROL_MODE_WHITE = 1;
    }

    public static int a() {
        if (a > 0 && System.currentTimeMillis() - b > 0) {
            b = 0L;
            a = 0;
        }
        return a;
    }

    public static synchronized Map<String, String> b() {
        synchronized (AmdcRuntimeInfo.class) {
            if (i == null) {
                return Collections.EMPTY_MAP;
            }
            return new HashMap(i);
        }
    }

    public static IAmdcSign c() {
        return c;
    }

    public static boolean d(String str) {
        if (j != 0 && k != null && !k.isEmpty() && !TextUtils.isEmpty(str)) {
            if (j == 1) {
                return k.contains(str);
            }
            if (j == 2) {
                return !k.contains(str);
            }
        }
        return true;
    }

    public static boolean e() {
        return l;
    }

    public static void f(String str, String str2, String str3) {
        g = str;
        h = str2;
        f = str3;
    }

    public static void g(Context context) {
    }

    public static void h(int i2, List<String> list) {
        if ((i2 == 1 || i2 == 2) && list != null && !list.isEmpty()) {
            j = i2;
            k = new ArrayList(list);
            ALog.e("awcn.AmdcRuntimeInfo", "[setControlMode]", null, "mode", Integer.valueOf(j), "list", k);
            return;
        }
        j = 0;
        ALog.e("awcn.AmdcRuntimeInfo", "[setControlMode]", null, "mode", Integer.valueOf(j));
    }

    public static void i(IAmdcSign iAmdcSign) {
        c = iAmdcSign;
    }

    public static void j(boolean z) {
        l = z;
    }

    public static void k(int i2, int i3) {
        ALog.f("awcn.AmdcRuntimeInfo", "set amdc limit", null, "level", Integer.valueOf(i2), "time", Integer.valueOf(i3));
        if (i2 < 0 || i2 > 3) {
            return;
        }
        a = i2;
        b = System.currentTimeMillis() + (i3 * 1000);
    }
}
