package tb;

import java.util.List;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class zj1 extends fd2 implements CapturedTypeMarker {
    @NotNull
    private final CaptureStatus b;
    @NotNull
    private final NewCapturedTypeConstructor c;
    @Nullable
    private final gu2 d;
    @NotNull
    private final Annotations e;
    private final boolean f;
    private final boolean g;

    public /* synthetic */ zj1(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, gu2 gu2Var, Annotations annotations, boolean z, boolean z2, int i, k50 k50Var) {
        this(captureStatus, newCapturedTypeConstructor, gu2Var, (i & 8) != 0 ? Annotations.Companion.b() : annotations, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }

    @Override // tb.z71
    @NotNull
    public List<TypeProjection> b() {
        List<TypeProjection> g;
        g = C8214m.g();
        return g;
    }

    @Override // tb.z71
    public boolean d() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.e;
    }

    @Override // tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope i = kf0.i("No member resolution should be done on captured type!", true);
        b41.h(i, "createErrorScope(\"No mem…on captured type!\", true)");
        return i;
    }

    @NotNull
    public final CaptureStatus l() {
        return this.b;
    }

    @Override // tb.z71
    @NotNull
    /* renamed from: m */
    public NewCapturedTypeConstructor c() {
        return this.c;
    }

    @Nullable
    public final gu2 n() {
        return this.d;
    }

    public final boolean o() {
        return this.g;
    }

    @Override // tb.fd2
    @NotNull
    /* renamed from: p */
    public zj1 j(boolean z) {
        return new zj1(this.b, c(), this.d, getAnnotations(), z, false, 32, null);
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: q */
    public zj1 h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        CaptureStatus captureStatus = this.b;
        NewCapturedTypeConstructor refine = c().refine(b81Var);
        gu2 gu2Var = this.d;
        return new zj1(captureStatus, refine, gu2Var == null ? null : b81Var.g(gu2Var).f(), getAnnotations(), d(), false, 32, null);
    }

    @Override // tb.fd2
    @NotNull
    /* renamed from: r */
    public zj1 k(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return new zj1(this.b, c(), this.d, annotations, d(), false, 32, null);
    }

    public zj1(@NotNull CaptureStatus captureStatus, @NotNull NewCapturedTypeConstructor newCapturedTypeConstructor, @Nullable gu2 gu2Var, @NotNull Annotations annotations, boolean z, boolean z2) {
        b41.i(captureStatus, "captureStatus");
        b41.i(newCapturedTypeConstructor, "constructor");
        b41.i(annotations, "annotations");
        this.b = captureStatus;
        this.c = newCapturedTypeConstructor;
        this.d = gu2Var;
        this.e = annotations;
        this.f = z;
        this.g = z2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zj1(@NotNull CaptureStatus captureStatus, @Nullable gu2 gu2Var, @NotNull TypeProjection typeProjection, @NotNull TypeParameterDescriptor typeParameterDescriptor) {
        this(captureStatus, new NewCapturedTypeConstructor(typeProjection, null, null, typeParameterDescriptor, 6, null), gu2Var, null, false, false, 56, null);
        b41.i(captureStatus, "captureStatus");
        b41.i(typeProjection, "projection");
        b41.i(typeParameterDescriptor, "typeParameter");
    }
}
