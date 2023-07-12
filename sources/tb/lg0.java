package tb;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public final class lg0 {
    private static final Logger c = Logger.getLogger(lg0.class.getName());
    @NullableDecl
    @GuardedBy("this")
    private a a;
    @GuardedBy("this")
    private boolean b;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class a {
        final Runnable a;
        final Executor b;
        @NullableDecl
        a c;

        a(Runnable runnable, Executor executor, a aVar) {
            this.a = runnable;
            this.b = executor;
            this.c = aVar;
        }
    }

    private static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        du1.q(runnable, "Runnable was null.");
        du1.q(executor, "Executor was null.");
        synchronized (this) {
            if (!this.b) {
                this.a = new a(runnable, executor, this.a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            a aVar = this.a;
            a aVar2 = null;
            this.a = null;
            while (aVar != null) {
                a aVar3 = aVar.c;
                aVar.c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.a, aVar2.b);
                aVar2 = aVar2.c;
            }
        }
    }
}
