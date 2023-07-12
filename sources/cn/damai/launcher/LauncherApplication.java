package cn.damai.launcher;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.multidex.MultiDex;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.CompliantUtUtils;
import cn.damai.commonbusiness.screenshot.ScreenShotBean;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.launcher.altriax.LaunchTrigger;
import cn.damai.launcher.initialize.CommonBiz;
import cn.damai.launcher.jacoco.CoverInject;
import cn.damai.launcher.utils.InitUtils;
import cn.damai.wantsee.StartConfig;
import com.alibaba.wireless.security.aopsdk.AopEntry;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tb.fd;
import tb.mu0;
import tb.ru1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class LauncherApplication extends Application implements ScreenShotDetector.IScreenShotDetectorListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public static long sAppCreateTimeMillis;

    private void closeAndroidPDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631750320")) {
            ipChange.ipc$dispatch("1631750320", new Object[]{this});
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void forceHideApiWarning() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499461538")) {
            ipChange.ipc$dispatch("1499461538", new Object[]{this});
        } else if (isDebug(this)) {
            try {
                closeAndroidPDialog();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isDebug(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1447018012") ? ((Boolean) ipChange.ipc$dispatch("-1447018012", new Object[]{this, context})).booleanValue() : (context.getApplicationInfo().flags & 2) != 0;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        AopEntry.init(context);
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222705072")) {
            ipChange.ipc$dispatch("1222705072", new Object[]{this, context});
            return;
        }
        super.attachBaseContext(context);
        MultiDex.install(context);
    }

    @Override // android.app.Application
    public void onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876887042")) {
            ipChange.ipc$dispatch("-1876887042", new Object[]{this});
            return;
        }
        sAppCreateTimeMillis = System.currentTimeMillis();
        fd.e(100);
        LaunchTrigger c = LaunchTrigger.c(this);
        c.a();
        c.d();
        forceHideApiWarning();
        super.onCreate();
        CommonBiz.getInstance().a = this;
        AppConfig.s(this);
        AppConfig.t(this);
        mu0.c(this);
        registerActivityLifecycleCallbacks(new ActivityLifeCycleListener());
        CompliantUtUtils.f(new StartConfig());
        if (ru1.d()) {
            InitUtils.g();
        }
        if (AppConfig.v()) {
            new CoverInject().loadCoverInit(this);
        }
        ScreenShotDetector.k().w(this);
        fd.a("Application onCreate finish", 100);
    }

    @Override // cn.damai.commonbusiness.screenshot.ScreenShotDetector.IScreenShotDetectorListener
    public void onFeedbackClick(ScreenShotBean screenShotBean, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1702686192")) {
            ipChange.ipc$dispatch("-1702686192", new Object[]{this, screenShotBean, activity});
            return;
        }
        if (ScreenShotDetector.k().o()) {
            activity.finish();
        }
        Bundle bundle = new Bundle();
        if (screenShotBean != null) {
            bundle.putSerializable("screenshot_info", screenShotBean);
            bundle.putBoolean("fromFloatActivity", true);
        }
        try {
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b("feedback_list"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708956997")) {
            ipChange.ipc$dispatch("-1708956997", new Object[]{this});
            return;
        }
        super.onLowMemory();
        System.gc();
    }
}
