package com.youku.live.livesdk.widgets.container;

import android.os.Handler;
import android.os.HandlerThread;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AsyncTasker {
    private static transient /* synthetic */ IpChange $ipChange;
    private static AsyncTasker sAsyncTasker;
    private HandlerThread mHandleThread;
    private Handler mHandler;

    private AsyncTasker() {
        HandlerThread handlerThread = new HandlerThread("AsyncTasker");
        this.mHandleThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandleThread.getLooper());
    }

    public static AsyncTasker getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342116517")) {
            return (AsyncTasker) ipChange.ipc$dispatch("-342116517", new Object[0]);
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2063970473")) {
            ipChange.ipc$dispatch("2063970473", new Object[]{this, runnable});
        } else if (runnable == null || (handler = this.mHandler) == null) {
        } else {
            handler.post(runnable);
        }
    }
}
