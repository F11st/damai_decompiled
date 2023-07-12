package tb;

import java.util.Map;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class qj0 extends jg0 {
    @Nullable
    private final Map<String, Object> b;
    @NotNull
    private final String c;

    @JvmOverloads
    public qj0() {
        this(null, null, 3, null);
    }

    public /* synthetic */ qj0(Map map, String str, int i, k50 k50Var) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? "result" : str);
    }

    @Override // tb.jg0
    @Nullable
    public Map<String, Object> a() {
        return this.b;
    }

    @NotNull
    public String b() {
        return this.c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public qj0(@Nullable Map<String, ? extends Object> map, @NotNull String str) {
        super(map, str, null);
        b41.i(str, "type");
        this.b = map;
        this.c = str;
    }
}
