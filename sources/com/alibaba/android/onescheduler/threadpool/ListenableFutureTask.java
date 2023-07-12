package com.alibaba.android.onescheduler.threadpool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import tb.lg0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final lg0 executionList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenableFutureTask(@NonNull Callable<V> callable) {
        super(callable);
        this.executionList = new lg0();
    }

    @NonNull
    public static <V> ListenableFutureTask<V> create(@NonNull Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.executionList.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.executionList.b();
    }

    @Nullable
    public static <V> ListenableFutureTask<V> create(@NonNull Runnable runnable, @Nullable V v) {
        return new ListenableFutureTask<>(runnable, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenableFutureTask(@NonNull Runnable runnable, @Nullable V v) {
        super(runnable, v);
        this.executionList = new lg0();
    }
}
