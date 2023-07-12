package tb;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class g71 extends fn<b> {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @Nullable
        public final fn<?> a(@NotNull z71 z71Var) {
            b41.i(z71Var, "argumentType");
            if (a81.a(z71Var)) {
                return null;
            }
            z71 z71Var2 = z71Var;
            int i = 0;
            while (kotlin.reflect.jvm.internal.impl.builtins.b.c0(z71Var2)) {
                z71Var2 = ((TypeProjection) kotlin.collections.k.q0(z71Var2.b())).getType();
                b41.h(z71Var2, "type.arguments.single().type");
                i++;
            }
            ClassifierDescriptor declarationDescriptor = z71Var2.c().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                hj h = DescriptorUtilsKt.h(declarationDescriptor);
                return h == null ? new g71(new b.a(z71Var)) : new g71(h, i);
            } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
                hj m = hj.m(c.a.any.l());
                b41.h(m, "topLevel(StandardNames.FqNames.any.toSafe())");
                return new g71(m, 0);
            } else {
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static abstract class b {

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class a extends b {
            @NotNull
            private final z71 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull z71 z71Var) {
                super(null);
                b41.i(z71Var, "type");
                this.a = z71Var;
            }

            @NotNull
            public final z71 a() {
                return this.a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && b41.d(this.a, ((a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            @NotNull
            public String toString() {
                return "LocalClass(type=" + this.a + ')';
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.g71$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0453b extends b {
            @NotNull
            private final ij a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0453b(@NotNull ij ijVar) {
                super(null);
                b41.i(ijVar, "value");
                this.a = ijVar;
            }

            public final int a() {
                return this.a.c();
            }

            @NotNull
            public final hj b() {
                return this.a.d();
            }

            @NotNull
            public final ij c() {
                return this.a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0453b) && b41.d(this.a, ((C0453b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            @NotNull
            public String toString() {
                return "NormalClass(value=" + this.a + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g71(@NotNull b bVar) {
        super(bVar);
        b41.i(bVar, "value");
    }

    @Override // tb.fn
    @NotNull
    public z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
        List e;
        b41.i(moduleDescriptor, "module");
        Annotations b2 = Annotations.Companion.b();
        ClassDescriptor E = moduleDescriptor.getBuiltIns().E();
        b41.h(E, "module.builtIns.kClass");
        e = kotlin.collections.l.e(new zq2(c(moduleDescriptor)));
        return KotlinTypeFactory.g(b2, E, e);
    }

    @NotNull
    public final z71 c(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        b b2 = b();
        if (b2 instanceof b.a) {
            return ((b.a) b()).a();
        }
        if (b2 instanceof b.C0453b) {
            ij c = ((b.C0453b) b()).c();
            hj a2 = c.a();
            int b3 = c.b();
            ClassDescriptor a3 = FindClassInModuleKt.a(moduleDescriptor, a2);
            if (a3 == null) {
                fd2 j = kf0.j("Unresolved type: " + a2 + " (arrayDimensions=" + b3 + ')');
                b41.h(j, "createErrorType(\"Unresol…sions=$arrayDimensions)\")");
                return j;
            }
            fd2 defaultType = a3.getDefaultType();
            b41.h(defaultType, "descriptor.defaultType");
            z71 t = TypeUtilsKt.t(defaultType);
            for (int i = 0; i < b3; i++) {
                t = moduleDescriptor.getBuiltIns().l(Variance.INVARIANT, t);
                b41.h(t, "module.builtIns.getArray…Variance.INVARIANT, type)");
            }
            return t;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g71(@NotNull ij ijVar) {
        this(new b.C0453b(ijVar));
        b41.i(ijVar, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g71(@NotNull hj hjVar, int i) {
        this(new ij(hjVar, i));
        b41.i(hjVar, "classId");
    }
}
