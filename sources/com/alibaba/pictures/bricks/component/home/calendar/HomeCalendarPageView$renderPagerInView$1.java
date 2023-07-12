package com.alibaba.pictures.bricks.component.home.calendar;

import android.widget.Scroller;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
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
@DebugMetadata(c = "com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1", f = "HomeCalendarPageView.kt", i = {}, l = {44, 45, 48, 49}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class HomeCalendarPageView$renderPagerInView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> $childAdapters;
    final /* synthetic */ Ref$IntRef $scrllor;
    int label;
    final /* synthetic */ HomeCalendarPageView this$0;

    /* compiled from: Taobao */
    @DebugMetadata(c = "com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1$1", f = "HomeCalendarPageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Ref$IntRef $scrllor;
        int label;
        final /* synthetic */ HomeCalendarPageView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HomeCalendarPageView homeCalendarPageView, Ref$IntRef ref$IntRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = homeCalendarPageView;
            this.$scrllor = ref$IntRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1425268812") ? (Continuation) ipChange.ipc$dispatch("1425268812", new Object[]{this, obj, continuation}) : new AnonymousClass1(this.this$0, this.$scrllor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super wt2> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "878756905") ? ipChange.ipc$dispatch("878756905", new Object[]{this, coroutineScope, continuation}) : ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Scroller scroller;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "537809178")) {
                return ipChange.ipc$dispatch("537809178", new Object[]{this, obj});
            }
            b.d();
            if (this.label == 0) {
                i32.b(obj);
                scroller = this.this$0.customScroller;
                if (scroller != null) {
                    scroller.startScroll(0, 0, this.$scrllor.element, 0, 2000);
                    return wt2.INSTANCE;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: Taobao */
    @DebugMetadata(c = "com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1$2", f = "HomeCalendarPageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Ref$IntRef $scrllor;
        int label;
        final /* synthetic */ HomeCalendarPageView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HomeCalendarPageView homeCalendarPageView, Ref$IntRef ref$IntRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = homeCalendarPageView;
            this.$scrllor = ref$IntRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "615781355") ? (Continuation) ipChange.ipc$dispatch("615781355", new Object[]{this, obj, continuation}) : new AnonymousClass2(this.this$0, this.$scrllor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super wt2> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1679292458") ? ipChange.ipc$dispatch("1679292458", new Object[]{this, coroutineScope, continuation}) : ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Scroller scroller;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1231201883")) {
                return ipChange.ipc$dispatch("1231201883", new Object[]{this, obj});
            }
            b.d();
            if (this.label == 0) {
                i32.b(obj);
                scroller = this.this$0.customScroller;
                if (scroller != null) {
                    int i = this.$scrllor.element;
                    scroller.startScroll(i, 0, -i, 0, 2000);
                    return wt2.INSTANCE;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeCalendarPageView$renderPagerInView$1(List<? extends VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list, HomeCalendarPageView homeCalendarPageView, Ref$IntRef ref$IntRef, Continuation<? super HomeCalendarPageView$renderPagerInView$1> continuation) {
        super(2, continuation);
        this.$childAdapters = list;
        this.this$0 = homeCalendarPageView;
        this.$scrllor = ref$IntRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "176873657") ? (Continuation) ipChange.ipc$dispatch("176873657", new Object[]{this, obj, continuation}) : new HomeCalendarPageView$renderPagerInView$1(this.$childAdapters, this.this$0, this.$scrllor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super wt2> continuation) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "60510364") ? ipChange.ipc$dispatch("60510364", new Object[]{this, coroutineScope, continuation}) : ((HomeCalendarPageView$renderPagerInView$1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1.$ipChange
            java.lang.String r1 = "10145101"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L18
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r12
            r2[r5] = r13
            java.lang.Object r13 = r0.ipc$dispatch(r1, r2)
            return r13
        L18:
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r12.label
            r6 = 3000(0xbb8, double:1.482E-320)
            r2 = 0
            r8 = 4
            r9 = 3
            if (r1 == 0) goto L45
            if (r1 == r5) goto L41
            if (r1 == r4) goto L3d
            if (r1 == r9) goto L39
            if (r1 != r8) goto L31
            tb.i32.b(r13)
            goto La3
        L31:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L39:
            tb.i32.b(r13)
            goto L8d
        L3d:
            tb.i32.b(r13)
            goto L84
        L41:
            tb.i32.b(r13)
            goto L6e
        L45:
            tb.i32.b(r13)
            java.util.List<com.youku.arch.v3.adapter.VBaseAdapter<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>>> r13 = r12.$childAdapters
            int r13 = r13.size()
            if (r13 <= r5) goto Laf
            com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$a r13 = com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView.Companion
            boolean r1 = r13.a()
            if (r1 != 0) goto Laf
            java.lang.String r1 = r13.b()
            boolean r1 = com.youku.middlewareservice.provider.kvdata.SPProviderProxy.getPreferenceBoolean(r1)
            if (r1 != 0) goto Laf
            r13.c(r5)
            r12.label = r5
            java.lang.Object r13 = kotlinx.coroutines.j.a(r6, r12)
            if (r13 != r0) goto L6e
            return r0
        L6e:
            tb.uc1 r13 = tb.da0.c()
            com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1$1 r1 = new com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1$1
            com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView r10 = r12.this$0
            kotlin.jvm.internal.Ref$IntRef r11 = r12.$scrllor
            r1.<init>(r10, r11, r2)
            r12.label = r4
            java.lang.Object r13 = kotlinx.coroutines.e.e(r13, r1, r12)
            if (r13 != r0) goto L84
            return r0
        L84:
            r12.label = r9
            java.lang.Object r13 = kotlinx.coroutines.j.a(r6, r12)
            if (r13 != r0) goto L8d
            return r0
        L8d:
            tb.uc1 r13 = tb.da0.c()
            com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1$2 r1 = new com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1$2
            com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView r4 = r12.this$0
            kotlin.jvm.internal.Ref$IntRef r6 = r12.$scrllor
            r1.<init>(r4, r6, r2)
            r12.label = r8
            java.lang.Object r13 = kotlinx.coroutines.e.e(r13, r1, r12)
            if (r13 != r0) goto La3
            return r0
        La3:
            com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$a r13 = com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView.Companion
            r13.c(r3)
            java.lang.String r13 = r13.b()
            com.youku.middlewareservice.provider.kvdata.SPProviderProxy.savePreference(r13, r5)
        Laf:
            tb.wt2 r13 = tb.wt2.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$renderPagerInView$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
