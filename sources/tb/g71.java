package tb;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C8212k;
import kotlin.collections.C8213l;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
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
public final class g71 extends fn<AbstractC9159b> {
    @NotNull
    public static final C9158a Companion = new C9158a(null);

    /* compiled from: Taobao */
    /* renamed from: tb.g71$a */
    /* loaded from: classes3.dex */
    public static final class C9158a {
        private C9158a() {
        }

        public /* synthetic */ C9158a(k50 k50Var) {
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
            while (AbstractC8271b.c0(z71Var2)) {
                z71Var2 = ((TypeProjection) C8212k.q0(z71Var2.b())).getType();
                b41.h(z71Var2, "type.arguments.single().type");
                i++;
            }
            ClassifierDescriptor declarationDescriptor = z71Var2.c().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                hj h = DescriptorUtilsKt.h(declarationDescriptor);
                return h == null ? new g71(new AbstractC9159b.C9160a(z71Var)) : new g71(h, i);
            } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
                hj m = hj.m(C8277c.C8278a.any.l());
                b41.h(m, "topLevel(StandardNames.FqNames.any.toSafe())");
                return new g71(m, 0);
            } else {
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.g71$b */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC9159b {

        /* compiled from: Taobao */
        /* renamed from: tb.g71$b$a */
        /* loaded from: classes3.dex */
        public static final class C9160a extends AbstractC9159b {
            @NotNull
            private final z71 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9160a(@NotNull z71 z71Var) {
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
                return (obj instanceof C9160a) && b41.d(this.a, ((C9160a) obj).a);
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
        /* renamed from: tb.g71$b$b */
        /* loaded from: classes3.dex */
        public static final class C9161b extends AbstractC9159b {
            @NotNull
            private final ij a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9161b(@NotNull ij ijVar) {
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
                return (obj instanceof C9161b) && b41.d(this.a, ((C9161b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            @NotNull
            public String toString() {
                return "NormalClass(value=" + this.a + ')';
            }
        }

        private AbstractC9159b() {
        }

        public /* synthetic */ AbstractC9159b(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g71(@NotNull AbstractC9159b abstractC9159b) {
        super(abstractC9159b);
        b41.i(abstractC9159b, "value");
    }

    @Override // tb.fn
    @NotNull
    public z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
        List e;
        b41.i(moduleDescriptor, "module");
        Annotations b = Annotations.Companion.b();
        ClassDescriptor E = moduleDescriptor.getBuiltIns().E();
        b41.h(E, "module.builtIns.kClass");
        e = C8213l.e(new zq2(c(moduleDescriptor)));
        return KotlinTypeFactory.g(b, E, e);
    }

    @NotNull
    public final z71 c(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        AbstractC9159b b = b();
        if (b instanceof AbstractC9159b.C9160a) {
            return ((AbstractC9159b.C9160a) b()).a();
        }
        if (b instanceof AbstractC9159b.C9161b) {
            ij c = ((AbstractC9159b.C9161b) b()).c();
            hj a = c.a();
            int b2 = c.b();
            ClassDescriptor a2 = FindClassInModuleKt.a(moduleDescriptor, a);
            if (a2 == null) {
                fd2 j = kf0.j("Unresolved type: " + a + " (arrayDimensions=" + b2 + ')');
                b41.h(j, "createErrorType(\"Unresol…sions=$arrayDimensions)\")");
                return j;
            }
            fd2 defaultType = a2.getDefaultType();
            b41.h(defaultType, "descriptor.defaultType");
            z71 t = TypeUtilsKt.t(defaultType);
            for (int i = 0; i < b2; i++) {
                t = moduleDescriptor.getBuiltIns().l(Variance.INVARIANT, t);
                b41.h(t, "module.builtIns.getArray…Variance.INVARIANT, type)");
            }
            return t;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g71(@NotNull ij ijVar) {
        this(new AbstractC9159b.C9161b(ijVar));
        b41.i(ijVar, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g71(@NotNull hj hjVar, int i) {
        this(new ij(hjVar, i));
        b41.i(hjVar, "classId");
    }
}
