package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.Method;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class RuntimeTypeMapperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Method method) {
        String F;
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        b41.h(parameterTypes, "parameterTypes");
        F = ArraysKt___ArraysKt.F(parameterTypes, "", jn1.BRACKET_START_STR, jn1.BRACKET_END_STR, 0, null, new Function1<Class<?>, CharSequence>() { // from class: kotlin.reflect.jvm.internal.RuntimeTypeMapperKt$signature$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(Class<?> cls) {
                b41.h(cls, AdvanceSetting.NETWORK_TYPE);
                return ReflectClassUtilKt.b(cls);
            }
        }, 24, null);
        sb.append(F);
        Class<?> returnType = method.getReturnType();
        b41.h(returnType, "returnType");
        sb.append(ReflectClassUtilKt.b(returnType));
        return sb.toString();
    }
}
