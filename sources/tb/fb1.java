package tb;

import android.util.Log;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class fb1 {
    @NotNull
    public static final fb1 INSTANCE = new fb1();
    private static boolean a = true;

    private fb1() {
    }

    @JvmStatic
    public static final void a(@Nullable String str, @Nullable String str2) {
        if (!a || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    @JvmStatic
    public static final void b(@Nullable String str, @Nullable String str2) {
        if (!a || str2 == null) {
            return;
        }
        Log.e(str, str2);
    }

    @JvmStatic
    public static final void c(@Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (a) {
            Log.e(str, str2, th);
        }
    }
}
