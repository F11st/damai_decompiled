package com.alibaba.android.onescheduler.threadpool;

import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListeningExecutorService;
import tb.ng0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface IExecutorServiceFactory {
    @NonNull
    ListeningExecutorService createCpuExecutorService(ng0 ng0Var);

    @NonNull
    ListeningExecutorService createIOExecutorService(ng0 ng0Var);

    @NonNull
    ListeningExecutorService createNormalExecutorService(ng0 ng0Var);

    @NonNull
    ListeningExecutorService createRpcExecutorService(ng0 ng0Var);
}
