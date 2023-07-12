package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class a4 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a4 INSTANCE = new a4();

    private a4() {
    }

    @NotNull
    public final String a(@NotNull String str, @NotNull String str2) {
        boolean K;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289523904")) {
            return (String) ipChange.ipc$dispatch("-1289523904", new Object[]{this, str, str2});
        }
        b41.i(str, "originalUrl");
        b41.i(str2, "param");
        if (str.length() > 0) {
            K = StringsKt__StringsKt.K(str, "?", false, 2, null);
            if (K) {
                return str + '&' + str2;
            }
            return str + jn1.CONDITION_IF + str2;
        }
        return "";
    }
}
