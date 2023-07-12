package kotlin.collections;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.v1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class AbstractMap$toString$1 extends Lambda implements Function1<Map.Entry<Object, Object>, CharSequence> {
    final /* synthetic */ v1<Object, Object> this$0;

    AbstractMap$toString$1(v1<Object, Object> v1Var) {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final CharSequence invoke(@NotNull Map.Entry<Object, Object> entry) {
        b41.i(entry, AdvanceSetting.NETWORK_TYPE);
        return v1.a(this.this$0, entry);
    }
}
