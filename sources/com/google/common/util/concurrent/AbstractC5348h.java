package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import tb.du1;

/* compiled from: Taobao */
@CanIgnoreReturnValue
@GwtCompatible
/* renamed from: com.google.common.util.concurrent.h */
/* loaded from: classes10.dex */
public abstract class AbstractC5348h<V> extends AbstractFutureC5347g<V> implements ListenableFuture<V> {

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.h$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC5349a<V> extends AbstractC5348h<V> {
        private final ListenableFuture<V> a;

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractC5349a(ListenableFuture<V> listenableFuture) {
            this.a = (ListenableFuture) du1.p(listenableFuture);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5205t
        /* renamed from: b */
        public final ListenableFuture<V> delegate() {
            return this.a;
        }
    }

    protected AbstractC5348h() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        b().addListener(runnable, executor);
    }

    protected abstract ListenableFuture<? extends V> b();
}
