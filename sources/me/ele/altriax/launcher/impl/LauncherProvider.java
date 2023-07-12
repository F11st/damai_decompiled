package me.ele.altriax.launcher.impl;

import com.taobao.android.job.core.task.Task;
import com.taobao.android.job.core.task.TaskProvider;
import java.util.HashMap;
import java.util.Map;
import me.ele.altriax.launcher.biz.launcher.DMInitACCS;
import me.ele.altriax.launcher.biz.launcher.DMInitAus;
import me.ele.altriax.launcher.biz.launcher.DMInitCrashReport;
import me.ele.altriax.launcher.biz.launcher.DMInitDynamicX;
import me.ele.altriax.launcher.biz.launcher.DMInitFbm;
import me.ele.altriax.launcher.biz.launcher.DMInitFlutter;
import me.ele.altriax.launcher.biz.launcher.DMInitImageLoader;
import me.ele.altriax.launcher.biz.launcher.DMInitLoginSDK;
import me.ele.altriax.launcher.biz.launcher.DMInitMtop;
import me.ele.altriax.launcher.biz.launcher.DMInitNav;
import me.ele.altriax.launcher.biz.launcher.DMInitOnlineMonitor;
import me.ele.altriax.launcher.biz.launcher.DMInitOrange;
import me.ele.altriax.launcher.biz.launcher.DMInitPopLayer;
import me.ele.altriax.launcher.biz.launcher.DMInitSecurity;
import me.ele.altriax.launcher.biz.launcher.DMInitTLog;
import me.ele.altriax.launcher.biz.launcher.DMInitTetrisProxy;
import me.ele.altriax.launcher.biz.launcher.DMInitUT;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LauncherProvider implements TaskProvider<String, Void> {
    private final Map<String, Task<String, Void>> tasks = new HashMap<String, Task<String, Void>>() { // from class: me.ele.altriax.launcher.impl.LauncherProvider.1
        {
            put("DMInitACCS", new DMInitACCS("DMInitACCS"));
            put("DMInitAus", new DMInitAus("DMInitAus"));
            put("DMInitCrashReport", new DMInitCrashReport("DMInitCrashReport"));
            put("DMInitDynamicX", new DMInitDynamicX("DMInitDynamicX"));
            put("DMInitFbm", new DMInitFbm("DMInitFbm"));
            put("DMInitFlutter", new DMInitFlutter("DMInitFlutter"));
            put("DMInitImageLoader", new DMInitImageLoader("DMInitImageLoader"));
            put("DMInitLoginSDK", new DMInitLoginSDK("DMInitLoginSDK"));
            put("DMInitMtop", new DMInitMtop("DMInitMtop"));
            put("DMInitNav", new DMInitNav("DMInitNav"));
            put("DMInitOnlineMonitor", new DMInitOnlineMonitor("DMInitOnlineMonitor"));
            put("DMInitOrange", new DMInitOrange("DMInitOrange"));
            put("DMInitPopLayer", new DMInitPopLayer("DMInitPopLayer"));
            put("DMInitSecurity", new DMInitSecurity("DMInitSecurity"));
            put("DMInitTLog", new DMInitTLog("DMInitTLog"));
            put("DMInitTetrisProxy", new DMInitTetrisProxy("DMInitTetrisProxy"));
            put("DMInitUT", new DMInitUT("DMInitUT"));
        }
    };

    public void clear() {
        this.tasks.clear();
    }

    @Override // com.taobao.android.job.core.task.TaskProvider
    public Task<String, Void> provideTask(String str) {
        return this.tasks.get(str);
    }
}
