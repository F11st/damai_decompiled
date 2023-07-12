package com.ali.user.open.core.task;

import android.os.AsyncTask;
import com.ali.user.open.core.trace.SDKLogger;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class AbsAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private static final String TAG = "kernel";

    protected abstract Result asyncExecute(Params... paramsArr);

    protected abstract void doFinally();

    @Override // android.os.AsyncTask
    protected Result doInBackground(Params... paramsArr) {
        try {
            return asyncExecute(paramsArr);
        } catch (Throwable th) {
            try {
                SDKLogger.e("kernel", th.getMessage(), th);
                doWhenException(th);
                doFinally();
                return null;
            } finally {
                doFinally();
            }
        }
    }

    protected abstract void doWhenException(Throwable th);
}
