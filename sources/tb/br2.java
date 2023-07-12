package tb;

import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class br2 {
    @NotNull
    public static final C8976b Companion = new C8976b(null);
    @JvmField
    @NotNull
    public static final br2 EMPTY = new C8975a();

    /* compiled from: Taobao */
    /* renamed from: tb.br2$a */
    /* loaded from: classes3.dex */
    public static final class C8975a extends br2 {
        C8975a() {
        }

        @Override // tb.br2
        public /* bridge */ /* synthetic */ TypeProjection e(z71 z71Var) {
            return (TypeProjection) i(z71Var);
        }

        @Override // tb.br2
        public boolean f() {
            return true;
        }

        @Nullable
        public Void i(@NotNull z71 z71Var) {
            b41.i(z71Var, "key");
            return null;
        }

        @NotNull
        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.br2$b */
    /* loaded from: classes3.dex */
    public static final class C8976b {
        private C8976b() {
        }

        public /* synthetic */ C8976b(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.br2$c */
    /* loaded from: classes3.dex */
    public static final class C8977c extends br2 {
        C8977c() {
        }

        @Override // tb.br2
        public boolean a() {
            return false;
        }

        @Override // tb.br2
        public boolean b() {
            return false;
        }

        @Override // tb.br2
        @NotNull
        public Annotations d(@NotNull Annotations annotations) {
            b41.i(annotations, "annotations");
            return br2.this.d(annotations);
        }

        @Override // tb.br2
        @Nullable
        public TypeProjection e(@NotNull z71 z71Var) {
            b41.i(z71Var, "key");
            return br2.this.e(z71Var);
        }

        @Override // tb.br2
        public boolean f() {
            return br2.this.f();
        }

        @Override // tb.br2
        @NotNull
        public z71 g(@NotNull z71 z71Var, @NotNull Variance variance) {
            b41.i(z71Var, "topLevelType");
            b41.i(variance, "position");
            return br2.this.g(z71Var, variance);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    @NotNull
    public final TypeSubstitutor c() {
        TypeSubstitutor g = TypeSubstitutor.g(this);
        b41.h(g, "create(this)");
        return g;
    }

    @NotNull
    public Annotations d(@NotNull Annotations annotations) {
        b41.i(annotations, "annotations");
        return annotations;
    }

    @Nullable
    public abstract TypeProjection e(@NotNull z71 z71Var);

    public boolean f() {
        return false;
    }

    @NotNull
    public z71 g(@NotNull z71 z71Var, @NotNull Variance variance) {
        b41.i(z71Var, "topLevelType");
        b41.i(variance, "position");
        return z71Var;
    }

    @NotNull
    public final br2 h() {
        return new C8977c();
    }
}
