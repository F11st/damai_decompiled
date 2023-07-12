package tb;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class c81 {
    @NotNull
    private static final zg1<sz1<b81>> a = new zg1<>("KotlinTypeRefiner");

    @NotNull
    public static final zg1<sz1<b81>> a() {
        return a;
    }

    @NotNull
    public static final List<z71> b(@NotNull b81 b81Var, @NotNull Iterable<? extends z71> iterable) {
        int q;
        b41.i(b81Var, "<this>");
        b41.i(iterable, "types");
        q = kotlin.collections.n.q(iterable, 10);
        ArrayList arrayList = new ArrayList(q);
        for (z71 z71Var : iterable) {
            arrayList.add(b81Var.g(z71Var));
        }
        return arrayList;
    }
}
