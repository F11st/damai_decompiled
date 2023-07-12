package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fd2;
import tb.p60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class b extends p60 {
    @NotNull
    private final fd2 b;

    public b(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        this.b = fd2Var;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: j */
    public fd2 g(boolean z) {
        return z == d() ? this : l().j(z).k(getAnnotations());
    }

    @Override // tb.p60
    @NotNull
    protected fd2 l() {
        return this.b;
    }

    @Override // tb.fd2
    @NotNull
    /* renamed from: o */
    public b k(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return annotations != getAnnotations() ? new a(this, annotations) : this;
    }
}
