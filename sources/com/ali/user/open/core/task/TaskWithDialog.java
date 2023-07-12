package com.ali.user.open.core.task;

import android.app.Activity;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class TaskWithDialog<Params, Progress, Result> extends AbsAsyncTask<Params, Progress, Result> {
    protected Activity activity;

    public TaskWithDialog(Activity activity) {
        this.activity = activity;
    }

    @Override // com.ali.user.open.core.task.AbsAsyncTask
    protected void doFinally() {
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
    }
}
