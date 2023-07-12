package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.c51;
import tb.fm1;
import tb.n51;
import tb.r81;
import tb.t51;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ContextKt {
    private static final r81 a(r81 r81Var, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, Lazy<t51> lazy) {
        n51 a = r81Var.a();
        LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = javaTypeParameterListOwner == null ? null : new LazyJavaTypeParameterResolver(r81Var, declarationDescriptor, javaTypeParameterListOwner, i);
        if (lazyJavaTypeParameterResolver == null) {
            lazyJavaTypeParameterResolver = r81Var.f();
        }
        return new r81(a, lazyJavaTypeParameterResolver, lazy);
    }

    @NotNull
    public static final r81 b(@NotNull r81 r81Var, @NotNull TypeParameterResolver typeParameterResolver) {
        b41.i(r81Var, "<this>");
        b41.i(typeParameterResolver, "typeParameterResolver");
        return new r81(r81Var.a(), typeParameterResolver, r81Var.c());
    }

    @NotNull
    public static final r81 c(@NotNull final r81 r81Var, @NotNull final ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, @Nullable JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        Lazy a;
        b41.i(r81Var, "<this>");
        b41.i(classOrPackageFragmentDescriptor, "containingDeclaration");
        a = b.a(LazyThreadSafetyMode.NONE, new Function0<t51>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$childForClassOrPackage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final t51 invoke() {
                return ContextKt.g(r81.this, classOrPackageFragmentDescriptor.getAnnotations());
            }
        });
        return a(r81Var, classOrPackageFragmentDescriptor, javaTypeParameterListOwner, i, a);
    }

    public static /* synthetic */ r81 d(r81 r81Var, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            javaTypeParameterListOwner = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return c(r81Var, classOrPackageFragmentDescriptor, javaTypeParameterListOwner, i);
    }

    @NotNull
    public static final r81 e(@NotNull r81 r81Var, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        b41.i(r81Var, "<this>");
        b41.i(declarationDescriptor, "containingDeclaration");
        b41.i(javaTypeParameterListOwner, "typeParameterOwner");
        return a(r81Var, declarationDescriptor, javaTypeParameterListOwner, i, r81Var.c());
    }

    public static /* synthetic */ r81 f(r81 r81Var, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return e(r81Var, declarationDescriptor, javaTypeParameterListOwner, i);
    }

    @Nullable
    public static final t51 g(@NotNull r81 r81Var, @NotNull Annotations annotations) {
        EnumMap<AnnotationQualifierApplicabilityType, c51> b;
        b41.i(r81Var, "<this>");
        b41.i(annotations, "additionalAnnotations");
        if (r81Var.a().i().b()) {
            return r81Var.b();
        }
        ArrayList<c51> arrayList = new ArrayList();
        Iterator<AnnotationDescriptor> it = annotations.iterator();
        while (it.hasNext()) {
            c51 i = i(r81Var, it.next());
            if (i != null) {
                arrayList.add(i);
            }
        }
        if (arrayList.isEmpty()) {
            return r81Var.b();
        }
        t51 b2 = r81Var.b();
        EnumMap enumMap = null;
        if (b2 != null && (b = b2.b()) != null) {
            enumMap = new EnumMap((EnumMap) b);
        }
        if (enumMap == null) {
            enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
        }
        boolean z = false;
        for (c51 c51Var : arrayList) {
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : c51Var.g()) {
                enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) c51Var);
                z = true;
            }
        }
        return !z ? r81Var.b() : new t51(enumMap);
    }

    @NotNull
    public static final r81 h(@NotNull final r81 r81Var, @NotNull final Annotations annotations) {
        Lazy a;
        b41.i(r81Var, "<this>");
        b41.i(annotations, "additionalAnnotations");
        if (annotations.isEmpty()) {
            return r81Var;
        }
        n51 a2 = r81Var.a();
        TypeParameterResolver f = r81Var.f();
        a = b.a(LazyThreadSafetyMode.NONE, new Function0<t51>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$copyWithNewDefaultTypeQualifiers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final t51 invoke() {
                return ContextKt.g(r81.this, annotations);
            }
        });
        return new r81(a2, f, a);
    }

    private static final c51 i(r81 r81Var, AnnotationDescriptor annotationDescriptor) {
        AnnotationTypeQualifierResolver a = r81Var.a().a();
        c51 l = a.l(annotationDescriptor);
        if (l == null) {
            AnnotationTypeQualifierResolver.a n = a.n(annotationDescriptor);
            if (n == null) {
                return null;
            }
            AnnotationDescriptor a2 = n.a();
            List<AnnotationQualifierApplicabilityType> b = n.b();
            ReportLevel k = a.k(annotationDescriptor);
            if (k == null) {
                k = a.j(a2);
            }
            if (k.isIgnore()) {
                return null;
            }
            fm1 h = r81Var.a().r().h(a2, r81Var.a().q().getTypeEnhancementImprovementsInStrictMode(), false);
            fm1 b2 = h == null ? null : fm1.b(h, null, k.isWarning(), 1, null);
            if (b2 == null) {
                return null;
            }
            return new c51(b2, b, false, false, 12, null);
        }
        return l;
    }

    @NotNull
    public static final r81 j(@NotNull r81 r81Var, @NotNull n51 n51Var) {
        b41.i(r81Var, "<this>");
        b41.i(n51Var, Constants.COMPONENT);
        return new r81(n51Var, r81Var.f(), r81Var.c());
    }
}
