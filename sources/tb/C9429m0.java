package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: tb.m0 */
/* loaded from: classes3.dex */
public final class C9429m0 extends p60 {
    @NotNull
    private final fd2 b;
    @NotNull
    private final fd2 c;

    public C9429m0(@NotNull fd2 fd2Var, @NotNull fd2 fd2Var2) {
        b41.i(fd2Var, "delegate");
        b41.i(fd2Var2, "abbreviation");
        this.b = fd2Var;
        this.c = fd2Var2;
    }

    @NotNull
    public final fd2 getExpandedType() {
        return l();
    }

    @Override // tb.p60
    @NotNull
    protected fd2 l() {
        return this.b;
    }

    @NotNull
    public final fd2 o() {
        return this.c;
    }

    @Override // tb.fd2
    @NotNull
    /* renamed from: p */
    public C9429m0 j(boolean z) {
        return new C9429m0(l().j(z), this.c.j(z));
    }

    @Override // tb.p60
    @NotNull
    /* renamed from: q */
    public C9429m0 m(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return new C9429m0((fd2) b81Var.g(l()), (fd2) b81Var.g(this.c));
    }

    @Override // tb.fd2
    @NotNull
    /* renamed from: r */
    public C9429m0 k(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return new C9429m0(l().k(annotations), this.c);
    }

    @Override // tb.p60
    @NotNull
    /* renamed from: s */
    public C9429m0 n(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        return new C9429m0(fd2Var, this.c);
    }
}
