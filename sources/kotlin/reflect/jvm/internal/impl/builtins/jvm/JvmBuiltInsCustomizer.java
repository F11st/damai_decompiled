package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.C8203e0;
import kotlin.collections.C8212k;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import tb.a12;
import tb.b41;
import tb.c70;
import tb.e70;
import tb.fd2;
import tb.gd1;
import tb.gj;
import tb.hj;
import tb.hp0;
import tb.ip0;
import tb.jp1;
import tb.lf1;
import tb.mf1;
import tb.ni1;
import tb.o51;
import tb.p51;
import tb.r61;
import tb.rs1;
import tb.tg2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] h = {a12.i(new PropertyReference1Impl(a12.b(JvmBuiltInsCustomizer.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), a12.i(new PropertyReference1Impl(a12.b(JvmBuiltInsCustomizer.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), a12.i(new PropertyReference1Impl(a12.b(JvmBuiltInsCustomizer.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    @NotNull
    private final ModuleDescriptor a;
    @NotNull
    private final p51 b;
    @NotNull
    private final NotNullLazyValue c;
    @NotNull
    private final z71 d;
    @NotNull
    private final NotNullLazyValue e;
    @NotNull
    private final CacheWithNotNullValues<hp0, ClassDescriptor> f;
    @NotNull
    private final NotNullLazyValue g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum JDKMemberStatus {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$a */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C8284a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JDKMemberStatus.values().length];
            iArr[JDKMemberStatus.HIDDEN.ordinal()] = 1;
            iArr[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;
            iArr[JDKMemberStatus.DROP.ordinal()] = 3;
            iArr[JDKMemberStatus.VISIBLE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$b */
    /* loaded from: classes3.dex */
    public static final class C8285b extends jp1 {
        C8285b(ModuleDescriptor moduleDescriptor, hp0 hp0Var) {
            super(moduleDescriptor, hp0Var);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
        @NotNull
        /* renamed from: d */
        public MemberScope.C8499b getMemberScope() {
            return MemberScope.C8499b.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$c */
    /* loaded from: classes3.dex */
    public static final class C8286c<N> implements DFS.Neighbors {
        C8286c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
        @NotNull
        /* renamed from: a */
        public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
            Collection<z71> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            b41.h(supertypes, "it.typeConstructor.supertypes");
            JvmBuiltInsCustomizer jvmBuiltInsCustomizer = JvmBuiltInsCustomizer.this;
            ArrayList arrayList = new ArrayList();
            for (z71 z71Var : supertypes) {
                ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
                ClassifierDescriptor original = declarationDescriptor == null ? null : declarationDescriptor.getOriginal();
                ClassDescriptor classDescriptor2 = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
                LazyJavaClassDescriptor k = classDescriptor2 != null ? jvmBuiltInsCustomizer.k(classDescriptor2) : null;
                if (k != null) {
                    arrayList.add(k);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$d */
    /* loaded from: classes3.dex */
    public static final class C8287d extends DFS.AbstractC8561b<ClassDescriptor, JDKMemberStatus> {
        final /* synthetic */ String a;
        final /* synthetic */ Ref$ObjectRef<JDKMemberStatus> b;

        C8287d(String str, Ref$ObjectRef<JDKMemberStatus> ref$ObjectRef) {
            this.a = str;
            this.b = ref$ObjectRef;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
        /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        /* renamed from: a */
        public boolean beforeChildren(@NotNull ClassDescriptor classDescriptor) {
            b41.i(classDescriptor, "javaClassDescriptor");
            String a = lf1.a(SignatureBuildingComponents.INSTANCE, classDescriptor, this.a);
            r61 r61Var = r61.INSTANCE;
            if (r61Var.e().contains(a)) {
                this.b.element = JDKMemberStatus.HIDDEN;
            } else if (r61Var.h().contains(a)) {
                this.b.element = JDKMemberStatus.VISIBLE;
            } else if (r61Var.c().contains(a)) {
                this.b.element = JDKMemberStatus.DROP;
            }
            return this.b.element == null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        @NotNull
        /* renamed from: b */
        public JDKMemberStatus result() {
            JDKMemberStatus jDKMemberStatus = this.b.element;
            return jDKMemberStatus == null ? JDKMemberStatus.NOT_CONSIDERED : jDKMemberStatus;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$e */
    /* loaded from: classes3.dex */
    public static final class C8288e<N> implements DFS.Neighbors {
        public static final C8288e<N> INSTANCE = new C8288e<>();

        C8288e() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
        @NotNull
        /* renamed from: a */
        public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
        }
    }

    public JvmBuiltInsCustomizer(@NotNull ModuleDescriptor moduleDescriptor, @NotNull final StorageManager storageManager, @NotNull Function0<JvmBuiltIns.C8282a> function0) {
        b41.i(moduleDescriptor, "moduleDescriptor");
        b41.i(storageManager, "storageManager");
        b41.i(function0, "settingsComputation");
        this.a = moduleDescriptor;
        this.b = p51.INSTANCE;
        this.c = storageManager.createLazyValue(function0);
        this.d = f(storageManager);
        this.e = storageManager.createLazyValue(new Function0<fd2>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$cloneableType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final fd2 invoke() {
                JvmBuiltIns.C8282a n;
                JvmBuiltIns.C8282a n2;
                n = JvmBuiltInsCustomizer.this.n();
                ModuleDescriptor a = n.a();
                hj a2 = JvmBuiltInClassDescriptorFactory.Companion.a();
                StorageManager storageManager2 = storageManager;
                n2 = JvmBuiltInsCustomizer.this.n();
                return FindClassInModuleKt.c(a, a2, new NotFoundClasses(storageManager2, n2.a())).getDefaultType();
            }
        });
        this.f = storageManager.createCacheWithNotNullValues();
        this.g = storageManager.createLazyValue(new Function0<Annotations>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$notConsideredDeprecation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Annotations invoke() {
                ModuleDescriptor moduleDescriptor2;
                List<? extends AnnotationDescriptor> e;
                moduleDescriptor2 = JvmBuiltInsCustomizer.this.a;
                AnnotationDescriptor b = AnnotationUtilKt.b(moduleDescriptor2.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null);
                Annotations.C8302a c8302a = Annotations.Companion;
                e = C8213l.e(b);
                return c8302a.a(e);
            }
        });
    }

    private final SimpleFunctionDescriptor e(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setOwner(deserializedClassDescriptor);
        newCopyBuilder.setVisibility(e70.PUBLIC);
        newCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
        newCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
        SimpleFunctionDescriptor build = newCopyBuilder.build();
        b41.f(build);
        return build;
    }

    private final z71 f(StorageManager storageManager) {
        List e;
        Set<ClassConstructorDescriptor> d;
        C8285b c8285b = new C8285b(this.a, new hp0("java.io"));
        e = C8213l.e(new LazyWrappedType(storageManager, new Function0<z71>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final z71 invoke() {
                ModuleDescriptor moduleDescriptor;
                moduleDescriptor = JvmBuiltInsCustomizer.this.a;
                fd2 i = moduleDescriptor.getBuiltIns().i();
                b41.h(i, "moduleDescriptor.builtIns.anyType");
                return i;
            }
        }));
        gj gjVar = new gj(c8285b, ni1.f("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, e, SourceElement.NO_SOURCE, false, storageManager);
        MemberScope.C8499b c8499b = MemberScope.C8499b.INSTANCE;
        d = C8203e0.d();
        gjVar.e(c8499b, d, null);
        fd2 defaultType = gjVar.getDefaultType();
        b41.h(defaultType, "mockSerializableClass.defaultType");
        return defaultType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e7, code lost:
        if (o(r3, r10) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> g(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> r11) {
        /*
            r9 = this;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r0 = r9.k(r10)
            if (r0 != 0) goto Lb
            java.util.List r10 = kotlin.collections.C8212k.g()
            return r10
        Lb:
            tb.p51 r1 = r9.b
            tb.hp0 r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.a$a r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.C8289a.Companion
            kotlin.reflect.jvm.internal.impl.builtins.b r3 = r3.a()
            java.util.Collection r1 = r1.i(r2, r3)
            java.lang.Object r2 = kotlin.collections.C8212k.c0(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            if (r2 != 0) goto L28
            java.util.List r10 = kotlin.collections.C8212k.g()
            return r10
        L28:
            tb.yd2$b r3 = tb.yd2.Companion
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.C8212k.q(r1, r5)
            r4.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L39:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r5
            tb.hp0 r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r5)
            r4.add(r5)
            goto L39
        L4d:
            tb.yd2 r1 = r3.b(r4)
            tb.p51 r3 = r9.b
            boolean r10 = r3.c(r10)
            kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues<tb.hp0, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> r3 = r9.f
            tb.hp0 r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1 r5 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1
            r5.<init>()
            java.lang.Object r0 = r3.computeIfAbsent(r4, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getUnsubstitutedMemberScope()
            java.lang.String r2 = "fakeJavaClassDescriptor.unsubstitutedMemberScope"
            tb.b41.h(r0, r2)
            java.lang.Object r11 = r11.invoke(r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r11 = r11.iterator()
        L80:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto Lef
            java.lang.Object r2 = r11.next()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r5 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L99
        L97:
            r6 = 0
            goto Le9
        L99:
            tb.f70 r4 = r3.getVisibility()
            boolean r4 = r4.d()
            if (r4 != 0) goto La4
            goto L97
        La4:
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b.i0(r3)
            if (r4 == 0) goto Lab
            goto L97
        Lab:
            java.util.Collection r4 = r3.getOverriddenDescriptors()
            java.lang.String r5 = "analogueMember.overriddenDescriptors"
            tb.b41.h(r4, r5)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto Lbc
        Lba:
            r4 = 0
            goto Le0
        Lbc:
            java.util.Iterator r4 = r4.iterator()
        Lc0:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lba
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r5
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r5.getContainingDeclaration()
            java.lang.String r8 = "it.containingDeclaration"
            tb.b41.h(r5, r8)
            tb.hp0 r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r5)
            boolean r5 = r1.contains(r5)
            if (r5 == 0) goto Lc0
            r4 = 1
        Le0:
            if (r4 == 0) goto Le3
            goto L97
        Le3:
            boolean r3 = r9.o(r3, r10)
            if (r3 != 0) goto L97
        Le9:
            if (r6 == 0) goto L80
            r0.add(r2)
            goto L80
        Lef:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.g(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    private final fd2 h() {
        return (fd2) tg2.a(this.e, this, h[1]);
    }

    private static final boolean i(ConstructorDescriptor constructorDescriptor, TypeSubstitutor typeSubstitutor, ConstructorDescriptor constructorDescriptor2) {
        return OverridingUtil.y(constructorDescriptor, constructorDescriptor2.substitute(typeSubstitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LazyJavaClassDescriptor k(ClassDescriptor classDescriptor) {
        if (!AbstractC8271b.a0(classDescriptor) && AbstractC8271b.z0(classDescriptor)) {
            ip0 j = DescriptorUtilsKt.j(classDescriptor);
            if (j.f()) {
                hj o = o51.INSTANCE.o(j);
                hp0 b = o == null ? null : o.b();
                if (b == null) {
                    return null;
                }
                ClassDescriptor c = c70.c(n().a(), b, NoLookupLocation.FROM_BUILTINS);
                if (c instanceof LazyJavaClassDescriptor) {
                    return (LazyJavaClassDescriptor) c;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private final JDKMemberStatus l(FunctionDescriptor functionDescriptor) {
        List e;
        String c = mf1.c(functionDescriptor, false, false, 3, null);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        e = C8213l.e((ClassDescriptor) functionDescriptor.getContainingDeclaration());
        Object b = DFS.b(e, new C8286c(), new C8287d(c, ref$ObjectRef));
        b41.h(b, "private fun FunctionDesc…ERED\n            })\n    }");
        return (JDKMemberStatus) b;
    }

    private final Annotations m() {
        return (Annotations) tg2.a(this.g, this, h[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JvmBuiltIns.C8282a n() {
        return (JvmBuiltIns.C8282a) tg2.a(this.c, this, h[0]);
    }

    private final boolean o(SimpleFunctionDescriptor simpleFunctionDescriptor, boolean z) {
        List e;
        String c = mf1.c(simpleFunctionDescriptor, false, false, 3, null);
        if (z ^ r61.INSTANCE.f().contains(lf1.a(SignatureBuildingComponents.INSTANCE, (ClassDescriptor) simpleFunctionDescriptor.getContainingDeclaration(), c))) {
            return true;
        }
        e = C8213l.e(simpleFunctionDescriptor);
        Boolean e2 = DFS.e(e, C8288e.INSTANCE, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$isMutabilityViolation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                boolean z2;
                p51 p51Var;
                if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION) {
                    p51Var = JvmBuiltInsCustomizer.this.b;
                    if (p51Var.c((ClassDescriptor) callableMemberDescriptor.getContainingDeclaration())) {
                        z2 = true;
                        return Boolean.valueOf(z2);
                    }
                }
                z2 = false;
                return Boolean.valueOf(z2);
            }
        });
        b41.h(e2, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return e2.booleanValue();
    }

    private final boolean p(ConstructorDescriptor constructorDescriptor, ClassDescriptor classDescriptor) {
        if (constructorDescriptor.getValueParameters().size() == 1) {
            List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
            b41.h(valueParameters, "valueParameters");
            ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) C8212k.q0(valueParameters)).getType().c().getDeclarationDescriptor();
            if (b41.d(declarationDescriptor == null ? null : DescriptorUtilsKt.j(declarationDescriptor), DescriptorUtilsKt.j(classDescriptor))) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor) {
        List g;
        int q;
        boolean z;
        List g2;
        List g3;
        b41.i(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() == ClassKind.CLASS && n().b()) {
            LazyJavaClassDescriptor k = k(classDescriptor);
            if (k == null) {
                g3 = C8214m.g();
                return g3;
            }
            ClassDescriptor h2 = p51.h(this.b, DescriptorUtilsKt.i(k), C8289a.Companion.a(), null, 4, null);
            if (h2 == null) {
                g2 = C8214m.g();
                return g2;
            }
            TypeSubstitutor c = gd1.a(h2, k).c();
            List<ClassConstructorDescriptor> constructors = k.getConstructors();
            ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList();
            Iterator<T> it = constructors.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) next;
                if (classConstructorDescriptor.getVisibility().d()) {
                    Collection<ClassConstructorDescriptor> constructors2 = h2.getConstructors();
                    b41.h(constructors2, "defaultKotlinVersion.constructors");
                    if (!constructors2.isEmpty()) {
                        for (ClassConstructorDescriptor classConstructorDescriptor2 : constructors2) {
                            b41.h(classConstructorDescriptor2, AdvanceSetting.NETWORK_TYPE);
                            if (i(classConstructorDescriptor2, c, classConstructorDescriptor)) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z && !p(classConstructorDescriptor, classDescriptor) && !AbstractC8271b.i0(classConstructorDescriptor) && !r61.INSTANCE.d().contains(lf1.a(SignatureBuildingComponents.INSTANCE, k, mf1.c(classConstructorDescriptor, false, false, 3, null)))) {
                        z2 = true;
                    }
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            q = C8215n.q(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(q);
            for (ClassConstructorDescriptor classConstructorDescriptor3 : arrayList) {
                FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder = classConstructorDescriptor3.newCopyBuilder();
                newCopyBuilder.setOwner(classDescriptor);
                newCopyBuilder.setReturnType(classDescriptor.getDefaultType());
                newCopyBuilder.setPreserveSourceElement();
                newCopyBuilder.setSubstitution(c.j());
                if (!r61.INSTANCE.g().contains(lf1.a(SignatureBuildingComponents.INSTANCE, k, mf1.c(classConstructorDescriptor3, false, false, 3, null)))) {
                    newCopyBuilder.setAdditionalAnnotations(m());
                }
                FunctionDescriptor build = newCopyBuilder.build();
                Objects.requireNonNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((ClassConstructorDescriptor) build);
            }
            return arrayList2;
        }
        g = C8214m.g();
        return g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f7, code lost:
        if (r2 != 3) goto L44;
     */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getFunctions(@org.jetbrains.annotations.NotNull final tb.ni1 r7, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctions(tb.ni1, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Collection");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @NotNull
    public Collection<z71> getSupertypes(@NotNull ClassDescriptor classDescriptor) {
        List g;
        List e;
        List j;
        b41.i(classDescriptor, "classDescriptor");
        ip0 j2 = DescriptorUtilsKt.j(classDescriptor);
        r61 r61Var = r61.INSTANCE;
        if (r61Var.i(j2)) {
            fd2 h2 = h();
            b41.h(h2, "cloneableType");
            j = C8214m.j(h2, this.d);
            return j;
        } else if (r61Var.j(j2)) {
            e = C8213l.e(this.d);
            return e;
        } else {
            g = C8214m.g();
            return g;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        b41.i(classDescriptor, "classDescriptor");
        b41.i(simpleFunctionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor k = k(classDescriptor);
        if (k != null && simpleFunctionDescriptor.getAnnotations().hasAnnotation(rs1.a())) {
            if (n().b()) {
                String c = mf1.c(simpleFunctionDescriptor, false, false, 3, null);
                LazyJavaClassMemberScope unsubstitutedMemberScope = k.getUnsubstitutedMemberScope();
                ni1 name = simpleFunctionDescriptor.getName();
                b41.h(name, "functionDescriptor.name");
                Collection<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
                if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
                    for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : contributedFunctions) {
                        if (b41.d(mf1.c(simpleFunctionDescriptor2, false, false, 3, null), c)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @NotNull
    /* renamed from: j */
    public Set<ni1> getFunctionsNames(@NotNull ClassDescriptor classDescriptor) {
        Set<ni1> d;
        LazyJavaClassMemberScope unsubstitutedMemberScope;
        Set<ni1> d2;
        b41.i(classDescriptor, "classDescriptor");
        if (!n().b()) {
            d2 = C8203e0.d();
            return d2;
        }
        LazyJavaClassDescriptor k = k(classDescriptor);
        Set<ni1> set = null;
        if (k != null && (unsubstitutedMemberScope = k.getUnsubstitutedMemberScope()) != null) {
            set = unsubstitutedMemberScope.getFunctionNames();
        }
        if (set == null) {
            d = C8203e0.d();
            return d;
        }
        return set;
    }
}
