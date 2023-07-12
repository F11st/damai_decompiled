package de.greenrobot.event;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class AsyncPoster implements Runnable {
    private final EventBus eventBus;
    private final C8105d queue = new C8105d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncPoster(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void enqueue(C8108g c8108g, Object obj) {
        this.queue.a(C8104c.a(c8108g, obj));
        this.eventBus.c().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        C8104c b = this.queue.b();
        if (b != null) {
            this.eventBus.e(b);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
