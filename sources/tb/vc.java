package tb;

import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class vc {
    @NotNull
    public static final C9815a Companion = new C9815a(null);
    private static String a;
    private static String b;

    /* compiled from: Taobao */
    /* renamed from: tb.vc$a */
    /* loaded from: classes7.dex */
    public static final class C9815a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9815a() {
        }

        public final boolean a(@Nullable List<String> list) {
            boolean r;
            boolean J;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1437389994")) {
                return ((Boolean) ipChange.ipc$dispatch("1437389994", new Object[]{this, list})).booleanValue();
            }
            if (vc.a == null) {
                vc.a = Build.VERSION.getRELEASE();
            }
            if (vc.b == null) {
                vc.b = Build.getMODEL();
            }
            r = C8604o.r(vc.a, "10", false, 2, null);
            if (r && list != null) {
                J = CollectionsKt___CollectionsKt.J(list, vc.b);
                if (J) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ C9815a(k50 k50Var) {
            this();
        }
    }
}
