package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class eg {
    public static final void a(@NotNull Continuation<? super wt2> continuation, @NotNull Continuation<?> continuation2) {
        Continuation c;
        try {
            c = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            Result.C8174a c8174a = Result.Companion;
            aa0.c(c, Result.m1271constructorimpl(wt2.INSTANCE), null, 2, null);
        } catch (Throwable th) {
            Result.C8174a c8174a2 = Result.Companion;
            continuation2.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    @InternalCoroutinesApi
    public static final <T> void b(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Continuation<wt2> a;
        Continuation c;
        try {
            a = IntrinsicsKt__IntrinsicsJvmKt.a(function1, continuation);
            c = IntrinsicsKt__IntrinsicsJvmKt.c(a);
            Result.C8174a c8174a = Result.Companion;
            aa0.c(c, Result.m1271constructorimpl(wt2.INSTANCE), null, 2, null);
        } catch (Throwable th) {
            Result.C8174a c8174a2 = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    public static final <R, T> void c(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation, @Nullable Function1<? super Throwable, wt2> function1) {
        Continuation<wt2> b;
        Continuation c;
        try {
            b = IntrinsicsKt__IntrinsicsJvmKt.b(function2, r, continuation);
            c = IntrinsicsKt__IntrinsicsJvmKt.c(b);
            Result.C8174a c8174a = Result.Companion;
            aa0.b(c, Result.m1271constructorimpl(wt2.INSTANCE), function1);
        } catch (Throwable th) {
            Result.C8174a c8174a2 = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    public static /* synthetic */ void d(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        c(function2, obj, continuation, function1);
    }
}
