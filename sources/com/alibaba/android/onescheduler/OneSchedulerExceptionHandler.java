package com.alibaba.android.onescheduler;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface OneSchedulerExceptionHandler {
    void onThreadPoolFull(TaskType taskType, int i, List<String> list);
}
