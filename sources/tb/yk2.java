package tb;

import android.app.Application;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class yk2 {
    @JvmField
    @Nullable
    public static Application a;
    @Nullable
    private static String c;
    private static boolean d;
    @NotNull
    public static final yk2 INSTANCE = new yk2();
    private static boolean b = true;

    private yk2() {
    }

    public static final boolean a() {
        return b;
    }

    @Nullable
    public static final String b() {
        return c;
    }

    public static final void d(@Nullable String str) {
        c = str;
    }

    public final boolean c() {
        return d;
    }

    public final void e(boolean z) {
        d = z;
    }
}
