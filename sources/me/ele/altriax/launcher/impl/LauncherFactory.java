package me.ele.altriax.launcher.impl;

import com.taobao.android.job.core.task.Task;
import com.taobao.android.job.core.task.TaskFactory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LauncherFactory implements TaskFactory<String, Void> {
    @Override // com.taobao.android.job.core.task.TaskFactory
    public Task<String, Void> newRunner(Task<String, Void> task) {
        return new LauncherTask(task);
    }
}
