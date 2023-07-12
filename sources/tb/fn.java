package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class fn<T> {
    private final T a;

    public fn(T t) {
        this.a = t;
    }

    @NotNull
    public abstract z71 a(@NotNull ModuleDescriptor moduleDescriptor);

    public T b() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            T b = b();
            fn fnVar = obj instanceof fn ? (fn) obj : null;
            if (!b41.d(b, fnVar != null ? fnVar.b() : null)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        T b = b();
        if (b == null) {
            return 0;
        }
        return b.hashCode();
    }

    @NotNull
    public String toString() {
        return String.valueOf(b());
    }
}
