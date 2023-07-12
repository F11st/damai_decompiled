package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class p60 extends fd2 {
    @Override // tb.z71
    @NotNull
    public List<TypeProjection> b() {
        return l().b();
    }

    @Override // tb.z71
    @NotNull
    public TypeConstructor c() {
        return l().c();
    }

    @Override // tb.z71
    public boolean d() {
        return l().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return l().getAnnotations();
    }

    @Override // tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        return l().getMemberScope();
    }

    @NotNull
    protected abstract fd2 l();

    @Override // tb.gu2
    @NotNull
    /* renamed from: m */
    public fd2 h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return n((fd2) b81Var.g(l()));
    }

    @NotNull
    public abstract p60 n(@NotNull fd2 fd2Var);
}
