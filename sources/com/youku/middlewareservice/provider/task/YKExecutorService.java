package com.youku.middlewareservice.provider.task;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.task.a;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tb.um1;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class YKExecutorService extends ThreadPoolExecutor {
    private static SharedPreferences sp;
    private String groupName;
    private int index;
    private boolean use;

    public YKExecutorService(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        this.use = true;
        this.index = 0;
        allowCoreThreadTimeOut(true);
        setRejectedExecutionHandler(new RejectedExecutionHandler(str) { // from class: com.youku.middlewareservice.provider.task.YKExecutorService.1
            private ExecutorService executorService;
            final /* synthetic */ String val$groupName;

            {
                this.val$groupName = str;
                this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory(str));
            }

            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(@NonNull Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                this.executorService.submit(runnable);
            }
        });
        this.groupName = str;
        if (AppInfoProviderProxy.getAppContext() != null) {
            SharedPreferences sharedPreferences = AppInfoProviderProxy.getAppContext().getSharedPreferences("OneSchedulerConfig", 0);
            sp = sharedPreferences;
            if (sharedPreferences != null) {
                this.use = sharedPreferences.getBoolean("use", true);
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        String sb;
        if (this.use) {
            if (um1.g().f(this.groupName) == null) {
                um1.g().a(this.groupName, 10);
            }
            a taskGroup = um1.g().h().setRunnable(runnable).setTaskGroup(this.groupName);
            if (runnable instanceof YKRunnable) {
                YKRunnable yKRunnable = (YKRunnable) runnable;
                sb = yKRunnable.getName();
                TaskType type = yKRunnable.getType();
                if (type != null) {
                    taskGroup.setTaskType(com.alibaba.android.onescheduler.TaskType.fromValue(type.getValue()));
                }
                Priority priority = yKRunnable.getPriority();
                if (priority != null) {
                    taskGroup.setPriority(com.alibaba.android.onescheduler.Priority.fromValue(priority.getValue()));
                }
                DelayType delayType = yKRunnable.getDelayType();
                if (delayType != null) {
                    taskGroup.setIsFixDelayed(com.alibaba.android.onescheduler.DelayType.fromValue(delayType.getValue()));
                    taskGroup.setDelayTime(yKRunnable.getDelayTime());
                    taskGroup.setInitialDelayTime(yKRunnable.getInitialDelayTime());
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.groupName);
                sb2.append(" task ");
                int i = this.index;
                this.index = i + 1;
                sb2.append(i);
                sb = sb2.toString();
            }
            taskGroup.setTaskName(sb).buildCommonTask().run();
            return;
        }
        super.execute(runnable);
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void pauseSelf() {
        if (this.use) {
            um1.g().i(this.groupName);
        }
    }

    public void resumeSelf() {
        if (this.use) {
            um1.g().l(this.groupName);
        }
    }
}
