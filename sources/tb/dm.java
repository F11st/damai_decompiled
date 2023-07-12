package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class dm {
    @NotNull
    public static final <T> Object a(@Nullable Object obj, @NotNull Continuation<? super T> continuation) {
        if (obj instanceof am) {
            Result.a aVar = Result.Companion;
            Throwable th = ((am) obj).a;
            if (k40.d() && (continuation instanceof CoroutineStackFrame)) {
                th = pf2.j(th, (CoroutineStackFrame) continuation);
            }
            return Result.m1271constructorimpl(i32.a(th));
        }
        Result.a aVar2 = Result.Companion;
        return Result.m1271constructorimpl(obj);
    }

    @Nullable
    public static final <T> Object b(@NotNull Object obj, @Nullable Function1<? super Throwable, wt2> function1) {
        Throwable m1274exceptionOrNullimpl = Result.m1274exceptionOrNullimpl(obj);
        if (m1274exceptionOrNullimpl == null) {
            return function1 != null ? new bm(obj, function1) : obj;
        }
        return new am(m1274exceptionOrNullimpl, false, 2, null);
    }

    @Nullable
    public static final <T> Object c(@NotNull Object obj, @NotNull CancellableContinuation<?> cancellableContinuation) {
        Throwable m1274exceptionOrNullimpl = Result.m1274exceptionOrNullimpl(obj);
        if (m1274exceptionOrNullimpl != null) {
            if (k40.d() && (cancellableContinuation instanceof CoroutineStackFrame)) {
                m1274exceptionOrNullimpl = pf2.j(m1274exceptionOrNullimpl, (CoroutineStackFrame) cancellableContinuation);
            }
            obj = new am(m1274exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
