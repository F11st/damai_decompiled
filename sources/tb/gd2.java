package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class gd2 extends p60 implements TypeWithEnhancement {
    @NotNull
    private final fd2 b;
    @NotNull
    private final z71 c;

    public gd2(@NotNull fd2 fd2Var, @NotNull z71 z71Var) {
        b41.i(fd2Var, "delegate");
        b41.i(z71Var, "enhancement");
        this.b = fd2Var;
        this.c = z71Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    @NotNull
    public z71 getEnhancement() {
        return this.c;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: j */
    public fd2 g(boolean z) {
        return (fd2) gr2.e(getOrigin().j(z), getEnhancement().f().g(z));
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: k */
    public fd2 i(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return (fd2) gr2.e(getOrigin().k(annotations), getEnhancement());
    }

    @Override // tb.p60
    @NotNull
    protected fd2 l() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    @NotNull
    /* renamed from: o */
    public fd2 getOrigin() {
        return l();
    }

    @Override // tb.p60
    @NotNull
    /* renamed from: p */
    public gd2 m(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return new gd2((fd2) b81Var.g(l()), b81Var.g(getEnhancement()));
    }

    @Override // tb.p60
    @NotNull
    /* renamed from: q */
    public gd2 n(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        return new gd2(fd2Var, getEnhancement());
    }
}
