package tb;

import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class l51 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final l51 d = new l51(ReportLevel.STRICT, null, null, 6, null);
    @NotNull
    private final ReportLevel a;
    @Nullable
    private final d81 b;
    @NotNull
    private final ReportLevel c;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final l51 a() {
            return l51.d;
        }
    }

    public l51(@NotNull ReportLevel reportLevel, @Nullable d81 d81Var, @NotNull ReportLevel reportLevel2) {
        b41.i(reportLevel, "reportLevelBefore");
        b41.i(reportLevel2, "reportLevelAfter");
        this.a = reportLevel;
        this.b = d81Var;
        this.c = reportLevel2;
    }

    @NotNull
    public final ReportLevel b() {
        return this.c;
    }

    @NotNull
    public final ReportLevel c() {
        return this.a;
    }

    @Nullable
    public final d81 d() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l51) {
            l51 l51Var = (l51) obj;
            return this.a == l51Var.a && b41.d(this.b, l51Var.b) && this.c == l51Var.c;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        d81 d81Var = this.b;
        return ((hashCode + (d81Var == null ? 0 : d81Var.hashCode())) * 31) + this.c.hashCode();
    }

    @NotNull
    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.a + ", sinceVersion=" + this.b + ", reportLevelAfter=" + this.c + ')';
    }

    public /* synthetic */ l51(ReportLevel reportLevel, d81 d81Var, ReportLevel reportLevel2, int i, k50 k50Var) {
        this(reportLevel, (i & 2) != 0 ? new d81(1, 0) : d81Var, (i & 4) != 0 ? reportLevel : reportLevel2);
    }
}
