package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class st2 {
    public static final <T> void a(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Object d;
        Continuation a = n40.a(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, null);
            if (function1 != null) {
                Object invoke = ((Function1) tq2.e(function1, 1)).invoke(a);
                ThreadContextKt.a(context, c);
                d = kotlin.coroutines.intrinsics.b.d();
                if (invoke != d) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m1271constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    public static final <R, T> void b(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Object d;
        Continuation a = n40.a(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, null);
            if (function2 != null) {
                Object invoke = ((Function2) tq2.e(function2, 2)).invoke(r, a);
                ThreadContextKt.a(context, c);
                d = kotlin.coroutines.intrinsics.b.d();
                if (invoke != d) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m1271constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    public static final <T> void c(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Object d;
        Continuation a = n40.a(continuation);
        try {
            if (function1 != null) {
                Object invoke = ((Function1) tq2.e(function1, 1)).invoke(a);
                d = kotlin.coroutines.intrinsics.b.d();
                if (invoke != d) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m1271constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    public static final <R, T> void d(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Object d;
        Continuation a = n40.a(continuation);
        try {
            if (function2 != null) {
                Object invoke = ((Function2) tq2.e(function2, 2)).invoke(r, a);
                d = kotlin.coroutines.intrinsics.b.d();
                if (invoke != d) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m1271constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    @Nullable
    public static final <T, R> Object e(@NotNull kotlinx.coroutines.internal.a<? super T> aVar, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object amVar;
        Object d;
        Object d2;
        Object d3;
        aVar.initParentJob$kotlinx_coroutines_core();
        try {
        } catch (Throwable th) {
            amVar = new am(th, false, 2, null);
        }
        if (function2 != null) {
            amVar = ((Function2) tq2.e(function2, 2)).invoke(r, aVar);
            d = kotlin.coroutines.intrinsics.b.d();
            if (amVar == d) {
                d3 = kotlin.coroutines.intrinsics.b.d();
                return d3;
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = aVar.makeCompletingOnce$kotlinx_coroutines_core(amVar);
            if (makeCompletingOnce$kotlinx_coroutines_core == kotlinx.coroutines.s.COMPLETING_WAITING_CHILDREN) {
                d2 = kotlin.coroutines.intrinsics.b.d();
                return d2;
            } else if (makeCompletingOnce$kotlinx_coroutines_core instanceof am) {
                Throwable th2 = ((am) makeCompletingOnce$kotlinx_coroutines_core).a;
                Continuation<? super T> continuation = aVar.uCont;
                if (k40.d() && (continuation instanceof CoroutineStackFrame)) {
                    throw pf2.a(th2, (CoroutineStackFrame) continuation);
                }
                throw th2;
            } else {
                return kotlinx.coroutines.s.h(makeCompletingOnce$kotlinx_coroutines_core);
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @Nullable
    public static final <T, R> Object f(@NotNull kotlinx.coroutines.internal.a<? super T> aVar, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object amVar;
        Object d;
        Object d2;
        Object d3;
        aVar.initParentJob$kotlinx_coroutines_core();
        boolean z = false;
        try {
        } catch (Throwable th) {
            amVar = new am(th, false, 2, null);
        }
        if (function2 != null) {
            amVar = ((Function2) tq2.e(function2, 2)).invoke(r, aVar);
            d = kotlin.coroutines.intrinsics.b.d();
            if (amVar == d) {
                d3 = kotlin.coroutines.intrinsics.b.d();
                return d3;
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = aVar.makeCompletingOnce$kotlinx_coroutines_core(amVar);
            if (makeCompletingOnce$kotlinx_coroutines_core == kotlinx.coroutines.s.COMPLETING_WAITING_CHILDREN) {
                d2 = kotlin.coroutines.intrinsics.b.d();
                return d2;
            } else if (makeCompletingOnce$kotlinx_coroutines_core instanceof am) {
                Throwable th2 = ((am) makeCompletingOnce$kotlinx_coroutines_core).a;
                if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == aVar) ? true : true) {
                    Continuation<? super T> continuation = aVar.uCont;
                    if (k40.d() && (continuation instanceof CoroutineStackFrame)) {
                        throw pf2.a(th2, (CoroutineStackFrame) continuation);
                    }
                    throw th2;
                } else if (amVar instanceof am) {
                    Throwable th3 = ((am) amVar).a;
                    Continuation<? super T> continuation2 = aVar.uCont;
                    if (k40.d() && (continuation2 instanceof CoroutineStackFrame)) {
                        throw pf2.a(th3, (CoroutineStackFrame) continuation2);
                    }
                    throw th3;
                } else {
                    return amVar;
                }
            } else {
                return kotlinx.coroutines.s.h(makeCompletingOnce$kotlinx_coroutines_core);
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
}
