package com.youku.middlewareservice.provider.task;

import com.youku.live.livesdk.wkit.component.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class NamedThreadFactory implements ThreadFactory {
    private final AtomicInteger counter;
    private final ThreadFactory factory;
    private final ThreadGroup group;
    private final String name;

    public NamedThreadFactory(String str) {
        this(null, str);
    }

    public static ThreadFactory newInstance(String str) {
        return new NamedThreadFactory(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadFactory threadFactory = this.factory;
        if (threadFactory == null) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.name + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.counter.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
        if (threadFactory.newThread(runnable).getName() == null) {
            this.factory.newThread(runnable).setName(this.name);
        }
        return this.factory.newThread(runnable);
    }

    public NamedThreadFactory(ThreadFactory threadFactory, String str) {
        this.counter = new AtomicInteger(1);
        this.factory = threadFactory;
        this.name = str;
        this.group = Thread.currentThread().getThreadGroup();
    }

    public static ThreadFactory newInstance(ThreadFactory threadFactory, String str) {
        return new NamedThreadFactory(threadFactory, str);
    }
}
