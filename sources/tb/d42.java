package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class d42 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final h70 a;
    @NotNull
    private final lp1 b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final d42 a(@NotNull ClassLoader classLoader) {
            List g;
            List j;
            b41.i(classLoader, "classLoader");
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            ni1 i = ni1.i("<runtime module for " + classLoader + '>');
            b41.h(i, "special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(i, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.C0(moduleDescriptorImpl);
            jvmBuiltIns.H0(moduleDescriptorImpl, true);
            u02 u02Var = new u02(classLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            hd2 hd2Var = new hd2();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl);
            LazyJavaPackageFragmentProvider c = e42.c(classLoader, moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, u02Var, deserializedDescriptorResolver, hd2Var, null, 128, null);
            i70 a = e42.a(moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, c, u02Var, deserializedDescriptorResolver);
            deserializedDescriptorResolver.n(a);
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            b41.h(javaResolverCache, "EMPTY");
            d51 d51Var = new d51(c, javaResolverCache);
            hd2Var.b(d51Var);
            ClassLoader classLoader2 = wt2.class.getClassLoader();
            b41.h(classLoader2, "stdlibClassLoader");
            u02 u02Var2 = new u02(classLoader2);
            JvmBuiltInsCustomizer G0 = jvmBuiltIns.G0();
            JvmBuiltInsCustomizer G02 = jvmBuiltIns.G0();
            DeserializationConfiguration.a aVar = DeserializationConfiguration.a.INSTANCE;
            hk1 a2 = NewKotlinTypeChecker.Companion.a();
            g = kotlin.collections.m.g();
            q61 q61Var = new q61(lockBasedStorageManager, u02Var2, moduleDescriptorImpl, notFoundClasses, G0, G02, aVar, a2, new u52(lockBasedStorageManager, g));
            moduleDescriptorImpl.s(moduleDescriptorImpl);
            j = kotlin.collections.m.j(d51Var.a(), q61Var);
            moduleDescriptorImpl.m(new km(j, b41.r("CompositeProvider@RuntimeModuleData for ", moduleDescriptorImpl)));
            return new d42(a.a(), new lp1(deserializedDescriptorResolver, u02Var), null);
        }
    }

    private d42(h70 h70Var, lp1 lp1Var) {
        this.a = h70Var;
        this.b = lp1Var;
    }

    public /* synthetic */ d42(h70 h70Var, lp1 lp1Var, k50 k50Var) {
        this(h70Var, lp1Var);
    }

    @NotNull
    public final h70 a() {
        return this.a;
    }

    @NotNull
    public final ModuleDescriptor b() {
        return this.a.p();
    }

    @NotNull
    public final lp1 c() {
        return this.b;
    }
}
