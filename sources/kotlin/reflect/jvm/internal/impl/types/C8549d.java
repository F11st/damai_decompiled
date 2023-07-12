package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fd2;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.types.d */
/* loaded from: classes3.dex */
final class C8549d extends AbstractC8544b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8549d(@NotNull fd2 fd2Var) {
        super(fd2Var);
        b41.i(fd2Var, "delegate");
    }

    @Override // tb.p60, tb.z71
    public boolean d() {
        return true;
    }

    @Override // tb.p60
    @NotNull
    /* renamed from: p */
    public C8549d n(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        return new C8549d(fd2Var);
    }
}
