package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class o40 {
    @NotNull
    public static final String a(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NotNull
    public static final String b(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    public static final String c(@NotNull Continuation<?> continuation) {
        String m1271constructorimpl;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(continuation + '@' + b(continuation));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(i32.a(th));
        }
        if (Result.m1274exceptionOrNullimpl(m1271constructorimpl) != null) {
            m1271constructorimpl = continuation.getClass().getName() + '@' + b(continuation);
        }
        return (String) m1271constructorimpl;
    }
}
