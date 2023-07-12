package tb;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class rc2 {
    @NotNull
    public static final rc2 INSTANCE = new rc2();

    private rc2() {
    }

    @NotNull
    public final String a(@NotNull Constructor<?> constructor) {
        b41.i(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.BRACKET_START_STR);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        b41.h(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            b41.h(cls, "parameterType");
            sb.append(ReflectClassUtilKt.b(cls));
        }
        sb.append(")V");
        String sb2 = sb.toString();
        b41.h(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    public final String b(@NotNull Field field) {
        b41.i(field, "field");
        Class<?> type = field.getType();
        b41.h(type, "field.type");
        return ReflectClassUtilKt.b(type);
    }

    @NotNull
    public final String c(@NotNull Method method) {
        b41.i(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.BRACKET_START_STR);
        Class<?>[] parameterTypes = method.getParameterTypes();
        b41.h(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            b41.h(cls, "parameterType");
            sb.append(ReflectClassUtilKt.b(cls));
        }
        sb.append(jn1.BRACKET_END_STR);
        Class<?> returnType = method.getReturnType();
        b41.h(returnType, "method.returnType");
        sb.append(ReflectClassUtilKt.b(returnType));
        String sb2 = sb.toString();
        b41.h(sb2, "sb.toString()");
        return sb2;
    }
}
