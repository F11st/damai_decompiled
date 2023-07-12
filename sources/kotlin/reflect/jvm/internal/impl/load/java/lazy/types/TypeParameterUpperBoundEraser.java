package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.C8201d0;
import kotlin.collections.C8212k;
import kotlin.collections.C8215n;
import kotlin.collections.C8225w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fd2;
import tb.hq2;
import tb.k50;
import tb.kf0;
import tb.oq2;
import tb.q51;
import tb.ty1;
import tb.u51;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class TypeParameterUpperBoundEraser {
    @NotNull
    private final LockBasedStorageManager a;
    @NotNull
    private final Lazy b;
    @NotNull
    private final RawSubstitution c;
    @NotNull
    private final MemoizedFunctionToNotNull<C8356a, z71> d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser$a */
    /* loaded from: classes3.dex */
    public static final class C8356a {
        @NotNull
        private final TypeParameterDescriptor a;
        private final boolean b;
        @NotNull
        private final q51 c;

        public C8356a(@NotNull TypeParameterDescriptor typeParameterDescriptor, boolean z, @NotNull q51 q51Var) {
            b41.i(typeParameterDescriptor, "typeParameter");
            b41.i(q51Var, "typeAttr");
            this.a = typeParameterDescriptor;
            this.b = z;
            this.c = q51Var;
        }

        @NotNull
        public final q51 a() {
            return this.c;
        }

        @NotNull
        public final TypeParameterDescriptor b() {
            return this.a;
        }

        public final boolean c() {
            return this.b;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof C8356a) {
                C8356a c8356a = (C8356a) obj;
                return b41.d(c8356a.a, this.a) && c8356a.b == this.b && c8356a.c.d() == this.c.d() && c8356a.c.e() == this.c.e() && c8356a.c.g() == this.c.g() && b41.d(c8356a.c.c(), this.c.c());
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode();
            int i = hashCode + (hashCode * 31) + (this.b ? 1 : 0);
            int hashCode2 = i + (i * 31) + this.c.d().hashCode();
            int hashCode3 = hashCode2 + (hashCode2 * 31) + this.c.e().hashCode();
            int i2 = hashCode3 + (hashCode3 * 31) + (this.c.g() ? 1 : 0);
            int i3 = i2 * 31;
            fd2 c = this.c.c();
            return i2 + i3 + (c != null ? c.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.a + ", isRaw=" + this.b + ", typeAttr=" + this.c + ')';
        }
    }

    public TypeParameterUpperBoundEraser(@Nullable RawSubstitution rawSubstitution) {
        Lazy b;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasion results");
        this.a = lockBasedStorageManager;
        b = C8177b.b(new Function0<fd2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser$erroneousErasedBound$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final fd2 invoke() {
                return kf0.j("Can't compute erased upper bound of type parameter `" + TypeParameterUpperBoundEraser.this + '`');
            }
        });
        this.b = b;
        this.c = rawSubstitution == null ? new RawSubstitution(this) : rawSubstitution;
        MemoizedFunctionToNotNull<C8356a, z71> createMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new Function1<C8356a, z71>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser$getErasedUpperBound$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final z71 invoke(TypeParameterUpperBoundEraser.C8356a c8356a) {
                z71 d;
                d = TypeParameterUpperBoundEraser.this.d(c8356a.b(), c8356a.c(), c8356a.a());
                return d;
            }
        });
        b41.h(createMemoizedFunction, "storage.createMemoizedFu… isRaw, typeAttr) }\n    }");
        this.d = createMemoizedFunction;
    }

    private final z71 b(q51 q51Var) {
        fd2 c = q51Var.c();
        z71 t = c == null ? null : TypeUtilsKt.t(c);
        if (t == null) {
            fd2 e = e();
            b41.h(e, "erroneousErasedBound");
            return e;
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final z71 d(TypeParameterDescriptor typeParameterDescriptor, boolean z, q51 q51Var) {
        int q;
        int e;
        int a;
        TypeProjection j;
        Set<TypeParameterDescriptor> f = q51Var.f();
        if (f != null && f.contains(typeParameterDescriptor.getOriginal())) {
            return b(q51Var);
        }
        fd2 defaultType = typeParameterDescriptor.getDefaultType();
        b41.h(defaultType, "typeParameter.defaultType");
        Set<TypeParameterDescriptor> f2 = TypeUtilsKt.f(defaultType, f);
        q = C8215n.q(f2, 10);
        e = C8225w.e(q);
        a = ty1.a(e, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a);
        for (TypeParameterDescriptor typeParameterDescriptor2 : f2) {
            if (f != null && f.contains(typeParameterDescriptor2)) {
                j = u51.b(typeParameterDescriptor2, q51Var);
            } else {
                RawSubstitution rawSubstitution = this.c;
                q51 i = z ? q51Var : q51Var.i(JavaTypeFlexibility.INFLEXIBLE);
                z71 c = c(typeParameterDescriptor2, z, q51Var.j(typeParameterDescriptor));
                b41.h(c, "getErasedUpperBound(it, …Parameter(typeParameter))");
                j = rawSubstitution.j(typeParameterDescriptor2, i, c);
            }
            Pair a2 = hq2.a(typeParameterDescriptor2.getTypeConstructor(), j);
            linkedHashMap.put(a2.getFirst(), a2.getSecond());
        }
        TypeSubstitutor g = TypeSubstitutor.g(oq2.C9530a.e(oq2.Companion, linkedHashMap, false, 2, null));
        b41.h(g, "create(TypeConstructorSu…rsMap(erasedUpperBounds))");
        List<z71> upperBounds = typeParameterDescriptor.getUpperBounds();
        b41.h(upperBounds, "typeParameter.upperBounds");
        z71 z71Var = (z71) C8212k.P(upperBounds);
        if (z71Var.c().getDeclarationDescriptor() instanceof ClassDescriptor) {
            b41.h(z71Var, "firstUpperBound");
            return TypeUtilsKt.s(z71Var, g, linkedHashMap, Variance.OUT_VARIANCE, q51Var.f());
        }
        Set<TypeParameterDescriptor> f3 = q51Var.f();
        if (f3 == null) {
            f3 = C8201d0.c(this);
        }
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) declarationDescriptor;
            if (!f3.contains(typeParameterDescriptor3)) {
                List<z71> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
                b41.h(upperBounds2, "current.upperBounds");
                z71 z71Var2 = (z71) C8212k.P(upperBounds2);
                if (z71Var2.c().getDeclarationDescriptor() instanceof ClassDescriptor) {
                    b41.h(z71Var2, "nextUpperBound");
                    return TypeUtilsKt.s(z71Var2, g, linkedHashMap, Variance.OUT_VARIANCE, q51Var.f());
                }
                declarationDescriptor = z71Var2.c().getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            } else {
                return b(q51Var);
            }
        }
    }

    private final fd2 e() {
        return (fd2) this.b.getValue();
    }

    public final z71 c(@NotNull TypeParameterDescriptor typeParameterDescriptor, boolean z, @NotNull q51 q51Var) {
        b41.i(typeParameterDescriptor, "typeParameter");
        b41.i(q51Var, "typeAttr");
        return this.d.invoke(new C8356a(typeParameterDescriptor, z, q51Var));
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(RawSubstitution rawSubstitution, int i, k50 k50Var) {
        this((i & 1) != 0 ? null : rawSubstitution);
    }
}
