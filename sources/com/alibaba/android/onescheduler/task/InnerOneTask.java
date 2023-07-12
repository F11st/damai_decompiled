package com.alibaba.android.onescheduler.task;

import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.CallableCallback;
import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.TaskTracker;
import com.alibaba.android.onescheduler.TaskType;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface InnerOneTask extends OneCommonTask {
    CallableCallback getCallback();

    Executor getExecutor();

    @Nullable
    FutureTask getFutureTask();

    Object getInnerData();

    Priority getPriority();

    long getPrioritySequence();

    TaskTracker getTaskTracker();

    TaskType getTaskType();

    boolean isRunningState();

    void setGroupPriority(Priority priority);

    void setInnerData(Object obj);

    void setPrioritySequence(long j);

    void setRunningState(boolean z);
}
