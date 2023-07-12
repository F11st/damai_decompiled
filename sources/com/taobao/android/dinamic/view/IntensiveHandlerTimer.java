package com.taobao.android.dinamic.view;

import android.os.Handler;
import com.taobao.android.dinamic.view.HandlerTimer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IntensiveHandlerTimer extends HandlerTimer {
    public long originInterval;
    private long startTime;

    public IntensiveHandlerTimer(Runnable runnable) {
        super(runnable);
    }

    @Override // com.taobao.android.dinamic.view.HandlerTimer
    public void cancel() {
        super.cancel();
    }

    public long getInterval() {
        return this.interval;
    }

    @Override // com.taobao.android.dinamic.view.HandlerTimer
    public void pause() {
        if (this.status == HandlerTimer.TimerStatus.Paused) {
            return;
        }
        this.interval -= System.currentTimeMillis() - this.startTime;
        super.pause();
    }

    @Override // com.taobao.android.dinamic.view.HandlerTimer
    public void restart() {
        if (this.status == HandlerTimer.TimerStatus.Running) {
            return;
        }
        this.startTime = System.currentTimeMillis();
        if (this.interval < 0) {
            this.interval = this.originInterval / 2;
        }
        super.restart();
    }

    @Override // com.taobao.android.dinamic.view.HandlerTimer
    public void runOver() {
        this.interval = this.originInterval;
        this.startTime = System.currentTimeMillis();
    }

    @Override // com.taobao.android.dinamic.view.HandlerTimer
    public void start() {
        this.startTime = System.currentTimeMillis();
        super.start();
    }

    @Override // com.taobao.android.dinamic.view.HandlerTimer
    public void stop() {
        if (this.status == HandlerTimer.TimerStatus.Stopped) {
            return;
        }
        super.stop();
    }

    public void updateInterval(long j) {
        this.interval = j;
    }

    public IntensiveHandlerTimer(long j, Runnable runnable) {
        super(j, runnable);
        this.originInterval = j;
    }

    public void start(int i) {
        this.startTime = System.currentTimeMillis();
        long j = i;
        this.interval = j;
        super.start(j);
    }

    public IntensiveHandlerTimer(long j, Runnable runnable, Handler handler) {
        super(j, runnable, handler);
    }
}
