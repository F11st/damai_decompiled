package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.collections.C8203e0;
import kotlin.collections.C8212k;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.C8433a;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ai2;
import tb.b41;
import tb.b81;
import tb.e70;
import tb.f51;
import tb.f70;
import tb.fd2;
import tb.fj;
import tb.gd1;
import tb.hj;
import tb.hp0;
import tb.k50;
import tb.kk;
import tb.m1;
import tb.mw2;
import tb.o61;
import tb.p21;
import tb.q51;
import tb.q81;
import tb.r81;
import tb.t21;
import tb.u51;
import tb.uy2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyJavaClassDescriptor extends fj implements JavaClassDescriptor {
    @NotNull
    public static final C8344a Companion = new C8344a(null);
    @NotNull
    private final r81 h;
    @NotNull
    private final JavaClass i;
    @Nullable
    private final ClassDescriptor j;
    @NotNull
    private final r81 k;
    @NotNull
    private final Lazy l;
    @NotNull
    private final ClassKind m;
    @NotNull
    private final Modality n;
    @NotNull
    private final uy2 o;
    private final boolean p;
    @NotNull
    private final LazyJavaClassTypeConstructor q;
    @NotNull
    private final LazyJavaClassMemberScope r;
    @NotNull
    private final ScopesHolderForClass<LazyJavaClassMemberScope> s;
    @NotNull
    private final t21 t;
    @NotNull
    private final LazyJavaStaticClassScope u;
    @NotNull
    private final Annotations v;
    @NotNull
    private final NotNullLazyValue<List<TypeParameterDescriptor>> w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class LazyJavaClassTypeConstructor extends m1 {
        @NotNull
        private final NotNullLazyValue<List<TypeParameterDescriptor>> d;
        final /* synthetic */ LazyJavaClassDescriptor e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LazyJavaClassTypeConstructor(final LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            super(lazyJavaClassDescriptor.k.e());
            b41.i(lazyJavaClassDescriptor, "this$0");
            this.e = lazyJavaClassDescriptor;
            this.d = lazyJavaClassDescriptor.k.e().createLazyValue(new Function0<List<? extends TypeParameterDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends TypeParameterDescriptor> invoke() {
                    return TypeParameterUtilsKt.d(LazyJavaClassDescriptor.this);
                }
            });
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
            if ((!r0.d() && r0.i(kotlin.reflect.jvm.internal.impl.builtins.C8277c.BUILT_INS_PACKAGE_NAME)) != false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final tb.z71 q() {
            /*
                r8 = this;
                tb.hp0 r0 = r8.r()
                r1 = 1
                r2 = 0
                if (r0 != 0) goto La
            L8:
                r0 = r2
                goto L1d
            La:
                boolean r3 = r0.d()
                if (r3 != 0) goto L1a
                tb.ni1 r3 = kotlin.reflect.jvm.internal.impl.builtins.C8277c.BUILT_INS_PACKAGE_NAME
                boolean r3 = r0.i(r3)
                if (r3 == 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 == 0) goto L8
            L1d:
                if (r0 != 0) goto L2e
                tb.ph0 r3 = tb.ph0.INSTANCE
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r4 = r8.e
                tb.hp0 r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r4)
                tb.hp0 r3 = r3.b(r4)
                if (r3 != 0) goto L2f
                return r2
            L2e:
                r3 = r0
            L2f:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r4 = r8.e
                tb.r81 r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.f(r4)
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r4 = r4.d()
                kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r5 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_JAVA_LOADER
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.r(r4, r3, r5)
                if (r3 != 0) goto L42
                return r2
            L42:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r3.getTypeConstructor()
                java.util.List r4 = r4.getParameters()
                int r4 = r4.size()
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r5 = r8.e
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r5.getTypeConstructor()
                java.util.List r5 = r5.getParameters()
                java.lang.String r6 = "getTypeConstructor().parameters"
                tb.b41.h(r5, r6)
                int r6 = r5.size()
                r7 = 10
                if (r6 != r4) goto L8d
                java.util.ArrayList r0 = new java.util.ArrayList
                int r1 = kotlin.collections.C8212k.q(r5, r7)
                r0.<init>(r1)
                java.util.Iterator r1 = r5.iterator()
            L72:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto Lc7
                java.lang.Object r2 = r1.next()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
                tb.zq2 r4 = new tb.zq2
                kotlin.reflect.jvm.internal.impl.types.Variance r5 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                tb.fd2 r2 = r2.getDefaultType()
                r4.<init>(r5, r2)
                r0.add(r4)
                goto L72
            L8d:
                if (r6 != r1) goto Ld2
                if (r4 <= r1) goto Ld2
                if (r0 != 0) goto Ld2
                tb.zq2 r0 = new tb.zq2
                kotlin.reflect.jvm.internal.impl.types.Variance r2 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                java.lang.Object r5 = kotlin.collections.C8212k.q0(r5)
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5
                tb.fd2 r5 = r5.getDefaultType()
                r0.<init>(r2, r5)
                tb.n31 r2 = new tb.n31
                r2.<init>(r1, r4)
                java.util.ArrayList r1 = new java.util.ArrayList
                int r4 = kotlin.collections.C8212k.q(r2, r7)
                r1.<init>(r4)
                java.util.Iterator r2 = r2.iterator()
            Lb6:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto Lc6
                r4 = r2
                tb.i31 r4 = (tb.i31) r4
                r4.nextInt()
                r1.add(r0)
                goto Lb6
            Lc6:
                r0 = r1
            Lc7:
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$a r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r1.b()
                tb.fd2 r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.g(r1, r3, r0)
                return r0
            Ld2:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.q():tb.z71");
        }

        private final hp0 r() {
            Annotations annotations = this.e.getAnnotations();
            hp0 hp0Var = o61.PURELY_IMPLEMENTS_ANNOTATION;
            b41.h(hp0Var, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor findAnnotation = annotations.findAnnotation(hp0Var);
            if (findAnnotation == null) {
                return null;
            }
            Object r0 = C8212k.r0(findAnnotation.getAllValueArguments().values());
            ai2 ai2Var = r0 instanceof ai2 ? (ai2) r0 : null;
            String b = ai2Var == null ? null : ai2Var.b();
            if (b != null && C8433a.e(b)) {
                return new hp0(b);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public Collection<z71> f() {
            List e;
            List A0;
            int q;
            Collection<JavaClassifierType> supertypes = this.e.j().getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            ArrayList<JavaType> arrayList2 = new ArrayList(0);
            z71 q2 = q();
            Iterator<JavaClassifierType> it = supertypes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JavaClassifierType next = it.next();
                z71 f = this.e.k.a().r().f(this.e.k.g().o(next, u51.d(TypeUsage.SUPERTYPE, false, null, 3, null)), this.e.k);
                if (f.c().getDeclarationDescriptor() instanceof NotFoundClasses.C8294b) {
                    arrayList2.add(next);
                }
                if (!b41.d(f.c(), q2 != null ? q2.c() : null) && !AbstractC8271b.b0(f)) {
                    arrayList.add(f);
                }
            }
            ClassDescriptor classDescriptor = this.e.j;
            kk.a(arrayList, classDescriptor != null ? gd1.a(classDescriptor, this.e).c().q(classDescriptor.getDefaultType(), Variance.INVARIANT) : null);
            kk.a(arrayList, q2);
            if (!arrayList2.isEmpty()) {
                ErrorReporter c = this.e.k.a().c();
                ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
                q = C8215n.q(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(q);
                for (JavaType javaType : arrayList2) {
                    arrayList3.add(((JavaClassifierType) javaType).getPresentableText());
                }
                c.reportIncompleteHierarchy(declarationDescriptor, arrayList3);
            }
            if (!arrayList.isEmpty()) {
                A0 = CollectionsKt___CollectionsKt.A0(arrayList);
                return A0;
            }
            e = C8213l.e(this.e.k.d().getBuiltIns().i());
            return e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return this.d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker j() {
            return this.e.k.a().v();
        }

        @Override // tb.pj, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        /* renamed from: p */
        public ClassDescriptor getDeclarationDescriptor() {
            return this.e;
        }

        @NotNull
        public String toString() {
            String b = this.e.getName().b();
            b41.h(b, "name.asString()");
            return b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$a */
    /* loaded from: classes3.dex */
    public static final class C8344a {
        private C8344a() {
        }

        public /* synthetic */ C8344a(k50 k50Var) {
            this();
        }
    }

    static {
        C8203e0.g("equals", "hashCode", "getClass", "wait", AgooConstants.MESSAGE_NOTIFICATION, "notifyAll", "toString");
    }

    public /* synthetic */ LazyJavaClassDescriptor(r81 r81Var, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor, int i, k50 k50Var) {
        this(r81Var, declarationDescriptor, javaClass, (i & 8) != 0 ? null : classDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.w.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public p21<fd2> getInlineClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List g;
        if (this.n == Modality.SEALED) {
            q51 d = u51.d(TypeUsage.COMMON, false, null, 3, null);
            Collection<JavaClassifierType> permittedTypes = this.i.getPermittedTypes();
            ArrayList arrayList = new ArrayList();
            for (JavaClassifierType javaClassifierType : permittedTypes) {
                ClassifierDescriptor declarationDescriptor = this.k.g().o(javaClassifierType, d).c().getDeclarationDescriptor();
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                if (classDescriptor != null) {
                    arrayList.add(classDescriptor);
                }
            }
            return arrayList;
        }
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getStaticScope() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.q;
    }

    @Override // tb.l1, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public f70 getVisibility() {
        if (b41.d(this.o, e70.PRIVATE) && this.i.getOuterClass() == null) {
            f70 f70Var = f51.PACKAGE_VISIBILITY;
            b41.h(f70Var, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
            return f70Var;
        }
        return mw2.a(this.o);
    }

    @NotNull
    public final LazyJavaClassDescriptor h(@NotNull JavaResolverCache javaResolverCache, @Nullable ClassDescriptor classDescriptor) {
        b41.i(javaResolverCache, "javaResolverCache");
        r81 r81Var = this.k;
        r81 j = ContextKt.j(r81Var, r81Var.a().x(javaResolverCache));
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        b41.h(containingDeclaration, "containingDeclaration");
        return new LazyJavaClassDescriptor(j, containingDeclaration, this.i, classDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    /* renamed from: i */
    public List<ClassConstructorDescriptor> getConstructors() {
        return this.r.p0().invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    @NotNull
    public final JavaClass j() {
        return this.i;
    }

    @Nullable
    public final List<JavaAnnotation> k() {
        return (List) this.l.getValue();
    }

    @NotNull
    public final r81 l() {
        return this.h;
    }

    @Override // tb.l1, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    /* renamed from: m */
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        return (LazyJavaClassMemberScope) super.getUnsubstitutedMemberScope();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.wg1
    @NotNull
    /* renamed from: n */
    public LazyJavaClassMemberScope b(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this.s.c(b81Var);
    }

    @NotNull
    public String toString() {
        return b41.r("Lazy Java class ", DescriptorUtilsKt.j(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor(@NotNull r81 r81Var, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull JavaClass javaClass, @Nullable ClassDescriptor classDescriptor) {
        super(r81Var.e(), declarationDescriptor, javaClass.getName(), r81Var.a().t().source(javaClass), false);
        Lazy b;
        ClassKind classKind;
        Modality modality;
        b41.i(r81Var, "outerContext");
        b41.i(declarationDescriptor, "containingDeclaration");
        b41.i(javaClass, "jClass");
        this.h = r81Var;
        this.i = javaClass;
        this.j = classDescriptor;
        r81 d = ContextKt.d(r81Var, this, javaClass, 0, 4, null);
        this.k = d;
        d.a().h().recordClass(javaClass, this);
        javaClass.getLightClassOriginKind();
        b = C8177b.b(new Function0<List<? extends JavaAnnotation>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$moduleAnnotations$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final List<? extends JavaAnnotation> invoke() {
                hj h = DescriptorUtilsKt.h(LazyJavaClassDescriptor.this);
                if (h == null) {
                    return null;
                }
                return LazyJavaClassDescriptor.this.l().a().f().getAnnotationsForModuleOwnerOfClass(h);
            }
        });
        this.l = b;
        if (javaClass.isAnnotationType()) {
            classKind = ClassKind.ANNOTATION_CLASS;
        } else if (javaClass.isInterface()) {
            classKind = ClassKind.INTERFACE;
        } else {
            classKind = javaClass.isEnum() ? ClassKind.ENUM_CLASS : ClassKind.CLASS;
        }
        this.m = classKind;
        if (!javaClass.isAnnotationType() && !javaClass.isEnum()) {
            modality = Modality.Companion.a(false, javaClass.isSealed() || javaClass.isAbstract() || javaClass.isInterface(), !javaClass.isFinal());
        } else {
            modality = Modality.FINAL;
        }
        this.n = modality;
        this.o = javaClass.getVisibility();
        this.p = (javaClass.getOuterClass() == null || javaClass.isStatic()) ? false : true;
        this.q = new LazyJavaClassTypeConstructor(this);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = new LazyJavaClassMemberScope(d, this, javaClass, classDescriptor != null, null, 16, null);
        this.r = lazyJavaClassMemberScope;
        this.s = ScopesHolderForClass.Companion.a(this, d.e(), d.a().k().getKotlinTypeRefiner(), new Function1<b81, LazyJavaClassMemberScope>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$scopeHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final LazyJavaClassMemberScope invoke(@NotNull b81 b81Var) {
                LazyJavaClassMemberScope lazyJavaClassMemberScope2;
                b41.i(b81Var, AdvanceSetting.NETWORK_TYPE);
                r81 r81Var2 = LazyJavaClassDescriptor.this.k;
                LazyJavaClassDescriptor lazyJavaClassDescriptor = LazyJavaClassDescriptor.this;
                JavaClass j = lazyJavaClassDescriptor.j();
                boolean z = LazyJavaClassDescriptor.this.j != null;
                lazyJavaClassMemberScope2 = LazyJavaClassDescriptor.this.r;
                return new LazyJavaClassMemberScope(r81Var2, lazyJavaClassDescriptor, j, z, lazyJavaClassMemberScope2);
            }
        });
        this.t = new t21(lazyJavaClassMemberScope);
        this.u = new LazyJavaStaticClassScope(d, javaClass, this);
        this.v = q81.a(d, javaClass);
        this.w = d.e().createLazyValue(new Function0<List<? extends TypeParameterDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$declaredParameters$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends TypeParameterDescriptor> invoke() {
                int q;
                List<JavaTypeParameter> typeParameters = LazyJavaClassDescriptor.this.j().getTypeParameters();
                LazyJavaClassDescriptor lazyJavaClassDescriptor = LazyJavaClassDescriptor.this;
                q = C8215n.q(typeParameters, 10);
                ArrayList arrayList = new ArrayList(q);
                for (JavaTypeParameter javaTypeParameter : typeParameters) {
                    TypeParameterDescriptor resolveTypeParameter = lazyJavaClassDescriptor.k.f().resolveTypeParameter(javaTypeParameter);
                    if (resolveTypeParameter == null) {
                        throw new AssertionError("Parameter " + javaTypeParameter + " surely belongs to class " + lazyJavaClassDescriptor.j() + ", so it must be resolved");
                    }
                    arrayList.add(resolveTypeParameter);
                }
                return arrayList;
            }
        });
    }
}
