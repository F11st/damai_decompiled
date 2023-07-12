package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    @Nullable
    public static final <T> Object a(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object b = b(flowCollector, receiveChannel, true, continuation);
        d = kotlin.coroutines.intrinsics.b.d();
        return b == d ? b : wt2.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #1 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007d, B:29:0x0083, B:35:0x0091, B:36:0x0092, B:18:0x0059), top: B:48:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #1 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007d, B:29:0x0083, B:35:0x0091, B:36:0x0092, B:18:0x0059), top: B:48:0x0022 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a6 -> B:14:0x0039). Please submit an issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r8, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends T> r9, boolean r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super tb.wt2> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5f
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r8 = r0.L$2
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            tb.i32.b(r11)     // Catch: java.lang.Throwable -> L5d
        L39:
            r11 = r8
            r8 = r2
            r6 = r10
            r10 = r9
            r9 = r6
            goto L63
        L3f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L47:
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r8 = r0.L$2
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            tb.i32.b(r11)     // Catch: java.lang.Throwable -> L5d
            goto L7d
        L5d:
            r8 = move-exception
            goto Lad
        L5f:
            tb.i32.b(r11)
            r11 = 0
        L63:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> La9
            r0.L$1 = r9     // Catch: java.lang.Throwable -> La9
            r0.Z$0 = r10     // Catch: java.lang.Throwable -> La9
            r0.L$2 = r11     // Catch: java.lang.Throwable -> La9
            r0.L$3 = r8     // Catch: java.lang.Throwable -> La9
            r0.label = r4     // Catch: java.lang.Throwable -> La9
            java.lang.Object r2 = r9.mo1285receiveOrClosedZYPwvRU(r0)     // Catch: java.lang.Throwable -> La9
            if (r2 != r1) goto L76
            return r1
        L76:
            r6 = r2
            r2 = r8
            r8 = r11
            r11 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L7d:
            boolean r5 = tb.yw2.g(r11)     // Catch: java.lang.Throwable -> L5d
            if (r5 == 0) goto L92
            java.lang.Throwable r11 = tb.yw2.d(r11)     // Catch: java.lang.Throwable -> L5d
            if (r11 != 0) goto L91
            if (r9 == 0) goto L8e
            kotlinx.coroutines.channels.b.j(r10, r8)
        L8e:
            tb.wt2 r8 = tb.wt2.INSTANCE
            return r8
        L91:
            throw r11     // Catch: java.lang.Throwable -> L5d
        L92:
            java.lang.Object r5 = tb.yw2.e(r11)     // Catch: java.lang.Throwable -> L5d
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L5d
            r0.L$1 = r10     // Catch: java.lang.Throwable -> L5d
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L5d
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L5d
            r0.L$3 = r11     // Catch: java.lang.Throwable -> L5d
            r0.label = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r11 = r2.emit(r5, r0)     // Catch: java.lang.Throwable -> L5d
            if (r11 != r1) goto L39
            return r1
        La9:
            r8 = move-exception
            r6 = r10
            r10 = r9
            r9 = r6
        Lad:
            throw r8     // Catch: java.lang.Throwable -> Lae
        Lae:
            r11 = move-exception
            if (r9 == 0) goto Lb4
            kotlinx.coroutines.channels.b.j(r10, r8)
        Lb4:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.b(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
