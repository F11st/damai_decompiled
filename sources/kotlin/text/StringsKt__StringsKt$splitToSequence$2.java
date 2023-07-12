package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.n31;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements Function1<n31, String> {
    final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        super(1);
        this.$this_splitToSequence = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final String invoke(@NotNull n31 n31Var) {
        b41.i(n31Var, AdvanceSetting.NETWORK_TYPE);
        return StringsKt__StringsKt.A0(this.$this_splitToSequence, n31Var);
    }
}
