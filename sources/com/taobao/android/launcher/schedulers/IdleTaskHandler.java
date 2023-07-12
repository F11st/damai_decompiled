package com.taobao.android.launcher.schedulers;

import androidx.annotation.NonNull;
import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.DAGTaskChain;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.Constants;
import com.taobao.android.launcher.LaunchScheduler;
import com.taobao.android.launcher.StageRunnable;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.report.ExecutionReporter;
import com.taobao.android.launcher.switches.LauncherSwitches;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class IdleTaskHandler implements Runnable {
    private final LaunchScheduler scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdleTaskHandler(@NonNull LaunchScheduler launchScheduler) {
        this.scheduler = launchScheduler;
    }

    private void scheduleIdle() {
        LauncherRuntime.sCold = false;
        if (LauncherSwitches.isStageSwitchOn(Constants.STAGE_MAIN_IDLE)) {
            Log.e(Constants.TAG_LIFE_CYCLE, "onIdled, but ignore because of switch m-idle", new Object[0]);
            return;
        }
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled", new Object[0]);
        long idleDelay = LauncherSwitches.getIdleDelay();
        if (idleDelay == 0) {
            idleDelay = 200;
        }
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE);
        this.scheduler.generator.genMainIdle(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, idleDelay, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.IdleTaskHandler.1
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle2s();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleIdle10s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled10s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_10s);
        this.scheduler.generator.genMainIdle10s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 5L, TimeUnit.SECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.IdleTaskHandler.4
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle15s();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleIdle15s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled15s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_15s);
        this.scheduler.generator.genMainIdle15s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 5L, TimeUnit.SECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.IdleTaskHandler.5
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle30s();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleIdle2s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled2s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_2s);
        this.scheduler.generator.genMainIdle2s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 2L, TimeUnit.SECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.IdleTaskHandler.2
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle5s();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleIdle30s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled30s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_30s);
        this.scheduler.generator.genMainIdle30s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 15L, TimeUnit.SECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.IdleTaskHandler.6
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleIdle5s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled5s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_5s);
        this.scheduler.generator.genMainIdle5s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 5L, TimeUnit.SECONDS, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.IdleTaskHandler.3
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle10s();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        scheduleIdle();
    }
}
