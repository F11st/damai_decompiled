package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import tb.lg0;
import tb.om2;

/* compiled from: Taobao */
/* renamed from: com.google.common.util.concurrent.l */
/* loaded from: classes10.dex */
class C5357l<V> extends AbstractFutureC5347g<V> implements ListenableFuture<V> {
    private static final ThreadFactory a;
    private static final Executor b;

    static {
        ThreadFactory b2 = new om2().e(true).f("ListenableFutureAdapter-thread-%d").b();
        a = b2;
        b = Executors.newCachedThreadPool(b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Future b(C5357l c5357l) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ lg0 c(C5357l c5357l) {
        throw null;
    }
}
