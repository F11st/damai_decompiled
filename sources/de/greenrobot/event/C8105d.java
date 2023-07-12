package de.greenrobot.event;

/* compiled from: Taobao */
/* renamed from: de.greenrobot.event.d */
/* loaded from: classes3.dex */
final class C8105d {
    private C8104c a;
    private C8104c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(C8104c c8104c) {
        try {
            if (c8104c != null) {
                C8104c c8104c2 = this.b;
                if (c8104c2 != null) {
                    c8104c2.c = c8104c;
                    this.b = c8104c;
                } else if (this.a == null) {
                    this.b = c8104c;
                    this.a = c8104c;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized C8104c b() {
        C8104c c8104c;
        c8104c = this.a;
        if (c8104c != null) {
            C8104c c8104c2 = c8104c.c;
            this.a = c8104c2;
            if (c8104c2 == null) {
                this.b = null;
            }
        }
        return c8104c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized C8104c c(int i) throws InterruptedException {
        if (this.a == null) {
            wait(i);
        }
        return b();
    }
}
