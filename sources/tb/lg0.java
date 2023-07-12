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
    private C9409a a;
    @GuardedBy("this")
    private boolean b;

    /* compiled from: Taobao */
    /* renamed from: tb.lg0$a */
    /* loaded from: classes10.dex */
    private static final class C9409a {
        final Runnable a;
        final Executor b;
        @NullableDecl
        C9409a c;

        C9409a(Runnable runnable, Executor executor, C9409a c9409a) {
            this.a = runnable;
            this.b = executor;
            this.c = c9409a;
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
                this.a = new C9409a(runnable, executor, this.a);
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
            C9409a c9409a = this.a;
            C9409a c9409a2 = null;
            this.a = null;
            while (c9409a != null) {
                C9409a c9409a3 = c9409a.c;
                c9409a.c = c9409a2;
                c9409a2 = c9409a;
                c9409a = c9409a3;
            }
            while (c9409a2 != null) {
                c(c9409a2.a, c9409a2.b);
                c9409a2 = c9409a2.c;
            }
        }
    }
}
