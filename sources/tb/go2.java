package tb;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class go2 {
    private static final AtomicLong a = new AtomicLong();

    public static String a() {
        return System.currentTimeMillis() + "." + a.incrementAndGet();
    }
}
