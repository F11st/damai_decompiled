package tb;

import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class j23 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9296a Companion = new C9296a(null);
    @NotNull
    private static final j23 b = C9297b.INSTANCE.a();

    /* compiled from: Taobao */
    /* renamed from: tb.j23$a */
    /* loaded from: classes.dex */
    public static final class C9296a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9296a() {
        }

        public /* synthetic */ C9296a(k50 k50Var) {
            this();
        }

        @NotNull
        public final j23 a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1946475707") ? (j23) ipChange.ipc$dispatch("-1946475707", new Object[]{this}) : j23.b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.j23$b */
    /* loaded from: classes.dex */
    public static final class C9297b {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        public static final C9297b INSTANCE = new C9297b();
        @NotNull
        private static final j23 a = new j23();

        private C9297b() {
        }

        @NotNull
        public final j23 a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1044093597") ? (j23) ipChange.ipc$dispatch("-1044093597", new Object[]{this}) : a;
        }
    }

    public final void g(@NotNull String str, long j, long j2, @NotNull String str2, @NotNull String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840778314")) {
            ipChange.ipc$dispatch("-840778314", new Object[]{this, str, Long.valueOf(j), Long.valueOf(j2), str2, str3});
            return;
        }
        b41.i(str, "pageSource");
        b41.i(str2, "module");
        b41.i(str3, "widget");
        C0529c.e().C(str3, str2, str, "1.0", j2 - j, null, 2201);
    }

    @NotNull
    public final C0525a.C0527b h(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1905854701")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1905854701", new Object[]{this, str, str2, str3});
        }
        b41.i(str, "pageSource");
        b41.i(str2, "module");
        b41.i(str3, "widget");
        C0525a.C0527b e = e(str, str2, str3, new HashMap(), Boolean.FALSE);
        b41.h(e, "getDamaiUTKeyBuilder(pag…dule, widget, map, false)");
        return e;
    }
}
