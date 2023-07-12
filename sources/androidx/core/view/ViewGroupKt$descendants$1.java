package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pa2;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Ltb/pa2;", "Landroid/view/View;", "Ltb/wt2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 1, 1}, l = {97, 99}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "$this$sequence", "$this$forEach$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes.dex */
public final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements Function2<pa2<? super View>, Continuation<? super wt2>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGroupKt$descendants$1(ViewGroup viewGroup, Continuation<? super ViewGroupKt$descendants$1> continuation) {
        super(2, continuation);
        this.$this_descendants = viewGroup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.$this_descendants, continuation);
        viewGroupKt$descendants$1.L$0 = obj;
        return viewGroupKt$descendants$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull pa2<? super View> pa2Var, @Nullable Continuation<? super wt2> continuation) {
        return ((ViewGroupKt$descendants$1) create(pa2Var, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009b, code lost:
        if (r4 >= r5) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0090 -> B:23:0x0092). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0098 -> B:25:0x009b). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.C8233a.d()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            int r1 = r10.I$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$1
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            java.lang.Object r6 = r10.L$0
            tb.pa2 r6 = (tb.pa2) r6
            tb.i32.b(r11)
            r7 = r10
            goto L92
        L1f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L27:
            int r1 = r10.I$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$2
            android.view.View r5 = (android.view.View) r5
            java.lang.Object r6 = r10.L$1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            java.lang.Object r7 = r10.L$0
            tb.pa2 r7 = (tb.pa2) r7
            tb.i32.b(r11)
            r11 = r7
            r7 = r10
            goto L72
        L3d:
            tb.i32.b(r11)
            java.lang.Object r11 = r10.L$0
            tb.pa2 r11 = (tb.pa2) r11
            android.view.ViewGroup r1 = r10.$this_descendants
            r4 = 0
            int r5 = r1.getChildCount()
            if (r5 <= 0) goto L9d
            r6 = r10
        L4e:
            int r7 = r4 + 1
            android.view.View r4 = r1.getChildAt(r4)
            java.lang.String r8 = "getChildAt(index)"
            tb.b41.h(r4, r8)
            r6.L$0 = r11
            r6.L$1 = r1
            r6.L$2 = r4
            r6.I$0 = r7
            r6.I$1 = r5
            r6.label = r3
            java.lang.Object r8 = r11.a(r4, r6)
            if (r8 != r0) goto L6c
            return r0
        L6c:
            r9 = r6
            r6 = r1
            r1 = r5
            r5 = r4
            r4 = r7
            r7 = r9
        L72:
            boolean r8 = r5 instanceof android.view.ViewGroup
            if (r8 == 0) goto L98
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            kotlin.sequences.Sequence r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r7.L$0 = r11
            r7.L$1 = r6
            r8 = 0
            r7.L$2 = r8
            r7.I$0 = r4
            r7.I$1 = r1
            r7.label = r2
            java.lang.Object r5 = r11.c(r5, r7)
            if (r5 != r0) goto L90
            return r0
        L90:
            r5 = r6
            r6 = r11
        L92:
            r11 = r6
            r6 = r7
            r9 = r5
            r5 = r1
            r1 = r9
            goto L9b
        L98:
            r5 = r1
            r1 = r6
            r6 = r7
        L9b:
            if (r4 < r5) goto L4e
        L9d:
            tb.wt2 r11 = tb.wt2.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewGroupKt$descendants$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
