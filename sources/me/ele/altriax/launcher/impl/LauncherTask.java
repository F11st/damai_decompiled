package me.ele.altriax.launcher.impl;

import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.helper.TimeHelpers;
import com.taobao.android.job.core.task.DelegateTask;
import com.taobao.android.job.core.task.ExecutionResults;
import com.taobao.android.job.core.task.Task;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.statistics.MotuCrash;
import com.taobao.android.launcher.statistics.TaoApm;
import com.taobao.android.launcher.statistics.trace.DAGTraceX;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LauncherTask extends DelegateTask<String, Void> {
    private static final String ORANGE_CATEGORY = "launch_config";
    private static final String ORANGE_SWITCH_NEED_REPORT = "1";
    private static final String ORANGE_SWITCH_REPORT = "is_report_crash";
    private static final String ORANGE_SWITCH_WHITE_LIST = "crash_white_list";
    private static final String TAG = "LauncherTask";

    /* JADX INFO: Access modifiers changed from: package-private */
    public LauncherTask(@NonNull Task<String, Void> task) {
        super(task);
    }

    private void onError(Throwable th) {
        if (LauncherRuntime.sDebuggable) {
            Log.e(TAG, "execute task '%s' failed with exception:", getId(), th);
        }
        OrangeConfig orangeConfig = OrangeConfig.getInstance();
        String config = orangeConfig.getConfig(ORANGE_CATEGORY, ORANGE_SWITCH_REPORT, "1");
        String config2 = orangeConfig.getConfig(ORANGE_CATEGORY, ORANGE_SWITCH_WHITE_LIST, "");
        if ("1".equals(config)) {
            if (TextUtils.isEmpty(config2) || !config2.contains(getId())) {
                MotuCrash.reportCrash(LauncherRuntime.sContext, getId(), th);
            }
        }
    }

    @Override // com.taobao.android.job.core.task.DelegateTask, com.taobao.android.job.core.task.Task
    public boolean intercept(ExecutionResults<String, Void> executionResults) {
        return !TaskSwitches.isTaskSwitchOn(getId()) && getTargetTask().intercept(executionResults);
    }

    @Override // com.taobao.android.job.core.task.Task
    public Void execute() {
        long j;
        if (LauncherRuntime.sDebuggable) {
            j = System.currentTimeMillis();
            Log.v(TAG, "Executing launcher # %s, thread priority:%d", getId(), Integer.valueOf(Process.getThreadPriority(Process.myTid())));
        } else {
            j = 0;
        }
        String id = getId();
        try {
            DAGTraceX.beginSection(id);
            TaoApm.startTask(id);
            Void execute = getTargetTask().execute();
            TaoApm.endTask(id);
            DAGTraceX.end();
            if (LauncherRuntime.sDebuggable) {
                Log.v(TAG, "Executed launcher # %s, Execution Done with result=%s, cost=%d ms", getId(), execute, Long.valueOf(TimeHelpers.since(j)));
            }
            return execute;
        } catch (Throwable th) {
            try {
                onError(th);
            } finally {
                TaoApm.endTask(id);
                DAGTraceX.end();
                if (LauncherRuntime.sDebuggable) {
                    Log.v(TAG, "Executed launcher # %s, Execution Done with result=%s, cost=%d ms", getId(), null, Long.valueOf(TimeHelpers.since(j)));
                }
            }
        }
    }
}
