package tb;

import com.alibaba.pictures.dolores.log.IDoloresLog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class rq {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259782555")) {
            ipChange.ipc$dispatch("1259782555", new Object[]{str, str2});
            return;
        }
        IDoloresLog l = sb0.Companion.g().l();
        if (l != null) {
            l.debug("Dolores:" + str, str2);
        }
    }

    public static final void b(@Nullable String str, @Nullable Exception exc) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "717383638")) {
            ipChange.ipc$dispatch("717383638", new Object[]{str, exc});
            return;
        }
        IDoloresLog l = sb0.Companion.g().l();
        if (l != null) {
            l.debug("Dolores:" + str, exc != null ? exc.getMessage() : null);
        }
    }

    public static final void c(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1573604742")) {
            ipChange.ipc$dispatch("-1573604742", new Object[]{str, str2});
            return;
        }
        IDoloresLog l = sb0.Companion.g().l();
        if (l != null) {
            l.error("Dolores:" + str, str2);
        }
    }

    public static final void d(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1034968536")) {
            ipChange.ipc$dispatch("-1034968536", new Object[]{str, str2});
            return;
        }
        IDoloresLog l = sb0.Companion.g().l();
        if (l != null) {
            l.warn("Dolores:" + str, str2);
        }
    }
}
