package com.ali.user.open.core.service;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface MemberExecutorService extends ExecutorService {
    Looper getDefaultLooper();

    void postHandlerTask(Runnable runnable);

    void postTask(Runnable runnable);

    void postUITask(Runnable runnable);
}
