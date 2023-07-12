package com.taobao.accs.net;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.taobao.accs.internal.AccsJobService;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class JobHeartBeatMgt extends HeartbeatManager {
    public static final int DEAMON_JOB_ID = 2051;
    public static final int HB_JOB_ID = 2050;
    private static final long INTERVAL = 1200000;
    private int result;
    private JobScheduler scheduler;

    /* JADX INFO: Access modifiers changed from: protected */
    public JobHeartBeatMgt(Context context) {
        super(context);
    }

    public static void setPeriodic(Context context) {
        ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(2051, new ComponentName(context.getPackageName(), AccsJobService.class.getName())).setPeriodic(INTERVAL).setRequiredNetworkType(1).build());
    }

    @Override // com.taobao.accs.net.HeartbeatManager
    protected void setInner(int i) {
        if (this.scheduler == null) {
            this.scheduler = (JobScheduler) this.mContext.getSystemService("jobscheduler");
        }
        long j = i * 1000;
        this.result = this.scheduler.schedule(new JobInfo.Builder(2050, new ComponentName(this.mContext.getPackageName(), AccsJobService.class.getName())).setMinimumLatency(j).setOverrideDeadline(j).setRequiredNetworkType(1).build());
    }
}
