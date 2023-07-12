package com.taobao.weex.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.tools.LogDetail;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXThread extends HandlerThread {
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SafeCallback implements Handler.Callback {
        static final String TAG = "SafeCallback";
        final Handler.Callback mCallback;

        SafeCallback(Handler.Callback callback) {
            this.mCallback = callback;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            boolean isApkDebugable;
            try {
                Handler.Callback callback = this.mCallback;
                if (callback != null) {
                    return callback.handleMessage(message);
                }
                return false;
            } finally {
                if (!isApkDebugable) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SafeRunnable implements Runnable {
        static final String TAG = "SafeRunnable";
        private WeakReference<WXSDKInstance> mInstance;
        final Runnable mTask;
        private LogDetail mTimelineLog;

        SafeRunnable(Runnable runnable) {
            this(runnable, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<WXSDKInstance> weakReference;
            WXSDKInstance wXSDKInstance;
            try {
                if (this.mTask != null) {
                    LogDetail logDetail = this.mTimelineLog;
                    if (logDetail != null) {
                        logDetail.taskStart();
                    }
                    this.mTask.run();
                    LogDetail logDetail2 = this.mTimelineLog;
                    if (logDetail2 != null) {
                        logDetail2.taskEnd();
                    }
                }
            } catch (Throwable th) {
                if (!WXEnvironment.isApkDebugable()) {
                    WXLogUtils.w(TAG, th);
                } else {
                    WXLogUtils.e(TAG, "SafeRunnable run throw expection:" + th.getMessage());
                    throw th;
                }
            }
            if (this.mTimelineLog == null || (weakReference = this.mInstance) == null || (wXSDKInstance = weakReference.get()) == null) {
                return;
            }
            wXSDKInstance.mTimeCalculator.addLog(this.mTimelineLog);
        }

        SafeRunnable(Runnable runnable, String str) {
            this(runnable, null, str);
        }

        SafeRunnable(Runnable runnable, WXSDKInstance wXSDKInstance, String str) {
            this.mTimelineLog = null;
            this.mTask = runnable;
            if (str != null) {
                LogDetail logDetail = new LogDetail();
                this.mTimelineLog = logDetail;
                logDetail.info.platform = "Android";
                logDetail.name(str);
                this.mInstance = new WeakReference<>(wXSDKInstance);
            }
        }
    }

    public WXThread(String str) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper());
    }

    public static Runnable secure(Runnable runnable) {
        return secure(runnable, null, null);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public boolean isWXThreadAlive() {
        return (this.mHandler == null || getLooper() == null || !isAlive()) ? false : true;
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        return super.quit();
    }

    public static Runnable secure(Runnable runnable, WXSDKInstance wXSDKInstance, String str) {
        return (runnable == null || (runnable instanceof SafeRunnable)) ? runnable : new SafeRunnable(runnable, wXSDKInstance, str);
    }

    public WXThread(String str, Handler.Callback callback) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper(), secure(callback));
    }

    public static Handler.Callback secure(Handler.Callback callback) {
        return (callback == null || (callback instanceof SafeCallback)) ? callback : new SafeCallback(callback);
    }

    public WXThread(String str, int i, Handler.Callback callback) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper(), secure(callback));
    }

    public WXThread(String str, int i) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper());
    }
}
