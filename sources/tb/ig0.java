package tb;

import java.util.Set;
import kotlin.collections.C8203e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ig0 {
    @NotNull
    public static final ig0 INSTANCE = new ig0();
    @NotNull
    private static final Set<hp0> a;

    static {
        Set<hp0> g;
        g = C8203e0.g(new hp0("kotlin.internal.NoInfer"), new hp0("kotlin.internal.Exact"));
        a = g;
    }

    private ig0() {
    }

    @NotNull
    public final Set<hp0> a() {
        return a;
    }
}
