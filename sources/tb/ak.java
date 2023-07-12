package tb;

import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class ak implements ClosedFloatingPointRange<Double> {
    private final double a;
    private final double b;

    public boolean a(double d) {
        return d >= this.a && d <= this.b;
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: b */
    public Double getEndInclusive() {
        return Double.valueOf(this.b);
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: c */
    public Double getStart() {
        return Double.valueOf(this.a);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).doubleValue());
    }

    public boolean d(double d, double d2) {
        return d <= d2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ak) {
            if (isEmpty() && ((ak) obj).isEmpty()) {
                return true;
            }
            ak akVar = (ak) obj;
            if (this.a == akVar.a) {
                if (this.b == akVar.b) {
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
        return (Double.valueOf(this.a).hashCode() * 31) + Double.valueOf(this.b).hashCode();
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this.a > this.b;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Double d, Double d2) {
        return d(d.doubleValue(), d2.doubleValue());
    }

    @NotNull
    public String toString() {
        return this.a + ".." + this.b;
    }
}
