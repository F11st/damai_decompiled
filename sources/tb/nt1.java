package tb;

import androidx.annotation.MainThread;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class nt1<T> {
    @NotNull
    private final os1 a = os1.INSTANCE;
    @Nullable
    private Continuation<? super T> b;
    private Object c;

    @Nullable
    public final Object a(@NotNull Continuation<? super T> continuation) {
        Continuation c;
        Object d;
        Object obj = this.c;
        if (obj == null) {
            c = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            o52 o52Var = new o52(c);
            System.out.println((Object) "PendingData await2");
            this.b = o52Var;
            Object a = o52Var.a();
            d = C8234b.d();
            if (a == d) {
                n40.c(continuation);
            }
            return a;
        }
        if (obj == null) {
            b41.A("data");
            obj = wt2.INSTANCE;
        }
        if (obj == this.a) {
            return null;
        }
        Object obj2 = this.c;
        if (obj2 == null) {
            b41.A("data");
            return wt2.INSTANCE;
        }
        return obj2;
    }

    @MainThread
    public final void b(T t) {
        if (this.c == null) {
            this.c = t == null ? this.a : t;
            Continuation<? super T> continuation = this.b;
            if (continuation == null) {
                return;
            }
            Result.C8174a c8174a = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(t));
            this.b = null;
        }
    }
}
