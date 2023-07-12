package com.youku.alixplayer.opensdk.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AsyncTasker {
    private static AsyncTasker sAsyncTasker;
    private HandlerThread mHandleThread;
    private Handler mHandler;

    private AsyncTasker() {
        HandlerThread handlerThread = new HandlerThread("AsyncTasker-playerservice");
        this.mHandleThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandleThread.getLooper());
    }

    public static AsyncTasker getInstance() {
        if (sAsyncTasker == null) {
            synchronized (AsyncTasker.class) {
                if (sAsyncTasker == null) {
                    sAsyncTasker = new AsyncTasker();
                }
            }
        }
        return sAsyncTasker;
    }

    public void asyncCall(Runnable runnable) {
        Handler handler;
        if (runnable == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(runnable);
    }

    public void asyncCall(Runnable runnable, long j) {
        Handler handler;
        if (runnable == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.postDelayed(runnable, j);
    }
}
