package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class c02 {
    @Nullable
    public static final Class<?> a(@NotNull ClassLoader classLoader, @NotNull String str) {
        b41.i(classLoader, "<this>");
        b41.i(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
