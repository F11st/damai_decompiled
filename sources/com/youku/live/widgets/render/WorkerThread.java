package com.youku.live.widgets.render;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.WidgetInstance;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class WorkerThread extends HandlerThread {
    private static transient /* synthetic */ IpChange $ipChange;
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class SafeCallback implements Handler.Callback {
        static final String TAG = "SafeCallback";
        final Handler.Callback mCallback;

        SafeCallback(Handler.Callback callback) {
            this.mCallback = callback;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                Handler.Callback callback = this.mCallback;
                if (callback != null) {
                    return callback.handleMessage(message);
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class SafeRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        static final String TAG = "SafeRunnable";
        private WeakReference<WidgetInstance> mInstance;
        final Runnable mTask;

        public SafeRunnable(Runnable runnable) {
            this(runnable, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1429730982")) {
                ipChange.ipc$dispatch("1429730982", new Object[]{this});
                return;
            }
            try {
                Runnable runnable = this.mTask;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public SafeRunnable(Runnable runnable, String str) {
            this(runnable, null, str);
        }

        public SafeRunnable(Runnable runnable, WidgetInstance widgetInstance, String str) {
            this.mTask = runnable;
            if (str != null) {
                this.mInstance = new WeakReference<>(widgetInstance);
            }
        }
    }

    public WorkerThread(String str) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper());
    }

    public static boolean isInMainThread() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-547923623") ? ((Boolean) ipChange.ipc$dispatch("-547923623", new Object[0])).booleanValue() : Looper.getMainLooper() == Looper.myLooper();
    }

    public static Runnable secure(Runnable runnable) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "74010662") ? (Runnable) ipChange.ipc$dispatch("74010662", new Object[]{runnable}) : secure(runnable, null, null);
    }

    public Handler getHandler() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-837765773") ? (Handler) ipChange.ipc$dispatch("-837765773", new Object[]{this}) : this.mHandler;
    }

    public boolean isWKThreadAlive() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1979462270") ? ((Boolean) ipChange.ipc$dispatch("-1979462270", new Object[]{this})).booleanValue() : (this.mHandler == null || getLooper() == null || !isAlive()) ? false : true;
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597948196")) {
            return ((Boolean) ipChange.ipc$dispatch("-1597948196", new Object[]{this})).booleanValue();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        return super.quit();
    }

    public static Runnable secure(Runnable runnable, WidgetInstance widgetInstance, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1711416191") ? (Runnable) ipChange.ipc$dispatch("1711416191", new Object[]{runnable, widgetInstance, str}) : (runnable == null || (runnable instanceof SafeRunnable)) ? runnable : new SafeRunnable(runnable, widgetInstance, str);
    }

    public WorkerThread(String str, Handler.Callback callback) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper(), secure(callback));
    }

    public static Handler.Callback secure(Handler.Callback callback) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1080555054") ? (Handler.Callback) ipChange.ipc$dispatch("1080555054", new Object[]{callback}) : (callback == null || (callback instanceof SafeCallback)) ? callback : new SafeCallback(callback);
    }

    public WorkerThread(String str, int i, Handler.Callback callback) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper(), secure(callback));
    }

    public WorkerThread(String str, int i) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper());
    }
}
