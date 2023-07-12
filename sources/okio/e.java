package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class e extends o {
    private o a;

    public e(o oVar) {
        if (oVar != null) {
            this.a = oVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final o a() {
        return this.a;
    }

    public final e b(o oVar) {
        if (oVar != null) {
            this.a = oVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.o
    public o clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // okio.o
    public o clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // okio.o
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // okio.o
    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // okio.o
    public void throwIfReached() throws IOException {
        this.a.throwIfReached();
    }

    @Override // okio.o
    public o timeout(long j, TimeUnit timeUnit) {
        return this.a.timeout(j, timeUnit);
    }

    @Override // okio.o
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // okio.o
    public o deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }
}
