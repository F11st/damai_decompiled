package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class l23 {
    @NotNull
    public static final l23 INSTANCE = new l23();
    @NotNull
    private static String a = "";

    private l23() {
    }

    @NotNull
    public final String a() {
        return a;
    }

    public final void b(boolean z) {
        i23.INSTANCE.b(z);
    }

    public final void c(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        b41.i(str, "platform");
        b41.i(str2, "module");
        b41.i(str3, "point");
        new h23(str, str2, str3);
    }

    public final void d(@NotNull String str) {
        b41.i(str, "<set-?>");
        a = str;
    }
}
