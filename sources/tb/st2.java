package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.C8705s;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.C8694a;
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
                d = C8234b.d();
                if (invoke != d) {
                    Result.C8174a c8174a = Result.Companion;
                    a.resumeWith(Result.m1271constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.C8174a c8174a2 = Result.Companion;
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
                d = C8234b.d();
                if (invoke != d) {
                    Result.C8174a c8174a = Result.Companion;
                    a.resumeWith(Result.m1271constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.C8174a c8174a2 = Result.Companion;
            a.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    public static final <T> void c(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Object d;
        Continuation a = n40.a(continuation);
        try {
            if (function1 != null) {
                Object invoke = ((Function1) tq2.e(function1, 1)).invoke(a);
                d = C8234b.d();
                if (invoke != d) {
                    Result.C8174a c8174a = Result.Companion;
                    a.resumeWith(Result.m1271constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.C8174a c8174a2 = Result.Companion;
            a.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    public static final <R, T> void d(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Object d;
        Continuation a = n40.a(continuation);
        try {
            if (function2 != null) {
                Object invoke = ((Function2) tq2.e(function2, 2)).invoke(r, a);
                d = C8234b.d();
                if (invoke != d) {
                    Result.C8174a c8174a = Result.Companion;
                    a.resumeWith(Result.m1271constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.C8174a c8174a2 = Result.Companion;
            a.resumeWith(Result.m1271constructorimpl(i32.a(th)));
        }
    }

    @Nullable
    public static final <T, R> Object e(@NotNull C8694a<? super T> c8694a, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object amVar;
        Object d;
        Object d2;
        Object d3;
        c8694a.initParentJob$kotlinx_coroutines_core();
        try {
        } catch (Throwable th) {
            amVar = new am(th, false, 2, null);
        }
        if (function2 != null) {
            amVar = ((Function2) tq2.e(function2, 2)).invoke(r, c8694a);
            d = C8234b.d();
            if (amVar == d) {
                d3 = C8234b.d();
                return d3;
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = c8694a.makeCompletingOnce$kotlinx_coroutines_core(amVar);
            if (makeCompletingOnce$kotlinx_coroutines_core == C8705s.COMPLETING_WAITING_CHILDREN) {
                d2 = C8234b.d();
                return d2;
            } else if (makeCompletingOnce$kotlinx_coroutines_core instanceof am) {
                Throwable th2 = ((am) makeCompletingOnce$kotlinx_coroutines_core).a;
                Continuation<? super T> continuation = c8694a.uCont;
                if (k40.d() && (continuation instanceof CoroutineStackFrame)) {
                    throw pf2.a(th2, (CoroutineStackFrame) continuation);
                }
                throw th2;
            } else {
                return C8705s.h(makeCompletingOnce$kotlinx_coroutines_core);
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @Nullable
    public static final <T, R> Object f(@NotNull C8694a<? super T> c8694a, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object amVar;
        Object d;
        Object d2;
        Object d3;
        c8694a.initParentJob$kotlinx_coroutines_core();
        boolean z = false;
        try {
        } catch (Throwable th) {
            amVar = new am(th, false, 2, null);
        }
        if (function2 != null) {
            amVar = ((Function2) tq2.e(function2, 2)).invoke(r, c8694a);
            d = C8234b.d();
            if (amVar == d) {
                d3 = C8234b.d();
                return d3;
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = c8694a.makeCompletingOnce$kotlinx_coroutines_core(amVar);
            if (makeCompletingOnce$kotlinx_coroutines_core == C8705s.COMPLETING_WAITING_CHILDREN) {
                d2 = C8234b.d();
                return d2;
            } else if (makeCompletingOnce$kotlinx_coroutines_core instanceof am) {
                Throwable th2 = ((am) makeCompletingOnce$kotlinx_coroutines_core).a;
                if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == c8694a) ? true : true) {
                    Continuation<? super T> continuation = c8694a.uCont;
                    if (k40.d() && (continuation instanceof CoroutineStackFrame)) {
                        throw pf2.a(th2, (CoroutineStackFrame) continuation);
                    }
                    throw th2;
                } else if (amVar instanceof am) {
                    Throwable th3 = ((am) amVar).a;
                    Continuation<? super T> continuation2 = c8694a.uCont;
                    if (k40.d() && (continuation2 instanceof CoroutineStackFrame)) {
                        throw pf2.a(th3, (CoroutineStackFrame) continuation2);
                    }
                    throw th3;
                } else {
                    return amVar;
                }
            } else {
                return C8705s.h(makeCompletingOnce$kotlinx_coroutines_core);
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
}
