package org.android.netutil;

import androidx.annotation.Keep;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class PingTask {
    private static int PING_DEFAULT_TIME = 5;
    private int interval;
    private int maxtime;
    private int payload;
    private String pingIPStr;
    private int ttl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes2.dex */
    public class PingFuture extends AsyncTask implements Future<b> {
        private b _inner_response;
        private long native_ptr;

        /* JADX INFO: Access modifiers changed from: private */
        public PingFuture start(String str, int i, int i2, int i3, int i4, PingTaskWatcher pingTaskWatcher) {
            b bVar = new b(i2);
            this._inner_response = bVar;
            bVar.g(pingTaskWatcher);
            this.native_ptr = PingTask.createPingTask(this, str, i, i2, i3, i4);
            return this;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        protected void finalize() throws Throwable {
            super.finalize();
            long j = this.native_ptr;
            if (j != 0) {
                PingTask.releasePingTask(j);
            }
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.done;
        }

        protected void onPingEntry(int i, int i2, double d) {
            this._inner_response.a(i, i2, d);
        }

        protected void onTaskFinish(String str, int i) {
            this._inner_response.j(str);
            this._inner_response.h(i);
        }

        protected void onTimxceed(String str) {
            this._inner_response.i(str);
        }

        private PingFuture() {
            this.native_ptr = 0L;
            this._inner_response = null;
        }

        @Override // java.util.concurrent.Future
        public b get() throws InterruptedException, ExecutionException {
            try {
                return get(0L, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // java.util.concurrent.Future
        public b get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            synchronized (this) {
                if (!this.done) {
                    long j2 = this.native_ptr;
                    if (j2 == 0) {
                        return null;
                    }
                    if (PingTask.waitPingTask(j2, timeUnit.toSeconds(j))) {
                        PingTask.releasePingTask(this.native_ptr);
                        this.native_ptr = 0L;
                    } else {
                        throw new TimeoutException();
                    }
                }
                return this._inner_response;
            }
        }
    }

    public PingTask(String str, int i, int i2, int i3, int i4) {
        this.pingIPStr = null;
        this.pingIPStr = str;
        this.interval = i;
        this.maxtime = i2 == 0 ? PING_DEFAULT_TIME : i2;
        this.payload = i3;
        this.ttl = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long createPingTask(PingFuture pingFuture, String str, int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void releasePingTask(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean waitPingTask(long j, long j2);

    public Future<b> launch() {
        return launchWith(null);
    }

    public Future<b> launchWith(PingTaskWatcher pingTaskWatcher) {
        return new PingFuture().start(this.pingIPStr, this.interval, this.maxtime, this.payload, this.ttl, pingTaskWatcher);
    }

    public PingTask(String str) {
        this(str, 0, 0, 0, 0);
    }
}
