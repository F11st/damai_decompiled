package com.taobao.update;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import com.taobao.update.framework.UpdateRuntime;
import java.util.List;
import tb.ju2;
import tb.mm;
import tb.pu2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UpdateManager {
    private static UpdateManager f;
    private Application a;
    private ActivityManager b;
    private volatile UpdateSDK c;
    private Application.ActivityLifecycleCallbacks d = new a();
    private ComponentCallbacks2 e = new b();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            UpdateManager.this.a.unregisterActivityLifecycleCallbacks(this);
            UpdateManager.this.onForeground();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class b implements ComponentCallbacks2 {
        b() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        @TargetApi(14)
        public void onTrimMemory(int i) {
            if (i == 20) {
                UpdateManager updateManager = UpdateManager.this;
                if (updateManager.f(updateManager.a) == null) {
                    return;
                }
                UpdateManager updateManager2 = UpdateManager.this;
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = updateManager2.f(updateManager2.a).getRunningAppProcesses();
                if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(0);
                    if (runningAppProcessInfo.uid == UpdateManager.this.a.getApplicationInfo().uid && runningAppProcessInfo.importance == 100) {
                        return;
                    }
                }
                UpdateManager.this.a.registerActivityLifecycleCallbacks(UpdateManager.this.d);
                UpdateManager.this.onBackground();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ActivityManager f(Application application) {
        try {
            if (this.b == null) {
                this.b = (ActivityManager) application.getSystemService("activity");
            }
        } catch (Throwable unused) {
        }
        return this.b;
    }

    public static UpdateManager getInstance() {
        if (f == null) {
            synchronized (UpdateManager.class) {
                if (f == null) {
                    f = new UpdateManager();
                }
            }
        }
        return f;
    }

    public void init(final mm mmVar, boolean z) {
        Application application;
        if (mmVar != null && (application = mmVar.application) != null) {
            this.a = application;
            String processName = pu2.getProcessName(application);
            UpdateRuntime.processName = processName;
            if (processName.equals(mmVar.application.getPackageName())) {
                Log.d("update-sdk", "initialize app in process " + UpdateRuntime.processName);
                UpdateRuntime.init(this.a, mmVar);
                UpdateRuntime.execute(new Runnable() { // from class: com.taobao.update.UpdateManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ju2 enableMonitor = new ju2(mmVar).enableApkUpdate().enableMonitor(null);
                        if (mmVar.autoStart) {
                            enableMonitor.enableCheckUpdateOnStartup();
                        }
                        UpdateManager.this.c = new UpdateSDK(enableMonitor);
                        UpdateManager.this.c.init(enableMonitor);
                    }
                });
                if (z) {
                    mmVar.application.registerComponentCallbacks(this.e);
                    return;
                }
                return;
            }
            return;
        }
        Log.d("update-sdk", "initialize app config is null || application == null!");
    }

    public void onBackground() {
        if (this.c != null) {
            this.c.onBackground();
        }
    }

    public void onExit() {
        if (this.c != null) {
            this.c.onExit();
        }
    }

    public void onForeground() {
        if (this.c != null) {
            this.c.onForeground();
        }
    }
}
