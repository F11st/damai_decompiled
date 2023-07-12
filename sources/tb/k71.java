package tb;

import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.KType;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@SinceKotlin(version = "1.1")
/* loaded from: classes3.dex */
public final class k71 {
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final k71 star = new k71(null, null);
    @Nullable
    private final KVariance a;
    @Nullable
    private final KType b;

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
        public final k71 a(@NotNull KType kType) {
            b41.i(kType, "type");
            return new k71(KVariance.IN, kType);
        }

        @JvmStatic
        @NotNull
        public final k71 b(@NotNull KType kType) {
            b41.i(kType, "type");
            return new k71(KVariance.OUT, kType);
        }

        @NotNull
        public final k71 c() {
            return k71.star;
        }

        @JvmStatic
        @NotNull
        public final k71 d(@NotNull KType kType) {
            b41.i(kType, "type");
            return new k71(KVariance.INVARIANT, kType);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public k71(@Nullable KVariance kVariance, @Nullable KType kType) {
        String str;
        this.a = kVariance;
        this.b = kType;
        if ((kVariance == null) == (kType == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @Nullable
    public final KVariance a() {
        return this.a;
    }

    @Nullable
    public final KType b() {
        return this.b;
    }

    @Nullable
    public final KType c() {
        return this.b;
    }

    @Nullable
    public final KVariance d() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k71) {
            k71 k71Var = (k71) obj;
            return this.a == k71Var.a && b41.d(this.b, k71Var.b);
        }
        return false;
    }

    public int hashCode() {
        KVariance kVariance = this.a;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        KType kType = this.b;
        return hashCode + (kType != null ? kType.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        KVariance kVariance = this.a;
        int i = kVariance == null ? -1 : b.$EnumSwitchMapping$0[kVariance.ordinal()];
        if (i != -1) {
            if (i != 1) {
                if (i == 2) {
                    return "in " + this.b;
                } else if (i == 3) {
                    return "out " + this.b;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return String.valueOf(this.b);
        }
        return jn1.MUL;
    }
}
