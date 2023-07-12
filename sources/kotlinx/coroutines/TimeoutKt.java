package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.d61;
import tb.st2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class TimeoutKt {
    @NotNull
    public static final TimeoutCancellationException a(long j, @NotNull Job job) {
        return new TimeoutCancellationException("Timed out waiting for " + j + " ms", job);
    }

    private static final <U, T extends U> Object b(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        d61.e(timeoutCoroutine, j.b(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.getContext()));
        return st2.f(timeoutCoroutine, timeoutCoroutine, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.TimeoutCoroutine, T] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object c(long r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            java.lang.Object r8 = r0.L$0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            tb.i32.b(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L32
            goto L6d
        L32:
            r8 = move-exception
            goto L70
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            tb.i32.b(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L46
            return r4
        L46:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r10.element = r4
            r0.J$0 = r7     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r0.L$0 = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r0.L$1 = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r0.label = r3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            kotlinx.coroutines.TimeoutCoroutine r2 = new kotlinx.coroutines.TimeoutCoroutine     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r10.element = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            java.lang.Object r7 = b(r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            java.lang.Object r8 = kotlin.coroutines.intrinsics.a.d()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            if (r7 != r8) goto L69
            tb.n40.c(r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
        L69:
            if (r7 != r1) goto L6c
            return r1
        L6c:
            r10 = r7
        L6d:
            return r10
        L6e:
            r8 = move-exception
            r7 = r10
        L70:
            kotlinx.coroutines.Job r9 = r8.coroutine
            T r7 = r7.element
            kotlinx.coroutines.TimeoutCoroutine r7 = (kotlinx.coroutines.TimeoutCoroutine) r7
            if (r9 != r7) goto L79
            return r4
        L79:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.c(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
