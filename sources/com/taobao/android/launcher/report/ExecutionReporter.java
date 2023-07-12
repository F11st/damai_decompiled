package com.taobao.android.launcher.report;

import android.content.Context;
import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.statistics.DAGRuntime;
import com.taobao.android.launcher.switches.LauncherSwitches;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ExecutionReporter {
    public static void reportDAGStage(Context context, DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
        if (LauncherSwitches.isDAGReportEnable()) {
            DAGRuntime.reportDAGStage(context, dAGStage, executionSummary);
        }
    }
}
