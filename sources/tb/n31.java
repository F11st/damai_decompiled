package tb;

import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class n31 extends l31 implements ClosedRange<Integer> {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final n31 d = new n31(1, 0);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final n31 a() {
            return n31.d;
        }
    }

    public n31(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Integer num) {
        return f(num.intValue());
    }

    @Override // tb.l31
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof n31) {
            if (!isEmpty() || !((n31) obj).isEmpty()) {
                n31 n31Var = (n31) obj;
                if (a() != n31Var.a() || b() != n31Var.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i) {
        return a() <= i && i <= b();
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: g */
    public Integer getEndInclusive() {
        return Integer.valueOf(b());
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: h */
    public Integer getStart() {
        return Integer.valueOf(a());
    }

    @Override // tb.l31
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // tb.l31, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // tb.l31
    @NotNull
    public String toString() {
        return a() + ".." + b();
    }
}
