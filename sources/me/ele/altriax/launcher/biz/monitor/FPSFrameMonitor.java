package me.ele.altriax.launcher.biz.monitor;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.Choreographer;
import com.taobao.android.launcher.statistics.Startups;

/* compiled from: Taobao */
@TargetApi(16)
@Deprecated
/* loaded from: classes11.dex */
public class FPSFrameMonitor implements Choreographer.FrameCallback {
    private static final long FRAME_INTERVAL_NANOS = 16666666;
    private static final int SKIPPED_FRAME_WARNING_LIMIT = 10;
    private static final String TAG = "TaobaoFPS";
    private long lastFrameTimeNanos;

    public FPSFrameMonitor(long j) {
        this.lastFrameTimeNanos = j;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.lastFrameTimeNanos == 0) {
            this.lastFrameTimeNanos = j;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = j - this.lastFrameTimeNanos;
        if (j2 >= FRAME_INTERVAL_NANOS) {
            long j3 = j2 / FRAME_INTERVAL_NANOS;
            if (j3 > 10) {
                Log.e(TAG, "Skipped " + j3 + " frames!  Taobao may be doing too much work on its main thread.");
                Startups.addJank((int) j3, currentTimeMillis);
            }
        }
        this.lastFrameTimeNanos = j;
        Choreographer.getInstance().postFrameCallback(this);
    }
}
