package com.alibaba.android.onescheduler;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface OneCommonTask extends Runnable {
    void cancel(boolean z);

    long getAddedTime();

    Object getData();

    long getDelayTime();

    String getGroupName();

    String getName();

    boolean isCancelled();

    void setAddedTime(long j);

    void setData(Object obj);

    void setTaskTracker(TaskTracker taskTracker);
}
