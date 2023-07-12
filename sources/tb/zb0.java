package tb;

import com.alibaba.pictures.dolores.monitor.IMtopMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class zb0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final zb0 INSTANCE = new zb0();
    private static IMtopMonitor a;

    private zb0() {
    }

    @JvmStatic
    public static final void a(@Nullable String str, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697316111")) {
            ipChange.ipc$dispatch("-1697316111", new Object[]{str, obj});
            return;
        }
        IMtopMonitor iMtopMonitor = a;
        if (iMtopMonitor != null) {
            iMtopMonitor.mtopJsonEmpty(str, obj);
        }
    }

    @JvmStatic
    public static final void b(@Nullable String str, @Nullable String str2, @Nullable Object obj, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745976911")) {
            ipChange.ipc$dispatch("-1745976911", new Object[]{str, str2, obj, str3});
            return;
        }
        IMtopMonitor iMtopMonitor = a;
        if (iMtopMonitor != null) {
            iMtopMonitor.mtopJsonFailure(str, str2, obj, str3);
        }
    }

    @JvmStatic
    public static final <BizResponse> void c(@Nullable String str, @Nullable dc0<BizResponse> dc0Var, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002422654")) {
            ipChange.ipc$dispatch("2002422654", new Object[]{str, dc0Var, str2});
            return;
        }
        IMtopMonitor iMtopMonitor = a;
        if (iMtopMonitor != null) {
            iMtopMonitor.mtopRequestAndResponse(str, dc0Var, str2);
        }
    }

    @JvmStatic
    public static final void d(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501536434")) {
            ipChange.ipc$dispatch("-1501536434", new Object[]{str, str2, str3, str4, str5, str6});
            return;
        }
        IMtopMonitor iMtopMonitor = a;
        if (iMtopMonitor != null) {
            iMtopMonitor.mtopResponseError(str, str2, str3, str4, str5, str6);
        }
    }

    @JvmStatic
    public static final void e(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-694243764")) {
            ipChange.ipc$dispatch("-694243764", new Object[]{str, str2, str3, str4, str5, str6});
            return;
        }
        IMtopMonitor iMtopMonitor = a;
        if (iMtopMonitor != null) {
            iMtopMonitor.mtopResponseFailure(str, str2, str3, str4, str5, str6);
        }
    }

    @JvmStatic
    public static final void f(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208730060")) {
            ipChange.ipc$dispatch("-1208730060", new Object[]{str, str2, str3});
            return;
        }
        IMtopMonitor iMtopMonitor = a;
        if (iMtopMonitor != null) {
            iMtopMonitor.mtopResponseSuccess(str, str2, str3);
        }
    }

    @JvmStatic
    public static final void g(@Nullable String str, @Nullable String str2, @Nullable bo2 bo2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "169138757")) {
            ipChange.ipc$dispatch("169138757", new Object[]{str, str2, bo2Var});
            return;
        }
        IMtopMonitor iMtopMonitor = a;
        if (iMtopMonitor != null) {
            iMtopMonitor.mtopRequestTime(str, str2, bo2Var);
        }
    }

    @JvmStatic
    public static final void h(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337391768")) {
            ipChange.ipc$dispatch("-337391768", new Object[]{str, str2, str3, str4});
            return;
        }
        IMtopMonitor iMtopMonitor = a;
        if (iMtopMonitor != null) {
            iMtopMonitor.commitRequestError(str, str2, str3, str4);
        }
    }

    @JvmStatic
    public static final void i(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1763611821")) {
            ipChange.ipc$dispatch("-1763611821", new Object[]{str, str2});
            return;
        }
        IMtopMonitor iMtopMonitor = a;
        if (iMtopMonitor != null) {
            iMtopMonitor.mtopLoginCancel(str, str2);
        }
    }

    @JvmStatic
    public static final void j(@NotNull IMtopMonitor iMtopMonitor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047709754")) {
            ipChange.ipc$dispatch("1047709754", new Object[]{iMtopMonitor});
            return;
        }
        b41.i(iMtopMonitor, "monitorDelegate");
        a = iMtopMonitor;
    }
}
