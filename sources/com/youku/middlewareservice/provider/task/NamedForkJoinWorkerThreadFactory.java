package com.youku.middlewareservice.provider.task;

import androidx.annotation.RequiresApi;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/* compiled from: Taobao */
@RequiresApi(api = 21)
/* loaded from: classes13.dex */
public class NamedForkJoinWorkerThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {
    private final ForkJoinPool.ForkJoinWorkerThreadFactory factory;
    private final String name;

    public NamedForkJoinWorkerThreadFactory(ForkJoinPool.ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory, String str) {
        this.factory = forkJoinWorkerThreadFactory;
        this.name = str;
    }

    @Override // java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory
    public ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool) {
        ForkJoinPool.ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
        ForkJoinWorkerThread newThread = forkJoinWorkerThreadFactory != null ? forkJoinWorkerThreadFactory.newThread(forkJoinPool) : new ForkJoinWorkerThread(forkJoinPool) { // from class: com.youku.middlewareservice.provider.task.NamedForkJoinWorkerThreadFactory.1
        };
        if (newThread.getName() == null) {
            newThread.setName(this.name);
        }
        return newThread;
    }

    public NamedForkJoinWorkerThreadFactory(String str) {
        this(null, str);
    }
}
