package cn.damai.launcher.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.common.util.PriorityTask;
import cn.damai.launcher.AppPreLauncher;
import cn.damai.launcher.PrivacyDoubleListDelegate;
import cn.damai.launcher.altriax.LaunchTrigger;
import cn.damai.launcher.initialize.CommonBiz;
import cn.damai.launcher.initialize.ProcessUtils;
import cn.damai.launcher.utils.AppForegroundManager;
import cn.damai.login.LoginManager;
import cn.damai.wantsee.StartConfig;
import com.alibaba.pictures.bricks.channel.DamaiComponentFilterBridgeImpl;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.C8933b;
import tb.b5;
import tb.cb1;
import tb.fd;
import tb.gm;
import tb.lt1;
import tb.mt1;
import tb.mu0;
import tb.nu1;
import tb.sb0;
import tb.z20;
import tb.zb0;
import tb.zm2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class InitUtils {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean a;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.launcher.utils.InitUtils$a */
    /* loaded from: classes15.dex */
    static /* synthetic */ class C1312a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[IGlobalConfig.Key.values().length];
            a = iArr;
            try {
                iArr[IGlobalConfig.Key.IS_GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IGlobalConfig.Key.NEED_LOGIN_FOR_ALL_REQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IGlobalConfig.Key.WUA_SWITCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[IGlobalConfig.Key.PROJECT_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[IGlobalConfig.Key.IS_USE_HTTPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[IGlobalConfig.Key.DOLORES_API_WHITE_LIST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264255498")) {
            ipChange.ipc$dispatch("1264255498", new Object[0]);
        } else {
            AppForegroundManager.getInstance().setAppStateListener(new AppForegroundManager.IAppStateChangeListener() { // from class: cn.damai.launcher.utils.InitUtils.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.launcher.utils.AppForegroundManager.IAppStateChangeListener
                public void onAppStateChanged(boolean z) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-320189111")) {
                        ipChange2.ipc$dispatch("-320189111", new Object[]{this, Boolean.valueOf(z)});
                        return;
                    }
                    cb1.b("onAppStateChanged", "isAppForceground = " + z);
                    if (z) {
                        mt1.k = true;
                        mt1.l = false;
                        if (InitUtils.a) {
                            LoginManager.k().h();
                            boolean unused = InitUtils.a = false;
                            return;
                        }
                        return;
                    }
                    mt1.l = true;
                    mt1.k = false;
                    boolean unused2 = InitUtils.a = true;
                }
            });
        }
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756157082")) {
            ipChange.ipc$dispatch("756157082", new Object[0]);
            return;
        }
        sb0.o(mu0.a());
        sb0.p().u(AppConfig.p());
        sb0.t(new DoloresLoginDelegate());
        sb0.s(AppConfig.v());
        sb0.r(new DoloresGlobalInterceptor());
        sb0.q(new IGlobalConfig() { // from class: cn.damai.launcher.utils.InitUtils.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.alibaba.pictures.dolores.config.IGlobalConfig
            @Nullable
            public String getGlobalConfig(@NonNull IGlobalConfig.Key key, @Nullable String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1834127675")) {
                    return (String) ipChange2.ipc$dispatch("1834127675", new Object[]{this, key, str});
                }
                switch (C1312a.a[key.ordinal()]) {
                    case 1:
                        return "true";
                    case 2:
                    case 3:
                        return "false";
                    case 4:
                        return z20.s();
                    case 5:
                        return z20.u() ? "false" : "true";
                    case 6:
                        return "";
                    default:
                        return null;
                }
            }
        });
        zb0.j(new DoloresMonitorDelegate());
    }

    private static void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1352939865")) {
            ipChange.ipc$dispatch("-1352939865", new Object[0]);
        } else if (ProcessUtils.b(mu0.a())) {
            b5.d(mu0.a(), true);
        }
    }

    private static void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864793267")) {
            ipChange.ipc$dispatch("1864793267", new Object[0]);
        } else if (ProcessUtils.b(mu0.a())) {
            lt1.Companion.a().p(mu0.a(), z20.c(), StartConfig.getPopupSceneTypes());
        }
    }

    public static void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679756204")) {
            ipChange.ipc$dispatch("-1679756204", new Object[0]);
            return;
        }
        CommonBiz.getInstance().i();
        fd.d();
        new AppPreLauncher().b(mu0.a());
        PrivacyDoubleListDelegate.INSTANCE.b();
        fd.c("initBeforeAtlas");
        e();
        fd.c("initOnlineMonitor");
        LaunchTrigger.c(mu0.a()).f();
        fd.c("AltriaXStart");
        CommonBiz.getInstance().J();
        CommonBiz.getInstance().l();
        fd.c("initLocationSDK");
        d();
        f();
        C8933b.INSTANCE.b(mu0.a());
        gm.INSTANCE.b(new DamaiComponentFilterBridgeImpl());
        c();
        nu1.a(new PriorityTask("workerThread", mu0.a(), 1) { // from class: cn.damai.launcher.utils.InitUtils.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.util.PriorityTask
            public void doTask() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "14768585")) {
                    ipChange2.ipc$dispatch("14768585", new Object[]{this});
                    return;
                }
                try {
                    fd.e(120);
                    CommonBiz.getInstance().w();
                    fd.a("SubThreadInitSDK", 120);
                } catch (Exception e) {
                    e.printStackTrace();
                    cb1.c("initSDK", "initSDK catch   " + zm2.a(e));
                }
            }
        });
    }
}
