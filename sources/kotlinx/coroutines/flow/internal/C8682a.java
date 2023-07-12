package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hl1;
import tb.la2;
import tb.n40;
import tb.tq2;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.flow.internal.a */
/* loaded from: classes11.dex */
public final class C8682a {
    @Nullable
    public static final <T, V> Object b(@NotNull CoroutineContext coroutineContext, V v, @NotNull Object obj, @NotNull Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object d;
        Object c = ThreadContextKt.c(coroutineContext, obj);
        try {
            C8684c c8684c = new C8684c(continuation, coroutineContext);
            if (function2 != null) {
                Object invoke = ((Function2) tq2.e(function2, 2)).invoke(v, c8684c);
                ThreadContextKt.a(coroutineContext, c);
                d = C8234b.d();
                if (invoke == d) {
                    n40.c(continuation);
                }
                return invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            ThreadContextKt.a(coroutineContext, c);
            throw th;
        }
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return b(coroutineContext, obj, obj2, function2, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> FlowCollector<T> d(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        return ((flowCollector instanceof la2) || (flowCollector instanceof hl1)) ? flowCollector : new UndispatchedContextCollector(flowCollector, coroutineContext);
    }
}
