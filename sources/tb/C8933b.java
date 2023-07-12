package tb;

import android.app.Application;
import cn.damai.abtest.ABTestOrangeModel;
import cn.damai.wantsee.StartConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C9021d;

/* compiled from: Taobao */
/* renamed from: tb.b */
/* loaded from: classes.dex */
public final class C8933b {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C8933b INSTANCE = new C8933b();

    private C8933b() {
    }

    @Nullable
    public final ABTestOrangeModel a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130755606")) {
            return (ABTestOrangeModel) ipChange.ipc$dispatch("2130755606", new Object[]{this});
        }
        StartConfig configFromSp = StartConfig.getConfigFromSp();
        if (configFromSp != null) {
            return configFromSp.abTestOrangeModel;
        }
        return null;
    }

    public final void b(@NotNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514085685")) {
            ipChange.ipc$dispatch("-1514085685", new Object[]{this, application});
            return;
        }
        b41.i(application, "application");
        C9021d.C9024b c9024b = C9021d.C9024b.INSTANCE;
        c9024b.e(2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(tx0.INSTANCE.d());
        c9024b.h(arrayList);
        c9024b.g(Login.getUserId());
        c9024b.f(false);
        try {
            C9021d.Companion.c(application, c9024b);
        } catch (Exception e) {
            cb1.c("ABTestHelper", "error=" + e);
        }
    }
}
