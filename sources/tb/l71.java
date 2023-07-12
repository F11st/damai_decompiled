package tb;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.JvmName;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmName(name = "KTypesJvm")
/* loaded from: classes3.dex */
public final class l71 {
    @NotNull
    public static final KClass<?> a(@NotNull KClassifier kClassifier) {
        Object obj;
        KClass<?> b;
        boolean z;
        b41.i(kClassifier, "$this$jvmErasure");
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (kClassifier instanceof KTypeParameter) {
            List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                KType kType = (KType) next;
                Objects.requireNonNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                Object declarationDescriptor = ((KTypeImpl) kType).c().c().getDeclarationDescriptor();
                ClassDescriptor classDescriptor = (ClassDescriptor) (declarationDescriptor instanceof ClassDescriptor ? declarationDescriptor : null);
                if (classDescriptor == null || classDescriptor.getKind() == ClassKind.INTERFACE || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            KType kType2 = (KType) obj;
            if (kType2 == null) {
                kType2 = (KType) kotlin.collections.k.R(upperBounds);
            }
            return (kType2 == null || (b = b(kType2)) == null) ? a12.b(Object.class) : b;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kClassifier);
    }

    @NotNull
    public static final KClass<?> b(@NotNull KType kType) {
        KClass<?> a;
        b41.i(kType, "$this$jvmErasure");
        KClassifier classifier = kType.getClassifier();
        if (classifier == null || (a = a(classifier)) == null) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kType);
        }
        return a;
    }
}
