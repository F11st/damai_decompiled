package com.taobao.android.task;

import android.os.AsyncTask;
import com.taobao.android.compat.ActionBarActivityCompat;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class SafeAsyncTask<Params, Result> extends AsyncTask<Params, Void, Result> {
    private final ActionBarActivityCompat mActivity;

    public SafeAsyncTask(ActionBarActivityCompat actionBarActivityCompat) {
        this.mActivity = actionBarActivityCompat;
    }

    public static void execute(Runnable runnable) {
        Coordinator.getDefaultAsyncTaskExecutor().execute(runnable);
    }

    public static final void init() {
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Result result) {
        if (this.mActivity.isFinishing() || this.mActivity.isDestroyed()) {
            return;
        }
        onResult(result);
    }

    protected abstract void onResult(Result result);
}
