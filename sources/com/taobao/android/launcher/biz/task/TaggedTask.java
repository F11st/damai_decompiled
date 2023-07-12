package com.taobao.android.launcher.biz.task;

import com.taobao.android.job.core.task.Task;
import com.taobao.android.launcher.common.LauncherParam;
import com.taobao.android.launcher.common.LauncherRuntime;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class TaggedTask extends Task<String, Void> implements TaggedRunnable {
    private TaggedTask() {
    }

    protected boolean needParam() {
        return true;
    }

    public TaggedTask(String str) {
        setId(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.taobao.android.job.core.task.Task
    public Void execute() {
        if (needParam()) {
            run(LauncherRuntime.sApplication, LauncherParam.getParams(getId()));
        } else {
            run(LauncherRuntime.sApplication, null);
        }
        return null;
    }
}
