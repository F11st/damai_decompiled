package kotlin.sequences;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$onEachIndexed$1 extends Lambda implements Function2<Integer, Object, Object> {
    final /* synthetic */ Function2<Integer, Object, wt2> $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$onEachIndexed$1(Function2<? super Integer, Object, wt2> function2) {
        super(2);
        this.$action = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Object obj) {
        return invoke(num.intValue(), obj);
    }

    public final Object invoke(int i, Object obj) {
        this.$action.invoke(Integer.valueOf(i), obj);
        return obj;
    }
}
