package tb;

import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class b13 {
    @NotNull
    private final WeakReference<ClassLoader> a;
    private final int b;

    public b13(@NotNull ClassLoader classLoader) {
        b41.i(classLoader, "classLoader");
        this.a = new WeakReference<>(classLoader);
        this.b = System.identityHashCode(classLoader);
    }

    public final void a(@Nullable ClassLoader classLoader) {
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof b13) && this.a.get() == ((b13) obj).a.get();
    }

    public int hashCode() {
        return this.b;
    }

    @NotNull
    public String toString() {
        String classLoader;
        ClassLoader classLoader2 = this.a.get();
        return (classLoader2 == null || (classLoader = classLoader2.toString()) == null) ? "<null>" : classLoader;
    }
}
