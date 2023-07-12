package com.taobao.android.launcher.biz.task;

import com.taobao.android.job.core.task.ExecutionResults;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class OneTimeTask extends TaggedTask {
    private final AtomicBoolean hasExecuted;

    public OneTimeTask(String str) {
        super(str);
        this.hasExecuted = new AtomicBoolean(false);
    }

    @Override // com.taobao.android.job.core.task.Task
    public boolean intercept(ExecutionResults<String, Void> executionResults) {
        boolean intercept = super.intercept(executionResults);
        return intercept ? !this.hasExecuted.get() : intercept;
    }

    @Override // com.taobao.android.launcher.biz.task.TaggedTask, com.taobao.android.job.core.task.Task
    public Void execute() {
        if (this.hasExecuted.compareAndSet(false, true)) {
            return super.execute();
        }
        return null;
    }
}
