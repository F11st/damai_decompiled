package tb;

import android.app.Application;
import android.os.Build;
import com.alibaba.youku.webp4pexode.WebpDecoder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.pexode.Pexode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class cs1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final cs1 INSTANCE = new cs1();

    private cs1() {
    }

    public final void a(@NotNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1986182549")) {
            ipChange.ipc$dispatch("-1986182549", new Object[]{this, application});
            return;
        }
        b41.i(application, "application");
        if (Build.VERSION.SDK_INT == 28) {
            ur1.w = true;
            Pexode.g = true;
        }
        ur1.o().z(application);
        if (mg1.INSTANCE.g()) {
            ur1.o().httpLoaderBuilder().with(new e23(application));
            lg1.INSTANCE.a("setupHttpLoader-use-xcdn");
        } else {
            xj2.b(application);
            lg1.INSTANCE.a("setupHttpLoader-use-default-httplaoder");
        }
        w4.a();
        ak2.a(true, true);
        ur1.o().b();
        Pexode.i(new com.taobao.pexode.decoder.d());
        Pexode.i(new com.taobao.pexode.decoder.a());
        Pexode.i(new WebpDecoder());
        Pexode.q(ur1.o().c().build());
        Pexode.n(application);
        cg2.d(application, new rg1(), 20, 204800);
        xj2.c();
        ur1.o().w(new qg1());
    }
}
