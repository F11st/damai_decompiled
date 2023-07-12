package tb;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.o51;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ar2 {
    @NotNull
    public static final <T> T a(@NotNull JvmTypeFactory<T> jvmTypeFactory, @NotNull T t, boolean z) {
        b41.i(jvmTypeFactory, "<this>");
        b41.i(t, "possiblyPrimitiveType");
        return z ? jvmTypeFactory.boxType(t) : t;
    }

    @Nullable
    public static final <T> T b(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull JvmTypeFactory<T> jvmTypeFactory, @NotNull vq2 vq2Var) {
        b41.i(typeSystemCommonBackendContext, "<this>");
        b41.i(kotlinTypeMarker, "type");
        b41.i(jvmTypeFactory, "typeFactory");
        b41.i(vq2Var, "mode");
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructor)) {
            PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructor);
            boolean z = true;
            if (primitiveType != null) {
                T createPrimitiveType = jvmTypeFactory.createPrimitiveType(primitiveType);
                if (!typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) && !qq2.b(typeSystemCommonBackendContext, kotlinTypeMarker)) {
                    z = false;
                }
                return (T) a(jvmTypeFactory, createPrimitiveType, z);
            }
            PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructor);
            if (primitiveArrayType != null) {
                return jvmTypeFactory.createFromString(b41.r(jn1.ARRAY_START_STR, JvmPrimitiveType.get(primitiveArrayType).getDesc()));
            }
            if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructor)) {
                ip0 classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructor);
                hj o = classFqNameUnsafe == null ? null : o51.INSTANCE.o(classFqNameUnsafe);
                if (o != null) {
                    if (!vq2Var.a()) {
                        List<o51.C9506a> j = o51.INSTANCE.j();
                        if (!(j instanceof Collection) || !j.isEmpty()) {
                            for (o51.C9506a c9506a : j) {
                                if (b41.d(c9506a.d(), o)) {
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            return null;
                        }
                    }
                    String f = t61.b(o).f();
                    b41.h(f, "byClassId(classId).internalName");
                    return jvmTypeFactory.createObjectType(f);
                }
            }
            return null;
        }
        return null;
    }
}
