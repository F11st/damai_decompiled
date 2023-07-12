package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class n60 extends br2 {
    @NotNull
    private final br2 a;

    public n60(@NotNull br2 br2Var) {
        b41.i(br2Var, "substitution");
        this.a = br2Var;
    }

    @Override // tb.br2
    public boolean a() {
        return this.a.a();
    }

    @Override // tb.br2
    @NotNull
    public Annotations d(@NotNull Annotations annotations) {
        b41.i(annotations, "annotations");
        return this.a.d(annotations);
    }

    @Override // tb.br2
    @Nullable
    public TypeProjection e(@NotNull z71 z71Var) {
        b41.i(z71Var, "key");
        return this.a.e(z71Var);
    }

    @Override // tb.br2
    public boolean f() {
        return this.a.f();
    }

    @Override // tb.br2
    @NotNull
    public z71 g(@NotNull z71 z71Var, @NotNull Variance variance) {
        b41.i(z71Var, "topLevelType");
        b41.i(variance, "position");
        return this.a.g(z71Var, variance);
    }
}
