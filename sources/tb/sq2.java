package tb;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class sq2 {
    @NotNull
    private static final te0 a;
    @NotNull
    private static final te0 b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MutabilityQualifier.values().length];
            iArr[MutabilityQualifier.READ_ONLY.ordinal()] = 1;
            iArr[MutabilityQualifier.MUTABLE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NullabilityQualifier.values().length];
            iArr2[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            iArr2[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        hp0 hp0Var = o61.ENHANCED_NULLABILITY_ANNOTATION;
        b41.h(hp0Var, "ENHANCED_NULLABILITY_ANNOTATION");
        a = new te0(hp0Var);
        hp0 hp0Var2 = o61.ENHANCED_MUTABILITY_ANNOTATION;
        b41.h(hp0Var2, "ENHANCED_MUTABILITY_ANNOTATION");
        b = new te0(hp0Var2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Annotations d(List<? extends Annotations> list) {
        List A0;
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                A0 = CollectionsKt___CollectionsKt.A0(list);
                return new CompositeAnnotations(A0);
            }
            return (Annotations) kotlin.collections.k.q0(list);
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ue0<ClassifierDescriptor> e(ClassifierDescriptor classifierDescriptor, s51 s51Var, TypeComponentPosition typeComponentPosition) {
        if (nq2.a(typeComponentPosition) && (classifierDescriptor instanceof ClassDescriptor)) {
            p51 p51Var = p51.INSTANCE;
            MutabilityQualifier b2 = s51Var.b();
            int i = b2 == null ? -1 : a.$EnumSwitchMapping$0[b2.ordinal()];
            if (i != 1) {
                if (i == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                    ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                    if (p51Var.e(classDescriptor)) {
                        return f(p51Var.b(classDescriptor));
                    }
                }
            } else if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
                if (p51Var.c(classDescriptor2)) {
                    return f(p51Var.a(classDescriptor2));
                }
            }
            return j(classifierDescriptor);
        }
        return j(classifierDescriptor);
    }

    private static final <T> ue0<T> f(T t) {
        return new ue0<>(t, b);
    }

    private static final <T> ue0<T> g(T t) {
        return new ue0<>(t, a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ue0<Boolean> h(z71 z71Var, s51 s51Var, TypeComponentPosition typeComponentPosition) {
        if (nq2.a(typeComponentPosition)) {
            NullabilityQualifier c = s51Var.c();
            int i = c == null ? -1 : a.$EnumSwitchMapping$1[c.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return j(Boolean.valueOf(z71Var.d()));
                }
                return g(Boolean.FALSE);
            }
            return g(Boolean.TRUE);
        }
        return j(Boolean.valueOf(z71Var.d()));
    }

    public static final boolean i(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return qq2.b(xc2.INSTANCE, z71Var);
    }

    private static final <T> ue0<T> j(T t) {
        return new ue0<>(t, null);
    }
}
