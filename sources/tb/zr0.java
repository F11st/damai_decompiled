package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class zr0 {
    @NotNull
    public static final zr0 INSTANCE = new zr0();
    @Nullable
    private static Boolean a;
    @Nullable
    private static Boolean b;

    private zr0() {
    }

    public final boolean a() {
        if (b == null) {
            b = Boolean.valueOf(b41.d("1", ms0.INSTANCE.a("debug.com.alibaba.gaiax.log", "0")));
        }
        Boolean bool = b;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean b() {
        if (a == null) {
            a = Boolean.valueOf(b41.d("1", ms0.INSTANCE.a("debug.com.alibaba.gaiax.trace", "0")));
        }
        Boolean bool = a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
