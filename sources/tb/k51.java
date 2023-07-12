package tb;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l51;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class k51 {
    @NotNull
    private static final hp0 a;
    @NotNull
    private static final hp0 b;
    @NotNull
    private static final NullabilityAnnotationStates<l51> c;
    @NotNull
    private static final l51 d;

    static {
        Map l;
        hp0 hp0Var = new hp0("org.jspecify.nullness");
        a = hp0Var;
        hp0 hp0Var2 = new hp0("org.checkerframework.checker.nullness.compatqual");
        b = hp0Var2;
        hp0 hp0Var3 = new hp0("org.jetbrains.annotations");
        l51.a aVar = l51.Companion;
        hp0 hp0Var4 = new hp0("androidx.annotation.RecentlyNullable");
        ReportLevel reportLevel = ReportLevel.WARN;
        d81 d81Var = new d81(1, 6);
        ReportLevel reportLevel2 = ReportLevel.STRICT;
        l = kotlin.collections.x.l(hq2.a(hp0Var3, aVar.a()), hq2.a(new hp0("androidx.annotation"), aVar.a()), hq2.a(new hp0("android.support.annotation"), aVar.a()), hq2.a(new hp0("android.annotation"), aVar.a()), hq2.a(new hp0("com.android.annotations"), aVar.a()), hq2.a(new hp0("org.eclipse.jdt.annotation"), aVar.a()), hq2.a(new hp0("org.checkerframework.checker.nullness.qual"), aVar.a()), hq2.a(hp0Var2, aVar.a()), hq2.a(new hp0("javax.annotation"), aVar.a()), hq2.a(new hp0("edu.umd.cs.findbugs.annotations"), aVar.a()), hq2.a(new hp0("io.reactivex.annotations"), aVar.a()), hq2.a(hp0Var4, new l51(reportLevel, null, null, 4, null)), hq2.a(new hp0("androidx.annotation.RecentlyNonNull"), new l51(reportLevel, null, null, 4, null)), hq2.a(new hp0("lombok"), aVar.a()), hq2.a(hp0Var, new l51(reportLevel, d81Var, reportLevel2)), hq2.a(new hp0("io.reactivex.rxjava3.annotations"), new l51(reportLevel, new d81(1, 7), reportLevel2)));
        c = new NullabilityAnnotationStatesImpl(l);
        d = new l51(reportLevel, null, null, 4, null);
    }

    @NotNull
    public static final Jsr305Settings a(@NotNull d81 d81Var) {
        ReportLevel c2;
        b41.i(d81Var, "configuredKotlinVersion");
        l51 l51Var = d;
        if (l51Var.d() != null && l51Var.d().compareTo(d81Var) <= 0) {
            c2 = l51Var.b();
        } else {
            c2 = l51Var.c();
        }
        ReportLevel reportLevel = c2;
        return new Jsr305Settings(reportLevel, c(reportLevel), null, 4, null);
    }

    public static /* synthetic */ Jsr305Settings b(d81 d81Var, int i, Object obj) {
        if ((i & 1) != 0) {
            d81Var = d81.CURRENT;
        }
        return a(d81Var);
    }

    @Nullable
    public static final ReportLevel c(@NotNull ReportLevel reportLevel) {
        b41.i(reportLevel, "globalReportLevel");
        if (reportLevel == ReportLevel.WARN) {
            return null;
        }
        return reportLevel;
    }

    @NotNull
    public static final ReportLevel d(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "annotationFqName");
        return g(hp0Var, NullabilityAnnotationStates.Companion.a(), null, 4, null);
    }

    @NotNull
    public static final hp0 e() {
        return a;
    }

    @NotNull
    public static final ReportLevel f(@NotNull hp0 hp0Var, @NotNull NullabilityAnnotationStates<? extends ReportLevel> nullabilityAnnotationStates, @NotNull d81 d81Var) {
        b41.i(hp0Var, "annotation");
        b41.i(nullabilityAnnotationStates, "configuredReportLevels");
        b41.i(d81Var, "configuredKotlinVersion");
        ReportLevel reportLevel = nullabilityAnnotationStates.get(hp0Var);
        if (reportLevel == null) {
            l51 l51Var = c.get(hp0Var);
            if (l51Var == null) {
                return ReportLevel.IGNORE;
            }
            if (l51Var.d() != null && l51Var.d().compareTo(d81Var) <= 0) {
                return l51Var.b();
            }
            return l51Var.c();
        }
        return reportLevel;
    }

    public static /* synthetic */ ReportLevel g(hp0 hp0Var, NullabilityAnnotationStates nullabilityAnnotationStates, d81 d81Var, int i, Object obj) {
        if ((i & 4) != 0) {
            d81Var = d81.CURRENT;
        }
        return f(hp0Var, nullabilityAnnotationStates, d81Var);
    }
}
