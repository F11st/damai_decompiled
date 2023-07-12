package com.taobao.weex.devtools.inspector.network;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class AsyncPrettyPrinterExecutorHolder {
    private static ExecutorService sExecutorService;

    private AsyncPrettyPrinterExecutorHolder() {
    }

    public static void ensureInitialized() {
        if (sExecutorService == null) {
            sExecutorService = Executors.newCachedThreadPool();
        }
    }

    @Nullable
    public static ExecutorService getExecutorService() {
        return sExecutorService;
    }

    public static void shutdown() {
        sExecutorService.shutdown();
        sExecutorService = null;
    }
}
