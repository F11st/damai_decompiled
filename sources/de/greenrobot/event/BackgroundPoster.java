package de.greenrobot.event;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class BackgroundPoster implements Runnable {
    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final C8105d queue = new C8105d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundPoster(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void enqueue(C8108g c8108g, Object obj) {
        C8104c a = C8104c.a(c8108g, obj);
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
                C8104c c = this.queue.c(1000);
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
