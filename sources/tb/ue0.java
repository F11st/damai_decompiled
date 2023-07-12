package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ue0<T> {
    private final T a;
    @Nullable
    private final Annotations b;

    public ue0(T t, @Nullable Annotations annotations) {
        this.a = t;
        this.b = annotations;
    }

    public final T a() {
        return this.a;
    }

    @Nullable
    public final Annotations b() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ue0) {
            ue0 ue0Var = (ue0) obj;
            return b41.d(this.a, ue0Var.a) && b41.d(this.b, ue0Var.b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        Annotations annotations = this.b;
        return hashCode + (annotations != null ? annotations.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EnhancementResult(result=" + this.a + ", enhancementAnnotations=" + this.b + ')';
    }
}
