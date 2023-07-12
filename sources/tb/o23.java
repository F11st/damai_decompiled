package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class o23 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static int c = 5;
    private static String d = "nobelKey";
    private Map<String, String> a;
    private Map<String, String> b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.o23$b */
    /* loaded from: classes4.dex */
    public static class C9501b {
        private static final o23 a = new o23();
    }

    public static String b(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390615318")) {
            return (String) ipChange.ipc$dispatch("390615318", new Object[]{str, Integer.valueOf(i), str2});
        }
        return d(str) + m80.DINAMIC_PREFIX_AT + i + m80.DINAMIC_PREFIX_AT + str2;
    }

    public static final o23 c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1009842757") ? (o23) ipChange.ipc$dispatch("-1009842757", new Object[0]) : C9501b.a;
    }

    public static String d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722821793")) {
            return (String) ipChange.ipc$dispatch("722821793", new Object[]{str});
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        return stringTokenizer.nextToken() + "." + stringTokenizer.nextToken();
    }

    public static void e(Map<String, String> map, UTHitBuilders.UTControlHitBuilder uTControlHitBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400943854")) {
            ipChange.ipc$dispatch("400943854", new Object[]{map, uTControlHitBuilder});
        } else if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                uTControlHitBuilder.setProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> a(java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.o23.a(java.util.Map):java.util.Map");
    }

    private o23() {
        this.a = new HashMap();
        this.b = new HashMap();
        new HashMap();
    }
}
