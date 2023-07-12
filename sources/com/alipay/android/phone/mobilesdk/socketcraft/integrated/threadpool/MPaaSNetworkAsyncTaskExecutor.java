package com.alipay.android.phone.mobilesdk.socketcraft.integrated.threadpool;

import com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor;
import com.alipay.mobile.common.transport.utils.NetworkAsyncTaskExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MPaaSNetworkAsyncTaskExecutor implements SCNetworkAsyncTaskExecutor {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void execute(Runnable runnable) {
        NetworkAsyncTaskExecutor.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void executeIO(Runnable runnable) {
        NetworkAsyncTaskExecutor.executeIO(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void executeLazy(Runnable runnable) {
        NetworkAsyncTaskExecutor.executeLazy(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void executeLowPri(Runnable runnable) {
        NetworkAsyncTaskExecutor.executeLowPri(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public void executeSerial(Runnable runnable) {
        NetworkAsyncTaskExecutor.executeSerial(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return NetworkAsyncTaskExecutor.schedule(runnable, j, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return NetworkAsyncTaskExecutor.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return NetworkAsyncTaskExecutor.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public Future<?> submit(Runnable runnable) {
        return NetworkAsyncTaskExecutor.submit(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public Future<?> submitLazy(Runnable runnable) {
        return NetworkAsyncTaskExecutor.submitLazy(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public Future<?> submitSerial(Runnable runnable) {
        return NetworkAsyncTaskExecutor.submitSerial(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return NetworkAsyncTaskExecutor.schedule(callable, j, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskExecutor
    public <T> Future<T> submit(Callable<T> callable) {
        return NetworkAsyncTaskExecutor.submit(callable);
    }
}
