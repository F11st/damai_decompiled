package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.i21;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements Function1<i21<Object>, Boolean> {
    final /* synthetic */ Function2<Integer, Object, Boolean> $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$filterIndexed$1(Function2<? super Integer, Object, Boolean> function2) {
        super(1);
        this.$predicate = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull i21<Object> i21Var) {
        b41.i(i21Var, AdvanceSetting.NETWORK_TYPE);
        return this.$predicate.invoke(Integer.valueOf(i21Var.c()), i21Var.d());
    }
}
