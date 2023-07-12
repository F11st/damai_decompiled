package kotlin.reflect.jvm.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.b71;
import tb.er2;
import tb.fx1;
import tb.ni1;
import tb.r10;
import tb.t02;
import tb.x02;
import tb.x61;
import tb.y61;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {
    private final x02.b<Data> c;
    @NotNull
    private final Class<?> d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty[] j = {a12.i(new PropertyReference1Impl(a12.b(Data.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "metadata", "getMetadata()Lkotlin/Triple;")), a12.i(new PropertyReference1Impl(a12.b(Data.class), "members", "getMembers()Ljava/util/Collection;"))};
        private final x02.a d;
        @NotNull
        private final x02.a e;
        @Nullable
        private final x02.b f;
        @Nullable
        private final x02.b g;
        @NotNull
        private final x02.a h;

        public Data() {
            super();
            this.d = x02.d(new Function0<t02>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$kotlinClass$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final t02 invoke() {
                    return t02.Factory.a(KPackageImpl.this.getJClass());
                }
            });
            this.e = x02.d(new Function0<MemberScope>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$scope$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final MemberScope invoke() {
                    t02 c;
                    c = KPackageImpl.Data.this.c();
                    if (c != null) {
                        return KPackageImpl.Data.this.a().c().a(c);
                    }
                    return MemberScope.b.INSTANCE;
                }
            });
            this.f = x02.b(new Function0<Class<?>>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$multifileFacade$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Class<?> invoke() {
                    t02 c;
                    String y;
                    KotlinClassHeader classHeader;
                    c = KPackageImpl.Data.this.c();
                    String e = (c == null || (classHeader = c.getClassHeader()) == null) ? null : classHeader.e();
                    if (e != null) {
                        if (e.length() > 0) {
                            ClassLoader classLoader = KPackageImpl.this.getJClass().getClassLoader();
                            y = o.y(e, r10.DIR, '.', false, 4, null);
                            return classLoader.loadClass(y);
                        }
                        return null;
                    }
                    return null;
                }
            });
            this.g = x02.b(new Function0<Triple<? extends y61, ? extends ProtoBuf$Package, ? extends x61>>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$metadata$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Triple<? extends y61, ? extends ProtoBuf$Package, ? extends x61> invoke() {
                    t02 c;
                    KotlinClassHeader classHeader;
                    c = KPackageImpl.Data.this.c();
                    if (c == null || (classHeader = c.getClassHeader()) == null) {
                        return null;
                    }
                    String[] a = classHeader.a();
                    String[] g = classHeader.g();
                    if (a == null || g == null) {
                        return null;
                    }
                    Pair<y61, ProtoBuf$Package> m = b71.m(a, g);
                    return new Triple<>(m.component1(), m.component2(), classHeader.d());
                }
            });
            this.h = x02.d(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$members$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KPackageImpl.Data data = KPackageImpl.Data.this;
                    return KPackageImpl.this.l(data.g(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final t02 c() {
            return (t02) this.d.b(this, j[0]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> d() {
            return (Collection) this.h.b(this, j[4]);
        }

        @Nullable
        public final Triple<y61, ProtoBuf$Package, x61> e() {
            return (Triple) this.g.b(this, j[3]);
        }

        @Nullable
        public final Class<?> f() {
            return (Class) this.f.b(this, j[2]);
        }

        @NotNull
        public final MemberScope g() {
            return (MemberScope) this.e.b(this, j[1]);
        }
    }

    public KPackageImpl(@NotNull Class<?> cls, @Nullable String str) {
        b41.i(cls, "jClass");
        this.d = cls;
        x02.b<Data> b = x02.b(new Function0<Data>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$data$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KPackageImpl.Data invoke() {
                return new KPackageImpl.Data();
            }
        });
        b41.h(b, "ReflectProperties.lazy { Data() }");
        this.c = b;
    }

    private final MemberScope u() {
        return this.c.invoke().g();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KPackageImpl) && b41.d(getJClass(), ((KPackageImpl) obj).getJClass());
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<?> getJClass() {
        return this.d;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        return this.c.invoke().d();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<ConstructorDescriptor> i() {
        List g;
        g = m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<FunctionDescriptor> j(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        return u().getContributedFunctions(ni1Var, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public PropertyDescriptor k(int i) {
        Triple<y61, ProtoBuf$Package, x61> e = this.c.invoke().e();
        if (e != null) {
            y61 component1 = e.component1();
            ProtoBuf$Package component2 = e.component2();
            x61 component3 = e.component3();
            GeneratedMessageLite.c<ProtoBuf$Package, List<ProtoBuf$Property>> cVar = JvmProtoBuf.packageLocalVariable;
            b41.h(cVar, "JvmProtoBuf.packageLocalVariable");
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) fx1.b(component2, cVar, i);
            if (protoBuf$Property != null) {
                Class<?> jClass = getJClass();
                ProtoBuf$TypeTable typeTable = component2.getTypeTable();
                b41.h(typeTable, "packageProto.typeTable");
                return (PropertyDescriptor) zv2.h(jClass, protoBuf$Property, component1, new er2(typeTable), component3, KPackageImpl$getLocalProperty$1$1$1.INSTANCE);
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    protected Class<?> m() {
        Class<?> f = this.c.invoke().f();
        return f != null ? f : getJClass();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<PropertyDescriptor> n(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        return u().getContributedVariables(ni1Var, NoLookupLocation.FROM_REFLECTION);
    }

    @NotNull
    public String toString() {
        return "file class " + ReflectClassUtilKt.a(getJClass()).b();
    }
}
