package tb;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class kc1<V> {
    @Nullable
    private final V a;
    @Nullable
    private final Throwable b;

    public kc1(V v) {
        this.a = v;
        this.b = null;
    }

    @Nullable
    public Throwable a() {
        return this.b;
    }

    @Nullable
    public V b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kc1) {
            kc1 kc1Var = (kc1) obj;
            if (b() == null || !b().equals(kc1Var.b())) {
                if (a() == null || kc1Var.a() == null) {
                    return false;
                }
                return a().toString().equals(a().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public kc1(Throwable th) {
        this.b = th;
        this.a = null;
    }
}
