package kotlin.reflect.full;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/reflect/KClass;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Lkotlin/reflect/KClass;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class KClasses$isSubclassOf$2 extends Lambda implements Function1<KClass<?>, Boolean> {
    final /* synthetic */ KClass $base;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KClasses$isSubclassOf$2(KClass kClass) {
        super(1);
        this.$base = kClass;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(KClass<?> kClass) {
        return Boolean.valueOf(b41.d(kClass, this.$base));
    }
}
