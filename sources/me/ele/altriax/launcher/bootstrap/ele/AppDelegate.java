package me.ele.altriax.launcher.bootstrap.ele;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.launcher.LaunchScheduler;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.config.Configuration;
import com.taobao.android.launcher.config.Generator;
import com.taobao.login4android.session.SessionManager;
import com.ut.device.UTDevice;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.altriax.launcher.biz.strategy.Discriminator;
import me.ele.altriax.launcher.bootstrap.AppDelegateInner;
import me.ele.altriax.launcher.bootstrap.Options;
import me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegister;
import me.ele.altriax.launcher.bootstrap.ele.strategy.ActivityCreatedStrategy;
import me.ele.altriax.launcher.bootstrap.ele.strategy.FirstActivityStrategy;
import me.ele.altriax.launcher.common.AltriaXLog;
import me.ele.altriax.launcher.config.ab.Generators;
import me.ele.altriax.launcher.impl.LauncherDeffer;
import me.ele.altriax.launcher.impl.LauncherFactory;
import me.ele.altriax.launcher.impl.LauncherProvider;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AppDelegate implements AppDelegateInner, ActivityCreatedStrategy.ActivityCreatedListener, FirstActivityStrategy.FirstActivityCreatedListener {
    private OnLineMonitorRegisterDelegate lineMonitorRegisterDelegate;
    private OnLineMonitorRegister onLineMonitorRegister;
    private Options options;
    private LaunchScheduler scheduler;
    private List<String> firstActivityFilter = new ArrayList();
    private AtomicInteger schemaWaked = new AtomicInteger(0);
    private AtomicInteger schemaWebWaked = new AtomicInteger(0);
    private AtomicInteger externalLinkSW = new AtomicInteger(0);
    private AtomicInteger externalLinkSWW = new AtomicInteger(0);

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void attachBaseContext(Context context) {
        UTDevice.setCollectDelayTime(DateUtils.MILLIS_PER_MINUTE);
        if (TextUtils.isEmpty(this.options.processName) || !this.options.processName.contains(SessionManager.CHANNEL_PROCESS)) {
            return;
        }
        Process.setThreadPriority(5);
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegateInner
    public void bindApp(Application application, Options options) {
        this.options = options;
        LauncherRuntime.init(application, options.packageName, options.processName, options.startTime);
        LauncherFactory launcherFactory = new LauncherFactory();
        LauncherProvider launcherProvider = new LauncherProvider();
        LauncherDeffer launcherDeffer = new LauncherDeffer();
        Generator<String> create = Generators.create(application);
        AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, "DAG class", null, create.getClass().getSimpleName()));
        AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, "distributed lock", null, "true"));
        Configuration build = new Configuration.Builder(launcherFactory, launcherProvider, create).bizSwitch("default").taskDeffer(launcherDeffer).build();
        LaunchScheduler create2 = LaunchScheduler.create(options.processName, build);
        this.scheduler = create2;
        LauncherRuntime.sReceiver = create2.asReceiver();
        LauncherRuntime.sConfiguration = build;
        OnLineMonitorRegister onLineMonitorRegister = new OnLineMonitorRegister();
        this.onLineMonitorRegister = onLineMonitorRegister;
        onLineMonitorRegister.mOnBootFinishedListener = new OnLineMonitorRegister.OnBootFinishedListener() { // from class: me.ele.altriax.launcher.bootstrap.ele.AppDelegate.1
            @Override // me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegister.OnBootFinishedListener
            public void onBootFinished(boolean z) {
                if (z) {
                    AppDelegate.this.scheduler.asReceiver().onBootFinished();
                }
            }
        };
        this.lineMonitorRegisterDelegate = new OnLineMonitorRegisterDelegate(this.onLineMonitorRegister, application);
        FirstActivityStrategy firstActivityStrategy = new FirstActivityStrategy();
        firstActivityStrategy.setFirstActivityFilter(this.firstActivityFilter);
        firstActivityStrategy.setFirstActivityCreatedListener(this);
        this.lineMonitorRegisterDelegate.addStrategy(firstActivityStrategy);
        ActivityCreatedStrategy activityCreatedStrategy = new ActivityCreatedStrategy();
        activityCreatedStrategy.setActivityCreatedListener(this);
        this.lineMonitorRegisterDelegate.addStrategy(activityCreatedStrategy);
        this.lineMonitorRegisterDelegate.register();
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onAppSecurityGuard() {
        this.scheduler.asReceiver().onAppSecurityGuard(LauncherRuntime.sContext);
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onAttach() {
        this.scheduler.asReceiver().onAppAttach(LauncherRuntime.sContext);
    }

    @Override // me.ele.altriax.launcher.bootstrap.ele.strategy.ActivityCreatedStrategy.ActivityCreatedListener
    public void onBaseActivityCreated(@NonNull Activity activity) {
        onSchemaWaked();
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onCreate() {
        this.scheduler.asReceiver().onAppCreated(LauncherRuntime.sContext);
    }

    @Override // me.ele.altriax.launcher.bootstrap.ele.strategy.FirstActivityStrategy.FirstActivityCreatedListener
    public void onFirstActivityCreated(@NonNull Activity activity, @NonNull Bundle bundle) {
        this.scheduler.asReceiver().onFirstActivityCreated(activity);
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onMain() {
        this.scheduler.asReceiver().onAppMain(LauncherRuntime.sContext);
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onSchemaWaked() {
        if (Discriminator.externalLink && this.externalLinkSW.get() == 0) {
            this.externalLinkSW.set(1);
        } else if (this.schemaWaked.compareAndSet(0, 1)) {
            this.scheduler.asReceiver().onSchemaWaked();
        }
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onSchemaWebWaked() {
        if (Discriminator.externalLink && this.externalLinkSWW.get() == 0) {
            this.externalLinkSWW.set(1);
        } else if (this.schemaWebWaked.compareAndSet(0, 1)) {
            this.scheduler.asReceiver().onSchemaWebWaked();
        }
    }

    @Override // me.ele.altriax.launcher.bootstrap.ele.strategy.ActivityCreatedStrategy.ActivityCreatedListener
    public void onWebActivityCreated(@NonNull Activity activity) {
        onSchemaWaked();
        onSchemaWebWaked();
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void setFirstActivityFilter(@NonNull String str) {
        this.firstActivityFilter.add(str);
    }
}
