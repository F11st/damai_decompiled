package com.youku.android.player;

import android.util.Log;
import com.youku.android.player.OprHwPlayer;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OprFpsCallback implements OprHwPlayer.FrameCallback {
    private static final boolean CHECK_SLEEP_TIME = false;
    private static final long ONE_MILLION = 1000000;
    private static final String TAG = "OPR_v2_OprFpsCallback";
    private long mFixedFrameDurationUsec;
    private boolean mLoopReset;
    private long mPrevMonoUsec;
    private long mPrevPresentUsec;

    @Override // com.youku.android.player.OprHwPlayer.FrameCallback
    public void loopReset() {
        this.mLoopReset = true;
    }

    @Override // com.youku.android.player.OprHwPlayer.FrameCallback
    public void postRender() {
    }

    @Override // com.youku.android.player.OprHwPlayer.FrameCallback
    public void preRender(long j) {
        long j2 = 0;
        if (this.mPrevMonoUsec == 0) {
            this.mPrevMonoUsec = System.nanoTime() / 1000;
        } else {
            if (this.mLoopReset) {
                this.mPrevPresentUsec = j - 33333;
                this.mLoopReset = false;
            }
            long j3 = this.mFixedFrameDurationUsec;
            if (j3 == 0) {
                j3 = j - this.mPrevPresentUsec;
            }
            int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
            if (i < 0) {
                Log.w(TAG, "Weird, video times went backward");
            } else {
                if (i == 0) {
                    Log.i(TAG, "Warning: current frame and previous frame had same timestamp");
                } else if (j3 > 10000000) {
                    Log.i(TAG, "Inter-frame pause was " + (j3 / ONE_MILLION) + "sec, capping at 5 sec");
                    j2 = 5000000;
                }
                j2 = j3;
            }
            long j4 = this.mPrevMonoUsec + j2;
            while (true) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime >= j4 - 100) {
                    break;
                }
                long j5 = j4 - nanoTime;
                if (j5 > 500000) {
                    j5 = 500000;
                }
                try {
                    Thread.sleep(j5 / 1000, ((int) (j5 % 1000)) * 1000);
                } catch (InterruptedException unused) {
                }
            }
            this.mPrevMonoUsec += j2;
            j = this.mPrevPresentUsec + j2;
        }
        this.mPrevPresentUsec = j;
    }

    public void setFixedPlaybackRate(int i) {
        this.mFixedFrameDurationUsec = ONE_MILLION / i;
    }
}
