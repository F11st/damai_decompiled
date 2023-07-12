package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class gx1 {
    @NotNull
    private final NameResolver a;
    @NotNull
    private final er2 b;
    @Nullable
    private final SourceElement c;

    /* compiled from: Taobao */
    /* renamed from: tb.gx1$a */
    /* loaded from: classes3.dex */
    public static final class C9189a extends gx1 {
        @NotNull
        private final ProtoBuf$Class d;
        @Nullable
        private final C9189a e;
        @NotNull
        private final hj f;
        @NotNull
        private final ProtoBuf$Class.Kind g;
        private final boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9189a(@NotNull ProtoBuf$Class protoBuf$Class, @NotNull NameResolver nameResolver, @NotNull er2 er2Var, @Nullable SourceElement sourceElement, @Nullable C9189a c9189a) {
            super(nameResolver, er2Var, sourceElement, null);
            b41.i(protoBuf$Class, "classProto");
            b41.i(nameResolver, "nameResolver");
            b41.i(er2Var, "typeTable");
            this.d = protoBuf$Class;
            this.e = c9189a;
            this.f = pi1.a(nameResolver, protoBuf$Class.getFqName());
            ProtoBuf$Class.Kind d = yj0.CLASS_KIND.d(protoBuf$Class.getFlags());
            this.g = d == null ? ProtoBuf$Class.Kind.CLASS : d;
            Boolean d2 = yj0.IS_INNER.d(protoBuf$Class.getFlags());
            b41.h(d2, "IS_INNER.get(classProto.flags)");
            this.h = d2.booleanValue();
        }

        @Override // tb.gx1
        @NotNull
        public hp0 a() {
            hp0 b = this.f.b();
            b41.h(b, "classId.asSingleFqName()");
            return b;
        }

        @NotNull
        public final hj e() {
            return this.f;
        }

        @NotNull
        public final ProtoBuf$Class f() {
            return this.d;
        }

        @NotNull
        public final ProtoBuf$Class.Kind g() {
            return this.g;
        }

        @Nullable
        public final C9189a h() {
            return this.e;
        }

        public final boolean i() {
            return this.h;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.gx1$b */
    /* loaded from: classes3.dex */
    public static final class C9190b extends gx1 {
        @NotNull
        private final hp0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9190b(@NotNull hp0 hp0Var, @NotNull NameResolver nameResolver, @NotNull er2 er2Var, @Nullable SourceElement sourceElement) {
            super(nameResolver, er2Var, sourceElement, null);
            b41.i(hp0Var, "fqName");
            b41.i(nameResolver, "nameResolver");
            b41.i(er2Var, "typeTable");
            this.d = hp0Var;
        }

        @Override // tb.gx1
        @NotNull
        public hp0 a() {
            return this.d;
        }
    }

    private gx1(NameResolver nameResolver, er2 er2Var, SourceElement sourceElement) {
        this.a = nameResolver;
        this.b = er2Var;
        this.c = sourceElement;
    }

    public /* synthetic */ gx1(NameResolver nameResolver, er2 er2Var, SourceElement sourceElement, k50 k50Var) {
        this(nameResolver, er2Var, sourceElement);
    }

    @NotNull
    public abstract hp0 a();

    @NotNull
    public final NameResolver b() {
        return this.a;
    }

    @Nullable
    public final SourceElement c() {
        return this.c;
    }

    @NotNull
    public final er2 d() {
        return this.b;
    }

    @NotNull
    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + a();
    }
}
