package tb;

import android.app.Application;
import com.alibaba.pictures.cornerstone.IAppBaseInfoProvider;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ko {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ko INSTANCE = new ko();
    @Nullable
    private static String a;
    private static IAppBaseInfoProvider b;
    private static Application c;

    private ko() {
    }

    @NotNull
    public static final ek d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1986471277") ? (ek) ipChange.ipc$dispatch("1986471277", new Object[0]) : ek.INSTANCE;
    }

    @NotNull
    public static final w41 e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-778930473") ? (w41) ipChange.ipc$dispatch("-778930473", new Object[0]) : w41.INSTANCE;
    }

    @NotNull
    public static final ba1 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1371280077") ? (ba1) ipChange.ipc$dispatch("1371280077", new Object[0]) : ba1.INSTANCE;
    }

    @NotNull
    public final Application a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-146684542")) {
            return (Application) ipChange.ipc$dispatch("-146684542", new Object[]{this});
        }
        Application application = c;
        if (application == null) {
            b41.A("application");
        }
        return application;
    }

    @NotNull
    public final IAppBaseInfoProvider b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032902501")) {
            return (IAppBaseInfoProvider) ipChange.ipc$dispatch("1032902501", new Object[]{this});
        }
        IAppBaseInfoProvider iAppBaseInfoProvider = b;
        if (iAppBaseInfoProvider == null) {
            b41.A("baseAppInfoProvider");
        }
        return iAppBaseInfoProvider;
    }

    @Nullable
    public final String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "387578447") ? (String) ipChange.ipc$dispatch("387578447", new Object[]{this}) : a;
    }

    public final void g(@NotNull Application application, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1940116174")) {
            ipChange.ipc$dispatch("-1940116174", new Object[]{this, application, str});
            return;
        }
        b41.i(application, "application");
        a = str;
        c = application;
    }

    public final void h(@NotNull IAppBaseInfoProvider iAppBaseInfoProvider) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891090241")) {
            ipChange.ipc$dispatch("1891090241", new Object[]{this, iAppBaseInfoProvider});
            return;
        }
        b41.i(iAppBaseInfoProvider, "baseAppInfoProvider");
        b = iAppBaseInfoProvider;
    }
}
