package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.d42;
import tb.d70;
import tb.f70;
import tb.f71;
import tb.fx1;
import tb.g42;
import tb.hj;
import tb.hp0;
import tb.ni1;
import tb.ql;
import tb.rl;
import tb.s61;
import tb.t02;
import tb.tq2;
import tb.x02;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    public static final /* synthetic */ int e = 0;
    @NotNull
    private final x02.b<KClassImpl<T>.Data> c;
    @NotNull
    private final Class<T> d;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty[] v = {a12.i(new PropertyReference1Impl(a12.b(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        @NotNull
        private final x02.a d;
        @NotNull
        private final x02.a e;
        @Nullable
        private final x02.a f;
        @Nullable
        private final x02.a g;
        @NotNull
        private final x02.a h;
        @NotNull
        private final x02.a i;
        @Nullable
        private final x02.b j;
        @NotNull
        private final x02.a k;
        @NotNull
        private final x02.a l;
        @NotNull
        private final x02.a m;
        @NotNull
        private final x02.a n;
        private final x02.a o;
        private final x02.a p;
        private final x02.a q;
        @NotNull
        private final x02.a r;
        @NotNull
        private final x02.a s;
        @NotNull
        private final x02.a t;

        public Data() {
            super();
            this.d = x02.d(new Function0<ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$descriptor$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ClassDescriptor invoke() {
                    hj w;
                    w = KClassImpl.this.w();
                    d42 a = ((KClassImpl.Data) KClassImpl.this.x().invoke()).a();
                    ClassDescriptor b = w.k() ? a.a().b(w) : FindClassInModuleKt.a(a.b(), w);
                    if (b != null) {
                        return b;
                    }
                    KClassImpl.this.B();
                    throw null;
                }
            });
            this.e = x02.d(new Function0<List<? extends Annotation>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$annotations$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends Annotation> invoke() {
                    return zv2.e(KClassImpl.Data.this.n());
                }
            });
            this.f = x02.d(new Function0<String>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$simpleName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    hj w;
                    String f;
                    if (KClassImpl.this.getJClass().isAnonymousClass()) {
                        return null;
                    }
                    w = KClassImpl.this.w();
                    if (w.k()) {
                        KClassImpl.Data data = KClassImpl.Data.this;
                        f = data.f(KClassImpl.this.getJClass());
                        return f;
                    }
                    String b = w.j().b();
                    b41.h(b, "classId.shortClassName.asString()");
                    return b;
                }
            });
            this.g = x02.d(new Function0<String>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$qualifiedName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    hj w;
                    if (KClassImpl.this.getJClass().isAnonymousClass()) {
                        return null;
                    }
                    w = KClassImpl.this.w();
                    if (w.k()) {
                        return null;
                    }
                    return w.b().b();
                }
            });
            this.h = x02.d(new Function0<List<? extends KFunction<? extends T>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$constructors$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<KFunction<T>> invoke() {
                    int q;
                    Collection<ConstructorDescriptor> i = KClassImpl.this.i();
                    q = n.q(i, 10);
                    ArrayList arrayList = new ArrayList(q);
                    for (ConstructorDescriptor constructorDescriptor : i) {
                        arrayList.add(new KFunctionImpl(KClassImpl.this, constructorDescriptor));
                    }
                    return arrayList;
                }
            });
            this.i = x02.d(new Function0<List<? extends KClassImpl<? extends Object>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$nestedClasses$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KClassImpl<? extends Object>> invoke() {
                    Collection a = ResolutionScope.a.a(KClassImpl.Data.this.n().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
                    ArrayList<DeclarationDescriptor> arrayList = new ArrayList();
                    for (Object obj : a) {
                        if (!d70.B((DeclarationDescriptor) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (DeclarationDescriptor declarationDescriptor : arrayList) {
                        if (!(declarationDescriptor instanceof ClassDescriptor)) {
                            declarationDescriptor = null;
                        }
                        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                        Class<?> p = classDescriptor != null ? zv2.p(classDescriptor) : null;
                        KClassImpl kClassImpl = p != null ? new KClassImpl(p) : null;
                        if (kClassImpl != null) {
                            arrayList2.add(kClassImpl);
                        }
                    }
                    return arrayList2;
                }
            });
            this.j = x02.b(new Function0<T>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$objectInstance$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final T invoke() {
                    Field declaredField;
                    ClassDescriptor n = KClassImpl.Data.this.n();
                    if (n.getKind() != ClassKind.OBJECT) {
                        return null;
                    }
                    if (n.isCompanionObject() && !rl.a(ql.INSTANCE, n)) {
                        declaredField = KClassImpl.this.getJClass().getEnclosingClass().getDeclaredField(n.getName().b());
                    } else {
                        declaredField = KClassImpl.this.getJClass().getDeclaredField("INSTANCE");
                    }
                    T t = (T) declaredField.get(null);
                    Objects.requireNonNull(t, "null cannot be cast to non-null type T");
                    return t;
                }
            });
            this.k = x02.d(new Function0<List<? extends KTypeParameterImpl>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$typeParameters$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KTypeParameterImpl> invoke() {
                    int q;
                    List<TypeParameterDescriptor> declaredTypeParameters = KClassImpl.Data.this.n().getDeclaredTypeParameters();
                    b41.h(declaredTypeParameters, "descriptor.declaredTypeParameters");
                    q = n.q(declaredTypeParameters, 10);
                    ArrayList arrayList = new ArrayList(q);
                    for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
                        KClassImpl kClassImpl = KClassImpl.this;
                        b41.h(typeParameterDescriptor, "descriptor");
                        arrayList.add(new KTypeParameterImpl(kClassImpl, typeParameterDescriptor));
                    }
                    return arrayList;
                }
            });
            this.l = x02.d(new KClassImpl$Data$supertypes$2(this));
            this.m = x02.d(new Function0<List<? extends KClassImpl<? extends T>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$sealedSubclasses$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<KClassImpl<? extends T>> invoke() {
                    Collection<ClassDescriptor> sealedSubclasses = KClassImpl.Data.this.n().getSealedSubclasses();
                    b41.h(sealedSubclasses, "descriptor.sealedSubclasses");
                    ArrayList arrayList = new ArrayList();
                    for (ClassDescriptor classDescriptor : sealedSubclasses) {
                        Objects.requireNonNull(classDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        Class<?> p = zv2.p(classDescriptor);
                        KClassImpl kClassImpl = p != null ? new KClassImpl(p) : null;
                        if (kClassImpl != null) {
                            arrayList.add(kClassImpl);
                        }
                    }
                    return arrayList;
                }
            });
            this.n = x02.d(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredNonStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.l(kClassImpl.z(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
            this.o = x02.d(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.l(kClassImpl.A(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
            this.p = x02.d(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$inheritedNonStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.l(kClassImpl.z(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                }
            });
            this.q = x02.d(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$inheritedStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.l(kClassImpl.A(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                }
            });
            this.r = x02.d(new Function0<List<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allNonStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    Collection o;
                    List<? extends KCallableImpl<?>> m0;
                    Collection<KCallableImpl<?>> l = KClassImpl.Data.this.l();
                    o = KClassImpl.Data.this.o();
                    m0 = CollectionsKt___CollectionsKt.m0(l, o);
                    return m0;
                }
            });
            this.s = x02.d(new Function0<List<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allStaticMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    Collection m;
                    Collection p;
                    List<? extends KCallableImpl<?>> m0;
                    m = KClassImpl.Data.this.m();
                    p = KClassImpl.Data.this.p();
                    m0 = CollectionsKt___CollectionsKt.m0(m, p);
                    return m0;
                }
            });
            x02.d(new Function0<List<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    Collection m;
                    List<? extends KCallableImpl<?>> m0;
                    Collection<KCallableImpl<?>> l = KClassImpl.Data.this.l();
                    m = KClassImpl.Data.this.m();
                    m0 = CollectionsKt___CollectionsKt.m0(l, m);
                    return m0;
                }
            });
            this.t = x02.d(new Function0<List<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allMembers$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    List<? extends KCallableImpl<?>> m0;
                    m0 = CollectionsKt___CollectionsKt.m0(KClassImpl.Data.this.h(), KClassImpl.Data.this.i());
                    return m0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(Class<?> cls) {
            String D0;
            String E0;
            String E02;
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                b41.h(simpleName, "name");
                E02 = StringsKt__StringsKt.E0(simpleName, enclosingMethod.getName() + "$", null, 2, null);
                return E02;
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                b41.h(simpleName, "name");
                E0 = StringsKt__StringsKt.E0(simpleName, enclosingConstructor.getName() + "$", null, 2, null);
                return E0;
            }
            b41.h(simpleName, "name");
            D0 = StringsKt__StringsKt.D0(simpleName, '$', null, 2, null);
            return D0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> m() {
            return (Collection) this.o.b(this, v[11]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> o() {
            return (Collection) this.p.b(this, v[12]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> p() {
            return (Collection) this.q.b(this, v[13]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> g() {
            return (Collection) this.t.b(this, v[17]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> h() {
            return (Collection) this.r.b(this, v[14]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> i() {
            return (Collection) this.s.b(this, v[15]);
        }

        @NotNull
        public final List<Annotation> j() {
            return (List) this.e.b(this, v[1]);
        }

        @NotNull
        public final Collection<KFunction<T>> k() {
            return (Collection) this.h.b(this, v[4]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> l() {
            return (Collection) this.n.b(this, v[10]);
        }

        @NotNull
        public final ClassDescriptor n() {
            return (ClassDescriptor) this.d.b(this, v[0]);
        }

        @NotNull
        public final Collection<KClass<?>> q() {
            return (Collection) this.i.b(this, v[5]);
        }

        @Nullable
        public final T r() {
            return this.j.b(this, v[6]);
        }

        @Nullable
        public final String s() {
            return (String) this.g.b(this, v[3]);
        }

        @NotNull
        public final List<KClass<? extends T>> t() {
            return (List) this.m.b(this, v[9]);
        }

        @Nullable
        public final String u() {
            return (String) this.f.b(this, v[2]);
        }

        @NotNull
        public final List<KType> v() {
            return (List) this.l.b(this, v[8]);
        }

        @NotNull
        public final List<KTypeParameter> w() {
            return (List) this.k.b(this, v[7]);
        }
    }

    public KClassImpl(@NotNull Class<T> cls) {
        b41.i(cls, "jClass");
        this.d = cls;
        x02.b<KClassImpl<T>.Data> b = x02.b(new Function0<KClassImpl<T>.Data>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$data$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KClassImpl<T>.Data invoke() {
                return new KClassImpl.Data();
            }
        });
        b41.h(b, "ReflectProperties.lazy { Data() }");
        this.c = b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void B() {
        KotlinClassHeader classHeader;
        t02 a = t02.Factory.a(getJClass());
        KotlinClassHeader.Kind c = (a == null || (classHeader = a.getClassHeader()) == null) ? null : classHeader.c();
        if (c != null) {
            switch (f71.$EnumSwitchMapping$0[c.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + getJClass());
                case 4:
                    throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations does it have. Please use Java reflection to inspect this class: " + getJClass());
                case 5:
                    throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + c + ')');
                case 6:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        throw new KotlinReflectionInternalError("Unresolved class: " + getJClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final hj w() {
        return g42.INSTANCE.c(getJClass());
    }

    @NotNull
    public final MemberScope A() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        b41.h(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KClassImpl) && b41.d(s61.c(this), s61.c((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.c.invoke().j();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KFunction<T>> getConstructors() {
        return this.c.invoke().k();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<T> getJClass() {
        return this.d;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        return this.c.invoke().g();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        return this.c.invoke().q();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public T getObjectInstance() {
        return this.c.invoke().r();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getQualifiedName() {
        return this.c.invoke().s();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.c.invoke().t();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getSimpleName() {
        return this.c.invoke().u();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KType> getSupertypes() {
        return this.c.invoke().v();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        return this.c.invoke().w();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public KVisibility getVisibility() {
        f70 visibility = getDescriptor().getVisibility();
        b41.h(visibility, "descriptor.visibility");
        return zv2.q(visibility);
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return s61.c(this).hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<ConstructorDescriptor> i() {
        List g;
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() != ClassKind.INTERFACE && descriptor.getKind() != ClassKind.OBJECT) {
            Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
            b41.h(constructors, "descriptor.constructors");
            return constructors;
        }
        g = m.g();
        return g;
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        return getDescriptor().isData();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        return getDescriptor().isFun();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        return getDescriptor().isInner();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(@Nullable Object obj) {
        Integer c = ReflectClassUtilKt.c(getJClass());
        if (c != null) {
            return tq2.k(obj, c.intValue());
        }
        Class g = ReflectClassUtilKt.g(getJClass());
        if (g == null) {
            g = getJClass();
        }
        return g.isInstance(obj);
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        return getDescriptor().getModality() == Modality.SEALED;
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        return getDescriptor().isValue();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<FunctionDescriptor> j(@NotNull ni1 ni1Var) {
        List m0;
        b41.i(ni1Var, "name");
        MemberScope z = z();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        m0 = CollectionsKt___CollectionsKt.m0(z.getContributedFunctions(ni1Var, noLookupLocation), A().getContributedFunctions(ni1Var, noLookupLocation));
        return m0;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public PropertyDescriptor k(int i) {
        Class<?> declaringClass;
        if (b41.d(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            KClass e2 = s61.e(declaringClass);
            Objects.requireNonNull(e2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) e2).k(i);
        }
        ClassDescriptor descriptor = getDescriptor();
        if (!(descriptor instanceof DeserializedClassDescriptor)) {
            descriptor = null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) descriptor;
        if (deserializedClassDescriptor != null) {
            ProtoBuf$Class t = deserializedClassDescriptor.t();
            GeneratedMessageLite.c<ProtoBuf$Class, List<ProtoBuf$Property>> cVar = JvmProtoBuf.classLocalVariable;
            b41.h(cVar, "JvmProtoBuf.classLocalVariable");
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) fx1.b(t, cVar, i);
            if (protoBuf$Property != null) {
                return (PropertyDescriptor) zv2.h(getJClass(), protoBuf$Property, deserializedClassDescriptor.s().g(), deserializedClassDescriptor.s().j(), deserializedClassDescriptor.v(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<PropertyDescriptor> n(@NotNull ni1 ni1Var) {
        List m0;
        b41.i(ni1Var, "name");
        MemberScope z = z();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        m0 = CollectionsKt___CollectionsKt.m0(z.getContributedVariables(ni1Var, noLookupLocation), A().getContributedVariables(ni1Var, noLookupLocation));
        return m0;
    }

    @NotNull
    public String toString() {
        String str;
        String y;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        hj w = w();
        hp0 h = w.h();
        b41.h(h, "classId.packageFqName");
        if (h.d()) {
            str = "";
        } else {
            str = h.b() + ".";
        }
        String b = w.i().b();
        b41.h(b, "classId.relativeClassName.asString()");
        y = o.y(b, '.', '$', false, 4, null);
        sb.append(str + y);
        return sb.toString();
    }

    @NotNull
    public final x02.b<KClassImpl<T>.Data> x() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    @NotNull
    /* renamed from: y */
    public ClassDescriptor getDescriptor() {
        return this.c.invoke().n();
    }

    @NotNull
    public final MemberScope z() {
        return getDescriptor().getDefaultType().getMemberScope();
    }
}
