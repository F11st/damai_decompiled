package android.taobao.windvane.thread;

import android.taobao.windvane.util.TaoLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVFixedThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static ExecutorService SingleExecutor = null;
    public static int bufferSize = 4096;
    private static WVFixedThreadPool threadManager;
    private BufferWrapper tempBuffer = null;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class BufferWrapper {
        private boolean isFree = false;
        public byte[] tempBuffer;

        BufferWrapper() {
            this.tempBuffer = null;
            this.tempBuffer = new byte[WVFixedThreadPool.bufferSize];
        }

        public boolean isFree() {
            return this.isFree;
        }

        public void setIsFree(boolean z) {
            this.isFree = z;
        }
    }

    public static WVFixedThreadPool getInstance() {
        if (threadManager == null) {
            threadManager = new WVFixedThreadPool();
        }
        return threadManager;
    }

    public void execute(Runnable runnable) {
        if (SingleExecutor == null) {
            SingleExecutor = Executors.newFixedThreadPool(1);
        }
        if (runnable == null) {
            TaoLog.w("WVThreadPool", "executeSingle is null.");
        } else {
            SingleExecutor.execute(runnable);
        }
    }

    public BufferWrapper getTempBuffer() {
        if (this.tempBuffer == null) {
            this.tempBuffer = new BufferWrapper();
        }
        return this.tempBuffer;
    }

    public void reSetTempBuffer() {
        BufferWrapper bufferWrapper = this.tempBuffer;
        if (bufferWrapper != null || bufferWrapper.isFree) {
            BufferWrapper bufferWrapper2 = this.tempBuffer;
            bufferWrapper2.tempBuffer = null;
            bufferWrapper2.isFree = false;
            this.tempBuffer = null;
        }
    }
}
