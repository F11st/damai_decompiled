package tb;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class hk1 implements NewKotlinTypeChecker {
    @NotNull
    private final b81 a;
    @NotNull
    private final KotlinTypePreparator b;
    @NotNull
    private final OverridingUtil c;

    public hk1(@NotNull b81 b81Var, @NotNull KotlinTypePreparator kotlinTypePreparator) {
        b41.i(b81Var, "kotlinTypeRefiner");
        b41.i(kotlinTypePreparator, "kotlinTypePreparator");
        this.a = b81Var;
        this.b = kotlinTypePreparator;
        OverridingUtil n = OverridingUtil.n(getKotlinTypeRefiner());
        b41.h(n, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.c = n;
    }

    public final boolean a(@NotNull mj mjVar, @NotNull gu2 gu2Var, @NotNull gu2 gu2Var2) {
        b41.i(mjVar, "<this>");
        b41.i(gu2Var, "a");
        b41.i(gu2Var2, "b");
        return n2.INSTANCE.i(mjVar, gu2Var, gu2Var2);
    }

    @NotNull
    public KotlinTypePreparator b() {
        return this.b;
    }

    public final boolean c(@NotNull mj mjVar, @NotNull gu2 gu2Var, @NotNull gu2 gu2Var2) {
        b41.i(mjVar, "<this>");
        b41.i(gu2Var, "subType");
        b41.i(gu2Var2, "superType");
        return n2.q(n2.INSTANCE, mjVar, gu2Var, gu2Var2, false, 8, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(@NotNull z71 z71Var, @NotNull z71 z71Var2) {
        b41.i(z71Var, "a");
        b41.i(z71Var2, "b");
        return a(new mj(false, false, false, getKotlinTypeRefiner(), b(), null, 38, null), z71Var.f(), z71Var2.f());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    @NotNull
    public b81 getKotlinTypeRefiner() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    @NotNull
    public OverridingUtil getOverridingUtil() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(@NotNull z71 z71Var, @NotNull z71 z71Var2) {
        b41.i(z71Var, "subtype");
        b41.i(z71Var2, "supertype");
        return c(new mj(true, false, false, getKotlinTypeRefiner(), b(), null, 38, null), z71Var.f(), z71Var2.f());
    }

    public /* synthetic */ hk1(b81 b81Var, KotlinTypePreparator kotlinTypePreparator, int i, k50 k50Var) {
        this(b81Var, (i & 2) != 0 ? KotlinTypePreparator.C8547a.INSTANCE : kotlinTypePreparator);
    }
}
