package tb;

import com.alibaba.gaiax.template.GXIExpression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class vq0 {
    @NotNull
    private final GXIExpression a;

    public vq0(@NotNull GXIExpression gXIExpression) {
        b41.i(gXIExpression, "event");
        this.a = gXIExpression;
    }

    @NotNull
    public final GXIExpression a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof vq0) && b41.d(this.a, ((vq0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return "GXEventBinding(event=" + this.a + ')';
    }
}
