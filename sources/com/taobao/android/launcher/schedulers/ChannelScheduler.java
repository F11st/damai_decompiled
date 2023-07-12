package com.taobao.android.launcher.schedulers;

import android.app.Activity;
import android.content.Context;
import com.taobao.android.job.core.DAGSchedulerConfig;
import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.DAGTaskChain;
import com.taobao.android.job.core.helper.ThreadPoolHelpers;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.DAGExecutors;
import com.taobao.android.launcher.LaunchScheduler;
import com.taobao.android.launcher.StageRunnable;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.common.OnDemandReceiver;
import com.taobao.android.launcher.config.Configuration;
import com.taobao.android.launcher.report.ExecutionReporter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ChannelScheduler extends LaunchScheduler implements OnDemandReceiver {
    private static final int POOL_SIZE = ThreadPoolHelpers.poolSize(0.0d);

    public ChannelScheduler(Configuration configuration) {
        super(configuration);
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    public OnDemandReceiver asReceiver() {
        return this;
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    protected DAGSchedulerConfig<String, Void> createConfig() {
        int i = POOL_SIZE;
        return new DAGSchedulerConfig<>(DAGExecutors.create("launcher", i, i, 5));
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    protected DAGSchedulerConfig<String, Void> createDemandConfig() {
        return null;
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppAttach(Context context) {
        DAGStage<String, Void> createStage = createStage("c-a");
        this.generator.genChannelAttach(DAGTaskChain.from(createStage));
        schedule(createStage, new StageRunnable<String, Void>() { // from class: com.taobao.android.launcher.schedulers.ChannelScheduler.1
            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppCreated(Context context) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppMain(Context context) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppPreCreated(Context context) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onAppSecurityGuard(Context context) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onBackground(Activity activity) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onBootFinished() {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onColdLogin() {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onFirstActivityCreated(Activity activity) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onFirstActivityDestroyed(Activity activity) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onFirstActivityStarted(Activity activity) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onFirstActivityStopped(Activity activity) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onForeground(Activity activity) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onIdle() {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onLogin() {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onLogout() {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onSchemaWaked() {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onSchemaWaked(Activity activity) {
    }

    @Override // com.taobao.android.launcher.common.OnDemandReceiver
    public void onSchemaWebWaked() {
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    public void schedule() {
    }
}
