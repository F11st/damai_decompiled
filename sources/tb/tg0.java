package tb;

import java.util.HashSet;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class tg0 {
    @Nullable
    public static final KotlinTypeMarker a(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
        b41.i(typeSystemCommonBackendContext, "<this>");
        b41.i(kotlinTypeMarker, "inlineClassType");
        return b(typeSystemCommonBackendContext, kotlinTypeMarker, new HashSet());
    }

    private static final KotlinTypeMarker b(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, HashSet<TypeConstructorMarker> hashSet) {
        KotlinTypeMarker b;
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (hashSet.add(typeConstructor)) {
            TypeParameterMarker typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(typeConstructor);
            if (typeParameterClassifier != null) {
                b = b(typeSystemCommonBackendContext, typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier), hashSet);
                if (b == null) {
                    return null;
                }
                if (!typeSystemCommonBackendContext.isNullableType(b) && typeSystemCommonBackendContext.isMarkedNullable(kotlinTypeMarker)) {
                    return typeSystemCommonBackendContext.makeNullable(b);
                }
            } else if (!typeSystemCommonBackendContext.isInlineClass(typeConstructor)) {
                return kotlinTypeMarker;
            } else {
                KotlinTypeMarker substitutedUnderlyingType = typeSystemCommonBackendContext.getSubstitutedUnderlyingType(kotlinTypeMarker);
                if (substitutedUnderlyingType == null || (b = b(typeSystemCommonBackendContext, substitutedUnderlyingType, hashSet)) == null) {
                    return null;
                }
                if (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker)) {
                    return typeSystemCommonBackendContext.isNullableType(b) ? kotlinTypeMarker : ((b instanceof SimpleTypeMarker) && typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) b)) ? kotlinTypeMarker : typeSystemCommonBackendContext.makeNullable(b);
                }
            }
            return b;
        }
        return null;
    }
}
