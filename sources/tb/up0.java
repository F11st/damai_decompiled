package tb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8212k;
import kotlin.collections.C8214m;
import kotlin.collections.C8225w;
import kotlin.collections.C8226x;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class up0 {
    @JvmOverloads
    @NotNull
    public static final fd2 a(@NotNull AbstractC8271b abstractC8271b, @NotNull Annotations annotations, @Nullable z71 z71Var, @NotNull List<? extends z71> list, @Nullable List<ni1> list2, @NotNull z71 z71Var2, boolean z) {
        b41.i(abstractC8271b, "builtIns");
        b41.i(annotations, "annotations");
        b41.i(list, "parameterTypes");
        b41.i(z71Var2, "returnType");
        List<TypeProjection> e = e(z71Var, list, list2, z71Var2, abstractC8271b);
        int size = list.size();
        if (z71Var != null) {
            size++;
        }
        ClassDescriptor d = d(abstractC8271b, size, z);
        if (z71Var != null) {
            annotations = q(annotations, abstractC8271b);
        }
        return KotlinTypeFactory.g(annotations, d, e);
    }

    public static /* synthetic */ fd2 b(AbstractC8271b abstractC8271b, Annotations annotations, z71 z71Var, List list, List list2, z71 z71Var2, boolean z, int i, Object obj) {
        return a(abstractC8271b, annotations, z71Var, list, list2, z71Var2, (i & 64) != 0 ? false : z);
    }

    @Nullable
    public static final ni1 c(@NotNull z71 z71Var) {
        String b;
        b41.i(z71Var, "<this>");
        AnnotationDescriptor findAnnotation = z71Var.getAnnotations().findAnnotation(C8277c.C8278a.parameterName);
        if (findAnnotation == null) {
            return null;
        }
        Object r0 = C8212k.r0(findAnnotation.getAllValueArguments().values());
        ai2 ai2Var = r0 instanceof ai2 ? (ai2) r0 : null;
        if (ai2Var == null || (b = ai2Var.b()) == null || !ni1.h(b)) {
            b = null;
        }
        if (b == null) {
            return null;
        }
        return ni1.f(b);
    }

    @NotNull
    public static final ClassDescriptor d(@NotNull AbstractC8271b abstractC8271b, int i, boolean z) {
        b41.i(abstractC8271b, "builtIns");
        ClassDescriptor X = z ? abstractC8271b.X(i) : abstractC8271b.C(i);
        b41.h(X, "if (isSuspendFunction) b…tFunction(parameterCount)");
        return X;
    }

    @NotNull
    public static final List<TypeProjection> e(@Nullable z71 z71Var, @NotNull List<? extends z71> list, @Nullable List<ni1> list2, @NotNull z71 z71Var2, @NotNull AbstractC8271b abstractC8271b) {
        ni1 ni1Var;
        Map f;
        List<? extends AnnotationDescriptor> l0;
        b41.i(list, "parameterTypes");
        b41.i(z71Var2, "returnType");
        b41.i(abstractC8271b, "builtIns");
        int i = 0;
        ArrayList arrayList = new ArrayList(list.size() + (z71Var != null ? 1 : 0) + 1);
        kk.a(arrayList, z71Var == null ? null : TypeUtilsKt.a(z71Var));
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                C8214m.p();
            }
            z71 z71Var3 = (z71) obj;
            if (list2 == null || (ni1Var = list2.get(i)) == null || ni1Var.g()) {
                ni1Var = null;
            }
            if (ni1Var != null) {
                hp0 hp0Var = C8277c.C8278a.parameterName;
                ni1 f2 = ni1.f("name");
                String b = ni1Var.b();
                b41.h(b, "name.asString()");
                f = C8225w.f(hq2.a(f2, new ai2(b)));
                BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(abstractC8271b, hp0Var, f);
                Annotations.C8302a c8302a = Annotations.Companion;
                l0 = CollectionsKt___CollectionsKt.l0(z71Var3.getAnnotations(), builtInAnnotationDescriptor);
                z71Var3 = TypeUtilsKt.r(z71Var3, c8302a.a(l0));
            }
            arrayList.add(TypeUtilsKt.a(z71Var3));
            i = i2;
        }
        arrayList.add(TypeUtilsKt.a(z71Var2));
        return arrayList;
    }

    @Nullable
    public static final FunctionClassKind f(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        if ((declarationDescriptor instanceof ClassDescriptor) && AbstractC8271b.z0(declarationDescriptor)) {
            return g(DescriptorUtilsKt.j(declarationDescriptor));
        }
        return null;
    }

    private static final FunctionClassKind g(ip0 ip0Var) {
        if (!ip0Var.f() || ip0Var.e()) {
            return null;
        }
        FunctionClassKind.C8279a c8279a = FunctionClassKind.Companion;
        String b = ip0Var.i().b();
        b41.h(b, "shortName().asString()");
        hp0 e = ip0Var.l().e();
        b41.h(e, "toSafe().parent()");
        return c8279a.b(b, e);
    }

    @Nullable
    public static final z71 h(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        m(z71Var);
        if (p(z71Var)) {
            return ((TypeProjection) C8212k.P(z71Var.b())).getType();
        }
        return null;
    }

    @NotNull
    public static final z71 i(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        m(z71Var);
        z71 type = ((TypeProjection) C8212k.b0(z71Var.b())).getType();
        b41.h(type, "arguments.last().type");
        return type;
    }

    @NotNull
    public static final List<TypeProjection> j(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        m(z71Var);
        List<TypeProjection> b = z71Var.b();
        return b.subList(k(z71Var) ? 1 : 0, b.size() - 1);
    }

    public static final boolean k(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return m(z71Var) && p(z71Var);
    }

    public static final boolean l(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        FunctionClassKind f = f(declarationDescriptor);
        return f == FunctionClassKind.Function || f == FunctionClassKind.SuspendFunction;
    }

    public static final boolean m(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        return declarationDescriptor != null && l(declarationDescriptor);
    }

    public static final boolean n(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : f(declarationDescriptor)) == FunctionClassKind.Function;
    }

    public static final boolean o(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : f(declarationDescriptor)) == FunctionClassKind.SuspendFunction;
    }

    private static final boolean p(z71 z71Var) {
        return z71Var.getAnnotations().findAnnotation(C8277c.C8278a.extensionFunctionType) != null;
    }

    @NotNull
    public static final Annotations q(@NotNull Annotations annotations, @NotNull AbstractC8271b abstractC8271b) {
        Map i;
        List<? extends AnnotationDescriptor> l0;
        b41.i(annotations, "<this>");
        b41.i(abstractC8271b, "builtIns");
        hp0 hp0Var = C8277c.C8278a.extensionFunctionType;
        if (annotations.hasAnnotation(hp0Var)) {
            return annotations;
        }
        Annotations.C8302a c8302a = Annotations.Companion;
        i = C8226x.i();
        l0 = CollectionsKt___CollectionsKt.l0(annotations, new BuiltInAnnotationDescriptor(abstractC8271b, hp0Var, i));
        return c8302a.a(l0);
    }
}
