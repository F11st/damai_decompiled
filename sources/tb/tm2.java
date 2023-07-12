package tb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
final class tm2 implements Function1<Throwable, wt2> {
    private static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(tm2.class, "_state");
    private volatile int _state = 0;
    private final Thread a = Thread.currentThread();
    private DisposableHandle b;
    private final Job c;

    public tm2(@NotNull Job job) {
        this.c = job;
    }

    private final Void b(int i) {
        throw new IllegalStateException(("Illegal state " + i).toString());
    }

    public final void a() {
        while (true) {
            int i = this._state;
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (d.compareAndSet(this, i, 1)) {
                DisposableHandle disposableHandle = this.b;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void c(@Nullable Throwable th) {
        int i;
        do {
            i = this._state;
            if (i != 0) {
                if (i == 1 || i == 2 || i == 3) {
                    return;
                }
                b(i);
                throw new KotlinNothingValueException();
            }
        } while (!d.compareAndSet(this, i, 2));
        this.a.interrupt();
        this._state = 3;
    }

    public final void d() {
        int i;
        this.b = this.c.invokeOnCompletion(true, true, this);
        do {
            i = this._state;
            if (i != 0) {
                if (i == 2 || i == 3) {
                    return;
                }
                b(i);
                throw new KotlinNothingValueException();
            }
        } while (!d.compareAndSet(this, i, 0));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        c(th);
        return wt2.INSTANCE;
    }
}
