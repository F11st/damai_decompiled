package tb;

import java.util.List;
import kotlin.collections.C8214m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class eu1 {
    @Nullable
    private final rq2 a;
    @NotNull
    private final List<rq2> b;

    public eu1() {
        this(null, null, 3, null);
    }

    public eu1(@Nullable rq2 rq2Var, @NotNull List<rq2> list) {
        b41.i(list, "parametersInfo");
        this.a = rq2Var;
        this.b = list;
    }

    @NotNull
    public final List<rq2> a() {
        return this.b;
    }

    @Nullable
    public final rq2 b() {
        return this.a;
    }

    public /* synthetic */ eu1(rq2 rq2Var, List list, int i, k50 k50Var) {
        this((i & 1) != 0 ? null : rq2Var, (i & 2) != 0 ? C8214m.g() : list);
    }
}
