package com.taobao.android.launcher.statistics;

import android.content.Context;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.common.Switches;
import com.taobao.android.launcher.statistics.LazyExecutor;
import com.taobao.android.launcher.statistics.Startup;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Startups {
    private static final String SWITCH_REPORT_STARTUP = ".report_startup_data";
    public static final String TAG = "Startups";

    public static void addJank(int i, long j) {
        Startup.Lazy.instance.addJank(i, j);
    }

    public static void addStage(String str, ExecutionSummary executionSummary, Map<String, ExecutionSummary> map) {
        Startup.Lazy.instance.addStage(str, executionSummary, map);
    }

    public static void dump(Context context) {
        Startup.Lazy.instance.dump(context);
    }

    public static boolean isEnabled() {
        return Switches.isSwitchOn(SWITCH_REPORT_STARTUP);
    }

    public static void start() {
        Startup.Lazy.instance.start();
    }

    public static void submit(final Context context) {
        Log.e(TAG, "[Startup][commit] submit", new Object[0]);
        LazyExecutor.Startup.EXECUTOR.submit(new Runnable() { // from class: com.taobao.android.launcher.statistics.Startups.1
            @Override // java.lang.Runnable
            public void run() {
                Startup startup = Startup.Lazy.instance;
                startup.submit(context);
                startup.teardown();
            }
        });
    }

    public static void teardown() {
        Startup.Lazy.instance.teardown();
    }
}
