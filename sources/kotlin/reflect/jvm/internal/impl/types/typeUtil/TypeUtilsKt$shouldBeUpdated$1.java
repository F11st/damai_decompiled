package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.a81;
import tb.b41;
import tb.ci2;
import tb.gu2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class TypeUtilsKt$shouldBeUpdated$1 extends Lambda implements Function1<gu2, Boolean> {
    public static final TypeUtilsKt$shouldBeUpdated$1 INSTANCE = new TypeUtilsKt$shouldBeUpdated$1();

    TypeUtilsKt$shouldBeUpdated$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull gu2 gu2Var) {
        b41.i(gu2Var, AdvanceSetting.NETWORK_TYPE);
        return Boolean.valueOf((gu2Var instanceof ci2) || (gu2Var.c() instanceof TypeVariableTypeConstructorMarker) || a81.a(gu2Var));
    }
}
