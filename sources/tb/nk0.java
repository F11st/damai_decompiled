package tb;

import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class nk0 {
    @Nullable
    public static final <R> Object a(@BuilderInference @NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        Object d;
        lk0 lk0Var = new lk0(continuation.getContext(), continuation);
        Object e = st2.e(lk0Var, lk0Var, function2);
        d = C8234b.d();
        if (e == d) {
            n40.c(continuation);
        }
        return e;
    }
}
