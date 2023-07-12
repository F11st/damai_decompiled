package com.youku.middlewareservice.provider.task;

import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.TaskTracker;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CommonTask implements OneCommonTask {
    private OneCommonTask oneCommonTask;

    public CommonTask(OneCommonTask oneCommonTask) {
        this.oneCommonTask = oneCommonTask;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void cancel(boolean z) {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            oneCommonTask.cancel(z);
        }
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public long getAddedTime() {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            return oneCommonTask.getAddedTime();
        }
        return 0L;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public Object getData() {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            return oneCommonTask.getData();
        }
        return null;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public long getDelayTime() {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            return oneCommonTask.getDelayTime();
        }
        return 0L;
    }

    public com.alibaba.android.onescheduler.DelayType getDelayType() {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            return oneCommonTask.getDelayType();
        }
        return null;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public String getGroupName() {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            return oneCommonTask.getGroupName();
        }
        return null;
    }

    public long getInitialDelayTime() {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            return oneCommonTask.getInitialDelayTime();
        }
        return 0L;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public String getName() {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            return oneCommonTask.getName();
        }
        return null;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public boolean isCancelled() {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            return oneCommonTask.isCancelled();
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            oneCommonTask.run();
        }
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void setAddedTime(long j) {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            oneCommonTask.setAddedTime(j);
        }
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void setData(Object obj) {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            oneCommonTask.setData(obj);
        }
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void setTaskTracker(TaskTracker taskTracker) {
        OneCommonTask oneCommonTask = this.oneCommonTask;
        if (oneCommonTask != null) {
            oneCommonTask.setTaskTracker(taskTracker);
        }
    }
}
