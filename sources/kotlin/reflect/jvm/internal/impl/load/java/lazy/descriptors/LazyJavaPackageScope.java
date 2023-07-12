package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.AbstractC5658c;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C8203e0;
import kotlin.collections.C8214m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.af2;
import tb.b41;
import tb.hj;
import tb.hp0;
import tb.k50;
import tb.ni1;
import tb.r81;
import tb.s81;
import tb.w71;
import tb.z60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyJavaPackageScope extends s81 {
    @NotNull
    private final JavaPackage m;
    @NotNull
    private final LazyJavaPackageFragment n;
    @NotNull
    private final NullableLazyValue<Set<String>> o;
    @NotNull
    private final MemoizedFunctionToNullable<C8346a, ClassDescriptor> p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$a */
    /* loaded from: classes3.dex */
    public static final class C8346a {
        @NotNull
        private final ni1 a;
        @Nullable
        private final JavaClass b;

        public C8346a(@NotNull ni1 ni1Var, @Nullable JavaClass javaClass) {
            b41.i(ni1Var, "name");
            this.a = ni1Var;
            this.b = javaClass;
        }

        @Nullable
        public final JavaClass a() {
            return this.b;
        }

        @NotNull
        public final ni1 b() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof C8346a) && b41.d(this.a, ((C8346a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$b */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC8347b {

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$b$a */
        /* loaded from: classes3.dex */
        public static final class C8348a extends AbstractC8347b {
            @NotNull
            private final ClassDescriptor a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8348a(@NotNull ClassDescriptor classDescriptor) {
                super(null);
                b41.i(classDescriptor, "descriptor");
                this.a = classDescriptor;
            }

            @NotNull
            public final ClassDescriptor a() {
                return this.a;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$b$b */
        /* loaded from: classes3.dex */
        public static final class C8349b extends AbstractC8347b {
            @NotNull
            public static final C8349b INSTANCE = new C8349b();

            private C8349b() {
                super(null);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$b$c */
        /* loaded from: classes3.dex */
        public static final class C8350c extends AbstractC8347b {
            @NotNull
            public static final C8350c INSTANCE = new C8350c();

            private C8350c() {
                super(null);
            }
        }

        private AbstractC8347b() {
        }

        public /* synthetic */ AbstractC8347b(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(@NotNull final r81 r81Var, @NotNull JavaPackage javaPackage, @NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(r81Var);
        b41.i(r81Var, AbstractC5658c.a);
        b41.i(javaPackage, "jPackage");
        b41.i(lazyJavaPackageFragment, "ownerDescriptor");
        this.m = javaPackage;
        this.n = lazyJavaPackageFragment;
        this.o = r81Var.e().createNullableLazyValue(new Function0<Set<? extends String>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$knownClassNamesInPackage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Set<? extends String> invoke() {
                return r81.this.a().d().knownClassNamesInPackage(this.v().getFqName());
            }
        });
        this.p = r81Var.e().createMemoizedFunctionWithNullableValues(new Function1<C8346a, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final ClassDescriptor invoke(@NotNull LazyJavaPackageScope.C8346a c8346a) {
                KotlinClassFinder.AbstractC8373a findKotlinClassOrContent;
                LazyJavaPackageScope.AbstractC8347b K;
                byte[] b;
                b41.i(c8346a, "request");
                hj hjVar = new hj(LazyJavaPackageScope.this.v().getFqName(), c8346a.b());
                if (c8346a.a() != null) {
                    findKotlinClassOrContent = r81Var.a().j().findKotlinClassOrContent(c8346a.a());
                } else {
                    findKotlinClassOrContent = r81Var.a().j().findKotlinClassOrContent(hjVar);
                }
                KotlinJvmBinaryClass a = findKotlinClassOrContent == null ? null : findKotlinClassOrContent.a();
                hj classId = a == null ? null : a.getClassId();
                if (classId == null || !(classId.l() || classId.k())) {
                    K = LazyJavaPackageScope.this.K(a);
                    if (K instanceof LazyJavaPackageScope.AbstractC8347b.C8348a) {
                        return ((LazyJavaPackageScope.AbstractC8347b.C8348a) K).a();
                    }
                    if (K instanceof LazyJavaPackageScope.AbstractC8347b.C8350c) {
                        return null;
                    }
                    if (K instanceof LazyJavaPackageScope.AbstractC8347b.C8349b) {
                        JavaClass a2 = c8346a.a();
                        if (a2 == null) {
                            JavaClassFinder d = r81Var.a().d();
                            if (findKotlinClassOrContent != null) {
                                if (!(findKotlinClassOrContent instanceof KotlinClassFinder.AbstractC8373a.C8374a)) {
                                    findKotlinClassOrContent = null;
                                }
                                KotlinClassFinder.AbstractC8373a.C8374a c8374a = (KotlinClassFinder.AbstractC8373a.C8374a) findKotlinClassOrContent;
                                if (c8374a != null) {
                                    b = c8374a.b();
                                    a2 = d.findClass(new JavaClassFinder.C8328a(hjVar, b, null, 4, null));
                                }
                            }
                            b = null;
                            a2 = d.findClass(new JavaClassFinder.C8328a(hjVar, b, null, 4, null));
                        }
                        JavaClass javaClass = a2;
                        if ((javaClass == null ? null : javaClass.getLightClassOriginKind()) != LightClassOriginKind.BINARY) {
                            hp0 fqName = javaClass == null ? null : javaClass.getFqName();
                            if (fqName == null || fqName.d() || !b41.d(fqName.e(), LazyJavaPackageScope.this.v().getFqName())) {
                                return null;
                            }
                            LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(r81Var, LazyJavaPackageScope.this.v(), javaClass, null, 8, null);
                            r81Var.a().e().reportClass(lazyJavaClassDescriptor);
                            return lazyJavaClassDescriptor;
                        }
                        throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass + "\nClassId: " + hjVar + "\nfindKotlinClass(JavaClass) = " + w71.a(r81Var.a().j(), javaClass) + "\nfindKotlinClass(ClassId) = " + w71.b(r81Var.a().j(), hjVar) + '\n');
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return null;
            }
        });
    }

    private final ClassDescriptor G(ni1 ni1Var, JavaClass javaClass) {
        if (af2.b(ni1Var)) {
            Set<String> invoke = this.o.invoke();
            if (javaClass != null || invoke == null || invoke.contains(ni1Var.b())) {
                return this.p.invoke(new C8346a(ni1Var, javaClass));
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC8347b K(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass == null) {
            return AbstractC8347b.C8349b.INSTANCE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().c() == KotlinClassHeader.Kind.CLASS) {
            ClassDescriptor l = p().a().b().l(kotlinJvmBinaryClass);
            return l != null ? new AbstractC8347b.C8348a(l) : AbstractC8347b.C8349b.INSTANCE;
        }
        return AbstractC8347b.C8350c.INSTANCE;
    }

    @Nullable
    public final ClassDescriptor H(@NotNull JavaClass javaClass) {
        b41.i(javaClass, "javaClass");
        return G(javaClass.getName(), javaClass);
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    /* renamed from: I */
    public ClassDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        return G(ni1Var, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    /* renamed from: J */
    public LazyJavaPackageFragment v() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    protected Set<ni1> e(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1) {
        Set<ni1> d;
        b41.i(z60Var, "kindFilter");
        if (!z60Var.a(z60.Companion.e())) {
            d = C8203e0.d();
            return d;
        }
        Set<String> invoke = this.o.invoke();
        if (invoke != null) {
            HashSet hashSet = new HashSet();
            for (String str : invoke) {
                hashSet.add(ni1.f(str));
            }
            return hashSet;
        }
        JavaPackage javaPackage = this.m;
        if (function1 == null) {
            function1 = FunctionsKt.a();
        }
        Collection<JavaClass> classes = javaPackage.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaClass javaClass : classes) {
            ni1 name = javaClass.getLightClassOriginKind() == LightClassOriginKind.SOURCE ? null : javaClass.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    protected Set<ni1> g(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1) {
        Set<ni1> d;
        b41.i(z60Var, "kindFilter");
        d = C8203e0.d();
        return d;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033 A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(@org.jetbrains.annotations.NotNull tb.z60 r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super tb.ni1, java.lang.Boolean> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "kindFilter"
            tb.b41.i(r5, r0)
            java.lang.String r0 = "nameFilter"
            tb.b41.i(r6, r0)
            tb.z60$a r0 = tb.z60.Companion
            int r1 = r0.c()
            int r0 = r0.e()
            r0 = r0 | r1
            boolean r5 = r5.a(r0)
            if (r5 != 0) goto L20
            java.util.List r5 = kotlin.collections.C8212k.g()
            goto L65
        L20:
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r5 = r4.o()
            java.lang.Object r5 = r5.invoke()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L33:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r5.next()
            r2 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r2
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L5d
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            tb.ni1 r2 = r2.getName()
            java.lang.String r3 = "it.name"
            tb.b41.h(r2, r3)
            java.lang.Object r2 = r6.invoke(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L5d
            r2 = 1
            goto L5e
        L5d:
            r2 = 0
        L5e:
            if (r2 == 0) goto L33
            r0.add(r1)
            goto L33
        L64:
            r5 = r0
        L65:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.getContributedDescriptors(tb.z60, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        List g;
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    protected DeclaredMemberIndex i() {
        return DeclaredMemberIndex.C8343a.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void k(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull ni1 ni1Var) {
        b41.i(collection, "result");
        b41.i(ni1Var, "name");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    protected Set<ni1> m(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1) {
        Set<ni1> d;
        b41.i(z60Var, "kindFilter");
        d = C8203e0.d();
        return d;
    }
}
