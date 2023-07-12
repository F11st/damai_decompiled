package tb;

import com.alibaba.pictures.share.ShareManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class yb2 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final yb2 INSTANCE = new yb2();
    @Nullable
    private static Map<String, String> a;

    private yb2() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(yb2 yb2Var, String str, String str2, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            map = new LinkedHashMap();
        }
        yb2Var.a(str, str2, map);
    }

    private final void d(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1016521453")) {
            ipChange.ipc$dispatch("-1016521453", new Object[]{this, map});
            return;
        }
        Map<String, String> map2 = a;
        if (map2 != null) {
            map.putAll(map2);
        }
    }

    public final void a(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1897605375")) {
            ipChange.ipc$dispatch("1897605375", new Object[]{this, str, str2, map});
            return;
        }
        b41.i(str, "ctrlName");
        b41.i(str2, "spm");
        b41.i(map, "args");
        d(map);
        ShareManager.IDogCat m = ShareManager.INSTANCE.b().m();
        if (m != null) {
            m.click(str, str2, map);
        }
    }

    public final void c(@NotNull String str, @NotNull Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239769628")) {
            ipChange.ipc$dispatch("1239769628", new Object[]{this, str, map});
            return;
        }
        b41.i(str, "eventName");
        b41.i(map, "args");
        d(map);
        ShareManager.IDogCat m = ShareManager.INSTANCE.b().m();
        if (m != null) {
            m.custom(str, map);
        }
    }
}
