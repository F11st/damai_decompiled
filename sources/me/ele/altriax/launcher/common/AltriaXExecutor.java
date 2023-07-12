package me.ele.altriax.launcher.common;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXExecutor {
    public static final ExecutorService ALTRIAX_EXECUTOR = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: me.ele.altriax.launcher.common.AltriaXExecutor.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "AltriaXExecutor");
        }
    });
}
