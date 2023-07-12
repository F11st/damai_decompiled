package tb;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ci2 extends l2 implements StubTypeMarker {
    @NotNull
    private final TypeConstructor e;
    @NotNull
    private final MemberScope f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci2(@NotNull TypeConstructor typeConstructor, boolean z, @NotNull TypeConstructor typeConstructor2) {
        super(typeConstructor, z);
        b41.i(typeConstructor, "originalTypeVariable");
        b41.i(typeConstructor2, "constructor");
        this.e = typeConstructor2;
        this.f = typeConstructor.getBuiltIns().i().getMemberScope();
    }

    @Override // tb.z71
    @NotNull
    public TypeConstructor c() {
        return this.e;
    }

    @Override // tb.l2, tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        return this.f;
    }

    @Override // tb.l2
    @NotNull
    public l2 m(boolean z) {
        return new ci2(l(), z, c());
    }

    @Override // tb.fd2
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stub (BI): ");
        sb.append(l());
        sb.append(d() ? "?" : "");
        return sb.toString();
    }
}
