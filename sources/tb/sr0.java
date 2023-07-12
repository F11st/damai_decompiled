package tb;

import android.view.View;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class sr0 {
    private static final qr0 a(qr0 qr0Var, qr0 qr0Var2, String str) {
        if (b41.d(qr0Var2.o().i().d(), str)) {
            return qr0Var2;
        }
        List<qr0> d = qr0Var2.d();
        if (d == null) {
            return null;
        }
        for (qr0 qr0Var3 : d) {
            qr0 a = a(qr0Var, qr0Var3, str);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    private static final View b(qr0 qr0Var, qr0 qr0Var2, String str) {
        if (b41.d(qr0Var2.o().i().d(), str)) {
            return qr0Var2.q();
        }
        List<qr0> d = qr0Var2.d();
        if (d == null) {
            return null;
        }
        for (qr0 qr0Var3 : d) {
            View b = b(qr0Var, qr0Var3, str);
            if (b != null) {
                return b;
            }
        }
        return null;
    }

    @Nullable
    public static final qr0 c(@NotNull qr0 qr0Var, @NotNull String str) {
        b41.i(qr0Var, "<this>");
        b41.i(str, "id");
        return a(qr0Var, qr0Var, str);
    }

    @Nullable
    public static final View d(@NotNull qr0 qr0Var, @NotNull String str) {
        b41.i(qr0Var, "<this>");
        b41.i(str, "id");
        return b(qr0Var, qr0Var, str);
    }
}
