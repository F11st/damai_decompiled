package tb;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class oa2 {
    private static final AtomicLongFieldUpdater a = AtomicLongFieldUpdater.newUpdater(oa2.class, "number");
    private volatile long number = 1;

    public final long a() {
        return a.incrementAndGet(this);
    }
}
