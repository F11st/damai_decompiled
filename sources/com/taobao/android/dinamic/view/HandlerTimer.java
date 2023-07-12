package com.taobao.android.dinamic.view;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class HandlerTimer implements Runnable {
    private Handler handler;
    protected long interval;
    protected TimerStatus status;
    private Runnable task;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum TimerStatus {
        Waiting(0, "待启动"),
        Running(1, "运行中"),
        Paused(-1, "暂停"),
        Stopped(-2, "停止");
        
        private int code;
        private String desc;

        TimerStatus(int i, String str) {
            this.code = i;
            this.desc = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setDesc(String str) {
            this.desc = str;
        }
    }

    public HandlerTimer(Runnable runnable) {
        this(1000L, runnable);
    }

    public void cancel() {
        this.status = TimerStatus.Stopped;
        this.handler.removeCallbacks(this);
    }

    public void pause() {
        this.status = TimerStatus.Paused;
        this.handler.removeCallbacks(this);
    }

    public void restart() {
        this.handler.removeCallbacks(this);
        this.status = TimerStatus.Running;
        this.handler.postDelayed(this, this.interval);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TimerStatus timerStatus = this.status;
        if (timerStatus == TimerStatus.Waiting || timerStatus == TimerStatus.Paused || timerStatus == TimerStatus.Stopped) {
            return;
        }
        this.task.run();
        runOver();
        this.handler.removeCallbacks(this);
        this.handler.postDelayed(this, this.interval);
    }

    public void runOver() {
    }

    public void start() {
        this.handler.removeCallbacks(this);
        this.status = TimerStatus.Running;
        this.handler.postDelayed(this, this.interval);
    }

    public void stop() {
        this.status = TimerStatus.Stopped;
        this.handler.removeCallbacksAndMessages(null);
    }

    public HandlerTimer(long j, Runnable runnable) {
        this(j, runnable, new Handler(Looper.getMainLooper()));
    }

    public HandlerTimer(long j, Runnable runnable, Handler handler) {
        this.interval = j;
        this.task = runnable;
        this.handler = handler;
        this.status = TimerStatus.Waiting;
    }

    public void start(long j) {
        this.handler.removeCallbacks(this);
        this.status = TimerStatus.Running;
        this.handler.postDelayed(this, j);
    }
}
