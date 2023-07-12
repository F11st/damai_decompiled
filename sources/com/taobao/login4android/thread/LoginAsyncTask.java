package com.taobao.login4android.thread;

import android.os.AsyncTask;
import com.taobao.login4android.log.LoginTLogAdapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class LoginAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static final String TAG = "login.LoginAsyncTask";

    public void doFinally() {
    }

    @Override // android.os.AsyncTask
    protected Result doInBackground(Params... paramsArr) {
        try {
            return excuteTask(paramsArr);
        } catch (Throwable th) {
            try {
                handleException(th);
                doFinally();
                return null;
            } finally {
                doFinally();
            }
        }
    }

    public abstract Result excuteTask(Params... paramsArr) throws Exception;

    public void handleException(Throwable th) {
        th.printStackTrace();
        LoginTLogAdapter.w(TAG, "LoginAsyncTask excute failed", th);
    }
}
