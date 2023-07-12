package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i2;
import tb.id;
import tb.j2;
import tb.k40;
import tb.kj2;
import tb.n40;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class n extends j2<StateFlowImpl<?>> {
    static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_state");
    volatile Object _state = null;

    @Override // tb.j2
    /* renamed from: c */
    public boolean a(@NotNull StateFlowImpl<?> stateFlowImpl) {
        kj2 kj2Var;
        if (this._state != null) {
            return false;
        }
        kj2Var = m.a;
        this._state = kj2Var;
        return true;
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super wt2> continuation) {
        Continuation c;
        kj2 kj2Var;
        Object d;
        kj2 kj2Var2;
        c = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c, 1);
        cancellableContinuationImpl.initCancellability();
        if (!k40.a() || id.a(!(this._state instanceof CancellableContinuationImpl)).booleanValue()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            kj2Var = m.a;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, kj2Var, cancellableContinuationImpl)) {
                if (k40.a()) {
                    Object obj = this._state;
                    kj2Var2 = m.b;
                    if (!id.a(obj == kj2Var2).booleanValue()) {
                        throw new AssertionError();
                    }
                }
                wt2 wt2Var = wt2.INSTANCE;
                Result.a aVar = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m1271constructorimpl(wt2Var));
            }
            Object result = cancellableContinuationImpl.getResult();
            d = kotlin.coroutines.intrinsics.b.d();
            if (result == d) {
                n40.c(continuation);
            }
            return result;
        }
        throw new AssertionError();
    }

    @Override // tb.j2
    @NotNull
    /* renamed from: e */
    public Continuation<Unit>[] b(@NotNull StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return i2.EMPTY_RESUMES;
    }

    public final void f() {
        kj2 kj2Var;
        kj2 kj2Var2;
        kj2 kj2Var3;
        kj2 kj2Var4;
        while (true) {
            Object obj = this._state;
            if (obj == null) {
                return;
            }
            kj2Var = m.b;
            if (obj == kj2Var) {
                return;
            }
            kj2Var2 = m.a;
            if (obj == kj2Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                kj2Var3 = m.b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, kj2Var3)) {
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = a;
                kj2Var4 = m.a;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, kj2Var4)) {
                    wt2 wt2Var = wt2.INSTANCE;
                    Result.a aVar = Result.Companion;
                    ((CancellableContinuationImpl) obj).resumeWith(Result.m1271constructorimpl(wt2Var));
                    return;
                }
            }
        }
    }

    public final boolean g() {
        kj2 kj2Var;
        kj2 kj2Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        kj2Var = m.a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, kj2Var);
        b41.f(andSet);
        if (!k40.a() || (!(andSet instanceof CancellableContinuationImpl))) {
            kj2Var2 = m.b;
            return andSet == kj2Var2;
        }
        throw new AssertionError();
    }
}
