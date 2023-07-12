package com.alibaba.appmonitor.delegate;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.event.EventRepo;
import java.util.concurrent.ScheduledFuture;
import tb.hl2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CleanTask implements Runnable {
    private static final String TAG = "CleanTask";
    private static CleanTask cleanTask = null;
    private static ScheduledFuture future = null;
    private static boolean init = false;
    private static final long timeout = 300000;

    private CleanTask() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void destroy() {
        ScheduledFuture scheduledFuture = future;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            future.cancel(true);
        }
        init = false;
        cleanTask = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init() {
        if (init) {
            return;
        }
        Logger.f(TAG, "init TimeoutEventManager");
        cleanTask = new CleanTask();
        future = hl2.c().e(future, cleanTask, 300000L);
        init = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger.f(TAG, "clean TimeoutEvent");
        EventRepo.s().h();
    }
}
