package tb;

import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ec1 extends cc1 implements ClosedRange<Long> {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    static {
        new ec1(1L, 0L);
    }

    public ec1(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Long l) {
        return d(l.longValue());
    }

    public boolean d(long j) {
        return a() <= j && j <= b();
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: e */
    public Long getEndInclusive() {
        return Long.valueOf(b());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ec1) {
            if (!isEmpty() || !((ec1) obj).isEmpty()) {
                ec1 ec1Var = (ec1) obj;
                if (a() != ec1Var.a() || b() != ec1Var.b()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: f */
    public Long getStart() {
        return Long.valueOf(a());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (a() ^ (a() >>> 32))) + (b() ^ (b() >>> 32)));
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return a() > b();
    }

    @NotNull
    public String toString() {
        return a() + ".." + b();
    }
}
