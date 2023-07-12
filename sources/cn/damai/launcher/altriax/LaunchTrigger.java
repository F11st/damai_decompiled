package cn.damai.launcher.altriax;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.AppConfig;
import cn.damai.common.app.ShareperfenceConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.DelegateRuntime;
import me.ele.altriax.launcher.biz.strategy.Discriminator;
import me.ele.altriax.launcher.biz.strategy.Strategy;
import me.ele.altriax.launcher.bootstrap.AppDelegate;
import me.ele.altriax.launcher.bootstrap.Bootstrap;
import me.ele.altriax.launcher.bootstrap.Options;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class LaunchTrigger {
    private static transient /* synthetic */ IpChange $ipChange;
    private static LaunchTrigger c;
    private final Application a;
    private AppDelegate b;

    private LaunchTrigger(Application application) {
        this.a = application;
    }

    private void b(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647110194")) {
            ipChange.ipc$dispatch("-1647110194", new Object[]{this, str, Integer.valueOf(i)});
        } else {
            this.a.getSharedPreferences(str, i);
        }
    }

    public static synchronized LaunchTrigger c(Application application) {
        synchronized (LaunchTrigger.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "404767510")) {
                return (LaunchTrigger) ipChange.ipc$dispatch("404767510", new Object[]{application});
            }
            if (c == null) {
                c = new LaunchTrigger(application);
            }
            return c;
        }
    }

    private AppDelegate e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2115828600")) {
            return (AppDelegate) ipChange.ipc$dispatch("-2115828600", new Object[]{this});
        }
        if (this.b == null) {
            Options options = new Options();
            options.packageName = this.a.getPackageName();
            String n = AppConfig.n(this.a);
            if (TextUtils.isEmpty(n)) {
                n = "cn.damai";
            }
            options.processName = n;
            options.startTime = System.currentTimeMillis();
            this.b = new Bootstrap.Builder(this.a, options).build();
        }
        return this.b;
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967075687")) {
            ipChange.ipc$dispatch("1967075687", new Object[]{this});
            return;
        }
        DelegateRuntime.sDMInitOnlineMonitorDelegate = new DMInitOnlineMonitorImpl();
        DelegateRuntime.sDMInitCrashReportDelegate = new DMInitCrashReportImpl();
        DelegateRuntime.sDMInitACCSDelegate = new DMInitACCSImpl();
        DelegateRuntime.sDMInitAusDelegate = new DMInitAusImpl();
        DelegateRuntime.sDMInitDynamicXDelegate = new DMInitDynamicXImpl();
        DelegateRuntime.sDMInitFbmDelegate = new DMInitFbmImpl();
        DelegateRuntime.sDMInitFlutterDelegate = new DMInitFlutterImpl();
        DelegateRuntime.sDMInitImageLoaderDelegate = new DMInitImageLoaderImpl();
        DelegateRuntime.sDMInitLoginSDKDelegate = new DMInitLoginSDKImpl();
        DelegateRuntime.sDMInitMtopDelegate = new DMInitMtopImpl();
        DelegateRuntime.sDMInitNavDelegate = new DMInitNavImpl();
        DelegateRuntime.sDMInitOrangeDelegate = new DMInitOrangeImpl();
        DelegateRuntime.sDMInitPopLayerDelegate = new DMInitPopLayerImpl();
        DelegateRuntime.sDMInitSecurityDelegate = new DMInitSecurityImpl();
        DelegateRuntime.sDMInitTetrisProxyDelegate = new DMInitTetrisProxyImpl();
        DelegateRuntime.sDMInitTLogDelegate = new DMInitTLogImpl();
        DelegateRuntime.sDMInitUTDelegate = new DMInitUTImpl();
        Discriminator.installStrategy(new Strategy(this) { // from class: cn.damai.launcher.altriax.LaunchTrigger.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // me.ele.altriax.launcher.biz.strategy.Strategy
            public boolean identify(@NonNull String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2102679131")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-2102679131", new Object[]{this, str})).booleanValue();
                }
                return true;
            }
        }, Strategy.DAG_ALTRIAXB_LINK_DAMAI_NOMAL_APP);
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1474673900")) {
            ipChange.ipc$dispatch("1474673900", new Object[]{this});
            return;
        }
        b("SP_APM_X_HELPER", 0);
        b("move_to_de_records", 0);
        b("push_client_self_info", 0);
        b(ShareperfenceConstants.CITY_SHAREPREFENCE, 0);
        b("embryo", 0);
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284735399")) {
            ipChange.ipc$dispatch("-284735399", new Object[]{this});
            return;
        }
        e();
        this.b.onAttach();
        this.b.onMain();
        this.b.onCreate();
    }
}
