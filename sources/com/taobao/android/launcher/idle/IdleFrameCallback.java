package com.taobao.android.launcher.idle;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import com.taobao.android.launcher.device.LowDevice;
import com.taobao.application.common.b;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
@TargetApi(16)
/* loaded from: classes12.dex */
class IdleFrameCallback implements Handler.Callback, Choreographer.FrameCallback {
    private static final int DELAY_IDLE_MIN_MILLIS = 2000;
    private static final int DELAY_IDLE_TIMEOUT = 20000;
    private static final int DELAY_IDLE_TIMEOUT_COLD_START = 4000;
    private static final int DELAY_IDLE_TIMEOUT_FIRST_INSTALL = 10000;
    private static final int DELAY_IDLE_TIMEOUT_LOW_DEVICE_COLD_START = 8000;
    private static final long FRAME_INTERVAL_NANOS = 16666666;
    private static final int MSG_IDLE = 100;
    private static final int MSG_IDLE_TIMEOUT = 101;
    private static final int SKIPPED_FRAME_WARNING_LIMIT = 10;
    private static final String TAG = "IdleFrameCallback";
    private long firstFrameTimeNanos;
    private final Runnable idleTask;
    private volatile boolean idleTaskExecuted = false;
    private long lastFrameTimeNanos;
    private final Handler smoothHandler;
    private final HandlerThread smoothThread;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdleFrameCallback(long j, @NonNull Runnable runnable) {
        boolean z = false;
        this.lastFrameTimeNanos = j;
        this.firstFrameTimeNanos = j;
        HandlerThread handlerThread = new HandlerThread("altriax-smooth-handler");
        this.smoothThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.smoothHandler = handler;
        boolean z2 = b.d().getBoolean("isFullNewInstall", false);
        Object obj = LowDevice.identify().first;
        if (obj != null && ((Boolean) obj).booleanValue()) {
            z = true;
        }
        long j2 = z2 ? 10000L : z ? DanmakuFactory.DEFAULT_DANMAKU_DURATION : DanmakuFactory.MIN_DANMAKU_DURATION;
        handler.sendEmptyMessageDelayed(101, j2);
        Log.e(TAG, "idle check default timeout " + j2 + "ms");
        this.idleTask = runnable;
    }

    private boolean isSmoothCheckTimeout(long j) {
        return TimeUnit.NANOSECONDS.toMillis(j - this.firstFrameTimeNanos) >= 20000;
    }

    private void quitSmoothCheckThread() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.smoothThread.quitSafely();
        } else {
            this.smoothThread.quit();
        }
    }

    private void runIdleTask() {
        if (this.idleTaskExecuted) {
            return;
        }
        this.idleTask.run();
        this.idleTaskExecuted = true;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.idleTaskExecuted) {
            return;
        }
        if (this.lastFrameTimeNanos == 0) {
            this.lastFrameTimeNanos = j;
            this.firstFrameTimeNanos = j;
        }
        if (isSmoothCheckTimeout(j)) {
            Log.e(TAG, "triggered idle final timeout");
            this.smoothHandler.sendEmptyMessage(101);
            return;
        }
        long j2 = j - this.lastFrameTimeNanos;
        if (j2 >= FRAME_INTERVAL_NANOS) {
            long j3 = j2 / FRAME_INTERVAL_NANOS;
            if (j3 > 10) {
                this.smoothHandler.removeMessages(101);
                this.smoothHandler.removeMessages(100);
                this.smoothHandler.sendEmptyMessageDelayed(100, Math.max(j3 * 16, 2000L));
            }
        }
        this.lastFrameTimeNanos = j;
        if (this.idleTaskExecuted) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 100) {
            Log.e(TAG, "idle reached");
            runIdleTask();
            quitSmoothCheckThread();
            return true;
        } else if (i == 101) {
            Log.e(TAG, "idle timeout");
            runIdleTask();
            quitSmoothCheckThread();
            return true;
        } else {
            return false;
        }
    }
}
