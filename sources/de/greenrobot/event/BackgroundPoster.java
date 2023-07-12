package de.greenrobot.event;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class BackgroundPoster implements Runnable {
    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final d queue = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundPoster(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void enqueue(g gVar, Object obj) {
        c a = c.a(gVar, obj);
        synchronized (this) {
            this.queue.a(a);
            if (!this.executorRunning) {
                this.executorRunning = true;
                this.eventBus.c().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                c c = this.queue.c(1000);
                if (c == null) {
                    synchronized (this) {
                        c = this.queue.b();
                        if (c == null) {
                            return;
                        }
                    }
                }
                this.eventBus.e(c);
            } catch (InterruptedException e) {
                Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.executorRunning = false;
            }
        }
    }
}
