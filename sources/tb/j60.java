package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class j60 extends p60 implements CustomTypeVariable, DefinitelyNotNullTypeMarker {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final fd2 b;
    private final boolean c;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        private final boolean a(gu2 gu2Var) {
            return (gu2Var.c() instanceof NewTypeVariableConstructor) || (gu2Var.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) || (gu2Var instanceof zj1) || (gu2Var instanceof ci2);
        }

        public static /* synthetic */ j60 c(a aVar, gu2 gu2Var, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return aVar.b(gu2Var, z);
        }

        private final boolean d(gu2 gu2Var, boolean z) {
            if (a(gu2Var)) {
                if (gu2Var instanceof ci2) {
                    return fr2.m(gu2Var);
                }
                if (z && (gu2Var.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
                    return fr2.m(gu2Var);
                }
                return !em1.INSTANCE.a(gu2Var);
            }
            return false;
        }

        @Nullable
        public final j60 b(@NotNull gu2 gu2Var, boolean z) {
            b41.i(gu2Var, "type");
            if (gu2Var instanceof j60) {
                return (j60) gu2Var;
            }
            if (d(gu2Var, z)) {
                if (gu2Var instanceof ak0) {
                    ak0 ak0Var = (ak0) gu2Var;
                    b41.d(ak0Var.k().c(), ak0Var.l().c());
                }
                return new j60(dk0.c(gu2Var), z, null);
            }
            return null;
        }
    }

    private j60(fd2 fd2Var, boolean z) {
        this.b = fd2Var;
        this.c = z;
    }

    public /* synthetic */ j60(fd2 fd2Var, boolean z, k50 k50Var) {
        this(fd2Var, z);
    }

    @Override // tb.p60, tb.z71
    public boolean d() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        return (l().c() instanceof NewTypeVariableConstructor) || (l().c().getDeclarationDescriptor() instanceof TypeParameterDescriptor);
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: j */
    public fd2 g(boolean z) {
        return z ? l().j(z) : this;
    }

    @Override // tb.p60
    @NotNull
    protected fd2 l() {
        return this.b;
    }

    @NotNull
    public final fd2 o() {
        return this.b;
    }

    @Override // tb.fd2
    @NotNull
    /* renamed from: p */
    public j60 k(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return new j60(l().k(annotations), this.c);
    }

    @Override // tb.p60
    @NotNull
    /* renamed from: q */
    public j60 n(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        return new j60(fd2Var, this.c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    @NotNull
    public z71 substitutionResult(@NotNull z71 z71Var) {
        b41.i(z71Var, "replacement");
        return bf2.e(z71Var.f(), this.c);
    }

    @Override // tb.fd2
    @NotNull
    public String toString() {
        return l() + "!!";
    }
}
