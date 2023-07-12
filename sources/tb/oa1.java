package tb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class oa1<E> {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(oa1.class, Object.class, "_cur");
    private volatile Object _cur;

    public oa1(boolean z) {
        this._cur = new pa1(8, z);
    }

    public final boolean a(@NotNull E e) {
        while (true) {
            pa1 pa1Var = (pa1) this._cur;
            int a2 = pa1Var.a(e);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                a.compareAndSet(this, pa1Var, pa1Var.i());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            pa1 pa1Var = (pa1) this._cur;
            if (pa1Var.d()) {
                return;
            }
            a.compareAndSet(this, pa1Var, pa1Var.i());
        }
    }

    public final int c() {
        return ((pa1) this._cur).f();
    }

    @Nullable
    public final E d() {
        while (true) {
            pa1 pa1Var = (pa1) this._cur;
            E e = (E) pa1Var.j();
            if (e != pa1.REMOVE_FROZEN) {
                return e;
            }
            a.compareAndSet(this, pa1Var, pa1Var.i());
        }
    }
}
