package tb;

import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class fm1 {
    @NotNull
    private final NullabilityQualifier a;
    private final boolean b;

    public fm1(@NotNull NullabilityQualifier nullabilityQualifier, boolean z) {
        b41.i(nullabilityQualifier, "qualifier");
        this.a = nullabilityQualifier;
        this.b = z;
    }

    public static /* synthetic */ fm1 b(fm1 fm1Var, NullabilityQualifier nullabilityQualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = fm1Var.a;
        }
        if ((i & 2) != 0) {
            z = fm1Var.b;
        }
        return fm1Var.a(nullabilityQualifier, z);
    }

    @NotNull
    public final fm1 a(@NotNull NullabilityQualifier nullabilityQualifier, boolean z) {
        b41.i(nullabilityQualifier, "qualifier");
        return new fm1(nullabilityQualifier, z);
    }

    @NotNull
    public final NullabilityQualifier c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof fm1) {
            fm1 fm1Var = (fm1) obj;
            return this.a == fm1Var.a && this.b == fm1Var.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.a + ", isForWarningOnly=" + this.b + ')';
    }

    public /* synthetic */ fm1(NullabilityQualifier nullabilityQualifier, boolean z, int i, k50 k50Var) {
        this(nullabilityQualifier, (i & 2) != 0 ? false : z);
    }
}
