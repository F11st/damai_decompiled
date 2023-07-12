package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.b81;
import tb.fd2;
import tb.kf0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.types.e */
/* loaded from: classes3.dex */
public final class C8550e extends fd2 {
    @NotNull
    private final TypeConstructor b;
    @NotNull
    private final List<TypeProjection> c;
    private final boolean d;
    @NotNull
    private final MemberScope e;
    @NotNull
    private final Function1<b81, fd2> f;

    /* JADX WARN: Multi-variable type inference failed */
    public C8550e(@NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z, @NotNull MemberScope memberScope, @NotNull Function1<? super b81, ? extends fd2> function1) {
        b41.i(typeConstructor, "constructor");
        b41.i(list, "arguments");
        b41.i(memberScope, "memberScope");
        b41.i(function1, "refinedTypeFactory");
        this.b = typeConstructor;
        this.c = list;
        this.d = z;
        this.e = memberScope;
        this.f = function1;
        if (getMemberScope() instanceof kf0.C9354d) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + getMemberScope() + '\n' + c());
        }
    }

    @Override // tb.z71
    @NotNull
    public List<TypeProjection> b() {
        return this.c;
    }

    @Override // tb.z71
    @NotNull
    public TypeConstructor c() {
        return this.b;
    }

    @Override // tb.z71
    public boolean d() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.b();
    }

    @Override // tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        return this.e;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: j */
    public fd2 g(boolean z) {
        if (z == d()) {
            return this;
        }
        if (z) {
            return new C8549d(this);
        }
        return new C8545c(this);
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: k */
    public fd2 i(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return annotations.isEmpty() ? this : new C8543a(this, annotations);
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: l */
    public fd2 h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        fd2 invoke = this.f.invoke(b81Var);
        return invoke == null ? this : invoke;
    }
}
