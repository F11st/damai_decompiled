package com.youku.gaiax.provider.module;

import androidx.annotation.Keep;
import com.youku.gaiax.api.proxy.IProxyTask;
import com.youku.gaiax.provider.module.GaiaXProxyTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyTask;", "Lcom/youku/gaiax/api/proxy/IProxyTask;", "Lkotlin/Function0;", "Ltb/wt2;", "runnable", "executeTask", "Ljava/util/concurrent/ExecutorService;", "threadPoolExecutor", "Ljava/util/concurrent/ExecutorService;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXProxyTask implements IProxyTask {
    @NotNull
    private final ExecutorService threadPoolExecutor;

    public GaiaXProxyTask() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        b41.h(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.threadPoolExecutor = newSingleThreadExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: executeTask$lambda-0  reason: not valid java name */
    public static final void m1262executeTask$lambda0(Function0 function0) {
        b41.i(function0, "$runnable");
        function0.invoke();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyTask
    public void executeTask(@NotNull final Function0<wt2> function0) {
        b41.i(function0, "runnable");
        this.threadPoolExecutor.execute(new Runnable() { // from class: tb.ft0
            @Override // java.lang.Runnable
            public final void run() {
                GaiaXProxyTask.m1262executeTask$lambda0(Function0.this);
            }
        });
    }
}
