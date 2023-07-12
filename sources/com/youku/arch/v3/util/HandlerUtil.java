package com.youku.arch.v3.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class HandlerUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "HandlerUtil";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static abstract class WaitableRunnable<V> implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final int MSG_INVOKE = 2147483646;
        private static final int MSG_PEEK = Integer.MAX_VALUE;
        private Exception exception;
        private volatile boolean isDone;
        private volatile boolean isStarted;
        private Object lock = new Object();
        private V value;

        protected WaitableRunnable() {
        }

        /* JADX WARN: Removed duplicated region for block: B:78:0x01c3 A[Catch: all -> 0x01f5, TryCatch #2 {, blocks: (B:8:0x001c, B:10:0x0022, B:15:0x0031, B:18:0x0037, B:30:0x0090, B:32:0x0094, B:34:0x009c, B:37:0x00a2, B:39:0x00a8, B:40:0x00ac, B:42:0x00b2, B:48:0x0119, B:50:0x011d, B:52:0x0125, B:55:0x012b, B:58:0x0133, B:60:0x0139, B:76:0x01bd, B:78:0x01c3, B:79:0x01f3, B:21:0x0043, B:23:0x0049, B:25:0x0069, B:28:0x0087, B:46:0x00e7), top: B:87:0x001c }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void join(android.os.Handler r14) {
            /*
                Method dump skipped, instructions count: 504
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.util.HandlerUtil.WaitableRunnable.join(android.os.Handler):void");
        }

        public V invoke(Handler handler) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-382801799")) {
                return (V) ipChange.ipc$dispatch("-382801799", new Object[]{this, handler});
            }
            Message obtain = Message.obtain(handler, this);
            obtain.what = MSG_INVOKE;
            obtain.obj = this.lock;
            if (!handler.sendMessage(obtain)) {
                Log.e(HandlerUtil.TAG, "Handler.post() returned false and loop is" + handler.getLooper());
                return null;
            }
            join(handler);
            if (this.exception == null) {
                return this.value;
            }
            throw new RuntimeException(this.exception);
        }

        protected abstract V onRun();

        @Override // java.lang.Runnable
        public final void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1902209374")) {
                ipChange.ipc$dispatch("1902209374", new Object[]{this});
                return;
            }
            try {
                try {
                    this.isStarted = true;
                    this.value = onRun();
                    this.exception = null;
                    synchronized (this.lock) {
                        this.isDone = true;
                        this.lock.notifyAll();
                    }
                } catch (Exception e) {
                    this.value = null;
                    this.exception = e;
                    synchronized (this.lock) {
                        this.isDone = true;
                        this.lock.notifyAll();
                    }
                }
            } catch (Throwable th) {
                synchronized (this.lock) {
                    this.isDone = true;
                    this.lock.notifyAll();
                    throw th;
                }
            }
        }
    }

    private HandlerUtil() {
    }

    public static boolean checkThreadAccess(Handler handler) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2123926169") ? ((Boolean) ipChange.ipc$dispatch("-2123926169", new Object[]{handler})).booleanValue() : Looper.myLooper() == handler.getLooper();
    }

    public static void postAndWait(Handler handler, final Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2087874645")) {
            ipChange.ipc$dispatch("-2087874645", new Object[]{handler, runnable});
        } else if (checkThreadAccess(handler)) {
            try {
                runnable.run();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        } else {
            new WaitableRunnable<Void>() { // from class: com.youku.arch.v3.util.HandlerUtil.1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.youku.arch.v3.util.HandlerUtil.WaitableRunnable
                public Void onRun() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-489300307")) {
                        return (Void) ipChange2.ipc$dispatch("-489300307", new Object[]{this});
                    }
                    runnable.run();
                    return null;
                }
            }.invoke(handler);
        }
    }

    public static void verifyThreadAccess(Handler handler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7554966")) {
            ipChange.ipc$dispatch("-7554966", new Object[]{handler});
        } else {
            checkThreadAccess(handler);
        }
    }
}
