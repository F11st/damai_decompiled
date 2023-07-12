package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    private final FlowCollector<T> a;
    private final Function2<FlowCollector<? super T>, Continuation<? super wt2>, Object> b;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super tb.wt2> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.flow.internal.SafeCollector r1 = (kotlinx.coroutines.flow.internal.SafeCollector) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.SubscribedFlowCollector r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r0
            tb.i32.b(r7)
            goto L81
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.internal.SafeCollector r2 = (kotlinx.coroutines.flow.internal.SafeCollector) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.SubscribedFlowCollector r4 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r4
            tb.i32.b(r7)     // Catch: java.lang.Throwable -> L48
            goto L69
        L48:
            r7 = move-exception
            goto L86
        L4a:
            tb.i32.b(r7)
            kotlinx.coroutines.flow.FlowCollector<T> r7 = r6.a
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r5 = new kotlinx.coroutines.flow.internal.SafeCollector
            r5.<init>(r7, r2)
            kotlin.jvm.functions.Function2<kotlinx.coroutines.flow.FlowCollector<? super T>, kotlin.coroutines.Continuation<? super tb.wt2>, java.lang.Object> r7 = r6.b     // Catch: java.lang.Throwable -> L84
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L84
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L84
            r0.label = r4     // Catch: java.lang.Throwable -> L84
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L84
            if (r7 != r1) goto L67
            return r1
        L67:
            r4 = r6
            r2 = r5
        L69:
            r2.releaseIntercepted()
            kotlinx.coroutines.flow.FlowCollector<T> r7 = r4.a
            boolean r5 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector
            if (r5 == 0) goto L81
            kotlinx.coroutines.flow.SubscribedFlowCollector r7 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r7
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L81
            return r1
        L81:
            tb.wt2 r7 = tb.wt2.INSTANCE
            return r7
        L84:
            r7 = move-exception
            r2 = r5
        L86:
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super wt2> continuation) {
        return this.a.emit(t, continuation);
    }
}
