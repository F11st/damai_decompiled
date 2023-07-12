package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.b;
import kotlin.collections.l;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hp0;
import tb.jn1;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class Jsr305Settings {
    @NotNull
    private final ReportLevel a;
    @Nullable
    private final ReportLevel b;
    @NotNull
    private final Map<hp0, ReportLevel> c;
    @NotNull
    private final Lazy d;
    private final boolean e;

    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305Settings(@NotNull ReportLevel reportLevel, @Nullable ReportLevel reportLevel2, @NotNull Map<hp0, ? extends ReportLevel> map) {
        Lazy b;
        b41.i(reportLevel, "globalLevel");
        b41.i(map, "userDefinedLevelForSpecificAnnotation");
        this.a = reportLevel;
        this.b = reportLevel2;
        this.c = map;
        b = b.b(new Function0<String[]>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings$description$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String[] invoke() {
                List c;
                List a;
                Jsr305Settings jsr305Settings = Jsr305Settings.this;
                c = l.c();
                c.add(jsr305Settings.a().getDescription());
                ReportLevel b2 = jsr305Settings.b();
                if (b2 != null) {
                    c.add(b41.r("under-migration:", b2.getDescription()));
                }
                for (Map.Entry<hp0, ReportLevel> entry : jsr305Settings.c().entrySet()) {
                    c.add('@' + entry.getKey() + jn1.CONDITION_IF_MIDDLE + entry.getValue().getDescription());
                }
                a = l.a(c);
                Object[] array = a.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                return (String[]) array;
            }
        });
        this.d = b;
        ReportLevel reportLevel3 = ReportLevel.IGNORE;
        this.e = reportLevel == reportLevel3 && reportLevel2 == reportLevel3 && map.isEmpty();
    }

    @NotNull
    public final ReportLevel a() {
        return this.a;
    }

    @Nullable
    public final ReportLevel b() {
        return this.b;
    }

    @NotNull
    public final Map<hp0, ReportLevel> c() {
        return this.c;
    }

    public final boolean d() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Jsr305Settings) {
            Jsr305Settings jsr305Settings = (Jsr305Settings) obj;
            return this.a == jsr305Settings.a && this.b == jsr305Settings.b && b41.d(this.c, jsr305Settings.c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        ReportLevel reportLevel = this.b;
        return ((hashCode + (reportLevel == null ? 0 : reportLevel.hashCode())) * 31) + this.c.hashCode();
    }

    @NotNull
    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.a + ", migrationLevel=" + this.b + ", userDefinedLevelForSpecificAnnotation=" + this.c + ')';
    }

    public /* synthetic */ Jsr305Settings(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int i, k50 k50Var) {
        this(reportLevel, (i & 2) != 0 ? null : reportLevel2, (i & 4) != 0 ? x.i() : map);
    }
}
