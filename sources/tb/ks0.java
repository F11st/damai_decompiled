package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ks0 extends ts0 {
    @Nullable
    private String a;

    public ks0() {
    }

    @Override // tb.ts0
    @Nullable
    public Object a() {
        return this.a;
    }

    @Nullable
    public final String b() {
        return this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ks0(@NotNull String str) {
        this();
        b41.i(str, "value");
        this.a = str;
    }
}
