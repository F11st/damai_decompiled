package com.youku.gaiax.impl.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.youku.arch.v3.event.Subject;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007J\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/youku/gaiax/impl/utils/GaiaXWorkerExecutor;", "", "Ljava/util/concurrent/FutureTask;", "Ltb/wt2;", "runnable", "action", "Ljava/lang/Runnable;", "Lkotlin/Function0;", Subject.FUNCTION, "removeAction", "Landroid/os/HandlerThread;", "uiWorker", "Landroid/os/HandlerThread;", "getUiWorker", "()Landroid/os/HandlerThread;", "setUiWorker", "(Landroid/os/HandlerThread;)V", "Landroid/os/Handler;", "uiActionHandler", "Landroid/os/Handler;", "getUiActionHandler", "()Landroid/os/Handler;", "setUiActionHandler", "(Landroid/os/Handler;)V", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXWorkerExecutor {
    @NotNull
    public static final GaiaXWorkerExecutor INSTANCE = new GaiaXWorkerExecutor();
    @Nullable
    private static Handler uiActionHandler;
    @NotNull
    private static HandlerThread uiWorker;

    static {
        HandlerThread handlerThread = new HandlerThread("GaiaXUiWorker");
        uiWorker = handlerThread;
        handlerThread.start();
        uiActionHandler = new Handler(uiWorker.getLooper());
    }

    private GaiaXWorkerExecutor() {
    }

    public final void action(@NotNull FutureTask<wt2> futureTask) {
        b41.i(futureTask, "runnable");
        Handler handler = uiActionHandler;
        if (handler == null) {
            return;
        }
        handler.post(futureTask);
    }

    @Nullable
    public final Handler getUiActionHandler() {
        return uiActionHandler;
    }

    @NotNull
    public final HandlerThread getUiWorker() {
        return uiWorker;
    }

    public final void removeAction(@NotNull Runnable runnable) {
        b41.i(runnable, Subject.FUNCTION);
        Handler handler = uiActionHandler;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public final void setUiActionHandler(@Nullable Handler handler) {
        uiActionHandler = handler;
    }

    public final void setUiWorker(@NotNull HandlerThread handlerThread) {
        b41.i(handlerThread, "<set-?>");
        uiWorker = handlerThread;
    }

    public final void action(@NotNull Runnable runnable) {
        b41.i(runnable, "runnable");
        Handler handler = uiActionHandler;
        if (handler == null) {
            return;
        }
        handler.post(runnable);
    }

    public final void action(@NotNull final Function0<wt2> function0) {
        b41.i(function0, Subject.FUNCTION);
        Handler handler = uiActionHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.youku.gaiax.impl.utils.GaiaXWorkerExecutor$action$1
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
    }
}
