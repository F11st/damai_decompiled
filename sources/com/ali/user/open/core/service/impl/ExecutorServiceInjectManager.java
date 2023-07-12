package com.ali.user.open.core.service.impl;

import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ExecutorServiceInjectManager {
    private static ThreadPoolExecutor mThreadPoolExecutor;

    public static ThreadPoolExecutor getInjectThreadPoolExecutor() {
        return mThreadPoolExecutor;
    }

    public static void setInjectThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        mThreadPoolExecutor = threadPoolExecutor;
    }
}
