package com.alibaba.pictures.bricks.component.home;

import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.wt2;

/* compiled from: Taobao */
@DebugMetadata(c = "com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3", f = "HorizontalPageView.kt", i = {}, l = {137, SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR, 141, 142}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class HorizontalPageView$bindView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Ref$IntRef $scrllor;
    int label;
    final /* synthetic */ HorizontalPageView this$0;

    /* compiled from: Taobao */
    @DebugMetadata(c = "com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3$1", f = "HorizontalPageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Ref$IntRef $scrllor;
        int label;
        final /* synthetic */ HorizontalPageView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HorizontalPageView horizontalPageView, Ref$IntRef ref$IntRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = horizontalPageView;
            this.$scrllor = ref$IntRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-476665679") ? (Continuation) ipChange.ipc$dispatch("-476665679", new Object[]{this, obj, continuation}) : new AnonymousClass1(this.this$0, this.$scrllor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super wt2> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-443095644") ? ipChange.ipc$dispatch("-443095644", new Object[]{this, coroutineScope, continuation}) : ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "210873429")) {
                return ipChange.ipc$dispatch("210873429", new Object[]{this, obj});
            }
            C8234b.d();
            if (this.label == 0) {
                i32.b(obj);
                this.this$0.getRecyclerView().smoothScrollBy(this.$scrllor.element, 0, null, 1500);
                return wt2.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: Taobao */
    @DebugMetadata(c = "com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3$2", f = "HorizontalPageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Ref$IntRef $scrllor;
        int label;
        final /* synthetic */ HorizontalPageView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HorizontalPageView horizontalPageView, Ref$IntRef ref$IntRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = horizontalPageView;
            this.$scrllor = ref$IntRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1286153136") ? (Continuation) ipChange.ipc$dispatch("-1286153136", new Object[]{this, obj, continuation}) : new AnonymousClass2(this.this$0, this.$scrllor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super wt2> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "357439909") ? ipChange.ipc$dispatch("357439909", new Object[]{this, coroutineScope, continuation}) : ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "904266134")) {
                return ipChange.ipc$dispatch("904266134", new Object[]{this, obj});
            }
            C8234b.d();
            if (this.label == 0) {
                i32.b(obj);
                this.this$0.getRecyclerView().smoothScrollBy(-this.$scrllor.element, 0, null, 1500);
                return wt2.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalPageView$bindView$3(HorizontalPageView horizontalPageView, Ref$IntRef ref$IntRef, Continuation<? super HorizontalPageView$bindView$3> continuation) {
        super(2, continuation);
        this.this$0 = horizontalPageView;
        this.$scrllor = ref$IntRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1885438370") ? (Continuation) ipChange.ipc$dispatch("-1885438370", new Object[]{this, obj, continuation}) : new HorizontalPageView$bindView$3(this.this$0, this.$scrllor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super wt2> continuation) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1230083287") ? ipChange.ipc$dispatch("1230083287", new Object[]{this, coroutineScope, continuation}) : ((HorizontalPageView$bindView$3) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3.$ipChange
            java.lang.String r1 = "1931590472"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L18
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r10
            r2[r5] = r11
            java.lang.Object r11 = r0.ipc$dispatch(r1, r2)
            return r11
        L18:
            java.lang.Object r0 = kotlin.coroutines.intrinsics.C8233a.d()
            int r1 = r10.label
            r2 = 0
            r6 = 4
            r7 = 3
            if (r1 == 0) goto L43
            if (r1 == r5) goto L3f
            if (r1 == r4) goto L3b
            if (r1 == r7) goto L37
            if (r1 != r6) goto L2f
            tb.i32.b(r11)
            goto L8d
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L37:
            tb.i32.b(r11)
            goto L77
        L3b:
            tb.i32.b(r11)
            goto L6c
        L3f:
            tb.i32.b(r11)
            goto L56
        L43:
            tb.i32.b(r11)
            com.alibaba.pictures.bricks.component.home.HorizontalPageView$a r11 = com.alibaba.pictures.bricks.component.home.HorizontalPageView.Companion
            r11.b(r5)
            r8 = 3000(0xbb8, double:1.482E-320)
            r10.label = r5
            java.lang.Object r11 = kotlinx.coroutines.C8696j.a(r8, r10)
            if (r11 != r0) goto L56
            return r0
        L56:
            tb.uc1 r11 = tb.da0.c()
            com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3$1 r1 = new com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3$1
            com.alibaba.pictures.bricks.component.home.HorizontalPageView r8 = r10.this$0
            kotlin.jvm.internal.Ref$IntRef r9 = r10.$scrllor
            r1.<init>(r8, r9, r2)
            r10.label = r4
            java.lang.Object r11 = kotlinx.coroutines.C8658e.e(r11, r1, r10)
            if (r11 != r0) goto L6c
            return r0
        L6c:
            r8 = 2000(0x7d0, double:9.88E-321)
            r10.label = r7
            java.lang.Object r11 = kotlinx.coroutines.C8696j.a(r8, r10)
            if (r11 != r0) goto L77
            return r0
        L77:
            tb.uc1 r11 = tb.da0.c()
            com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3$2 r1 = new com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3$2
            com.alibaba.pictures.bricks.component.home.HorizontalPageView r4 = r10.this$0
            kotlin.jvm.internal.Ref$IntRef r7 = r10.$scrllor
            r1.<init>(r4, r7, r2)
            r10.label = r6
            java.lang.Object r11 = kotlinx.coroutines.C8658e.e(r11, r1, r10)
            if (r11 != r0) goto L8d
            return r0
        L8d:
            com.alibaba.pictures.bricks.component.home.HorizontalPageView$a r11 = com.alibaba.pictures.bricks.component.home.HorizontalPageView.Companion
            r11.b(r3)
            java.lang.String r11 = r11.a()
            com.youku.middlewareservice.provider.kvdata.SPProviderProxy.savePreference(r11, r5)
            tb.wt2 r11 = tb.wt2.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
