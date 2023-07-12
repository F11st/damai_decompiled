package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ed implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final AtomicInteger b;
    private final String c;
    private final boolean d;
    private final ThreadGroup e;

    public ed() {
        this("amap-threadpool-" + a.getAndIncrement(), false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.e, runnable, this.c + this.b.getAndIncrement(), 0L);
        thread.setDaemon(this.d);
        return thread;
    }

    public ed(String str) {
        this(str, false);
    }

    public ed(String str, boolean z) {
        String str2;
        this.b = new AtomicInteger(1);
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str + "-thread-";
        }
        this.c = str2;
        this.d = z;
        SecurityManager securityManager = System.getSecurityManager();
        this.e = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
    }
}
