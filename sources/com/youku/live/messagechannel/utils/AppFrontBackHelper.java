package com.youku.live.messagechannel.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AppFrontBackHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "com.youku.live.messagechannel.utils.AppFrontBackHelper";
    private static AppFrontBackHelper appFrontBackHelper = new AppFrontBackHelper();
    private static ScheduledThreadPoolExecutor startExecutor = new ScheduledThreadPoolExecutor(1);
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
    private volatile int activityStartCount;
    private Application application;
    private Set<FrontBackEventListener> frontBackEventListeners;
    private String frontBackHelperStartDelay;
    private volatile boolean onBackground;
    private volatile boolean registered;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface FrontBackEventListener {
        void onBack();

        void onFront();
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    class StartTask implements Runnable {
        private Application tempApplication;

        public StartTask(Application application) {
            this.tempApplication = application;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.tempApplication == null || AppFrontBackHelper.this.registered) {
                return;
            }
            AppFrontBackHelper.this.application = this.tempApplication;
            AppFrontBackHelper.this.application.registerActivityLifecycleCallbacks(AppFrontBackHelper.this.activityLifecycleCallbacks);
            AppFrontBackHelper.this.registered = true;
            MyLog.i(AppFrontBackHelper.TAG, "register activity lifecycle callbacks success.");
        }
    }

    private AppFrontBackHelper() {
        OrangeConfig orangeConfig = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.frontBackHelperStartDelay;
        this.frontBackHelperStartDelay = orangeConfig.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        this.registered = false;
        this.activityStartCount = 1;
        this.onBackground = false;
        this.frontBackEventListeners = new HashSet();
        this.activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.youku.live.messagechannel.utils.AppFrontBackHelper.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1298391181")) {
                    ipChange.ipc$dispatch("-1298391181", new Object[]{this, activity, bundle});
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1986063056")) {
                    ipChange.ipc$dispatch("-1986063056", new Object[]{this, activity});
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "464922295")) {
                    ipChange.ipc$dispatch("464922295", new Object[]{this, activity});
                    return;
                }
                AppFrontBackHelper.access$010(AppFrontBackHelper.this);
                MyLog.v(AppFrontBackHelper.TAG, "onActivityPaused, activity:", activity.getLocalClassName(), ", activityCount:", Integer.valueOf(AppFrontBackHelper.this.activityStartCount));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1139187634")) {
                    ipChange.ipc$dispatch("1139187634", new Object[]{this, activity});
                    return;
                }
                AppFrontBackHelper.access$008(AppFrontBackHelper.this);
                MyLog.v(AppFrontBackHelper.TAG, "onActivityResumed, activity:", activity.getLocalClassName(), ", activityCount:", Integer.valueOf(AppFrontBackHelper.this.activityStartCount));
                if (AppFrontBackHelper.this.activityStartCount == 1 && AppFrontBackHelper.this.onBackground) {
                    AppFrontBackHelper.this.onBackground = false;
                    MyLog.i(AppFrontBackHelper.TAG, "OnFront from back.");
                    for (FrontBackEventListener frontBackEventListener : AppFrontBackHelper.this.frontBackEventListeners) {
                        frontBackEventListener.onFront();
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "244261642")) {
                    ipChange.ipc$dispatch("244261642", new Object[]{this, activity, bundle});
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "324931656")) {
                    ipChange.ipc$dispatch("324931656", new Object[]{this, activity});
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "116100220")) {
                    ipChange.ipc$dispatch("116100220", new Object[]{this, activity});
                }
            }
        };
    }

    static /* synthetic */ int access$008(AppFrontBackHelper appFrontBackHelper2) {
        int i = appFrontBackHelper2.activityStartCount;
        appFrontBackHelper2.activityStartCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(AppFrontBackHelper appFrontBackHelper2) {
        int i = appFrontBackHelper2.activityStartCount;
        appFrontBackHelper2.activityStartCount = i - 1;
        return i;
    }

    public static AppFrontBackHelper getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-530960581") ? (AppFrontBackHelper) ipChange.ipc$dispatch("-530960581", new Object[0]) : appFrontBackHelper;
    }

    public void addFrontBackEventListener(FrontBackEventListener frontBackEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-410442873")) {
            ipChange.ipc$dispatch("-410442873", new Object[]{this, frontBackEventListener});
        } else {
            this.frontBackEventListeners.add(frontBackEventListener);
        }
    }

    public boolean isOnBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562041055")) {
            return ((Boolean) ipChange.ipc$dispatch("-562041055", new Object[]{this})).booleanValue();
        }
        if (this.activityStartCount == 0) {
            if (!this.onBackground) {
                this.onBackground = true;
                MyLog.i(TAG, "OnBack from front.");
                for (FrontBackEventListener frontBackEventListener : this.frontBackEventListeners) {
                    frontBackEventListener.onBack();
                }
            }
            return true;
        }
        if (this.onBackground) {
            this.onBackground = false;
        }
        return false;
    }

    public void removeFrontBackEventListener(FrontBackEventListener frontBackEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1992062476")) {
            ipChange.ipc$dispatch("1992062476", new Object[]{this, frontBackEventListener});
        } else {
            this.frontBackEventListeners.remove(frontBackEventListener);
        }
    }

    public void start(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490763221")) {
            ipChange.ipc$dispatch("-1490763221", new Object[]{this, application});
        } else if (application == null || this.registered) {
        } else {
            startExecutor.schedule(new StartTask(application), Integer.valueOf(this.frontBackHelperStartDelay).intValue(), TimeUnit.SECONDS);
        }
    }
}
