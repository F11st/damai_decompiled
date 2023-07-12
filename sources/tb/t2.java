package tb;

import android.app.Application;
import com.alibaba.pictures.accs.PushAgent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.utl.ForeBackManager;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class t2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ACCS_CHANNEL = "damaiAccsService";
    @NotNull
    public static final t2 INSTANCE = new t2();
    @NotNull
    public static final String TAG = "Accs";

    private t2() {
    }

    @JvmStatic
    public static final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098315318")) {
            ipChange.ipc$dispatch("1098315318", new Object[0]);
            return;
        }
        cb1.b(TAG, "bindApp，in progress=" + AppInfoProviderProxy.getCurrentProcessName());
        PushAgent.c();
    }

    @JvmStatic
    public static final void b(@NotNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "384314361")) {
            ipChange.ipc$dispatch("384314361", new Object[]{application});
            return;
        }
        b41.i(application, "application");
        t2 t2Var = INSTANCE;
        cb1.b(TAG, "initACCS，in progress=" + AppInfoProviderProxy.getCurrentProcessName());
        if (t2Var.d()) {
            ForeBackManager.getManager().initialize(application);
        }
        PushAgent pushAgent = PushAgent.INSTANCE;
        pushAgent.o(new s2());
        pushAgent.m(new u2());
        pushAgent.n(new d4());
        pushAgent.p(new xl1());
        PushAgent.j();
    }

    @JvmStatic
    public static final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1317737658")) {
            ipChange.ipc$dispatch("1317737658", new Object[0]);
            return;
        }
        t2 t2Var = INSTANCE;
        cb1.b(TAG, "initAgooAccsChannel，in progress=" + AppInfoProviderProxy.getCurrentProcessName());
        PushAgent.k();
        if (t2Var.d()) {
            cb1.b(TAG, "initAgooManufactureChannel，in progress=" + AppInfoProviderProxy.getCurrentProcessName());
            PushAgent.l();
        }
    }

    private final boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "564047666")) {
            return ((Boolean) ipChange.ipc$dispatch("564047666", new Object[]{this})).booleanValue();
        }
        String packageName = AppInfoProviderProxy.getPackageName();
        String currentProcessName = AppInfoProviderProxy.getCurrentProcessName();
        return currentProcessName != null && b41.d(currentProcessName, packageName);
    }
}
