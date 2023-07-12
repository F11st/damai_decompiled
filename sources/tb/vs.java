package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.module.plugin.UTPlugin;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class vs extends UTPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9827a Companion = new C9827a(null);

    /* compiled from: Taobao */
    /* renamed from: tb.vs$a */
    /* loaded from: classes4.dex */
    public static final class C9827a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9827a() {
        }

        public /* synthetic */ C9827a(k50 k50Var) {
            this();
        }

        @JvmStatic
        public final void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1779467528")) {
                ipChange.ipc$dispatch("-1779467528", new Object[]{this});
                return;
            }
            try {
                UTAnalytics.getInstance().registerPlugin(new vs());
            } catch (Throwable th) {
                cb1.d(th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d A[Catch: Exception -> 0x0085, TryCatch #0 {Exception -> 0x0085, blocks: (B:9:0x0021, B:12:0x0029, B:14:0x0031, B:20:0x003d, B:21:0x0048, B:23:0x004e, B:24:0x0059, B:26:0x0062, B:28:0x0068, B:29:0x007a), top: B:34:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: Exception -> 0x0085, TryCatch #0 {Exception -> 0x0085, blocks: (B:9:0x0021, B:12:0x0029, B:14:0x0031, B:20:0x003d, B:21:0x0048, B:23:0x004e, B:24:0x0059, B:26:0x0062, B:28:0x0068, B:29:0x007a), top: B:34:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(java.util.Map<java.lang.String, java.lang.String> r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "city"
            com.android.alibaba.ip.runtime.IpChange r1 = tb.vs.$ipChange
            java.lang.String r2 = "-52637131"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L1c
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r6] = r7
            r0[r5] = r8
            r0[r4] = r9
            r1.ipc$dispatch(r2, r0)
            return
        L1c:
            if (r9 == 0) goto L89
            if (r8 != 0) goto L21
            goto L89
        L21:
            boolean r1 = r9.containsKey(r0)     // Catch: java.lang.Exception -> L85
            java.lang.String r2 = "getCityName()"
            if (r1 == 0) goto L7a
            java.lang.Object r9 = r9.get(r0)     // Catch: java.lang.Exception -> L85
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Exception -> L85
            if (r9 == 0) goto L3a
            int r1 = r9.length()     // Catch: java.lang.Exception -> L85
            if (r1 != 0) goto L38
            goto L3a
        L38:
            r1 = 0
            goto L3b
        L3a:
            r1 = 1
        L3b:
            if (r1 == 0) goto L48
            java.lang.String r9 = tb.z20.d()     // Catch: java.lang.Exception -> L85
            tb.b41.h(r9, r2)     // Catch: java.lang.Exception -> L85
            r8.put(r0, r9)     // Catch: java.lang.Exception -> L85
            goto L89
        L48:
            boolean r1 = tb.hm1.a(r9)     // Catch: java.lang.Exception -> L85
            if (r1 == 0) goto L59
            java.lang.String r9 = tb.z20.d()     // Catch: java.lang.Exception -> L85
            tb.b41.h(r9, r2)     // Catch: java.lang.Exception -> L85
            r8.put(r0, r9)     // Catch: java.lang.Exception -> L85
            goto L89
        L59:
            java.lang.String r1 = "市"
            r2 = 0
            boolean r1 = kotlin.text.C8596g.p(r9, r1, r6, r4, r2)     // Catch: java.lang.Exception -> L85
            if (r1 == 0) goto L89
            int r1 = r9.length()     // Catch: java.lang.Exception -> L85
            if (r1 <= r5) goto L89
            int r1 = r9.length()     // Catch: java.lang.Exception -> L85
            int r1 = r1 - r5
            java.lang.String r9 = r9.substring(r6, r1)     // Catch: java.lang.Exception -> L85
            java.lang.String r1 = "this as java.lang.String…ing(startIndex, endIndex)"
            tb.b41.h(r9, r1)     // Catch: java.lang.Exception -> L85
            r8.put(r0, r9)     // Catch: java.lang.Exception -> L85
            goto L89
        L7a:
            java.lang.String r9 = tb.z20.d()     // Catch: java.lang.Exception -> L85
            tb.b41.h(r9, r2)     // Catch: java.lang.Exception -> L85
            r8.put(r0, r9)     // Catch: java.lang.Exception -> L85
            goto L89
        L85:
            r8 = move-exception
            tb.cb1.d(r8)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.vs.a(java.util.Map, java.util.Map):void");
    }

    @JvmStatic
    public static final void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236399568")) {
            ipChange.ipc$dispatch("-1236399568", new Object[0]);
        } else {
            Companion.a();
        }
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    @NotNull
    public int[] getAttentionEventIds() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-969159209") ? (int[]) ipChange.ipc$dispatch("-969159209", new Object[]{this}) : new int[]{2001, 2101, 2201, 19999, 12002, 12003};
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    @NotNull
    public Map<String, String> onEventDispatch(@Nullable String str, int i, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1740044539")) {
            return (Map) ipChange.ipc$dispatch("-1740044539", new Object[]{this, str, Integer.valueOf(i), str2, str3, str4, map});
        }
        HashMap hashMap = new HashMap();
        a(hashMap, map);
        return hashMap;
    }
}
