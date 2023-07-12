package com.taobao.android.launcher.schedulers;

import com.taobao.android.job.core.DAGSchedulerConfig;
import com.taobao.android.launcher.DefaultOnDemandReceiver;
import com.taobao.android.launcher.LaunchScheduler;
import com.taobao.android.launcher.common.OnDemandReceiver;
import com.taobao.android.launcher.config.Configuration;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class EmptyScheduler extends LaunchScheduler {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private static class Lazy {
        private static final OnDemandReceiver receiver = new DefaultOnDemandReceiver();

        private Lazy() {
        }
    }

    public EmptyScheduler(Configuration configuration) {
        super(configuration);
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    public OnDemandReceiver asReceiver() {
        return Lazy.receiver;
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    protected DAGSchedulerConfig<String, Void> createConfig() {
        return null;
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    protected DAGSchedulerConfig<String, Void> createDemandConfig() {
        return null;
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    public void schedule() {
    }
}
