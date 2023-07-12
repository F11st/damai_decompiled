package com.taobao.android.job.core.task;

import androidx.annotation.NonNull;
import com.taobao.android.job.core.helper.TimeHelpers;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ExecutionSummary {
    public final long endTime;
    public final int executed;
    public boolean isMainThread = false;
    public final long startTime;
    public final int total;

    private ExecutionSummary(int i, int i2, long j, long j2) {
        this.total = i;
        this.executed = i2;
        this.startTime = j;
        this.endTime = j2;
    }

    public static ExecutionSummary create(int i, int i2, long j, long j2) {
        return new ExecutionSummary(i, i2, j, j2);
    }

    @NonNull
    public String toString() {
        return "ExecutionSummary{startTime=" + this.startTime + ", endTime=" + this.endTime + ", duration=" + TimeHelpers.between(this.startTime, this.endTime) + ", total=" + this.total + ", executed=" + this.executed + ", isMainThread=" + (this.isMainThread ? 1 : 0) + '}';
    }

    public static ExecutionSummary create(long j, long j2) {
        return new ExecutionSummary(1, 1, j, j2);
    }
}
