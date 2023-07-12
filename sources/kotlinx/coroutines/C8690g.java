package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.C8694a;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.eg;
import tb.lo;
import tb.n23;
import tb.n40;
import tb.st2;
import tb.wt2;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.g */
/* loaded from: classes8.dex */
public final /* synthetic */ class C8690g {
    @NotNull
    public static final Job a(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super wt2>, ? extends Object> function2) {
        AbstractC8619a c8723y;
        CoroutineContext c = lo.c(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            c8723y = new C8717t(c, function2);
        } else {
            c8723y = new C8723y(c, true);
        }
        c8723y.start(coroutineStart, c8723y, function2);
        return c8723y;
    }

    public static /* synthetic */ Job b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return C8658e.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @Nullable
    public static final <T> Object c(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object a;
        Object d;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        n23.a(plus);
        if (plus == context) {
            C8694a c8694a = new C8694a(plus, continuation);
            a = st2.e(c8694a, c8694a, function2);
        } else {
            ContinuationInterceptor.C8231b c8231b = ContinuationInterceptor.Key;
            if (b41.d((ContinuationInterceptor) plus.get(c8231b), (ContinuationInterceptor) context.get(c8231b))) {
                C8620a0 c8620a0 = new C8620a0(plus, continuation);
                Object c = ThreadContextKt.c(plus, null);
                try {
                    Object e = st2.e(c8620a0, c8620a0, function2);
                    ThreadContextKt.a(plus, c);
                    a = e;
                } catch (Throwable th) {
                    ThreadContextKt.a(plus, c);
                    throw th;
                }
            } else {
                C8697k c8697k = new C8697k(plus, continuation);
                c8697k.initParentJob$kotlinx_coroutines_core();
                eg.d(function2, c8697k, c8697k, null, 4, null);
                a = c8697k.a();
            }
        }
        d = C8234b.d();
        if (a == d) {
            n40.c(continuation);
        }
        return a;
    }
}
