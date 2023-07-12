package tb;

import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class bk implements ClosedFloatingPointRange<Float> {
    private final float a;
    private final float b;

    public boolean a(float f) {
        return f >= this.a && f <= this.b;
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: b */
    public Float getEndInclusive() {
        return Float.valueOf(this.b);
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: c */
    public Float getStart() {
        return Float.valueOf(this.a);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).floatValue());
    }

    public boolean d(float f, float f2) {
        return f <= f2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof bk) {
            if (isEmpty() && ((bk) obj).isEmpty()) {
                return true;
            }
            bk bkVar = (bk) obj;
            if (this.a == bkVar.a) {
                if (this.b == bkVar.b) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.a).hashCode() * 31) + Float.valueOf(this.b).hashCode();
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this.a > this.b;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Float f, Float f2) {
        return d(f.floatValue(), f2.floatValue());
    }

    @NotNull
    public String toString() {
        return this.a + ".." + this.b;
    }
}
