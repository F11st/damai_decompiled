package com.youku.live.dago.widgetlib.interactive.gift.star.timer;

import android.os.SystemClock;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class SYTimerTask implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Condition condition;
    private long createTime;
    private ReentrantLock lock;
    private String name;
    private long offsetTimeMillis;
    private final Runnable r;
    private long step;
    private SYTimerStepListener stepListener;
    private Thread thread;
    private AtomicBoolean threadIntterupt;
    private long when;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface SYTimerStepListener {
        void onStepError(long j, long j2);

        void onStepNotify(long j, long j2);
    }

    protected SYTimerTask() {
        this(1L);
    }

    public final void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027380265")) {
            ipChange.ipc$dispatch("1027380265", new Object[]{this});
        } else if (this.thread == null) {
        } else {
            this.threadIntterupt.set(true);
            try {
                if (this.lock.isLocked()) {
                    this.condition.signal();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1384946746") ? (String) ipChange.ipc$dispatch("1384946746", new Object[]{this}) : this.name;
    }

    public final long getSurplus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2126956125") ? ((Long) ipChange.ipc$dispatch("-2126956125", new Object[]{this})).longValue() : this.when - SystemClock.elapsedRealtime();
    }

    public final long getWhen() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2048563701") ? ((Long) ipChange.ipc$dispatch("-2048563701", new Object[]{this})).longValue() : this.when;
    }

    public abstract void onTimeOver();

    @Override // java.lang.Runnable
    public abstract void run();

    public final void setOffsetTimeMillis(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384328763")) {
            ipChange.ipc$dispatch("-384328763", new Object[]{this, Long.valueOf(j)});
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.createTime = elapsedRealtime;
        this.offsetTimeMillis = j;
        this.when = elapsedRealtime + j;
    }

    protected SYTimerTask(long j) {
        this(j, String.valueOf(System.nanoTime()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SYTimerTask(long j, String str) {
        this(j, str, null, 0L);
    }

    protected SYTimerTask(long j, SYTimerStepListener sYTimerStepListener, long j2) {
        this(j, String.valueOf(System.nanoTime()), sYTimerStepListener, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SYTimerTask(long j, String str, SYTimerStepListener sYTimerStepListener, long j2) {
        this.threadIntterupt = new AtomicBoolean(false);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        Runnable runnable = new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange, "-764469521")) {
                    ipChange.ipc$dispatch("-764469521", new Object[]{this});
                    return;
                }
                while (!SYTimerTask.this.thread.isInterrupted() && SYTimerTask.this.getSurplus() > SYTimerTask.this.step && !SYTimerTask.this.threadIntterupt.get()) {
                    try {
                        SYTimerTask.this.lock.lock();
                        SYTimerTask.this.condition.await(SYTimerTask.this.step, TimeUnit.MILLISECONDS);
                        i++;
                        if (SYTimerTask.this.threadIntterupt.get()) {
                            SYTimerTask.this.stepListener.onStepError(SYTimerTask.this.step * i, SYTimerTask.this.offsetTimeMillis);
                            return;
                        } else {
                            SYTimerTask.this.stepListener.onStepNotify(SYTimerTask.this.step * i, SYTimerTask.this.offsetTimeMillis);
                            SYTimerTask.this.lock.unlock();
                        }
                    } catch (InterruptedException unused) {
                        SYTimerTask.this.stepListener.onStepError(SYTimerTask.this.step * i, SYTimerTask.this.offsetTimeMillis);
                        SYTimerTask.this.stepListener = null;
                        return;
                    } finally {
                    }
                }
                long surplus = SYTimerTask.this.getSurplus() - SYTimerTask.this.step;
                if (!SYTimerTask.this.thread.isInterrupted() && surplus > 0) {
                    try {
                        if (!SYTimerTask.this.threadIntterupt.get()) {
                            SYTimerTask.this.lock.lock();
                            SYTimerTask.this.condition.await(surplus, TimeUnit.MILLISECONDS);
                        }
                    } catch (InterruptedException unused2) {
                        SYTimerTask.this.stepListener.onStepError(SYTimerTask.this.offsetTimeMillis, SYTimerTask.this.offsetTimeMillis);
                        SYTimerTask.this.stepListener = null;
                        return;
                    } finally {
                    }
                }
                SYTimerTask.this.onTimeOver();
                SYTimerTask.this.stepListener = null;
            }
        };
        this.r = runnable;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.createTime = elapsedRealtime;
        this.offsetTimeMillis = j;
        this.when = elapsedRealtime + j;
        this.name = str;
        this.stepListener = sYTimerStepListener;
        this.step = j2;
        if (j2 <= 0 || sYTimerStepListener == null) {
            return;
        }
        this.threadIntterupt.set(false);
        Thread thread = new Thread(runnable);
        this.thread = thread;
        thread.setName("SYTimer-Step-Task");
        this.thread.start();
    }
}
