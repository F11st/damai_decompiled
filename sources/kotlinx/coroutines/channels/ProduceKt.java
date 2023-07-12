package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dv1;
import tb.lo;
import tb.ph;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class ProduceKt {
    /* JADX WARN: Removed duplicated region for block: B:45:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x003c  */
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope<?> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<tb.wt2> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super tb.wt2> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$1
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            tb.i32.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r4 = move-exception
            goto L82
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            tb.i32.b(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.Job$b r2 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            if (r6 != r4) goto L4f
            r6 = 1
            goto L50
        L4f:
            r6 = 0
        L50:
            if (r6 == 0) goto L86
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L32
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.a.c(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.initCancellability()     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1 r2 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            r4.invokeOnClose(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.getResult()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = kotlin.coroutines.intrinsics.a.d()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L79
            tb.n40.c(r0)     // Catch: java.lang.Throwable -> L32
        L79:
            if (r4 != r1) goto L7c
            return r1
        L7c:
            r5.invoke()
            tb.wt2 r4 = tb.wt2.INSTANCE
            return r4
        L82:
            r5.invoke()
            throw r4
        L86:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ProduceKt.a(kotlinx.coroutines.channels.ProducerScope, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object b(ProducerScope producerScope, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0<wt2>() { // from class: kotlinx.coroutines.channels.ProduceKt$awaitClose$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        return a(producerScope, function0, continuation);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <E> ReceiveChannel<E> c(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super wt2>, ? extends Object> function2) {
        return d(coroutineScope, coroutineContext, i, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, function2);
    }

    @NotNull
    public static final <E> ReceiveChannel<E> d(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, wt2> function1, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super wt2>, ? extends Object> function2) {
        dv1 dv1Var = new dv1(lo.c(coroutineScope, coroutineContext), ph.b(i, bufferOverflow, null, 4, null));
        if (function1 != null) {
            dv1Var.invokeOnCompletion(function1);
        }
        dv1Var.start(coroutineStart, dv1Var, function2);
        return dv1Var;
    }

    public static /* synthetic */ ReceiveChannel e(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return c(coroutineScope, coroutineContext, i, function2);
    }

    public static /* synthetic */ ReceiveChannel f(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i3 = (i2 & 2) != 0 ? 0 : i;
        if ((i2 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i2 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 16) != 0) {
            function1 = null;
        }
        return d(coroutineScope, coroutineContext2, i3, bufferOverflow2, coroutineStart2, function1, function2);
    }
}
