package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: okio.e */
/* loaded from: classes2.dex */
public class C8841e extends C8857o {
    private C8857o a;

    public C8841e(C8857o c8857o) {
        if (c8857o != null) {
            this.a = c8857o;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final C8857o a() {
        return this.a;
    }

    public final C8841e b(C8857o c8857o) {
        if (c8857o != null) {
            this.a = c8857o;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.C8857o
    public C8857o clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // okio.C8857o
    public C8857o clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // okio.C8857o
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // okio.C8857o
    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // okio.C8857o
    public void throwIfReached() throws IOException {
        this.a.throwIfReached();
    }

    @Override // okio.C8857o
    public C8857o timeout(long j, TimeUnit timeUnit) {
        return this.a.timeout(j, timeUnit);
    }

    @Override // okio.C8857o
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // okio.C8857o
    public C8857o deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }
}
