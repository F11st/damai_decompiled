package com.alibaba.android.onescheduler.group;

import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.task.InnerOneTask;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface IGroup {
    void addTask(InnerOneTask innerOneTask);

    void destroy();

    int getConcurrents();

    void pause();

    void removeCanceledTask(InnerOneTask innerOneTask);

    void removeFinishedTask(InnerOneTask innerOneTask);

    void resume();

    void setConcurrents(int i);

    void setPriority(Priority priority);
}
