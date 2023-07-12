package tb;

import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.poplayer.trigger.view.TrackingService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ss0 {
    @NotNull
    private final GXIExpression a;

    public ss0(@NotNull GXIExpression gXIExpression) {
        b41.i(gXIExpression, TrackingService.OPER_TRACK);
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
        return (obj instanceof ss0) && b41.d(this.a, ((ss0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return "GXTrackBinding(track=" + this.a + ')';
    }
}
