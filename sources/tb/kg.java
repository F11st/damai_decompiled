package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class kg extends fd2 implements CapturedTypeMarker {
    @NotNull
    private final TypeProjection b;
    @NotNull
    private final CapturedTypeConstructor c;
    private final boolean d;
    @NotNull
    private final Annotations e;

    public /* synthetic */ kg(TypeProjection typeProjection, CapturedTypeConstructor capturedTypeConstructor, boolean z, Annotations annotations, int i, k50 k50Var) {
        this(typeProjection, (i & 2) != 0 ? new lg(typeProjection) : capturedTypeConstructor, (i & 4) != 0 ? false : z, (i & 8) != 0 ? Annotations.Companion.b() : annotations);
    }

    @Override // tb.z71
    @NotNull
    public List<TypeProjection> b() {
        List<TypeProjection> g;
        g = kotlin.collections.m.g();
        return g;
    }

    @Override // tb.z71
    public boolean d() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.e;
    }

    @Override // tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope i = kf0.i("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        b41.h(i, "createErrorScope(\n      …solution\", true\n        )");
        return i;
    }

    @Override // tb.z71
    @NotNull
    /* renamed from: l */
    public CapturedTypeConstructor c() {
        return this.c;
    }

    @Override // tb.fd2
    @NotNull
    /* renamed from: m */
    public kg j(boolean z) {
        return z == d() ? this : new kg(this.b, c(), z, getAnnotations());
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: n */
    public kg h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        TypeProjection refine = this.b.refine(b81Var);
        b41.h(refine, "typeProjection.refine(kotlinTypeRefiner)");
        return new kg(refine, c(), d(), getAnnotations());
    }

    @Override // tb.fd2
    @NotNull
    /* renamed from: o */
    public kg k(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return new kg(this.b, c(), d(), annotations);
    }

    @Override // tb.fd2
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Captured(");
        sb.append(this.b);
        sb.append(')');
        sb.append(d() ? "?" : "");
        return sb.toString();
    }

    public kg(@NotNull TypeProjection typeProjection, @NotNull CapturedTypeConstructor capturedTypeConstructor, boolean z, @NotNull Annotations annotations) {
        b41.i(typeProjection, "typeProjection");
        b41.i(capturedTypeConstructor, "constructor");
        b41.i(annotations, "annotations");
        this.b = typeProjection;
        this.c = capturedTypeConstructor;
        this.d = z;
        this.e = annotations;
    }
}
