package tb;

import cn.damai.common.app.ShareperfenceConstants;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class t90 extends br2 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final br2 a;
    @NotNull
    private final br2 b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @JvmStatic
        @NotNull
        public final br2 a(@NotNull br2 br2Var, @NotNull br2 br2Var2) {
            b41.i(br2Var, ShareperfenceConstants.FIRST);
            b41.i(br2Var2, "second");
            return br2Var.f() ? br2Var2 : br2Var2.f() ? br2Var : new t90(br2Var, br2Var2, null);
        }
    }

    private t90(br2 br2Var, br2 br2Var2) {
        this.a = br2Var;
        this.b = br2Var2;
    }

    public /* synthetic */ t90(br2 br2Var, br2 br2Var2, k50 k50Var) {
        this(br2Var, br2Var2);
    }

    @JvmStatic
    @NotNull
    public static final br2 i(@NotNull br2 br2Var, @NotNull br2 br2Var2) {
        return Companion.a(br2Var, br2Var2);
    }

    @Override // tb.br2
    public boolean a() {
        return this.a.a() || this.b.a();
    }

    @Override // tb.br2
    public boolean b() {
        return this.a.b() || this.b.b();
    }

    @Override // tb.br2
    @NotNull
    public Annotations d(@NotNull Annotations annotations) {
        b41.i(annotations, "annotations");
        return this.b.d(this.a.d(annotations));
    }

    @Override // tb.br2
    @Nullable
    public TypeProjection e(@NotNull z71 z71Var) {
        b41.i(z71Var, "key");
        TypeProjection e = this.a.e(z71Var);
        return e == null ? this.b.e(z71Var) : e;
    }

    @Override // tb.br2
    public boolean f() {
        return false;
    }

    @Override // tb.br2
    @NotNull
    public z71 g(@NotNull z71 z71Var, @NotNull Variance variance) {
        b41.i(z71Var, "topLevelType");
        b41.i(variance, "position");
        return this.b.g(this.a.g(z71Var, variance), variance);
    }
}
