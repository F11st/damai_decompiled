package com.taobao.android.launcher.schedulers;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.taobao.android.job.core.DAGSchedulerConfig;
import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.DAGTaskChain;
import com.taobao.android.job.core.SchedulePolicy;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.helper.ThreadPoolHelpers;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.Constants;
import com.taobao.android.launcher.DAGExecutor;
import com.taobao.android.launcher.DAGExecutorParam;
import com.taobao.android.launcher.DAGExecutors;
import com.taobao.android.launcher.LaunchScheduler;
import com.taobao.android.launcher.StageRunnable;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.common.OnDemandReceiver;
import com.taobao.android.launcher.config.Configuration;
import com.taobao.android.launcher.device.LowDevice;
import com.taobao.android.launcher.idle.IdleChecker;
import com.taobao.android.launcher.report.ExecutionReporter;
import java.util.concurrent.TimeUnit;
import me.ele.altriax.launcher.common.AltriaXLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MainScheduler extends LaunchScheduler implements DAGExecutor.Interceptor, OnDemandReceiver, Runnable {
    private static final boolean DAG_CREATE_SYSTRACE;
    private static final int POOL_SIZE_IDLE = ThreadPoolHelpers.poolSize(0.0d);
    private static final boolean REPORT_M_FRONT;
    private static final String TAG = "MainScheduler";
    private final Runnable idleTaskHandler;
    private volatile boolean isIdle;

    static {
        DAG_CREATE_SYSTRACE = Log.isLoggable("systrace", 2) && Build.VERSION.SDK_INT >= 18;
        REPORT_M_FRONT = Log.isLoggable("MFront", 2);
    }

    public MainScheduler(Configuration configuration) {
        super(configuration);
        this.isIdle = false;
        this.idleTaskHandler = new IdleTaskHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void idleCheckerSetup() {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onIdle");
        IdleChecker.setup(this);
    }

    private void idleRealStart() {
        this.isIdle = true;
        this.idleTaskHandler.run();
    }

    private void onBootFinishedInternal(final boolean z) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onBootFinished");
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, Constants.STAGE_MAIN_BOOT_FINISH);
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_BOOT_FINISH);
        this.generator.genMainBootFinished(DAGTaskChain.from(createStage));
        schedule(createStage, 200L, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.14
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                if (z) {
                    MainScheduler.this.idleCheckerSetup();
                }
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    private void onIdleInternal() {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onIdle internal");
        if (((Boolean) LowDevice.identify().first).booleanValue()) {
            onBootFinishedInternal(false);
            idleRealStart();
            return;
        }
        idleRealStart();
    }

    private void scheduleDebugStage() {
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_APP_ATTACH_DEBUG);
        this.generator.genMainAttachDebug(DAGTaskChain.from(createStage));
        schedule(createStage, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.1
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    @Override // com.taobao.android.launcher.DAGExecutor.Interceptor
    public boolean adjustParam(@NonNull DAGExecutorParam dAGExecutorParam) {
        if (this.isIdle) {
            dAGExecutorParam.coreSize = 1;
            dAGExecutorParam.maxPoolSize = POOL_SIZE_IDLE;
            dAGExecutorParam.priority = 1;
            return true;
        }
        return false;
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    public OnDemandReceiver asReceiver() {
        return this;
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    protected DAGSchedulerConfig<String, Void> createConfig() {
        int poolSize = ThreadPoolHelpers.poolSize(0.5d);
        return new DAGSchedulerConfig<>(DAGExecutors.create("launcher", poolSize, poolSize, 10, this));
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    protected DAGSchedulerConfig<String, Void> createDemandConfig() {
        return new DAGSchedulerConfig<>(DAGExecutors.create("launcher-demand", 1, ThreadPoolHelpers.poolSize(0.0d), 5));
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppAttach(Context context) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onAppAttach start");
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, Constants.STAGE_MAIN_APP_FRONT);
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_APP_FRONT);
        DAGTaskChain<String> from = DAGTaskChain.from(createStage);
        final long uptimeMillis = SystemClock.uptimeMillis();
        android.util.Log.e(TAG, "m-front >> " + uptimeMillis);
        this.generator.genMainFront(from);
        schedule(createStage, 1L, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.2
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                if (MainScheduler.REPORT_M_FRONT) {
                    android.util.Log.e(MainScheduler.TAG, "m-front << " + (SystemClock.uptimeMillis() - uptimeMillis));
                    ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                }
            }
        });
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onAppAttach end");
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppCreated(Context context) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onAppCreated start");
        long uptimeMillis = SystemClock.uptimeMillis();
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, Constants.STAGE_MAIN_APP_ONCREATE);
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_APP_ONCREATE);
        DAGTaskChain<String> from = DAGTaskChain.from(createStage);
        boolean z = DAG_CREATE_SYSTRACE;
        if (z) {
            Trace.beginSection("m-a-c-dag-create");
        }
        final long uptimeMillis2 = SystemClock.uptimeMillis();
        android.util.Log.e(TAG, "m-a-c >> " + uptimeMillis2);
        this.generator.genMainCreate(from);
        if (z) {
            Trace.endSection();
        }
        schedule(createStage, SchedulePolicy.DEFERRABLE, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.7
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                android.util.Log.e(MainScheduler.TAG, "m-a-c << " + (SystemClock.uptimeMillis() - uptimeMillis2));
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
        LauncherRuntime.mAC = Math.abs(SystemClock.uptimeMillis() - uptimeMillis);
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onAppCreated end");
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppMain(Context context) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onAppMain start");
        if (LauncherRuntime.sDebuggable) {
            scheduleDebugStage();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, Constants.STAGE_MAIN_APP_LAUNCH);
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_APP_LAUNCH);
        DAGTaskChain<String> from = DAGTaskChain.from(createStage);
        final long uptimeMillis2 = SystemClock.uptimeMillis();
        android.util.Log.e(TAG, "m-launch >> " + uptimeMillis2);
        this.generator.genMainLaunch(from);
        SchedulePolicy schedulePolicy = SchedulePolicy.DEFERRABLE;
        schedule(createStage, schedulePolicy, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.4
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                android.util.Log.e(MainScheduler.TAG, "m-launch << " + (SystemClock.uptimeMillis() - uptimeMillis2));
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
        LauncherRuntime.mLaunch = Math.abs(SystemClock.uptimeMillis() - uptimeMillis);
        long uptimeMillis3 = SystemClock.uptimeMillis();
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, Constants.STAGE_MAIN_APP_ATTACH_HEAD);
        DAGStage<String, Void> createStage2 = createStage(Constants.STAGE_MAIN_APP_ATTACH_HEAD);
        DAGTaskChain<String> from2 = DAGTaskChain.from(createStage2);
        final long uptimeMillis4 = SystemClock.uptimeMillis();
        android.util.Log.e(TAG, "m-head >> " + uptimeMillis4);
        this.generator.genMainAttachHead(from2);
        schedule(createStage2, schedulePolicy, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.5
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                android.util.Log.e(MainScheduler.TAG, "m-head << " + (SystemClock.uptimeMillis() - uptimeMillis4));
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
        LauncherRuntime.mAHead = Math.abs(SystemClock.uptimeMillis() - uptimeMillis3);
        long uptimeMillis5 = SystemClock.uptimeMillis();
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, Constants.STAGE_MAIN_APP_ATTACH_TAIL);
        DAGStage<String, Void> createStage3 = createStage(Constants.STAGE_MAIN_APP_ATTACH_TAIL);
        DAGTaskChain<String> from3 = DAGTaskChain.from(createStage3);
        final long uptimeMillis6 = SystemClock.uptimeMillis();
        android.util.Log.e(TAG, "m-a-tail >> " + uptimeMillis6);
        this.generator.genMainAttachTail(from3);
        schedule(createStage3, schedulePolicy, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.6
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                android.util.Log.e(MainScheduler.TAG, "m-a-tail << " + (SystemClock.uptimeMillis() - uptimeMillis6));
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
        LauncherRuntime.mATail = Math.abs(SystemClock.uptimeMillis() - uptimeMillis5);
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onAppMain end");
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppPreCreated(Context context) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppSecurityGuard(Context context) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onAppSecurityGuard start");
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, Constants.STAGE_MAIN_APP_SECURITY_GUARD);
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_APP_SECURITY_GUARD);
        DAGTaskChain<String> from = DAGTaskChain.from(createStage);
        final long uptimeMillis = SystemClock.uptimeMillis();
        android.util.Log.e(TAG, "m-security-guard >> " + uptimeMillis);
        this.generator.genMainSecurityGuard(from);
        schedule(createStage, 1L, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.3
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                if (MainScheduler.REPORT_M_FRONT) {
                    android.util.Log.e(MainScheduler.TAG, "m-security-guard << " + (SystemClock.uptimeMillis() - uptimeMillis));
                    ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                }
            }
        });
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onAppSecurityGuard end");
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onBackground(Activity activity) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onBackground");
        DAGStage<String, Void> createDemandStage = createDemandStage(Constants.STAGE_MAIN_BACKGROUND);
        this.generator.genMainBackground(DAGTaskChain.from(createDemandStage));
        scheduleDemand(createDemandStage, 200L, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.13
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onBootFinished() {
        Pair<Boolean, Float> identify = LowDevice.identify();
        AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, "device", null, String.valueOf(identify.second)));
        if (((Boolean) identify.first).booleanValue()) {
            idleCheckerSetup();
            AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, "low device", null, String.valueOf(identify.second)));
            return;
        }
        onBootFinishedInternal(true);
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onColdLogin() {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onColdLogin");
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_COLD_LOGIN);
        this.generator.genMainColdLogin(DAGTaskChain.from(createStage));
        schedule(createStage, 200L, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.15
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onFirstActivityCreated(Activity activity) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onFirstActivityCreated start");
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_FIRST_ACTIVITY);
        DAGTaskChain<String> from = DAGTaskChain.from(createStage);
        boolean z = DAG_CREATE_SYSTRACE;
        if (z) {
            Trace.beginSection("m-f-a-dag-create");
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        android.util.Log.e(TAG, "m-f-a >> " + uptimeMillis);
        this.generator.genMainFirstActivity(from);
        if (z) {
            Trace.endSection();
        }
        schedule(createStage, SchedulePolicy.DEFERRABLE, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.8
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                android.util.Log.e(MainScheduler.TAG, "m-f-a << " + (SystemClock.uptimeMillis() - uptimeMillis));
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onFirstActivityCreated end");
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onFirstActivityDestroyed(Activity activity) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onFirstActivityDestroyed");
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onFirstActivityStarted(Activity activity) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onFirstActivityStarted");
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onFirstActivityStopped(Activity activity) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onFirstActivityStopped");
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onForeground(Activity activity) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onForeground");
        DAGStage<String, Void> createDemandStage = createDemandStage(Constants.STAGE_MAIN_FOREGROUND);
        this.generator.genMainForeground(DAGTaskChain.from(createDemandStage));
        scheduleDemand(createDemandStage, 200L, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.12
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onIdle() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdle from external", new Object[0]);
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onLogin() {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onLogin");
        DAGStage<String, Void> createDemandStage = createDemandStage(Constants.STAGE_MAIN_LOGIN);
        this.generator.genMainLogin(DAGTaskChain.from(createDemandStage));
        scheduleDemand(createDemandStage, 200L, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.16
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onLogout() {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onLogout");
        DAGStage<String, Void> createDemandStage = createDemandStage(Constants.STAGE_MAIN_LOGOUT);
        this.generator.genMainLogout(DAGTaskChain.from(createDemandStage));
        scheduleDemand(createDemandStage, 200L, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.17
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onSchemaWaked(Activity activity) {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onSchemaWaked");
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_SCHEMA_WAKE);
        this.generator.genMainSchemaWaked(DAGTaskChain.from(createStage));
        schedule(createStage, SchedulePolicy.DEFERRABLE, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.9
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onSchemaWebWaked() {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onSchemaWebWaked");
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_SCHEMA_WEB_WAKE);
        this.generator.genMainSchemaWebWaked(DAGTaskChain.from(createStage));
        schedule(createStage, SchedulePolicy.DEFERRABLE, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.11
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        onIdleInternal();
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    public void schedule() {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onSchemaWaked() {
        android.util.Log.e(Constants.TAG_LIFE_CYCLE, "onSchemaWaked");
        DAGStage<String, Void> createStage = createStage(Constants.STAGE_MAIN_SCHEMA_WAKE);
        this.generator.genMainSchemaWaked(DAGTaskChain.from(createStage));
        schedule(createStage, SchedulePolicy.DEFERRABLE, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.MainScheduler.10
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }
}
