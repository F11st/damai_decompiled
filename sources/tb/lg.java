package tb;

import java.util.Collection;
import java.util.List;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class lg implements CapturedTypeConstructor {
    @NotNull
    private final TypeProjection a;
    @Nullable
    private NewCapturedTypeConstructor b;

    public lg(@NotNull TypeProjection typeProjection) {
        b41.i(typeProjection, "projection");
        this.a = typeProjection;
        getProjection().getProjectionKind();
        Variance variance = Variance.INVARIANT;
    }

    @Nullable
    public Void a() {
        return null;
    }

    @Nullable
    public final NewCapturedTypeConstructor b() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: c */
    public lg refine(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        TypeProjection refine = getProjection().refine(b81Var);
        b41.h(refine, "projection.refine(kotlinTypeRefiner)");
        return new lg(refine);
    }

    public final void d(@Nullable NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.b = newCapturedTypeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public AbstractC8271b getBuiltIns() {
        AbstractC8271b builtIns = getProjection().getType().c().getBuiltIns();
        b41.h(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
        return (ClassifierDescriptor) a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> g;
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    @NotNull
    public TypeProjection getProjection() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public Collection<z71> getSupertypes() {
        z71 I;
        List e;
        if (getProjection().getProjectionKind() == Variance.OUT_VARIANCE) {
            I = getProjection().getType();
        } else {
            I = getBuiltIns().I();
        }
        b41.h(I, "if (projection.projectio… builtIns.nullableAnyType");
        e = C8213l.e(I);
        return e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public String toString() {
        return "CapturedTypeConstructor(" + getProjection() + ')';
    }
}
