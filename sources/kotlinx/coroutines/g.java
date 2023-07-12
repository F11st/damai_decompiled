package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
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
/* loaded from: classes8.dex */
public final /* synthetic */ class g {
    @NotNull
    public static final Job a(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super wt2>, ? extends Object> function2) {
        a yVar;
        CoroutineContext c = lo.c(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            yVar = new t(c, function2);
        } else {
            yVar = new y(c, true);
        }
        yVar.start(coroutineStart, yVar, function2);
        return yVar;
    }

    public static /* synthetic */ Job b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return e.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @Nullable
    public static final <T> Object c(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object a;
        Object d;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        n23.a(plus);
        if (plus == context) {
            kotlinx.coroutines.internal.a aVar = new kotlinx.coroutines.internal.a(plus, continuation);
            a = st2.e(aVar, aVar, function2);
        } else {
            ContinuationInterceptor.b bVar = ContinuationInterceptor.Key;
            if (b41.d((ContinuationInterceptor) plus.get(bVar), (ContinuationInterceptor) context.get(bVar))) {
                a0 a0Var = new a0(plus, continuation);
                Object c = ThreadContextKt.c(plus, null);
                try {
                    Object e = st2.e(a0Var, a0Var, function2);
                    ThreadContextKt.a(plus, c);
                    a = e;
                } catch (Throwable th) {
                    ThreadContextKt.a(plus, c);
                    throw th;
                }
            } else {
                k kVar = new k(plus, continuation);
                kVar.initParentJob$kotlinx_coroutines_core();
                eg.d(function2, kVar, kVar, null, 4, null);
                a = kVar.a();
            }
        }
        d = kotlin.coroutines.intrinsics.b.d();
        if (a == d) {
            n40.c(continuation);
        }
        return a;
    }
}
