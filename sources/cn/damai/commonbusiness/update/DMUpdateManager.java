package cn.damai.commonbusiness.update;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.update.UpdateSDK;
import com.taobao.update.framework.UpdateRuntime;
import java.util.List;
import tb.C9444mm;
import tb.ju2;
import tb.pu2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DMUpdateManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static DMUpdateManager f;
    private Application a;
    private ActivityManager b;
    private volatile UpdateSDK c;
    private Application.ActivityLifecycleCallbacks d = new C0942a();
    private ComponentCallbacks2 e = new ComponentCallbacks2C0943b();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.update.DMUpdateManager$a */
    /* loaded from: classes.dex */
    public class C0942a implements Application.ActivityLifecycleCallbacks {
        private static transient /* synthetic */ IpChange $ipChange;

        C0942a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-867187054")) {
                ipChange.ipc$dispatch("-867187054", new Object[]{this, activity, bundle});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "726052913")) {
                ipChange.ipc$dispatch("726052913", new Object[]{this, activity});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1565043882")) {
                ipChange.ipc$dispatch("-1565043882", new Object[]{this, activity});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1660221709")) {
                ipChange.ipc$dispatch("-1660221709", new Object[]{this, activity});
                return;
            }
            DMUpdateManager.this.a.unregisterActivityLifecycleCallbacks(this);
            DMUpdateManager.this.k();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "483372905")) {
                ipChange.ipc$dispatch("483372905", new Object[]{this, activity, bundle});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1820489609")) {
                ipChange.ipc$dispatch("1820489609", new Object[]{this, activity});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1611658173")) {
                ipChange.ipc$dispatch("1611658173", new Object[]{this, activity});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.update.DMUpdateManager$b */
    /* loaded from: classes.dex */
    public class ComponentCallbacks2C0943b implements ComponentCallbacks2 {
        private static transient /* synthetic */ IpChange $ipChange;

        ComponentCallbacks2C0943b() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-329946036")) {
                ipChange.ipc$dispatch("-329946036", new Object[]{this, configuration});
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "737108659")) {
                ipChange.ipc$dispatch("737108659", new Object[]{this});
            }
        }

        @Override // android.content.ComponentCallbacks2
        @TargetApi(14)
        public void onTrimMemory(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-100666236")) {
                ipChange.ipc$dispatch("-100666236", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 20) {
                DMUpdateManager dMUpdateManager = DMUpdateManager.this;
                if (dMUpdateManager.f(dMUpdateManager.a) == null) {
                    return;
                }
                DMUpdateManager dMUpdateManager2 = DMUpdateManager.this;
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = dMUpdateManager2.f(dMUpdateManager2.a).getRunningAppProcesses();
                if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(0);
                    if (runningAppProcessInfo.uid == DMUpdateManager.this.a.getApplicationInfo().uid && runningAppProcessInfo.importance == 100) {
                        return;
                    }
                }
                DMUpdateManager.this.a.registerActivityLifecycleCallbacks(DMUpdateManager.this.d);
                DMUpdateManager.this.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ActivityManager f(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348966517")) {
            return (ActivityManager) ipChange.ipc$dispatch("-1348966517", new Object[]{this, application});
        }
        try {
            if (this.b == null) {
                this.b = (ActivityManager) application.getSystemService("activity");
            }
        } catch (Throwable unused) {
        }
        return this.b;
    }

    public static DMUpdateManager g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223020059")) {
            return (DMUpdateManager) ipChange.ipc$dispatch("1223020059", new Object[0]);
        }
        if (f == null) {
            synchronized (DMUpdateManager.class) {
                if (f == null) {
                    f = new DMUpdateManager();
                }
            }
        }
        return f;
    }

    public UpdateSDK h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "946516523") ? (UpdateSDK) ipChange.ipc$dispatch("946516523", new Object[]{this}) : this.c;
    }

    public void i(final C9444mm c9444mm, boolean z) {
        Application application;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119994505")) {
            ipChange.ipc$dispatch("-2119994505", new Object[]{this, c9444mm, Boolean.valueOf(z)});
        } else if (c9444mm != null && (application = c9444mm.application) != null) {
            this.a = application;
            String processName = pu2.getProcessName(application);
            UpdateRuntime.processName = processName;
            if (processName.equals(c9444mm.application.getPackageName())) {
                Log.d("update-sdk", "initialize app in process " + UpdateRuntime.processName);
                UpdateRuntime.init(this.a, c9444mm);
                UpdateRuntime.execute(new Runnable() { // from class: cn.damai.commonbusiness.update.DMUpdateManager.3
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1616871555")) {
                            ipChange2.ipc$dispatch("-1616871555", new Object[]{this});
                            return;
                        }
                        ju2 enableMonitor = new ju2(c9444mm).enableMonitor(null);
                        if (c9444mm.autoStart) {
                            enableMonitor.enableCheckUpdateOnStartup();
                        }
                        DMUpdateManager.this.c = new UpdateSDK(enableMonitor);
                        DMUpdateManager.this.c.init(enableMonitor);
                    }
                });
                if (z) {
                    c9444mm.application.registerComponentCallbacks(this.e);
                }
            }
        } else {
            Log.d("update-sdk", "initialize app config is null || application == null!");
        }
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577757830")) {
            ipChange.ipc$dispatch("577757830", new Object[]{this});
        } else if (this.c != null) {
            this.c.onBackground();
        }
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205918289")) {
            ipChange.ipc$dispatch("1205918289", new Object[]{this});
        } else if (this.c != null) {
            this.c.onForeground();
        }
    }
}
