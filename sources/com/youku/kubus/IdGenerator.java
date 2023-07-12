package com.youku.kubus;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class IdGenerator {
    private static volatile AtomicLong sBaseId = new AtomicLong(0);

    public static long getId() {
        return sBaseId.incrementAndGet();
    }

    public static long getId(Object obj) {
        return obj.hashCode();
    }
}
