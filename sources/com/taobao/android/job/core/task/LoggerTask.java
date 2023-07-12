package com.taobao.android.job.core.task;

import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.helper.TimeHelpers;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class LoggerTask<T, R> extends DelegateTask<T, R> implements Serializable {
    private static final String TAG = LoggerTask.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoggerTask(Task<T, R> task) {
        super(task);
    }

    @Override // com.taobao.android.job.core.task.Task
    public R execute() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = TAG;
        Log.v(str, "Executing Node # %s", getId());
        R execute = getTargetTask().execute();
        Log.v(str, "Executed Node # %s, Execution Done with result=%s, cost=%d ms", getId(), execute, Long.valueOf(TimeHelpers.since(currentTimeMillis)));
        return execute;
    }
}
