package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import tb.lg0;
import tb.om2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class l<V> extends g<V> implements ListenableFuture<V> {
    private static final ThreadFactory a;
    private static final Executor b;

    static {
        ThreadFactory b2 = new om2().e(true).f("ListenableFutureAdapter-thread-%d").b();
        a = b2;
        b = Executors.newCachedThreadPool(b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Future b(l lVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ lg0 c(l lVar) {
        throw null;
    }
}
