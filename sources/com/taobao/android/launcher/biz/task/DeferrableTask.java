package com.taobao.android.launcher.biz.task;

import com.taobao.android.launcher.statistics.TaoTrace;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class DeferrableTask extends TaggedTask {
    private static final String CATEGORY = "defer";

    public DeferrableTask(String str) {
        super(str);
        shouldRunImmediately(true);
    }

    @Override // com.taobao.android.launcher.biz.task.TaggedTask, com.taobao.android.job.core.task.Task
    public Void execute() {
        TaoTrace.start(CATEGORY, getId());
        Void execute = super.execute();
        TaoTrace.end(CATEGORY, getId());
        return execute;
    }
}
