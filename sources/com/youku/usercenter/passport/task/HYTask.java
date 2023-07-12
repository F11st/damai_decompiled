package com.youku.usercenter.passport.task;

import android.content.Context;
import android.os.AsyncTask;
import com.youku.usercenter.passport.util.Logger;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class HYTask extends AsyncTask<String, Integer, String> {
    private Context mContext;

    public HYTask(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void start(String... strArr) {
        try {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, strArr);
        } catch (Exception e) {
            Logger.printStackTrace(e);
        }
    }
}
