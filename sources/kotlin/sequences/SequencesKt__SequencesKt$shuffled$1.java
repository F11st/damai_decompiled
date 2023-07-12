package kotlin.sequences;

import java.util.List;
import kotlin.collections.k;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.pa2;
import tb.wt2;

/* compiled from: Taobao */
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements Function2<pa2<Object>, Continuation<? super wt2>, Object> {
    final /* synthetic */ Random $random;
    final /* synthetic */ Sequence<Object> $this_shuffled;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$shuffled$1(Sequence<Object> sequence, Random random, Continuation<? super SequencesKt__SequencesKt$shuffled$1> continuation) {
        super(2, continuation);
        this.$this_shuffled = sequence;
        this.$random = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, continuation);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull pa2<Object> pa2Var, @Nullable Continuation<? super wt2> continuation) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(pa2Var, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d;
        List C;
        pa2 pa2Var;
        d = kotlin.coroutines.intrinsics.b.d();
        int i = this.label;
        if (i == 0) {
            i32.b(obj);
            C = SequencesKt___SequencesKt.C(this.$this_shuffled);
            pa2Var = (pa2) this.L$0;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            C = (List) this.L$1;
            pa2Var = (pa2) this.L$0;
            i32.b(obj);
        }
        while (!C.isEmpty()) {
            int nextInt = this.$random.nextInt(C.size());
            Object y = k.y(C);
            if (nextInt < C.size()) {
                y = C.set(nextInt, y);
            }
            this.L$0 = pa2Var;
            this.L$1 = C;
            this.label = 1;
            if (pa2Var.a(y, this) == d) {
                return d;
            }
        }
        return wt2.INSTANCE;
    }
}
