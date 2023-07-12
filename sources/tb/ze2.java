package tb;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ze2 {
    @NotNull
    public static final ze2 INSTANCE = new ze2();
    @NotNull
    private static final Set<hj> a;

    static {
        List<hp0> j;
        j = kotlin.collections.m.j(o61.METADATA_FQ_NAME, o61.JETBRAINS_NOT_NULL_ANNOTATION, o61.JETBRAINS_NULLABLE_ANNOTATION, o61.TARGET_ANNOTATION, o61.RETENTION_ANNOTATION, o61.DOCUMENTED_ANNOTATION);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (hp0 hp0Var : j) {
            linkedHashSet.add(hj.m(hp0Var));
        }
        a = linkedHashSet;
    }

    private ze2() {
    }

    @NotNull
    public final Set<hj> a() {
        return a;
    }
}
