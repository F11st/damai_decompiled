package com.google.common.util.concurrent;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class MoreExecutors$Application$1 implements Runnable {
    final /* synthetic */ MoreExecutors.c this$0;
    final /* synthetic */ ExecutorService val$service;
    final /* synthetic */ long val$terminationTimeout;
    final /* synthetic */ TimeUnit val$timeUnit;

    MoreExecutors$Application$1(MoreExecutors.c cVar, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.val$service = executorService;
        this.val$terminationTimeout = j;
        this.val$timeUnit = timeUnit;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$service.shutdown();
            this.val$service.awaitTermination(this.val$terminationTimeout, this.val$timeUnit);
        } catch (InterruptedException unused) {
        }
    }
}
