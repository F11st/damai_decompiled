package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import tb.du1;

/* compiled from: Taobao */
@CanIgnoreReturnValue
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class h<V> extends g<V> implements ListenableFuture<V> {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class a<V> extends h<V> {
        private final ListenableFuture<V> a;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(ListenableFuture<V> listenableFuture) {
            this.a = (ListenableFuture) du1.p(listenableFuture);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t
        /* renamed from: b */
        public final ListenableFuture<V> delegate() {
            return this.a;
        }
    }

    protected h() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        b().addListener(runnable, executor);
    }

    protected abstract ListenableFuture<? extends V> b();
}
