package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements Function1<Object, Object> {
    final /* synthetic */ Function1<Object, wt2> $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$onEach$1(Function1<Object, wt2> function1) {
        super(1);
        this.$action = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.$action.invoke(obj);
        return obj;
    }
}
