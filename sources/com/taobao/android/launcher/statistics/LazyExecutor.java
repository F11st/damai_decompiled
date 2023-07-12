package com.taobao.android.launcher.statistics;

import androidx.annotation.NonNull;
import com.alibaba.motu.crashreportadapter.MotuReportAdapteHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
class LazyExecutor {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static class Motu {
        static final MotuReportAdapteHandler ADAPTER_HANDLER = new MotuReportAdapteHandler();

        Motu() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static class Startup {
        static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.taobao.android.launcher.statistics.LazyExecutor.Startup.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "debug-launcher-statistics");
            }
        });

        Startup() {
        }
    }

    LazyExecutor() {
    }
}
