package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.youku.arch.v3.data.Constants;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.d0;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b71;
import tb.ej;
import tb.g21;
import tb.h70;
import tb.i70;
import tb.k50;
import tb.ni1;
import tb.o70;
import tb.x61;
import tb.y61;
import tb.y71;
import tb.z61;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class DeserializedDescriptorResolver {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Set<KotlinClassHeader.Kind> b;
    @NotNull
    private static final Set<KotlinClassHeader.Kind> c;
    @NotNull
    private static final x61 d;
    @NotNull
    private static final x61 e;
    @NotNull
    private static final x61 f;
    public h70 a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final x61 a() {
            return DeserializedDescriptorResolver.f;
        }
    }

    static {
        Set<KotlinClassHeader.Kind> c2;
        Set<KotlinClassHeader.Kind> g;
        c2 = d0.c(KotlinClassHeader.Kind.CLASS);
        b = c2;
        g = e0.g(KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        c = g;
        d = new x61(1, 1, 2);
        e = new x61(1, 1, 11);
        f = new x61(1, 1, 13);
    }

    private final DeserializedContainerAbiStability d(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return e().g().getAllowUnstableDependencies() ? DeserializedContainerAbiStability.STABLE : kotlinJvmBinaryClass.getClassHeader().j() ? DeserializedContainerAbiStability.FIR_UNSTABLE : kotlinJvmBinaryClass.getClassHeader().k() ? DeserializedContainerAbiStability.IR_UNSTABLE : DeserializedContainerAbiStability.STABLE;
    }

    private final g21<x61> f(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (g() || kotlinJvmBinaryClass.getClassHeader().d().h()) {
            return null;
        }
        return new g21<>(kotlinJvmBinaryClass.getClassHeader().d(), x61.INSTANCE, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g() {
        return e().g().getSkipMetadataVersionCheck();
    }

    private final boolean h(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return !e().g().getSkipPrereleaseCheck() && kotlinJvmBinaryClass.getClassHeader().i() && b41.d(kotlinJvmBinaryClass.getClassHeader().d(), e);
    }

    private final boolean i(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return (e().g().getReportErrorsOnPreReleaseDependencies() && (kotlinJvmBinaryClass.getClassHeader().i() || b41.d(kotlinJvmBinaryClass.getClassHeader().d(), d))) || h(kotlinJvmBinaryClass);
    }

    private final String[] k(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] a2 = classHeader.a();
        if (a2 == null) {
            a2 = classHeader.b();
        }
        if (a2 != null && set.contains(classHeader.c())) {
            return a2;
        }
        return null;
    }

    @Nullable
    public final MemberScope c(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] g;
        Pair<y61, ProtoBuf$Package> pair;
        b41.i(packageFragmentDescriptor, "descriptor");
        b41.i(kotlinJvmBinaryClass, "kotlinClass");
        String[] k = k(kotlinJvmBinaryClass, c);
        if (k == null || (g = kotlinJvmBinaryClass.getClassHeader().g()) == null) {
            return null;
        }
        try {
            try {
                pair = b71.m(k, g);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(b41.r("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (g() || kotlinJvmBinaryClass.getClassHeader().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        y61 component1 = pair.component1();
        ProtoBuf$Package component2 = pair.component2();
        z61 z61Var = new z61(kotlinJvmBinaryClass, component2, component1, f(kotlinJvmBinaryClass), i(kotlinJvmBinaryClass), d(kotlinJvmBinaryClass));
        return new o70(packageFragmentDescriptor, component2, component1, kotlinJvmBinaryClass.getClassHeader().d(), z61Var, e(), "scope for " + z61Var + " in " + packageFragmentDescriptor, new Function0<Collection<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver$createKotlinPackagePartScope$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Collection<? extends ni1> invoke() {
                List g2;
                g2 = m.g();
                return g2;
            }
        });
    }

    @NotNull
    public final h70 e() {
        h70 h70Var = this.a;
        if (h70Var != null) {
            return h70Var;
        }
        b41.A(Constants.COMPONENT);
        return null;
    }

    @Nullable
    public final ej j(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] g;
        Pair<y61, ProtoBuf$Class> pair;
        b41.i(kotlinJvmBinaryClass, "kotlinClass");
        String[] k = k(kotlinJvmBinaryClass, b);
        if (k == null || (g = kotlinJvmBinaryClass.getClassHeader().g()) == null) {
            return null;
        }
        try {
            try {
                pair = b71.i(k, g);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(b41.r("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (g() || kotlinJvmBinaryClass.getClassHeader().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        return new ej(pair.component1(), pair.component2(), kotlinJvmBinaryClass.getClassHeader().d(), new y71(kotlinJvmBinaryClass, f(kotlinJvmBinaryClass), i(kotlinJvmBinaryClass), d(kotlinJvmBinaryClass)));
    }

    @Nullable
    public final ClassDescriptor l(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        b41.i(kotlinJvmBinaryClass, "kotlinClass");
        ej j = j(kotlinJvmBinaryClass);
        if (j == null) {
            return null;
        }
        return e().f().d(kotlinJvmBinaryClass.getClassId(), j);
    }

    public final void m(@NotNull h70 h70Var) {
        b41.i(h70Var, "<set-?>");
        this.a = h70Var;
    }

    public final void n(@NotNull i70 i70Var) {
        b41.i(i70Var, Constants.COMPONENT);
        m(i70Var.a());
    }
}
