package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.huawei.hms.opendevice.c;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fd2;
import tb.hj;
import tb.hp0;
import tb.kf0;
import tb.p51;
import tb.q51;
import tb.r81;
import tb.u51;
import tb.v51;
import tb.z71;
import tb.zq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class JavaTypeResolver {
    @NotNull
    private final r81 a;
    @NotNull
    private final TypeParameterResolver b;
    @NotNull
    private final TypeParameterUpperBoundEraser c;
    @NotNull
    private final RawSubstitution d;

    public JavaTypeResolver(@NotNull r81 r81Var, @NotNull TypeParameterResolver typeParameterResolver) {
        b41.i(r81Var, c.a);
        b41.i(typeParameterResolver, "typeParameterResolver");
        this.a = r81Var;
        this.b = typeParameterResolver;
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(null, 1, null);
        this.c = typeParameterUpperBoundEraser;
        this.d = new RawSubstitution(typeParameterUpperBoundEraser);
    }

    private final boolean b(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        if (v51.a((JavaType) k.d0(javaClassifierType.getTypeArguments()))) {
            List<TypeParameterDescriptor> parameters = p51.INSTANCE.b(classDescriptor).getTypeConstructor().getParameters();
            b41.h(parameters, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) k.d0(parameters);
            Variance variance = typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance();
            return (variance == null || variance == Variance.OUT_VARIANCE) ? false : true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
        if ((!r0.isEmpty()) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> c(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r7, tb.q51 r8, kotlin.reflect.jvm.internal.impl.types.TypeConstructor r9) {
        /*
            r6 = this;
            boolean r0 = r7.isRaw()
            r1 = 0
            java.lang.String r2 = "constructor.parameters"
            r3 = 1
            if (r0 != 0) goto L24
            java.util.List r0 = r7.getTypeArguments()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L23
            java.util.List r0 = r9.getParameters()
            tb.b41.h(r0, r2)
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 == 0) goto L23
            goto L24
        L23:
            r3 = 0
        L24:
            java.util.List r0 = r9.getParameters()
            tb.b41.h(r0, r2)
            if (r3 == 0) goto L32
            java.util.List r7 = r6.d(r7, r0, r9, r8)
            return r7
        L32:
            int r8 = r0.size()
            java.util.List r9 = r7.getTypeArguments()
            int r9 = r9.size()
            r2 = 10
            if (r8 == r9) goto L75
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = kotlin.collections.k.q(r0, r2)
            r7.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
        L4f:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L70
            java.lang.Object r9 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9
            tb.zq2 r0 = new tb.zq2
            tb.ni1 r9 = r9.getName()
            java.lang.String r9 = r9.b()
            tb.fd2 r9 = tb.kf0.j(r9)
            r0.<init>(r9)
            r7.add(r0)
            goto L4f
        L70:
            java.util.List r7 = kotlin.collections.k.A0(r7)
            return r7
        L75:
            java.util.List r7 = r7.getTypeArguments()
            java.lang.Iterable r7 = kotlin.collections.k.G0(r7)
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = kotlin.collections.k.q(r7, r2)
            r8.<init>(r9)
            java.util.Iterator r7 = r7.iterator()
        L8a:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto Lbe
            java.lang.Object r9 = r7.next()
            tb.i21 r9 = (tb.i21) r9
            int r2 = r9.a()
            java.lang.Object r9 = r9.b()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r9 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r9
            r0.size()
            java.lang.Object r2 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r3 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r4 = 3
            r5 = 0
            tb.q51 r3 = tb.u51.d(r3, r1, r5, r4, r5)
            java.lang.String r4 = "parameter"
            tb.b41.h(r2, r4)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r9 = r6.p(r9, r3, r2)
            r8.add(r9)
            goto L8a
        Lbe:
            java.util.List r7 = kotlin.collections.k.A0(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.c(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, tb.q51, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):java.util.List");
    }

    private final List<TypeProjection> d(final JavaClassifierType javaClassifierType, List<? extends TypeParameterDescriptor> list, final TypeConstructor typeConstructor, final q51 q51Var) {
        int q;
        TypeProjection j;
        q = n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        for (final TypeParameterDescriptor typeParameterDescriptor : list) {
            if (TypeUtilsKt.k(typeParameterDescriptor, null, q51Var.f())) {
                j = u51.b(typeParameterDescriptor, q51Var);
            } else {
                j = this.d.j(typeParameterDescriptor, javaClassifierType.isRaw() ? q51Var : q51Var.i(JavaTypeFlexibility.INFLEXIBLE), new LazyWrappedType(this.a.e(), new Function0<z71>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final z71 invoke() {
                        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;
                        typeParameterUpperBoundEraser = JavaTypeResolver.this.c;
                        TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
                        boolean isRaw = javaClassifierType.isRaw();
                        q51 q51Var2 = q51Var;
                        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
                        z71 c = typeParameterUpperBoundEraser.c(typeParameterDescriptor2, isRaw, q51Var2.h(declarationDescriptor == null ? null : declarationDescriptor.getDefaultType()));
                        b41.h(c, "typeParameterUpperBoundE…efaultType)\n            )");
                        return c;
                    }
                }));
            }
            arrayList.add(j);
        }
        return arrayList;
    }

    private final fd2 e(JavaClassifierType javaClassifierType, q51 q51Var, fd2 fd2Var) {
        Annotations annotations = fd2Var == null ? null : fd2Var.getAnnotations();
        if (annotations == null) {
            annotations = new LazyJavaAnnotations(this.a, javaClassifierType, false, 4, null);
        }
        Annotations annotations2 = annotations;
        TypeConstructor f = f(javaClassifierType, q51Var);
        if (f == null) {
            return null;
        }
        boolean i = i(q51Var);
        if (b41.d(fd2Var != null ? fd2Var.c() : null, f) && !javaClassifierType.isRaw() && i) {
            return fd2Var.j(true);
        }
        return KotlinTypeFactory.i(annotations2, f, c(javaClassifierType, q51Var, f), i, null, 16, null);
    }

    private final TypeConstructor f(JavaClassifierType javaClassifierType, q51 q51Var) {
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return g(javaClassifierType);
        }
        if (classifier instanceof JavaClass) {
            JavaClass javaClass = (JavaClass) classifier;
            hp0 fqName = javaClass.getFqName();
            if (fqName != null) {
                ClassDescriptor j = j(javaClassifierType, q51Var, fqName);
                if (j == null) {
                    j = this.a.a().n().resolveClass(javaClass);
                }
                TypeConstructor typeConstructor = j != null ? j.getTypeConstructor() : null;
                return typeConstructor == null ? g(javaClassifierType) : typeConstructor;
            }
            throw new AssertionError(b41.r("Class type should have a FQ name: ", classifier));
        } else if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.b.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter == null) {
                return null;
            }
            return resolveTypeParameter.getTypeConstructor();
        } else {
            throw new IllegalStateException(b41.r("Unknown classifier kind: ", classifier));
        }
    }

    private final TypeConstructor g(JavaClassifierType javaClassifierType) {
        List<Integer> e;
        hj m = hj.m(new hp0(javaClassifierType.getClassifierQualifiedName()));
        b41.h(m, "topLevel(FqName(javaType.classifierQualifiedName))");
        NotFoundClasses q = this.a.a().b().e().q();
        e = l.e(0);
        TypeConstructor typeConstructor = q.d(m, e).getTypeConstructor();
        b41.h(typeConstructor, "c.components.deserialize…istOf(0)).typeConstructor");
        return typeConstructor;
    }

    private final boolean h(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        return (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) ? false : true;
    }

    private final boolean i(q51 q51Var) {
        return (q51Var.d() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || q51Var.g() || q51Var.e() == TypeUsage.SUPERTYPE) ? false : true;
    }

    private final ClassDescriptor j(JavaClassifierType javaClassifierType, q51 q51Var, hp0 hp0Var) {
        if (q51Var.g() && b41.d(hp0Var, u51.a())) {
            return this.a.a().p().c();
        }
        p51 p51Var = p51.INSTANCE;
        ClassDescriptor h = p51.h(p51Var, hp0Var, this.a.d().getBuiltIns(), null, 4, null);
        if (h == null) {
            return null;
        }
        return (p51Var.e(h) && (q51Var.d() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || q51Var.e() == TypeUsage.SUPERTYPE || b(javaClassifierType, h))) ? p51Var.b(h) : h;
    }

    public static /* synthetic */ z71 l(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, q51 q51Var, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.k(javaArrayType, q51Var, z);
    }

    private final z71 m(JavaClassifierType javaClassifierType, q51 q51Var) {
        boolean z = (q51Var.g() || q51Var.e() == TypeUsage.SUPERTYPE) ? false : true;
        boolean isRaw = javaClassifierType.isRaw();
        if (!isRaw && !z) {
            fd2 e = e(javaClassifierType, q51Var, null);
            return e == null ? n(javaClassifierType) : e;
        }
        fd2 e2 = e(javaClassifierType, q51Var.i(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (e2 == null) {
            return n(javaClassifierType);
        }
        fd2 e3 = e(javaClassifierType, q51Var.i(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), e2);
        if (e3 == null) {
            return n(javaClassifierType);
        }
        if (isRaw) {
            return new RawTypeImpl(e2, e3);
        }
        return KotlinTypeFactory.d(e2, e3);
    }

    private static final fd2 n(JavaClassifierType javaClassifierType) {
        fd2 j = kf0.j(b41.r("Unresolved java class ", javaClassifierType.getPresentableText()));
        b41.h(j, "createErrorType(\"Unresol…vaType.presentableText}\")");
        return j;
    }

    private final TypeProjection p(JavaType javaType, q51 q51Var, TypeParameterDescriptor typeParameterDescriptor) {
        if (javaType instanceof JavaWildcardType) {
            JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
            JavaType bound = javaWildcardType.getBound();
            Variance variance = javaWildcardType.isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
            if (bound != null && !h(variance, typeParameterDescriptor)) {
                return TypeUtilsKt.e(o(bound, u51.d(TypeUsage.COMMON, false, null, 3, null)), variance, typeParameterDescriptor);
            }
            return u51.b(typeParameterDescriptor, q51Var);
        }
        return new zq2(Variance.INVARIANT, o(javaType, q51Var));
    }

    @NotNull
    public final z71 k(@NotNull JavaArrayType javaArrayType, @NotNull q51 q51Var, boolean z) {
        List<? extends AnnotationDescriptor> k0;
        b41.i(javaArrayType, "arrayType");
        b41.i(q51Var, RichTextNode.ATTR);
        JavaType componentType = javaArrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = componentType instanceof JavaPrimitiveType ? (JavaPrimitiveType) componentType : null;
        PrimitiveType type = javaPrimitiveType == null ? null : javaPrimitiveType.getType();
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.a, javaArrayType, true);
        if (type != null) {
            fd2 O = this.a.d().getBuiltIns().O(type);
            b41.h(O, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            Annotations.a aVar = Annotations.Companion;
            k0 = CollectionsKt___CollectionsKt.k0(lazyJavaAnnotations, O.getAnnotations());
            O.k(aVar.a(k0));
            return q51Var.g() ? O : KotlinTypeFactory.d(O, O.j(true));
        }
        z71 o = o(componentType, u51.d(TypeUsage.COMMON, q51Var.g(), null, 2, null));
        if (q51Var.g()) {
            fd2 m = this.a.d().getBuiltIns().m(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, o, lazyJavaAnnotations);
            b41.h(m, "c.module.builtIns.getArr…mponentType, annotations)");
            return m;
        }
        fd2 m2 = this.a.d().getBuiltIns().m(Variance.INVARIANT, o, lazyJavaAnnotations);
        b41.h(m2, "c.module.builtIns.getArr…mponentType, annotations)");
        return KotlinTypeFactory.d(m2, this.a.d().getBuiltIns().m(Variance.OUT_VARIANCE, o, lazyJavaAnnotations).j(true));
    }

    @NotNull
    public final z71 o(@Nullable JavaType javaType, @NotNull q51 q51Var) {
        fd2 Z;
        b41.i(q51Var, RichTextNode.ATTR);
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                Z = this.a.d().getBuiltIns().R(type);
            } else {
                Z = this.a.d().getBuiltIns().Z();
            }
            b41.h(Z, "{\n                val pr…ns.unitType\n            }");
            return Z;
        } else if (javaType instanceof JavaClassifierType) {
            return m((JavaClassifierType) javaType, q51Var);
        } else {
            if (javaType instanceof JavaArrayType) {
                return l(this, (JavaArrayType) javaType, q51Var, false, 4, null);
            }
            if (!(javaType instanceof JavaWildcardType)) {
                if (javaType == null) {
                    fd2 y = this.a.d().getBuiltIns().y();
                    b41.h(y, "c.module.builtIns.defaultBound");
                    return y;
                }
                throw new UnsupportedOperationException(b41.r("Unsupported type: ", javaType));
            }
            JavaType bound = ((JavaWildcardType) javaType).getBound();
            z71 o = bound == null ? null : o(bound, q51Var);
            if (o == null) {
                fd2 y2 = this.a.d().getBuiltIns().y();
                b41.h(y2, "c.module.builtIns.defaultBound");
                return y2;
            }
            return o;
        }
    }
}
