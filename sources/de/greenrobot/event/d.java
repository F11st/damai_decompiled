package de.greenrobot.event;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class d {
    private c a;
    private c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(c cVar) {
        try {
            if (cVar != null) {
                c cVar2 = this.b;
                if (cVar2 != null) {
                    cVar2.c = cVar;
                    this.b = cVar;
                } else if (this.a == null) {
                    this.b = cVar;
                    this.a = cVar;
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
    public synchronized c b() {
        c cVar;
        cVar = this.a;
        if (cVar != null) {
            c cVar2 = cVar.c;
            this.a = cVar2;
            if (cVar2 == null) {
                this.b = null;
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized c c(int i) throws InterruptedException {
        if (this.a == null) {
            wait(i);
        }
        return b();
    }
}
