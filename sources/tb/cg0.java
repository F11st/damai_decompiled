package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class cg0 {
    public static final boolean a(@NotNull Throwable th) {
        b41.i(th, "<this>");
        Class<?> cls = th.getClass();
        while (!b41.d(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final RuntimeException b(@NotNull Throwable th) {
        b41.i(th, "e");
        throw th;
    }
}
