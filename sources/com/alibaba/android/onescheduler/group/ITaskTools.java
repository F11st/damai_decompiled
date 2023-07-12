package com.alibaba.android.onescheduler.group;

import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.TaskType;
import java.util.List;
import java.util.concurrent.FutureTask;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface ITaskTools {
    @Nullable
    OneCommonTask convert(FutureTask futureTask);

    @Nullable
    List<String> getTaskNames(TaskType taskType);
}
