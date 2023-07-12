package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fd2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class c extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull fd2 fd2Var) {
        super(fd2Var);
        b41.i(fd2Var, "delegate");
    }

    @Override // tb.p60, tb.z71
    public boolean d() {
        return false;
    }

    @Override // tb.p60
    @NotNull
    /* renamed from: p */
    public c n(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        return new c(fd2Var);
    }
}
