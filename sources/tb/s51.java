package tb;

import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class s51 {
    @NotNull
    public static final C9674a Companion = new C9674a(null);
    @NotNull
    private static final s51 e = new s51(null, null, false, false, 8, null);
    @Nullable
    private final NullabilityQualifier a;
    @Nullable
    private final MutabilityQualifier b;
    private final boolean c;
    private final boolean d;

    /* compiled from: Taobao */
    /* renamed from: tb.s51$a */
    /* loaded from: classes3.dex */
    public static final class C9674a {
        private C9674a() {
        }

        public /* synthetic */ C9674a(k50 k50Var) {
            this();
        }

        @NotNull
        public final s51 a() {
            return s51.e;
        }
    }

    public s51(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.a = nullabilityQualifier;
        this.b = mutabilityQualifier;
        this.c = z;
        this.d = z2;
    }

    @Nullable
    public final MutabilityQualifier b() {
        return this.b;
    }

    @Nullable
    public final NullabilityQualifier c() {
        return this.a;
    }

    public final boolean d() {
        return this.c;
    }

    public final boolean e() {
        return this.d;
    }

    public /* synthetic */ s51(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i, k50 k50Var) {
        this(nullabilityQualifier, mutabilityQualifier, z, (i & 8) != 0 ? false : z2);
    }
}
