package com.alibaba.mobsec.privacydoublelist.e;

import com.alibaba.wireless.security.aopsdk.Invocation;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* renamed from: com.alibaba.mobsec.privacydoublelist.e.b */
/* loaded from: classes6.dex */
public abstract class AbstractC3434b {
    public static final Pattern f = Pattern.compile("(.*)\\.(.*\\(.*\\))");
    public static final Pattern g = Pattern.compile("(.*)\\.(\\w+)");
    public String a;
    public final AtomicInteger b = new AtomicInteger(0);
    public final AtomicInteger c = new AtomicInteger(0);
    public final AtomicInteger d = new AtomicInteger(0);
    public final AtomicInteger e = new AtomicInteger(0);

    public void a(Invocation invocation, boolean z) {
        if (!z) {
            this.e.addAndGet(1);
        }
        if (z) {
            this.d.addAndGet(1);
        } else if (invocation.shouldBlock()) {
            this.c.addAndGet(1);
        } else {
            this.b.addAndGet(1);
        }
    }

    public int a() {
        return this.d.get();
    }
}
