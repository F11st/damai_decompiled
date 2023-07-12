package com.youku.live.messagechannel.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCThreadFactory implements ThreadFactory {
    private static transient /* synthetic */ IpChange $ipChange;
    static final AtomicInteger poolNumber = new AtomicInteger(1);
    final ThreadGroup group;
    final String moduleName;
    final String namePrefix;
    final AtomicInteger threadNumber = new AtomicInteger(1);

    public MCThreadFactory(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = "pool-" + str + "-" + poolNumber.getAndIncrement() + "-thread-";
        this.moduleName = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1473927538")) {
            return (Thread) ipChange.ipc$dispatch("-1473927538", new Object[]{this, runnable});
        }
        ThreadGroup threadGroup = this.group;
        Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
