package org.android.spdy;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class ProtectedPointer {
    private AtomicLong a = new AtomicLong(1);
    private Object b;
    protected ProtectedPointerOnClose c;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    interface ProtectedPointerOnClose {
        void close(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtectedPointer(Object obj) {
        this.b = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        long j;
        do {
            j = this.a.get();
            if (j == 3) {
                return false;
            }
        } while (!this.a.compareAndSet(j, 16 + j));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.a.addAndGet(-16L);
        if (this.a.compareAndSet(2L, 3L)) {
            ProtectedPointerOnClose protectedPointerOnClose = this.c;
            if (protectedPointerOnClose != null) {
                protectedPointerOnClose.close(this.b);
            }
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.a.incrementAndGet();
        if (this.a.compareAndSet(2L, 3L)) {
            ProtectedPointerOnClose protectedPointerOnClose = this.c;
            if (protectedPointerOnClose != null) {
                protectedPointerOnClose.close(this.b);
            }
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ProtectedPointerOnClose protectedPointerOnClose) {
        this.c = protectedPointerOnClose;
    }
}
