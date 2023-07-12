package tb;

import com.taobao.orange.OConstant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class fg extends g60 {
    @NotNull
    private final Runnable b;
    @NotNull
    private final Function1<InterruptedException, wt2> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public fg(@NotNull Lock lock, @NotNull Runnable runnable, @NotNull Function1<? super InterruptedException, wt2> function1) {
        super(lock);
        b41.i(lock, OConstant.DIMEN_FILE_LOCK);
        b41.i(runnable, "checkCancelled");
        b41.i(function1, "interruptedExceptionHandler");
        this.b = runnable;
        this.c = function1;
    }

    @Override // tb.g60, kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.b.run();
            } catch (InterruptedException e) {
                this.c.invoke(e);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fg(@NotNull Runnable runnable, @NotNull Function1<? super InterruptedException, wt2> function1) {
        this(new ReentrantLock(), runnable, function1);
        b41.i(runnable, "checkCancelled");
        b41.i(function1, "interruptedExceptionHandler");
    }
}
