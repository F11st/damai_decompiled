package tb;

import android.util.Log;
import com.alibaba.pictures.share.ShareManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@JvmName(name = sb2.a)
/* loaded from: classes8.dex */
public final class sb2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "ShareLog";

    public static final void a(@NotNull String str, @Nullable Exception exc) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1293587413")) {
            ipChange.ipc$dispatch("-1293587413", new Object[]{str, exc});
            return;
        }
        b41.i(str, "tag");
        if (ShareManager.INSTANCE.f()) {
            Log.e(str, (exc == null || (r5 = exc.getMessage()) == null) ? "" : "");
        }
    }

    public static final void b(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1389423035")) {
            ipChange.ipc$dispatch("-1389423035", new Object[]{str, str2});
            return;
        }
        b41.i(str, "tag");
        b41.i(str2, "msg");
        if (ShareManager.INSTANCE.f()) {
            Log.e(str, str2);
        }
    }

    public static /* synthetic */ void c(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = a;
        }
        b(str, str2);
    }

    public static final void d(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161929665")) {
            ipChange.ipc$dispatch("161929665", new Object[]{str, str2});
            return;
        }
        b41.i(str, "tag");
        b41.i(str2, "msg");
        if (ShareManager.INSTANCE.f()) {
            Log.i(str, str2);
        }
    }

    public static /* synthetic */ void e(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = a;
        }
        d(str, str2);
    }

    public static final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792780065")) {
            ipChange.ipc$dispatch("-1792780065", new Object[0]);
        } else {
            e(null, "application not init", 1, null);
        }
    }

    public static final void g(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850786829")) {
            ipChange.ipc$dispatch("-850786829", new Object[]{str, str2});
            return;
        }
        b41.i(str, "tag");
        b41.i(str2, "msg");
        if (ShareManager.INSTANCE.f()) {
            Log.w(str, str2);
        }
    }
}
