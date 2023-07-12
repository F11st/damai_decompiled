package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public interface ListeningExecutorService extends ExecutorService {
    @Override // java.util.concurrent.ExecutorService
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException;

    @Override // java.util.concurrent.ExecutorService
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.concurrent.ExecutorService
    ListenableFuture<?> submit(Runnable runnable);

    @Override // java.util.concurrent.ExecutorService
    <T> ListenableFuture<T> submit(Runnable runnable, T t);

    @Override // java.util.concurrent.ExecutorService
    <T> ListenableFuture<T> submit(Callable<T> callable);
}
