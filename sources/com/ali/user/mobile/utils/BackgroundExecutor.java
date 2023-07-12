package com.ali.user.mobile.utils;

import com.ali.user.mobile.coordinator.Coordinator;
import com.ali.user.mobile.log.TLogAdapter;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class BackgroundExecutor {
    private static final Executor executor = Coordinator.sThreadPoolExecutor;

    public static void execute(Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            TLogAdapter.e("login.BackgroundExecutor", "BackgroundExecutor.excute failed.", e);
            e.printStackTrace();
        }
    }
}
