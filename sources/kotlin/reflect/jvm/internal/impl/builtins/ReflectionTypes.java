package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.hj;
import tb.jg;
import tb.k50;
import tb.ni1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ReflectionTypes {
    @NotNull
    private final NotFoundClasses a;
    @NotNull
    private final Lazy b;
    @NotNull
    private final a c;
    static final /* synthetic */ KProperty<Object>[] d = {a12.i(new PropertyReference1Impl(a12.b(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(ReflectionTypes.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(ReflectionTypes.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private final int a;

        public a(int i) {
            this.a = i;
        }

        @NotNull
        public final ClassDescriptor a(@NotNull ReflectionTypes reflectionTypes, @NotNull KProperty<?> kProperty) {
            b41.i(reflectionTypes, "types");
            b41.i(kProperty, "property");
            return reflectionTypes.b(jg.a(kProperty.getName()), this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k50 k50Var) {
            this();
        }

        @Nullable
        public final z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
            List e;
            b41.i(moduleDescriptor, "module");
            ClassDescriptor a = FindClassInModuleKt.a(moduleDescriptor, c.a.kProperty);
            if (a == null) {
                return null;
            }
            Annotations b = Annotations.Companion.b();
            List<TypeParameterDescriptor> parameters = a.getTypeConstructor().getParameters();
            b41.h(parameters, "kPropertyClass.typeConstructor.parameters");
            Object q0 = k.q0(parameters);
            b41.h(q0, "kPropertyClass.typeConstructor.parameters.single()");
            e = l.e(new StarProjectionImpl((TypeParameterDescriptor) q0));
            return KotlinTypeFactory.g(b, a, e);
        }
    }

    public ReflectionTypes(@NotNull final ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses) {
        Lazy a2;
        b41.i(moduleDescriptor, "module");
        b41.i(notFoundClasses, "notFoundClasses");
        this.a = notFoundClasses;
        a2 = kotlin.b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<MemberScope>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes$kotlinReflectScope$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemberScope invoke() {
                return ModuleDescriptor.this.getPackage(c.KOTLIN_REFLECT_FQ_NAME).getMemberScope();
            }
        });
        this.b = a2;
        this.c = new a(1);
        new a(1);
        new a(1);
        new a(2);
        new a(3);
        new a(1);
        new a(2);
        new a(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor b(String str, int i) {
        List<Integer> e;
        ni1 f = ni1.f(str);
        b41.h(f, "identifier(className)");
        ClassifierDescriptor contributedClassifier = d().getContributedClassifier(f, NoLookupLocation.FROM_REFLECTION);
        ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        if (classDescriptor == null) {
            NotFoundClasses notFoundClasses = this.a;
            hj hjVar = new hj(c.KOTLIN_REFLECT_FQ_NAME, f);
            e = l.e(Integer.valueOf(i));
            return notFoundClasses.d(hjVar, e);
        }
        return classDescriptor;
    }

    private final MemberScope d() {
        return (MemberScope) this.b.getValue();
    }

    @NotNull
    public final ClassDescriptor c() {
        return this.c.a(this, d[0]);
    }
}
