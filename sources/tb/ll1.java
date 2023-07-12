package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ll1 extends p60 implements NotNullTypeVariable {
    @NotNull
    private final fd2 b;

    public ll1(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        this.b = fd2Var;
    }

    private final fd2 o(fd2 fd2Var) {
        fd2 j = fd2Var.j(false);
        return !TypeUtilsKt.o(fd2Var) ? j : new ll1(j);
    }

    @Override // tb.p60, tb.z71
    public boolean d() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        return true;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: j */
    public fd2 g(boolean z) {
        return z ? l().j(true) : this;
    }

    @Override // tb.p60
    @NotNull
    protected fd2 l() {
        return this.b;
    }

    @Override // tb.fd2
    @NotNull
    /* renamed from: p */
    public ll1 k(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return new ll1(l().k(annotations));
    }

    @Override // tb.p60
    @NotNull
    /* renamed from: q */
    public ll1 n(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        return new ll1(fd2Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    @NotNull
    public z71 substitutionResult(@NotNull z71 z71Var) {
        b41.i(z71Var, "replacement");
        gu2 f = z71Var.f();
        if (TypeUtilsKt.o(f) || fr2.m(f)) {
            if (f instanceof fd2) {
                return o((fd2) f);
            }
            if (f instanceof ak0) {
                ak0 ak0Var = (ak0) f;
                return gr2.e(KotlinTypeFactory.d(o(ak0Var.k()), o(ak0Var.l())), gr2.a(f));
            }
            throw new IllegalStateException(b41.r("Incorrect type: ", f).toString());
        }
        return f;
    }
}
