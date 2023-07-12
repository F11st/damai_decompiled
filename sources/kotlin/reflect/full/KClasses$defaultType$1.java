package kotlin.reflect.full;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Type;", "invoke", "()Ljava/lang/reflect/Type;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class KClasses$defaultType$1 extends Lambda implements Function0<Type> {
    final /* synthetic */ KClass $this_defaultType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KClasses$defaultType$1(KClass kClass) {
        super(0);
        this.$this_defaultType = kClass;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Type invoke() {
        return ((KClassImpl) this.$this_defaultType).getJClass();
    }
}
