package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class nd {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final nd INSTANCE = new nd();

    private nd() {
    }

    @JvmStatic
    public static final void a(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "702639197")) {
            ipChange.ipc$dispatch("702639197", new Object[]{str, str2});
            return;
        }
        b41.i(str, "msg");
        b41.i(str2, "tag");
        if (AppInfoProviderProxy.isDebuggable()) {
            Log.e(str2, str);
        }
    }

    public static /* synthetic */ void b(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "BricksLog";
        }
        a(str, str2);
    }
}
