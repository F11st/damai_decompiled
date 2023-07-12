package com.squareup.okhttp.internal.spdy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class Ping {
    private final CountDownLatch latch = new CountDownLatch(1);
    private long sent = -1;
    private long received = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel() {
        if (this.received == -1) {
            long j = this.sent;
            if (j != -1) {
                this.received = j - 1;
                this.latch.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receive() {
        if (this.received == -1 && this.sent != -1) {
            this.received = System.nanoTime();
            this.latch.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public long roundTripTime() throws InterruptedException {
        this.latch.await();
        return this.received - this.sent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void send() {
        if (this.sent == -1) {
            this.sent = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    public long roundTripTime(long j, TimeUnit timeUnit) throws InterruptedException {
        if (this.latch.await(j, timeUnit)) {
            return this.received - this.sent;
        }
        return -2L;
    }
}
