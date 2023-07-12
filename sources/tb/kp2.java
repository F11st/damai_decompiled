package tb;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class kp2 {
    private static final AtomicInteger a = new AtomicInteger(0);

    public static int a() {
        return a.getAndIncrement();
    }
}
