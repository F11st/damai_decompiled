package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import tb.pt2;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0006\b\u0002\u0010\u0002 \u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"P", "Q", "R", "Ltb/wt2;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes11.dex */
final class UnbiasedSelectBuilderImpl$invoke$3 extends Lambda implements Function0<wt2> {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ Object $param;
    final /* synthetic */ SelectClause2 $this_invoke;
    final /* synthetic */ pt2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UnbiasedSelectBuilderImpl$invoke$3(pt2 pt2Var, SelectClause2 selectClause2, Object obj, Function2 function2) {
        super(0);
        this.$this_invoke = selectClause2;
        this.$param = obj;
        this.$block = function2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ wt2 invoke() {
        invoke2();
        return wt2.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        throw null;
    }
}
