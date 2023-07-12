package tb;

import java.util.Set;
import kotlin.collections.C8205f0;
import kotlin.collections.C8212k;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class qq2 {
    @NotNull
    public static final s51 a(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        if (z2 && nullabilityQualifier == NullabilityQualifier.NOT_NULL) {
            return new s51(nullabilityQualifier, mutabilityQualifier, true, z);
        }
        return new s51(nullabilityQualifier, mutabilityQualifier, false, z);
    }

    public static final boolean b(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
        b41.i(typeSystemCommonBackendContext, "<this>");
        b41.i(kotlinTypeMarker, "type");
        hp0 hp0Var = o61.ENHANCED_NULLABILITY_ANNOTATION;
        b41.h(hp0Var, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(kotlinTypeMarker, hp0Var);
    }

    @Nullable
    public static final <T> T c(@NotNull Set<? extends T> set, @NotNull T t, @NotNull T t2, @Nullable T t3, boolean z) {
        Set j;
        Set<? extends T> E0;
        b41.i(set, "<this>");
        b41.i(t, "low");
        b41.i(t2, "high");
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (b41.d(t4, t) && b41.d(t3, t2)) {
                return null;
            }
            return t3 == null ? t4 : t3;
        }
        if (t3 != null) {
            j = C8205f0.j(set, t3);
            E0 = CollectionsKt___CollectionsKt.E0(j);
            if (E0 != null) {
                set = E0;
            }
        }
        return (T) C8212k.r0(set);
    }

    @Nullable
    public static final NullabilityQualifier d(@NotNull Set<? extends NullabilityQualifier> set, @Nullable NullabilityQualifier nullabilityQualifier, boolean z) {
        b41.i(set, "<this>");
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) c(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }
}
