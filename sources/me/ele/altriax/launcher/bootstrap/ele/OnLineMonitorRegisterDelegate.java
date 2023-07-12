package me.ele.altriax.launcher.bootstrap.ele;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.altriax.launcher.bootstrap.ele.delegate.RegisterDelegate;
import me.ele.altriax.launcher.bootstrap.ele.strategy.Strategy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OnLineMonitorRegisterDelegate implements RegisterDelegate {
    private final Application application;
    private final RegisterDelegate registerDelegate;
    private AtomicInteger activityCount = new AtomicInteger(0);
    private AtomicBoolean registered = new AtomicBoolean(false);
    private List<Strategy> strategies = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ForegroundChangeListener {
        void onForeground(boolean z);
    }

    public OnLineMonitorRegisterDelegate(@NonNull RegisterDelegate registerDelegate, @NonNull Application application) {
        this.registerDelegate = registerDelegate;
        this.application = application;
    }

    private void registerForegroundChanged(@NonNull Application application, @NonNull final ForegroundChangeListener foregroundChangeListener) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegisterDelegate.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (OnLineMonitorRegisterDelegate.this.strategies == null || OnLineMonitorRegisterDelegate.this.strategies.size() <= 0) {
                    return;
                }
                for (Strategy strategy : OnLineMonitorRegisterDelegate.this.strategies) {
                    strategy.activity(activity, activity.getClass().getName(), bundle);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                OnLineMonitorRegisterDelegate.this.activityCount.getAndIncrement();
                if (OnLineMonitorRegisterDelegate.this.activityCount.get() == 1) {
                    foregroundChangeListener.onForeground(true);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                OnLineMonitorRegisterDelegate.this.activityCount.getAndDecrement();
                if (OnLineMonitorRegisterDelegate.this.activityCount.get() == 0) {
                    foregroundChangeListener.onForeground(false);
                }
            }
        });
    }

    public void addStrategy(@NonNull Strategy strategy) {
        this.strategies.add(strategy);
    }

    @Override // me.ele.altriax.launcher.bootstrap.ele.delegate.RegisterDelegate
    public void register() {
        registerForegroundChanged(this.application, new ForegroundChangeListener() { // from class: me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegisterDelegate.1
            @Override // me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegisterDelegate.ForegroundChangeListener
            public void onForeground(boolean z) {
                if (OnLineMonitorRegisterDelegate.this.registered.get()) {
                    return;
                }
                OnLineMonitorRegisterDelegate.this.registerDelegate.register();
                OnLineMonitorRegisterDelegate.this.registered.set(true);
            }
        });
    }
}
