package tb;

import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class wf2 extends yq2 {
    @NotNull
    private final z71 a;

    public wf2(@NotNull kotlin.reflect.jvm.internal.impl.builtins.b bVar) {
        b41.i(bVar, "kotlinBuiltIns");
        fd2 I = bVar.I();
        b41.h(I, "kotlinBuiltIns.nullableAnyType");
        this.a = I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public z71 getType() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public TypeProjection refine(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this;
    }
}
