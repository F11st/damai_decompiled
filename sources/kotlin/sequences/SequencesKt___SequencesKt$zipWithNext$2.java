package kotlin.sequences;

import com.taobao.weex.ui.component.AbstractEditComponent;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.pa2;
import tb.wt2;

/* compiled from: Taobao */
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2864}, m = "invokeSuspend", n = {"$this$result", "iterator", AbstractEditComponent.ReturnTypes.NEXT}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements Function2<pa2<Object>, Continuation<? super wt2>, Object> {
    final /* synthetic */ Sequence<Object> $this_zipWithNext;
    final /* synthetic */ Function2<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$zipWithNext$2(Sequence<Object> sequence, Function2<Object, Object, Object> function2, Continuation<? super SequencesKt___SequencesKt$zipWithNext$2> continuation) {
        super(2, continuation);
        this.$this_zipWithNext = sequence;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, continuation);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull pa2<Object> pa2Var, @Nullable Continuation<? super wt2> continuation) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(pa2Var, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d;
        pa2 pa2Var;
        Object next;
        Iterator<Object> it;
        d = kotlin.coroutines.intrinsics.b.d();
        int i = this.label;
        if (i == 0) {
            i32.b(obj);
            pa2 pa2Var2 = (pa2) this.L$0;
            Iterator<Object> it2 = this.$this_zipWithNext.iterator();
            if (!it2.hasNext()) {
                return wt2.INSTANCE;
            }
            pa2Var = pa2Var2;
            next = it2.next();
            it = it2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object obj2 = this.L$2;
            it = (Iterator) this.L$1;
            pa2Var = (pa2) this.L$0;
            i32.b(obj);
            next = obj2;
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            Object invoke = this.$transform.invoke(next, next2);
            this.L$0 = pa2Var;
            this.L$1 = it;
            this.L$2 = next2;
            this.label = 1;
            if (pa2Var.a(invoke, this) == d) {
                return d;
            }
            next = next2;
        }
        return wt2.INSTANCE;
    }
}
