package tb;

import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class cc1 implements Iterable<Long>, KMappedMarker {
    @NotNull
    public static final C8998a Companion = new C8998a(null);
    private final long a;
    private final long b;
    private final long c;

    /* compiled from: Taobao */
    /* renamed from: tb.cc1$a */
    /* loaded from: classes3.dex */
    public static final class C8998a {
        private C8998a() {
        }

        public /* synthetic */ C8998a(k50 k50Var) {
            this();
        }
    }

    public cc1(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 != Long.MIN_VALUE) {
            this.a = j;
            this.b = hv1.d(j, j2, j3);
            this.c = j3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: c */
    public bc1 iterator() {
        return new dc1(this.a, this.b, this.c);
    }
}
