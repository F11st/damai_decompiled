package tb;

import android.app.Activity;
import android.content.res.Configuration;
import com.alibaba.pictures.responsive.page.IResponsivePage;
import com.alibaba.pictures.responsive.state.ResponsivePageStateCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class u22 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Activity a;
    @NotNull
    private final IResponsivePage b;
    private int c;
    private int d;

    public u22(@NotNull Activity activity, @NotNull IResponsivePage iResponsivePage) {
        b41.i(activity, "activity");
        b41.i(iResponsivePage, "responsivePage");
        this.a = activity;
        this.b = iResponsivePage;
        this.d = ResponsivePageStateCache.Companion.a().f(activity);
    }

    public final int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-853831472") ? ((Integer) ipChange.ipc$dispatch("-853831472", new Object[]{this})).intValue() : this.d;
    }

    public final void b(@Nullable Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-72591600")) {
            ipChange.ipc$dispatch("-72591600", new Object[]{this, configuration});
        } else if (e32.INSTANCE.j(this.a)) {
            this.c = this.d;
            this.d = ResponsivePageStateCache.Companion.a().f(this.a);
        }
    }

    public final void c(@Nullable Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134578096")) {
            ipChange.ipc$dispatch("2134578096", new Object[]{this, configuration});
        } else if (e32.INSTANCE.j(this.a)) {
            IResponsivePage iResponsivePage = this.b;
            int i = this.d;
            iResponsivePage.onResponsiveLayout(configuration, i, this.c != i);
        }
    }
}
