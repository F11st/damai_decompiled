package tb;

import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: tb.do  reason: invalid class name */
/* loaded from: classes3.dex */
public final class Cdo {
    @SinceKotlin(version = "1.3")
    public static final <T> void a(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Continuation<wt2> a;
        Continuation c;
        b41.i(function1, "<this>");
        b41.i(continuation, "completion");
        a = IntrinsicsKt__IntrinsicsJvmKt.a(function1, continuation);
        c = IntrinsicsKt__IntrinsicsJvmKt.c(a);
        Result.C8174a c8174a = Result.Companion;
        c.resumeWith(Result.m1271constructorimpl(wt2.INSTANCE));
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> void b(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Continuation<wt2> b;
        Continuation c;
        b41.i(function2, "<this>");
        b41.i(continuation, "completion");
        b = IntrinsicsKt__IntrinsicsJvmKt.b(function2, r, continuation);
        c = IntrinsicsKt__IntrinsicsJvmKt.c(b);
        Result.C8174a c8174a = Result.Companion;
        c.resumeWith(Result.m1271constructorimpl(wt2.INSTANCE));
    }
}
