package tb;

import android.app.Application;
import com.alibaba.pictures.moimage.IImageUrlFixer;
import com.alibaba.pictures.moimage.IMoImageConfig;
import com.alibaba.pictures.moimage.IMoImageViewMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class mg1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private static Application a;
    private static IMoImageConfig b;
    @Nullable
    private static IMoImageViewMonitor e;
    @Nullable
    private static IImageUrlFixer f;
    @NotNull
    public static final mg1 INSTANCE = new mg1();
    private static boolean c = true;
    private static boolean d = true;

    private mg1() {
    }

    public final boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-307595583")) {
            return ((Boolean) ipChange.ipc$dispatch("-307595583", new Object[]{this})).booleanValue();
        }
        IMoImageConfig iMoImageConfig = b;
        return b41.d(iMoImageConfig != null ? iMoImageConfig.debugAble() : null, Boolean.TRUE);
    }

    public final boolean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "969367365")) {
            return ((Boolean) ipChange.ipc$dispatch("969367365", new Object[]{this})).booleanValue();
        }
        IMoImageConfig iMoImageConfig = b;
        return b41.d(iMoImageConfig != null ? iMoImageConfig.disableFadeIn() : null, Boolean.TRUE);
    }

    @Nullable
    public final Application c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1916501163") ? (Application) ipChange.ipc$dispatch("-1916501163", new Object[]{this}) : a;
    }

    @Nullable
    public final IMoImageViewMonitor d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-409278188") ? (IMoImageViewMonitor) ipChange.ipc$dispatch("-409278188", new Object[]{this}) : e;
    }

    @Nullable
    public final IImageUrlFixer e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "759416581") ? (IImageUrlFixer) ipChange.ipc$dispatch("759416581", new Object[]{this}) : f;
    }

    public final boolean f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "110414475") ? ((Boolean) ipChange.ipc$dispatch("110414475", new Object[]{this})).booleanValue() : d;
    }

    public final boolean g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "225530918") ? ((Boolean) ipChange.ipc$dispatch("225530918", new Object[]{this})).booleanValue() : c;
    }

    public final void h(@NotNull Application application, @Nullable IMoImageConfig iMoImageConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1480689097")) {
            ipChange.ipc$dispatch("1480689097", new Object[]{this, application, iMoImageConfig});
            return;
        }
        b41.i(application, "application");
        a = application;
        b = iMoImageConfig;
        cs1.INSTANCE.a(application);
    }

    public final void i(@Nullable IImageUrlFixer iImageUrlFixer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1509645945")) {
            ipChange.ipc$dispatch("1509645945", new Object[]{this, iImageUrlFixer});
        } else {
            f = iImageUrlFixer;
        }
    }

    public final void j(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-28781255")) {
            ipChange.ipc$dispatch("-28781255", new Object[]{this, Boolean.valueOf(z)});
        } else {
            d = z;
        }
    }

    public final void k(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678396826")) {
            ipChange.ipc$dispatch("-678396826", new Object[]{this, Boolean.valueOf(z)});
        } else {
            c = z;
        }
    }

    public final boolean l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1180199725")) {
            return ((Boolean) ipChange.ipc$dispatch("-1180199725", new Object[]{this})).booleanValue();
        }
        IMoImageConfig iMoImageConfig = b;
        return b41.d(iMoImageConfig != null ? iMoImageConfig.showImageOff() : null, Boolean.TRUE);
    }
}
