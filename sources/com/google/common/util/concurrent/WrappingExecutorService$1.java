package com.google.common.util.concurrent;

import com.google.common.base.C4844i;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class WrappingExecutorService$1 implements Runnable {
    final /* synthetic */ AbstractExecutorServiceC5364r this$0;
    final /* synthetic */ Callable val$wrapped;

    WrappingExecutorService$1(AbstractExecutorServiceC5364r abstractExecutorServiceC5364r, Callable callable) {
        this.this$0 = abstractExecutorServiceC5364r;
        this.val$wrapped = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$wrapped.call();
        } catch (Exception e) {
            C4844i.f(e);
            throw new RuntimeException(e);
        }
    }
}
