package me.ele.altriax.launcher.impl;

import com.taobao.android.job.core.TaskDeffer;
import com.taobao.android.job.core.task.Task;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LauncherDeffer<T, R> implements TaskDeffer<T, R> {
    private final Queue<Task<T, R>> defferQueueNormal = new LinkedBlockingDeque(1);
    private final Queue<Task<T, R>> defferQueueLast = new LinkedBlockingDeque(1);

    @Override // com.taobao.android.job.core.TaskDeffer
    public boolean offer(Task<T, R> task, int i) {
        if (i == 0) {
            return this.defferQueueLast.offer(task);
        }
        if (i == 1) {
            return this.defferQueueNormal.offer(task);
        }
        return false;
    }

    @Override // com.taobao.android.job.core.TaskDeffer
    public Task<T, R> poll(int i) {
        if (i == 0) {
            return this.defferQueueLast.poll();
        }
        if (i == 1) {
            return this.defferQueueNormal.poll();
        }
        return null;
    }
}
