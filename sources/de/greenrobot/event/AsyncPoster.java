package de.greenrobot.event;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class AsyncPoster implements Runnable {
    private final EventBus eventBus;
    private final d queue = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncPoster(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void enqueue(g gVar, Object obj) {
        this.queue.a(c.a(gVar, obj));
        this.eventBus.c().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        c b = this.queue.b();
        if (b != null) {
            this.eventBus.e(b);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
