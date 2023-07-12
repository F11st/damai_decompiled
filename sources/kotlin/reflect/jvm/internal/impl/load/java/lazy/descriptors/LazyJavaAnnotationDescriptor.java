package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.a70;
import tb.a81;
import tb.b41;
import tb.d6;
import tb.dm1;
import tb.fd2;
import tb.fn;
import tb.g71;
import tb.hj;
import tb.hp0;
import tb.hq2;
import tb.k50;
import tb.kf0;
import tb.ni1;
import tb.o61;
import tb.p51;
import tb.r81;
import tb.tg2;
import tb.u51;
import tb.xe0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] i = {a12.i(new PropertyReference1Impl(a12.b(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), a12.i(new PropertyReference1Impl(a12.b(LazyJavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), a12.i(new PropertyReference1Impl(a12.b(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull
    private final r81 a;
    @NotNull
    private final JavaAnnotation b;
    @NotNull
    private final NullableLazyValue c;
    @NotNull
    private final NotNullLazyValue d;
    @NotNull
    private final JavaSourceElement e;
    @NotNull
    private final NotNullLazyValue f;
    private final boolean g;
    private final boolean h;

    public LazyJavaAnnotationDescriptor(@NotNull r81 r81Var, @NotNull JavaAnnotation javaAnnotation, boolean z) {
        b41.i(r81Var, c.a);
        b41.i(javaAnnotation, "javaAnnotation");
        this.a = r81Var;
        this.b = javaAnnotation;
        this.c = r81Var.e().createNullableLazyValue(new Function0<hp0>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$fqName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final hp0 invoke() {
                JavaAnnotation javaAnnotation2;
                javaAnnotation2 = LazyJavaAnnotationDescriptor.this.b;
                hj classId = javaAnnotation2.getClassId();
                if (classId == null) {
                    return null;
                }
                return classId.b();
            }
        });
        this.d = r81Var.e().createLazyValue(new Function0<fd2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$type$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final fd2 invoke() {
                r81 r81Var2;
                JavaAnnotation javaAnnotation2;
                r81 r81Var3;
                JavaAnnotation javaAnnotation3;
                hp0 fqName = LazyJavaAnnotationDescriptor.this.getFqName();
                if (fqName == null) {
                    javaAnnotation3 = LazyJavaAnnotationDescriptor.this.b;
                    return kf0.j(b41.r("No fqName: ", javaAnnotation3));
                }
                p51 p51Var = p51.INSTANCE;
                r81Var2 = LazyJavaAnnotationDescriptor.this.a;
                ClassDescriptor h = p51.h(p51Var, fqName, r81Var2.d().getBuiltIns(), null, 4, null);
                if (h == null) {
                    javaAnnotation2 = LazyJavaAnnotationDescriptor.this.b;
                    JavaClass resolve = javaAnnotation2.resolve();
                    if (resolve == null) {
                        h = null;
                    } else {
                        r81Var3 = LazyJavaAnnotationDescriptor.this.a;
                        h = r81Var3.a().n().resolveClass(resolve);
                    }
                    if (h == null) {
                        h = LazyJavaAnnotationDescriptor.this.e(fqName);
                    }
                }
                return h.getDefaultType();
            }
        });
        this.e = r81Var.a().t().source(javaAnnotation);
        this.f = r81Var.e().createLazyValue(new Function0<Map<ni1, ? extends fn<?>>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$allValueArguments$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<ni1, ? extends fn<?>> invoke() {
                JavaAnnotation javaAnnotation2;
                Map<ni1, ? extends fn<?>> r;
                fn i2;
                javaAnnotation2 = LazyJavaAnnotationDescriptor.this.b;
                Collection<JavaAnnotationArgument> arguments = javaAnnotation2.getArguments();
                LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = LazyJavaAnnotationDescriptor.this;
                ArrayList arrayList = new ArrayList();
                for (JavaAnnotationArgument javaAnnotationArgument : arguments) {
                    ni1 name = javaAnnotationArgument.getName();
                    if (name == null) {
                        name = o61.DEFAULT_ANNOTATION_MEMBER_NAME;
                    }
                    i2 = lazyJavaAnnotationDescriptor.i(javaAnnotationArgument);
                    Pair a = i2 == null ? null : hq2.a(name, i2);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                r = x.r(arrayList);
                return r;
            }
        });
        this.g = javaAnnotation.isIdeExternalAnnotation();
        this.h = javaAnnotation.isFreshlySupportedTypeUseAnnotation() || z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor e(hp0 hp0Var) {
        ModuleDescriptor d = this.a.d();
        hj m = hj.m(hp0Var);
        b41.h(m, "topLevel(fqName)");
        return FindClassInModuleKt.c(d, m, this.a.a().b().e().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final fn<?> i(JavaAnnotationArgument javaAnnotationArgument) {
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            return ConstantValueFactory.INSTANCE.c(((JavaLiteralAnnotationArgument) javaAnnotationArgument).getValue());
        }
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
            return l(javaEnumValueAnnotationArgument.getEnumClassId(), javaEnumValueAnnotationArgument.getEntryName());
        } else if (!(javaAnnotationArgument instanceof JavaArrayAnnotationArgument)) {
            if (javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument) {
                return j(((JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).getAnnotation());
            }
            if (javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument) {
                return m(((JavaClassObjectAnnotationArgument) javaAnnotationArgument).getReferencedType());
            }
            return null;
        } else {
            JavaArrayAnnotationArgument javaArrayAnnotationArgument = (JavaArrayAnnotationArgument) javaAnnotationArgument;
            ni1 name = javaArrayAnnotationArgument.getName();
            if (name == null) {
                name = o61.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            b41.h(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            return k(name, javaArrayAnnotationArgument.getElements());
        }
    }

    private final fn<?> j(JavaAnnotation javaAnnotation) {
        return new d6(new LazyJavaAnnotationDescriptor(this.a, javaAnnotation, false, 4, null));
    }

    private final fn<?> k(ni1 ni1Var, List<? extends JavaAnnotationArgument> list) {
        int q;
        fd2 type = getType();
        b41.h(type, "type");
        if (a81.a(type)) {
            return null;
        }
        ClassDescriptor f = DescriptorUtilsKt.f(this);
        b41.f(f);
        ValueParameterDescriptor b = a70.b(ni1Var, f);
        fd2 type2 = b != null ? b.getType() : null;
        if (type2 == null) {
            type2 = this.a.a().m().getBuiltIns().l(Variance.INVARIANT, kf0.j("Unknown array element type"));
        }
        b41.h(type2, "DescriptorResolverUtils.… type\")\n                )");
        q = n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (JavaAnnotationArgument javaAnnotationArgument : list) {
            fn<?> i2 = i(javaAnnotationArgument);
            if (i2 == null) {
                i2 = new dm1();
            }
            arrayList.add(i2);
        }
        return ConstantValueFactory.INSTANCE.b(arrayList, type2);
    }

    private final fn<?> l(hj hjVar, ni1 ni1Var) {
        if (hjVar == null || ni1Var == null) {
            return null;
        }
        return new xe0(hjVar, ni1Var);
    }

    private final fn<?> m(JavaType javaType) {
        return g71.Companion.a(this.a.g().o(javaType, u51.d(TypeUsage.COMMON, false, null, 3, null)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    /* renamed from: f */
    public JavaSourceElement getSource() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    /* renamed from: g */
    public fd2 getType() {
        return (fd2) tg2.a(this.d, this, i[1]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<ni1, fn<?>> getAllValueArguments() {
        return (Map) tg2.a(this.f, this, i[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @Nullable
    public hp0 getFqName() {
        return (hp0) tg2.b(this.c, this, i[0]);
    }

    public final boolean h() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.g;
    }

    @NotNull
    public String toString() {
        return DescriptorRenderer.c(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }

    public /* synthetic */ LazyJavaAnnotationDescriptor(r81 r81Var, JavaAnnotation javaAnnotation, boolean z, int i2, k50 k50Var) {
        this(r81Var, javaAnnotation, (i2 & 4) != 0 ? false : z);
    }
}
